import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;

public class Literals {
	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("John Doe");
		names.add("Jane Smith");

		Map<String, String> phones = new LinkedHashMap<String, String>();
		phones.put("John Doe", "+1 87234598734");
		phones.put("Jane Smith", "+1 85873483738");

		System.out.println(names);
		System.out.println(names.getClass());
		System.out.println(phones);
		System.out.println(phones.getClass());
	}
}
