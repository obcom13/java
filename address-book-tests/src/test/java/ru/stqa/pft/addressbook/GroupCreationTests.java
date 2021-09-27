package ru.stqa.pft.addressbook;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class GroupCreationTests {
    FirefoxDriver wd;

    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        wd.get("http://localhost:8080/addressbook/");
        wd.manage().window().setSize(new Dimension(1049, 707));
        auth("admin", "secret");
    }

    private void auth(String username, String userpass) {
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).sendKeys(userpass);
        wd.findElement(By.name("pass")).sendKeys(Keys.ENTER);
    }

    @Test
    public void testGroupCreation() {
        gotoGroupsPage();
        newGroup();
        fillGroupForm(new GroupData("test1", "test2", "test3"));
        submitGroupCreation();
        returnToGroupPage();
    }

    private void returnToGroupPage() {
        wd.findElement(By.linkText("group page")).click();
    }

    private void submitGroupCreation() {
        wd.findElement(By.name("submit")).click();
    }

    private void fillGroupForm(GroupData groupData) {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    private void newGroup() {
        wd.findElement(By.name("new")).click();
    }

    private void gotoGroupsPage() {
        wd.findElement(By.linkText("groups")).click();
    }

    @AfterMethod
    public void tearDown() { wd.quit();}

    public static boolean isAlertPresent (FirefoxDriver wd){
        try {
            wd.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException e) {
            return false;
        }
    }
}





