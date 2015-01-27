package jp.azumis.sandbag;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;



//import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class SingletonTest {

    @Test
    public void testSingleton() {
        RobotThread threadA = new RobotThread();
        threadA.init("threadA", 300);
        threadA.start();
        
        RobotThread threadB = new RobotThread();
        threadB.init("------------------------------threadB", 500);
        threadB.start();
        
        Thread thread = new Thread();
        try {
            thread.sleep(1700);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("testSingleton stops");
        }
        
        threadA.stopThread();
        threadB.stopThread();
        Singleton.getInstance().dispData();
        
    }


}
