import java.io.*;

public class ObjectWriteRead {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        writeAssetObjectToFile();
        readAssetObjectFromFile();
    }

    private static void writeAssetObjectToFile() throws IOException {
        Asset asset = new Asset("House", 150000.25);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("asset.data"));
        objectOutputStream.writeObject(asset);
        System.out.println("Write asset: " + asset);
        objectOutputStream.close();
    }

    private static void readAssetObjectFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("asset.data"));
        Asset asset = (Asset) objectInputStream.readObject();
        System.out.println("Read asset: " + asset);
        objectInputStream.close();
    }
}
