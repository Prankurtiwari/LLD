package problems.rate_limitter;

import problems.rate_limitter.model.User;
import problems.rate_limitter.strategy.RateLimitStrategy;
import problems.rate_limitter.strategy.impl.LeakyBucketRateLimiterStrategy;
import problems.rate_limitter.strategy.impl.TokenBucketRateLimiterStrategy;

public class Main {
    public static void main(String[] args) throws InterruptedException {
// User A with TokenBucket strategy
        RateLimitStrategy tokenStrategy = new TokenBucketRateLimiterStrategy(5, 2);
        User userA = new User("userA", tokenStrategy);

        // User B with LeakyBucket strategy
        RateLimitStrategy leakyStrategy = new LeakyBucketRateLimiterStrategy(5, 1);
        User userB = new User("userB", leakyStrategy);

        // Simulate requests
        for (int i = 0; i < 4000; i++) {
            userA.sendRequest();
            userB.sendRequest();
            Thread.sleep(300); // Delay
        }
    }
}
