package com.example.creditbank.service;

import com.example.creditbank.dao.AccountDAO;
import com.example.creditbank.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountDAO accountDAO;

    public List<Account> getAllAccounts() {
        return accountDAO.getAllAccounts();
    }

    public List<Account> getAllAccountsSorted(String sortBy) {
        return accountDAO.getAllAccountsSorted(sortBy);
    }

    public Account getAccountById(Long id) {
        return accountDAO.getAccountById(id);
    }

    public void saveAccount(Account account) {
        accountDAO.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDAO.updateAccount(account);
    }

    public void deleteAccount(Long id) {
        accountDAO.deleteAccount(id);
    }
}
