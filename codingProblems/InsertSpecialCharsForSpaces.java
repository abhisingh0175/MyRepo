package codingProblems;

public class InsertSpecialCharsForSpaces {

	public static void main(String[] args) {
		String source = "sdfas sdf sdf";
		System.out.println(processSpaces(source));
		System.out.println(processSpaces(""));
		System.out.println(processSpaces(null));
		System.out.println(processSpaces("  "));

	}

	public static String processSpaces(String input) {
		if (input == null || input.equals(""))
			return input;
		char[] arr = input.toCharArray();
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ' ')
				count++;
		}
		char[] output = new char[arr.length + (count * 3)];
		count = 0;
		for (char c : arr) {
			if (c == ' ') {
				output[count++] = '%';
				output[count++] = '2';
				output[count++] = '0';
			} else {
				output[count++] = c;
			}
		}
		return new String(output);
	}

}
