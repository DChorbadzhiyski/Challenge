/**
 *  Java program to find all number in range 1 to 1000
 *  that fit the two conditions below:
 *  1) The sum of all proper divisors excluding the number it-self
 *  is grater that the actual number.
 *  2) The sum of any subset of the proper divisors of a number excluding
 *  the number it-self should not be equal to the actual number.
 *  
 *  Author: Dimitar Chorbadzhiyski
 *  Date: 27th of February 2019
 */
import java.util.ArrayList;
import java.util.Collections;

public class Divisors {
	
	// find all the divisors of the number  
		// excluding the actual number
		static ArrayList<Integer> factors(int n) 
		{ 
		    // ArrayList to store 
		    // the factors 
		    ArrayList<Integer> factors = new ArrayList<Integer>(); 
		    factors.add(1); 
		    
		    // loop until i is either either
		    // less or equal to n
		    for (int i = 2; 
		             i <= Math.sqrt(n); i++) 
		    { 
		  
		        // if the value of  
		        // i is a proper divisor
		    	//add it to the array
		        if (n % i == 0)  
		        { 
		        	factors.add(i); 
		  
		            // check if the proper divisor
		        	// is equal to the number it-self
		            if (n / i != i)  
		            { 
		            	factors.add(n / i); 
		            } 
		        } 
		    } 
		    
		    //return the array list of divisors
		    return factors; 
		} 
		  
		// check if the sum of all divisors 
		// is greater than the actual number
		static boolean checkSumOfDivisors(int n) 
		{ 
		    ArrayList<Integer> d; 
		  
		    int sum = 0; 
		  	     
		    d = factors(n); 
		  
		    // sum all of the divisors 
		    for (int i = 0; i < d.size(); i++)  
		    { 
		        sum += d.get(i); 
		    } 
		  
		    // check if the number 
		    // fits the first condition
		    // (whether or not its value is smaller
		    // that the value of the sum of its divisors)
		    if (sum > n) 
		        return true; 
		    else
		        return false; 
		} 
		  
		// Check if the number fits 
		// the second condition of the task
		static boolean checkSubsets(int n) 
		{ 
		    ArrayList<Integer> d; 
		  
		    d = factors(n); 
		  	     
		    Collections.sort(d); 
		  
		    int r = d.size(); 
		  
		    // check if any subset of the divisors
		    // is equal to the actual number
		    boolean subsetDivisors[][] = new boolean[r + 1][n + 1]; 
		  	    
		    for (int i = 0; i <= r; i++) 
		    	subsetDivisors[i][0] = true; 
		  	    
		    for (int i = 1; i <= n; i++) 
		    	subsetDivisors[0][i] = false; 		  
		    
		    for (int i = 1; i <= r; i++)  
		    { 
		        for (int j = 1; j <= n; j++)  
		        { 
		  
		            // sum each subset of divisors
		            if (j < d.get(i - 1)) 
		            	subsetDivisors[i][j] = subsetDivisors[i - 1][j]; 
		            else { 
		            	subsetDivisors[i][j] = subsetDivisors[i - 1][j] ||  
		            			subsetDivisors[i - 1][j -  
		                                d.get(i - 1)]; 
		            } 
		        } 
		    } 
		  
		    // check if the sum of any subset
		    // of divisors is equal to the number
		    if ((subsetDivisors[r][n]) == false) 
		        return false; 
		    else
		        return true; 
		}  
		static boolean checkNumber(int n) 
		{ 
		    if (checkSumOfDivisors(n) == true &&  
		        checkSubsets(n) == false) 
		        return true; 
		    else
		        return false; 
		} 
		
		public static void main(String args[]) 
		{ 
		    int n = 1000;
		    //loop until i either less or 
		    // equal to 1000
		  for(int i=1;i<=n;i++) {
		    if (checkNumber(i)) 
		        System.out.println("The number that fits both conditions of the task is: " + i);
		  }
		} 

}
