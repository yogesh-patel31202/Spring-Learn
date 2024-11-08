package com.learn.spring.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenerateResponse<T> {

    private String message;
    private T data;

    public GenerateResponse(String message) {
        this.message = message;
    }
}
