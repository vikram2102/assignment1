package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class FlipkartHomePage extends TestBase {
	@FindBy(name="q")
	WebElement searchBar;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement searchBtn;
	
	@FindBy(xpath="//button[@class='_2AkmmA _29YdH8']")
	WebElement closeBtn;
	
	public FlipkartHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void setSearchBarText(String text) {
		searchBar.sendKeys(text);
	}
	
	public void clickOnSerach() {
		searchBtn.click();
	}
	
	public void closePopup() {
		closeBtn.click();
	}
}
