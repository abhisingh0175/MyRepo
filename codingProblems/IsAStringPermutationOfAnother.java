package codingProblems;

import java.util.HashMap;
import java.util.Map;

public class IsAStringPermutationOfAnother {

	public static void main(String[] args) {
		String s1 = "asfd32asd32v";
		String s2 = "dsf23203dasav";
		System.out.println(isPer(s1, s2));
	}

	public static boolean isPer(String s1, String s2) {
		if (s1 == null || s2 == null || (s1.length() != s2.length()))
			return false;
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s1.toCharArray()) {
			if (map.get(c) == null) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}
		for (char c : s2.toCharArray()) {
			if (map.get(c) == null)
				return false;
			map.put(c, map.get(c) - 1);
		}

		return true;
	}

}
