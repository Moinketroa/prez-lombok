package com.excilys.prezlombok.cdb.cheatsheet.mapper.request;

import com.excilys.prezlombok.cdb.cheatsheet.dto.CompanyDTO;
import com.excilys.prezlombok.cdb.cheatsheet.mapper.Mapper;
import com.excilys.prezlombok.cdb.model.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper implements Mapper<CompanyDTO, Company> {
    @Override
    public Company map(CompanyDTO input) {
        return Company.builder()
                .id(input.getId())
                .name(input.getName())
                .build();
    }
}
