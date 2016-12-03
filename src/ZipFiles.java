import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

class ZipFiles {

    private static final int KILOBYTE = 1024;
    private static final int MEGABYTE = KILOBYTE * KILOBYTE;
    private static final Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws IOException {
        createEmptyZipFile();
        createZipFileWithTwoEmptyFiles();
        createZipFileWithTwo1MBRandomFiles();
    }

    private static void createEmptyZipFile() throws IOException {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("output1.zip"));
        zipOutputStream.close();
    }

    private static void createZipFileWithTwoEmptyFiles() throws IOException {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("output2.zip"));
        zipOutputStream.putNextEntry(new ZipEntry("file1.txt"));
        zipOutputStream.putNextEntry(new ZipEntry("file2.txt"));
        zipOutputStream.close();
    }

    private static void createZipFileWithTwo1MBRandomFiles() throws IOException {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("output3.zip"));

        byte[] someBytes = new byte[MEGABYTE];

        // create first zip entry
        zipOutputStream.putNextEntry(new ZipEntry("file1.txt"));
        random.nextBytes(someBytes);
        zipOutputStream.write(someBytes);
        zipOutputStream.closeEntry();

        // create second zip entry
        zipOutputStream.putNextEntry(new ZipEntry("file2.txt"));
        random.nextBytes(someBytes);
        zipOutputStream.write(someBytes);
        zipOutputStream.closeEntry();

        zipOutputStream.close();
    }
}