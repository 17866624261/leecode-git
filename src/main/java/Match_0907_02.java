import java.math.BigInteger;

public class Match_0907_02 {
    public int Decrypt (int encryptedNumber, int decryption, int number) {
        // write code here
        BigInteger eb = new BigInteger(String.valueOf(encryptedNumber));
        BigInteger bn = new BigInteger(String.valueOf(number));
        return eb.pow(decryption).mod(bn).intValue();
    }
}
