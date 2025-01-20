package com.example.creditbank.dao;

import com.example.creditbank.model.Address;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressDAO {

    private final JdbcTemplate jdbcTemplate;

    public AddressDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Address> getAllAddresses() {
        String sql = "SELECT * FROM address";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Address.class));
    }

    public List<Address> getAllAddressesSorted(String sortBy) {
        String sql = "SELECT * FROM address";
        if (sortBy != null && !sortBy.isEmpty()) {
            sql += " ORDER BY " + sortBy;
        }
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Address.class));
    }

    public Address getAddressById(Long id) {
        String sql = "SELECT * FROM address WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Address.class), id);
    }

    public void saveAddress(Address address) {
        String sql = "INSERT INTO address (street, city, zip_code) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, address.getStreet(), address.getCity(), address.getZipCode());
    }

    public void updateAddress(Address address) {
        String sql = "UPDATE address SET street = ?, city = ?, zip_code = ? WHERE id = ?";
        jdbcTemplate.update(sql, address.getStreet(), address.getCity(), address.getZipCode(), address.getId());
    }

    public void deleteAddress(Long id) {
        String sql = "DELETE FROM address WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
