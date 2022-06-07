import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections; 
public class main {
	
	
	public static int FCFS(ArrayList<Integer> list,int Start) 
	{
		int sum=0;
		sum+=Math.abs(list.get(0)-Start);
		System.out.println("("+Start+"->"+list.get(0)+")"+" = "+sum);
		
		for(int i = 0 ; i < list.size()-1 ; i++) 
		{
			System.out.println("("+list.get(i)+"->"+list.get(i+1)+")"+" = "+sum);
			sum+=Math.abs(list.get(i)-list.get(i+1));
			
		}
		System.out.println("Total head movement is "+sum +" Cylinders.");
		return sum;
		
		
	}
	

	
	
	public static int SSTF(ArrayList<Integer> list,int Start)
	{
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2= (ArrayList<Integer>) list.clone();
		int sum=0;
		int n = list2.size();
		for(int i = 0 ; i < n ; i++ )
		{
			int value,index=0;
			value =Math.abs(Start-list2.get(index));
			for(int j = 1 ;j < list2.size();j++) {
				if(Math.abs(Start-list2.get(j))<value) {
					value = Start-list2.get(j);
					index = j;
				}

			}
			System.out.println("("+ Start + "->"+list2.get(index)+")"+" = "+Math.abs(list2.get(index)-Start));
            sum += Math.abs(list2.get(index)-Start);
            Start=list2.remove(index);
		}
		System.out.println("Total head movement is "+sum +" Cylinders.");
		return sum;
		
		
	}

	
	public static int RIGHTSCAN(ArrayList<Integer> list,int Start,int diskSize) 
	{
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2= (ArrayList<Integer>) list.clone();
		list2.add(Start);
		list2.add(diskSize);
		Collections.sort(list2);
		int sum=0;
		int index= list2.indexOf(Start);
		//System.out.println(index);
		int n = list2.size();
		for(int i = index; i < n-1 ; i++) 
		{
			
			sum+=Math.abs(list2.get(i)-list2.get(i+1));
			System.out.println("("+list2.get(i)+"->"+list2.get(i+1)+")"+" = "+sum);

			if(i == n-2) {
				sum+=Math.abs(list2.get(i+1)-list2.get(index-1));
				System.out.println("("+list2.get(i+1)+"->"+list2.get(index-1)+")"+" = "+sum);
				for(int j = index-1 ; j>0;j--) 
				{
					sum+=Math.abs(list2.get(j)-list2.get(j-1));
					System.out.println("("+list2.get(j)+"->"+list2.get(j-1)+")"+" = "+sum);	
				}
			}

		}
		

		System.out.println("Total head movement is "+sum +" Cylinders.");
		return sum;
		
	}
	
	
	public static int LEFTSCAN(ArrayList<Integer> list,int Start) 
	{
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2= (ArrayList<Integer>) list.clone();
		list2.add(Start);
		list2.add(0);
		Collections.sort(list2);
		int sum=0;
		int index= list2.indexOf(Start);
		//System.out.println(list);
		int n = list2.size();
		for(int i = index; i > 0 ; i--) 
		{
			
			sum+=Math.abs(list2.get(i)-list2.get(i-1));
			System.out.println("("+list2.get(i)+"->"+list2.get(i-1)+")"+" = "+sum);

			if(i == 1) {
				sum+=Math.abs(list2.get(i-1)-list2.get(index+1));
				System.out.println("("+list2.get(i)+"->"+list2.get(index+1)+")"+" = "+sum);
				for(int j = index+1 ; j<n-1;j++) 
				{
					sum+=Math.abs(list2.get(j)-list2.get(j+1));
					System.out.println("("+list2.get(j)+"->"+list2.get(j+1)+")"+" = "+sum);	
				}
			}

		}
		

		System.out.println("Total head movement is "+sum +" Cylinders.");
		return sum;
		
	}
	
