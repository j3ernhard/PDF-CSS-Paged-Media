package me.jungwirth.playground.springboot.pdf.pagedmedia.service;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import me.jungwirth.playground.springboot.pdf.pagedmedia.service.OpenDataService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class OpenDataServiceTest {
    

    @Autowired
    private OpenDataService openDataService;

    @Test
    public void testGetOpenDataList() {

        try {
            openDataService.getELadeStelleData();
        } catch (IOException e) {
            
            e.printStackTrace();
        }

    }

}
