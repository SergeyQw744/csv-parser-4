package org.example.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Person {
    private int id;
    private String name;
    private String gender;
    private Date birthDate;
    private Division division;
    private BigDecimal salary;

    public static class Builder {
        private int id;
        private String name;
        private String gender;
        private Date birthDate;
        private Division division;
        private BigDecimal salary;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder setBirthDate(Date birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder setDivision(Division division) {
            this.division = division;
            return this;
        }

        public Builder setSalary(BigDecimal salary) {
            this.salary = salary;
            return this;
        }

        // Метод для создания экземпляра Person
        public Person build() {
            return new Person(this);
        }
    }

    private Person(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.gender = builder.gender;
        this.birthDate = builder.birthDate;
        this.division = builder.division;
        this.salary = builder.salary;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
