package com.github.beelencodingacademy.chinook.repositories;

public class Customer {

    private String firstName;
    private String lastName;
    private String company;
    private String address;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String phone;
    private String fax;
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static final class CustomerBuilder {
        private Customer customer;

        private CustomerBuilder() {
            customer = new Customer();
        }

        public static CustomerBuilder aCustomer() {
            return new CustomerBuilder();
        }

        public CustomerBuilder withFirstName(String firstName) {
            customer.setFirstName(firstName);
            return this;
        }

        public CustomerBuilder withLastName(String lastName) {
            customer.setLastName(lastName);
            return this;
        }

        public CustomerBuilder withCompany(String company) {
            customer.setCompany(company);
            return this;
        }

        public CustomerBuilder withAddress(String address) {
            customer.setAddress(address);
            return this;
        }

        public CustomerBuilder withCity(String city) {
            customer.setCity(city);
            return this;
        }

        public CustomerBuilder withState(String state) {
            customer.setState(state);
            return this;
        }

        public CustomerBuilder withCountry(String country) {
            customer.setCountry(country);
            return this;
        }

        public CustomerBuilder withPostalCode(String postalCode) {
            customer.setPostalCode(postalCode);
            return this;
        }

        public CustomerBuilder withPhone(String phone) {
            customer.setPhone(phone);
            return this;
        }

        public CustomerBuilder withFax(String fax) {
            customer.setFax(fax);
            return this;
        }

        public CustomerBuilder withEmail(String email) {
            customer.setEmail(email);
            return this;
        }

        public CustomerBuilder but() {
            return aCustomer().withFirstName(customer.getFirstName()).withLastName(customer.getLastName()).withCompany(customer.getCompany()).withAddress(customer.getAddress()).withCity(customer.getCity()).withState(customer.getState()).withCountry(customer.getCountry()).withPostalCode(customer.getPostalCode()).withPhone(customer.getPhone()).withFax(customer.getFax()).withEmail(customer.getEmail());
        }

        public Customer build() {
            return customer;
        }
    }
}
