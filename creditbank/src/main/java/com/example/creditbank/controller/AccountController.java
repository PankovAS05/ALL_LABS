package com.example.creditbank.controller;

import com.example.creditbank.model.Account;
import com.example.creditbank.service.AccountService;
import com.example.creditbank.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ClientService clientService;

    @GetMapping
    public String listAccounts(Model model) {
        List<Account> accounts = accountService.getAllAccounts();
        Map<Long, String> clientsMap = new HashMap<>();
        for (Account account : accounts) {
            clientsMap.put(account.getClientId(), clientService.getClientById(account.getClientId()).getFio());
        }
        model.addAttribute("accounts", accounts);
        model.addAttribute("clientsMap", clientsMap);
        return "accounts";
    }

    @GetMapping("/sorted")
    public String listSortedAccounts(@RequestParam(required = false) String sortBy, Model model) {
        List<Account> accounts = accountService.getAllAccountsSorted(sortBy);
        Map<Long, String> clientsMap = new HashMap<>();
        for (Account account : accounts) {
            clientsMap.put(account.getClientId(), clientService.getClientById(account.getClientId()).getFio());
        }
        model.addAttribute("accounts", accounts);
        model.addAttribute("clientsMap", clientsMap);
        return "accounts";
    }

    @GetMapping("/{id}")
    public String viewAccount(@PathVariable Long id, Model model) {
        Account account = accountService.getAccountById(id);
        model.addAttribute("account", account);
        return "account";
    }

    @GetMapping("/new")
    public String createAccountForm(Model model) {
        model.addAttribute("account", new Account());
        model.addAttribute("clients", clientService.getAllClients());
        return "account_form";
    }

    @PostMapping
    public String saveAccount(@ModelAttribute Account account) {
        if (account.getId() == null) {
            accountService.saveAccount(account);
        } else {
            accountService.updateAccount(account);
        }
        return "redirect:/accounts";
    }

    @GetMapping("/edit/{id}")
    public String editAccountForm(@PathVariable Long id, Model model) {
        Account account = accountService.getAccountById(id);
        model.addAttribute("account", account);
        model.addAttribute("clients", clientService.getAllClients());
        return "account_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return "redirect:/accounts";
    }
}
