package runners;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.junit.DateTestSteps;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        DateTestSteps.class})
public class DateTestRunner {
}