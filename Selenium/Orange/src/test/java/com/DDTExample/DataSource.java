package com.DDTExample;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by PS2 on 24-Sep-17.
 */
public class DataSource {   // set the test data there
    @DataProvider(name = "userCredentials")   // Add the Data Source (Define data source here)
    private static Object[][] userCredentials(){    // Returning object Array (String..interger..etc)
        return new Object[][]{     // Creating data set. (This is create data set for testing)
                {"Admin","","Password cannot be empty"},
                {"","admin","Username cannot be empty"},
                {"Admin","admin1","Invalid credentials"},
                {"Admin1","admin","Invalid credentials"}
        };
    }


}
