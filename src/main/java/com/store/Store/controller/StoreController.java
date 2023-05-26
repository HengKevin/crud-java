package com.store.Store.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.Store.model.Address;
import com.store.Store.repository.MySqlRepository;

@RestController
public class StoreController {

    @Autowired
    MySqlRepository mySqlRepository;

    @GetMapping("/addresses")
    public List<Address> getAllAddresses() {

        return mySqlRepository.findAll();
    }

    @GetMapping("/address/{identity}")
    public Address getAddressById(@PathVariable("identity") Integer id) {

        return mySqlRepository.findById(id).get();
    }

    @DeleteMapping("/address/{identity}")
    public boolean deleteRow(@PathVariable("identity") Integer id) {
        if (!mySqlRepository.findById(id).equals(Optional.empty())) {
            mySqlRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @PutMapping("/address/{identity}")
    public Address updateRow(@PathVariable("identity") Integer id,
            @RequestBody Map<String, String> body) {
        Address current = mySqlRepository.findById(id).get();
        current.setStreet(body.get("street"));
        current.setNumber(Integer.parseInt(body.get("number")));
        current.setPostcode(body.get("postcode"));
        mySqlRepository.save(current);
        return current;
    }

    @PostMapping("/add")
    public Address create(@RequestBody Map<String, String> body) {
        String street = body.get("street");
        String postcode = body.get("postcode");
        Integer number = Integer.parseInt(body.get("number"));
        Address newAddress = new Address(number, street, postcode);

        return mySqlRepository.save(newAddress);
    }
}
