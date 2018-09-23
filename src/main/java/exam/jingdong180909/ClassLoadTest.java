package exam.jingdong180909;

public class ClassLoadTest {
    static {
        System.out.println("Main Static Statement");
    }
    {
        System.out.println("Main Normal Statement");
    }
    public ClassLoadTest() {
        System.out.println("Main Construct Statement");
    }
    public static void main(String[] args) {
        // new Child();
        System.out.println(Child.str);
        new Child();

    }
}
class Base {
//     public static String str = "Base";
    public static final String str = "Base";
    public Base() {
        System.out.println("Base Construct Statement");
    }

    {
        System.out.println("Base Normal Statement");
    }

    static {
        System.out.println("Base Static Statement");
    }
}
class Child extends Base {
//     public static String str = "Child";
     public static final String str = "Child";
    public Child() {
        System.out.println("Child Construct Statement");
    }

    {
        System.out.println("Child Normal Statement");
    }

    static {
        System.out.println("Child Static Statement");
    }
}

