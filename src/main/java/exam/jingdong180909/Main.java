package exam.jingdong180909;


import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int total = Integer.parseInt(in.nextLine());
        int count = 0;
        PriorityQueue<Item> queue = new PriorityQueue<>(10, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o2.compareTo(o1);
            }
        });

        for (Item item : queue) {
            System.out.println("item: " + item.a + " " + item.b + " " + item.c);
        }
        for (int i = 0; i < total; i++) {
            String[] strArr = in.nextLine().split(" ");
            Item temp = new Item(Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1]), Integer.parseInt(strArr[2]));
            Iterator<Item> itemIterator = queue.iterator();

            boolean flag = false;
            while (itemIterator.hasNext()) {
                Item item = itemIterator.next();
                if (temp.compareTo(item) == 1 || item.compareTo(temp) == 1) {
//                    System.out.println(item.a + " " + item.b + " " + item.c);
                    flag = true;
                    count++;
                    break;
                }
            }
            if (!flag)
                queue.offer(temp);
        }

        System.out.println(count);

    }
}

class Item implements Comparable<Item> {
    public int a;
    public int b;
    public int c;

    public Item(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public int compareTo(Item o) {
        if (a > o.a && b > o.b && c > o.c) {
            return 1;
        } else if (a == o.a && b == o.b && c == o.c) {
            return 0;
        }
        return -1;
    }
}
