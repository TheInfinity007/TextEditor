package Practice;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeSet;

public class demo {

	public static void main(String[] args) {
		
		TreeSet <String> ts = new TreeSet<String>();
		ts.add("Ram");
		ts.add("Chandra");
		System.out.println(ts.add("Paudel"));
		System.out.println(ts.add("Paudel"));
		Boolean b = ts.add("Rasm");
		System.out.println(b);
		System.out.println(ts);
		
		LinkedList<String> dict = new LinkedList<String>();
		dict.add("Sachin");
		dict.add("TEndulkar");
		System.out.println(dict);
		
		for(String str: dict) {
			System.out.print(str + " ");
		}
		
		
		
		
	}

}