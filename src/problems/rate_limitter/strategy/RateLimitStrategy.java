package problems.rate_limitter.strategy;

import problems.rate_limitter.model.User;

public interface RateLimitStrategy {
    boolean allowRequest(User id);

    String getStrategyName();
}
