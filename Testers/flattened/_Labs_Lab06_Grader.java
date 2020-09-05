package lab06;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;

import java.lang.reflect.Field;


public class Lab06_Grader{
	
	FileWriter fw;

	@Rule
	public TestWatcher watchman = new TestWatcher() {

		@Override
		protected void failed(Throwable e, Description description) {
			try{ 
    			fw.write("FAILED ");// Write FAILED token to file for each failed test
    			fw.close();
    		}catch(Exception ex){}
  		}

		@Override
		protected void succeeded(Description description) {
			try{ 
    			fw.write("PASSED ");// Write PASSED token to file for each successful test
    			fw.close();
    		}catch(Exception ex){}
		}
	};


	@Before
	public void setUp() throws Exception {
		fw = new FileWriter("temp.txt", true); //write a token in temp fil
		BankAccount.reset();
	}


	@Test
	public void testBankConstructor1() {
		BankAccount b = new BankAccount(12.5);
		assertTrue(b.getBalance() == 12.5);
	}

	//Can't test because numAccounts is private and there is no getter
	/*@Test
	public void testBankConstructor2() {
		BankAccount b = new BankAccount(12.5);
		BankAccount b2 = new BankAccount(12.5);
		BankAccount b3 = new BankAccount(13.0);
		assertTrue(BankAccount.numAccounts == 3);
	}*/

	@Test
	public void testDeposit1(){
		BankAccount b = new BankAccount(13.5);
		b.deposit(5.5);
		assertTrue(b.getBalance() == 19.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDeposit2(){
		BankAccount b = new BankAccount(13.5);
		b.deposit(-6.0);
	}

	//Typical Case
	@Test
	public void testWithdraw1(){
		BankAccount b = new BankAccount(10);
		double w = b.withdraw(6.0);
		assertTrue(b.getBalance() == 4.0);
		assertTrue(w == 6.0);
	}

	//Withdraw more than you have
	@Test
	public void testWithdraw2(){
		BankAccount b = new BankAccount(10);
		double w = b.withdraw(12);
		assertTrue(b.getBalance() == 0.0);
		assertTrue(w == 10.0);
	}

	//withdraw negative
	@Test(expected = IllegalArgumentException.class)
	public void testWithdraw3(){
		BankAccount b = new BankAccount(13.5);
		double w = b.withdraw(-6.0);
	}

	@Test
	public void testSavingsDeposit1(){
		SavingsAccount s = new SavingsAccount(10.0, 0.1);
		s.deposit(10.0); //adds 10 + 10*0.1
		assertTrue(s.getBalance() == 21.0);
	}

	@Test
	public void testSavingsDeposit2(){
		SavingsAccount s = new SavingsAccount(5.0, 0.0);
		s.deposit(10.0);
		assertTrue(s.getBalance() == 15.0);
	}

	@Test
	public void testCheckingConstructor1(){
		CheckingAccount c = new CheckingAccount(10.0, 4); //limit 4 withdrawals
		assertTrue(c.getBalance() == 10.0);
		assertTrue(c.getWithdrawLimit() == 4);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCheckingConstructor2(){
		CheckingAccount c = new CheckingAccount(10.0, -3);
	}

	@Test
	public void testCheckingWithdraw1(){
		CheckingAccount c = new CheckingAccount(10.0, 2); //limit 4 withdrawals
		double w = c.withdraw(12.0);
		assertTrue(c.getBalance() == 0.0);
		assertTrue(w == 10.0);

	}

	@Test
	public void testCheckingWithdraw2(){
		CheckingAccount c = new CheckingAccount(10.0, 2); //limit 4 withdrawals
		double w1 = c.withdraw(1.0);
		double w2 = c.withdraw(2.0);
		assertTrue(c.getBalance() == 7.0);
		assertTrue(w2 == 2.0);
	}

	@Test
	public void testCheckingWithdraw3(){
		CheckingAccount c = new CheckingAccount(10.0, 2); //limit 4 withdrawals
		double w1 = c.withdraw(1.0);
		double w2 = c.withdraw(2.0);
		double w3 = c.withdraw(1.0);

		assertTrue(c.getBalance() == 7.0);
		assertTrue(w3 == 0.0);
	}


	//assertEquals("Investment must not be null", exception.getMessage());

}