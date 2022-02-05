<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">
    <xsl:template match="stations">

        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="eladestelleA4" 
						page-height="297mm"
						page-width="210mm"
						margin-left="12mm"
						margin-right="12mm"
						margin-top="20mm"
						margin-bottom="20mm">
                    <fo:region-body />
					<fo:region-after extent="20mm"/>
				</fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="eladestelleA4">
				<fo:static-content flow-name="xsl-region-after">
					<fo:block text-align="center" font-size="12pt"> 
					-
					<fo:page-number/>
					-
					</fo:block>
				</fo:static-content>
				<fo:flow flow-name="xsl-region-body">
					<fo:block font-size="16pt" font-weight="bold" space-after="5mm"><xsl:value-of select="title"/>
					</fo:block>
					<fo:block font-size="10pt">
						<fo:table table-layout="fixed" width="100%" border-collapse="separate">    
							<fo:table-column column-width="3cm"/>
							<fo:table-column column-width="4cm"/>
							<fo:table-column column-width="7cm"/>
							<fo:table-column column-width="4cm"/>
							<fo:table-body>
								<xsl:apply-templates select="station"/>
							</fo:table-body>
						</fo:table>
					</fo:block>
				</fo:flow>
			</fo:page-sequence>

        
        </fo:root>
    </xsl:template>

    <xsl:template match="station">
		<fo:table-row>   
			<xsl:if test="designation = 'Manager'">
				<xsl:attribute name="font-weight">bold</xsl:attribute>
			</xsl:if>
			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="id"/>
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="address"/>
				</fo:block>
			</fo:table-cell>   
			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="designation"/>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="evseid"/>
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
	</xsl:template>

</xsl:stylesheet>

