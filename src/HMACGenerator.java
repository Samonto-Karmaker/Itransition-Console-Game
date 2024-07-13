import java.security.SecureRandom;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HMACGenerator {

    private static final int KEY_SIZE = 256; // In bits
    private static final String ALGORITHM = "HmacSHA3-256";

    public static String getHMAC(String text) {
        try {
            Mac mac = Mac.getInstance(ALGORITHM);
            mac.init(new SecretKeySpec(generateKey(), ALGORITHM));
            byte[] rawHmac = mac.doFinal(text.getBytes());
            return bytesToHex(rawHmac).toUpperCase();
        } catch (Exception e) {
            System.out.println("Error while generating HMAC");
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static byte[] generateKey() {
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[KEY_SIZE / 8]; // Convert bits to bytes
        random.nextBytes(key);
        return key;
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder(2 * bytes.length);
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
