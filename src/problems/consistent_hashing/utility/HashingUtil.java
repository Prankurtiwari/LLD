package problems.consistent_hashing.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static problems.consistent_hashing.constant.Constant.HASH_ALGO;

public class HashingUtil {
    public static long hash(String key) {
        try {
            MessageDigest md = MessageDigest.getInstance(HASH_ALGO);
            md.update(key.getBytes());
            byte[] digest = md.digest();
            return ((long) (digest[0] & 0xFF) << 24) |
                    ((long) (digest[1] & 0xFF) << 16) |
                    ((long) (digest[2] & 0xFF) << 8) |
                    ((long) (digest[3] & 0xFF));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException( HASH_ALGO + " algorithm not found", e);
        }
    }
}
