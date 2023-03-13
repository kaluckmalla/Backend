package com.bitskraft.bankaccountmock.Advice;

import com.bitskraft.bankaccountmock.customerexception.AccountNotFound;
import com.bitskraft.bankaccountmock.customerexception.AccountTypeAlreadyExist;
import com.bitskraft.bankaccountmock.customerexception.CustomerPhoneAlreadyExist;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice

public class GlobalCustomerAccountException {
    @ExceptionHandler(AccountTypeAlreadyExist.class)
    @ResponseStatus(HttpStatus.OK)

    public @ResponseBody ExceptionMessage accountTypeAlreadyExist(AccountTypeAlreadyExist accountTypeAlreadyExist){

        return new ExceptionMessage(HttpStatus.CONFLICT.toString(), accountTypeAlreadyExist.getMessage());
    }
    @ExceptionHandler(AccountNotFound.class)
    @ResponseStatus(HttpStatus.OK)

    public @ResponseBody ExceptionMessage accountNotFound(AccountNotFound accountNotFound){

        return new ExceptionMessage(HttpStatus.NOT_FOUND.toString(), accountNotFound.getMessage());
    }



    //Customer Account validation
}
