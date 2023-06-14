import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) {

        Block[] blockchain = new Block[11];
        Block genesisBlock;
        Block previousBlock;

        try {
            long timestamp = System.currentTimeMillis();
            genesisBlock = new Block(0, "0", timestamp, "Genesis Block",
                    Utils.calculateHash(0, "0", timestamp, "Genesis Block"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        blockchain[0] = genesisBlock;
        previousBlock = genesisBlock;

        for (int i = 1; i < blockchain.length; i++) {
            try {
                long timestamp = System.currentTimeMillis();
                blockchain[i] = new Block(i, previousBlock.getHash(), timestamp, "Block " + i,
                        Utils.calculateHash(i, previousBlock.getHash(), timestamp, "Block " + i));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
            previousBlock = blockchain[i];
            System.out.println("Block " + i + " has been added to the blockchain!");
        }

        System.out.println(Utils.verifyBlockchain(blockchain));
    }
}
