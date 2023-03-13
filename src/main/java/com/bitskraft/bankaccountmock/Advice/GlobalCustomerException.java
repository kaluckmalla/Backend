package com.bitskraft.bankaccountmock.Advice;

import com.bitskraft.bankaccountmock.customerexception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalCustomerException {
    @ExceptionHandler(CustomerPhoneAlreadyExist.class)
    @ResponseStatus(HttpStatus.OK)

    public @ResponseBody ExceptionMessage CustomerPhoneAlreadyExist(CustomerPhoneAlreadyExist customerPhoneAlreadyExist){

        return new ExceptionMessage(HttpStatus.CONFLICT.toString(), customerPhoneAlreadyExist.getMessage());
    }
    @ExceptionHandler(CustomerEmailAlreadyExist.class)
    @ResponseStatus(HttpStatus.OK)

    public @ResponseBody ExceptionMessage CustomerEmailAlreadyExist(CustomerEmailAlreadyExist customerEmailAlreadyExist){

        return new ExceptionMessage(HttpStatus.CONFLICT.toString(), customerEmailAlreadyExist.getMessage());
    }
    @ExceptionHandler(CustomerDateOfBirthNotValid.class)
    @ResponseStatus(HttpStatus.OK)

    public @ResponseBody ExceptionMessage customerDateOfBirthNotValid(CustomerDateOfBirthNotValid customerDateOfBirthNotValid){

        return new ExceptionMessage(HttpStatus.NOT_ACCEPTABLE.toString(), customerDateOfBirthNotValid.getMessage());
    }

    @ExceptionHandler(CustomerNotFound.class)
    @ResponseStatus(HttpStatus.OK)

    public @ResponseBody ExceptionMessage customerNotFound(CustomerNotFound customerNotFound){

        return new ExceptionMessage(HttpStatus.NOT_FOUND.toString(), customerNotFound.getMessage());
    }



    @ExceptionHandler(CustomerServerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)

    public @ResponseBody ExceptionMessage customerServerException(CustomerServerException customerServerException){

        return new ExceptionMessage(HttpStatus.INTERNAL_SERVER_ERROR.toString(), customerServerException.getMessage());
    }

    //Customer validation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)

    public @ResponseBody Map<String,String> handleInvalidArgument(MethodArgumentNotValidException validationException){
        Map<String,String> errorMap=new HashMap<>();
        validationException.getBindingResult().getFieldErrors().forEach(error->{
            errorMap.put(error.getField(),error.getDefaultMessage());
        });
        return errorMap;
    }

}
