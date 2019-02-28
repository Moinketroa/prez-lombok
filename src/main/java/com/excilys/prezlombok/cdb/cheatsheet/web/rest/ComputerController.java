package com.excilys.prezlombok.cdb.cheatsheet.web.rest;

import com.excilys.prezlombok.cdb.cheatsheet.dto.ComputerDTO;
import com.excilys.prezlombok.cdb.cheatsheet.service.ComputerService;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/computers")
@AllArgsConstructor
public class ComputerController {

    private final ComputerService computerService;

    @GetMapping()
    @ResponseBody
    public List<ComputerDTO> getComputers() {
        return computerService.findAll();
    }

    @GetMapping(value = "/{computerId}")
    @ResponseBody
    public ComputerDTO getComputerById(@PathVariable(value = "computerId") Integer computerId) {
        var c = computerService.findById(computerId);
        return c;
    }

    @PostMapping()
    @ResponseBody
    public ComputerDTO getTestData(@RequestBody ComputerDTO computerDTO) {
        return computerService.create(computerDTO);
    }
}
