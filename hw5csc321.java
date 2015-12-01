package hw5321;
import java.util.Scanner;
import java.lang.Math;
import java.lang.System;
import java.util.Random;
import java.util.*;
public class hw5csc321 {
	
//ERIK BARNS
//HOMEWORK 5 CSC 321
//ALL CODE IS INCORPORATED IN THIS FILE.
//EACH PROBLEM IS NUMBERED AND LABELED BY ITS TYPE OF SORT
//I IMPLEMENTED FUNCTIONS THAT WILL GENERATE PREDETERMINED TYPES OF LISTS FOR THE PROGRAM
// CAN HANDLE USER INPUT FOR A LIST
//USER WILL CHOOSE AN ALGORITHM TO TEST, BY GIVING THE OPTION OF USER INPUT OR GENERATED TESTS
//BASED ON CHOICE THE PROGRAM WILL DISPLAY RUN TIME IN NANO SECONDS FOR EACH ALGORITHM SORT TIME 
//PROGRAM WILL DISPLAY THE SORTED ARRAYS ONCE EVERY TEST HAS FINISHED
//TO STOP THE LOOPED PROMPT USE 9 AS AN INDEX SELECTION.
	
//CREATE LISTS
	//create descending list
	public int[] descList(int n){
		int[] x = new int[n];
		int i;
		for(i=n-1;i >= 0; i--)
			x[i] = i;
		return x;
	}
	//create ascending list
	public int[] ascList(int n){
		int[] x = new int[n];
		int i;
		for(i=0;i < n; i++)
			x[i] = i;
		return x;
	}
	//create list of one number 
	public int[] oneList(int n){
		int[] x = new int[n];
		for(int i=0; i <n;i++)
			x[i] = n;
		return x;
	}
	//randomly generate list
	public int[] randList(int n){
		int[] x = new int[n];
		Random rand = new Random();
		for(int i=0;i<n;i++)
			x[i] = rand.nextInt(n+1);
		return x;
	}
	//user input list
	public int[] userList(Scanner sc){
		//userInput = true;
		System.out.println("Choose an input size: ");
		int size = sc.nextInt();
	    int[] numbers = new int[size];

	    for (int i = 0; i < numbers.length; i++)
	    {
	        System.out.println("Please enter number");
	        numbers[i] = sc.nextInt();
	    }

		return numbers;
	}
	
//BEGINNING OF SORTING METHODS 
	
	//#1 bubble sort
	public int[] bubbleSort(int[] lst){
		int[] bubble = lst;
		int temp;
		//starts at end -- after iteration i = highest val in sublist [0] to [i]
		for(int i=bubble.length-1; i>=0; i--){
			for(int j=1; j<=i;j++){
				//trailing element
				temp = bubble[j-1];
				//if trail is larger, swap values
				if(temp > bubble[j]){
					bubble[j-1] = bubble[j];
					bubble[j] = temp;
				}
			}
		}
		return bubble;
	}
	
	//#2 selection sort
	public int[] selectionSort(int[] lstx){
		int[] lst = lstx;
		int min;
		int temp;
		for(int i=0;i<lst.length-1;i++){
			//min index that isn't sorted
			min = i;
			//finds smallest val and sorts per iteration
			for(int j=i+1; j < lst.length; j++){
				//if element is less than current min index position save position
				if(lst[j] < lst[min])min = j;
				//swap element
				temp = lst[i];
				lst[i] = lst[min];
				lst[min] = temp;
					
				
			}
		}
		return lst;
		
	}
	
	//#3 insertion sort
	public int[] insertionSort(int[] lst){
		int i,j,temp;
		for(i=1; i<lst.length; i++){
			//current value to be sorted
			temp = lst[i];
			j = i;
			//while current value is less than previous values, move previous values + 1 indecies 
			while(j>0 && lst[j-1]>temp){
				lst[j] = lst[j-1];
				j = j-1;
			}
			//places current value to be sorted into position
			lst[j] = temp;
		}
		return lst;
	}
	
