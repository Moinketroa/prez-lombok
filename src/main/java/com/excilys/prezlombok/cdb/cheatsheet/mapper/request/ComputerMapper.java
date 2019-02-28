package com.excilys.prezlombok.cdb.cheatsheet.mapper.request;

import com.excilys.prezlombok.cdb.cheatsheet.dto.ComputerDTO;
import com.excilys.prezlombok.cdb.cheatsheet.mapper.Mapper;
import com.excilys.prezlombok.cdb.model.Computer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ComputerMapper implements Mapper<ComputerDTO, Computer> {

    private final CompanyMapper companyMapper;

    @Override
    public Computer map(ComputerDTO input) {
        return Computer.builder()
                .id(input.getId())
                .name(input.getName())
                .introduced(input.getIntroduced())
                .discontinued(input.getDiscontinued())
                .company(companyMapper.map(input.getCompanyDTO()))
                .build();
    }
}
