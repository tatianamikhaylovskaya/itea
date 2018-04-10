package test;

import org.testng.Assert;
import org.testng.annotations.*;
import page.LinkedInLoginPage;
import page.LinkedinHomePage;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest extends LinkedinBaseTest{

    @DataProvider
    public Object[][] successfulLoginTest() {
        return new Object[][]{
                {"chudnayatest@gmail.com", "Xelyfz!6"},
                {"CHUDNAYATEST@gmail.com", "Xelyfz!6"}};

    }

    /**
     * Verifies that user logged in successfully if valid email and password are entered
     * @return the Home page
     */

    @Test (dataProvider ="successfulLoginTest")
    public void successfulLoginTest(String email, String password){
       String initialPageTitle = landingPage.getPageTitle();
       String initialPageUrl = landingPage.getPageUrl();

        Assert.assertEquals(initialPageTitle, "LinkedIn: Log In or Sign Up",
                "Login page title is wrong");

        LinkedinHomePage homePage = landingPage.loginAs(email, password);

        Assert.assertTrue(homePage.isSignedIn(), "User is not signed in");

        Assert.assertNotEquals(homePage.getPageTitle(), initialPageTitle,
                "Page title did not change after login");
        Assert.assertNotEquals(homePage.getPageUrl(), initialPageUrl,
                "Page url did not change after login");
    }

        @DataProvider
        public Object[][] negativeTestCredentialsReturnedToLanding() {
        return new Object[][]{
                {"", ""},
                {"chudnayatest@gmail.com", ""},
                {"", "Xelyfz!6"}};

        }

    /**
     * Verifies that if at least one field is empty while log in - user stays on the same page
     * @return the same page, Landing page
     */

    @Test(dataProvider= "negativeTestCredentialsReturnedToLanding")
    public void negativeLoginTestReturnedToLanding(String email, String password) {
        String initialPageTitle = landingPage.getPageTitle();
        String initialPageUrl = landingPage.getPageUrl();

        Assert.assertEquals(initialPageTitle, "LinkedIn: Log In or Sign Up",
                "Login page title is wrong");

        //LinkedInLoginPage loginPage = landingPage.loginAs(email, password);
        // Assert.assertTrue(loginPage.isNotSignedIn(), "User is signed in");

        landingPage = landingPage.loginAs(email, password);
        Assert.assertEquals(landingPage.getPageUrl(), initialPageUrl, "different page URL is loaded");
    }


    @DataProvider
    public Object[][] negativeTestCrdentialsReturnedToLogin() {
        return new Object[][]{
                {"wwww", "rrr", "Укажите действительный адрес эл. почты.", "Пароль должен содержать не менее 6 символов."},
                {"wwwwd", "rrrf", "Укажите действительный адрес эл. почты.", "Пароль должен содержать не менее 6 символов."}};

    }

    /**
     * Verifies that user redirected to the Login page and Error message is shown if invalid email and password are entered
     * @return Login page
     */

        @Test(dataProvider="negativeTestCrdentialsReturnedToLogin")
        public void negativeLoginTestReturnedToLogin (String email, String password,String emailErrorMessage, String passwordErrorMessage) {
            String initialPageTitle = landingPage.getPageTitle();
            String initialPageUrl = landingPage.getPageUrl();

            Assert.assertEquals(initialPageTitle, "LinkedIn: Log In or Sign Up",
                    "Login page title is wrong");

            LinkedInLoginPage loginPage = landingPage.loginAs(email, password);
            Assert.assertNotEquals(loginPage.getPageUrl(), initialPageUrl, "different page URL is loaded");

            String actualEmailMessage = loginPage.getEmailError();
            String actualPasswordMessage = loginPage.getPasswordError();

            Assert.assertEquals(emailErrorMessage, actualEmailMessage, "Actual and Expected Email messages do not match");
            Assert.assertEquals(passwordErrorMessage, actualPasswordMessage, "Actual and Expected Password messages do not match");





            //LinkedInLoginPage loginPage = landingPage.loginAs(email, password);
            // Assert.assertTrue(loginPage.isNotSignedIn(), "User is signed in");


     //   Assert.assertTrue(loginPage.isNotSignedIn(), "User is signed in");

     //   Assert.assertNotEquals(loginPage.getPageTitle(), initialPageTitle,
                //"Page title did not change after login");
       // Assert.assertNotEquals(loginPage.getPageUrl(), initialPageUrl,
             //   "Page url did not change after login");
    }
}


    /*public void negativeLoginTest(){
        LinkedinLandingPage loginPage = new LinkedinLandingPage(driver);
        loginPage.loginAs("taraschudnyy@gmail.com");
        WebElement initialPageAlert = loginPage.getPageAlert();

        Assert.assertTrue(initialPageAlert.isDisplayed(), "Alert message is not displayed.");
    }*/




   /*@Test
    public void negativeLoginTest(){

        driver.get("https://www.linkedin.com/");
        WebElement emailField = driver.findElement(By.xpath("//*[@id='login-email']"));
        //WebElement emailField = driver.findElement(By.id("login-email"));// такаяже строка как и верхняя
        WebElement paswordField = driver.findElement(By.xpath("//*[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.id("login-submit"));

        emailField.sendKeys("taraschudnyy@gmail.com");
        paswordField.sendKeys("Xelyfz!6");
        signInButton.click();

        WebElement alertMessage = driver.findElement(By.xpath("//div[@id='global-alert-queue']//strong[not(text()='')]"));

        Assert.assertTrue(alertMessage.isDisplayed(),"Alert message is not displayed");

        }
        }


//Assert.assertTrue(driver.getTitle().equals(initialPageTitle), "Page title did not change after login");

/* WebElement emailField = driver.findElement(By.xpath("//*[@id='login-email']"));
    //WebElement emailField = driver.findElement(By.id("login-email"));// такаяже строка как и верхняя
    WebElement paswordField = driver.findElement(By.xpath("//*[@id='login-password']"));
    WebElement signInButton = driver.findElement(By.id("login-submit"));

    emailField.sendKeys("taraschudnyy@gmail.com");
    paswordField.sendKeys("Xelyfz!6");
    signInButton.click();
    sleep(5000);
        WebElement userIcon = driver.findElement(By.id("profile-nav-item"));*/
// Assert.assertTrue(userIcon.isDisplayed(), "user icon was not displayed");

/*
        //sleep(5000);
      //driver.getCurrentUrl();
       // String expectedUrl = "https://www.linkedin.com/feed/";
      // String actualUrl = driver.getCurrentUrl();
       // Assert.assertEquals(actualUrl, expectedUrl);
       // Assert.assertEquals(driver.getCurrentUrl(), expectedUurl);
       // Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/feed/");
       // WebElement messagingIcon = driver.findElement(By.xpath("//span[@id='messaging-tab-icon']"));
       // Assert.assertTrue(messagingIcon.isDisplayed());
       */
