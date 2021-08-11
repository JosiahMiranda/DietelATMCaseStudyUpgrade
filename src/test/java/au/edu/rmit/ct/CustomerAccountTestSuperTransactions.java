/**
*  
* Name: John Smith
* Student ID: s45045012
* Email: s45045012@student.rmit.edu.au
* 
* [OPTIONAL: add any notes here about the code]
*/
package au.edu.rmit.ct;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerAccountTestSuperTransactions {
	
	static CustomerAccount customer1;
	static CustomerAccount customer0;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		customer0 = new CustomerAccount(0, 1234, 0, 0, "Given", "Family", 111);
		customer1 = new CustomerAccount(1, 1234, 10.0, 100.0, "Family", "Given", 875);
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	@DisplayName("getTotalBalance of a customer with 100 total balance will return 100.")
	void testCustomerGetTotalBalanceIsCorrect() throws Exception {
		assertEquals(100, customer1.getTotalBalance());
	}
	
	@Test
	@DisplayName("getAvailableBalance of a customer with 10 available balance will return 10.")
	void testCustomerGetAvailableBalanceIsCorrect() throws Exception {
		assertEquals(10, customer1.getAvailableBalance());
	}

	@Test
	@DisplayName("A customer with 0 total balance will have 10 total balance after being credited 10.")
	void testCustomerWithTotalBalanceZeroIncreasesAfterCredit() throws Exception {
		customer0.credit(10);
		assertEquals(10, customer0.getTotalBalance());
	}
	
	@Test
	@DisplayName("A customer with 100 total balance will have 110 total balance after being credited 10.")
	void testCustomerWithTotalBalanceNotZeroIncreasesAfterCredit() throws Exception {
		customer1.credit(10);
		assertEquals(110, customer1.getTotalBalance());
	}
	
	@Test
	@DisplayName("A customer with 0 total balance will have -10 total balance after being debited 10.")
	void testCustomerWithTotalBalanceZeroDecreasesAfterDebit() throws Exception {
		customer0.debit(10);
		assertEquals(-10, customer0.getTotalBalance());
	}
	
	@Test
	@DisplayName("A customer with 0 available balance will have -10 available balance after being debited 10.")
	void testCustomerWithAvailableBalanceZeroDecreasesAfterDebit() throws Exception {
		customer0.debit(10);
		assertEquals(-10, customer0.getAvailableBalance());
	}
	
	@Test
	@DisplayName("A customer with 100 total balance will have 90 total balance after being debited 10.")
	void testCustomerWithTotalBalanceNotZeroDecreasesAfterDebit() throws Exception {
		customer1.debit(10);
		assertEquals(90, customer1.getTotalBalance());
	}
	
	@Test
	@DisplayName("A customer with 10 available balance will have 0 available balance after being debited 10.")
	void testCustomerWithAvailableBalanceNotZeroDecreasesAfterDebit() throws Exception {
		customer1.debit(10);
		assertEquals(0, customer1.getAvailableBalance());
	}
	

}
