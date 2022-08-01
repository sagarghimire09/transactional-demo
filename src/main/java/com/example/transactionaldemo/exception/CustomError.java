package com.example.transactionaldemo.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomError {
    private Integer status;
    private String message;
    private Timestamp timestamp;
}
