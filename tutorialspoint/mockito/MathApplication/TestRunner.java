import org.junit.runner.Result;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

public class TestRunner{
	public static void main(String[] args){
		Result result = JUnitCore.runClasses(MathApplicationTester.class);
		result.getFailures()
			.stream()
			.forEach(System.out::println);
		System.out.println(result.wasSuccessful());
	}
}
