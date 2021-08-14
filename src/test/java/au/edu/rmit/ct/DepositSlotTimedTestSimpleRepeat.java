/**
*  
* Name: John Smith
* Student ID: s45045012
* Email: s45045012@student.rmit.edu.au
* 
* [OPTIONAL: add any notes here about the code]
*/

package au.edu.rmit.ct;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class DepositSlotTimedTestSimpleRepeat {
	
	static DepositSlotTimed depositTime;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		depositTime = new DepositSlotTimed("name");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@RepeatedTest(10)
	@DisplayName("1. Test to check that deposit time finishes before specified time. Intended to get 5/10 repeats successful.")
	void testSimpleRepeatDepositSlotTime() {
		assertTimeout(Duration.ofMillis(1210), () -> {
			depositTime.checkTimer();
		});
	}

}
