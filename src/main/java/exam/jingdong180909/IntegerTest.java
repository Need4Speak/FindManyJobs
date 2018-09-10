package exam.jingdong180909;

public class IntegerTest {

    public static void main(String[] args) {

        Integer integer = 1;
        String str = "a";
        A a = new A();

        System.out.println(integer);
        change(integer);
        System.out.println(integer);

        System.out.println(str);
        change(str);
        System.out.println(str);

        System.out.println(a.integer);
        change(a);
        System.out.println(a.integer);

    }

    public static void change(Integer integer ) {
        integer  = 2;
    }

    public static void change(String str) {
        str = "b";
    }

    public static void change(A a) {
        a.integer = 2;
    }
}

class A {
    public int integer = 1;
}
