package test;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.LinkedInResetPasswordSuccessPage;
import page.LinkedinChooseNewPasswordPage;
import page.LinkedinPasswordResetSubmitPage;
import page.LinkedinRequestPasswordResetPage;
import utils.GMailService;

public class LinkedinPasswordResetTest extends LinkedinBaseTest{

    String userEmail = "chudnayatest@gmail.com";
    String newPassword = "Stanislav123";

    @Test
    public void successfulPasswordReset() {
        LinkedinRequestPasswordResetPage requestPasswordResetPage = landingPage.forgotPasswordLinkClick();
        Assert.assertTrue(requestPasswordResetPage.isLoaded(), "requestPasswordResetPage is not loaded");
        GMailService GMailService = new GMailService();
        LinkedinPasswordResetSubmitPage passwordResetSubmitPage = requestPasswordResetPage.submitEmail(userEmail);
        //Manually selected "email" option and "Submit" button. Need to automate.
        //Assert.assertTrue(passwordResetSubmitPage.isLoaded(), "passwordResetSubmitPage is not loaded");

        //read email
        String messageSubjectPartial = "here's the link to reset your password";
        String messageToPartial = "chudnayatest@gmail.com";
        String messageFromPartial = "security-noreply@linkedin.com";
        String message = GMailService.waitForNewMessage(messageSubjectPartial, messageToPartial, messageFromPartial, 60);
        System.out.println("Content: " + message);

        String resetPasswordLink = StringUtils.substringBetween(message, "browser:", "This link").trim();
        LinkedinChooseNewPasswordPage chooseNewPasswordPage = passwordResetSubmitPage.navigateToResetPasswordLink(resetPasswordLink);
        LinkedInResetPasswordSuccessPage resetPasswordSuccessPage = chooseNewPasswordPage.submitNewPassword(newPassword);

        //proceed with next steps here

    }
}