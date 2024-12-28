package Rajesh.projectmanagementsystem.service;

import Rajesh.projectmanagementsystem.model.PlanType;
import Rajesh.projectmanagementsystem.model.Subscription;
import Rajesh.projectmanagementsystem.model.User;

public interface SubscriptionService {
    Subscription createSubscription(User user);

    Subscription getUsersSubscription(Long userId) throws Exception;

    Subscription upgradeSubscription(Long userId, PlanType planType);

    boolean isValid(Subscription subscription);
}
