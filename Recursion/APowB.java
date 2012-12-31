package com.math;


/*
 * 
 * 
 * lets take example
2^10 --> 2^9 * 2 ^1 --> 2^3 * 2^3 * 2^3 * 2^1
Algo:
1. Find nearest square root of power and remainder.
2. Calculate number ^ square root using multiplication and store it. Here 2^3 using multiplication.
3. Again find stored number ^ square root power. Here 2^3 is 8. So get 8 ^3 using multiplication that is 8 *8 *8.
4. Now multiply result with remainder of power. Here it is 512 * 2^1
 * 
 * 
 */
public class APowB {

	public static void main(String[] args) {

		
	System.out.println(power(10,5));
	}

	static int power(int a, int b) {
		int temp;
		if (b == 1)
			return 1;
		temp = power(a, b / 2);
		if (b % 2 == 0)
			return (temp * temp);
		else
			return (temp * temp * a);
		
		/*
		 * if(b%2==0)
          return(temp*temp);
else {
     if(b > 1) {
          return(temp*temp*a);
     }
     else {
          return ((temp * temp)/a);
     }
}
		 */
	}
	
	
	/*
	 * 
	 * 
 HashMap<Integer, Long> hmap=new HashMap<Integer, Long>();
	 long power(int a, int b) {
		if (b == 0)
			return 1;
		if (b == 1)
			return a;
		if(hmap.containsKey(b))
			return hmap.get(b);
		long p = power(a, b / 2) * power(a, b / 2);
		if (b % 2 == 1)
			 p=p*a;
		hmap.put(b, p);
		return p;
	}
	 * 
	 * 
	 */
}

/*****************************************************

void generateIPUtil( char* str, char* output, int depth, int countDot, int val )
{
        if( !*str )
        {
                output[depth] = '\0';
                if( countDot == 3 && output[depth-1] != '.' )
                        printf( "%s\n", output );
        }
        else
        {
                output[depth] = *str;
                val = val * 10 + *str - '0';
                if( val <= 255 )
                {
                if( countDot < 3)
                {
                        output[depth + 1] = '.';
                        generateIPUtil( str+1, output, depth+2, countDot+1, 0 );
                }
                generateIPUtil( str+1, output, depth+1, countDot, val );
                }
        }
}
 
void generateIP( char* str )
{
        char output[30];
 
        generateIPUtil( str, output, 0, 0, 0 );
}



**********************************************************/