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

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BankDatabaseNewTestSorting {
	
	// every test has a manually checked expected result list that
	// is accounted for, for each and every one of the following static variables.
	
	// Customers for total balance tests and first BSB test.
	static CustomerAccount customer1;
	static CustomerAccount customer2;
	static CustomerAccount customer3;
	static CustomerAccount customer4;
	static CustomerAccount customer5;
	static CustomerAccount customer6;
	static CustomerAccount customer7;
	static CustomerAccount customer8;
	static CustomerAccount customer9;
	static CustomerAccount customer10;
	static CustomerAccount customer11;
	static CustomerAccount customer12;
	static CustomerAccount customer13;
	
	// Customers for remaining BSB tests.
	
	static CustomerAccount sameBSBCustomer1;
	static CustomerAccount sameBSBCustomer2;
	static CustomerAccount sameBSBCustomer3;
	static CustomerAccount sameBSBCustomer4;
	static CustomerAccount sameBSBCustomer5;
	static CustomerAccount sameBSBCustomer6;
	static CustomerAccount sameBSBCustomer7;
	static CustomerAccount sameBSBCustomer8;
	static CustomerAccount sameBSBCustomer9;
	static CustomerAccount sameBSBCustomer10;
	
	static CustomerAccount sameFamilyNameCustomer1;
	static CustomerAccount sameFamilyNameCustomer2;
	static CustomerAccount sameFamilyNameCustomer3;
	static CustomerAccount sameFamilyNameCustomer4;
	static CustomerAccount sameFamilyNameCustomer5;
	static CustomerAccount sameFamilyNameCustomer6;
	static CustomerAccount sameFamilyNameCustomer7;
	static CustomerAccount sameFamilyNameCustomer8;
	static CustomerAccount sameFamilyNameCustomer9;
	static CustomerAccount sameFamilyNameCustomer10;
	
	
	
	// Lists that have the expected sorted results for each test, that we compare to
	// check if the sorting methods worked as expected.
	// if the sorted list equals to the respected, checked sorted list below,
	// then assertEquals for that true will return true and the test will pass.
	
	static ArrayList<CustomerAccount> sortedByTotalBalanceAllDifferentValues;
	static ArrayList<CustomerAccount> sortedByTotalBalanceSomeSameValues;
	static ArrayList<CustomerAccount> sortedByBSBAllDifferentBSBAndFamilyNames;
	static ArrayList<CustomerAccount> sortedByBSBAllSameBSBAndDifferentFamilyNames;
	static ArrayList<CustomerAccount> sortedByBSBAllDifferentBSBAndSameFamilyNames;
	
	
	static ArrayList<CustomerAccount> seededCustomers;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		customer1 = new CustomerAccount(1, 1999, 10.0, 100.0, "Josh", "Alpha", 000);
		customer2 = new CustomerAccount(2, 1111, 10.0, 200.0, "Isaiah", "Bravo", 111);
		customer3 = new CustomerAccount(3, 2222, 10.0, 300.0, "Holley", "Charlie", 222);
		customer4 = new CustomerAccount(4, 3333, 10.0, 400.0, "Gary", "Delta", 333);
		customer5 = new CustomerAccount(5, 4444, 10.0, 500.0, "Fatimah", "Echo", 444);
		customer6 = new CustomerAccount(6, 5555, 10.0, 600.0, "Evelyn", "Foxtrot", 555);
		customer7 = new CustomerAccount(7, 6666, 10.0, 700.0, "Deez", "Gold", 666);
		customer8 = new CustomerAccount(8, 7777, 10.0, 800.0, "Cucumber", "Hotel", 777);
		customer9 = new CustomerAccount(9, 8888, 10.0, 900.0, "Banana", "India", 888);
		customer10 = new CustomerAccount(10, 9999, 10.0, 1000.0, "Apple", "Juliet", 999);
		customer11 = new CustomerAccount(11, 1222, 10.0, 300.0, "Zed", "Jerry", 444);
		customer12 = new CustomerAccount(12, 2333, 10.0, 700.0, "Xavier", "Berry", 555);
		customer13 = new CustomerAccount(13, 3444, 10.0, 1000.0, "Wallace", "Tom", 888);
		
		sameBSBCustomer1 = new CustomerAccount(21, 1999, 10.0, 100.0, "Alpha", "Josh", 123);
		sameBSBCustomer2 = new CustomerAccount(22, 1111, 10.0, 200.0,"Bravo", "Isaiah", 123);
		sameBSBCustomer3 = new CustomerAccount(23, 2222, 10.0, 300.0, "Charlie", "Holley", 123);
		sameBSBCustomer4 = new CustomerAccount(24, 3333, 10.0, 400.0, "Delta", "Gary", 123);
		sameBSBCustomer5 = new CustomerAccount(25, 4444, 10.0, 500.0, "Echo", "Fatimah", 123);
		sameBSBCustomer6 = new CustomerAccount(26, 5555, 10.0, 600.0, "Foxtrot", "Evelyn", 123);
		sameBSBCustomer7 = new CustomerAccount(27, 6666, 10.0, 700.0, "Gold", "Deez", 123);
		sameBSBCustomer8 = new CustomerAccount(28, 7777, 10.0, 800.0, "Hotel", "Cucumber", 123);
		sameBSBCustomer9 = new CustomerAccount(29, 8888, 10.0, 900.0,  "India", "Banana", 123);
		sameBSBCustomer10 = new CustomerAccount(20, 9999, 10.0, 1000.0, "Juliet", "Apple", 123);
		
		sameFamilyNameCustomer1 = new CustomerAccount(31, 1999, 10.0, 100.0, "same", "Alpha", 000);
		sameFamilyNameCustomer2 = new CustomerAccount(32, 1111, 10.0, 200.0, "same", "Bravo", 111);
		sameFamilyNameCustomer3 = new CustomerAccount(33, 2222, 10.0, 300.0, "same", "Charlie", 222);
		sameFamilyNameCustomer4 = new CustomerAccount(34, 3333, 10.0, 400.0, "same", "Delta", 333);
		sameFamilyNameCustomer5 = new CustomerAccount(35, 4444, 10.0, 500.0, "same", "Echo", 444);
		sameFamilyNameCustomer6 = new CustomerAccount(36, 5555, 10.0, 600.0, "same", "Foxtrot", 555);
		sameFamilyNameCustomer7 = new CustomerAccount(37, 6666, 10.0, 700.0, "same", "Gold", 666);
		sameFamilyNameCustomer8 = new CustomerAccount(38, 7777, 10.0, 800.0, "same", "Hotel", 777);
		sameFamilyNameCustomer9 = new CustomerAccount(39, 8888, 10.0, 900.0, "same", "India", 888);
		sameFamilyNameCustomer10 = new CustomerAccount(310, 9999, 10.0, 1000.0, "same", "Juliet", 999);
		
		// customers added in order of total balance.
		sortedByTotalBalanceAllDifferentValues = new ArrayList<CustomerAccount>();
		sortedByTotalBalanceAllDifferentValues.add(customer1);
		sortedByTotalBalanceAllDifferentValues.add(customer2);
		sortedByTotalBalanceAllDifferentValues.add(customer3);
		sortedByTotalBalanceAllDifferentValues.add(customer4);
		sortedByTotalBalanceAllDifferentValues.add(customer5);
		sortedByTotalBalanceAllDifferentValues.add(customer6);
		sortedByTotalBalanceAllDifferentValues.add(customer7);
		sortedByTotalBalanceAllDifferentValues.add(customer8);
		sortedByTotalBalanceAllDifferentValues.add(customer9);
		sortedByTotalBalanceAllDifferentValues.add(customer10);
		
		// customers added in order of totalBalance, including the customers with same total balances.
		sortedByTotalBalanceSomeSameValues = new ArrayList<CustomerAccount>();
		sortedByTotalBalanceSomeSameValues.add(customer1);
		sortedByTotalBalanceSomeSameValues.add(customer2);
		sortedByTotalBalanceSomeSameValues.add(customer3);
		sortedByTotalBalanceSomeSameValues.add(customer11);
		sortedByTotalBalanceSomeSameValues.add(customer4);
		sortedByTotalBalanceSomeSameValues.add(customer5);
		sortedByTotalBalanceSomeSameValues.add(customer6);
		sortedByTotalBalanceSomeSameValues.add(customer7);
		sortedByTotalBalanceSomeSameValues.add(customer12);
		sortedByTotalBalanceSomeSameValues.add(customer8);
		sortedByTotalBalanceSomeSameValues.add(customer9);
		sortedByTotalBalanceSomeSameValues.add(customer10);
		sortedByTotalBalanceSomeSameValues.add(customer13);
		
		// customers added in order of BSB.
		sortedByBSBAllDifferentBSBAndFamilyNames = new ArrayList<CustomerAccount>();
		sortedByBSBAllDifferentBSBAndFamilyNames.add(customer1);
		sortedByBSBAllDifferentBSBAndFamilyNames.add(customer2);
		sortedByBSBAllDifferentBSBAndFamilyNames.add(customer3);
		sortedByBSBAllDifferentBSBAndFamilyNames.add(customer4);
		sortedByBSBAllDifferentBSBAndFamilyNames.add(customer5);
		sortedByBSBAllDifferentBSBAndFamilyNames.add(customer6);
		sortedByBSBAllDifferentBSBAndFamilyNames.add(customer7);
		sortedByBSBAllDifferentBSBAndFamilyNames.add(customer8);
		sortedByBSBAllDifferentBSBAndFamilyNames.add(customer9);
		sortedByBSBAllDifferentBSBAndFamilyNames.add(customer10);
		
		// customers added in order of BSB where all have same BSB but different Family Names
		sortedByBSBAllSameBSBAndDifferentFamilyNames = new ArrayList<CustomerAccount>();
		sortedByBSBAllSameBSBAndDifferentFamilyNames.add(sameBSBCustomer1);
		sortedByBSBAllSameBSBAndDifferentFamilyNames.add(sameBSBCustomer2);
		sortedByBSBAllSameBSBAndDifferentFamilyNames.add(sameBSBCustomer3);
		sortedByBSBAllSameBSBAndDifferentFamilyNames.add(sameBSBCustomer4);
		sortedByBSBAllSameBSBAndDifferentFamilyNames.add(sameBSBCustomer5);
		sortedByBSBAllSameBSBAndDifferentFamilyNames.add(sameBSBCustomer6);
		sortedByBSBAllSameBSBAndDifferentFamilyNames.add(sameBSBCustomer7);
		sortedByBSBAllSameBSBAndDifferentFamilyNames.add(sameBSBCustomer8);
		sortedByBSBAllSameBSBAndDifferentFamilyNames.add(sameBSBCustomer9);
		sortedByBSBAllSameBSBAndDifferentFamilyNames.add(sameBSBCustomer10);
		
		// customers added in order of BSB where all have different BSB but same Family Names
		sortedByBSBAllDifferentBSBAndSameFamilyNames = new ArrayList<CustomerAccount>();
		sortedByBSBAllDifferentBSBAndSameFamilyNames.add(sameFamilyNameCustomer1);
		sortedByBSBAllDifferentBSBAndSameFamilyNames.add(sameFamilyNameCustomer2);
		sortedByBSBAllDifferentBSBAndSameFamilyNames.add(sameFamilyNameCustomer3);
		sortedByBSBAllDifferentBSBAndSameFamilyNames.add(sameFamilyNameCustomer4);
		sortedByBSBAllDifferentBSBAndSameFamilyNames.add(sameFamilyNameCustomer5);
		sortedByBSBAllDifferentBSBAndSameFamilyNames.add(sameFamilyNameCustomer6);
		sortedByBSBAllDifferentBSBAndSameFamilyNames.add(sameFamilyNameCustomer7);
		sortedByBSBAllDifferentBSBAndSameFamilyNames.add(sameFamilyNameCustomer8);
		sortedByBSBAllDifferentBSBAndSameFamilyNames.add(sameFamilyNameCustomer9);
		sortedByBSBAllDifferentBSBAndSameFamilyNames.add(sameFamilyNameCustomer10);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		// Adding each customer at index 0 so that the list is backwards,
		// so the sort should essentially reverse this list.
		
		// have to reset every test in case one test adds customers that do not want to be
		// included in other test cases
		
		seededCustomers = new ArrayList<CustomerAccount>();
		seededCustomers.add(0, customer1);
		seededCustomers.add(0, customer2);
		seededCustomers.add(0, customer3);
		seededCustomers.add(0, customer4);
		seededCustomers.add(0, customer5);
		seededCustomers.add(0, customer6);
		seededCustomers.add(0, customer7);
		seededCustomers.add(0, customer8);
		seededCustomers.add(0, customer9);
		seededCustomers.add(0, customer10);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("1. Test that sortByTotalBalance method sorts it properly when all customers have different total balances.")
	void testSortByTotalBalanceWithAllDifferentValues() throws Exception {
		

		
		BankDatabaseNew bankDatabase = new BankDatabaseNew(seededCustomers);
		bankDatabase.sortByTotalBalance();
		// if the exported list of customers is the same as the manually checked, sorted by total balance list, then it is sorted correctly.
		assertEquals(sortedByTotalBalanceAllDifferentValues, bankDatabase.export());

	}
	
	@Test
	@DisplayName("2. Test sortByTotalBalance method when sorting customers where some have the same total balance.")
	void testSortByTotalBalanceWithSomeSameValues() throws Exception {
		
		// add the other customers to be tested
		seededCustomers.add(customer11);
		seededCustomers.add(customer12);
		seededCustomers.add(customer13);
		BankDatabaseNew bankDatabase = new BankDatabaseNew(seededCustomers);
		bankDatabase.sortByTotalBalance();
		
		assertEquals(sortedByTotalBalanceSomeSameValues, bankDatabase.export());
	}
	
	@Test
	@DisplayName("3. Test sortByBSB method when sorting customers with all different BSBs and family names.")
	void testSortByBSBWithAllDifferentBSBAndAllDifferentFamilyNames() throws Exception {
		
		BankDatabaseNew bankDatabase = new BankDatabaseNew(seededCustomers);
		bankDatabase.sortByBSB();
		// if the exported list of customers is the same as the manually checked, sorted by total balance list, then it is sorted correctly.
		assertEquals(sortedByBSBAllDifferentBSBAndFamilyNames, bankDatabase.export());
	}
	
	@Test
	@DisplayName("4. Test sortByBSB method when sorting customers with same BSBs and different family names.")
	void testSortByBSBWithAllSameBSBAndAllDifferentFamilyNames() throws Exception {
		
		// adding them in reverse order so that we know the sort
		// changing the seededCustomers here because it is for a different test case.
		seededCustomers = new ArrayList<CustomerAccount>();
		seededCustomers.add(0, sameBSBCustomer1);
		seededCustomers.add(0, sameBSBCustomer2);
		seededCustomers.add(0, sameBSBCustomer3);
		seededCustomers.add(0, sameBSBCustomer4);
		seededCustomers.add(0, sameBSBCustomer5);
		seededCustomers.add(0, sameBSBCustomer6);
		seededCustomers.add(0, sameBSBCustomer7);
		seededCustomers.add(0, sameBSBCustomer8);
		seededCustomers.add(0, sameBSBCustomer9);
		seededCustomers.add(0, sameBSBCustomer10);
		
		BankDatabaseNew bankDatabase = new BankDatabaseNew(seededCustomers);
		bankDatabase.sortByBSB();
		// if the exported list of customers is the same as the manually checked, sorted by total balance list, then it is sorted correctly.
		assertEquals(sortedByBSBAllSameBSBAndDifferentFamilyNames, bankDatabase.export());
	}
	
	@Test
	@DisplayName("5. Test sortByBSB method when sorting customers with different BSBs but same family names.")
	void testSortByBSBWithAllDifferentBSBAndAllSameFamilyNames() throws Exception {
		
		// adding them in reverse order so that we know the sort.
		// changing the seededCustomers here because it is for a different test case.
		seededCustomers = new ArrayList<CustomerAccount>();
		seededCustomers.add(0, sameFamilyNameCustomer1);
		seededCustomers.add(0, sameFamilyNameCustomer2);
		seededCustomers.add(0, sameFamilyNameCustomer3);
		seededCustomers.add(0, sameFamilyNameCustomer4);
		seededCustomers.add(0, sameFamilyNameCustomer5);
		seededCustomers.add(0, sameFamilyNameCustomer6);
		seededCustomers.add(0, sameFamilyNameCustomer7);
		seededCustomers.add(0, sameFamilyNameCustomer8);
		seededCustomers.add(0, sameFamilyNameCustomer9);
		seededCustomers.add(0, sameFamilyNameCustomer10);
		
		BankDatabaseNew bankDatabase = new BankDatabaseNew(seededCustomers);
		bankDatabase.sortByBSB();
		// if the exported list of customers is the same as the manually checked, sorted by total balance list, then it is sorted correctly.
		assertEquals(sortedByBSBAllDifferentBSBAndSameFamilyNames, bankDatabase.export());
	}
	
	// This test fails because the order in which the customers should be sorted when the TotalBalance is the same is unclear.
	// Like, for Customer3 and Customer11 which have identical total balances, the expected result would be that customer3 comes directly
	// before customer11. But in the result of the sort, the opposite happens. It's interesting that this only happens when the customers with
	// the same totalBalance are sequential in the list, as in Test Case 2 when they are not sequential it seemed to work fine.
	@Test
	@DisplayName("TEST FAIL - Test sortByTotalBalance method when sorting customers with same total balance and sequential in list.")
	void testSortByTotalBalanceWithSomeSameValuesAndSequential() throws Exception {
		
		// customers added in order of totalBalance, including the customers with same total balances.
		sortedByTotalBalanceSomeSameValues = new ArrayList<CustomerAccount>();
		sortedByTotalBalanceSomeSameValues.add(customer1);
		sortedByTotalBalanceSomeSameValues.add(customer2);
		sortedByTotalBalanceSomeSameValues.add(customer3);
		sortedByTotalBalanceSomeSameValues.add(customer11);
		sortedByTotalBalanceSomeSameValues.add(customer4);
		sortedByTotalBalanceSomeSameValues.add(customer5);
		sortedByTotalBalanceSomeSameValues.add(customer6);
		sortedByTotalBalanceSomeSameValues.add(customer7);
		sortedByTotalBalanceSomeSameValues.add(customer12);
		sortedByTotalBalanceSomeSameValues.add(customer8);
		sortedByTotalBalanceSomeSameValues.add(customer9);
		sortedByTotalBalanceSomeSameValues.add(customer10);
		sortedByTotalBalanceSomeSameValues.add(customer13);

		BankDatabaseNew bankDatabase = new BankDatabaseNew(seededCustomers);
		bankDatabase.sortByTotalBalance();
		
		assertEquals(sortedByTotalBalanceSomeSameValues, bankDatabase.export());
	}

}
