import java.util.*;

class Account {
    String accountNumber;
    String name;
    double balance;
    Scanner sc = new Scanner(System.in);
    
    //create constructor
    Account(){
        System.out.print("Enter Account Number: ");
        accountNumber = sc.next();
        System.out.print("Enter Account Holder Name: ");
        sc.nextLine(); //consume the newline character
        name = sc.nextLine(); 
        System.out.print("Enter Account Balance: ");
        balance = sc.nextDouble();
        System.out.println("Account Created for " + name + " Acc No. is " + accountNumber+"\n");
    } 
     //Deposit method
    public static void Deposit(String a, double damount, Account acnt[])
    {
        for (int i=0; i<acnt.length; i++) {
            if(a.equals( acnt[i].accountNumber)){
               acnt[i].balance += damount;
               System.out.println(damount + " Successfully Deposited"+"\n");
               return;
            }   
        }
         System.out.println("Invalid Account Number Try Again......"+"\n");
    }
    //Account Details search method
    public static void Search(String b, Account acnt[])
    {
      for (int i=0; i<acnt.length; i++){
            if(b.equals(acnt[i].accountNumber)) {
              System.out.println("Account Number: "+ acnt[i].accountNumber);
              System.out.println("Account Name: "+ acnt[i].name);
              System.out.print("Account Balance: "+ acnt[i].balance);
              System.out.println("\n");
              return;
            }
          }
          System.out.println("Invalid Account Number Try Again......"+"\n");
      }
     //withdrow method
    public static void Withdrow(String w, double wamount, Account acnt[])
    {
        for (int i=0; i<acnt.length; i++){
            if(w.equals(acnt[i].accountNumber)) {
               if(acnt[i].balance >= wamount){
               acnt[i].balance -= wamount;
               System.out.println(wamount + " Successfully Withdrow"+"\n");
               }
               else{
                System.out.println("Account balanace is low...: "+acnt[i].balance+"\n");
               }
               return; 
            }
        }
        System.out.println("Invalid Account Number Try Again......"+"\n");
    }
     //Check balance method
    public static void Check(String c,Account acnt [])
    {
      for (int i=0; i<acnt.length; i++){
            if(c.equals(acnt[i].accountNumber)){
              System.out.print("Account Balance : "+ acnt[i].balance+"\n");
              return;
            } 
        }
        System.out.println("Invalid Account Number Try Again......"+"\n");
    }
} 
public class AccountDemo{
        public static void main(String[] args){
        Account[] acnt=null;      //Declare the array of Account datatype
        Scanner sc = new Scanner(System.in);
        int n;
        int choice; 
    do{
        System.out.println("1. Add Account Details");     //Asked to user which transaction want to perform
        System.out.println("2. Deposite");
        System.out.println("3. Withdrow");
        System.out.println("4. Check Account Balance");
        System.out.println("5. Search Account Details");
        System.out.println("6. Exit");

        System.out.print("Enter your choice: ");
        choice = sc.nextInt();
        System.out.println();

        switch(choice){
        case 1:
           System.out.print("How Many Account you want to create: ");
           n = sc.nextInt();
           System.out.println();
           acnt = new Account[n];    //initialize the array
           for(int i=0; i<acnt.length; i++)
           {
            acnt[i] = new Account();   //innitialize the ith position of array
           }
           break;

        case 2:
        System.out.print("Enter Account Number: ");
        String a =sc.next();
        System.out.print("Enter Amount :");
        double damount =sc.nextDouble();
        Account.Deposit(a, damount, acnt);   //call deposit method by class name
        break;

        case 3:
        System.out.print("Enter Account Number: ");
        String w =sc.next();
        System.out.print("Enter Amount :");
        double wamount =sc.nextDouble();
        Account.Withdrow(w, wamount, acnt);    //call withdrow method by class name
        break;

        case 4:
        System.out.print("Enter Account Number: ");
        String c =sc.next();
        Account.Check(c, acnt);               //call CheckBalance method by class name
        break;

        case 5:
        System.out.print("Enter Account Number: ");
        String b =sc.next();
        System.out.println();  //To consume the line
        Account.Search(b, acnt);             //call Search method by class name
        break;

        case 6:
        System.out.println("Exiting program..."+"\n");
        break;

        default:
        System.out.println("Invalid input try again....."+"\n");
       }
     }while(choice!=6);
    sc.close();
  }
}



 