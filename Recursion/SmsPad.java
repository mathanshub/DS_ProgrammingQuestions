package epicSystems;

import java.util.ArrayList;

public class SmsPad {

	static String[] tele_pad = { "", "", "ABC", "DEF", "GHI", "JKL", "MNO",
			"PQR", "STU", "VWXYZ" };

	public static void main(String[] args) {

		
		int a[]={3,4};
		
		generate(a, 0, "");
		//numbers_letters(324);
	}

	public static void numbers_letters(int num) {
		String numStr = Integer.toString(num);
		parse("", numStr, 0);
	}

	public static void parse(String prefix, String str, int index) {
		if (str.length() - index == 0) {
			System.out.println(prefix);
			return;
		}

		int v = str.charAt(index) - 48;
		int len = tele_pad[v].length();

		if (len == 0)
			parse(prefix, str, index + 1);

		else {
			for (int i = 0; i < len; i++) {
				prefix += tele_pad[v].charAt(i);
				parse(prefix, str, index + 1);
				prefix = prefix.substring(0, prefix.length() - 1);
			}
		}
	}
	
	public static void generate(int[] a,int index,String prefix){
		
		
		if(index==a.length){
			System.out.println(prefix);return;
		}
		
		for(int i=0;i<tele_pad[a[index]].length();i++){
			
			generate(a, index+1, prefix+tele_pad[a[index]].charAt(i));
		}
	}

}

