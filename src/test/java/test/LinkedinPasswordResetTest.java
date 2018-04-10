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

    /**
     * Verifies reset password process
     */
    public void successfulPasswordResetTest() {
        LinkedinRequestPasswordResetPage requestPasswordResetPage = landingPage.forgotPasswordLinkClick();
        Assert.assertTrue (requestPasswordResetPage.isLoaded(),
                "requestPasswordResetPage is not loaded");

        LinkedinPasswordResetSubmitPage requestPasswordSubmitPage = requestPasswordResetPage.submitEmail(userEmail);
        String resetPasswordLink = requestPasswordSubmitPage.getResetPasswordLinkFromEmail(userEmail);
        Assert.assertTrue(requestPasswordSubmitPage.isLoaded(), "Page isn't loaded");

        LinkedinChooseNewPasswordPage createNewPasswordPage = requestPasswordSubmitPage.navigateToResetPasswordLink(resetPasswordLink);
        Assert.assertTrue(createNewPasswordPage.isLoaded(), "Page isn't loaded");

        LinkedInResetPasswordSuccessPage passwordChangedPage = createNewPasswordPage.resetPassword(newPassword);
        Assert.assertTrue(passwordChangedPage.isLoaded(), "Page isn't loaded");
    }


}