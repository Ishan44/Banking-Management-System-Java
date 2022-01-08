
package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

class Account implements Serializable{ //Used to insert account object as whole in file,  
    String accNo;
    String name;
    Long bal;
    Long phno;
    String address;
    Boolean loan; //to check if user has taken loan from the bank or not
    Long loanAmt;
    int loanPriority;
    int bt; //approval time
    boolean pending=false; //to check if the loan has been cleared or not
    //static int ac=0;

    public Account(String name, Long bal,String accNo, Long phno, String address) { //constructor
        this.name = name;
        this.bal = bal;
        this.accNo= accNo;
        this.phno=phno;
        this.address=address;
        loan=false;
        loanAmt=(long)0;
        loanPriority=0;
    }


//    public void setAccNo(String accNo) {
//        this.accNo = accNo;
//    }
//
//    public void setNamee(String name) {
//        Name = name;
//    }
//
//    public void setBal(Integer bal) {
//        this.bal = bal;
//    }


    @Override
    public String toString() { //to display the account details
        return "" +
                "accNo= " + accNo  +
                " name= " + name  +
                " bal= " + bal +
                " phno= "+ phno+
                " address= "+ address
                ;
    }

}

//class Transaction extends Thread{
//    Account a;
//
//    synchronized public void transaction(){
//        HashMap<String,Account> hm=new HashMap<>();
//        Scanner sc=new Scanner(System.in);
//        if(!hm.isEmpty()){
//            Account a;
//            Account b;
//            Integer bal;
//            System.out.println("Enter Account Number: ");
//            sc.nextLine();
//            String s=sc.nextLine();
//            if(hm.containsKey(s)){
//                a=hm.get(s);
//                System.out.println("Your Balance: "+a.bal);
//                System.out.println("Enter account Number to Transfer your Balance: ");
//                String s2=sc.nextLine();
//                if(hm.containsKey(s2)){
//                    b=hm.get(s2);
//                    System.out.println("Enter Balance to be Transferred: ");
//                    bal=sc.nextInt();
//                    if(bal<a.bal){
//                        System.out.println("Transaction is being performed...");
//                        sc.nextLine();
//                        sc.nextLine();
//                        a.bal-=bal;
//                        b.bal+=bal;
//                        System.out.println("Balance Transferred Successfully!");
//                        System.out.println(s+" Balance: "+a.bal);
//                        System.out.println(s2+" Balance: "+b.bal);
//                        sc.nextLine();
//                    }
//                    else{
//                        System.out.println("Account Number Not FOUND!");
//                        sc.nextLine();
//                    }
//                }
//            }
//            else{
//                System.out.println("Account Number Not FOUND!");
//                sc.nextLine();
//            }
//        }
//        else{
//            System.out.println("File is empty!");
//            sc.nextLine();
//
//        }
//    }
//    public void run(){
//        transaction();
//    }
//
//
//}


public class Main extends Thread { //Created main as a thread with transaction as its run function //  
    static Scanner sc = new Scanner(System.in);
    static HashMap<String, Account> hm = new HashMap<>(); //hash map uses key, value pair, we have used acc number as key and whole account class as its value as account number is unique
    static File f = new File("Account.txt"); //to store our file data


    static void create(){ //  
        System.out.println("Enter Account Number: ");
        sc.nextLine();
        String a= sc.nextLine();
        if(!hm.containsKey(a)){ // to check if the account number is present already in the hash map or not
            System.out.print("Enter Account Holders Name: ");
            //sc.nextLine();
            String s=sc.nextLine();
            System.out.println("Enter Balance: ");
            Long b=sc.nextLong();
            System.out.println("Enter Phone Number: ");
            Long ph=sc.nextLong();
            System.out.println("Enter Address: ");
            sc.nextLine();
            String ad=sc.nextLine();


            Account ac=new Account(s,b,a,ph,ad); //account object is created
            hm.put(ac.accNo,ac); //We have stored it in hashmap here
            System.out.println();
            System.out.println("Account Created Successfully!");
        }
        else{
            System.out.println("Account Number Already Exists!");

        }
        sc.nextLine();

    }


    static void delete(){ //  
        if(!hm.isEmpty()){ //This indiactes that the file is empty
            System.out.println("Enter Acc No: ");
            sc.nextLine();
            String s=sc.nextLine();

            if(hm.containsKey(s)){
                hm.remove(s);
                System.out.println("Account Details successfully deleted!");
            }
            else{
                System.out.println("Account number not found!");
            }
        }
        else{
            System.out.println("The File is Empty!");
        }
        sc.nextLine();
    }



