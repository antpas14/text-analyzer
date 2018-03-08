package com.gcnc.sskbe.main;

import java.util.List;
import java.util.Map;

public interface MainServiceInterface {
    Long getWordsNumber(String data);
    Map<Character, Long> getCharacters(String data);
    Map<Long, Long> getWordsLength(String data);

    String getCharactersFromPattern(String data, List<Long> pattern);
    String getWordsFromPattern(String data, List<Long> pattern);
}
