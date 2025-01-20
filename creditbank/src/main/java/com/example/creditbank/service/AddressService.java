package com.example.creditbank.service;

import com.example.creditbank.dao.AddressDAO;
import com.example.creditbank.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressDAO addressDAO;

    public List<Address> getAllAddresses() {
        return addressDAO.getAllAddresses();
    }

    public List<Address> getAllAddressesSorted(String sortBy) {
        return addressDAO.getAllAddressesSorted(sortBy);
    }

    public Address getAddressById(Long id) {
        return addressDAO.getAddressById(id);
    }

    public void saveAddress(Address address) {
        addressDAO.saveAddress(address);
    }

    public void updateAddress(Address address) {
        addressDAO.updateAddress(address);
    }

    public void deleteAddress(Long id) {
        addressDAO.deleteAddress(id);
    }
}
