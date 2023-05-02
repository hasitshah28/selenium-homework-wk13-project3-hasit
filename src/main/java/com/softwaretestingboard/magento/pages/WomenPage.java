package com.softwaretestingboard.magento.pages;

import com.softwaretestingboard.magento.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WomenPage extends Utility {
    // Mouse Hover on Women Menu
    By womenMenu = By.xpath("//a[@id='ui-id-4']//span[contains(text(),'Women')]");
    // Mouse Hover on Tops
    By tops = By.linkText("Tops");
    // Click on Jackets
    By clickOnJackets = By.linkText("Jackets");
    By selectByFilterProductName = By.xpath("//div[2]//div[3]//select[1]");
    By selectByFilterPrice = By.xpath("//select[@id='sorter']");

    public void mouseHoverOnWomen() {
        mouseHoverToElement(womenMenu);
    }

    public void mouseHoverOnTop() {
        mouseHoverToElement(tops);
    }

    public void clickOnJacket() {
        clickOnElement(clickOnJackets);
    }

    public void selectFiletrFromDropDownList() {
        clickOnElement(selectByFilterProductName);
    }

    public void setSelectByFilterPrice() {
        selectByValueFromDropDown(selectByFilterPrice, "price");
    }

    public void getPriceLowToHigh() {
        List<WebElement> multiElement = driver.findElements(By.xpath("//span[@class='price-wrapper ']"));
        System.out.println("Total Items are: " + multiElement.size());
        double tmpValue = 0;
        for (WebElement list : multiElement) {
            String name1 = list.getText().replaceAll("[$]", "");
            System.out.println(name1);
            double itemValue = Double.valueOf(name1);
        }

    }
}
