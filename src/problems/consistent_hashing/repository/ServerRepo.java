package problems.consistent_hashing.repository;

import problems.consistent_hashing.utility.HashingUtil;

import java.util.*;

import static problems.consistent_hashing.constant.Constant.SEPARATOR;
import static problems.consistent_hashing.utility.HashingUtil.hash;

public class ServerRepo {
    private static volatile ServerRepo serverRepo;
    private final int numReplicas; // Number of virtual nodes per server
    private final TreeMap<Long, String> ring; // Hash ring storing virtual nodes
    private final Set<String> servers; // Set of physical servers
    private ServerRepo(List<String> servers, int numReplicas) {
        this.numReplicas = numReplicas;
        this.ring = new TreeMap<>();
        this.servers = new HashSet<>();

        for(String server: servers) {
            addServer(server);
        }
    }

    public static ServerRepo getInstance(List<String> servers, int numReplicas) {
        if (serverRepo == null) {
            synchronized (ServerRepo.class) {
                if(serverRepo == null) {
                    serverRepo = new ServerRepo(servers, numReplicas);
                }
            }
        }
        return serverRepo;
    }


    public void addServer(String server) {
        for (int i = 0; i < numReplicas; i++) {
            long hash = hash(server + SEPARATOR + i); // Unique hash for each virtual node
            ring.put(hash, server);
        }

    }

    public void removeServer(String server) {
        if (servers.remove(server)) {
            for (int i = 0; i < numReplicas; i++) {
                long hash = hash(server + SEPARATOR + i);
                ring.remove(hash);
            }
        }
    }

    public String getServer(String key) {
        if (ring.isEmpty()) {
            return null; // No servers available
        }

        long hash = hash(key);
        // Find the closest server in a clockwise direction
        Map.Entry<Long, String> entry = ring.ceilingEntry(hash);
        if (entry == null) {
            // If we exceed the highest node, wrap around to the first node
            entry = ring.firstEntry();
        }
        return entry.getValue();
    }
}
