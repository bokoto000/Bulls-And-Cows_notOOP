import java.util.*;
public class bullsNcows {
	
	public static void main(String[] args)
	{
		Vector<Integer> v= new Vector<>();
		int[] num=new int[16];
		for(int i=1;i<=9;i++)
		{
			v.add(i);
		}
		
		int rand=random(0,8);
		num[0]=v.get(rand);
		v.remove(rand);
		v.add(0);
		for(int i=1;i<4;i++)
		{
			rand=random(0,9-i);
			num[i]=v.get(rand);
			v.remove(rand);
		}
		
		System.out.println("@"+num[0]+num[1]+num[2]+num[3]);
		Scanner scan= new Scanner(System.in);

		for(;;)
		{	
			int bulls=0, cows=0;
			String n=scan.nextLine();
			if(n=="I Give Up"){System.out.println("rip");break;}
			char[] c= n.toCharArray();
			boolean tryinput=true;
			if(n.length()>4)tryinput=false;
			for(int i=0;i<4;i++)
			{
				if(!(c[i]>='0'&&c[i]<='9'))
					tryinput=false;
			}
			if(c[0]==c[1]||c[0]==c[2]||c[0]==c[3]||c[1]==c[2]||c[1]==c[3]||c[2]==c[3])tryinput=false;
			if(tryinput==false)System.out.println("Bad Input");
			else
			{
				bulls=countBulls(num,c);
				cows=countCows(num,c);
				System.out.println("Bulls: "+bulls+" Cows: "+cows);
				if(bulls==4) {System.out.println("U win gratz");break;}
			}
		}
		scan.close();
	}
	
	public static int countBulls(int[] comp, char[] player)
	{
		int bulls=0;
		if(comp[0]==player[0]-'0')bulls++;
		if(comp[1]==player[1]-'0')bulls++;
		if(comp[2]==player[2]-'0')bulls++;
		if(comp[3]==player[3]-'0')bulls++;
		return bulls;
	}
	public static int countCows(int[] comp, char[] player)
	{
		int cows=0;
		if(comp[0]==player[1]-'0'||comp[0]==player[2]-'0'||comp[0]==player[3]-'0')cows++;
		if(comp[1]==player[0]-'0'||comp[1]==player[2]-'0'||comp[1]==player[3]-'0')cows++;
		if(comp[2]==player[0]-'0'||comp[2]==player[1]-'0'||comp[2]==player[3]-'0')cows++;
		if(comp[3]==player[0]-'0'||comp[3]==player[1]-'0'||comp[3]==player[2]-'0')cows++;
		return cows;
	}
	public static int random(int min, int max)
	{
	   int range = (max - min) + 1;
	   return (int)(Math.random() * range) + min;
	}
}
