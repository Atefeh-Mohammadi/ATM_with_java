
package Atefeh;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Atefeh {

    public static void main(String[] args) {
        Account a=new Account();
        File f=new File("C:\\Users\\SAMSUNG\\Documents\\NetBeansProjects\\Atefeh\\src\\Atefeh\\data.txt");
        Account acc[]=new Account[50];
        int i=-1;
        
            try {
                FileReader fr=new FileReader(f);
                Scanner sf=new Scanner(f);
                while(sf.hasNext()){
                    ++i;
                    acc[i]=new Account();
                    acc[i].id=sf.nextInt();
                    acc[i].name=sf.next();
                    acc[i].lastName=sf.next();
                    acc[i].balance=sf.nextDouble();
                }
            }
            catch(IOException e){
            System.out.println("There's sth wrong");
            }
            
            //----------تا اینجا ارایه ای از آبکجتها درست می شود و اجزای فایل به ترتیب
            //خوانده شده و داخل آرایه ریخته میشود------------
            
        while(true){
            System.out.println("0-exit 1-new account 2-existing account");
            Scanner sc=new Scanner(System.in);
            int first=sc.nextInt();
            switch(first){
                case 0:
                    close(f, i, acc);
                    System.exit(0);
                    break;
                case 1:
                    i++;
                    acc[i]=new Account();
                    System.out.println("Enter ur id :");
                    acc[i].id=sc.nextInt();
                    System.out.println("Enter ur name :");
                    acc[i].name=sc.next();
                    System.out.println("Enter ur last name :");
                    acc[i].lastName=sc.next();
                    System.out.println("Enter ur first balance :");
                    acc[i].balance=sc.nextDouble();
                    break;
                    
                default:
                    System.out.println("Enter your Id :");
                    int ID=sc.nextInt();
                    boolean b = false;
                    for (int m=0;m<=i;m++){
                        if(acc[m].id==ID){
                            b = true;
                            System.out.println("1-exit 2-print 3-search 4-delete 5-deposit 6-withdrawal");
                            int n=sc.nextInt();
                            switch(n){
                                case 1:
                                    close(f, i, acc);
                                    System.exit(0);
                                    break;
                                case 2:
                                    for(int j=0;j<=i;++j){
                                    System.out.println(acc[j].id+"\t"+acc[j].name+"\t"+acc[j].lastName+"\t"+acc[j].balance);}
                                    break;
                                case 3:
                                    System.out.println("1-id-based search  2-name-based search  3-lastname-based search");
                                    int k=sc.nextInt();
                                    switch(k){
                                        case 1:
                                            System.out.println("Type the id :");
                                            int Id=sc.nextInt();
                                            boolean boo = false;
                                            for (int j=0;j<=i;j++){
                                                if(acc[j].id==Id){
                                                    System.out.println(acc[j].name+"\t"+acc[j].lastName+"\t"+acc[j].balance);
                                                    boo = true;
                                                }
                                            }
                                            if (boo==false) {
                                                System.out.println("This id doesn't seem to exist");
                                            }
                                            break; 
                                        case 2:
                                            System.out.println("Type the name :");
                                            String N=sc.next();
                                            boolean bo = false;
                                            for (int j=0;j<=i;j++) {
                                                if (acc[j].name.equalsIgnoreCase(N)) {
                                                    System.out.println(acc[j].id+"\t"+acc[j].lastName+"\t"+acc[j].balance);  
                                                    bo = true; 
                                                }
                                            }
                                            if (bo==false) {
                                                System.out.println("This name doesn't seem to exist");
                                            }
                                            break;
                                        case 3:
                                            System.out.println("Type the lastname :");
                                            String L=sc.next();
                                            boolean bool = false;
                                            for (int j=0;j<=i;j++) {
                                                if (acc[j].lastName.equalsIgnoreCase(L)) {
                                                    System.out.println(acc[j].id+"\t"+acc[j].name+"\t"+acc[j].balance);
                                                    bool = true;
                                                }   
                                            }
                                            if (bool==false) {
                                                System.out.println("This lastname doesn't seem to exist");
                                            }
                                            break;
                                    }
                                    break;
                                case 4:
                                    for (int j=0;j<=i;j++){
                                       if(acc[j].id==ID){
                                            while(j<i){
                                               acc[j].id=acc[j+1].id;
                                               acc[j].name=acc[j+1].name;
                                               acc[j].lastName=acc[j+1].lastName;
                                               acc[j].balance=acc[j+1].balance;
                                               j++;
                                            }   
                                        }
                                    }
                                    i--;
                                    close(f, i, acc);
                                    break;
                                case 5:
                                    acc[m].balance=a.deposit(acc[m].balance);
                                    close(f, i, acc);
                                    break;
                                case 6:
                                    acc[m].balance=a.withdrawal(acc[m].balance);
                                    close(f, i, acc);
                                    break;
                            }
                        }
                                
                    }
                    if (b==false) {System.out.println("This id is invalid");}
            }
        }
    }
     
    
static int close(File f,int i,Account acc[]){
    try{
        FileWriter fw=new FileWriter(f);
        PrintWriter pw=new PrintWriter(fw);
        for(int j=0;j<=i;++j){
            pw.println(acc[j].id+"\t"+acc[j].name+"\t"+acc[j].lastName+"\t"+acc[j].balance);
        }
        pw.flush();
        pw.close();
        fw.close();
    }catch(IOException error){
        System.out.println("There's sth wrong");
    }
    return 0;
    }
}