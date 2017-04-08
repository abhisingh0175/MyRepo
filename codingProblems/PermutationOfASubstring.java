package codingProblems;

public class PermutationOfASubstring {

	public static void main(String[] args) {
		String string = "acdfhdlcdac";
		String key = "acdg";
		if (string == null || string.equals("") || key == null || key.equals("")) {
			return;
		}
		int stringLen = string.length();
		int keyLen = key.length();
		int count = 0;
		String temp = "";
		char[] str = string.toCharArray();
		int index;
		for (int i = 0; i < stringLen - keyLen + 1; i++) {
			temp = key;
			count = 0;
			while (!temp.equals("")) {
				index = temp.indexOf(str[i]);
				if (index == -1) {
					break;
				} else {
					temp = temp.substring(0, index) + temp.substring(index + 1);
					//temp = temp.substring(0, index == 0 ? 0 : index - 1) + temp.substring(index + 1);
					count++;
					i++;
				}

			}
			i = i - count;
			if (count == keyLen) {
				System.out.println(i);
			}
		}
	}

}
