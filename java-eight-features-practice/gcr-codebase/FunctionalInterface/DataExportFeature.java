package FunctionalInterface;

interface ReportExporter {

    void export(String reportData);

    default void exportToJSON(String reportData) {
        System.out.println("JSON Export not supported yet.");
    }
}

class CSVExporter implements ReportExporter {

    @Override
    public void export(String reportData) {
        System.out.println("Exporting report to CSV: " + reportData);
    }
}

class PDFExporter implements ReportExporter {

    @Override
    public void export(String reportData) {
        System.out.println("Exporting report to PDF: " + reportData);
    }
}

class JSONExporter implements ReportExporter {

    @Override
    public void export(String reportData) {
        System.out.println("Exporting report to JSON: " + reportData);
    }

    @Override
    public void exportToJSON(String reportData) {
        System.out.println("Exporting report to JSON: " + reportData);
    }
}

public class DataExportFeature {
    public static void main(String[] args) {

        ReportExporter csv = new CSVExporter();
        csv.export("Sales Report");
        csv.exportToJSON("Sales Report"); // default method

        ReportExporter pdf = new PDFExporter();
        pdf.export("Employee Report");
        pdf.exportToJSON("Employee Report"); // default method

        ReportExporter json = new JSONExporter();
        json.export("Profit Report");
        json.exportToJSON("Profit Report"); // overridden
    }
}
