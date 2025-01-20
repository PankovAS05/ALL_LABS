package com.example.creditbank.service;

import com.example.creditbank.dao.CreditDAO;
import com.example.creditbank.model.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditService {

    @Autowired
    private CreditDAO creditDAO;

    public List<Credit> getAllCredits() {
        return creditDAO.getAllCredits();
    }

    public List<Credit> getAllCreditsSorted(String sortBy) {
        return creditDAO.getAllCreditsSorted(sortBy);
    }

    public Credit getCreditById(Long id) {
        return creditDAO.getCreditById(id);
    }

    public void saveCredit(Credit credit) {
        creditDAO.saveCredit(credit);
    }

    public void updateCredit(Credit credit) {
        creditDAO.updateCredit(credit);
    }

    public void deleteCredit(Long id) {
        creditDAO.deleteCredit(id);
    }
}
