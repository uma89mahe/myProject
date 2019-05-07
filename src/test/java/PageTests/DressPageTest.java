package PageTests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import homePageObjects.BasePage;
import homePageObjects.HomePageObjects;
import homePageObjects.dressPageObjects;

public class DressPageTest {
	dressPageObjects dressPage;
	HomePageObjects homePage;
	BasePage bp;

	public dressPageTests() {
		dressPage = new dressPageObjects();
		homePage = new HomePageObjects();
		bp = new BasePage();
	}

	@BeforeTest
	public void beforecart() {
		homePage.clickDressTab();
	}
	
	@Test
	public void sizeCheck() {
	//	homePage.clickDressTab();
		Assert.assertTrue(dressPage.elementFound(dressPage.sizeSmall()));
		Assert.assertTrue(dressPage.elementFound(dressPage.sizeMedium()));
		Assert.assertTrue(dressPage.elementFound(dressPage.sizeLarge()));
	}

	@Test
	public void matchingSizeCount() {
	//	homePage.clickDressTab();
		int actual = dressPage.getProductNumberFromHeader();
		int expected = dressPage.getProductsCount();
		Assert.assertTrue(actual == expected, "Failed:Count mismatched");
		// Assert.assertTrue(dressPage.getProductNumberFromHeader() ==
		// dressPage.getProductsCount(), " Failed:Count mismatched");
	}
	
	

	@Test
	public void addToCart() {
		homePage.clickDressTab();
		dressPage.addCart();
		Assert.assertTrue(dressPage.elementFound(dressPage.cartPopUp()));
		dressPage.closePop();
		Assert.assertTrue(dressPage.verifyCart() > 0, "Failed: Cart empty");
	}
	
	

	@Test
	public void dressAscendingOrder() {
	//	homePage.clickDressTab();
		dressPage.orderByAscending();	
		
		ArrayList<Double> checkPrice = new ArrayList<Double>();
		checkPrice.addAll(dressPage.verifyProductPrice());
		for (int i = 0; i < checkPrice.size() - 1; i++) {
			Assert.assertTrue(checkPrice.get(i) < (checkPrice.get(i + 1)));
		}
		}
	
	

	@Test
	public void verifyDiscountPrice() {
		//homePage.clickDressTab();
		dressPage.listView().click();
		List<WebElement> pdts = dressPage.getProducts();
		for(WebElement product: pdts) {
			if(dressPage.discountProducts(product)== true) {
			Assert.assertTrue(dressPage.oldPriceList(product), "Old Price unavailable");
		}
		}
		}
		
		
	/*
	@Test
	public void discountCheckMethod2() {
		homePage.clickDressTab();
		dressPage.listView().click();
		List<WebElement> pdts = dressPage.discountPrice();
		for(WebElement product: pdts) {
		if((dressPage.elementFound(product))&& (product.getText()== "Reduced price!")) {
			System.out.println(product.getText());
			Assert.assertTrue(dressPage.oldPriceList(product), "Discount price unavailable");
			
		}
	}
	}
	*/
	

}
