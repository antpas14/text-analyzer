package com.gcnc.sskbe.main;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class WordResponse {
    private Long wordCount;
    private Map<Character, Long> charactersNumber;
    private Map<Long, Long> wordLength;
    private String charactersFromPattern;
    private String wordsFromPattern;

    WordResponse() {};
}
