import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sorting {
	public static void main(String[] args) {
		List<String> people = new ArrayList<String>();
		people.add("John Doe");
		people.add("Jane Smith");

		Collections.sort(people, new Comparator<String>() {
			public int compare(String s1, String s2) {
			   return s1.compareToIgnoreCase(s2);
			}
		});

		System.out.println(people);
	}
}
