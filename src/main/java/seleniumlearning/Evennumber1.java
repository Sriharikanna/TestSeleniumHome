package seleniumlearning;

public class Evennumber1 {
	public static void main(String[] args) {
        
        //define limit
        int limit = 200;
       
        System.out.println("Printing Even numbers between 100 and " + limit);
       
        for(int i=100; i <= limit; i++){
               
                // if the number is divisible by 2 then it is even
                if( i % 2 == 0){
                        System.out.print(i + " ");
                }
        }
}
}


