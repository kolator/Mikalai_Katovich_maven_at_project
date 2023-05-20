package classwork.day20052023;

import org.junit.runner.JUnitCore;
import org.junit.runner.notification.RunListener;

public class ListenerRunner extends RunListener {
    public static void main(String[] args) {
        JUnitCore runner = new JUnitCore();
        runner.addListener(new MyListener());
        runner.run(MyTestRailTests.class);

    }
}
