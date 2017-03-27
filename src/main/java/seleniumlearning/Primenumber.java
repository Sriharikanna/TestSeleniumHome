package seleniumlearning;

public class Primenumber {

	public static void main(String[] args) 
	{

	//loop through the numbers one by one
	     for(int i=30; i <= 45; i++){

	     boolean isPrime = true;

	 //check to see if the number is prime
	     for(int j=2; j < i ; j++){
          if(i % j == 0){
        isPrime = false;
           break;
          }
          }
       // print the number
       if(isPrime)
       System.out.print(i + " ");
		            }
		    }
	
	}

