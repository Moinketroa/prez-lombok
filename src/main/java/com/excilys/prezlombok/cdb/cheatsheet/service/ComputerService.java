package com.excilys.prezlombok.cdb.cheatsheet.service;

import com.excilys.prezlombok.cdb.cheatsheet.dto.ComputerDTO;
import com.excilys.prezlombok.cdb.cheatsheet.mapper.request.ComputerMapper;
import com.excilys.prezlombok.cdb.cheatsheet.mapper.response.ComputerDTOMapper;
import com.excilys.prezlombok.cdb.model.Computer;
import com.excilys.prezlombok.cdb.cheatsheet.repository.ComputerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ComputerService {

    private final ComputerRepository computerRepository;
    private final ComputerMapper computerMapper;
    private final ComputerDTOMapper computerDTOMapper;

    public ComputerDTO create(ComputerDTO computerDTO) {
        Computer computerToCreate = computerMapper.map(computerDTO);
        Computer computerCreated = computerRepository.persist(computerToCreate);
        return computerDTOMapper.map(computerCreated);
    }

    public ComputerDTO findById(Integer computerId) {
        Computer computerFound = computerRepository.findOneById(computerId);
        return computerDTOMapper.map(computerFound);
    }

    public List<ComputerDTO> findAll() {
        List<Computer> computersFound = computerRepository.findAll();
        return computerDTOMapper.mapSeveral(computersFound);
    }
}
