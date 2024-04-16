import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class MerkleTree {

    public static String calculateMerkleRoot(List<String> transactionHashes) {
        if (transactionHashes.isEmpty()) {
            return ""; // Handle empty transaction list
        }

        List<String> newHashes = transactionHashes;
        while (newHashes.size() > 1) {
            List<String> combinedHashes = new ArrayList<>();
            for (int i = 0; i < newHashes.size() - 1; i += 2) {
                String combinedHash = hash(newHashes.get(i) + newHashes.get(i + 1));
                combinedHashes.add(combinedHash);
            }
            if (newHashes.size() % 2 != 0) {
                combinedHashes.add(newHashes.get(newHashes.size() - 1));
            }
            newHashes = combinedHashes;
        }
        return newHashes.get(0); // The last element is the Merkle root
    }

    private static String hash(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data.getBytes());
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
