package miscellaneous;

public class SubStringFinder {

	public static void main(String[] args) {
		int [] ab = new SubStringFinder().subStringFounder("asdfasdfasdffasddfasdf", "ddf");
		System.out.println(ab);
		
	}
	
	public int[] subStringFounder(String source, String sub){
		int num=0;
		int[] result = new int[source.length()-sub.length()];
		char[] str = source.toCharArray();
		char[] s = sub.toCharArray();
		int count = 0;
		for (int i = 0; i < str.length-s.length; i++) {
			count = 0;
			for (int j = 0; j < s.length; j++) {
				if (str[j+i] != s[j])
					break;
				else
					count++;
			}
			if (count == sub.length()){
				System.out.println("Found at location : " + i);
				result[num++]=i;
			}				
		}
	
		return result;
	}

}
