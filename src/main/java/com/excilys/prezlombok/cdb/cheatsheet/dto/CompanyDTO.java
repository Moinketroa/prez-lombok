package com.excilys.prezlombok.cdb.cheatsheet.dto;

import java.util.Objects;

public class CompanyDTO {
    private Integer id;
    private final String name;

    public CompanyDTO(String name) {
        this.name = name;
    }

    public CompanyDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public static CompanyDTOBuilder builder() {
        return new CompanyDTOBuilder();
    }

    @Override
    public String toString() {
        return "CompanyDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyDTO company = (CompanyDTO) o;
        return id.equals(company.id) &&
                Objects.equals(name, company.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public static class CompanyDTOBuilder {
        private Integer id;
        private String name;

        public CompanyDTOBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public CompanyDTOBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CompanyDTO build() {
            CompanyDTO result = new CompanyDTO(this.name);

            result.setId(this.id);

            return result;
        }
    }
}
