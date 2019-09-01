package assignment07;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

class BankTester {
	public static void main(String args[]) {
	}
	
	Bank testBank;
	String[] names = {"Jane Devon","John CornWall", "Jean Dorset", "James Hampshire"};

	@BeforeEach
	void initialize() {
		testBank = new Bank("NewNYBank");
		testBank.setBaseCheckLimit(5);
		testBank.setBaseRate(2);
		testBank.setCheckFee(1.50);
		testBank.addCustomer(names[0], 0, 200); 	// no savings account
		testBank.addCustomer(names[1], 200, 99);	// no checking account
		testBank.addCustomer(names[2], 200, 300);
		testBank.addCustomer(names[3], 100000, 2000);
	} // !initialize

	@AfterEach
	void resetIdNum() {
		testBank.reset();		
	} // !resetIdNum

	@Test
	@DisplayName("Check id getter for Customer works")
	void testCustomerIdGetter() {
		Customer testCustomer = new Customer("Test Customer", 1001, null, null);
		assertEquals(1001, testCustomer.getIdNum());
	}
	
	
	@Test
	@DisplayName("Check that all the accounts are set up correctly in the Bank")
	void testBankCustomerList() {
		Customer test0 = testBank.getCustomer(10000); // null Customer
		Customer test1 = testBank.getCustomer(10001); // no savings account
		Customer test2 = testBank.getCustomer(10002); // no checking account
		Customer test3 = testBank.getCustomer(10003);
		Customer test4 = testBank.getCustomer(10004);
		try {
			assertAll(
					() -> assertNull(test0),
					() -> assertEquals(names[0], test1.getName()),
					() -> assertEquals(names[1], test2.getName()),
					() -> assertEquals(names[2], test3.getName()),
					() -> assertEquals(names[3], test4.getName()),
					() -> assertThrows(UnsupportedOperationException.class,
							() -> test1.getMySavingsBalance()),
					() -> assertEquals(200, test2.getMySavingsBalance(), 1e-6),
					() -> assertEquals(200, test3.getMySavingsBalance(), 1e-6),
					() -> assertEquals(100000, test4.getMySavingsBalance(), 1e-6),
					() -> assertThrows(UnsupportedOperationException.class,
							() -> test2.getMyCheckingBalance()),
					() -> assertEquals(200, test1.getMyCheckingBalance(), 1e-6),
					() -> assertEquals(300, test3.getMyCheckingBalance(), 1e-6),
					() -> assertEquals(2000, test4.getMyCheckingBalance(), 1e-6)
					);			
		} // !try
		catch(AssertionError e){
			System.out.println("The Bank Customers were no set up correctly: " + e.getMessage());
			throw e;
		} // !catch
	} // !testBankCustomerList
	
	@Test
	@DisplayName("Tests deposit method of a savings account")
	void testSavingsDeposit() {
		SavingsAccount test = new SavingsAccount(200, 5);
		test.deposit(500);
		try {
			assertEquals(700.00, test.getBalance(), 1e-6);
		} // !try
		catch(AssertionError e){
			System.out.println("deposit() method in savings failed: " + e.getMessage());
			throw e;
		} // !catch
	} // !testSavingsDeposit
	
	@Test
	@DisplayName("Tests deposit method of a checking account")
	void testCheckingDeposit() {
		CheckingAccount test = new CheckingAccount(300, 3);
		test.deposit(200);
		
		try {
			assertEquals(500.00, test.getBalance(), 1e-6);
		} // !try
		catch (AssertionError e) {
			System.out.println("deposit() method in  checking failed: "
					+ e.getMessage());
			throw e;
		} // !catch
	} // !testCheckingDeposit
	
	@Test
	@DisplayName("Tests that the deposit method of a savings account throws "
			+ "illegal argument exception when argument is negative")
	void testSavings1Deposit() {
		SavingsAccount test = new SavingsAccount(200, 5);
		try {
			assertThrows(IllegalArgumentException.class,
					() -> {test.deposit(-10);});
		} // !try
		catch(AssertionError e) {
			System.out.println("deposit() method in savings failed: "
					+ e.getMessage());
			throw e;
		} // !catch
	} // !testSavings1Deposit
	
