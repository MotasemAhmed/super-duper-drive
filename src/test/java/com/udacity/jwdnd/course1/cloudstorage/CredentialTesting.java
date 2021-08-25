package com.udacity.jwdnd.course1.cloudstorage;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CredentialTesting extends CloudStorageApplicationTests {

    private void setCredentialFields(String url, String username, String password, HomePage homePage) {
        homePage.setCredentialUrl(url);
        homePage.setCredentialUsername(username);
        homePage.setCredentialPassword(password);
    }

    private void createAndVerifyCredential(String url, String username, String password, HomePage homePage) throws InterruptedException {
        createCredential(url, username, password, homePage);
        homePage.navToCredentialsTab();
        Credential credential = homePage.getFirstCredential();
        Assertions.assertEquals(url, credential.getUrl());
        Assertions.assertEquals(username, credential.getUsername());
        Assertions.assertNotEquals(password, credential.getPassword());
    }

    private void createCredential(String url, String username, String password, HomePage homePage) throws InterruptedException {
        homePage.navToCredentialsTab();
        homePage.addNewCredential();
        setCredentialFields(url, username, password, homePage);
        Thread.sleep(2000);
        homePage.saveCredentialChanges();
        Thread.sleep(3000);

        homePage.navToCredentialsTab();
    }

    @Test
    public void createCredentialTest() throws InterruptedException {
        HomePage homePage = getHomePage();
        Thread.sleep(1500);
        createAndVerifyCredential("https://www.youtube.com/", "Mo3ts", "P9421", homePage);
        Thread.sleep(1500);
        homePage.deleteCredential();
        homePage.logout();
    }

    @Test
    public void readUpdateCredentialTest() throws InterruptedException {
        HomePage homePage = getHomePage();
        createAndVerifyCredential("https://www.youtube.com/", "Mo3ts", "P9421", homePage);
        Credential credential = homePage.getFirstCredential();
        String firstEncryptedPassword = credential.getPassword();
        homePage.editCredential();
        String newUrl = "https://stackoverflow.com/";
        String newCredentialUsername = "Mo3tasem";
        String newPassword = "PPP=D";
        setCredentialFields(newUrl, newCredentialUsername, newPassword, homePage);
        homePage.saveCredentialChanges();
        homePage.navToCredentialsTab();
        Credential modifiedCredential = homePage.getFirstCredential();
        Assertions.assertEquals(newUrl, modifiedCredential.getUrl());
        Assertions.assertEquals(newCredentialUsername, modifiedCredential.getUsername());
        String modifiedCredentialPassword = modifiedCredential.getPassword();
        Assertions.assertNotEquals(newPassword, modifiedCredentialPassword);
        Assertions.assertNotEquals(firstEncryptedPassword, modifiedCredentialPassword);
        homePage.deleteCredential();
        homePage.logout();
    }

    @Test
    public void deletionCredentialTest() throws InterruptedException {
        HomePage homePage = getHomePage();
        createCredential("https://www.youtube.com/", "Mo3ts", "P9421", homePage);
        createCredential("https://stackoverflow.com/", "Mo3tasem", "PPP=D", homePage);
        createCredential("http://www.google.com/", "Mo", "NoPasswordToday", homePage);
        Assertions.assertFalse(homePage.noCredentials(driver));
        homePage.deleteCredential();
        homePage.navToCredentialsTab();
        homePage.deleteCredential();
        homePage.navToCredentialsTab();
        homePage.deleteCredential();
        homePage.navToCredentialsTab();
        Assertions.assertTrue(homePage.noCredentials(driver));
        homePage.logout();
    }
}
