package com.prussf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
@ComponentScan("com.prussf")
public class ApplicationContext {

    @Bean("fortuneDataFile")
    public Path namedFile() throws MalformedURLException, URISyntaxException {
        Path namedFile = Paths.get(new URL("file://resources/fortune-data.txt").toURI());
        return namedFile;
    }
}
