package com.example.transactionaldemo.service;

import com.example.transactionaldemo.dto.CustomerInfoRequest;
import com.example.transactionaldemo.entity.Customer;
import com.example.transactionaldemo.entity.PaymentInfo;
import com.example.transactionaldemo.repository.CustomerRepository;
import com.example.transactionaldemo.repository.PaymentInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public Customer saveCustomerInfo(CustomerInfoRequest infoRequest) throws SQLException {
        Customer customer = Customer.builder()
                .firstName(infoRequest.getFirstName())
                .lastName(infoRequest.getLastName())
                .build();
        Customer savedCustomer = customerRepository.save(customer);
        savePaymentInfo(savedCustomer.getCustomerId(), infoRequest);
        return savedCustomer;
    }

    private void savePaymentInfo(Long customerId, CustomerInfoRequest infoRequest) throws SQLException {
//        throw new SQLException("Failed to execute sql statement");
        PaymentInfo paymentInfo = PaymentInfo.builder()
                .customerId(customerId)
                .cardNumber(infoRequest.getCardNumber())
                .build();
        paymentInfoRepository.save(paymentInfo);
    }
}
