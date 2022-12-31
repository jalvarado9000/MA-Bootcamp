package com.techelevator.auctions.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class ExceptionHandler1 extends Exception{
    public ExceptionHandler1(String msg){
        super(msg);
    }



}