	public static int RIGHTCSCAN(ArrayList<Integer> list,int Start,int diskSize) 
	{
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2= (ArrayList<Integer>) list.clone();
		list2.add(Start);
		list2.add(diskSize);
		list2.add(0);
		Collections.sort(list2);
		int sum=0;
		int index= list2.indexOf(Start);
		//System.out.println(index);
		int n = list2.size();
		for(int i = index; i < n-1 ; i++) 
		{
			
			sum+=Math.abs(list2.get(i)-list2.get(i+1));
			System.out.println("("+list2.get(i)+"->"+list2.get(i+1)+")"+" = "+sum);

			if(i == n-2) {
				sum+=Math.abs(list2.get(i+1)-list2.get(0));
				System.out.println("("+list2.get(i+1)+"->"+list2.get(0)+")"+" = "+sum);
				for(int j = 0 ; j<index-1;j++) 
				{
					sum+=Math.abs(list2.get(j)-list2.get(j+1));
					System.out.println("("+list2.get(j)+"->"+list2.get(j+1)+")"+" = "+sum);	
				}
			}

		}
		

		System.out.println("Total head movement is "+sum +" Cylinders.");
		return sum;
		
	}
	
	
	public static int LEFTCSCAN(ArrayList<Integer> list,int Start,int diskSize) 
	{
		
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2= (ArrayList<Integer>) list.clone();
		list2.add(Start);
		list2.add(diskSize);
		list2.add(0);
		Collections.sort(list2);
		int sum=0;
		int index= list2.indexOf(Start);
		System.out.println(list2);
		int n = list2.size();
		for(int i = index; i > 0 ; i--) 
		{
			
			sum+=Math.abs(list2.get(i)-list2.get(i-1));
			System.out.println("("+list2.get(i)+"->"+list2.get(i-1)+")"+" = "+sum);

			if(i == 1) {
				sum+=Math.abs(list2.get(0)-list2.get(n-1));
				System.out.println("("+list2.get(0)+"->"+list2.get(n-1)+")"+" = "+sum);
				for(int j = n-1 ; j>index+1;j--) 
				{
					sum+=Math.abs(list2.get(j)-list2.get(j-1));
					System.out.println("("+list2.get(j)+"->"+list2.get(j-1)+")"+" = "+sum);	
				}
			}

		}
		

		System.out.println("Total head movement is "+sum +" Cylinders.");
		return sum;
		
	}
	
	
	public static int RIGHTC_LOOK(ArrayList<Integer> list,int Start) 
	{
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2= (ArrayList<Integer>) list.clone();
		list2.add(Start);
		//list2.add(0);
		Collections.sort(list2);
		
		int sum=0;
		int index= list2.indexOf(Start);
		//System.out.println(index);
		int n = list2.size();
		for(int i = index; i < n-1 ; i++) 
		{
			
			sum+=Math.abs(list2.get(i)-list2.get(i+1));
			System.out.println("("+list2.get(i)+"->"+list2.get(i+1)+")"+" = "+sum);

			if(i == n-2) {
				sum+=Math.abs(list2.get(i+1)-list2.get(0));
				System.out.println("("+list2.get(i+1)+"->"+list2.get(0)+")"+" = "+sum);
				for(int j = 0 ; j<index-1;j++) 
				{
					sum+=Math.abs(list2.get(j)-list2.get(j+1));
					System.out.println("("+list2.get(j)+"->"+list2.get(j+1)+")"+" = "+sum);	
				}
			}

		}
		

		System.out.println("Total head movement is "+sum +" Cylinders.");
		return sum;
		
	}

	
	
