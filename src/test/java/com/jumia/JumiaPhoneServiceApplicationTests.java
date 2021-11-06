package com.jumia;

import com.jumia.entity.Customer;
import com.jumia.repository.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class JumiaPhoneServiceApplicationTests {
	@Autowired
	private CustomerRepository customerRepository;

	@Test
	@Order(1)
	public void getCustomerTest(){
		Customer customer = customerRepository.findById(0L).get();
		System.out.println("Test2 getCustomerTest");
		Assertions.assertThat(customer.getId()).isEqualTo(0L);
	}

	@Test
	@Order(2)
	public void getListOfCustomersTest(){
		List<Customer> customersList = customerRepository.findAll();
		System.out.println("Test2 getListOfCustomersTest");
		Assertions.assertThat(customersList.size()).isGreaterThan(0);
	}
	@Test
	void contextLoads() {
		System.out.println("Hello Test");
	}

}
