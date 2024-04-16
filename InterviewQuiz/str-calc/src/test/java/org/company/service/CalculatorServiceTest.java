package org.company.service;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


public class CalculatorServiceTest {
    private static CalculatorService calServ;
    private static Map<String, String> dataMap = new HashMap<>();
    private static Set<Map.Entry<String, String>> mapEntrySet = new HashSet<>();

    @BeforeAll
    private static void setup() {
        calServ = new CalculatorService();
        dataMap.put("\"\"","0");
        dataMap.put("\"\", \"1\"","0,1");
        dataMap.put("\"\", \"1\", \"1,5\"","0,1,6");
        dataMap.put("\"3\\n4,3\"","10");
        dataMap.put("\"//;\\n3;2\"","5");
        dataMap.put("\"//[***]\\n10***20***30\"","60");
        dataMap.put("\"//[*][%]\\n50*20%30\"","100");
        dataMap.put("\"//[**][%%]\\n100**20%%30\"","150");
        dataMap.put("\"2,1000\", \"1001\"","1002,0");
        mapEntrySet = dataMap.entrySet();
    }

    @Test
    public void testAdd() {
        for (Map.Entry<String, String> mapEntry: mapEntrySet) {
            assertEquals(calServ.add(mapEntry.getKey()), mapEntry.getValue());
        }
    }

    @Test
    public void testNegativeNumException() {
        Exception exception = assertThrows(RuntimeException.class, () -> calServ.add("\"10,5,-5,-1,4\""));
        String expectedMessage = "negative numbers not allowed <-5,-1>";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
