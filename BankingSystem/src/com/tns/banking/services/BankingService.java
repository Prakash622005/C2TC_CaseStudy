package com.tns.banking.services;

import java.util.*;
import com.tns.banking.entities.*;

public interface BankingService {

    void addCustomer(Customer customer);
    void addAccount(Account account);
    void addTransaction(Transaction transaction);
    void addBeneficiary(Beneficiary beneficiary);

    Customer findCustomerById(int id);
    Account findAccountById(int id);
    Transaction findTransactionById(int id);
    Beneficiary findBeneficiaryById(int id);

    Collection<Customer> getAllCustomers();
    Collection<Account> getAllAccounts();
    Collection<Transaction> getAllTransactions();
    Collection<Beneficiary> getAllBeneficiaries();

    List<Account> getAccountsByCustomerId(int customerID);
    List<Transaction> getTransactionsByAccountId(int accountID);
    List<Beneficiary> getBeneficiariesByCustomerId(int customerID);
}
