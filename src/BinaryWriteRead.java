import java.io.*;

public class BinaryWriteRead {

    public static void main(String[] args) throws IOException {
        writeReadByte();
        writeReadBoolean();
        writeReadInteger();
    }

    private static void writeReadByte() throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("byte.data"));
        int writeByte = 15;
        dataOutputStream.writeByte(writeByte);
        System.out.println("write byte: " + writeByte);
        dataOutputStream.close();

        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("byte.data"));
        byte readByte = dataInputStream.readByte();
        System.out.println("read byte: " + readByte);
        dataInputStream.close();
    }

    private static void writeReadBoolean() throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("boolean.data"));
        dataOutputStream.writeBoolean(true);
        System.out.println("write boolean: " + true);
        dataOutputStream.close();

        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("boolean.data"));
        boolean readBoolean = dataInputStream.readBoolean();
        System.out.println("read boolean: " + readBoolean);
        dataInputStream.close();
    }

    private static void writeReadInteger() throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("integer.data"));
        int writeInteger = 45;
        dataOutputStream.writeInt(writeInteger);
        System.out.println("write integer: " + writeInteger);
        dataOutputStream.close();

        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("integer.data"));
        int readInteger = dataInputStream.readInt();
        System.out.println("read integer: " + readInteger);
        dataInputStream.close();
    }
}
