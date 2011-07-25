import java.io.*;

public class Execute {
	public static void main(String[] args) {
		System.out.println(execute("git.cmd"));
	}

	public static String execute(String cmdLine) {
		String line;
		String output = "";
		try {
			Process p = Runtime.getRuntime().exec(cmdLine);
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((line = input.readLine()) != null) {
				output += (line + '\n');
			}
			input.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return output;
	}
}
