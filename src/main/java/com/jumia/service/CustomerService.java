package com.jumia.service;

import com.jumia.entity.Customer;
import com.jumia.enums.CountryEnum;
import com.jumia.model.CustomerDTO;
import com.jumia.model.CustomerSearchRequestDTO;
import com.jumia.repository.CustomerRepository;
import com.jumia.rest.CustomerResource;
import com.jumia.util.CustomMapperUtil;
import com.jumia.util.GeneralUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    Logger logger = LoggerFactory.getLogger(CustomerResource.class);

    public List<CustomerDTO> getAllPhoneNumbers(){
        String methodName = "getAllPhoneNumbers";
        logger.info(methodName);
        List<CustomerDTO> customerDTOList=null;
        List<Customer> customerList = customerRepository.findAll();
        if(!GeneralUtil.isEmptyList(customerList)) {
            logger.info(methodName+" Transfer to DTO");
            customerDTOList = CustomMapperUtil.mapCustomerEntityToDTO(customerList);
        }
        return customerDTOList;
    }

    public List<CustomerDTO> getPhoneNumbersByUserFilter(boolean valid, String countryName){
        String methodName = "getPhoneNumbersByUserFilter";
        logger.info(methodName);
        List<CustomerDTO> customerDTOList=null;
        List<Customer> customerList = null;
        logger.info(methodName+" User filters are valid = "+valid+" country = "+countryName);
        String countryCode = "";
        String countryRegx = "";
        CountryEnum countryEnum = null;
        if(!GeneralUtil.isEmptyString(countryName)) {
            countryEnum = CountryEnum.valueOf(countryName);
        }
        if(countryEnum!=null) {
            countryCode = countryEnum.getCode();
            if(!GeneralUtil.isEmptyString( countryCode)) {
                countryCode = "("+countryCode.substring(1)+") %";
            }
            countryRegx = countryEnum.getRegex();
            customerList = customerRepository.findByPhoneLike(countryCode);
//            if(!valid){
//                customerList = customerRepository.findByPhoneLike(countryCode);
//            }else
//                customerList = customerRepository.findByUserFilter(countryCode, countryRegx);
        }
        if(!GeneralUtil.isEmptyList(customerList)) {
            logger.info("Query return "+ customerList.size()+" records");
            customerDTOList = CustomMapperUtil.mapCustomerEntityToDTO(customerList);
            if(valid)
                customerDTOList = CustomMapperUtil.getValidCustomerDTO(customerDTOList);
        }

        return customerDTOList;
    }
}
