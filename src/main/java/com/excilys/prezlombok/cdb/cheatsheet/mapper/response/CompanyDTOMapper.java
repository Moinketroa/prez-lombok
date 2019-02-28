package com.excilys.prezlombok.cdb.cheatsheet.mapper.response;

import com.excilys.prezlombok.cdb.cheatsheet.dto.CompanyDTO;
import com.excilys.prezlombok.cdb.cheatsheet.mapper.Mapper;
import com.excilys.prezlombok.cdb.model.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyDTOMapper implements Mapper<Company, CompanyDTO> {
    @Override
    public CompanyDTO map(Company input) {
        return CompanyDTO.builder()
                .id(input.getId())
                .name(input.getName())
                .build();
    }
}
