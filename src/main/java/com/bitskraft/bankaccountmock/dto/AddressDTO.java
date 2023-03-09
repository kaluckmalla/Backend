package com.bitskraft.bankaccountmock.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDTO {
     private int id;
        private int country;
        private String states;
        private String districts;
        private String municipalities;
}
