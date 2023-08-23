import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.image.BufferedImage;
import java.io.File;

import org.json.*;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.chrome.ChromeDriverService;


public class TestImplementation {

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver");
    }

@Test
public void doTest()
{
    //  create a driver
    //  fixed size so screen shots will compare.
    ChromeOptions options = new ChromeOptions();
    options.setHeadless(true);
    options.addArguments("--window-size=1024x768");
    WebDriver driver = new ChromeDriver(options);
    
    //  go to the web site and verify that we got there.
    driver.get("https://www.ross-perry.com");
    assertThat(driver.getTitle(), containsString("Fred"));
    
    //  quit
    driver.quit();
    
    
}
// {
//     String url = "https:/www.ross-perry.com";
//     String newShotPath = "/Users/fredrossperry/Desktop/screenshot.png";
//     String oldShotPath = "/Users/fredrossperry/Desktop/screenshot-save.png";
//     String diffPath = "/Users/fredrossperry/Desktop/screenshot-diff.png";
	
//     //  create a driver
//     //  fixed size so screen shots will compare.
//     ChromeOptions options = new ChromeOptions();
//     options.setHeadless(true);
//     options.addArguments("--window-size=1024x768");
//     WebDriver driver = new ChromeDriver(options);

//     //  go to the web site and verify that we got there.
//     driver.get(url);
//     assertThat(driver.getTitle(), containsString("Fred"));

//     //  find and click on the "Original Songs" tab
//     //  and verify
//     WebElement originalSongsTab = driver.findElement(By.xpath("//a[contains(.,'Original Songs')]"));
//     originalSongsTab.click();
// 	assertThat(driver.getTitle(), containsString("Original Songs"));

//     //  take a screen shot and save to a file
//     File destFile = new File(newShotPath);
//     TakesScreenshot scrShot =((TakesScreenshot)driver);
//     assertNotNull("srcShot is null", scrShot);
//     File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
//     assertNotNull("srcFile is null", srcFile);
//     try {
//     	FileUtils.copyFile(srcFile, destFile);
//     }
//     catch (Exception e){
//     	assert(false);
//     }

//     //  compare with a saved screen shot
//     try{
//         BufferedImage expectedImage = ImageIO.read(new File(oldShotPath));
//         BufferedImage actualImage = ImageIO.read(new File(newShotPath));
//         Boolean same = bufferedImagesEqual(expectedImage, actualImage);

//         //  produce a diff using imagemagick compare
//         Runtime rt = Runtime.getRuntime();
//         Process pr = rt.exec(String.format("compare %s %s %s", oldShotPath, newShotPath, diffPath));
//         int retVal = pr.waitFor();

//         assert(same);
//     }
//     catch (Exception e)
//     {
//         assert(false);
//     }

//     //  quit
//     driver.quit();
// }


//     @Test
//     public void doTest()
//     {   
//         //  create a driver
//         //  fixed size so screen shots will compare.
//         ChromeOptions options = new ChromeOptions();
//         options.setHeadless(true);
//         options.addArguments("--window-size=1024x768");
//         WebDriver driver = new ChromeDriver(options);
// 
//         //  go to the web site and verify that we got there.
//         driver.get("http://127.0.0.1:8000/users");
// 		String pre = driver.findElement(By.tagName("pre")).getText();
// 		// System.out.println(pre);
// 
//         JSONObject json = new JSONObject(pre);
//         System.out.println("hey hey hey"+json.toString());
// 
// 
// 
//         //  quit
//         driver.quit();
//     }

    //  this does a pixel-by-pixel comparison of two images.
    private boolean bufferedImagesEqual(BufferedImage img1, BufferedImage img2) 
    {
        if (img1.getWidth() == img2.getWidth() && img1.getHeight() == img2.getHeight()) {
            for (int x = 0; x < img1.getWidth(); x++) {
                for (int y = 0; y < img1.getHeight(); y++) {
                    if (img1.getRGB(x, y) != img2.getRGB(x, y))
                        return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

}
