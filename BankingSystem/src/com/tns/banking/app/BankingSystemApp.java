package com.tns.banking.app;

import com.tns.banking.entities.*;
import com.tns.banking.services.*;
import java.util.*;

public class BankingSystemApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankingService service = new BankingServiceImpl();

        while (true) {
            System.out.println("\nBanking System");
            System.out.println("1. Add Customers");
            System.out.println("2. Add Accounts");
            System.out.println("3. Add Beneficiary");
            System.out.println("4. Add Transaction");
            System.out.println("5. Find Customer by Id");
            System.out.println("6. List all Accounts of specific Customer");
            System.out.println("7. List all transactions of specific Account");
            System.out.println("8. List all beneficiaries of specific customer");
            System.out.println("9. Check Account Balance");
            System.out.println("10. Exit");
            

            System.out.print("Enter your choice : ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Enter Customer Details");
                    System.out.print("Customer Id : ");
                    int cid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name : ");
                    String name = sc.nextLine();

                    System.out.print("Address : ");
                    String address = sc.nextLine();

                    System.out.print("Contact No. : ");
                    String contact = sc.nextLine();

                    service.addCustomer(new Customer(cid, name, address, contact));
                    break;

                case 2:
                    System.out.println("Enter Account Details");
                    System.out.print("Account Id : ");
                    int accid = sc.nextInt();

                    System.out.print("Customer Id : ");
                    int custid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Account Type Saving/ Current : ");
                    String type = sc.nextLine();

                    System.out.print("Balance : ");
                    double balance = sc.nextDouble();

                    service.addAccount(new Account(accid, custid, type, balance));
                    break;

                case 3:
                    System.out.println("Enter Beneficiary Details");
                    System.out.print("Beneficiary Id : ");
                    int bid = sc.nextInt();

                    System.out.print("Customer Id : ");
                    int bcust = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Beneficiary Name : ");
                    String bname = sc.nextLine();

                    System.out.print("Beneficiary Account No. : ");
                    String bacc = sc.nextLine();

                    System.out.print("Beneficiary Bank Details : ");
                    String bbank = sc.nextLine();

                    service.addBeneficiary(new Beneficiary(bid, bcust, bname, bacc, bbank));
                    break;

                case 4:
                    System.out.println("Enter Transaction Details");
                    System.out.print("Transaction Id : ");
                    int tid = sc.nextInt();

                    System.out.print("Account Id : ");
                    int tacc = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Transaction Type (deposit / withdraw): ");
                    String ttype = sc.nextLine();

                    System.out.print("Amount : ");
                    double amt = sc.nextDouble();

                    service.addTransaction(new Transaction(tid, tacc, ttype, amt));
                    break;

                case 5:
                    System.out.print("Enter Customer ID : ");
                    int id1 = sc.nextInt();
                    System.out.println(service.findCustomerById(id1));
                    break;

                case 6:
                    System.out.print("Enter Customer ID : ");
                    int id2 = sc.nextInt();
                    List<Account> accList = service.getAccountsByCustomerId(id2);
                    accList.forEach(System.out::println);
                    break;

                case 7:
                    System.out.print("Enter Account ID : ");
                    int id3 = sc.nextInt();
                    List<Transaction> tlist = service.getTransactionsByAccountId(id3);
                    tlist.forEach(System.out::println);
                    break;

                case 8:
                    System.out.print("Enter Customer ID : ");
                    int id4 = sc.nextInt();
                    List<Beneficiary> blist = service.getBeneficiariesByCustomerId(id4);
                    blist.forEach(System.out::println);
                    break;

                    case 9:
                    System.out.print("Enter Account ID : ");
                    int accCheckId = sc.nextInt();
                    
                    Account acc = service.findAccountById(accCheckId);

                    if (acc != null) {
                        System.out.println("Current Balance = " + acc.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                    case 10:
                        System.out.println("Thank you.");
                        sc.close();
                        return;
                


                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}
