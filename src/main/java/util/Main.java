package util;


import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Item t1 = new Item(1, 2, 3);
        Item t2 = new Item(1, 2, 3);
        Item t3 = new Item(-1, 2, 3);
        Item t4 = new Item(4, 4, 4);
        System.out.println(t1.equals(t2));

        PriorityQueue<Item> queue = new PriorityQueue<>(10, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o2.compareTo(o1);
            }
        });
        queue.add(t1);
        queue.add(t2);
        queue.add(t3);
        queue.add(t4);

        // 遍历优先级队列
        for (Item temp : queue) {
            System.out.println("temp: " + temp);
        }

        System.out.println();
        System.out.println("peek: " + queue.peek());
        System.out.println();

        // 只删除第一个匹配的元素
//        queue.remove(t1);

        // 删除所有匹配的元素
        Iterator<Item> iterator = queue.iterator();
        while (iterator.hasNext())
            if (iterator.next().equals(t1))
                iterator.remove();

        // 出队
        Item val = null;
        while ((val = queue.poll()) != null) {
            System.out.println(val);
        }

        System.out.println();
        System.out.println("peek: " + queue.peek());

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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Item item = (Item) object;

        if (a != item.a) return false;
        if (b != item.b) return false;
        return c == item.c;
    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + b;
        result = 31 * result + c;
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
