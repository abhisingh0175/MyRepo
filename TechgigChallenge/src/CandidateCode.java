
public class CandidateCode {
	public static void main(String[] args) {
		String input1[] = "1#1,2#5,3#3,6#3".split(",");
		String input2[] = "2#6#8#6#-7,2#5#-5#-5#0,-1#3#-8#8#7,3#2#0#6#0,2#1#-4#5#8,-5#6#7#4#7".split(",");
		int input3 = 3;
		System.out.println("Expected output is ");
		System.out.println("2#1,2#4,2#3,6#2\n");

		String[] output = CandidateCode.rePostionRats(input1, input2, input3);
		System.out.println("\nFinal output after "+input3+" step(s) is..");
		for(int i=0;i<output.length;i++){
			System.out.print(output[i]+",");	
		}
	}

	public static String[] rePostionRats(String[] input1, String[] input2, int input3) {

		// input array population
		int noOfRats = input1.length;
		int[][] ratArray = new int[noOfRats][2];

		System.out.println("Initial Rat positions...");
		for (int i = 0; i < noOfRats; i++) {
			ratArray[i][0] = Integer.valueOf(input1[i].split("#")[0]);
			ratArray[i][1] = Integer.valueOf(input1[i].split("#")[1]);
			System.out.println(ratArray[i][0] + " " + ratArray[i][1]);
		}
		System.out.println();

		int[][] inputArray = new int[6][5];

		System.out.println("Temprature matrix looks like...");
		for (int i = 0; i < 6; i++) {
			String cols[] = input2[i].split("#");
			for (int j = 0; j < 5; j++) {
				inputArray[i][j] = Integer.valueOf(cols[j]);
				System.out.print(inputArray[i][j] + " ");
			}
			System.out.println();
		}

		String outputString[]=new String[noOfRats];
		// rats movement
		for (int k = 0; k < input3; k++) {
			for (int l = 0; l < noOfRats; l++) {
				int output[] = move(ratArray[l][0]-1, ratArray[l][1]-1, inputArray);
				ratArray[l][0] = output[0]+1;
				ratArray[l][1] = output[1]+1;
			}
		}
		// forming output...
		for (int i = 0; i < noOfRats; i++) {
			outputString[i] = ratArray[i][0] + "#" + ratArray[i][1];
		}
		return outputString;
	}

	public static int[] move(int i, int j, int[][] inputArray) {
		int a, b, c, d;
		int currentTemprature = inputArray[i][j];

		if (i == 0)
			a = Integer.MAX_VALUE;
		else
			a = Math.abs(inputArray[i - 1][j] - currentTemprature);

		if (j == 4)
			b = Integer.MAX_VALUE;
		else
			b = Math.abs(inputArray[i][j + 1] - currentTemprature);

		if (i == 5)
			c = Integer.MAX_VALUE;
		else
			c = Math.abs(inputArray[i + 1][j] - currentTemprature);

		if (j == 0)
			d = Integer.MAX_VALUE;
		else
			d = Math.abs(inputArray[i][j - 1] - currentTemprature);

		int x = less(a, b, c, d);

		if (x == 0) {
			return new int[] { i - 1, j };
		} else if (x == 1) {
			return new int[] { i, j + 1 };
		} else if (x == 2) {
			return new int[] { i + 1, j };
		} else
			return new int[] { i, j - 1 };
	}

	public static int less(int upper, int right, int lower, int left) {
		if (upper <= right && upper <= lower && upper<= lower)
			return 0;
		if (right <= upper && right <= lower && right <= lower)
			return 1;
		if (lower <= upper && lower <= right && lower <= lower)
			return 2;
		else
			return 3;
	}

}