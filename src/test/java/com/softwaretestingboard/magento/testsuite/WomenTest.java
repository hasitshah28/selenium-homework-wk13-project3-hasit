package com.softwaretestingboard.magento.testsuite;

import com.softwaretestingboard.magento.pages.WomenPage;
import com.softwaretestingboard.magento.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomenTest extends BaseTest {
    WomenPage womenPage = new WomenPage();

    @Test
    public void verifyTheSortByProductNameFilter() {

        //Mouse Hover on Women Menu
        womenPage.mouseHoverOnWomen();

        //Mouse Hover on Tops
        womenPage.mouseHoverOnTop();

        //Click on Jackets
        womenPage.clickOnJacket();

        //Select Sort By filter “Product Name”
        womenPage.selectFiletrFromDropDownList();

        // Verify the products name display in alphabetical order
        List<WebElement> listOrder = driver.findElements(By.xpath("//div[2]//div[3]//select[1]/option[3]"));
        ArrayList<String> originalList = new ArrayList<>();
        for (WebElement e : listOrder) {
            originalList.add(e.getText());
        }
        System.out.println(originalList);
        Collections.sort(originalList);
        System.out.println(originalList);

        selectByVisibleTextFromDropDown(By.xpath("//select[@id='sorter']"), "Product Name");

        List<WebElement> listSorted = driver.findElements(By.xpath("//div[2]//div[3]//select[1]/option[3]"));
        ArrayList<String> listAfterSorting = new ArrayList<>();
        for (WebElement e : listSorted) {
            listAfterSorting.add(e.getText());
        }
        System.out.println(listAfterSorting);

        Assert.assertEquals(originalList, listAfterSorting);


    }

    @Test
    public void verifyTheSortByPriceFilter() {

        //Mouse Hover on Women Menu
        womenPage.mouseHoverOnWomen();

        //Mouse Hover on Tops
        womenPage.mouseHoverOnTop();

        //Click on Jackets
        womenPage.clickOnJacket();

        //Select Sort By filter “Price”
        womenPage.setSelectByFilterPrice();

        //Verify the products price display in Low to High
       womenPage.getPriceLowToHigh();
        }
    }
