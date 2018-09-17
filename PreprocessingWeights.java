import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class PreprocessingWeights
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
static String str1[];
static List<Integer> orderlist = new ArrayList<Integer>();
static int weightlimit;
static List<String> globallist;
static int w;
static boolean elsecase;
//static List<Integer> itemlist = new ArrayList<Integer>();

public static  void main(String[] args)
{       globallist = new ArrayList<String>();
	    map = new HashMap<Integer,ArrayList<Integer>>();
	    productidmap = new HashMap<Integer,Integer>();
	    start =-1;
	    end = -2;
	    startendc = new ArrayList<Integer>();
	    w=0;
	    Weights.main(args);
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
	    	
		    
		    System.out.println("Enter the weight limit the worker can push");
		    weightlimit= sc.nextInt();
		    System.out.println("The weight limit is " + weightlimit);
            weightparsing();
	        while(!elsecase)
	        {
	        	System.out.println("Enter the Order Number from warehouse-orders File");
		        int a;
		    {			       
		       a= sc.nextInt();
		       orderlist.clear();
		       orderlist.add(a);
	           weightparsing();

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
	
static public void weightparsing()
{
    String list= "";
	try {
		list = Files.readAllLines(Paths.get("warehouse-orders-v02-tabbed.txt")).get(orderlist.get(0));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    System.out.println(list);
    str1= list.trim().split("\\s++");
    int s =0, starting=0;
    
    for(int f=0;f<str1.length;f++)
    {
    	System.out.println("The element is " + Integer.parseInt(str1[f]));
    	s= Weights.dimensionsmap.getOrDefault(Integer.parseInt(str1[f]),0);
    	System.out.println("The weight of element is " + s);
       
    	 if(w+s<=weightlimit)
         {
        	 w+=s;
        	 System.out.println("The total weight till now is " + w);
        	 globallist.add(str1[f]);
        	 continue;
         }
         else
         {  
            elsecase=true;
           // int temp = f;
            System.out.println("Order being splitted");
            splitting (starting,f);
            starting = f;
            w=0;
            globallist.clear();
            globallist.add(str1[f]);
        	//System.out.println("Total number of items from the order is " + str.length);
 	       
         }
    }
   if(elsecase)
   {
       splitting (starting,str1.length);
       
   }
   

}

public static void splitting(int starting, int f )
{   
	  //int point = 0;
	 // System.out.println("The value of f is " + f);
	 // System.out.println("The value of starting is " + starting);
 	 // N=f-starting;
      str=new String[globallist.size()];
	  //System.out.println("Size of str is " + str.length);
      //System.out.println("Size of globallist is " + globallist.size());
      for(int k=0;k<globallist.size();k++)
      {    
      	   str[k] = globallist.get(k);
      	
      }
   	  N = str.length;      
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
      if(UserInterface.option)
      {
      	MultipleIterationsW.main(new String[1]);
      }
      else
      {
      	BB2W.main(new String[1]);
      }
}


}
