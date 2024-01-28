package org.example.hooks;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.AfterAll;

public class AfterHooks {

    @AfterAll
    public static void tearDown(){
        System.out.println("TEARDOWN METHOD");
        Selenide.refresh();
    }
}