	//#4 shell sort
	public int[] shellSort(int[] lst){
		int i,j,temp, inc;
		inc = 4;
		while(inc > 0){
			//basic shell sort, sorts list based on sublists increment size
			for(i=0; i< lst.length;i++){
				j = i; temp = lst[i];
				while(j>=inc && lst[j-inc] > temp){
					lst[j] = lst[j-inc];
					j = j-inc;
				}
				lst[j] = temp;
			}
			//decrement the increment degree
			if(inc/2 != 0) inc = inc/2;
			//if inc = 2 list is sorted else inc = 1
			else if(inc == 1) inc = 0;
			else{ inc = 1;}
		}
		return lst;
	}
	
	
	//#5 right pivot quick sort
	 public void rightquickSort(int[] lst) {
	        if (lst == null || lst.length == 0) //if empty return
	            return;
	        rightsort(lst, 0, lst.length - 1); //sort 
	    }

	    public void rightsort(int[] lst, int left, int right) {
	        int pivot = lst[right];//set pivot to right most point
	        int i = left;
	        int j = right;
	        while (i <= j) { //create partition -- while pointers don't cross
	            while (lst[i] < pivot) {
	                i++;
	            }
	            while (lst[j] > pivot) {
	                j--;
	            }
	            if (i <= j) {
	    	        int temp=lst[i]; // swap high and low vals
	    	        lst[i]=lst[j];
	    	        lst[j]=temp;
	                i++;
	                j--;
	            }
	        }
	        
	        if(left < j) //sort left 
	            rightsort(lst,left,j);
	        if(i < right)//sort right
	            rightsort(lst,i,right);
	    }
	    
	    //#6  quick sort with right pivot point
	    //   switch to insert sort after cutoff size
		 public void quick_insert_Sort(int[] lst) {
		        if (lst == null || lst.length == 0)
		            return;
		        rightsort(lst, 0, lst.length - 1); //sort list
		    }
			public void insertion_quick_Sort(int[] lst,int start, int end){
				int i,j,temp;
				for(i=start=1; i<end; i++){
					//current value to be sorted
					temp = lst[i];
					j = i;
					//while current value is less than previous values, move previous values + 1 indecies 
					while(j>0 && lst[j-1]>temp){
						lst[j] = lst[j-1];
						j = j-1;
					}
					//places current value to be sorted into position
					lst[j] = temp;
				}
			}
		 public void quickinssort(int[] lst, int left, int right) {
		        int pivot = lst[right];
		        int i = left;
		        int j = right;
		        
		        if(right-left < 10) //set value to switch to insertion sort
		        	insertion_quick_Sort(lst,left,right);
		        while (i <= j) { //find partition -- until pointers cross
		            while (lst[i] < pivot) {
		                i++;
		            }
		            while (lst[j] > pivot) {
		                j--;
		            }
		            if (i <= j) {  //restore pivot
		    	        int temp=lst[i];
		    	        lst[i]=lst[j];
		    	        lst[j]=temp;
		                i++;
		                j--;
		            }
		        }
		        
		        if(left < j) //sort left side
		            quickinssort(lst,left,j);
		        if(i < right) //sort right side
		            quickinssort(lst,i,right);
		    }
		 //#7 quicksort2 media of 3 pivot point
		public void med3sort(int[] lst){
			med3QuickSort(lst, 0,lst.length-1);
		}
		public int median3(int[] lst, int left, int right) {
			//of left right and middle value. swap middle term to right position
			    int center = (left + right) / 2;
			    if (lst[left] > lst[center]){
			    	swap(lst,left,center);
			    }
			    if (lst[left] > lst[right]){
			    	swap(lst,left,right);
			    }
			    if (lst[center] > lst[right]){
			    	swap(lst,center,right);
			    }
		    	swap(lst,center,right-1);
			  
			    return lst[right - 1]; // return median value
			  }
		
	    public int partition(int[] lst,int left, int right, long pivot)
	       {
	       int leftPtr = left;            
	       int rightPtr = right - 1;

	       while(true)
	          {
	    	   //find larger
	          while( lst[++leftPtr] < pivot );  // find bigger
	           // find smaller                           
	          while( lst[--rightPtr] > pivot ); // find smaller
	          //break if pointers cross 
	          if(leftPtr >= rightPtr)
	             break;            
	          else                         
	             swap(lst,leftPtr, rightPtr);  
	          }
	       swap(lst,leftPtr, right-1);         // restore pivot point
	       return leftPtr;                
	       }  
		  public void med3QuickSort(int[] lst, int left, int right) {
			    int size = right - left + 1;
			    //if less 3 or less use insertion sort
			    if (size <= 3)
			      insertion_quick_Sort(lst,left, right);
			    else
			    {
			      int median = median3(lst,left, right);			//swaps a middle ground value into middle for partition
			      int part = partition(lst,left,right,median);		//get pivot point	     
			      med3QuickSort(lst,left,part-1);					//sort left side
			      med3QuickSort(lst,part + 1, right);				//sort right side
			    }
			  }
//#8 Merge Sort
		  public static void mergeSort(int[] arr, int low, int high){
			  if(low < high){
				  int mid = (int) Math.floor((low+high)/2);
				  mergeSort(arr,low,mid);
				  mergeSort(arr,mid+1,high);
				  merge(arr,low,mid,high);
			  }
		  }
		  
