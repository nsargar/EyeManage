package com.app.eyemanage.service;

import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Repository;
import com.app.eyemanage.pojo.VisitDetailsPOJO;

@Repository
public interface PdfService {
	String dischargeSummary(VisitDetailsPOJO visit,HttpServletResponse response);
	String drugPrescription(VisitDetailsPOJO visit,HttpServletResponse response);
	String glassPrescription(VisitDetailsPOJO visit,HttpServletResponse response);
	String aScanReport(VisitDetailsPOJO visit,HttpServletResponse response);
}
