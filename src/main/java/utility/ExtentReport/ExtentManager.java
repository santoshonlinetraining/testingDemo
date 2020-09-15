package utility.ExtentReport;

import java.io.File;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter(){
        if(extent == null){
/*   For local Project setup : 
 *             //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            extent = new ExtentReports(workingDir+"\\ExtentReports\\ExtentReportResults.html", true);
            extent.loadConfig(new File(System.getProperty("user.dir")+"/src/main/resources/Config/extent-config.xml"));
*/
        	File jarPath=new File(ExtentManager.class.getProtectionDomain().getCodeSource().getLocation().getPath());
	        String currentPath=jarPath.getParentFile().getAbsolutePath();
	        extent = new ExtentReports(currentPath+"\\ExtentReports\\ExtentReportResults.html", true);
            extent.loadConfig(new File(currentPath+"/Config/extent-config.xml"));
        }
        return extent;
    }
}