	@Test
	@DisplayName("Tests that the deposit() method of CheckingAccount throws "
			+ "illegal argument exception when argument is negative")
	void testCheckingDepositFail() {
		CheckingAccount test = new CheckingAccount(100, 2);
		try {
			assertThrows(IllegalArgumentException.class,
					() -> {test.deposit(-100);});
		} // !try
		catch (AssertionError e) {
			System.out.println("deposit() method in checking failed: "
					+ e.getMessage());
			throw e;
		} // !catch
	} // !testCheckingDepositFail

	@Test
	@DisplayName("Tests deposit method of mySavings in a Customer with only a "
			+ "savings account")
	void testCustomer1SavingsDeposit() {
		Customer test = new Customer("Name", 1, new SavingsAccount(200, 5), null);
		test.depositSavings(500);
		try {
			assertEquals(700.00, test.getMySavingsBalance(), 1e-6);
		} // !try
		catch(AssertionError e) {
			System.out.println("depositSavings() method in Customer failed: "
					+ e.getMessage());
			throw e;
		} // !catch
	} // !testCustomer1SavingsDeposit
	
	@Test
	@DisplayName("Tests deposit method of myChecking in a Customer with only a "
			+ "checking account")
	void testCustomer1CheckingDeposit() {
		Customer test = new Customer("Name", 1, null, new CheckingAccount(100, 2));
		test.depositChecking(100);
		try {
			assertEquals(200.00, test.getMyCheckingBalance(), 1e-6);
		} // !try
		catch (AssertionError e) {
			System.out.println("depositChecking() method in Customer failed: "
					+ e.getMessage());
			throw e;
		} // !catch
	} // !testCustomer1CheckingDeposit
	
	@Test
	@DisplayName("Tests deposit method of mySavings in a Customer with savings "
			+ "and checking account")
	void testCustomer2SavingsDeposit() {
		Customer test = new Customer("Name", 1, new SavingsAccount(200, 5), new CheckingAccount(200, 5));
		test.depositSavings(500);
		try {
			assertEquals(700.00, test.getMySavingsBalance(), 1e-6);
		} // !try
		catch(AssertionError e){
			System.out.println("depositSavings() method in Customer failed: "
					+ e.getMessage());
			throw e;
		} // !catch
	} // !testCustomer2SavingsDeposit
	
	@Test
	@DisplayName("Tests deposit method of myChecking in a Customer with savings "
			+ "and checking account")
	void testCustomer2CheckingDeposit() {
		Customer test = new Customer("Name", 1, new SavingsAccount(100, 3),
				new CheckingAccount(100, 3));
		test.depositChecking(100);
		try {
			assertEquals(200.00, test.getMyCheckingBalance(), 1e-6);
		} // !try
		catch (AssertionError e) {
			System.out.println("depositChecking() method in Customer failed: "
					+ e.getMessage());
			throw e;
		} // !catch
	} // !testCustomer2CheckingDeposit

	@Test
	@DisplayName("Tests deposit method of mySavings in Customer with only "
			+ "checking account")
	void testCustomer3SavingsDeposit() {
		Customer test = new Customer("Name", 1, null,
				new CheckingAccount(200, 5));
		// there is no savings account so we check the correct exception occurs
		try {
			assertThrows(UnsupportedOperationException.class,
					() -> {test.depositSavings(500);});
		} // !try
		catch(AssertionError e){
			System.out.println("depositSavings() method failed to throw "
					+ "exception: " + e.getMessage());
			throw e;
		} // !catch
	} // !testCustomer3SavingsDeposit
	
