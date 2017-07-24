package patterns;

// Lazy initialized singleton
public class Singleton3 {

    private static Singleton3 INSTANCE;

    private Singleton3() {}

    public static Singleton3 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton3.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton3();
                }
            }
        }
        return INSTANCE;
    }

}
