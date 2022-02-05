package me.jungwirth.playground.springboot.pagedmedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * read data from open data portal and generate pdf file 
 * https://github.com/wkhtmltopdf/wkhtmltopdf
 * 
 * Elektroladestationen Wien
 * https://www.data.gv.at/katalog/dataset/336bbdae-a29d-47c5-8c0d-f51affffd44f
 * 
 */
@SpringBootApplication
public class PagedmediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PagedmediaApplication.class, args);
	}

}
