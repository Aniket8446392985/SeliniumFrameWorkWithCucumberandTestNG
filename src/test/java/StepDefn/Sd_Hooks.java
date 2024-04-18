package StepDefn;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Sd_Hooks {
    // Before and After hooks are defined this will be executed
    // before and after every Smoke test
    @Before ("@SmokeTest")
    public void Browser_launch_hook(){
        System.out.println("****************************************************");
        System.out.println("Browser is launched");
    }

    @After("@SmokeTest")
    public void browser_Close_Hook(){
        System.out.println("Browser is closed");
    }
}
