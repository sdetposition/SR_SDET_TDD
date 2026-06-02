package com.parabank.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.parabank.BaseTest;
import com.parabank.pages.AccountsOverviewPage;

public class AccountsOverviewTest extends BaseTest {
	AccountsOverviewPage accOverViewPage;
	
	@BeforeClass
	public void setUpAccOverViewPage() {		
		accOverViewPage = new AccountsOverviewPage(getDriver());
	}
	
	@Test(priority = 1)
	public void verify_AccOverView_Link() {
		accOverViewPage.clickOnOverViewLink();
		String actResult = accOverViewPage.verifyAccountsSection();
		Assert.assertEquals(actResult, "Accounts Overview");
	}
	
	@Test(priority = 2)
	public void verifyAccNum() {
		String accNum = accOverViewPage.getAccNumber();
		Assert.assertEquals(accNum, accNum);
	}
	
	@Test(priority = 3)
	public void verifyAccbalance() {
		String accbal = accOverViewPage.getAccBalance();
		Assert.assertEquals(accbal.replace("$", ""), "515.50");
		System.out.println("Testing ");
		
	}

}
