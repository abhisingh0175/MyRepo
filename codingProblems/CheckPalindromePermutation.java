package codingProblems;

public class CheckPalindromePermutation {

	public static void main(String[] args) {
//		System.out.println(check("fjasdasd"));
	}

	
	public int hash(int len, int ch){
		return (int)(Math.pow(2, 18)%len)+ch;
	}
	
	public boolean check(String input){
		if(input == null || input.length()<2) return true;
		
		boolean arr[] = new boolean[input.length()];
		
		return true;
	}
	/*public static boolean check(String input) {
		if (input == null || input.length() < 2)
			return true;

		Map<Character, Boolean> map = new HashMap<>();
		for (char c : input.toCharArray()) {
			if (map.get(c) == null) {
				map.put(c, true);
			} else {
				map.put(c, !map.get(c));
			}
		}
		int count = 0;
		for (boolean bool : map.values()) {
			if (bool && count++ > 0)
				return false;
		}

		return true;
		
	}
*/
}