	public static int LEFTC_LOOK(ArrayList<Integer> list,int Start) 
	{
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2= (ArrayList<Integer>) list.clone();
		list2.add(Start);
		//list2.add(diskSize);
	
		Collections.sort(list2);
		int sum=0;
		int index= list2.indexOf(Start);
		System.out.println(list2);
		int n = list2.size();
		for(int i = index; i > 0 ; i--) 
		{
			
			sum+=Math.abs(list2.get(i)-list2.get(i-1));
			System.out.println("("+list2.get(i)+"->"+list2.get(i-1)+")"+" = "+sum);

			if(i == 1) {
				sum+=Math.abs(list2.get(0)-list2.get(n-1));
				System.out.println("("+list2.get(0)+"->"+list2.get(n-1)+")"+" = "+sum);
				for(int j = n-1 ; j>index+1;j--) 
				{
					sum+=Math.abs(list2.get(j)-list2.get(j-1));
					System.out.println("("+list2.get(j)+"->"+list2.get(j-1)+")"+" = "+sum);	
				}
			}

		}
		

		System.out.println("Total head movement is "+sum +" Cylinders.");
		return sum;
		
	}
	
	
	public static int RIGHTLOOK(ArrayList<Integer> list,int Start) 
	{
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2= (ArrayList<Integer>) list.clone();
		list2.add(Start);
		list2.add(0);
		Collections.sort(list2);
		
		int sum=0;
		int index= list2.indexOf(Start);
		//System.out.println(index);
		int n = list2.size();
		for(int i = index; i < n-1 ; i++) 
		{
			
			sum+=Math.abs(list2.get(i)-list2.get(i+1));
			System.out.println("("+list2.get(i)+"->"+list2.get(i+1)+")"+" = "+sum);

			if(i == n-2) {
				sum+=Math.abs(list2.get(i+1)-list2.get(index-1));
				System.out.println("("+list2.get(i+1)+"->"+list2.get(index-1)+")"+" = "+sum);
				for(int j = index-1 ; j>1;j--) 
				{
					sum+=Math.abs(list2.get(j)-list2.get(j-1));
					System.out.println("("+list2.get(j)+"->"+list2.get(j-1)+")"+" = "+sum);	
				}
			}

		}
		

		System.out.println("Total head movement is "+sum +" Cylinders.");
		return sum;
		
	}
	
	
	public static int LEFTLOOK(ArrayList<Integer> list,int Start) 
	{
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2= (ArrayList<Integer>) list.clone();
		list2.add(Start);
		Collections.sort(list2);
		int sum=0;
		int index= list2.indexOf(Start);
		System.out.println(list2);
		int n = list2.size();
		for(int i = index; i > 0 ; i--) 
		{
			
			sum+=Math.abs(list2.get(i)-list2.get(i-1));
			System.out.println("("+list2.get(i)+"->"+list2.get(i-1)+")"+" = "+sum);

			if(i == 1) {
				sum+=Math.abs(list2.get(0)-list2.get(index+1));
				System.out.println("("+list2.get(0)+"->"+list2.get(index+1)+")"+" = "+sum);
				for(int j = index+1 ; j<n-1;j++) 
				{
					sum+=Math.abs(list2.get(j)-list2.get(j+1));
					System.out.println("("+list2.get(j)+"->"+list2.get(j+1)+")"+" = "+sum);	
				}
			}

		}
		

		System.out.println("Total head movement is "+sum +" Cylinders.");
		return sum;
		
	}
           public static int optimizedAlgorithm(ArrayList<Integer> list){
        	   ArrayList<Integer> list2 = new ArrayList<Integer>();
        	   list2= (ArrayList<Integer>) list.clone();
        	   list2.add(0);
                    Collections.sort(list2);
                    int sum =0;
                    for(int i = 0 ; i < list2.size()-1 ; i++) 
		{
			System.out.println("("+list2.get(i)+"->"+list2.get(i+1)+")"+" = "+sum);
			sum+=Math.abs(list2.get(i)-list2.get(i+1));
			
		}
		System.out.println("Total head movement is "+sum +" Cylinders.");
		return sum;
            }
	

public static void main(String[] args) throws IOException {
	
	System.out.println("Enter the head");
	Scanner sc = new Scanner(System.in);
	int headStart = sc.nextInt();
	
	
    Scanner s = new Scanner(new File("input.txt"));
    ArrayList<Integer> list = new ArrayList<Integer>();
    while (s.hasNext()){
        if(s.hasNextInt()){
            list.add(s.nextInt());
        } else {
            s.next();
        }
    }
    s.close();
    //System.out.println(list);
    
    System.out.println("Enter the disk size");
    int diskSize = sc.nextInt();
    
    System.out.println("Enter the disk direction");
     sc.nextLine();
     String dir = sc.nextLine();
    while(true) 
    {
    	System.out.println("1-FCFS\r\n"
    			+ "2-SSTF\r\n"
    			+ "3-SCAN\r\n"
    			+ "4-C-SCAN\r\n"
    			+ "5-LOOK\r\n"
    			+ "6-C-LOOK\r\n"
                            + "7-Optimized Algorithmr\n"
    			+ "8-Exit");
    	int choice = sc.nextInt();
    	if(choice==1)
    		FCFS(list,headStart);
    	 if(choice==2)
    		 SSTF(list,headStart);
    	 if(choice==3) 
    	 {
    		 if(dir.equals("right"))
    		 	RIGHTSCAN(list,headStart,diskSize-1);
    		 if(dir.equals("left"))
    			 LEFTSCAN(list,headStart);
    	 }
    	 if(choice==4) 
    	 {
    		 if(dir.equals("right"))
    		 	RIGHTCSCAN(list,headStart,diskSize-1);
    		 if(dir.equals("left"))
    		LEFTCSCAN(list,headStart,diskSize-1);
    		 
    			 
    	 }
    	 if(choice==5) 
    	 {
    		 if(dir.equals("right"));
    		 RIGHTLOOK(list,headStart);
    		 if(dir.equals("left"))
    			 LEFTLOOK(list,headStart);
    	 }
    	 if(choice==6) 
    	 {
    		 if(dir.equals("right"));
    		 RIGHTC_LOOK(list,headStart);
    		 if(dir.equals("left"))
    			 LEFTC_LOOK(list,headStart);
    	 }
              if(choice==7) 
    	 {
                 optimizedAlgorithm(list);
    		 
    	 }
    	 if(choice==8)
    		 System.exit(0);
    }
   
   

    

	    }
	   
	   

	    
	}