    static void view(){ // 

        if(!hm.isEmpty()){
            System.out.println("Enter Acc No: ");
            sc.nextLine();
            String s=sc.nextLine();
            if(hm.containsKey(s))
                System.out.println(hm.get(s));
            else
                System.out.println("Account Number not Found!");
        }
        else{
            System.out.println("The File is Empty!");
        }
        sc.nextLine();
        //sc.nextLine();
    }



    static void viewAll(){ // 
        int c=0;
        if(!hm.isEmpty()){ //same concepts are used to make the test cases generic,
            if(c==0){
                System.out.println("Displaying All Account Details: ");
                c++;
            }
            hm.forEach((k,v)-> System.out.println(hm.get(k))); //we have used for each loop to display the records of account class... for each loop is a function of hash map
        }
        else{
            System.out.println("The file is already empty!");
        }
        sc.nextLine();
        sc.nextLine();
    }

    static void addBal(){
        if(!hm.isEmpty()){
            System.out.println("Enter Acc No: ");
            sc.nextLine();

            String s=sc.nextLine();
            Account a;
            Integer b;
            if(hm.containsKey(s)){
                a=hm.get(s);
                System.out.println("Balance: "+a.bal);
                System.out.println("Enter Balance to be Added: ");
                b=sc.nextInt();
                a.bal+=b;
                System.out.println("Balance Added Successfully.");
                System.out.println("Current Balance: " +a.bal);

            }
            else{
                System.out.println("Account number not found!");

            }
        }
        else{
            System.out.println("The File is Empty!");
        }
        sc.nextLine();
        sc.nextLine();
    }

    static void loanPay(){

    }

    static void loan() { //me
        System.out.println("LOAN: ");
        if (!hm.isEmpty()) {
            System.out.println("Enter Acc No: ");
            sc.nextLine();
            String s = sc.nextLine();
            Account a;
            Integer b;
            int p = 0;
            Long amt;
            if (hm.containsKey(s)) {

                a = hm.get(s);
                if(a.pending==false){
                    a.loan = true;
                    a.pending=true;
                    System.out.println("Enter Loan Type:(low to high Priority)");
                    System.out.println("1. Vehicle");
                    System.out.println("2. Housing");
                    System.out.println("3. Business");
                    System.out.println("4. Education");
                    System.out.println("5. Health");
                    p = sc.nextInt();
                    if (p < 6) {
                        System.out.println("");
                        System.out.println("Enter loan Amount: ");
                        amt = sc.nextLong();
                        a.loanAmt = amt;
                        a.loanPriority = p;

                        if (amt < 100000) {
                            a.bt = 2;
                        } else {
                            if (amt < 1000000) {
                                a.bt = 4;
                            } else {
                                if (amt < 10000000) {
                                    a.bt = 7;
                                } else {
                                    if (amt < 100000000) {
                                        a.bt = 10;
                                    } else {
                                        a.bt = 13;
                                    }
                                }
                            }
                        }
                        System.out.println("Loan Applied Successfully!");
                    } else {
                        System.out.println("Invalid Choice!");
                    }
                }else{
                    System.out.println("Pending loan exists. Complete that payment first!" +
                            "");
                }

            }
            else {
                System.out.println("Account number not found!");

            }

        } else {
            System.out.println("The File is Empty!");
        }
        sc.nextLine();
        sc.nextLine();
    }



    static void dispLoan() {
        int c = 0;

        if (!hm.isEmpty()) {
            if (c == 0) {
                System.out.println("Displaying All Loan Details: ");
                c++;
            }
            hm.forEach((k, v) -> {
                Account a;
                a = hm.get(k);
                if (a.loan == true) {
                    System.out.println(a + " Loan Amt: " + a.loanAmt + " Loan Reason: " + a.loanPriority+" LoanApproved: "+!a.pending);
                }
            });
        } else {
            System.out.println("The file is already empty!");
        }
        sc.nextLine();
        sc.nextLine();

    }


