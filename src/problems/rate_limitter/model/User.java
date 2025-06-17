package problems.rate_limitter.model;

import problems.rate_limitter.strategy.RateLimitStrategy;

public class User {
    private final String userId;
    private final RateLimitStrategy rateLimiter;

    public User(String userId, RateLimitStrategy rateLimiter) {
        this.userId = userId;
        this.rateLimiter = rateLimiter;
    }



    public void sendRequest() {
        if (rateLimiter.allowRequest(this)) {
            System.out.println("Request from " + userId + " allowed with strategy as : " + rateLimiter.getStrategyName());
        } else {
            System.out.println("Request from " + userId + " throttled with strategy as : " + rateLimiter.getStrategyName());
        }
    }
}