	@Test
	@DisplayName("Tests deposit method of myChecking in Customer with only "
			+ "savings account")
	void testCustomer3CheckingDeposit() {
		Customer test = new Customer("Name", 1, new SavingsAccount(100, 3),
				null);
		try {
			assertThrows(UnsupportedOperationException.class,
					() -> {test.depositChecking(100);});
		} // !try
		catch (AssertionError e) {
			System.out.println("depositChecking() method failed to throw "
					+ "exception: " + e.getMessage());
			throw e;
		} // !catch
	} // !testCustomer3CheckingDeposit

	@Test
	@DisplayName("Tests withdraw method of a savings account")
	void testSavingsWithdraw() {
		SavingsAccount test = new SavingsAccount(200, 5);
		double retVal = test.withdraw(50);
		try {
			assertAll(
					() -> assertEquals(150.00, test.getBalance(), 1e-6),
					() -> assertEquals(50.00, retVal, 1e-6)
					);
		} // !try
		catch(AssertionError e){
			System.out.println("withdraw() method in savings failed: "
					+ e.getMessage());
			throw e;
		} // !catch
	} // !testSavingsWithdraw
	
	@Test
	@DisplayName("Tests withdraw method of a checking account")
	void testCheckingWithdraw() {
		CheckingAccount test = new CheckingAccount(100, 3);
		double withdrawal = test.withdraw(50.00);
		try {
			assertAll(
					() -> assertEquals(50.00, test.getBalance(), 1e-6),
					() -> assertEquals(50.00, withdrawal, 1e-6)
					);
		} // !try
		catch (AssertionError e) {
			System.out.println("withdraw() method in checking failed: "
					+ e.getMessage());
		} // !catch
	} // !testCheckingWithdraw

	@Test
	@DisplayName("Tests withdraw method of a savings account when amount > "
			+ "balance")
	void testSavingsWithdraw1() {
		SavingsAccount test = new SavingsAccount(200, 5);
		double retVal = test.withdraw(250);
		try {
			assertAll(
					() -> assertEquals(0.00, test.getBalance(), 1e-6),
					() -> assertEquals(200.00, retVal, 1e-6)
					);
		} // !try
		catch(AssertionError e){
			System.out.println("withdraw() method in savings failed: "
					+ e.getMessage());
			throw e;
		} // !catch
	} // !testSavingsWithdraw1
	
	@Test
	@DisplayName("Tests withdraw method of a checking account when "
			+ "amount > balance")
	void testCheckingWithdraw1() {
		CheckingAccount test = new CheckingAccount(200, 4);
		double retVal = test.withdraw(300);
		try {
			assertAll(
					() -> assertEquals(0.00, test.getBalance(), 1e-6),
					() -> assertEquals(200.00, retVal, 1e-6)
					);
		} // !try
		catch (AssertionError e) {
			System.out.println("withdraw() method in checking failed: "
					+ e.getMessage());
			throw e;
		} // !catch
	} // !testCheckingWithdraw1

