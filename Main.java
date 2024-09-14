import java.util.Scanner;
import java.util.Vector;

class User{
    //this class contains all the details of the user
    private String Name;
    //name of the user
    private int AccountNumber;
    //Account Number of the user
    private int  PIN;
    //pin of the account that the user has
    private String  PhoneNumber;
    //phone number of the user
    private String AadhaarNumber;
    //aadhaar number of the user
    private int currentBalance;
    //used in to set balance
    private int AmountTaken;
    //used in withdrawal
    private int AmountDeposited;
    //used in deposit
    private int typeOfMoney;
    //used in deposit
    private int noOfItems;
    //used in deposit
    //As these all are private field getters and setters are created.

    public String getAadhaarNumber() {
        return AadhaarNumber;
    }

    public void setAadhaarNumber(String aadhaarNumber) {
        AadhaarNumber = aadhaarNumber;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public int getAccountNumber() {
        return AccountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        AccountNumber = accountNumber;
    }

    public int getPIN() {
        return PIN;
    }
    public void setPIN(int PIN) {
        this.PIN = PIN;
    }
    public int getAmountTaken() {
        return AmountTaken;
    }

    public void setAmountTaken(int amountTaken) {
        AmountTaken = amountTaken;
    }

    public int getAmountDeposited() {
        return AmountDeposited;
    }

    public void setAmountDeposited(int amountDeposited) {
        AmountDeposited = amountDeposited;
    }

    public int getTypeOfMoney() {
        return typeOfMoney;
    }

    public void setTypeOfMoney(int typeOfMoney) {
        this.typeOfMoney = typeOfMoney;
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    public void setNoOfItems(int noOfItems) {
        this.noOfItems = noOfItems;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }
    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //created a vector to take multiple users
        Vector<User> v = new Vector<User>();
        //I have put all my code in the while loop so that it keeps working all the time
        while (true) {
            //created the object of the user class
            User u = new User();
            System.out.println("----welcome----");
            //User can select he wanted to signUp or signIn
            System.out.println("Select the following-\n1.signUp\n2.SignIn");
            int x = sc.nextInt();
            if (x == 1) {
                //input of user name
                System.out.println("Enter the following details-\nName:- ");
                String s = sc.next();
                u.setName(s);
                //input of user's account number
                System.out.println("Enter Account Number:-");
                int n = sc.nextInt();
                int index = -1;
                for (int i = 0; i < v.size(); i++) {
                    if (v.get(i).getAccountNumber() == n) {
                        index = i;
                    }
                }
                int m = n;
                if (index == -1) {
                    int count = 0;
                    while (n != 0) {
                        n = n / 10;
                        count++;
                    }
                    while (count != 5) {
                        //prints INVALID Account Number if it is not a 5-digit number
                        System.out.println("INVALID Account Number");
                        System.out.println("PLease Enter 5-digit Number");
                        n = sc.nextInt();
                        m = n;
                        count = 0;
                        while (n != 0) {
                            n = n / 10;
                            count++;
                        }
                    }
                    u.setAccountNumber(m);
                    //input of user's account pin
                    System.out.println("Enter the PIN:-");
                    n = sc.nextInt();
                    int l = n;
                    int count1 = 0;
                    while (n != 0) {
                        n = n / 10;
                        count1++;
                    }
                    while (count1 != 5) {
                        //prints INVALID  PIN if it is not a 5-digit number
                        System.out.println("INVALID  PIN");
                        System.out.println("PLease Enter 5-digit Number");
                        n = sc.nextInt();
                        l=n;
                        count1 = 0;
                        while (n != 0) {
                            n = n / 10;
                            count1++;
                        }
                    }
                    u.setPIN(l);
                    //input of user's phone number
                    System.out.print("Enter your Phone Number:- +91");
                    s = sc.next();
                    u.setPhoneNumber(s);
                    //input of user's aadhaar number
                    System.out.println("Enter your Aadhaar Number:-");
                    s = sc.next();
                    u.setAadhaarNumber(s);
                    //here the user can deposit the minimum amount when he signUp for the first time
                    System.out.println("Please deposit a Rs500 of minimum balance");
                    System.out.println("Please deposit you Money");
                    System.out.println("Enter the type of note:-");
                    n = sc.nextInt();
                    u.setTypeOfMoney(n);
                    System.out.println("Enter the Number of Items:-");
                    n = sc.nextInt();
                    u.setNoOfItems(n);
                    u.setAmountDeposited(u.getTypeOfMoney() * u.getNoOfItems());
                    //prints the amount of the money deposited in the user account
                    System.out.println("Rs" + u.getAmountDeposited() + " is deposited in you account");
                    //this increments the balance of the user
                    u.setCurrentBalance(u.getCurrentBalance() + u.getAmountDeposited());
                    System.out.println("Your account is created  successfully ");
                    System.out.println("Thank you");
                    //Here I have added all the details of the user in a vector
                    v.add(u);
                }
                else {
                    //print you have already have an account please signIn if he has already signUp and trying to signUp
                    //again
                    System.out.println("you have already have an account please signIn");
                }
            }
            if (x == 2) {
                //takes account number as input from the user
                System.out.println("Enter Account Number:-");
                int n = sc.nextInt();
                int index = -1;
                //searches for the account which is already stored in the vector
                for (int i = 0; i < v.size(); i++) {
                    if (v.get(i).getAccountNumber() == n) {
                        index = i;
                        break;
                    }
                }
                if (index == -1) {
                    //if the account number does not found it tell to signUp
                    System.out.println("your do not have account please signUp");
                }
                else {
                    if (v.get(index).getAccountNumber() == n) {
                        //if account number is correct it takes pin as the input from the user
                        System.out.println("Enter the PIN:-");
                        n = sc.nextInt();
                        int count4 = 0;
                        //comparing  the given pin with the pin corresponding to the account number
                        while (v.get(index).getPIN() != n) {
                            //it shows INVALID PIN if it is incorrect and asks to enter again
                            System.out.println("INVALID PIN");
                            System.out.println("please enter correct PIN");
                            count4++;
                            //if the user enter incorrect pin for 4 times then it asks to reset the pin by using phone number
                            if (count4 == 4) {
                                System.out.println("reset the password");
                                System.out.println("OTP is sent to this Number" + v.get(index).getPhoneNumber());
                                System.out.println("Please enter the OTP");
                                n = sc.nextInt();
                                n = sc.nextInt();
                                v.get(index).setPIN(n);
                            }
                        }
                        //after signIn thw user can do following thinks
                        System.out.println("Select the following\n1.deposit\n2.Balance\n3.Withdrawal\n4.Details\n5.change Details");
                        int y = sc.nextInt();
                        if (y == 1) {
                            //In deposit first takes the input of the type of the notes he want to deposit and then it takes
                            //the input of number of notes he need to deposit and it calculates the amount and after deposit
                            //it displays the amount deposited in the account and increments the balance
                            System.out.println("Please deposit you Money");
                            System.out.println("Enter the type of note:-");
                            n = sc.nextInt();
                            v.get(index).setTypeOfMoney(n);
                            System.out.println("Enter the Number of Items:-");
                            n = sc.nextInt();
                            v.get(index).setNoOfItems(n);
                            v.get(index).setAmountDeposited(v.get(index).getTypeOfMoney() * v.get(index).getNoOfItems());
                            //prints the amount of money deposited in the account of the user
                            System.out.println("Rs" + v.get(index).getAmountDeposited() + " is deposited in you account");
                            //sets the balance of the user by incrementing the balance of the user with amount he deposited
                            v.get(index).setCurrentBalance(v.get(index).getCurrentBalance() + v.get(index).getAmountDeposited());
                        }
                        if (y == 2) {
                            //if the user select the balance option it will display the total balance in the user account
                            System.out.print("Your balance is ");
                            System.out.println(v.get(index).getCurrentBalance());
                        }
                        if (y == 3) {
                            //in withdrawal it takes the input of the amount that the user want to withdraw and it checks
                            //whether the balance is 500 more than the amount that he want to withdraw
                            System.out.println("Enter the Amount your wanted to withdraw:-");
                            n = sc.nextInt();
                            v.get(index).setAmountTaken(n);
                            //if the balance is 500 more than the amount that he want to withdraw then he collect the amount
                            //at the dispenser and it displays Please collect your amount at dispenser and it decrements that
                            //amount from the balance .
                            if (v.get(index).getAmountTaken() <= v.get(index).getCurrentBalance() - 500) {
                                System.out.println("Please collect your amount at dispenser");
                                //sets the balance of the user by decrementing the amount that the user collected at the
                                //dispenser
                                v.get(index).setCurrentBalance(v.get(index).getCurrentBalance() - v.get(index).getAmountTaken());
                                //after collecting the money it will display the balance in the account of the user
                                System.out.println("Your Balance is " + v.get(index).getCurrentBalance());
                            }
                            //if the balance is not 500 more than the amount that he want to withdraw then it displays
                            //Sorry your Balance is less than the Amount you wanted
                            else if (v.get(index).getAmountTaken() > v.get(index).getCurrentBalance()) {
                                System.out.println("Sorry your Balance is less than the Amount you wanted");
                            }
                        }
                        if (y == 4) {
                            //if the user wants to see his details the details option will display all the details of the user
                            //except the private details like account number and pin of that account
                            System.out.println("Your Details");
                            System.out.print("Name:-");
                            System.out.println(v.get(index).getName());
                            System.out.print("PhoneNumber:-");
                            System.out.println(v.get(index).getPhoneNumber());
                            System.out.print("AadhaarNumber:-");
                            System.out.println(v.get(index).getAadhaarNumber());
                        }
                        if (y == 5) {
                            //this will help the user to change his details.here the user can change his name,phone number
                            //and his aadhaar number
                            System.out.println("select the following\n1.Name\n2.PhoneNumber\n3.AadhaarNumber");
                            int z = sc.nextInt();
                            if (z == 1) {
                                //takes the input of the name and resets his name in vector
                                System.out.println("Enter Your Name:-");
                                String s = sc.next();
                                v.get(index).setName(s);
                            }
                            if (z == 2) {
                                //takes the input of the phone number and resets his phone number in the vector
                                System.out.println("Enter Your PhoneNumber:-");
                                String s = sc.next();
                                v.get(index).setPhoneNumber(s);
                            }
                            if (z == 3) {
                                //takes the input of the aadhaar number and resets his aadhaar number in the vector
                                System.out.println("Enter Your AadhaarNumber:-");
                                String s = sc.next();
                                v.get(index).setAadhaarNumber(s);
                            }
                        }
                    }
                }
            }
        }
    }
}