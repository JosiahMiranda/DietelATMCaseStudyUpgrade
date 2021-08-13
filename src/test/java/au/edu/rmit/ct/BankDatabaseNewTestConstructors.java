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

import java.io.Console;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BankDatabaseNewTestConstructors {
	
	static ArrayList<CustomerAccount> seedCustomers;
	static CustomerAccount customer1;
	static CustomerAccount customer2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		seedCustomers = new ArrayList<CustomerAccount>();
		customer1 = new CustomerAccount(1, 1234, 10.0, 100.0, "Family", "Given", 875);
		customer2 = new CustomerAccount(2, 2345, 10.0, 100.0, "Family2", "Given2", 111);
		seedCustomers.add(customer1);
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	// Default Constructor Tests.
	
	@Test
	@DisplayName("1. Test that Default Constructor throws Exception when trying to clear.")
	void testDefaultConstructorThrowsExceptionOnClear() {
		BankDatabaseNew bankDatabase = new BankDatabaseNew();
		assertThrows(Exception.class, () -> {
			bankDatabase.clear();
		});
	}
	
	@Test
	@DisplayName("2. Test that a new database with default constructor is empty.")
	void testDefaultConstructorIsEmpty() {
		BankDatabaseNew bankDatabase = new BankDatabaseNew();
		assertTrue(bankDatabase.isEmpty());
	}
	
	@Test
	@DisplayName("3. Test that a new Database made from default constructor is Size 0.")
	void testDefaultConstructorIsSizeZero() {
		BankDatabaseNew bankDatabase = new BankDatabaseNew();
		assertEquals(0, bankDatabase.size());
	}
	
	// Parameterized Constructor Tests.
	
	@Test
	@DisplayName("4. Test that a new Database made from parameterized constructor is not Empty.")
	void testSeededCustomerConstructorIsNotEmpty() throws Exception {
		BankDatabaseNew bankDatabase = new BankDatabaseNew(seedCustomers);
		assertFalse(bankDatabase.isEmpty());
	}
	
	@Test
	@DisplayName("5. Test that a new Database made from parameterized constructor is Size 1")
	void testSeededCustomerConstructorIsSizeOne() throws Exception {
		BankDatabaseNew bankDatabase = new BankDatabaseNew(seedCustomers);
		assertEquals(1, bankDatabase.size());
	}
	
	@Test
	@DisplayName("6. Test that parameterized constructor will throw Exception when seeded customers is empty")
	void testSeededCustomerConstructorWithEmptyCustomersThrowsException() throws Exception {
		assertThrows(Exception.class, () -> {
			BankDatabaseNew bankDatabase = new BankDatabaseNew(new ArrayList<CustomerAccount>());
		});
	}
	
	@Test
	@DisplayName("7. Test that a new Database made from parameterized constructor will authenticate an existing user")
	void testSeededCustomerConstructorWillAuthenticateExistingCustomer() throws Exception {
		BankDatabaseNew bankDatabase = new BankDatabaseNew(seedCustomers);
		assertTrue(bankDatabase.authenticateUser(1, 1234));
	}
	
	// Customer Add tests
	
	@Test
	@DisplayName("7. Test that adding a Customer to a new, blank database will make the size equal to one.")
	void testBankDatabaseSizeEqualsOneAfterAddCustomer() throws Exception {
		BankDatabaseNew bankDatabase = new BankDatabaseNew();
		bankDatabase.add(customer1);
		assertEquals(1, bankDatabase.size());
		
	}
	
	@Test
	@DisplayName("8. Test that adding a new customer to a database with one existing customer will equal to two.")
	void testBankDatabaseSizeEqualsTwoAfterAddCustomerToExistingDatabase() throws Exception {
		BankDatabaseNew bankDatabase = new BankDatabaseNew(seedCustomers);
		bankDatabase.add(customer2);
		assertEquals(2, bankDatabase.size());
		
	}
	
	@Test
	@DisplayName("9. Test that adding a customer to a new, blank database will make isEmpty() assert to false.")
	void testAddCustomerToNewBlankDatabaseIsNotEmpty() throws Exception {
		BankDatabaseNew bankDatabase = new BankDatabaseNew();
		bankDatabase.add(customer1);
		assertFalse(bankDatabase.isEmpty());
		
	}
	
	@Test
	@DisplayName("10. Test that add Customer will throw an exception when adding an existing customer.")
	void testSeededCustomerDatabaseThrowsExceptionWhenAddExistingCustomer() throws Exception {
		BankDatabaseNew bankDatabase = new BankDatabaseNew(seedCustomers);
		assertThrows(Exception.class, () -> {
			bankDatabase.add(customer1);
		});
		
	}

}
