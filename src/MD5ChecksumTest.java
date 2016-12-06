import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * Calculate MD5 checksum
 */
public class MD5ChecksumTest {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        MessageDigest messageDigest = MessageDigest.getInstance("MD5");

        String text = "Close The World, Open The Next";
        System.out.println("text: " + text);
        messageDigest.update(text.getBytes());

        StringBuilder md5sum = new StringBuilder();
        for (byte b : messageDigest.digest()) {
            md5sum.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }

        System.out.println("MD5: " + md5sum.toString());
    }
}
