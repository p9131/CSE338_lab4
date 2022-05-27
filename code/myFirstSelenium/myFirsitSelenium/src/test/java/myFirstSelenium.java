import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;

import static org.junit.jupiter.api.Assertions.*;

public class myFirstSelenium {


    static WebDriver wd;
    static  final String WEB="http://formy-project.herokuapp.com/form";

    @BeforeAll
    public  static  void  initSelenium(){
        WebDriverManager.chromedriver().setup();
    }

    @Nested
    @DisplayName("Test Chrome")
    public  class Test_Chrome{

        @BeforeAll
        public static void initEdge(){
            wd = new ChromeDriver();
        }

        @Test
        public  void change_form(){
            wd.get(WEB);
            WebElement first_name = wd.findElement(By.id("first-name"));
            WebElement last_name = wd.findElement(By.id("last-name"));
            WebElement job_title = wd.findElement(By.id("job-title"));
            WebElement radio_button = wd.findElement(By.id("radio-button-2"));
            WebElement check_box = wd.findElement(By.id("checkbox-1"));
            check_box.click();
            WebElement btn_1 = wd.findElement(By.className("btn"));

            first_name.sendKeys("Abdel Rahman");
            last_name.sendKeys("Salah");
            job_title.sendKeys("Student");
            radio_button.click();
            assertTrue(Boolean.parseBoolean(check_box.getAttribute("checked")));

            btn_1.click();
        }

    }



    @AfterAll
    public static void Clear(){
        if(wd!=null){
            wd.quit();
        }
    }
}