package com.plainRecursion;

import java.util.Scanner;

public class SubSequence {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		String input=sc.next();
		int charCount=sc.nextInt();
	
		
		new SubSequence().printSequence("", input, charCount);
	}
	
	void printSequence(String prefix,String remaining,int count){

			if(count==0){
				
				System.out.println(prefix);
				return;
			}
			if(remaining.length()==0)
				return;
			else{
				
				printSequence(prefix+remaining.charAt(0), remaining.substring(1), count-1);
				printSequence(prefix, remaining.substring(1), count);
			}
		
		
		
	}
	
	
	
	
	
	

}
