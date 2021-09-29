package com.bong.algorithm.kakao_mobility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution01 {

    private static final String DOT_COM = ".com";
    private static final String DELIMITER = ", ";

    public String solution(String S, String C) {
        String afterAddress = C.toLowerCase() + DOT_COM;
        String[] names = S.split(DELIMITER);

        Map<String, Integer> duplicateCheckMap = new HashMap<>();
        List<String> nameList = Arrays.stream(names).map(fullName -> fullName.split("\\s+"))
                .map(name -> getBeforeAddress(duplicateCheckMap, name))
                .collect(Collectors.toList());

        List<String> resultList = IntStream.range(0, names.length)
                .mapToObj(i -> String.format("%s <%s@%s>", names[i], nameList.get(i), afterAddress))
                .collect(Collectors.toList());

        return String.join(DELIMITER, resultList);
    }

    private String getBeforeAddress(Map<String, Integer> duplicateCheckMap, String[] name) {
        String lastName = getLastName(name[name.length - 1]);
        String firstName = getFirstName(name);

        return getResult(duplicateCheckMap, lastName, firstName);
    }

    private String getLastName(String lastName1) {
        String lastName = lastName1;
        lastName = lastName.replaceAll("-", "");
        if (lastName.length() > 8) {
            lastName = lastName.substring(0, 8);
        }
        return lastName;
    }

    private String getFirstName(String[] name) {
        String firstName;
        if (name.length > 2) {
            firstName = name[0].substring(0, 1) + name[1].substring(0, 1);
        } else {
            firstName = name[0].substring(0, 1);
        }
        return firstName;
    }

    private String getResult(Map<String, Integer> duplicateCheckMap, String lastName, String firstName) {
        String result = (firstName + lastName).toLowerCase();
        if (!duplicateCheckMap.containsKey(result)) {
            duplicateCheckMap.put(result, 1);
            return result;
        }

        duplicateCheckMap.computeIfPresent(result, (string, num) -> num + 1);
        return result + duplicateCheckMap.get(result);
    }
}
