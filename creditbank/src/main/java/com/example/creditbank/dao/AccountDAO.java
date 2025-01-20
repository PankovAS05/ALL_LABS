package com.example.creditbank.dao;

import com.example.creditbank.model.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDAO {

    private final JdbcTemplate jdbcTemplate;

    public AccountDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Account> getAllAccounts() {
        String sql = "SELECT * FROM account";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Account.class));
    }

    public List<Account> getAllAccountsSorted(String sortBy) {
        String sql = "SELECT * FROM account";
        if (sortBy != null && !sortBy.isEmpty()) {
            sql += " ORDER BY " + sortBy;
        }
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Account.class));
    }

    public Account getAccountById(Long id) {
        String sql = "SELECT * FROM account WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), id);
    }

    public void saveAccount(Account account) {
        String sql = "INSERT INTO account (balance, client_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, account.getBalance(), account.getClientId());
    }

    public void updateAccount(Account account) {
        String sql = "UPDATE account SET balance = ?, client_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, account.getBalance(), account.getClientId(), account.getId());
    }

    public void deleteAccount(Long id) {
        String sql = "DELETE FROM account WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
