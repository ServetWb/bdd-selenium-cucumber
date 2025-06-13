package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static void wait(int sec) {
        try {
            Thread.sleep(sec * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> convertToStringList(List<WebElement> webElementList) {
        List<String> stringList = new ArrayList<>();
        for (WebElement element : webElementList) {
            stringList.add(element.getText());
        }
        return stringList;
    }

    public static void switchToWindowByUrl(WebDriver driver, String targetUrl) {
        Set<String> allHandles = driver.getWindowHandles();
        for (String handle : allHandles) {
            driver.switchTo().window(handle);
            if (driver.getCurrentUrl().equals(targetUrl)) break;
        }
    }

    public static void switchToWindowByTitle(WebDriver driver, String targetTitle) {
        Set<String> allHandles = driver.getWindowHandles();
        for (String handle : allHandles) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) break;
        }
    }

    public static void takeFullPageScreenshot(WebDriver driver) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File finalImage = new File("target/screenshots/fullPage.jpg");
        File tempImage = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(tempImage, finalImage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void takeFullPageScreenshot(WebDriver driver, String name) {
        wait(1);
        TakesScreenshot ts = (TakesScreenshot) driver;
        File finalImage = new File("target/screenshots/" + name + ".jpg");
        File tempImage = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(tempImage, finalImage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void takeFullPageScreenshotWithTimestamp(WebDriver driver) {
        wait(1);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("_ddMMyy_HHmmss"));
        TakesScreenshot ts = (TakesScreenshot) driver;
        File finalImage = new File("target/screenshots/fullPage" + timestamp + ".jpg");
        File tempImage = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(tempImage, finalImage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void takeFullPageScreenshotWithTimestamp(WebDriver driver, String name) {
        wait(1);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("_ddMMyy_HHmmss"));
        TakesScreenshot ts = (TakesScreenshot) driver;
        File finalImage = new File("target/screenshots/" + name + timestamp + ".jpg");
        File tempImage = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(tempImage, finalImage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void takeElementScreenshot(WebElement element) {
        File finalImage = new File("target/screenshots/element.jpg");
        File tempImage = element.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(tempImage, finalImage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void takeElementScreenshot(WebElement element, String name) {
        File finalImage = new File("target/screenshots/" + name + ".jpg");
        File tempImage = element.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(tempImage, finalImage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void takeElementScreenshotWithTimestamp(WebElement element) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("_ddMMyy_HHmmss"));
        File finalImage = new File("target/screenshots/element" + timestamp + ".jpg");
        File tempImage = element.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(tempImage, finalImage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void takeElementScreenshotWithTimestamp(WebElement element, String name) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("_ddMMyy_HHmmss"));
        File finalImage = new File("target/screenshots/" + name + timestamp + ".jpg");
        File tempImage = element.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(tempImage, finalImage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String takeScreenshotForReport(String testName) throws IOException {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("_yyMMdd_HHmmss"));
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File tempFile = ts.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/test-output/Screenshots/" + testName + timestamp + ".jpg";
        File finalFile = new File(path);
        FileUtils.copyFile(tempFile, finalFile);
        return path;
    }
}