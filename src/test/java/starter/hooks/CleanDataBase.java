package starter.hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CleanDataBase {

    @Before
    public static void beforeHook() {
        System.out.println("Before hook");
    }

    @Before("@onlyThis")
    public static void beforeHookOnlyThis() {
        System.out.println("Before hook - only this");
    }

    @After
    public static void afterHook(){
        System.out.println("After hook");
    }
}
