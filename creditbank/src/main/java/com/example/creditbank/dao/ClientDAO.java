package com.example.creditbank.dao;

import com.example.creditbank.model.Client;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ClientDAO {

    private final JdbcTemplate jdbcTemplate;

    public ClientDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Client> getAllClients() {
        String sql = "SELECT * FROM client";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Client.class));
    }

    public List<Client> getAllClientsSorted(String sortBy) {
        String sql = "SELECT * FROM client";
        if (sortBy != null && !sortBy.isEmpty()) {
            sql += " ORDER BY " + sortBy;
        }
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Client.class));
    }

    public Client getClientById(Long id) {
        String sql = "SELECT * FROM client WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Client.class), id);
    }

    public void saveClient(Client client) {
        String sql = "INSERT INTO client (fio, address_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, client.getFio(), client.getAddressId());
    }

    public void updateClient(Client client) {
        String sql = "UPDATE client SET fio = ?, address_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, client.getFio(), client.getAddressId(), client.getId());
    }

    @Transactional
    public void deleteClient(Long id) {
        // Удаление кредитов клиента
        String deleteCreditSql = "DELETE FROM credit WHERE client_id = ?";
        jdbcTemplate.update(deleteCreditSql, id);

        // Удаление счета клиента
        String deleteAccountSql = "DELETE FROM account WHERE client_id = ?";
        jdbcTemplate.update(deleteAccountSql, id);

        // Удаление клиента
        String deleteClientSql = "DELETE FROM client WHERE id = ?";
        jdbcTemplate.update(deleteClientSql, id);
    }
}
