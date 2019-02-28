package com.excilys.prezlombok.cdb.cheatsheet.mapper.response;

import com.excilys.prezlombok.cdb.cheatsheet.dto.ComputerDTO;
import com.excilys.prezlombok.cdb.cheatsheet.mapper.Mapper;
import com.excilys.prezlombok.cdb.model.Computer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ComputerDTOMapper implements Mapper<Computer, ComputerDTO> {

    private final CompanyDTOMapper companyDTOMapper;

    @Override
    public ComputerDTO map(Computer input) {
        return ComputerDTO.builder()
                .id(input.getId())
                .name(input.getName())
                .introduced(input.getIntroduced())
                .discontinued(input.getDiscontinued())
                .companyDTO(companyDTOMapper.map(input.getCompany()))
                .build();
    }
}
