package problems.rate_limitter.model;

public class LeakyBucket {
    private final long capacity;
    private final double leakRate;
    private double waterLevel;
    private long lastLeakTime;

    public LeakyBucket(long capacity, double leakRate) {
        this.capacity = capacity;
        this.leakRate = leakRate;
        this.waterLevel = 0;
        this.lastLeakTime = System.nanoTime();
    }

    public synchronized boolean tryConsume() {
        leak();
        if (waterLevel < capacity) {
            waterLevel++;
            return true;
        }
        return false;
    }

    private void leak() {
        long now = System.nanoTime();
        double elapsed = (now - lastLeakTime) / 1_000_000_000.0;
        waterLevel = Math.max(0, waterLevel - elapsed * leakRate);
        lastLeakTime = now;
    }
}