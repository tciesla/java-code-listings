import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystem {

    public static void main(String[] args) throws IOException {

        // create path
        Path path = Paths.get("file.txt");

        // create file
        Files.createFile(path);

        // save data into file
        BufferedWriter writer = Files.newBufferedWriter(path);
        writer.append("1234567890");
        writer.close();

        // load data from file
        BufferedReader reader = Files.newBufferedReader(path);
        System.out.println(reader.readLine());
        reader.close();

        // delete file
        Files.deleteIfExists(path);
    }
}
