/**
 * 
 */
/**
 * @author Damian
 *
 */
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleHomePage extends Page{

	// Google Home Page class with all webElements that are needed 
	
	public GoogleHomePage(WebDriver driver, int timeout) {
		super(driver,timeout);
	}
	
	@FindBy(id = "lst-ib")
	public WebElement searchInput;
	
	
}
