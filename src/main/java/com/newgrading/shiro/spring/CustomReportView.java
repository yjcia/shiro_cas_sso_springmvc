package com.newgrading.shiro.spring;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;

import java.util.Map;

public class CustomReportView extends JasperReportsMultiFormatView {
    private JasperReport report;


    public CustomReportView() {
        super();
    }

    protected JasperPrint fillReport(Map<String, Object> model) throws Exception {
        if (model.containsKey("url")) {
            setUrl(String.valueOf(model.get("url")));
            this.report = loadReport();
        }

        return super.fillReport(model);
    }

    protected JasperReport getReport() {
        return this.report;
    }

// @Override
//    protected void renderReport(JasperPrint populatedReport,
//            Map<String, Object> model, HttpServletResponse response)
//            throws Exception {
//        if (model.containsKey("requestObject")) {
//              HttpServletRequest request = (HttpServletRequest) model.get("requestObject");
//              request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, populatedReport);
//        }
//        super.renderReport(populatedReport, model, response);
//    }
/*@Override
protected void postProcessReport(JasperPrint populatedReport, Map model)
throws Exception {


// HTML reports need the JasperPrint object in the session
if ("html".equalsIgnoreCase((String) model.get("format"))) {
session.setAttribute(
ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE,
populatedReport);
}
}*/
}