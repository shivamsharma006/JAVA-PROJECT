import java.util.*; 
public class atmMachineProject {
    public static void main(String[] args) {
        //u have to be suppose balance firstly of ur Account
        int balance = 100000;
        int withdraw, deposit;
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose 1 for deposit.");
        System.out.println("Choose 2 for withdraw.");
        System.out.println("Choose 3 for check balance.");
        System.out.println("Choose 4 for exit.");
        System.out.println("CHOOSE CORRECT OPTION TO PERFORM:-");
        int choose = sc.nextInt();

        switch(choose){
            case 1:
                  System.out.println("Enter amount u want to deposit:-");
                  deposit = sc.nextInt();
                  balance = balance + deposit;
                  System.out.println("Your updated balance is:-" + balance);
                  System.out.println();
                  break;

            case 2:
                  System.out.println("Enter amount u want to withdraw:-");
                  withdraw = sc.nextInt();
                  if(balance>=withdraw){ 
                     balance = balance-withdraw;
                     System.out.println("Your updated balance is:-" + balance);
                  }
                  else{
                    System.out.println("Insufficient balance...");
                  }
                  break;
            
            case 3:
                System.out.println("Your account balance is:-" + balance);
                System.out.println();
                break;
            
            case 4:
                System.exit(0);
        }
    }
}
