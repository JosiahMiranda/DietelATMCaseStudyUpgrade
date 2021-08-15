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

class DepositSlotTimedTestAdvancedTiming {
	
	static DepositSlotTimed depositTime;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		depositTime = new DepositSlotTimed("name");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Test receiving a deposit before activation of the slot.")
	void testReceiveDepositBeforeActivation() {
		assertFalse(depositTime.receiveEnvelope());
	}
	
	@Test
	@DisplayName("Test receiving a deposit whilst the slot is activated.")
	void testReceiveDepositAfterActivation() {
		
		// Run two different threads so that we can emulate depositing the envelope while
		// it is activated.
		Thread runThread = new Thread(new Runnable() {
		    @Override
		    public void run() {
		        depositTime.run();
		    }
		});  
		
		Thread receiveEnvelopeThread = new Thread(new Runnable() {
		    @Override
		    public void run() {
		    	try {
		    		// Sleep for 500ms to give the other thread time to activate the slot.
		    		// The default wait time for the deposit slot is 1200 so this should work all the time.
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		        assertTrue(depositTime.receiveEnvelope());
		    }
		});  
		
		runThread.start();
		receiveEnvelopeThread.start();
	}
	
	@Test
	@DisplayName("Test receiving a deposit after the slot is deactivated after activating.")
	void testReceiveDepositAfterDeactivation() {
		
		// Run two different threads so that we can emulate depositing the envelope while
		// it is activated.
		Thread runThread = new Thread(new Runnable() {
		    @Override
		    public void run() {
		        depositTime.run();
		    }
		});  
		
		Thread receiveEnvelopeThread = new Thread(new Runnable() {
		    @Override
		    public void run() {
		    	try {
		    		// Sleep for 1500ms to give the other thread time to activate and then deactivate the slot.
		    		// The default wait time for the deposit slot is 1200 so this should work all the time.
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		        assertFalse(depositTime.receiveEnvelope());
		    }
		});  
		
		runThread.start();
		receiveEnvelopeThread.start();
	}
	

}
