package net.slipp.user;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import net.slipp.qna.IndexPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {
    private static Logger log = LoggerFactory.getLogger(LoginPage.class);
    
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        assertThat(driver.getTitle(), is("로그인 :: SLiPP"));
    }

    public FacebookPage loginFacebook() {
        driver.findElement(By.cssSelector("input[value='페이스북 계정으로 로그인']")).click();
        if (driver.getTitle().equals("SLiPP")) {

        }

        return new FacebookPage(driver);
    }

    public IndexPage loginSlipp(final String userName) {
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.cssSelector(".btn-success")).click();
        return new IndexPage(driver);
    }

    public IndexPage loginToSlipp(final String userId, final String password) {
        log.debug("userId : {}, password : {}", userId, password);
        
        driver.findElement(By.id("authenticationId")).clear();
        driver.findElement(By.id("authenticationId")).sendKeys(userId);
        driver.findElement(By.id("authenticationPassword")).clear();
        driver.findElement(By.id("authenticationPassword")).sendKeys(password);
        driver.findElement(By.id("loginSubmitBtn")).click();
        return new IndexPage(driver);
    }

    public IndexPage join(String userId, String nickName, String email) {
        driver.findElement(By.id("userId")).clear();
        driver.findElement(By.id("userId")).sendKeys(userId);
        driver.findElement(By.id("nickName")).clear();
        driver.findElement(By.id("nickName")).sendKeys(nickName);
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.cssSelector(".btn-submit")).click();
        return new IndexPage(driver);

    }
}
