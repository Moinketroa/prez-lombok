package com.excilys.prezlombok.cdb.cheatsheet.repository;

import com.excilys.prezlombok.cdb.model.Computer;
import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.var;
import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

@Repository
@AllArgsConstructor
public class ComputerRepository {

    private final Properties properties;

    private String getPath() {
        return properties.getProperty("computer-path");
    }

    private Integer getRandomNumber() {
        return new Random().nextInt();
    }

    @SneakyThrows
    @SuppressWarnings({"unchecked", "UnnecessaryLocalVariable"})
    public List<Computer> findAll() {
        @Cleanup FileInputStream fileIn = new FileInputStream(getPath());
        @Cleanup ObjectInputStream objectIn = new ObjectInputStream(fileIn);

        var computerList = (ArrayList<Computer>) objectIn.readObject();

        return computerList;
    }

    public Computer findOneById(Integer computerId) {
        var allComputers = findAll();

        Optional<Computer> computerFound = allComputers.stream()
                .filter(computer -> computerId.equals(computer.getId()))
                .findFirst();

        if (computerFound.isPresent())
            return computerFound.get();
        else
            throw new NullPointerException();
    }

    @SneakyThrows
    public Computer persist(Computer computerToCreate) {
        computerToCreate.setId(getRandomNumber());

        var allComputers = findAll();
        allComputers.add(computerToCreate);

        @Cleanup FileOutputStream fileOut = new FileOutputStream(getPath());
        @Cleanup ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

        objectOut.writeObject(allComputers);

        return computerToCreate;
    }
}
