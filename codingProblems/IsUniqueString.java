package codingProblems;

public class IsUniqueString {

	public static void main(String[] args) {
		
		System.out.println(IsUniqueString.isUnique("+- 6735"));

	}

	public static boolean isUnique(String string) {

		boolean[] bool = new boolean[16*16*16*16];
		for (char c : string.toCharArray()) {
			if (bool[c] == true)
				return false;
			bool[c] = true;
		}
		return true;

	}

}
