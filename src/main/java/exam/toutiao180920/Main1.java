package exam.toutiao180920;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * Created by chao on 2018/9/20.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        if (!path.trim().equals("") && path.length() < 4096) {
            System.out.println(simp(path));
        }
    }

    static String simp(String path) {
        String[] dirs = path.split("/");
        Set<String> set = new HashSet<>();
        set.add("");
        set.add(".");
        set.add("..");
        Stack<String> stack = new Stack<>();

        for (String dir : dirs) {
            if (!set.contains(dir)) {
                stack.push(dir);
            } else if (dir.equals("..") && !stack.isEmpty()) {
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return "/";
        } else {
            StringBuilder builder = new StringBuilder();
            while (!stack.isEmpty()) {
                builder.insert(0, "/").insert(1, stack.pop());
//                builder.append("/").append(stack.pop());
            }
            return builder.toString();
        }
    }
}
