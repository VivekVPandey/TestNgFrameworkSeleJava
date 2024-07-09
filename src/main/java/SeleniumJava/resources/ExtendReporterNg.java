package SeleniumJava.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public  class ExtendReporterNg {

	
	public static ExtentReports gerReportObject() {
		
		String path= System.getProperty(System.getProperty("user.dir")+"\\reports\\index.html");
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Vivek's Automation Report");
		
		ExtentReports extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Vivek");
		return extent;
	}
}
