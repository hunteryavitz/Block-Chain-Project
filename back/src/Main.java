import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) {

        Block[] blockchain = new Block[10];
        Block genesisBlock;
        Block previousBlock;

        try {
            genesisBlock = new Block(0, "0", System.currentTimeMillis(), "Genesis Block", Utils.calculateHash(0, "0", System.currentTimeMillis(), "Genesis Block"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        blockchain[0] = genesisBlock;
        previousBlock = genesisBlock;

        for (int i = 1; i < blockchain.length; i++) {
            try {
                blockchain[i] = new Block(i, previousBlock.getHash(), System.currentTimeMillis(), "Block " + i, Utils.calculateHash(i, previousBlock.getHash(), System.currentTimeMillis(), "Block " + i));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
            previousBlock = blockchain[i];
            System.out.println("Block " + i + " has been added to the blockchain!");
        }
    }
}