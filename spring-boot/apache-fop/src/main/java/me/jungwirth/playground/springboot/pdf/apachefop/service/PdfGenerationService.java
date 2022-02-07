package me.jungwirth.playground.springboot.pdf.apachefop.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

@Service
public class PdfGenerationService {


	/**
	 * https://xmlgraphics.apache.org/fop/2.7/embedding.html
	 * 
	 * @throws IOException
	 * @throws FOPException
	 * @throws TransformerException
	 */
    public void generatePdf() throws IOException, FOPException, TransformerException {

        File xsltFile = ResourceUtils.getFile("classpath:templates/fop.template.xsl");
        File xmlFile = ResourceUtils.getFile("classpath:data/eladestationen.xml");

        StreamSource xmlSource = new StreamSource(xmlFile);

        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());

        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();

        OutputStream out;
        out = new FileOutputStream("C:\\Users\\Bernhard\\Development\\PDFGeneration\\ApacheFOP\\ApacheFOP.pdf");


        try {
			Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

			Result res = new SAXResult(fop.getDefaultHandler());

			transformer.transform(xmlSource, res);
		} finally {
			out.close();
		}
    }
    
}
