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
public class DistrictDTO {
    private int id;
    private String name;
    private List<MunicipalityDTO> municipalities;
}
