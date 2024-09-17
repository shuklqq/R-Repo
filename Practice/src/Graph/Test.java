import java.util.*;

public class Test {
    public static List<String> processLogs(List<String> logs, int threshold) {
        // Map to store user and their transaction count
        Map<String, Integer> userTransactionCount = new HashMap<>();

        // Process each log entry
        for (String log : logs) {
            String[] parts = log.split(" ");
            String sender = parts[0];
            String recipient = parts[1];
            // No need to store amount as it's not relevant for counting transactions

            // Increase sender's transaction count
            userTransactionCount.put(sender, userTransactionCount.getOrDefault(sender, 0) + 1);

            // If sender and recipient are different, increase recipient's transaction count
            if (!sender.equals(recipient)) {
                userTransactionCount.put(recipient, userTransactionCount.getOrDefault(recipient, 0) + 1);
            }
        }

        // List to store users who meet the threshold condition
        List<String> result = new ArrayList<>();

        // Filter users who have transactions over the threshold
        for (Map.Entry<String, Integer> entry : userTransactionCount.entrySet()) {
            if (entry.getValue() >= threshold) {
                result.add(entry.getKey());
            }
        }

        // Sort the result in ascending numeric order
        result.sort(Comparator.comparingInt(Integer::parseInt));

        return result;
    }

    public static void main(String[] args) {
        // Sample test
        List<String> logs = Arrays.asList(
                "1 2 50",
                "1 3 100",
                "2 3 20",
                "3 4 70",
                "2 2 5"
        );

        int threshold = 2;
        List<String> result = processLogs(logs, threshold);
        System.out.println(result);  // Output: [1, 2, 3]
    }
}
