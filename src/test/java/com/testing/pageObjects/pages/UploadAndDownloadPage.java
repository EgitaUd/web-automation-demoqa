package com.testing.pageObjects.pages;

import org.openqa.selenium.By;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/upload-download")
public class UploadAndDownloadPage extends ElementsPage{
  // Locators ----------------------------------------------------------------------------------------------------------
  public static By UPLOAD_AND_DOWNLOAD_TITLE = text("Upload and Download");
  public static By DOWNLOAD = css("#downloadButton");
  public static By SELECT_A_FILE = xpath("//*[@id=\'app\']/div/div/div[2]/div[2]/div[1]/div[2]/form/div/label");
  public static By CHOOSE_FILE = css("label[for='uploadFile']");
  public static By UPLOADED_FILE_PATH = css("#uploadedFilePath");


  // Public methods ----------------------------------------------------------------------------------------------------
  public void waitForPageToLoad() {
    getElement(UPLOAD_AND_DOWNLOAD_TITLE).waitUntilPresent();
    logWeAreOnPage();
  }

  public void setElementValueTo(String elementName, String value) {
    switch(elementName){

      case "CHOOSE_FILE":
        String currentDir = System.getProperty("user.dir");

        getElement(CHOOSE_FILE).sendKeys(currentDir + value);
        break;
      default:
        super.setElementValueTo(elementName, value);
    }
  }
}
