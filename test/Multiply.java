
package multiply;

import java.util.Scanner;

public class Multiply {

    
    public static void main(String[] args) {
         int a, b;
         Scanner scan = new Scanner(System.in);
         System.out.println("Please enter a number"); 
         a = scan.nextInt();
         System.out.println("Please enter another number"); 
         b = scan.nextInt();
         System.out.println("The result is: " +multiply(a,b)); 
         
                
    }
    
    public static int multiply(int a, int b){
        int product = a * b;
        return product;
    }
    
}
