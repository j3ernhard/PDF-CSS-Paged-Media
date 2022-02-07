package me.jungwirth.playground.springboot.pdf.apachepdfbox.service;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Service;

@Service
public class PdfGenerationService {
    


    public void generatePdf() throws IOException {

        try (PDDocument document = new PDDocument()) {

            

            PDPage page = new PDPage();
            
            document.addPage(page);

            try (PDPageContentStream content = new PDPageContentStream(document, page)) {
                content.beginText();

                content.setFont(PDType1Font.TIMES_ROMAN, 12);
                content.setLeading(14.5f);

                content.newLineAtOffset(25, 700);
                String text = "Apache PDFBox with Spring Boot";

                content.showText(text);
                content.newLine();

                content.endText();


            }

            document.save("C:\\Users\\Bernhard\\Development\\PDFGeneration\\ApachePDFBox\\ApachePDFBox.pdf");
        }

    }
}
