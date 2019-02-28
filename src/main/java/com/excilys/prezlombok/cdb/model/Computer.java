package com.excilys.prezlombok.cdb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class Computer implements Serializable {
    private static final long serialVersionUID = 4242L;

    private Integer id;
    private final String name;
    private final LocalDate introduced;
    private final LocalDate discontinued;
    private final Company company;
}
