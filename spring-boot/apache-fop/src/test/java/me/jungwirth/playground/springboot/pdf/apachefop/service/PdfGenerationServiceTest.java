package me.jungwirth.playground.springboot.pdf.apachefop.service;

import java.io.IOException;

import javax.xml.transform.TransformerException;

import org.apache.fop.apps.FOPException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PdfGenerationServiceTest {

    @Autowired
    private PdfGenerationService pdfGenerationService;

    @Test
    public void testGeneratePdfFile() {

        try {
            pdfGenerationService.generatePdf();
        } catch (IOException | FOPException | TransformerException e) {
            e.printStackTrace();
        }

    }
}