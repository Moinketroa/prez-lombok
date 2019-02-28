package com.excilys.prezlombok.cdb.cheatsheet.web.rest;

import com.excilys.prezlombok.cdb.cheatsheet.dto.CompanyDTO;
import com.excilys.prezlombok.cdb.cheatsheet.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(@Autowired CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping()
    @ResponseBody
    public List<CompanyDTO> getCompanies() {
        return companyService.findAll();
    }

    @GetMapping(value = "/{companyId}")
    @ResponseBody
    public CompanyDTO getCompanyById(@PathVariable(value = "companyId") Integer companyId) {
        return companyService.findById(companyId);
    }

    @PostMapping()
    @ResponseBody
    public CompanyDTO createCompany(@RequestBody CompanyDTO companyDTO) {
        return companyService.create(companyDTO);
    }

}
