package com.excilys.prezlombok.cdb.cheatsheet.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class ComputerDTO {
    private Integer id;
    private String name;
    private LocalDate introduced;
    private LocalDate discontinued;
    private CompanyDTO companyDTO;
}
