package patterns;

public class SingletonDemo {

    public static void main(String[] args) {
        Singleton1 singleton1a = Singleton1.INSTANCE;
        Singleton1 singleton1b = Singleton1.INSTANCE;
        System.out.println("Singleton1: " + (singleton1a == singleton1b));

        Singleton2 singleton2a = Singleton2.getInstance();
        Singleton2 singleton2b = Singleton2.getInstance();
        System.out.println("Singleton2: " + (singleton2a == singleton2b));

        Singleton3 singleton3a = Singleton3.getInstance();
        Singleton3 singleton3b = Singleton3.getInstance();
        System.out.println("Singleton3: " + (singleton3a == singleton3b));

        Singleton4 singleton4a = Singleton4.INSTANCE;
        Singleton4 singleton4b = Singleton4.INSTANCE;
        System.out.println("Singleton4: " + (singleton4a == singleton4b));
    }

}
