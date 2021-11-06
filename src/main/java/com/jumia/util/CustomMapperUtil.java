package com.jumia.util;

import com.jumia.entity.Customer;
import com.jumia.enums.CountryEnum;
import com.jumia.model.CustomerDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomMapperUtil {
    public static List<CustomerDTO> mapCustomerEntityToDTO(List<Customer> customerList){
        if(!GeneralUtil.isEmptyList(customerList)){
            List<CustomerDTO>customerDTOList = new ArrayList<>();
            customerList.forEach(customer -> {
                CountryEnum countryEnum = getCountryEnum(customer.getPhone());
                CustomerDTO customerDTO = new CustomerDTO(countryEnum.name(),
                        isPhoneNumberValid(customer.getPhone(), countryEnum.getRegex()),
                        countryEnum.getCode(),customer.getPhone().substring(customer.getPhone().lastIndexOf(") ")+2));
                customerDTOList.add(customerDTO);
            });
            return customerDTOList;
        }
        return null;
    }

    private static CountryEnum getCountryEnum(String phoneNumber){

        String countryCode = "+" + phoneNumber
                .substring(phoneNumber.lastIndexOf("(")+1
                        , phoneNumber.lastIndexOf(")"));
        return CountryEnum.findByCode(countryCode);
    }

    private static boolean isPhoneNumberValid(String phoneNumber, String countryRegex){
        return phoneNumber.matches(countryRegex);
    }

    public static List<CustomerDTO> getValidCustomerDTO(List<CustomerDTO> customerDTOList){
        return customerDTOList.stream().filter( c -> c.isValid()).collect(Collectors.toList());
    }
}
