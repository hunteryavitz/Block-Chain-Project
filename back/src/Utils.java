import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {

    public static String calculateHash(int index, String previous_hash, long timestamp, String data) throws NoSuchAlgorithmException {

        String value = index + previous_hash + timestamp + data;
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(value.getBytes(StandardCharsets.UTF_8));
        final StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            final String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1)
                hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }

    public static boolean verifyBlockchain(Block[] blockchain) {
        for (int i = 1; i < blockchain.length; i++) {
            Block currentBlock = blockchain[i];
            Block previousBlock = blockchain[i - 1];

            try {
                if (!currentBlock.getHash().equals(
                        calculateHash(currentBlock.getIndex(), currentBlock.getPrevious_hash(),
                                currentBlock.getTimestamp(), currentBlock.getData()))) {
                    System.out.println("Block has a hash mismatch: " + currentBlock.getIndex());
                    return false;
                }
                System.out.println("Block hash matches: " + currentBlock.getIndex());

                if (!currentBlock.getPrevious_hash().equals(previousBlock.getHash())) {
                    System.out.println("Block has a previous hash pointer mismatch: " + currentBlock.getIndex());
                    return false;
                }
                System.out.println("Block previous hash matches: " + currentBlock.getIndex());

            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Blockchain is valid");

        return true;
    }
}
