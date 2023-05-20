package runners;

import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class TestNGYamlRunner {
    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        List<String> strings = new ArrayList<>();
        strings.add("src/test/java/settings/testng.yaml");
        testNG.setTestSuites(strings);
        testNG.run();
    }
}