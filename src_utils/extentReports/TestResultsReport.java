package extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestResultsReport {

	public static ExtentReports reports() {
		String path = System.getProperty("user.dir") + "\\Reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Test results");
		reporter.config().setDocumentTitle("Excler Assignment Results");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Mohan");

		return extent;

	}
}
