package epicSystems;

import java.util.List;

public class WellOrderdComb {
	
	public static void main(String[] args) {
		//printWellOrdered(0,0,3);
		generatePswd(3,0, 0);
	}
	
	private static void printWellOrdered(int number, int prev, int n) {

		if(n==0){
		System.out.println(number);
		return;
		}

		for(int i=(prev+1); i<10; i++){
		printWellOrdered(number*10 + i, i, n-1) ;
		}

	}
	
	
	/*static void wellFormed(int index, int n)
	{	
		static StringBuffer s=new StringBuffer();
		int i;
		if(n>9)
		{
			System.out.println("Cannot form Well Formed NUmbers with the given size of n");
			return;
		}
		if(s.length()==n)
		{
			System.out.print(s.toString()+"  ");
			return;
		}
		for(i=index;i<10;i++)
		{
			s.append(i);
			wellFormed(i+1,n);
			s.delete(s.length()-1,s.length());
		}
	}
*/
	/*
	public static List<String> Well(int start, int size)
    {
		List<String> output = new List<String>();
        if (size == 1)
            output.Add(start.ToString());
        else
        {
            for (int i = start; i <= 10 - size; i++)
            {
                List<string> temp = Well(i + 1, size - 1);
                foreach (string str in temp)
                {
                    output.Add(i.ToString() + str);
                }
            }
        }
        return output;
    }
	*/
	

	static void generatePswd(int level, int curtDigit, int num)
	{
	    if (level == 0)
	    {
	        
	        System.out.println(num);
	        return ;
	    }



	int newNum = num * 10;
	    for (int ire = curtDigit + 1; ire < 10; ire++)
	    {
	        generatePswd(level - 1, ire, newNum + ire);
	    }
	}


	
}
