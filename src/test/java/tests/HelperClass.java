package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

public class HelperClass {
    public static String capture(WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String dest = "Reports/screenshots/screenshot"+getRandomDateTime()+".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);

        // Read the image file as bytes
        Path path = destination.toPath();
        byte[] imageBytes = Files.readAllBytes(path);

        // Encode the image bytes to base64
        String Screenshot_Image = Base64.getEncoder().encodeToString(imageBytes);

        return Screenshot_Image;
    }
    public static long getRandomDateTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddHmss");
        LocalDateTime now = LocalDateTime.now();
        long genNum;
        genNum= Long.parseLong(dtf.format(now).replaceAll(":","").replaceAll("/",""));
        //   log.info(genNum);
        return genNum;
    }
}
