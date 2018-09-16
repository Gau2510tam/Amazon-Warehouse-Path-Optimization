import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Preprocessing 
{
static HashMap<Integer, ArrayList<Integer>> map ; // Map holding the product numbers and x and y coordinates and scaled coordinates of all products
static int N;
static HashMap<Integer,Integer> productidmap;// Map of Product ID
static final int INF =Integer.MAX_VALUE;
static int start =-1;
static int end = -2;
static List<Integer> startendc ;
static int ans[][];
static String str[];
static List<Integer> orderlist = new ArrayList<Integer>();
//static List<Integer> itemlist = new ArrayList<Integer>();

public static  void main(String[] args)
{
	    map = new HashMap<Integer,ArrayList<Integer>>();
	    productidmap = new HashMap<Integer,Integer>();
	    start =-1;
	    end = -2;
	    startendc = new ArrayList<Integer>();
	    //itemlist = new ArrayList<Integer>();
		String fileToParse = "./warehouse-grid.csv";
	    BufferedReader fileReader = null;

	     //Delimiter used in CSV file
	    final String DELIMITER = ";";
	    try
	    {
	        String line = "";
	        
	        //Create the file reader
	        
	        fileReader = new BufferedReader(new FileReader(fileToParse));
	        
	        //Read the file line by line
	        
	        String final_var= "";
	        
	        while ((line = fileReader.readLine()) != null)
	        {
	        	final_var += line + DELIMITER;
	        	//Get all tokens available in line
	        }
	        
	        //  System.out.println(final_var);
	       
	        String [] arr = final_var.split(";");
	        
	      	/* for(String s:arr)
	        {
	     	   System.out.println(s);
	        }*/
	        
	        for(int i=0;i<arr.length;i++)
	        {
	     	   String [] tmp = arr[i].trim().split(",");
	     	   int x = Integer.parseInt(tmp[0].trim());
	     	   float y = Float.parseFloat(tmp[1].trim());
	     	   float z = Float.parseFloat(tmp[2].trim());
	     	   List<Integer> list= new ArrayList<Integer>();
	     	   list.add((int)y);
	     	   list.add((int)z);
	     	   list.add(2*(int)y);
	     	   list.add(2*(int)z);
	     	   list.add((2*((int)y)-1));
	     	   list.add((int)(z+1));
	     	   map.put(x, (ArrayList<Integer>) list);
	     	//System.out.println(x +";" +  list.get(0) + ";" + list.get(1));   
	        }
		
	    	Scanner sc = new Scanner(System.in);
	    	
		/*    System.out.println("Enter the Order Number from warehouse-orders File");
		    int a;
		    String list= "";
		    while(sc.hasNextInt())
		    {
		       a= sc.nextInt();
		       orderlist.add(a);
		       if(a==-1)
		    	   break;

		    }*/
	    	
		 /*   int weightlimit;
		    System.out.println("Enter the weight limit the worker can push");
		    weightlimit= sc.nextInt();
		    System.out.println("The weight limit is " + weightlimit);
		    int w=0;
		    for(int i=0;i<orderlist.size();i++)
		    {   
		    	if(w<weightlimit)
			    {list = Files.readAllLines(Paths.get("warehouse-orders-v01.csv")).get(orderlist.get(i));
			    
			    itemlist.
			    }
		    }
   */
		    String list= "";
	    	list = Files.readAllLines(Paths.get("warehouse-orders-v02-tabbed.txt")).get(orderlist.get(0));
	        System.out.println(list);
	        str= list.trim().split("\\s++");
	        System.out.println("Total number of items from the order is " + str.length);
	        N=str.length;
	        

	        //System.out.println(N);
	       /* System.out.println("Enter the scaled start point coordinates and scaled end point coordinates");
	        for(int k =0;k<4; k++)
	        {
	          startendc.add(sc.nextInt());
	        }*/
	       // System.out.println(startendc);
	        
	        ans= new int[str.length][str.length];

	        for(int i=0;i<ans.length;i++)
	        { 

	        	productidmap.put(i+1, Integer.parseInt(str[i]));
	        	for(int j=0;j<ans.length;j++)
	        	{
	        		if(i==j)
	        		{
	        			ans[i][j]=INF;
	        		}
	        		else
	        			{
	        			int right = Math.abs((map.get(Integer.parseInt(str[i])).get(2) + 1)-(map.get(Integer.parseInt(str[j])).get(2)+1)) +  Math.abs((map.get(Integer.parseInt(str[i])).get(3))-map.get(Integer.parseInt(str[j])).get(3));
	        			
	        			int left =  Math.abs((map.get(Integer.parseInt(str[i])).get(2) - 1)-(map.get(Integer.parseInt(str[j])).get(2)-1)) +  Math.abs((map.get(Integer.parseInt(str[i])).get(3))-map.get(Integer.parseInt(str[j])).get(3));
	        			
	        			if(right<left)
	        			    ans[i][j] =  right;
	        			
	        			else 
	        				 
	        				ans[i][j] = left;
	        			}
	        		
	        	}
	        }
	        
	       // String[] arr1 = {" "," "};
	        //Weights.main(arr1);
	               
	        
	 
	 sc.close();
 }
	
	
	
	
	
	catch(Exception e)
	    {
		e.printStackTrace();
	    }
	
	
 }
	
}
