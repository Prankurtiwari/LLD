package problems.consistent_hashing;

import problems.consistent_hashing.repository.ServerRepo;

import java.util.*;

public class ConsistentHashingDemo {
    public static void main(String[] args) {

        List<String> servers = Arrays.asList("S0", "S1", "S2", "S3", "S4", "S5");
        int numberOfVirtualNode = 90;
        ServerRepo serverRepo = ServerRepo.getInstance(servers, numberOfVirtualNode);


        // Step 2: Assign requests (keys) to servers
        System.out.println("UserA is assigned to: " + serverRepo.getServer("UserA"));
        System.out.println("UserB is assigned to: " + serverRepo.getServer("UserB"));

        // Step 3: Add a new server dynamically
        serverRepo.addServer("S6");
        System.out.println("UserA is now assigned to: " + serverRepo.getServer("UserA"));

        // Step 4: Remove a server dynamically
        serverRepo.removeServer("S6");
        System.out.println("UserB is now assigned to: " + serverRepo.getServer("UserB"));

    }
}
