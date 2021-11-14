package com.prussf.fortuneservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

@Component
public class FileRandomFortuneService implements FortuneService {

    private List<String> fortunes;

    @Autowired
    public FileRandomFortuneService(Path pathToFortuneFile) {
        try {
            fortunes = Files.readAllLines(pathToFortuneFile);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Override
    public String getFortune() {
        int rdmIdx = (new Random()).nextInt(fortunes.size());
        return fortunes.get(rdmIdx);
    }
}