    static void loanTime() {
        int no = 0;
        if (!hm.isEmpty()) {
            System.out.println("Display Loan Time: ");
            Account a;
            int x = 0;
            boolean flag = false;
            Integer bt[] = new Integer[1000];
            Integer pri[] = new Integer[1000];
            Integer arrival[] = new Integer[1000];
            String acc[]=new String[1000];

            for (Map.Entry<String, Account> set :
                    hm.entrySet()) {
                a = set.getValue();
                if (a.loan == true) {
                    if(a.pending== true){
                        bt[x] = a.bt;
                        pri[x] = a.loanPriority;
                        arrival[x] = x;
                        acc[x]=a.accNo;
                        x++;
                        no++;
                        flag = true;
                        a.pending=false;
                        a.bal+=a.loanAmt;
                    }
                }

            }
            if (flag == false) {
                System.out.println("No loan record found!");
            }


            if (flag == true) {

                int i, j, NOP, sum = 0, count = 0, y, quant, wt = 0, tat = 0, pos, n, tem;
                int temp[] = new int[10];
                int BT[] = new int[10];
                int p[] = new int[10];
                int pr[] = new int[10];
                int at[] = new int[10];

                float avg_wt, avg_tat;
                for (i = 0; i < no; i++) {
                    at[i] = arrival[i];
                    BT[i] = bt[i];
                    pr[i] = pri[i];
                    temp[i] = BT[i];
                    p[i] = i + 1;
                }
                NOP = no;
                System.out.println("Enter time quanta");
                quant = sc.nextInt();


//        System.out.println("Total number of process in the system: ");
//        NOP=s.nextInt();
                n = NOP;// For Sorting
                y = NOP;
//        for(i=0; i<NOP; i++)
//        {
//
//            System.out.println("\nEnter the Arrival, Burst time and Priority of the Process"+ (i+1)+" :");
//            System.out.println("Arrival time : ");
//            at[i]=s.nextInt();
//            System.out.println("Burst time : ");
//            bt[i]=s.nextInt();
//            System.out.println("Enter Priority : ");
//            pr[i]=s.nextInt();
//            temp[i] = bt[i];
//            p[i]=i+1;   //Assign Process number
//
//        }
                //Selection sort
                for (i = 0; i < n; i++) {
                    pos = i;
                    for (j = i + 1; j < n; j++) {
                        if (pr[j] < pr[pos])
                            pos = j;
                    }

                    tem = pr[i];
                    pr[i] = pr[pos];
                    pr[pos] = tem;

                    tem = BT[i];
                    BT[i] = BT[pos];
                    BT[pos] = tem;

                    tem = at[i];
                    at[i] = at[pos];
                    at[pos] = tem;

                    tem = p[i];
                    p[i] = p[pos];
                    p[pos] = tem;
                }
//        System.out.println("Enter the Time Quantum for the process: ");
//        quant=s.nextInt();

                System.out.println("\nAcc No \t\t Loan Process Time\t\t Loan Approved Time \t\t Waiting Time \tLoan Priority \t");
                for (sum = 0, i = 0; y != 0; ) {
                    if (temp[i] <= quant && temp[i] > 0) {
                        sum = sum + temp[i];
                        temp[i] = 0;
                        count = 1;
                    } else if (temp[i] > 0) {
                        temp[i] = temp[i] - quant;
                        sum = sum + quant;
                    }
                    if (temp[i] == 0 && count == 1) {
                        y--;
                        System.out.printf("\nAcc No[%s] \t\t\t\t %d\t\t\t\t\t\t %d\t\t\t\t\t\t %d \t\t\t\t  %d\t\t\t\t", acc[i], BT[i], sum - at[i] - 1, Math.abs(sum - at[i] - BT[i]), pr[i]);
                        wt = wt + sum - at[i] - BT[i];
                        tat = tat + sum - at[i];
                        count = 0;
                    }
                    if (i == NOP - 1) {
                        i = 0;
                    } else if (at[i + 1] <= sum) {
                        i++;
                    } else {
                        i = 0;
                    }
                }
                avg_wt = (float) (wt * 1.0 / NOP);
                avg_tat = (float) (tat * 1.0 / NOP);
                System.out.printf("\n Average Waiting Time: \t%f", avg_wt);
                System.out.printf("\n Average TurnAround Time: \t%f", avg_tat);
                bt= null;
                pri= null;
                arrival= null;
                acc=null;



            }

        }else

        {
            System.out.println("The File is Empty!");

        }
        sc.nextLine();
        sc.nextLine();
    }






    //    static void trans(){
//        Transaction t=new Transaction();
//        t.start();
//    }


