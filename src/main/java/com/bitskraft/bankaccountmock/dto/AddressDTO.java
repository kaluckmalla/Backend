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
        private List<CountryDTO> name;
        private List<StatesDTO> states;
        private List<DistrictDTO> districts;
        private List<MunicipalityDTO> municipalities;
}
