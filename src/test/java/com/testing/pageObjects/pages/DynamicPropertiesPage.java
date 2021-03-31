package com.testing.pageObjects.pages;

import org.openqa.selenium.By;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/dynamic-properties")
public class DynamicPropertiesPage extends ElementsPage {
  // Locators ----------------------------------------------------------------------------------------------------------
  public static By DYNAMIC_PROPERTIES_TITLE  = text("Dynamic Properties");
  public static By TEXT_TITLE  = css("//p[contains(text(), 'random')]");
  public static By WILL_ENABLE_5_SECONDS_BUTTON = css("#enableAfter");
  public static By COLOR_CHANGE_BUTTON = css("#colorChange");
  public static By VISIBLE_AFTER_5_SECONDS_BUTTON = css("#visibleAfter");
  // A custom message is thrown each time the user clicks a specific button
  public static By DOUBLE_CLICK_MESSAGE = css("p[id='doubleClickMessage']");
  public static By RIGHT_CLICK_MESSAGE =  css("p[id='rightClickMessage']");
  public static By DYNAMIC_CLICK_MESSAGE =  css("p[id='dynamicClickMessage']");
  // Public methods ----------------------------------------------------------------------------------------------------
  public void waitForPageToLoad() {
    getElement(DYNAMIC_PROPERTIES_TITLE).waitUntilPresent();
    logWeAreOnPage();
  }

}

