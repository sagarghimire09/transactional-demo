package com.example.transactionaldemo.dto;

import lombok.Data;

@Data
public class CustomerInfoRequest {
    private String firstName;
    private String lastName;
    private String cardNumber;
}
