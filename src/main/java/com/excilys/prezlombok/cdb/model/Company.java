package com.excilys.prezlombok.cdb.model;

import java.io.Serializable;
import java.util.Objects;

public class Company implements Serializable {
    private static final long serialVersionUID = 2424L;

    private Integer id;
    private final String name;

    public Company(String name) {
        this.name = name;
    }

    public Company(Integer id, String name) {
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

    public static CompanyBuilder builder() {
        return new CompanyBuilder();
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return id.equals(company.id) &&
                Objects.equals(name, company.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public static class CompanyBuilder {
        private Integer id;
        private String name;

        public CompanyBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public CompanyBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Company build() {
            Company result = new Company(this.name);

            result.setId(this.id);

            return result;
        }
    }
}
