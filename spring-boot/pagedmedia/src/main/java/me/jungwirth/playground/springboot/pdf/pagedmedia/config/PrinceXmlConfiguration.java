package me.jungwirth.playground.springboot.pdf.pagedmedia.config;

import java.io.File;
import java.io.FileNotFoundException;

import com.princexml.Prince;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

@Configuration
public class PrinceXmlConfiguration {
    

    private static final String princeExecutable = "C:\\Program Files (x86)\\Prince\\engine\\bin\\prince.exe";

    @Bean
    public Prince prince() throws FileNotFoundException {
        File cssFile = ResourceUtils.getFile("classpath:report.css");
        
        Prince prince = new Prince(princeExecutable);
        prince.setDebug(true);
        prince.addStyleSheet(cssFile.toString());
        return prince;
    }
}
