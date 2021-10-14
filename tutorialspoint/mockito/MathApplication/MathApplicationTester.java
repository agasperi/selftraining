import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.MockitoAnnotations;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester{
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@InjectMocks 
	MathApplication mathApplication = new MathApplication();
	
	@Mock
	CalculatorService calcService;
	
	@Test
	public void TestAdd(){
		when(calcService.add(10.0,20.0)).thenReturn(30.00);
		Assert.assertEquals(mathApplication.add(10.0,20.0),30.0,0);
	}
}
