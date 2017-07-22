package tricky;

class A {
    static String x = "A";
}

class B {
    static String x = "B";
}

class C {
    static String x = "C";

    class D extends B {
        public void printX() {
            System.out.println(x);
        }
    }
}

public class MemberVisibilityTest {

    public static void main(String[] args) {
        new C().new D().printX(); // prints B
    }

}
