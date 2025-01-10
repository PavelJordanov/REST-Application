package com.example.springboot.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot.model.Plan;
import com.example.springboot.model.User;
import com.example.springboot.model.Subscription;
import com.example.springboot.repository.PlanRepository;
import com.example.springboot.repository.SubscriptionRepository;
import com.example.springboot.repository.UserRepository;
import com.example.springboot.service.UserService;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository repository;
    @Autowired
    PlanRepository planRepository;
    @Autowired
    SubscriptionRepository subscriptionRepository;

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
        String oldStart = existingUser.getStart();
        String newStart = user.getStart();
        String oldEnd = existingUser.getEnd();
        String newEnd = user.getEnd();

        // Handle numclients adjustment when the plan changes
        if (!oldPlanId.equals(newPlanId)) {
            Plan oldPlan = planRepository.findById(oldPlanId);

            // Decrement numclients for the old plan
            if (oldPlanId != null) {
                // Plan oldPlan = planRepository.findById(oldPlanId);
                if (oldPlan != null) {
                    // Create new subscription in the log with info of the old plan
                    Subscription subscription = new Subscription();
                    subscription.setId(UUID.randomUUID().toString());
                    subscription.setPid(oldPlanId);
                    subscription.setUid(existingUser.getId());
                    subscription.setStart(oldStart);
                    subscription.setEnd(oldEnd);
                    subscription.setPrice(oldPlan.getPrice());
                    subscriptionRepository.insert(subscription);

                    oldPlan.removeUser(user.getId());
                    planRepository.update(oldPlan);
                }
            }

            // Increment numclients for the new plan
            if (newPlanId != null) {
                Plan newPlan = planRepository.findById(newPlanId);
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
        }

        return repository.update(user);
    }

}
