abstract class ReportGenerator {
    public final void generateReport() {
        formatHeader();
        formatBody();
        formatFooter();
    }

    protected abstract void formatHeader();
    protected abstract void formatBody();
    protected abstract void formatFooter();
}

class PDFReportGenerator extends ReportGenerator {
    protected void formatHeader() {
        System.out.println("PDF Header");
    }

    protected void formatBody() {
        System.out.println("PDF Body");
    }

    protected void formatFooter() {
        System.out.println("PDF Footer");
    }
}

class HTMLReportGenerator extends ReportGenerator {
    protected void formatHeader() {
        System.out.println("HTML Header");
    }

    protected void formatBody() {
        System.out.println("HTML Body");
    }

    protected void formatFooter() {
        System.out.println("HTML Footer");
    }
}

public class Report {
    public static void main(String[] args) {
        ReportGenerator pdfReport = new PDFReportGenerator();
        pdfReport.generateReport();

        ReportGenerator htmlReport = new HTMLReportGenerator();
        htmlReport.generateReport();
    }
}