	@Test
	@DisplayName("Tests that the withdraw method of a savings account throws " +
			"illegal argument exception when argument is negative")
	void testSavings1Withdraw() {
		SavingsAccount test = new SavingsAccount(200, 5);
		try {
			assertThrows(IllegalArgumentException.class,
					() -> test.withdraw(-10));
		} catch(AssertionError e){
			System.out.println("withdraw() method in savings failed to throw exception: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	@DisplayName("Tests that the withdraw method of a checking account throws "
			+ "illegal argument exception when argument is negative")
	void testChecking1Withdraw() {
		CheckingAccount test = new CheckingAccount(200, 4);
		try {
			assertThrows(IllegalArgumentException.class,
					() -> test.withdraw(-100));
		} // !try
		catch (AssertionError e) {
			System.out.println("withdraw() method in checking failed to throw "
					+ "execption: " + e.getMessage());
			throw e;
		} // !catch
	} // !testChecking1Withdraw

	@Test
	@DisplayName("Tests withdraw method of mySavings in a Customer with only a "
			+ "savings account")
	void testCustomer1SavingsWithdraw() {
		Customer test = new Customer("Name", 1, new SavingsAccount(200, 5), null);
		double retVal = test.withdrawSavings(50);
		try {
			assertAll(
					() -> assertEquals(150.00, test.getMySavingsBalance(), 1e-6),
					() -> assertEquals(50.00, retVal, 1e-6)
					);
		} // !try
		catch(AssertionError e) {
			System.out.println("withdrawSavings() method in customer failed: "
					+ e.getMessage());
			throw e;
		} // !catch
	} // !testCustomer1SavingsWithdraw
	
	@Test
	@DisplayName("Tests writeCheck method of myChecking in a Customer with only "
			+ "a checking account")
	void testCustomer1CheckingWriteCheck() {
		Customer test = new Customer("Name", 1, null,
				new CheckingAccount(200, 3));
		double retVal = test.writeCheck(50.00);
		try {
			assertAll(
					() -> assertEquals(150.00, test.getMyCheckingBalance(), 1e-6),
					() -> assertEquals(50.00, retVal, 1e-6)
					);
		} // !try
		catch (AssertionError e) {
			System.out.println("writeCheck() method in Customer failed: "
					+ e.getMessage());
			throw e;
		} // !catch
	} // !testCustomer1CheckingWriteCheck

	@Test
	@DisplayName("Tests withdraw method of mySavings in a Customer with only a "
			+ "savings account when amount > balance")
	void testCustomer1SavingsWithdraw1() {
		Customer test = new Customer("Name", 1, new SavingsAccount(200, 5),
				null);
		double retVal = test.withdrawSavings(250);
		try {
			assertAll(
					() -> assertEquals(0.00, test.getMySavingsBalance(), 1e-6),
					() -> assertEquals(200.00, retVal, 1e-6)
					);
		} // !try
		catch(AssertionError e){
			System.out.println("withdrawSavings() method in Customer failed: "
				+ e.getMessage());
			throw e;
		} // !catch
	} // !testCustomer1SavingsWithdraw1
	
	@Test
	@DisplayName("Tests writeCheck method of myChecking in a Customer with "
			+ "only a checking account when amount > balance")
	void testCustomer1CheckingWriteCheck1() {
		Customer test = new Customer("Name", 1, null,
				new CheckingAccount(200.00, 3));
		double retVal = test.writeCheck(250.00);
		try {
			assertAll(
					() -> assertEquals(0.00, test.getMyCheckingBalance(), 1e-6),
					() -> assertEquals(200.00, retVal, 1e-6)
					);
		} // !try
		catch (AssertionError e) {
			System.out.println("writeCheck() method in Customer failed: "
					+ e.getMessage());
			throw e;
		} // !catch
	} // !testCustomer1CheckingWriteCheck1
	
	@Test
	@DisplayName("Tests withdraw method of mySavings in a Customer with savings "
			+ "and checking account")
	void testCustomer2SavingsWithdraw() {
		Customer test = new Customer("Name", 1, new SavingsAccount(200, 5), new CheckingAccount(200, 5));
		double retVal = test.withdrawSavings(50);
		try {
			assertAll(
					() -> assertEquals(150.00, test.getMySavingsBalance(), 1e-6),
					() -> assertEquals(50.00, retVal, 1e-6)
					);
		} // !try
		catch(AssertionError e){
			System.out.println("withdrawSavings() method in Customer failed: " + e.getMessage());
			throw e;
		} // !catch
	} // !testCustomer2SavingsWithdraw
	
	@Test
	@DisplayName("Tests writeCheck method of myChecking in a Customer with savings "
			+ "and checking account")
	void testCustomer2CheckingWriteCheck() {
		Customer test = new Customer("Name", 1, new SavingsAccount(100, 2),
				new CheckingAccount(200, 3));
		double retVal = test.writeCheck(50);
		try {
			assertAll(
					() -> assertEquals(150.00, test.getMyCheckingBalance(), 1e-6),
					() -> assertEquals(50.00, retVal, 1e-6)
					);
		} // !try
		catch(AssertionError e){
			System.out.println("writeCheck() method in Customer failed: "
					+ e.getMessage());
			throw e;
		} // !catch
	} // !testCustomer2CheckingWriteCheck

	@Test
	@DisplayName("Tests withdraw method of mySavings in Customer with only "
			+ "checking account")
	void testCustomer3SavingsWithdraw() {
		Customer test = new Customer("Name", 1, null, new CheckingAccount(200, 5));
		// there is no savings account so we check the correct exception occurs
		try {
			assertThrows(UnsupportedOperationException.class,
					() -> test.withdrawSavings(500));
		} // !try
		catch(AssertionError e){
			System.out.println("withdrawSavings() method failed to throw "
					+ "exception: "	+ e.getMessage());
			throw e;
		} // !catch
	} // !testCustomer3SavingsWithdraw
	
	@Test
	@DisplayName("Tests writeCheck method of myChecking in Customer with only "
			+ "savings account")
	void testCustomer3CheckingWriteCheck() {
		Customer test = new Customer("Name", 1, new SavingsAccount(300, 1),
				null);
		// there is no checking account so we check the correct exception occurs
		try {
			assertThrows(UnsupportedOperationException.class,
					() -> test.writeCheck(500));
		} // !try
		catch(AssertionError e){
			System.out.println("writeCheck() method failed to throw exception: "
					+ e.getMessage());
			throw e;
		} // !catch
	} // !testCustomer3CheckingWriteCheck
	
	@Test
	@DisplayName("Tests getWithCount method of myChecking in Customer")
	void testCustomerGetWithdrawCount() {
		Customer test = new Customer("Name", 1, null,
				new CheckingAccount(100, 5));
		
		for (int i = 0; i < 3; i++) {
			test.writeCheck(5);
		} // !for
		
		try {
			assertEquals(3, test.getWithdrawCount());
		} // !try
		catch (AssertionError e) {
			System.out.println("getWithdrawCount() method in Customer failed: "
					+ e.getMessage());
			throw e;
		} // !catch
	} // !testCustomerGetWithdrawCount
	
	@Test
	@DisplayName("Testing doMonthlyAdjustment in Bank and thereby testing all the "
			+ "monthlyAdjustment methods in Customer, Checking") 
	void testBankDoMonthlyAdjustment() {
		//Bank was set up in Initialize() above
		//YOU MUST ADD TEST FOR CHECHKING, SO DO 
		// writeCheck with small amounts, 10 times

		Customer test1 = testBank.getCustomer(10001); // no savings account
		Customer test2 = testBank.getCustomer(10002); // no checking account
		Customer test3 = testBank.getCustomer(10003);
		Customer test4 = testBank.getCustomer(10004);
		
		for (int i = 0; i < 10; i++) {
			test1.writeCheck(10);
		} // !for
		for (int i = 0; i < 6; i++) {
			test4.writeCheck(1);
		} // !for
		
		testBank.doMonthlyAdjustment();
		try {
			assertAll(
					//test 1 does not have a savings account
					() -> assertEquals(200.333333, test2.getMySavingsBalance(), 1e-3),
					() -> assertEquals(200.333333, test3.getMySavingsBalance(), 1e-3),
					() -> assertEquals(100183.333333, test4.getMySavingsBalance(), 1e-3),
					// INSERT SIMILAR TESTS THAT THE BALANCES ARE CORRECT
					// AND THE withdrawCount IS BACK TO 0 FOR EACH test1, test3, test4
					() -> assertEquals(111, test1.getNextCheckNum()),
					() -> assertEquals(0, test1.getWithdrawCount()),
					() -> assertEquals(92.5, test1.getMyCheckingBalance(), 1e-6),
					//test 2 does not have a checking account
					() -> assertEquals(300.00, test3.getMyCheckingBalance(), 1e-6),
					() -> assertEquals(6, test4.getWithdrawLimit()),
					() -> assertEquals(1994, test4.getMyCheckingBalance(), 1e-6)
					);
		} // !try
		catch(AssertionError e){
			System.out.println("doMonthlyAdjustment in Bank failed: "
					+ e.getMessage());
			throw e;
		} // !catch
	} // !testBankDoMonthlyAdjustment
} // !BankTester

