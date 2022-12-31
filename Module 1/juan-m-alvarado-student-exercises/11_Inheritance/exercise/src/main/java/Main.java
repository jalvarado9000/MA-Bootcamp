import com.techelevator.BankAccount;
import com.techelevator.CheckingAccount;
import com.techelevator.SavingsAccount;

import java.util.*;

class Main {
    public static void main(String[] args) {

        int id = 0;
        int choose = 0;
        boolean option = false;
        ArrayList<BankAccount> users = new ArrayList<>();
        option = true;
        Scanner on = new Scanner(System.in);
        do {
                menu();
                choose = on.nextInt();

                if(choose == 1 || choose == 0){
                    System.out.println("Name of the account holder");
                    String name = on.next().toUpperCase();

                    int balance = 0;
                    try{
                        System.out.println("Deposit amount");
                        balance = amount();
                    }catch (InputMismatchException e){
                        System.out.println("The amount was incorrect please try again");
                        continue;
                    }
                    String accoutNumber = String.valueOf(id);
                    BankAccount account = selectOption(choose,name,accoutNumber,balance);
                    id++;
                    users.add(account);
                    System.out.println("The account was created");

                }
                else if(choose == 2){
                    try {
                        System.out.println("Select the id of the account you want to view");
                        int idSelected = on.nextInt();
                        accountType(users.get(idSelected));
                        System.out.print("ACCOUNT HOLDER NAME ");
                        System.out.println(users.get(idSelected).getAccountHolderName());
                        System.out.print("ID NO. ");
                        System.out.println(users.get(idSelected).getAccountNumber());
                        System.out.print("AVAILABLE BALANCE: $");
                        System.out.println(users.get(idSelected).getBalance());
                    }
                    catch (IndexOutOfBoundsException e){
                        System.out.println("The account select does not exist please try again");
                        continue;
                    }

                }
                else if(choose == 3){
                    try {
                        System.out.println("Select the id of the account you want to deposit");
                        int idSelectedForDeposit = on.nextInt();
                        System.out.println("Select the deposit amount");
                        int depositAmount = amount();
                        users.get(idSelectedForDeposit).deposit(depositAmount);
                        System.out.println("Account after deposit");
                        accountType(users.get(idSelectedForDeposit));
                        System.out.print("ACCOUNT HOLDER NAME ");
                        System.out.println(users.get(idSelectedForDeposit).getAccountHolderName());
                        System.out.print("ID NO. ");
                        System.out.println(users.get(idSelectedForDeposit).getAccountNumber());
                        System.out.print("AVAILABLE BALANCE: $");
                        System.out.println(users.get(idSelectedForDeposit).getBalance());
                    }
                    catch (IndexOutOfBoundsException e){
                        System.out.println("The account select does not exist please try again");
                        continue;
                    }
                    catch (InputMismatchException e){
                        System.out.println("The amount was incorrect please try again");
                        continue;
                    }


                }

                else if(choose == 4){
                    try {
                        System.out.println("Select the id of the account you want to withdraw");
                        int idSelectedForWithdraw = on.nextInt();
                        System.out.println("Select the withdraw amount");
                        int withdrawAmount = amount();
                        users.get(idSelectedForWithdraw).withdraw(withdrawAmount);
                        System.out.println("Account after withdraw");
                        accountType(users.get(idSelectedForWithdraw));
                        System.out.print("ACCOUNT HOLDER NAME ");
                        System.out.println(users.get(idSelectedForWithdraw).getAccountHolderName());
                        System.out.print("ID NO. ");
                        System.out.println(users.get(idSelectedForWithdraw).getAccountNumber());
                        System.out.print("AVAILABLE BALANCE: $");
                        System.out.println(users.get(idSelectedForWithdraw).getBalance());



                    }
                    catch (IndexOutOfBoundsException e){
                        System.out.println("The account select does not exist please try again");
                        continue;
                    }
                    catch (InputMismatchException e){
                        System.out.println("The amount was incorrect please try again");
                        continue;
                    }

                }
                else if(choose == 99){
                    System.out.println("This is a developer options to view all account enrolled with the bank");
                    for(BankAccount acc : users) {
                        accountType(acc);

                        System.out.print(" [ID NO. ");
                        System.out.println(acc.getAccountNumber());
                        System.out.print("ACCOUNT HOLDER NAME ");
                        System.out.println(acc.getAccountHolderName());
                        System.out.print("AVAILABLE BALANCE: $");
                        System.out.println(acc.getBalance() + "] \n");

                    }

                }

                else
                    option = false;

                System.out.println();

       } while (option);

    }

    public static int amount() throws InputMismatchException{
        Scanner on = new Scanner(System.in);
        int balance = on.nextInt();
        return balance;
    }

    public static BankAccount selectOption(int choose, String name, String accountNumber, int balance) {

        boolean flag = true;
        BankAccount account;

        switch (choose) {
            case 0: {
                account = new CheckingAccount(name, accountNumber,balance);
            }
            break;
            case 1: {
                account = new SavingsAccount(name, accountNumber,balance);
            }
            break;

            default: {
                account = null;
                //accountType(account);
            }
            break;
        }

        return account;

    }

    public static void menu() {
        System.out.println("Welcome to Bank");
        System.out.println("Press 0 to create a checking account");
        System.out.println("Press 1 to create a savings account");
        System.out.println("Press 2 to view status");
        System.out.println("Press 3 to deposit");
        System.out.println("Press 4 to withdraw");
        System.out.println("Press 5 to Exit");
        System.out.println("Press 99 to view all accounts");


    }

    public static void accountType(BankAccount account) throws RuntimeException {

        if (account instanceof CheckingAccount)
            System.out.println("CHECKING ACCOUNT");


        if (account instanceof SavingsAccount)
            System.out.println("SAVINGS ACCOUNT");

    }



}