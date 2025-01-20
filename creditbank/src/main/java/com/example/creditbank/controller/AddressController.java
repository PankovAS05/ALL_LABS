package com.example.creditbank.controller;

import com.example.creditbank.model.Address;
import com.example.creditbank.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public String listAddresses(Model model) {
        List<Address> addresses = addressService.getAllAddresses();
        model.addAttribute("addresses", addresses);
        return "addresses";
    }

    @GetMapping("/sorted")
    public String listSortedAddresses(@RequestParam(required = false) String sortBy, Model model) {
        List<Address> addresses = addressService.getAllAddressesSorted(sortBy);
        model.addAttribute("addresses", addresses);
        return "addresses";
    }

    @GetMapping("/{id}")
    public String viewAddress(@PathVariable Long id, Model model) {
        Address address = addressService.getAddressById(id);
        model.addAttribute("address", address);
        return "address";
    }

    @GetMapping("/new")
    public String createAddressForm(Model model) {
        model.addAttribute("address", new Address());
        return "address_form";
    }

    @PostMapping
    public String saveAddress(@ModelAttribute Address address) {
        if (address.getId() == null) {
            addressService.saveAddress(address);
        } else {
            addressService.updateAddress(address);
        }
        return "redirect:/addresses";
    }

    @GetMapping("/edit/{id}")
    public String editAddressForm(@PathVariable Long id, Model model) {
        Address address = addressService.getAddressById(id);
        model.addAttribute("address", address);
        return "address_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
        return "redirect:/addresses";
    }
}
