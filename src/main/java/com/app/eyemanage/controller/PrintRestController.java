package com.app.eyemanage.controller;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.eyemanage.pojo.VisitDetailsPOJO;
import com.app.eyemanage.service.VisitService;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

@RestController
@RequestMapping("/dashboard")
public class PrintRestController {
	private static final Logger logger = Logger.getLogger(PrintRestController.class);

	@Autowired
	VisitDetailsPOJO visit;

	@Autowired
	VisitService visitService;

	@RequestMapping(value= "/print/CaseReport_{id}.pdf")
	public String printDetails(@PathVariable("id")String id, HttpServletResponse response) {
		logger.info("In Print Post");

		// Set Paths
		String dir			=	System.getProperty("user.dir");
		final String home	=	System.getProperty("user.home") + "\\AppData\\Local\\EyeManage";
		File directory		=	new File(String.valueOf(home));
		if( !directory.exists() ){
			directory.mkdir();
		}
		String templatePDF	=	dir + "\\MyTemplate.pdf";
		String generatedPDF	=	home + "\\caseReport.pdf";


		PdfStamper stamper;
		PdfReader pdfReader;
		try {
			// Get Report Details
			visit	=	visitService.findOne(Integer.parseInt(id));

			// Write contents to PDF
			pdfReader	=	new PdfReader( templatePDF );
			logger.info("Temp file : " + pdfReader);
			FileOutputStream fileOS	=	new FileOutputStream( generatedPDF );
			stamper	=	new PdfStamper(pdfReader, fileOS);
			stamper.setFormFlattening(true);
			stamper.getAcroFields().setField("FirstName", visit.getPatient().getFirstName());
			logger.info("After writing");
			stamper.close();
			pdfReader.close(); 

			// Show PDF in a browser
			logger.info("Dir : " + dir);
			logger.info("Home : " + home);
			File file	=	new File( generatedPDF );
			InputStream inputStream = new FileInputStream(file);
			IOUtils.copy( inputStream, response.getOutputStream() );
			response.setContentType("application/pdf");
			response.setHeader("content-disposition", "inline");
			response.flushBuffer();
			logger.info("Try End");

		} catch ( IOException | DocumentException e ) {
			e.printStackTrace();
		}
		return null;
	}
}
