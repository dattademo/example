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

public class GoogleResultPage extends Page{

	public GoogleResultPage(WebDriver driver, int timeout) {
		super(driver,timeout);
	}
	
	public String resultContainerClassName = "_NId"; 
	public String firstLinkContainerClassName = "rc";
	public String linkTagName = "a"; 
	
	@FindBy(id = "ires")
	public WebElement mainContainer;
	
	
}
