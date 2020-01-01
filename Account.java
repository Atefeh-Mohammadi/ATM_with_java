
package Atefeh;

import java.util.Scanner;


public class Account {

    public int id;
    public String name;
    public String lastName;
    public double balance; //mojoodi
    Scanner sc=new Scanner(System.in);
    /*public Account(String name,String lastName,int id) {   
    }
    
    public Account(){
    id = 0;
    name = null;
    lastName = null;
    balance = 0;
    }*/
        
    public Double deposit(double balance){  //amount meghdare voroody ast , deposit variz ast
        System.out.println("Enter ur additional amount :");
        double additionalAmount = sc.nextDouble();
        balance += additionalAmount ;
        return balance;
    }
    
    public Double withdrawal (double balance){ //bardasht az hesab
        System.out.println("Enter ur removal amount :");
        double removalamount = sc.nextDouble();
        if (balance < removalamount ){
            System.out.println("balance is not enough");
        }else{
        balance -= removalamount;
        }
        return balance; 
    }
    

}