		  public static void merge(int[] arr, int low, int mid, int high){
			  int[] temp = new int[arr.length];
			  for(int t=0; t<= high; t++){
				  temp[t] = arr[t];
			  }
			  
			  int i = low;
			  int k = low;
			  int j = mid + 1;
			  
			  while(i <= mid && j <= high){
				  if(temp[i] <= temp[j]){
					  arr[k] = temp[i];
					  i++;
				  }
				  else{
					  arr[k] = temp[j];
					  j++;
				  }
				  k++;
			  }
			  while(i <= mid){
				  arr[k] = temp[i];
				  i++;
				  k++;
			  }
		  }
		  
//#9 Heap Sort
    private static int N;
    
    public static void heapSort(int arr[])
    {       
        buildHeap(arr);        
        for (int i = N; i > 0; i--)
        {
            swap(arr,0, i); //swap first and last element
            N = N-1;
            heapify(arr, 0); //heapify
        }
    }     
    //build heap
    public static void buildHeap(int arr[])
    {
        N = arr.length-1;
        for (int i = N/2; i >= 0; i--)
            heapify(arr, i);        //calls heapify on left side
    }
    //heapify 
    public static void heapify(int arr[], int i)
    { 
        int left = 2*i ;//left ptr
        int right = 2*i + 1; //right ptr
        int max = i;
        if (left <= N && arr[left] > arr[i]) //find max of heap
            max = left;
        if (right <= N && arr[right] > arr[max])        
            max = right;
 
        if (max != i) //if max is not i swap max-i and heapify
        {
            swap(arr, i, max);
            heapify(arr, max);
        }
    }    

