package com.excilys.prezlombok.cdb.cheatsheet.service;

import com.excilys.prezlombok.cdb.cheatsheet.dto.CompanyDTO;
import com.excilys.prezlombok.cdb.cheatsheet.mapper.request.CompanyMapper;
import com.excilys.prezlombok.cdb.cheatsheet.mapper.response.CompanyDTOMapper;
import com.excilys.prezlombok.cdb.model.Company;
import com.excilys.prezlombok.cdb.cheatsheet.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final CompanyDTOMapper companyDTOMapper;

    public CompanyService(@Autowired CompanyRepository companyRepository,
                          @Autowired CompanyMapper companyMapper,
                          @Autowired CompanyDTOMapper companyDTOMapper) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
        this.companyDTOMapper = companyDTOMapper;
    }

    public CompanyDTO create(CompanyDTO companyDTO) {
        Company companyToCreate = companyMapper.map(companyDTO);
        Company companyCreated = companyRepository.persist(companyToCreate);
        return companyDTOMapper.map(companyCreated);
    }

    public CompanyDTO findById(Integer companyId) {
        Company companyFound = companyRepository.findOneById(companyId);
        return companyDTOMapper.map(companyFound);
    }

    public List<CompanyDTO> findAll() {
        List<Company> companiesFound = companyRepository.findAll();
        return companyDTOMapper.mapSeveral(companiesFound);
    }
}
