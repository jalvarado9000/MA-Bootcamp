package com.techelevator.auctions.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExceptionHandler2 extends Exception{

    public ExceptionHandler2(){
        super(" ");
    }

}
