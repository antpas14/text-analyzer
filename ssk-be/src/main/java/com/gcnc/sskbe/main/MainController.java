package com.gcnc.sskbe.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
    @Autowired MainServiceImpl mainService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @CrossOrigin
    @RequestMapping(value = "/getMetadata", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public WordResponse getMetadata(@RequestBody MetaDataRequest request) {
        logger.debug("Request is ", request);
        WordResponse response = new WordResponse();
        response.setCharactersNumber(mainService.getCharacters(request.getData()));
        response.setWordCount(mainService.getWordsNumber(request.getData()));
        response.setWordLength(mainService.getWordsLength(request.getData()));
        response.setCharactersFromPattern(mainService.getCharactersFromPattern(request.getData(), request.getPattern()));
        response.setWordsFromPattern(mainService.getWordsFromPattern(request.getData(), request.getPattern()));
        logger.debug("Response is ", response);
        return response;
    }
}
