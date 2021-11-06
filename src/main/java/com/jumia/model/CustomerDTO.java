package com.jumia.model;

import java.io.Serializable;

public class CustomerDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String country;
    private boolean valid;
    private String countryCode;
    private String phone;

    public CustomerDTO() {
    }

    public CustomerDTO(String country, boolean valid, String countryCode, String phone) {
        this.country = country;
        this.valid = valid;
        this.countryCode = countryCode;
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
