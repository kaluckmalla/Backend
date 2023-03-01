package com.bitskraft.bankaccountmock.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MunicipalityDTO {
    private int id;
    private String name;
    private String type;
}
