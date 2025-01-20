package com.example.creditbank.controller;

import com.example.creditbank.model.Client;
import com.example.creditbank.service.AddressService;
import com.example.creditbank.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private AddressService addressService;

    @GetMapping
    public String listClients(Model model) {
        List<Client> clients = clientService.getAllClients();
        model.addAttribute("clients", clients);
        return "clients";
    }

    @GetMapping("/sorted")
    public String listSortedClients(@RequestParam(required = false) String sortBy, Model model) {
        List<Client> clients = clientService.getAllClientsSorted(sortBy);
        model.addAttribute("clients", clients);
        return "clients";
    }

    @GetMapping("/{id}")
    public String viewClient(@PathVariable Long id, Model model) {
        Client client = clientService.getClientById(id);
        model.addAttribute("client", client);
        return "client";
    }

    @GetMapping("/new")
    public String createClientForm(Model model) {
        model.addAttribute("client", new Client());
        model.addAttribute("addresses", addressService.getAllAddresses());
        return "client_form";
    }

    @PostMapping
    public String saveClient(@ModelAttribute Client client) {
        if (client.getId() == null) {
            clientService.saveClient(client);
        } else {
            clientService.updateClient(client);
        }
        return "redirect:/clients";
    }

    @GetMapping("/edit/{id}")
    public String editClientForm(@PathVariable Long id, Model model) {
        Client client = clientService.getClientById(id);
        model.addAttribute("client", client);
        model.addAttribute("addresses", addressService.getAllAddresses());
        return "client_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return "redirect:/clients";
    }
}
