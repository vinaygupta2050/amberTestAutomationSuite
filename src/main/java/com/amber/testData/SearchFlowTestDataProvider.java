package com.amber.testData;

import org.testng.annotations.DataProvider;

/**
 * @author : Vinaykumar Gupta
 * @Date 25/03/23
 */
public class SearchFlowTestDataProvider {
    @DataProvider(name = "task1")
    public Object[][] task1(){
        return new Object[][] {
                {"London","London","127","2","Chapter Old Street, London","Paul St, London, EC2A 4JH, United Kingdom"}
                };
    }
}
