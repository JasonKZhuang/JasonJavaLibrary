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
		Test t = new Test();
		t.printText();
	}

	private void printText() {
		String txt = "SELECT " +
			    "p.id            		AS parcel_id, " +
			    "p.external_id          AS external_id, " +
			    "date(p.created_on)     AS created_date, " +
			    "p.retailer_id          AS retailer_id, " +
			    "r.type          		AS retailer_type, " +
			    "r.is_international     AS is_international, "+
			    "rf.type       			AS retailer_type, " +
			    "p.type                 AS parcel_type, " +
			    "p.status               AS parcel_stauts, " +
			    "p.external_reference2  AS hub_code, " +
			    "p.destination_agent_id AS agent_id, " +
			    "po.id                  AS order_id, " +
			    "po.order_type          AS order_type, " +
			    "po.product_type        AS product_type, " +
			    "po.service_type        AS service_type, " +
			    "po.dispatch_type       AS dispatch_type, " +
					"CASE " +
					"	WHEN po.sort_code IS NOT NULL THEN po.sort_code " +
					"	WHEN cv1.id IS NOT NULL AND LEFT(al.postcode, 1) = 2 THEN 'PP-SYD' " +
					"	WHEN cv1.id IS NOT NULL AND LEFT(al.postcode, 1) = 3 THEN 'PP-MEL' " +
					"	ELSE 'PP-OTHER' " +
					"END                	AS sort_code " +
		"FROM parcel p " +
			    "LEFT JOIN order_parcel_map opm ON opm.parcel_id = p.id " +
			    "LEFT JOIN parcelpoint_order po ON po.id = opm.order_id " +
			    "JOIN retailer r ON r.id = p.retailer_id " +
			 	"JOIN retailer_feature rf ON rf.retailer_id = r.id " +
			    "JOIN agent a ON a.id = p.destination_agent_id " +
		        "JOIN location al ON al.id = a.primary_location_id " +
		        "LEFT JOIN coverage_v1 cv1 ON cv1.postcode = al.postcode AND cv1.suburb = al.city AND cv1.business_delivery = 1 "+
		"WHERE 1=1 " +
			  "AND p.is_test = 0 "+ //not test data
			  "AND p.is_training = 0 "+// not training data
			  "AND p.is_mystery = 0 "+ // not mystery data
			  "AND p.is_unregistered = 0 "+ //not unregistered data
			  //"AND p.is_international = 1 "+ //is international
			  //"AND p.type = 'COLLECT_INITIAL_RETAILER' " + //Pickup Parcel
			  //"AND rf.type = 'INTEGRATED_FREIGHT_CNC' " +//Freight feature
			  "AND p.external_id= :externalId ";
		System.out.println(txt);
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
