import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;
public class Banking {

    Scanner in = new Scanner(System.in);
    bank_sql db = new bank_sql();
    String pass;
    String user;
    String user_in;
    double checking_balance;
    double saving_balance;
    boolean over = false;
    boolean logged_in = false;
    double valid_amt;
    double balance;
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public Banking() {
        db.create_connection();
    }
    public void main_menu() {
        System.out.println("------------------");
        System.out.println("|  Java Banking  |");
        System.out.println("------------------");
        System.out.println("1. Log-in");
        System.out.println("2. Create Account");
        System.out.println("3. Exit");
        user_in = in.nextLine();
        switch (user_in) {
            case "1":
                log_in();
                break;
            case "2":
                create_acc();
                break;
            case "3":
                over = true;
                break;
        }
    }

    public void log_in() {
        while(true) {
            System.out.print("Enter your username: ");
            user = in.next();
            boolean valid = db.exec_cursor("SELECT username FROM accounts WHERE username = '" + user + "';");
            if(valid) {
                System.out.print("Enter your password: ");
                pass = in.next();
                valid = db.exec_cursor("SELECT password FROM accounts WHERE password = '" + pass + "';");
                if(valid)
                    break;
            }
        }
        logged_in = true;
    }

    public void create_acc() {
        System.out.print("Enter a username: ");
        user = in.next();
        System.out.print("Enter a password: ");
        pass = in.next();
        db.add_new_info("INSERT INTO accounts VALUES ('" + user + "', '" + pass +"', 0, 0);");
        System.out.println("Account Created Successfully!");
    }

    public void logged_in_menu() {
        checking_balance = db.get_balance(checking_balance, "checking_balance", user);
        saving_balance = db.get_balance(saving_balance, "saving_balance", user);
        System.out.println("------------------");
        System.out.println("|  Java Banking  |");
        System.out.println("------------------");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Logout");
        user_in = in.next();
        switch (user_in) {
            case "1":
                check_balance();
                break;
            case "2":
                deposit();
                break;
            case "3":
                withdraw();
                break;
            case "4":
                logged_in = false;
                break;
        }
    }

    public void check_balance() {
        System.out.println("Checkings: " + df.format(checking_balance));
        System.out.println("Savings: " + df.format(saving_balance));
        System.out.print("Go back?(Y/N): ");
        user_in = in.next();
        if(user_in.equals("Y") || user_in.equals("y"))
            logged_in_menu();
    }
    public void deposit() {
        System.out.println("Which account would you like to deposit towards(C,S): ");
        user_in = in.next();
        String account = user_in;
        System.out.print("Enter amount to deposit: ");
        user_in = in.next();
        if(account.equals("C") || account.equals("c"))
            db.add_new_info("update accounts set checking_balance = checking_balance + " + Double.valueOf(user_in) + " where username = '" + user + "';");
        else if(account.equals("S") || account.equals("s"))
            db.add_new_info("update accounts set saving_balance = saving_balance + " + user_in + " where username = '" + user + "';");
        System.out.println("Success!");
    }
    public void withdraw() {
        System.out.println("Which account would you like to withdraw from(C,S): ");
        user_in = in.next();
        String account = user_in;
        System.out.print("Enter amount to withdraw: ");
        user_in = in.next();
        while(true) {
            if (account.equals("C") || account.equals("c")) {
                valid_amt = db.get_balance(balance, "checking_balance", user);
                if (valid_amt - Double.parseDouble(user_in) < 0) {
                    System.out.println("Error, cant withdraw more than whats in account");
                    System.out.print("Enter amount to withdraw: ");
                    user_in = in.next();
                }
                db.add_new_info("update accounts set checking_balance = checking_balance - " + user_in + " where username = '" + user + "';");
                break;
            }
            if (account.equals("S") || account.equals("s")) {
                valid_amt = db.get_balance(balance, "saving_balance", user);
                if (valid_amt - Double.parseDouble(user_in) < 0) {
                    System.out.println("Error, cant withdraw more than whats in account");
                    System.out.print("Enter amount to withdraw: ");
                    user_in = in.next();
                }
                db.add_new_info("update accounts set saving_balance = saving_balance - " + user_in + " where username = '" + user + "';");
                break;
            }
        }
        System.out.println("Success!");
    }
    public void Run() {
        while (!over) {
            if (!logged_in) {
                main_menu();
            } else
                logged_in_menu();
            if(over)
                break;
        }
    }
}