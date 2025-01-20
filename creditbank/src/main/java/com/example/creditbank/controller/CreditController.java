package com.example.creditbank.controller;

import com.example.creditbank.model.Account;
import com.example.creditbank.model.Credit;
import com.example.creditbank.service.AccountService;
import com.example.creditbank.service.ClientService;
import com.example.creditbank.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/credits")
public class CreditController {

    @Autowired
    private CreditService creditService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private AccountService accountService;

    @GetMapping
    public String listCredits(Model model) {
        List<Credit> credits = creditService.getAllCredits();
        for (Credit credit : credits) {
            credit.setEndDate(calculateEndDate(credit.getDateOfLoan(), credit.getTermMonths()));
            credit.setClientFio(clientService.getClientById(credit.getClientId()).getFio());
        }
        model.addAttribute("credits", credits);
        return "credits";
    }

    @GetMapping("/sorted")
    public String listSortedCredits(@RequestParam(required = false) String sortBy, Model model) {
        List<Credit> credits = creditService.getAllCreditsSorted(sortBy);
        for (Credit credit : credits) {
            credit.setEndDate(calculateEndDate(credit.getDateOfLoan(), credit.getTermMonths()));
            credit.setClientFio(clientService.getClientById(credit.getClientId()).getFio());
        }
        model.addAttribute("credits", credits);
        return "credits";
    }

    @GetMapping("/{id}")
    public String viewCredit(@PathVariable Long id, Model model) {
        Credit credit = creditService.getCreditById(id);
        credit.setEndDate(calculateEndDate(credit.getDateOfLoan(), credit.getTermMonths()));
        credit.setClientFio(clientService.getClientById(credit.getClientId()).getFio());
        model.addAttribute("credit", credit);
        return "credit";
    }

    @GetMapping("/new")
    public String createCreditForm(Model model) {
        model.addAttribute("credit", new Credit());
        model.addAttribute("clients", clientService.getAllClients());
        model.addAttribute("accounts", accountService.getAllAccounts());
        return "credit_form";
    }

    @PostMapping
    public String saveCredit(@ModelAttribute Credit credit) {
        if (credit.getId() == null) {
            creditService.saveCredit(credit);
            // Пополнение счета клиента на сумму кредита
            Account account = accountService.getAccountById(credit.getAccountId());
            account.setBalance(account.getBalance().add(credit.getSum()));
            accountService.updateAccount(account);
        } else {
            creditService.updateCredit(credit);
        }
        return "redirect:/credits";
    }

    @GetMapping("/edit/{id}")
    public String editCreditForm(@PathVariable Long id, Model model) {
        Credit credit = creditService.getCreditById(id);
        model.addAttribute("credit", credit);
        model.addAttribute("clients", clientService.getAllClients());
        model.addAttribute("accounts", accountService.getAllAccounts());
        return "credit_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteCredit(@PathVariable Long id) {
        creditService.deleteCredit(id);
        return "redirect:/credits";
    }

    private Date calculateEndDate(Date dateOfLoan, Integer termMonths) {
        if (dateOfLoan != null && termMonths != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateOfLoan);
            calendar.add(Calendar.MONTH, termMonths);
            return calendar.getTime();
        }
        return null;
    }
}
