package problems.rate_limitter.strategy.impl;

import problems.rate_limitter.model.LeakyBucket;
import problems.rate_limitter.model.User;
import problems.rate_limitter.strategy.RateLimitStrategy;

import java.util.*;

public class LeakyBucketRateLimiterStrategy implements RateLimitStrategy {
    private final long capacity;
    private final double leakRate;

    private final static String strategyName = "Leaky Bucket";
    private final Map<User, LeakyBucket> userBuckets = new HashMap<>();

    public LeakyBucketRateLimiterStrategy(long capacity, double leakRate) {
        this.capacity = capacity;
        this.leakRate = leakRate;
    }

    public long getCapacity() {
        return capacity;
    }

    public double getLeakRate() {
        return leakRate;
    }

    public Map<User, LeakyBucket> getUserBuckets() {
        return userBuckets;
    }

    @Override
    public String getStrategyName() {
        return strategyName;
    }

    @Override
    public boolean allowRequest(User user) {
        LeakyBucket bucket = userBuckets.computeIfAbsent(user, u -> new LeakyBucket(capacity, leakRate));
        return bucket.tryConsume();
    }
}
