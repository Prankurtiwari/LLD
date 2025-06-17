package problems.rate_limitter.strategy.impl;

import problems.rate_limitter.model.TokenBucket;
import problems.rate_limitter.model.User;
import problems.rate_limitter.strategy.RateLimitStrategy;

import java.util.HashMap;
import java.util.Map;

public class TokenBucketRateLimiterStrategy implements RateLimitStrategy {

    private final long capacity;
    private final double refillRate;

    private final static String strategyName = "Token Bucket";
    private final Map<User, TokenBucket> userBuckets = new HashMap<>();

    public TokenBucketRateLimiterStrategy(long capacity, double refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
    }

    public long getCapacity() {
        return capacity;
    }

    public double getRefillRate() {
        return refillRate;
    }

    @Override
    public String getStrategyName() {
        return strategyName;
    }

    @Override
    public boolean allowRequest(User user) {
        TokenBucket bucket = userBuckets.computeIfAbsent(user, u -> new TokenBucket(capacity, refillRate));
        return bucket.tryConsume();
    }
}