    public static void swap(int arr[], int i, int j)
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp; 
    }    
	
    
	public static void main(String[] args){
		//create hw object and establish list of sorts
		//prompts user for algorithm choice and type of list to test
		hw5csc321 sorts = new hw5csc321();
		String[] algs = new String[] {"Bubblesort","Selectionsort","Insertionsort","Shellsort","Quicksort (Right Pivot)","Quicksort w/ Insertsort (Right Pivot)","Quicksort2 (median of three)","Mergesort","Heapsort"};
		boolean sorter = true;
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		int size =0;
		while(sorter){
			System.out.println("Choose a sorting algorithm by index number: ");
			for(int i=0;i<algs.length;i++)
				System.out.println("["+i+"]"+algs[i]+"");
			System.out.println("[9] Quit");
			System.out.println("Index Choice: ");
			choice = sc.nextInt();
			if(choice == 9)
				break;
			System.out.println("Would you like to enter input for list (y/n)? ");
			String choicestr = sc.next();

			int[] user = null;
			boolean userInput = false;
			if(choicestr.equals("y")){
				user = sorts.userList(sc);
				userInput = true;
			}
			else{
				System.out.println("Don't worry I have some lists for you!");
				System.out.println("Choose an input size: ");
				size = sc.nextInt();
			}
			
			//instantiate  generated lists
			int[] case1 = null, case2 = null, case3 = null, case4 = null;
			int[] usr = null;
			int[] asc = sorts.ascList(size);
			int[] desc = sorts.descList(size);
			int[] one = sorts.oneList(size);
			int[] rand = sorts.randList(size);
			
			long start = System.nanoTime();
			
			//CONTROL FLOW FOR ALGORITHM CHOICE
			if(choice == 0){
				if(userInput){
					start = System.nanoTime();
					usr = sorts.bubbleSort(user);
					System.out.println("User input list: "+ (System.nanoTime() - start)+" nano secs");
				}
				else{	
					start = System.nanoTime();
					case1 = sorts.bubbleSort(desc);
					System.out.println("Descending sorted: "+ (System.nanoTime() - start)+" nano secs");
					start = System.nanoTime();
					case2 = sorts.bubbleSort(asc);
					System.out.println("Ascending sorted: "+ (System.nanoTime() - start)+" nano secs");
					start = System.nanoTime();
					case3 = sorts.bubbleSort(one);
					System.out.println("One number: "+ (System.nanoTime() - start)+ " nano secs");
					start = System.nanoTime();
					case4 = sorts.bubbleSort(rand);
					System.out.println("Random numbers unsorted: "+ (System.nanoTime() - start)+ " nano secs");
				}
			}
			else if (choice == 1){
				if(userInput){
					start = System.nanoTime();
					usr = sorts.selectionSort(user);
					System.out.println("User input list: "+ (System.nanoTime() - start)+" nano secs");
				}
				else{
					start = System.nanoTime();
					case1 = sorts.selectionSort(desc);
					System.out.println("Descending sorted: "+ (System.nanoTime() - start)+" nano secs");
					start = System.nanoTime();
					case2 = sorts.selectionSort(asc);
					System.out.println("Ascending sorted: "+ (System.nanoTime() - start)+" nano secs");
					start = System.nanoTime();
					case3 = sorts.selectionSort(one);
					System.out.println("One number: "+ (System.nanoTime() - start)+ " nano secs");
					start = System.nanoTime();
					case4 = sorts.selectionSort(rand);
					System.out.println("Random numbers unsorted: "+ (System.nanoTime() - start)+ " nano secs");
				}
			}
			else if(choice == 2){
				if(userInput){
					start = System.nanoTime();
					usr = sorts.insertionSort(user);
					System.out.println("User input list: "+ (System.nanoTime() - start)+" nano secs");
				}
				else{
					start = System.nanoTime();
					case1 = sorts.insertionSort(desc);
					System.out.println("Descending sorted: "+ (System.nanoTime() - start)+" nano secs");
					start = System.nanoTime();
					case2 = sorts.insertionSort(asc);
					System.out.println("Ascending sorted: "+ (System.nanoTime() - start)+" nano secs");
					start = System.nanoTime();
					case3 = sorts.insertionSort(one);
					System.out.println("One number: "+ (System.nanoTime() - start)+ " nano secs");
					start = System.nanoTime();
					case4 = sorts.insertionSort(rand);
					System.out.println("Random numbers unsorted: "+ (System.nanoTime() - start)+ " nano secs");
				}
			}
			else if(choice == 3){
				if(userInput){
					start = System.nanoTime();
					usr = sorts.shellSort(user);
					System.out.println("User input list: "+ (System.nanoTime() - start)+" nano secs");
				}
				else{
					start = System.nanoTime();
					case1 = sorts.shellSort(desc);
					System.out.println("Descending sorted: "+ (System.nanoTime() - start)+" nano secs");
					start = System.nanoTime();
					case2 = sorts.shellSort(asc);
					System.out.println("Ascending sorted: "+ (System.nanoTime() - start)+" nano secs");
					start = System.nanoTime();
					case3 = sorts.shellSort(one);
					System.out.println("One number: "+ (System.nanoTime() - start)+ " nano secs");
					start = System.nanoTime();
					case4 = sorts.shellSort(rand);
					System.out.println("Random numbers unsorted: "+ (System.nanoTime() - start)+ " nano secs");
				}
			}
			else if(choice == 4){
				if(userInput){
					start = System.nanoTime();
					sorts.rightquickSort(user);
					usr = user;
					System.out.println("User input list: "+ (System.nanoTime() - start)+" nano secs");
				}
				else{
					start = System.nanoTime();
					sorts.rightquickSort(desc);
					case1 = desc;
					System.out.println("Descending sorted: "+ (System.nanoTime() - start)+" nano secs");
					start = System.nanoTime();
					sorts.rightquickSort(asc);
					case2 = asc;
					System.out.println("Ascending sorted: "+ (System.nanoTime() - start)+" nano secs");
					start = System.nanoTime();
					sorts.rightquickSort(one);
					case3 = one;
					System.out.println("One number: "+ (System.nanoTime() - start)+ " nano secs");
					start = System.nanoTime();
					sorts.rightquickSort(rand);
					case4 = rand;
					System.out.println("Random numbers unsorted: "+ (System.nanoTime() - start)+ " nano secs");
				}
			}
			else if (choice == 5){
				if(userInput){
					start = System.nanoTime();
					sorts.quick_insert_Sort(user);
					usr = user;
					System.out.println("User input list: "+ (System.nanoTime() - start)+" nano secs");
				}
				else{
					start = System.nanoTime();
					sorts.quick_insert_Sort(desc);
					case1 = desc;
					System.out.println("Descending sorted: "+ (System.nanoTime() - start)+" nano secs");
					start = System.nanoTime();
					sorts.quick_insert_Sort(asc);
					case2 = asc;
					System.out.println("Ascending sorted: "+ (System.nanoTime() - start)+" nano secs");
					start = System.nanoTime();
					sorts.quick_insert_Sort(one);
					case3 = one;
					System.out.println("One number: "+ (System.nanoTime() - start)+ " nano secs");
					start = System.nanoTime();
					sorts.quick_insert_Sort(rand);
					case4 = rand;
					System.out.println("Random numbers unsorted: "+ (System.nanoTime() - start)+ " nano secs");
				}
			}
			else if (choice == 6){
				if(userInput){
					start = System.nanoTime();
					sorts.med3sort(user);
					usr = user;
					System.out.println("User input list: "+ (System.nanoTime() - start)+" nano secs");
				}
				else{
					start = System.nanoTime();
					sorts.med3sort(desc);
					case1 = desc;
					System.out.println("Descending sorted: "+ (System.nanoTime() - start)+" nano secs");
					start = System.nanoTime();
					sorts.med3sort(asc);
					case2 = asc;
					System.out.println("Ascending sorted: "+ (System.nanoTime() - start)+" nano secs");
					start = System.nanoTime();
					sorts.med3sort(one);
					case3 = one;
					System.out.println("One number: "+ (System.nanoTime() - start)+ " nano secs");
					start = System.nanoTime();
					sorts.med3sort(rand);
					case4 = rand;
					System.out.println("Random numbers unsorted: "+ (System.nanoTime() - start)+ " nano secs");
				}
			}
			else if (choice == 7){
				if(userInput){
					start = System.nanoTime();
					sorts.mergeSort(user,0,user.length-1);
					usr = user;
					System.out.println("User input list: "+ (System.nanoTime() - start)+" nano secs");
				}
				else{
					start = System.nanoTime();
					sorts.mergeSort(desc,0,desc.length-1);
					case1 = desc;
					System.out.println("Descending sorted: "+ (System.nanoTime() - start)+" nano secs");
					start = System.nanoTime();
					sorts.mergeSort(asc,0,asc.length-1);
					case2 = asc;
					System.out.println("Ascending sorted: "+ (System.nanoTime() - start)+" nano secs");
					start = System.nanoTime();
					sorts.mergeSort(one,0,one.length-1);
					case3 = one;
					System.out.println("One number: "+ (System.nanoTime() - start)+ " nano secs");
					start = System.nanoTime();
					sorts.mergeSort(rand,0,rand.length-1);
					case4 = rand;
					System.out.println("Random numbers unsorted: "+ (System.nanoTime() - start)+ " nano secs");
				}
			}
			else if (choice == 8){
				if(userInput){
					start = System.nanoTime();
					sorts.heapSort(user);
					usr = user;
					System.out.println("User input list: "+ (System.nanoTime() - start)+" nano secs");
				}
				else{
					start = System.nanoTime();
					sorts.heapSort(desc);
					case1 = desc;
					System.out.println("Descending sorted: "+ (System.nanoTime() - start)+" nano secs");
					start = System.nanoTime();
					sorts.heapSort(asc);
					case2 = asc;
					System.out.println("Ascending sorted: "+ (System.nanoTime() - start)+" nano secs");
					start = System.nanoTime();
					sorts.heapSort(one);
					case3 = one;
					System.out.println("One number: "+ (System.nanoTime() - start)+ " nano secs");
					start = System.nanoTime();
					sorts.heapSort(rand);
					case4 = rand;
					System.out.println("Random numbers unsorted: "+ (System.nanoTime() - start)+ " nano secs");
				}
			}
			
			//if user input print our their array else print out predetermined sorted arrays
			if(userInput){
				for(int i=0;i<usr.length;i++)
					System.out.print(" "+usr[i]);
			}
			else{
				for(int i=0;i<case1.length;i++)
					System.out.print(" "+case1[i]);
				System.out.println("");
				for(int i=0;i<case2.length;i++)
					System.out.print(" "+case2[i]);
				System.out.println("");
				for(int i=0;i<case3.length;i++)
					System.out.print(" "+case3[i]);
				System.out.println("");
				for(int i=0;i<case4.length;i++)
					System.out.print(" "+case4[i]);
				System.out.println("");
			}
			System.out.println("\n");
			sorter = true;
		}
		
	}

}
