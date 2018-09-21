package interview;

public class Package {
    public static void main(String[] args) {
        Integer i = 127;
        Integer j = 127;
        System.out.println(i == j);
        Object object = new Object();
        String str;
        StringBuilder stringBuilder;
        StringBuffer stringBuffer;

        Integer a = -128;
        Integer b = -128;
        System.out.println(a == b);
    }
}

