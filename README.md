# PDF Erstellung mit HTML und CSS Paged Media 

Beispielprojekt zum Artikel PDFs mit HTML und CSS automatisiert erstellen auf heise.de/developer:  
https://www.heise.de/hintergrund/Auf-Knopfdruck-PDFs-in-Anwendungen-erstellen-mit-HTML-und-CSS-Modul-6457863.html


## HTML und CSS Paged Media 

### Example 1 

Beispiel 1 zeigt die Verwendung von HTML und CSS Paged Media zur Erstellung eines Dokuments im A4 Layout. 

### Example 2

In Beispiel 2 wird ein Ticket erstellt, welches ein eigenes Format hat und einen QR-Code als SVG beinhaltet

## PDF Erstellung mit einer Spring Boot Anwendung

Dieses Beispiel zeigt die Erstellung von PDF Dokumenten mit einer Java Anwendung. 

Die Daten werden von einem Open Data Datensatz der Stadt Wien geladen.  
https://www.data.gv.at/katalog/dataset/336bbdae-a29d-47c5-8c0d-f51affffd44f

### PagedMedia 

Das PDF-Dokument wird mit HTML und CSS Paged Media erstellt, wobei HTML Templates zum Einsatz kommen. 
Als Template Engine wird Thymeleaf (https://www.thymeleaf.org/) verwendet.

Mit dem `OpenDataService` werden die Daten von der JSON Datei geladen und anschließend transformiert. 

Die aufbereiteten Daten werden dann in die Datenstruktur für den Report als `Chapter` überführt. Dabei wird auch das Inhlatsverzeichnis erstellt. 

Anschließend wird das Template mit den Reportdaten befüllt und daraus das fertige HTML erstellt. 

Mit der HTML Datei und den Stylesheets wird der `PrinceWrapper` zur Erstellung des PDF Dokuemnts aufgerufen. 

### Apache FOP 

Die Daten liegen in einer XML Datei vor und gemeinsam mit einem XSLT Dokument wird daraus ein PDF erstellt. 


### Apache PDFBox

Es wird ein PDF-Dokument mit der Bibliothek PDFBox erstellt. 





