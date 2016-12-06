import java.util.zip.CRC32;

/**
 * Calculate CRC32 checksum
 */
public class CRC32ChecksumTest {

    public static void main(String[] args) {

        CRC32 crc32 = new CRC32();

        String text = "Close The World, Open The Next";
        System.out.println("text: " + text);
        crc32.update(text.getBytes());
        System.out.println("CRC32: " + crc32.getValue());
    }
}
