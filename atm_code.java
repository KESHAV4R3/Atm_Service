
// project of atm machine cum banking system
import java.util.*;
import javax.management.openmbean.OpenType;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.plaf.synth.SynthOptionPaneUI;


// main class 
public class  Banking_System 
{
    // method to store the data of withdrawl amount

    public static void Withdraw(String Data[], int Amount1) 
    {
        int Amount = Integer.parseInt(Data[6]);
        Amount = Amount - Amount1;
        Data[6] = Integer.toString(Amount);
        System.out.println("REMAINING BALANCE :  " + Amount);
        System.out.println("THANK YOU YOUR TRANSACTION HAS COMPLETED !! ");
    }

    // method to store the data of deposited amount

    public static void Deposite(String Data2[], int Amount2) 
    {
        int Amount11 = Integer.parseInt(Data2[6]);
        Amount11 = Amount11 + Amount2;
        Data2[6] = Integer.toString(Amount11);
        System.out.println("REMAINING BALANCE :  " + Amount11);
        System.out.println("THANK YOU YOUR TRANSACTION HAS COMPLETED !! ");
    }

    public static void main(String aregs[]) 
    {
        Scanner s = new Scanner(System.in);

        // 2-D array to store the data of registering customer
        String Data[][] = new String[100][10];

        // 2-D array for storing the transaction history
        String MiniStatement[][] = new String[100][20];

        // 1-D array to keep the record of number of transaction done by individual customer 
        int transactionNumber[]=new int[100];

        // to count the total customer in the data
        int CustomerCount = 0;

        while (true) 
        {
            // int check variable is used give access to the person in Data array in correct row
            int Check = 0;

            // verify is the variable to store the location of row in data[][] array
            int Verify = 0;

            // initial interface
            System.out.println("SELECT OPTIONS GIVEN BELOW ");
            System.out.println("1. LOGIN          2. CREAT ACCOUNT");
            String Option = s.nextLine();

            // loop to verify correct input from user 
            while(Option.matches("[1-2]")==false)
            {
            System.out.println("WRONG INPUT PLEASE TRY AGAIN !!");
            System.out.println("SELECT OPTIONS GIVEN BELOW ");
            System.out.println("1. LOGIN          2. CREAT ACCOUNT");
            Option = s.nextLine();
            }

            int DecisionOption=Integer.parseInt(Option);

            // condition to open the account of customer
            if (DecisionOption == 2) 
            {
                System.out.print("NAME                                              : ");
                Data[CustomerCount][0] = s.nextLine();

                System.out.print("PAN NUMBER                                        : ");
                Data[CustomerCount][1] = s.nextLine();

                int PanVerification=1;

                // loop to check whether the PAN NUMBER is already registered or not 
                if(CustomerCount>=1)
                {
                do{
                 for(int i=0;i<CustomerCount;i++)
                 {
                    if(Data[i][1].compareTo(Data[CustomerCount][1])==0)
                    {
                        System.out.println("ALREADY REGISTERED PAN-NUMBER !! ");
                        System.out.print("PAN NUMBER                                        : ");
                        Data[CustomerCount][1] = s.nextLine();
                        PanVerification=1;
                        break;
                    }
                    else
                    PanVerification=0;
                 }
                }
                while(PanVerification==1);
                }

                // loop to verify the correct formate of PAN MUMBER
                while (Data[CustomerCount][1].matches("[A-Z]{5}[0-9]{4}[A-Z]") == false) 
                {
                    System.out.println("WRONG INPUT PLEASE TRY AGAIN !! ");
                    System.out.print("PAN NUMBER                                        : ");
                    Data[CustomerCount][1] = s.nextLine();
                }

                System.out.print("AADHAR NUMBER                                     : ");
                Data[CustomerCount][2] = s.nextLine();

                int AadharVerification=1;

                // loop to check whether the PAN NUMBER is already registered or not 
                if(CustomerCount>=1)
                {
                do{
                 for(int i=0;i<CustomerCount;i++)
                 {
                    if(Data[i][2].compareTo(Data[CustomerCount][2])==0)
                    {
                        System.out.println("ALREADY REGISTERED AADHAR-NUMBER !! ");
                        System.out.print("AADHAR NUMBER                                     : ");
                        Data[CustomerCount][2] = s.nextLine();
                        AadharVerification=1;
                        break;
                    }
                    else
                    AadharVerification=0;
                 }
                }
                while(AadharVerification==1);
                }

                // loop to verify correct formate of AADHAR NUMBER
                while (Data[CustomerCount][2].matches("[0-9]{12}") == false) 
                {
                    System.out.println("WRONG INPUT PLEASE TRY AGAIN !! ");
                    System.out.print("AADHAR NUMBER                                     : ");
                    Data[CustomerCount][2] = s.nextLine();
                }

                System.out.print("ADDRESS                                           : ");
                Data[CustomerCount][3] = s.nextLine();

                System.out.print("DOB(dd/mm/yyyy)                                   : ");
                Data[CustomerCount][4] = s.nextLine();

                // loop to verify correct D_O_B formate
                while (Data[CustomerCount][4].matches("(0[1-9]|[1-2][0-9]|3[0-1])" + "/" + "(0[1-9]|1[1-2])"+ "/" + "(19[5-9][0-9]|200[0-9]|20[1-2][0-3])") == false) 
                {
                    System.out.println("WRONG INPUT PLEASE TRY AGAIN !! ");
                    System.out.print("DOB(dd/mm/yyyy)                                   : ");
                    Data[CustomerCount][4] = s.nextLine();
                }

                System.out.print("MOBILE                                            : ");
                Data[CustomerCount][5] = s.nextLine();

                //loop to verify correct MOBILE number formate
                while (Data[CustomerCount][5].matches("[6-9][0-9]{9}") == false) 
                {
                    System.out.println("WRONG INPUT PLEASE TRY AGAIN !! ");
                    System.out.print("MOBILE                                            : ");
                    Data[CustomerCount][5] = s.nextLine();
                }

                System.out.print("DEPOSITE AMOUNT                                   : ");
                Data[CustomerCount][6] = s.nextLine();

                System.out.print("ENTER THE USER ID THAT YOU WANT TO USE FOR ACCOUT : ");
                Data[CustomerCount][7] = s.nextLine();

                int IdVerification=1;

                // loop to check whether the user name is already registered or not 
                if(CustomerCount>=1)
                {
                do{
                 for(int i=0;i<CustomerCount;i++)
                 {
                    if(Data[i][7].compareTo(Data[CustomerCount][7])==0)
                    {
                        System.out.println("ALREADY REGISTERED ID !! ");
                        System.out.print("ENTER THE USER ID THAT YOU WANT TO USE FOR ACCOUT : ");
                        Data[CustomerCount][7] = s.nextLine();
                        IdVerification=1;
                        break;
                    }
                    else
                    IdVerification=0;
                 }
                }
                while(IdVerification==1);
                }

                System.out.print("ENTER THE PASSWORD THAT YOU WANT TO KEEP          : ");
                Data[CustomerCount][8] = s.nextLine();

                System.out.println("CONGRATES YOUR ACOUNT HAS BE OPENED ");
                System.out.println();

                // creation pf AccountNumber
                String AccountNumber1=Integer.toString((int)Math.floor(Math.random()*(100000)+899999));
                String AccountNumber2=Integer.toString((int)Math.floor(Math.random()*(100000)+899999));
                Data[CustomerCount][9]=AccountNumber1.concat(AccountNumber2);

                CustomerCount++;
            } 
            
            // now condition to login activates 

            else if (DecisionOption == 1) 
            {
                // AccountVerification variable is used to verify that entered ID and Password is correct 
                int AccountVerification = 0;
    
                // interface to the user
                System.out.println("ENTER YOUR USER ID        : ");
                String CustomerID = s.nextLine();
                
                System.out.println("ENTER YOUR LOGIN PASSWORD : ");
                String Password = s.nextLine();
                
                // loop to match the given data with stored data
                for (Check = 0; Check < CustomerCount; Check++) 
                {
                    if (CustomerID.compareTo(Data[Check][7]) == 0 && Password.compareTo(Data[Check][8]) == 0) {
                        AccountVerification = 1;
                        // verify is the variable to store the location of row in data[][] array
                        Verify = Check;
                        break;
                    }
                }

                // condition to be activated when verification is completed
                if (AccountVerification == 1) 
                {
                    System.out.println("SELECT THE OPTION GIVEN BELOW : ");
                    System.out.print("1.  WITHDRAW          ");
                    System.out.println("2.  DEPOSITE");
                    System.out.print("3.  MINI STATEMENT    ");
                    System.out.println("4.  BANK OFFER");
                    System.out.print("5.  GET INFORMATION   ");
                    System.out.println("6.  EXIT ");
                    String  Option2 = s.next();

                    // loop to verify correct input formate 
                    while(Option2.matches("\\d")==false)
                    {
                    System.out.println("SELECT THE OPTION GIVEN BELOW : ");
                    System.out.print("1.  WITHDRAW          ");
                    System.out.println("2.  DEPOSITE");
                    System.out.print("3.  MINI STATEMENT    ");
                    System.out.println("4.  BANK OFFER");
                    System.out.print("5.  GET INFORMATION   ");
                    System.out.println("6.  EXIT ");
                    Option2 = s.next();
                    }

                    int Option1=Integer.parseInt(Option2);

                    // switch case to access the options
                    switch (Option1) 
                    {
                        
                        case 1:
                            // case for withdrawl in amount
                            System.out.println("ENTER AMOUNT : ");
                            int Amount1 = s.nextInt();
                            System.out.println("ENTER DATE : ");
                            String Date1 = s.next();
                            while(Date1.matches("(0[1-9]|[1-2][0-9]|3[0-1])" + "/" + "(0[1-9]|1[1-2])"+ "/" + "(19[5-9][0-9]|200[0-9]|20[1-2][0-3])") == false)
                            {
                                System.out.println("WRONG INPUT PLEASE TRY AGAIN !! ");
                                System.out.println("ENTER DATE : ");
                                Date1 = s.next();
                            }
                            if(Amount1>Integer.parseInt(Data[Verify][6]))
                                System.out.println("INSUFFICIANT FUND !! ");
                            else
                                Withdraw(Data[Verify], Amount1);

                            // data to store on ministatement history    
                            String history=Date1+" :-  -"+Integer.toString(Amount1);
                            MiniStatement[Verify][transactionNumber[Verify]]=history;
                            transactionNumber[Verify]++;

                            s.nextLine();

                            break;

                        case 2:
                            // case for deposite in amount
                            System.out.println("ENTER AMOUNT : ");
                            int Amount2 = s.nextInt();
                            System.out.println("ENTER DATE : ");
                            String Date2 = s.next();
                            while(Date2.matches("(0[1-9]|[1-2][0-9]|3[0-1])" + "/" + "(0[1-9]|1[1-2])"+ "/" + "(19[5-9][0-9]|200[0-9]|20[1-2][0-3])") == false)
                            {
                                System.out.println("WRONG INPUT PLEASE TRY AGAIN !! ");
                                System.out.println("ENTER DATE : ");
                                Date2 = s.next();
                            }
                            Deposite(Data[Verify], Amount2);

                            // data to store on ministatement history    
                            history=Date2+" :-  +"+Integer.toString(Amount2);
                            MiniStatement[Verify][transactionNumber[Verify]]=history;
                            transactionNumber[Verify]++;

                            s.nextLine();

                            break;

                        case 3:
                            // case for ministatement printing 

                            int temp2;
                            int temp3=0;
                            temp2=transactionNumber[Verify]-1;
                            while(temp2>=0 && temp3<=5)
                            {
                                System.out.println(MiniStatement[Verify][temp2]);
                                temp3++;
                                temp2--;
                            }
                            System.out.println("THANK YOU YOUR TRANSACTION HAS COMPLETED !! ");

                            s.nextLine();

                            break;

                        case 4:
                            // case for loan enquiry
                            System.out.println("HOME LOAN        :    0.5% p.a. - 21.00% p.a.");
                            System.out.println("EDUCATIONAL LOAN :  	10.75% onwards");
                            System.out.println("CAR LOAN         :    8.60% p.a. onwards");

                            s.nextLine();

                            break;

                        case 5:
                            // case for personal information
                            System.out.println("NAME                :  " + Data[Verify][0]);
                            System.out.println("PAN NUMBER          :  " + Data[Verify][1]);
                            System.out.println("AADHAR NUMBER       :  " + Data[Verify][2]);
                            System.out.println("ADDRESS             :  " + Data[Verify][3]);
                            System.out.println("DOB                 :  " + Data[Verify][4]);
                            System.out.println("MOBILE              :  " + Data[Verify][5]);
                            System.out.println("BALANCE             :  " + Data[Verify][6]);
                            System.out.println("ACCOUNT NUMBER      :  " + Data[Verify][9]);
                            System.out.println("IFSC CODE         :  SBIN0005943");

                            s.nextLine();

                            break;

                        case 6:
                            // case for EXIT option
                            s.nextLine();

                            break;

                        default:
                            // case for wrong input
                            System.out.println("WRONG INPUT PLEASE TRY AGAIN !! ");

                            s.nextLine();

                            break;
                    }
                } 
                else 
                {
                    System.out.println("NO DATA FOUND !! ");
                }
            } 
            else
            {
                System.out.println("WRONG INPUT PLEASE TRY AGAIN !! ");
            }
        }
    }
}