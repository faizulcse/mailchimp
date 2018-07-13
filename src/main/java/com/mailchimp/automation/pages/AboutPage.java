package com.mailchimp.automation.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.mailchimp.automation.util.CSVFileHandler;
import com.mailchimp.automation.util.TestUtil;
import com.mailchimp.automation.base.TestBase;
import com.mailchimp.automation.model.LeadersInfo;


public class AboutPage extends TestBase{
	
	List<WebElement> leadershipList;
	
	public void scrollToLeadershipSection(){
		Actions actions = new Actions(driver);
		WebElement leadershipLabel = driver.findElement(By.xpath("//h2[contains(text(), 'Leadership Team')]"));
        actions.moveToElement(leadershipLabel);
        actions.perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
	}
	
	public void closeLeadershipDetailsWindow(){
		
		WebElement closeButton = driver.findElement(By.cssSelector("[class='close_btn icon-close-large']"));
		closeButton.click();
	}
	
	public List<WebElement> getLeadershipList(){
		leadershipList = driver.findElements(By.xpath("//div[contains(@class, 'col span1of4 large-span1of3 small-span1of2 ptb3 mb3 align-left')]"));
		
		return leadershipList;
	}
	
	public int getLeadershipElementCount(){
		return leadershipList.size();
	}

	public void clickLeadershipLinkElement(int index){
		WebElement element = leadershipList.get(index);
		element.click();
	}
	
	public LeadersInfo getLeadershipInfo(int index){
		clickLeadershipLinkElement(index);
		TestUtil.waitFor(2);
		String leaderName = driver.findElement(By.xpath("//*[@id='bio_view']/div/div[2]/div[2]/h3")).getText();
		TestUtil.waitFor(1);
		String designation = driver.findElement(By.xpath("//*[@id='bio_view']/div/div[2]/div[2]/span")).getText();
		TestUtil.waitFor(1);
		String details = driver.findElement(By.className("mt6")).getText();
		TestUtil.waitFor(2);
		closeLeadershipDetailsWindow();
		TestUtil.waitFor(2);
		
		//System.out.println(details);
		details = details.replaceAll("'","").replace("\"", "").replaceAll("’","");
		//System.out.println(details);
		LeadersInfo leadersInfo = new LeadersInfo(leaderName,designation,details);
		
		return leadersInfo;
	}
	
	public void saveLeadershipInfoToCSV() {
		getLeadershipList();
		int count = getLeadershipElementCount();
		
		List<LeadersInfo> leadersList = new ArrayList();
		for(int i=0;i<count;i++) {
			LeadersInfo leadersInfo = getLeadershipInfo(i);
			leadersList.add(leadersInfo);
			
			//System.out.println(leadersInfo.toString());
		}
		
		CSVFileHandler.writeCsvFile(leadersList);
	}
}
