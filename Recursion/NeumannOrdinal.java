package com.plainRecursion;

public class NeumannOrdinal {


	public static String NeumannOrdinal(int N) {
        if (N == 0) return "{}"; 
        String s = "";
        for (int i = 0; i < N - 1; i++)
            s += NeumannOrdinal(i) + ", ";
        return "{" + s + NeumannOrdinal(N-1) + "}";
    } 


    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        System.out.println(NeumannOrdinal(N));
    }

}
