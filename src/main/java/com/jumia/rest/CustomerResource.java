package com.jumia.rest;

import com.jumia.exception.BadRequestException;
import com.jumia.exception.NoContentException;
import com.jumia.model.CustomerDTO;
import com.jumia.model.CustomerSearchRequestDTO;
import com.jumia.service.CustomerService;
import com.jumia.util.GeneralUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/jumia/services")
@ApiOperation(value = "Management Customers Jumia Phone Service")
public class CustomerResource {
    @Autowired
    private CustomerService customerService;
    Logger logger = LoggerFactory.getLogger(CustomerResource.class);
//, params = {"billingAcctId"}
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity<?> getAllPhoneNumbers() throws NoContentException {
        String methodName = "getAllPhoneNumbers";
        logger.info(methodName);
        List<CustomerDTO> customerDTOList = customerService.getAllPhoneNumbers();
        if (GeneralUtil.isEmptyList(customerDTOList)) {
            logger.info("Throw NoContentException : No phone numbers found");
            throw new NoContentException("No phone numbers found");
        }
        logger.info(methodName);
        return ResponseEntity.ok().body(customerDTOList);
    }

    @PostMapping("/customers/search")
    public ResponseEntity<?> getPhoneNumbersByUserFilter(@RequestBody CustomerSearchRequestDTO customerSearchRequestDTO) throws BadRequestException, NoContentException {
        String methodName = "getPhoneNumbersByUserFilter";
        logger.info(methodName);

        //Validation
        if (customerSearchRequestDTO == null ||
                ( GeneralUtil.isEmptyString(customerSearchRequestDTO.getCountry())
                        && customerSearchRequestDTO.getValid()==null)) {
            throw new BadRequestException("please enter at least on search criteria");
        }
        boolean valid = customerSearchRequestDTO.getValid()!=null? customerSearchRequestDTO.getValid().booleanValue() : false;
        String countryName = customerSearchRequestDTO.getCountry();
        List<CustomerDTO> customerDTOList = customerService.getPhoneNumbersByUserFilter(valid, countryName);
        if (GeneralUtil.isEmptyList(customerDTOList)) {
            logger.info("Throw NoContentException : No phone numbers found");
            throw new NoContentException("No phone numbers found");
        }
        return ResponseEntity.ok().body(customerDTOList);
    }
}
