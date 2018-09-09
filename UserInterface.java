import java.util.Scanner;

public class UserInterface {
static boolean option ;
	public static void main(String[] args) 
	{
	
		Scanner sa = new Scanner(System.in);
		Scanner sb = new Scanner(System.in);
		System.out.println("Enter the algorithm to be implemented, 1 for Nearest Neighbor or 2 for Branch and Bound");
		int choice = sa.nextInt();
		if(choice == 1)
		{	System.out.println("Nearest Neighbor Algorithm");

			try
			{  
			System.out.println("Enter 1 if you want to include weight and calculate effort or 2 if no weight and no effort");
			int wchoice = sb.nextInt();
			if(wchoice == 1)
			{		System.out.println("Weights Included");
                    option =true;
				try
				{   
					System.out.println("Enter the Order Number from warehouse-orders File");
			        int a;
			        while(sa.hasNextInt())
			    {			       
			       a= sa.nextInt();
			       PreprocessingWeights.orderlist.clear();
			       PreprocessingWeights.orderlist.add(a);
			       if(a==-1)
			    	   break;
			       System.out.println("The order number is " + a);
			       PreprocessingWeights.main(args);
				   //MultipleIterationsW.main(args);
				   System.out.println();
			    }
			        
			        	
			    
				   
				   
				}
				
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			else if(wchoice == 2)
			{System.out.println("Weights Not Included");
			 option =false;	
			try
				{   
					
				System.out.println("Enter the Order Number from warehouse-orders File");
		        int a;
		        while(sa.hasNextInt())
		       {			       
		         a= sa.nextInt();
			     Preprocessing.orderlist.clear();
		         Preprocessing.orderlist.add(a);
		         if(a==-1)
		    	   break;
		         System.out.println("The order number is " + a);
		         Preprocessing.main(args);
			     MultipleIterations.main(args);
			     System.out.println();
		    }
		        
					
					
					

				}
				
				catch(Exception e)
				{
					e.printStackTrace();
				}	
			} 
			
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		else if(choice == 2)
		{ System.out.println("Branch and Bound Algorithm");
			try
			{
				System.out.println("Enter 1 if you want to include weight and calculate effort or 2 if no weight and no effort");
				int wchoice = sb.nextInt();
				if(wchoice == 1)
				{		System.out.println("Weights Included");
                        option =false;

					try
					{   System.out.println("Enter the Order Number from warehouse-orders File");
			        int a;
			      //  String list= "";
			        while(sa.hasNextInt())
			    {			       
			       a= sa.nextInt();
			       PreprocessingWeights.orderlist.clear();
			       PreprocessingWeights.orderlist.add(a);
			       if(a==-1)
			    	   break;
			       System.out.println("The order number is " + a);
			       PreprocessingWeights.main(args);
				   //BB2W.main(args);
				   System.out.println();
			    }
						
						
						
					}
					
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				else if(wchoice == 2)
				{System.out.println("Weights Not Included");
					try
					{  System.out.println("Enter the Order Number from warehouse-orders File");
			        int a;
			        String list= "";
			        while(sa.hasNextInt())
			    {			       
			       a= sa.nextInt();
			       Preprocessing.orderlist.clear();
			       Preprocessing.orderlist.add(a);
			       if(a==-1)
			    	   break;
			       System.out.println("The order number is " + a);
			       Preprocessing.main(args);
				   BB2.main(args);
				   System.out.println();
			    }
					}
					
					catch(Exception e)
					{
						e.printStackTrace();
					}	
				}
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}	
		}
		
		
 }

}
