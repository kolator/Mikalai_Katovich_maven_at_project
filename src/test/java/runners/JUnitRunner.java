package runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.junit.RegisterLogin;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        RegisterLogin.class})

public class JUnitRunner {
}
