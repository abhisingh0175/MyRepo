package dirtypad;

public class PermutationString {
	public static void main(String[] args) {
		new PermutationString().permutation("abc", "");
	}
	void permutation(String str, String prefix) {
		if (str.length() == 0) {
			System.out.println("Permut->"+prefix);
		} else {
			for (int i = 0; i < str.length(); i++) {
				String rem = str.substring(0, i) + str.substring(i + 1);
				System.out.println("Rem: "+rem+", prefix: "+prefix + str.charAt(i));
				permutation(rem, prefix + str.charAt(i));
				System.out.println("done");
			}
		}
	}
}
