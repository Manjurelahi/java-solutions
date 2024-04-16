package org.company.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CalculatorService {
    private static final int MAX_NUMBER = 1000;
    private static final String DEFAULT_DELIMITER = ",";

    private List<String> getDelimiterList(String numStr) {
        String delimiter = "";
        List<String> delimiterList = new ArrayList<>();
        if (numStr != null && !numStr.isEmpty()) {
            if (numStr.startsWith("\"//")) {
                numStr = numStr.substring(0, numStr.indexOf("\\n") + 2);
                if (numStr.length() == 6) {
                    delimiter = numStr.substring(3, numStr.indexOf("\\n"));
                    delimiterList.add(0, delimiter);
                } else if (numStr.startsWith("\"//[")) {
                    numStr = numStr.substring(0, numStr.indexOf("]\\n") + 3);
                    delimiter = (numStr.substring(4, numStr.indexOf("]\\n")));
                    if (delimiter.contains("]") && delimiter.contains("[")) {
                        String[] delimiterArray = delimiter.split("]\\[");
                        for (String delimiterStr : delimiterArray) {
                            delimiterList.add(delimiterStr);
                        }
                    } else {
                        delimiterList.add(0, delimiter);
                    }
                }
            } else {
                delimiterList.add(0, ",");
            }
        }
        return delimiterList;
    }

    private String[] getNumbers(String numStr, List<String> delimiterList) {
        if (numStr.startsWith("\"//")) {
            numStr = numStr.substring(numStr.indexOf("\\n"));
        }
        numStr = numStr.replace("\\n", DEFAULT_DELIMITER);
        for (String delimiter: delimiterList) {
            numStr = numStr.replace(delimiter, DEFAULT_DELIMITER);
        }
        return numStr.split(DEFAULT_DELIMITER);
    }

    private List<Integer> parseIntegerNumbers(String[] numbers) {
        List<String> negativeNumberList = new ArrayList<>();
        List<Integer> integerNumList = new ArrayList<>();
        for (String num: numbers) {
            if (num != null) {
                num = num.replace("\"", "");
                num = num.trim();
                if (!num.isEmpty()) {
                    int numVal = Integer.parseInt(num);
                    if (numVal < 0) {
                        negativeNumberList.add(num);
                    } else {
                        integerNumList.add(numVal);
                    }
                }
            }
        }
        if (negativeNumberList.size() > 0) {
            String negativeNumbers = negativeNumberList.stream().collect(Collectors.joining(DEFAULT_DELIMITER));
            throw new RuntimeException("negative numbers not allowed <"+negativeNumbers+">");
        }
        return integerNumList;
    }

    public String add(String inputCSV) {
        String result = "";
        int sum = 0;
        Map<String, Integer> map = new LinkedHashMap<>();
        if (inputCSV != null && !inputCSV.isEmpty()) {
            String[] numStrArray = inputCSV.split(DEFAULT_DELIMITER + " "+"\"");
            for (String numStr: numStrArray) {
                if (!numStr.isEmpty()) {
                    List<String> delimiterList = getDelimiterList(numStr);
                    String[] numbers = getNumbers(numStr, delimiterList);
                    List<Integer> integerNumList = parseIntegerNumbers(numbers);
                    sum = 0;
                    for (Integer integerNum: integerNumList) {
                        if (integerNum <= MAX_NUMBER) {
                            sum = sum + integerNum;
                        }
                    }
                    map.put(numStr, sum);
                }
            }
        }
        return map.values().stream().map(String::valueOf).collect(Collectors.joining(DEFAULT_DELIMITER));
    }
}
