package exam.xiecheng180904;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = Integer.parseInt(in.nextLine());
        String date = in.nextLine();
        List<Record> list = new ArrayList<Record> ();
        for(int i = 0; i<count;i++) {
        	String[] inputs = in.nextLine().split(" ");
        	list.add(new Record(inputs[0],inputs[1],inputs[2]));
        }
        
        Set<String> set = new TreeSet<String>();
        for(int i = 0; i<count;i++) {
        	Record record = list.get(i);
        	if(date.compareTo(record.start)>=0 && date.compareTo(record.end) <=0) {
        		set.add(record.no);
        	}
        }
        
        if(set.size()>0) {
	        for(String no : set) {
	        	System.out.println(no);
	        }
        } else {
        	System.out.println("null");
        }
        
    }
}
class Record {
	public String no;
	public String start;
	public String end;
	
	public Record(String no, String start, String end) {
		this.no = no;
		this.start = start;
		this.end = end;
	}
}
