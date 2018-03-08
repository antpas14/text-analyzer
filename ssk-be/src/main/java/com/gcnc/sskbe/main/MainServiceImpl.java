package com.gcnc.sskbe.main;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MainServiceImpl implements MainServiceInterface {
    @Override
    public Long getWordsNumber(String data) {
        return (long) data.split(" ").length;
    }

    @Override
    public Map<Character, Long> getCharacters(String data) {
        Map<Character, Long> response = new HashMap<>();
        for (Character c : data.replace(" ", "").toCharArray()) {
            response.merge(c, 1L, (a, b) -> a + b);
        }
        return response;
    }

    @Override
    public Map<Long, Long> getWordsLength(String data) {
        Map<Long,Long> response = new HashMap<>();
        Arrays.stream(data.split(" ")).forEach(word -> {
            response.merge((long) word.length(), 1L, (a, b) -> a + b);
        });
        return response;
    }

    @Override
    public String getCharactersFromPattern(String data, List<Long> pattern) {
        final String[] result = {""};

        String dataWithoutSpaces = data.replace(" ", "");
        List<String> arrayData = Arrays.asList(dataWithoutSpaces.split(""));
        pattern.forEach(idx -> {
            try {
                result[0] += arrayData.get(idx.intValue() - 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return result[0];
    }

    @Override
    public String getWordsFromPattern(String data, List<Long> pattern) {
        final String[] result = {""};

        List<String> dataArray = Arrays.asList(data.split(" "));
        pattern.stream().forEach(idx -> {
            try {
                result[0] += " " + dataArray.get(idx.intValue() - 1);
            } catch (Exception e) {
               e.printStackTrace();
            }
        });
        return result[0];
    }

}
