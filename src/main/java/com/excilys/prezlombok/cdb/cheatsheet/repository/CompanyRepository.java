package com.excilys.prezlombok.cdb.cheatsheet.repository;

import com.excilys.prezlombok.cdb.model.Company;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.*;

@Repository
public class CompanyRepository {
    private final static Logger LOGGER = LoggerFactory.getLogger(CompanyRepository.class);

    private final Properties properties;

    public CompanyRepository(@Autowired Properties properties) {
        this.properties = properties;
    }

    private String getPath() {
        return properties.getProperty("company-path");
    }

    private Integer getRandomNumber() {
        return new Random().nextInt();
    }

    @SuppressWarnings({"Duplicates", "unchecked", "UnnecessaryLocalVariable"})
    public List<Company> findAll() {
        LOGGER.debug("Find All !");

        try (   FileInputStream fileIn = new FileInputStream(getPath());
                ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            List<Company> companyList = (ArrayList<Company>) objectIn.readObject();

            return companyList;
        } catch (IOException | ClassNotFoundException e) {
            throw new NullPointerException();
        }
    }

    @SuppressWarnings("Duplicates")
    public Company findOneById(Integer companyId) {
        LOGGER.debug("Find One By Id !");

        List<Company> allCompanies = findAll();

        Optional<Company> companyFound = allCompanies.stream()
                .filter(company -> companyId.equals(company.getId()))
                .findFirst();

        if (companyFound.isPresent())
            return companyFound.get();
        else
            throw new NullPointerException("Object company not found");
    }

    @SuppressWarnings("Duplicates")
    public Company persist(Company companyToCreate) {
        LOGGER.debug("Persisting !");

        companyToCreate.setId(getRandomNumber());

        List<Company> allCompanies = findAll();
        allCompanies.add(companyToCreate);

        try (FileOutputStream fileOut = new FileOutputStream(getPath());
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            objectOut.writeObject(allCompanies);

            return companyToCreate;
        } catch (IOException e) {
            throw new NullPointerException();
        }
    }

}
