package com.bitskraft.bankaccountmock.dto;

import lombok.*;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CountryDTO {
    private String id;
    private String name;
    private List<StatesDTO> states;
}
