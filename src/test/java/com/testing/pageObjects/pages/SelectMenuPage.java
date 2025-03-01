package com.testing.pageObjects.pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/select-menu")
public class SelectMenuPage extends WidgetsPage{
  // Locators ----------------------------------------------------------------------------------------------------------
  public static By SELECT_MENU_TITLE = text("Select Menu");
  public static By SELECT_VALUE = css("#withOptGroup > div > div.css-1hwfws3");
  public static By SELECT_ONE = css("#selectOne > div > div.css-1hwfws3");
  public static By OLD_STYLE_SELECT_MENU = css("select[id='oldSelectMenu']");
  public static By MULTISELECT_DROP_DOWN = css("#react-select-4-input");
  // Field containing selected values. Might need an xpath selector
  public static By MULTISELECT_DROP_DOWN_VALUES = xpath("//*[@id=\'selectMenuContainer\']/div[7]/div/div/div");
  public static By VOLVO = css("option[value='volvo']");
  public static By SAAB = css("option[value='saab']");
  public static By OPEL = css("option[value='opel']");
  public static By AUDI = css("option[value='audi']");
  // Selector that would allow to get either of given four car brands.
  public static By CAR_MENU_OPTIONS = xpath("//*[@id=\'cars\']");
  // Public methods ----------------------------------------------------------------------------------------------------
  public void waitForPageToLoad() {
    getElement(SELECT_MENU_TITLE).waitUntilPresent();
    logWeAreOnPage();
  }

  public void setElementValueTo(String elementName, String value){
    switch(elementName){
      case "SELECT_VALUE":
      case "OLD_STYLE_SELECT_MENU":
      case "SELECT_ONE":
        click(elementName);
        click(text(value));
        // Clicking title to loose focus
        getElement(SELECT_MENU_TITLE).click();
        break;
      case "MULTISELECT_DROP_DOWN":
        click(elementName);
        getElement(elementName).sendKeys(value);
        getElement(elementName).sendKeys(Keys.ENTER);
        // Clicking title to loose focus
        getElement(SELECT_MENU_TITLE).click();
        break;
      default:
        super.setElementValueTo(elementName, value);
    }
  }

  public Boolean validateStandardMultiSelect(DataTable data){
    for (Map<String, String> map : dataToMap(data)) {
      for (String key : map.keySet()) {
        String value = snakify(map.get(key));
        WebElementFacade e = getElement(snakify(value));
        info("Validating: " + value);
        if(e.getCssValue("background-color").contains("0, 0, 0, 0")) return false;
      }
    }
    return true;
  }
}
