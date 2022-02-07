package me.jungwirth.playground.springboot.pdf.pagedmedia.service;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;

import com.princexml.Prince;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

/**
 * PdfService with PrinceXML
 * https://www.princexml.com/doc/server-integration/
 * https://www.baeldung.com/spring-thymeleaf-fragments
 * @author Bernhard Jungwirth
 */

@Service
public class PdfGenerationService {

    private static final String reportTemplate = "report";
    

    @Autowired
    private SpringTemplateEngine templateEngine;

    @Autowired
    private Prince prince;

    public String processHtmlTemplate(Map<String,Object> values) {
        String html = "";

        Context context = new Context(Locale.GERMAN);
        context.setVariables(values);

        html = templateEngine.process(reportTemplate, context);

        return html;
    }

    public boolean generatePdf(String htmlContent, String pdfPath) throws IOException {

        return prince.convert(htmlContent, pdfPath);

    }

    
}