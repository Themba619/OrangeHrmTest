import org.testng.annotations.Test;

public class priorityTest {
	
	@Test(priority = 3)
	public void a() {
		System.out.println("Test A");
	}
	
	//Duplicate
	@Test(priority = 1)
	public void duplicate2() {
		System.out.println("Test duplicate 2");
	}
	
	// Duplicate
	@Test(priority = 1)
	public void duplicate1() {
		System.out.println("Test duplicate 1");
	}
	
	
	@Test(priority = 2)
	public void c() {
		System.out.println("Test C");
	}
	
	// negative
	// Execute case multiple times
	@Test(priority = -2, invocationCount = 3)
	public void d() {
		System.out.println("Test D");
	}
}
