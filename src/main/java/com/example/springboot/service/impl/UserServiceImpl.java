package com.example.springboot.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot.model.Plan;
import com.example.springboot.model.User;
import com.example.springboot.model.Subscription;
import com.example.springboot.model.UserBalance;
import com.example.springboot.repository.PlanRepository;
import com.example.springboot.repository.SubscriptionRepository;
import com.example.springboot.repository.UserRepository;
import com.example.springboot.repository.UserBalanceRepository;
import com.example.springboot.service.UserService;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository repository;
    @Autowired
    PlanRepository planRepository;
    @Autowired
    SubscriptionRepository subscriptionRepository;
    @Autowired
    UserBalanceRepository userBalanceRepository;

    public List<User> findAll() {
        System.out.println("HERE2!!!");
        return repository.findAll();
    }
    public User findById(String id) {
        return repository.findById(id);
    }
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public int insert(User user) {
        int result = repository.insert(user);
    
        // Increment numclients for the assigned plan
        if (user.getPlanID() != null) {
            Plan plan = planRepository.findById(user.getPlanID());
            if (plan != null) {
                plan.addUser(user.getId()); // Increment numclients
                planRepository.update(plan); // Save changes to the database

                // Create a subscription log
                Subscription subscription = new Subscription();
                subscription.setId(UUID.randomUUID().toString());
                subscription.setPid(user.getPlanID());
                subscription.setUid(user.getId());
                subscription.setStart(user.getStart());
                subscription.setEnd(user.getEnd());
                subscription.setPrice(plan.getPrice());
                subscriptionRepository.insert(subscription);
                
                UserBalance userBalance = new UserBalance();
                userBalance.setId(UUID.randomUUID().toString());
                userBalance.setUid(user.getId());
                userBalance.setBalance(-(plan.getPrice()));
                userBalanceRepository.insert(userBalance);
            }
        }
    
        return result;
    }

    @Override
    @Transactional
    public int update(User user) {
        User existingUser = repository.findById(user.getId());
        if (existingUser == null) {
            throw new IllegalArgumentException("User not found with ID: " + user.getId());
        }

        String oldPlanId = existingUser.getPlanID();
        String newPlanId = user.getPlanID();
        // String oldStart = existingUser.getStart();
        String newStart = user.getStart();
        // String oldEnd = existingUser.getEnd();
        String newEnd = user.getEnd();

        // Handle numclients adjustment when the plan changes
        Plan oldPlan = planRepository.findById(oldPlanId);
        if (oldPlan != null) {
            if (!oldPlanId.equals(newPlanId)) {
                // Decrement numclients for the old plan
                if (oldPlanId != null) {
                    // Create new subscription in the log with info of the old plan
                    // Subscription subscription = new Subscription();
                    // subscription.setId(UUID.randomUUID().toString());
                    // subscription.setPid(oldPlanId);
                    // subscription.setUid(existingUser.getId());
                    // subscription.setStart(oldStart);
                    // subscription.setEnd(oldEnd);
                    // subscription.setPrice(oldPlan.getPrice());
                    // subscriptionRepository.insert(subscription);

                    oldPlan.removeUser(user.getId());
                    planRepository.update(oldPlan);
                }

                // Increment numclients for the new plan
                Plan newPlan = planRepository.findById(newPlanId);
                if (newPlanId != null) {
                    if (newPlan != null) {
                        // Create new subscription in the log with info of the new plan
                        Subscription subscription = new Subscription();
                        subscription.setId(UUID.randomUUID().toString());
                        subscription.setPid(newPlanId);
                        subscription.setUid(user.getId());
                        subscription.setStart(newStart);
                        subscription.setEnd(newEnd);
                        subscription.setPrice(newPlan.getPrice());
                        subscriptionRepository.insert(subscription);

                        newPlan.addUser(user.getId());
                        planRepository.update(newPlan);
                    }
                }

                // Update the balance of the user after having changed plans
                UserBalance userBalance = userBalanceRepository.findByUid(user.getId());

                int oldBalance = userBalance.getBalance();
                if (oldPlan != null && newPlan != null) {
                    // Check if there is a negative balance meaning the user has not paid for the old plan yet
                    // If there is a negative balance then the balance will be nullified and the new amount
                    // Will be added to the balance of the user for the new plan
                    if (oldBalance < 0) {
                        int nullifyAmount = oldPlan.getPrice();
                        int newBalance = oldBalance + nullifyAmount;
                        newBalance = newBalance - newPlan.getPrice();
                        userBalance.setBalance(newBalance);
                        userBalanceRepository.update(userBalance);
                    }
                    
                    // Check if there is a zero balance meaning the user has paid for the old plan
                    if (oldBalance == 0) {
                        if (oldPlan.getPrice() > newPlan.getPrice()) {
                            int refundAmount = oldPlan.getPrice() - newPlan.getPrice();
                            int newBalance = oldBalance + refundAmount;
                            userBalance.setBalance(newBalance);
                            userBalanceRepository.update(userBalance);
                        } else if (oldPlan.getPrice() < newPlan.getPrice()) {
                            int amountOwed = newPlan.getPrice() - oldPlan.getPrice();
                            int newBalance = oldBalance - amountOwed;
                            userBalance.setBalance(newBalance);
                            userBalanceRepository.update(userBalance);
                        }
                    }
                }
            }
        }
        return repository.update(user);
    }

}
