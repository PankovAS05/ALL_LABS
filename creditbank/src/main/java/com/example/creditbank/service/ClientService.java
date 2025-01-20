package com.example.creditbank.service;

import com.example.creditbank.dao.ClientDAO;
import com.example.creditbank.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientDAO clientDAO;

    public List<Client> getAllClients() {
        return clientDAO.getAllClients();
    }

    public List<Client> getAllClientsSorted(String sortBy) {
        return clientDAO.getAllClientsSorted(sortBy);
    }

    public Client getClientById(Long id) {
        return clientDAO.getClientById(id);
    }

    public void saveClient(Client client) {
        clientDAO.saveClient(client);
    }

    public void updateClient(Client client) {
        clientDAO.updateClient(client);
    }

    @Transactional
    public void deleteClient(Long id) {
        clientDAO.deleteClient(id);
    }
}
