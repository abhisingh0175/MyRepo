package dirtypad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumCubeTillThousands {

	public static void main(String[] args) {
		int n = 100;
		int count = 0;
		Map<Integer, List<Pair>> pairsMap = new HashMap<>();
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				temp = i ^ 3 + j ^ 3;
				if (pairsMap.containsKey(temp)) {
					for (Pair pair : pairsMap.get(temp)) {
						if (i != pair.x && j != pair.y) {
							count++;
							System.out.println(temp + "->" + i + ":" + j + "  " + pair.x + ":" + pair.y);
						}
					}
					pairsMap.get(temp).add(new Pair(i, j));
				} else {
					List<Pair> list = new ArrayList<>();
					list.add(new Pair(i, j));
					pairsMap.put(temp, list);
				}
			}
		}
		System.out.println(count);
	}

}

class Pair {
	int x;
	int y;

	Pair(int a, int b) {
		x = a;
		y = b;
	}

	/*
	 * @Override public boolean equals(Object obj) { if (!(obj instanceof Pair))
	 * { return false; } Pair pair = (Pair) obj; if (this.x == pair.x && this.y
	 * == pair.y) return true; return false; }
	 */
}