    synchronized static void transaction(){ //  
        if(!hm.isEmpty()){
            Account a;
            Account b;
            Integer bal;
            System.out.println("Enter Your Account Number: "); //enter acc no, check if your acc no is present,
            sc.nextLine();
            String s=sc.nextLine();
            if(hm.containsKey(s)){
                a=hm.get(s);
                System.out.println("Your Balance: "+a.bal);
                System.out.println("Enter account Number to Transfer your Balance: ");
                String s2=sc.nextLine();
                if(hm.containsKey(s2)){
                    b=hm.get(s2);
                    System.out.println("Enter Balance to be Transferred: ");
                    bal=sc.nextInt();
                    if(bal<a.bal){
                        System.out.println("Transaction is being performed...");
                        sc.nextLine();
                        sc.nextLine();
                        a.bal-=bal; //transaction is performed here
                        b.bal+=bal;
                        System.out.println("Balance Transferred Successfully!");
                        System.out.println(s+" Balance: "+a.bal);
                        System.out.println(s2+" Balance: "+b.bal);
                        sc.nextLine();
                    }
                    else{
                        System.out.println("Insufficient Balance!");
                        sc.nextLine();
                        sc.nextLine();
                        //sc.nextLine();
                    }

                }
            }
            else{
                System.out.println("Account Number Not FOUND!");
                sc.nextLine();
            }
        }
        else{
            System.out.println("File is empty!");
            sc.nextLine();

        }
    }


    public void run(){
        transaction();
    }



    static void save(ObjectOutputStream ooss)throws Exception{
        ObjectOutputStream oos=ooss;
        int c=hm.size();
        oos.writeInt(c);
        //System.out.println(c);

        if(!hm.isEmpty()){
            hm.forEach((k,v)-> {
                try {
                    oos.writeObject(hm.get(k));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            System.out.println("Saved Successfully!");
        }
        else{
            System.out.println("Hash Map is Empty!");
        }
        sc.nextLine();
        sc.nextLine();

    }

    static void exitt(ObjectOutputStream ooss)throws Exception{
        ObjectOutputStream oos=ooss;
        int c=hm.size();
        oos.writeInt(c);
        //System.out.println(c);

        if(!hm.isEmpty()){
            hm.forEach((k,v)-> {
                try {
                    oos.writeObject(hm.get(k));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            System.out.println("Saved Successfully!");
        }
        else{
            //System.out.println("Hash Map is Empty!");
        }


    }



    public static void main(String[] args) throws Exception{
        // write your code here
        //File f=new File("Account.txt");
        Account ac=null;

        //sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?"); //Skips any new line thrown at it
        try {
            FileInputStream fis = new FileInputStream("Account.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            int count=ois.readInt();
            System.out.println("Getting File");
            for (int i = 0; i < count; i++) {
                ac=(Account)ois.readObject();
                hm.put(ac.accNo,ac);
            }
            System.out.println("Getting Data from File...");
            sc.nextLine();
            fis.close();
            ois.close();
        }catch (Exception e){
        }


        FileOutputStream fos=new FileOutputStream("Account.txt");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        int ch=0;
        int cu=0;
        Main m[]=new Main[100];
        while(ch!=11) {
            System.out.println("\n\nAccounts Menu: ");
            System.out.println("1.  Create Account");
            System.out.println("2.  Delete Account");
            System.out.println("3.  View Account");
            System.out.println("4.  View All Account");
            System.out.println("5.  Add Balance(Deposit)");
            System.out.println("6.  Perform Transaction");
            System.out.println("7.  Apply For Loan");
            System.out.println("8.  Calculate Loan Time");
            System.out.println("9.  Display Loan Record");
            System.out.println("10. Save Accounts");
            System.out.println("11. Exit");
            System.out.println("");
            System.out.println("\nEnter your choice: ");

            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    create();
                    break;

                case 2:
                    delete();
                    break;

                case 3:
                    view();
                    break;

                case 4:
                    viewAll();
                    break;

                case 10:
                    save(oos);
                    break;

                case 5:
                    addBal();
                    break;

                case 6:
                    cu++;
                    m[cu]=new Main();
                    m[cu].start();
                    m[cu].join();
                    break;

                case 7:
                    loan();
                    break;

                case 8:
                    loanTime();
                    break;

                case 9:
                    dispLoan();
                    break;

                case 11:
                    exitt(oos);
                    break;

                default:
                    System.out.println("Invalid Entry!");
                    sc.nextLine();
            }
        }

        oos.flush();
        fos.close();
        oos.close();

    }
}
