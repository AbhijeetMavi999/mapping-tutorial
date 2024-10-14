package com.orm.service;

import com.orm.entity.Address;

import java.util.List;

public interface AddressService {

    Address saveAddress(Address address);

    List<Address> getAllAddresses();

    Address getAddressById(Integer addressId);

    void deleteAddress(Integer addressId);
}
