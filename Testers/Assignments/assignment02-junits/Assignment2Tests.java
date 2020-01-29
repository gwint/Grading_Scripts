package assignment02;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Assignment2Tests {
	final double INITIAL_BALANCE2 = 10000;
	final double RATE2 = 5;
	Investment2 invest2;
	final double INITIAL_BALANCE3 = 10000;
	final double RATE3 = 5;
	Investment3 invest3;
	Investment3 invest3a;
	Investment3 invest3b;
	Investment3 invest3TooBig;
	Portfolio port;

	@BeforeEach
	void setUp() throws Exception {
		invest2 = new Investment2(INITIAL_BALANCE2, RATE2);
		invest3 = new Investment3(INITIAL_BALANCE3, RATE3);
		invest3.setNewRateFrom(5, 4);
		invest3.setNewRateFrom(10, 6);
		invest3.setNewRateFrom(15, 7);
		invest3.setNewRateFrom(20, 8);
		invest3a = new Investment3(INITIAL_BALANCE3 + 100, RATE3-1);
		invest3a.setNewRateFrom(5, 4.5);
		invest3a.setNewRateFrom(10, 5.5);
		invest3a.setNewRateFrom(15, 6);
		invest3a.setNewRateFrom(20, 6.5);
		invest3b = new Investment3(INITIAL_BALANCE3 - 200, RATE3+1);
		invest3b.setNewRateFrom(5, 5);
		invest3b.setNewRateFrom(10, 4.5);
		invest3b.setNewRateFrom(15, 6);
		invest3b.setNewRateFrom(20, 5.5);
		invest3TooBig = new Investment3(2.5*INITIAL_BALANCE3, RATE3+1);
		port = new Portfolio(3*INITIAL_BALANCE3+500);
	}

	@Test
	void testYearsToBalance2() {
		assertAll (
				() -> assertEquals(20, invest2.yearsToBalance(26500)),
				() -> assertEquals(0, invest2.getYears()),
				() -> assertEquals(INITIAL_BALANCE2, invest2.getBalance(),1e-2)
				);
	}

	@Test
	void testBalanceAfter2() {
		assertAll (
				() -> assertEquals(26532.98, invest2.balanceAfter(20),1e-2),
				() -> assertEquals(0, invest2.getYears()),
				() -> assertEquals(INITIAL_BALANCE2, invest2.getBalance(),1e-2)
				);
	}

	@Test
	void testWaitYears2() {
		invest2.waitYears(20);
		assertAll (
				() -> assertEquals(20, invest2.getYears()),
				() -> assertEquals(26532.98, invest2.getBalance(),1e-2)
				);
	}

	@Test
	void testYearsToBalance3() {
		invest3.waitYears(4); // more interesting if years is not 0
		double startBalance = invest3.getBalance();
		assertAll (
				() -> assertEquals(15, invest3.yearsToBalance(26500)),
				() -> assertEquals(4, invest3.getYears()),
				() -> assertEquals(startBalance, invest3.getBalance(),1e-2)
				);
	}

	@Test
	void testWaitYears3() {
		invest3.waitYears(20);
		assertAll (
				() -> assertEquals(20, invest3.getYears()),
				() -> assertEquals(29144.82, invest3.getBalance(),1e-2)
				);
	}

	@Test
	void testBalanceAfter3() {
		invest3.waitYears(5);
		double startBalance = invest3.getBalance();
		assertAll (
				() -> assertEquals(29144.82, invest3.balanceAfter(15),1e-2),
				() -> assertEquals(5, invest3.getYears()),
				() -> assertEquals(startBalance, invest3.getBalance(),1e-2)
				);
	}

	@Test
	void testAddInvestment() {
		port.addInvestment(0, 2, invest3);
		assertAll (
				() -> assertEquals(INITIAL_BALANCE3, invest3.getBalance(),1e-2)
				);
		port.addInvestment(2, 3, invest3a);
		assertAll (
				() -> assertEquals(11025.00, invest3.getBalance(),1e-2),
				() -> assertEquals(INITIAL_BALANCE3+100, invest3a.getBalance(),1e-2)
				);
		Throwable exception = assertThrows(IllegalArgumentException.class,
				() -> port.addInvestment(0, 0, null));
		assertEquals("Investment must not be null", exception.getMessage());				
		exception = assertThrows(IllegalArgumentException.class, 
				() -> port.addInvestment(0, -1, invest3TooBig));
		assertEquals("index out of bounds", exception.getMessage());
		exception = assertThrows(IllegalArgumentException.class, 
				() -> port.addInvestment(0, 5, invest3TooBig));
		assertEquals("index out of bounds", exception.getMessage());
		exception = assertThrows(IllegalArgumentException.class, 
				() -> port.addInvestment(0, 2, invest3TooBig));
		assertEquals("previous investment is stored at that index", exception.getMessage());
		exception = assertThrows(IllegalArgumentException.class, 
				() -> port.addInvestment(0, 0, invest3TooBig));
		assertEquals("insufficient funds", exception.getMessage());
		port.addInvestment(3, 4, invest3b);
		assertAll (
				() -> assertEquals(5, invest3.getYears()),
				() -> assertEquals(12762.82, invest3.getBalance(),1e-2),
				() -> assertEquals(11361.13, invest3a.getBalance(),1e-2),
				() -> assertEquals(INITIAL_BALANCE3-200, invest3b.getBalance(),1e-2)
				);
	}

	@Test
	void testPortfolioWaitYears() {
		port.addInvestment(0, 2, invest3);
		port.addInvestment(2, 3, invest3a);
		port.addInvestment(3, 4, invest3b);
		port.waitYears(10);
		assertAll (
				() -> assertEquals(15, invest3.getYears()),
				() -> assertEquals(20779.86, invest3.getBalance(),1e-2),
				() -> assertEquals(13, invest3a.getYears()),
				() -> assertEquals(17981.54, invest3a.getBalance(),1e-2),
				() -> assertEquals(10, invest3b.getYears()),
				() -> assertEquals(16737.94, invest3b.getBalance(),1e-2)
				);
	}

	@Test
	void testCashInInvestment() {
		double cashValueCopy = 3*INITIAL_BALANCE3+500 - invest3.getBalance() -
				invest3a.getBalance() - invest3b.getBalance();
		port.addInvestment(0, 2, invest3); 
		port.addInvestment(2, 3, invest3a);
		port.addInvestment(3, 4, invest3b);
		port.waitYears(10);
		port.cashInInvestment(2); // invest3 stops growing
		cashValueCopy += invest3.getBalance();
		assertEquals(cashValueCopy + invest3a.getBalance() + 
				invest3b.getBalance(), port.currentWealth(), 1e-2);
		port.waitYears(10); // only invest3a and invest3b continue to grow
		assertEquals(cashValueCopy + invest3a.getBalance() + 
				invest3b.getBalance(), port.currentWealth(), 1e-2);
	}

	@Test
	void testIndexOfFirstInvestmentToBalance() {
		port.addInvestment(0, 2, invest3); 
		port.addInvestment(2, 3, invest3a);
		port.addInvestment(3, 4, invest3b);
		assertEquals(2, port.indexOfFirstInvestmentToBalance(50000));
	}

	@Test
	void testIndexOfFirstInvestmentToBalance2() {
		port.addInvestment(0, 2, invest3); 
		port.addInvestment(0, 3, invest3a);
		port.addInvestment(0, 4, invest3b);
		assertEquals(4, port.indexOfFirstInvestmentToBalance(20800));
	}

	@Test
	void testCurrentWealth() {
		double cashValueCopy = 3*INITIAL_BALANCE3+500 - invest3.getBalance() -
				invest3a.getBalance() - invest3b.getBalance();
		port.addInvestment(0, 2, invest3); 
		port.addInvestment(2, 3, invest3a);
		port.addInvestment(3, 4, invest3b);
		port.waitYears(10);
		assertEquals(cashValueCopy + invest3.getBalance() + 
				invest3a.getBalance() + 
				invest3b.getBalance(), port.currentWealth(), 1e-2);
	}
}
