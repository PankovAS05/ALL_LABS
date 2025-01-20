package com.example.creditbank.dao;

import com.example.creditbank.model.Credit;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CreditDAO {

    private final JdbcTemplate jdbcTemplate;

    public CreditDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Credit> getAllCredits() {
        String sql = "SELECT * FROM credit";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Credit.class));
    }

    public List<Credit> getAllCreditsSorted(String sortBy) {
        String sql = "SELECT * FROM credit";
        if (sortBy != null && !sortBy.isEmpty()) {
            sql += " ORDER BY " + sortBy;
        }
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Credit.class));
    }

    public Credit getCreditById(Long id) {
        String sql = "SELECT * FROM credit WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Credit.class), id);
    }

    public void saveCredit(Credit credit) {
        String sql = "INSERT INTO credit (type, sum, date_of_loan, term_months, client_id, account_id) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, credit.getType(), credit.getSum(), credit.getDateOfLoan(), credit.getTermMonths(), credit.getClientId(), credit.getAccountId());
    }

    public void updateCredit(Credit credit) {
        String sql = "UPDATE credit SET type = ?, sum = ?, date_of_loan = ?, term_months = ?, client_id = ?, account_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, credit.getType(), credit.getSum(), credit.getDateOfLoan(), credit.getTermMonths(), credit.getClientId(), credit.getAccountId(), credit.getId());
    }

    public void deleteCredit(Long id) {
        String sql = "DELETE FROM credit WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
