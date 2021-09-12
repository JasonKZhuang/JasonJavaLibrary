import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;

public class Test
{

	interface IFuncInter
	{
		int operation(int a, int b);
	}
	
	private int operate(int a, int b, IFuncInter fobj)
	{
		return fobj.operation(a, b);
	}
	
	public static void main(String[] args) throws IOException
	{

	}

	private void t2() throws IOException
	{
		IFuncInter plus = (int x, int y) -> x + y;
		IFuncInter minus = (int x, int y) -> x - y;
		IFuncInter times = (int x, int y) -> x * y;
		
		
		
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String line;
		int[] arrValue = new int[5];
		HashSet<Integer> nums = new HashSet<Integer>(); 
		 
		while ((line = in.readLine()) != null)
		{
			String[] arr = line.split(" ");
			for (int i = 0; i < arr.length; i++)
			{
				nums.add(Integer.valueOf(arr[i]));
			}
			for(int i = 0;i<arr.length;i++)
			{
				int var1 = (int) nums.toArray()[0];
			}
			int var1 = (int) nums.toArray()[0];
			
			

				
		}
	}
	
	private int pickOne(HashSet<Integer> nums)
	{
		int value = (int) nums.toArray()[0];
		nums.remove(value);
		return value;
	}

	private void t1() throws IOException
	{
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String line;
		String newLine;
		while ((line = in.readLine()) != null)
		{
			newLine = "";
			String[] myArray = line.split("\\|");
			String[] first = myArray[0].trim().split(" ");
			String[] secod = myArray[1].trim().split(" ");

			for (int i = 0; i < first.length; i++)
			{
				int a = Integer.parseInt(first[i]);
				int b = Integer.parseInt(secod[i]);
				newLine = newLine + String.valueOf(a * b) + " ";
			}
			System.out.println(newLine);
		}
	}

}
