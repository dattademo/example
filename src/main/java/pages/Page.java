/**
 * 
 */
/**
 * @author Damian
 *
 */
package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

	protected WebDriver driver;
	WebDriverWait wait;
	private int timeout;

	// Generic page class

	public Page(WebDriver driver, int timeout) {
		this.driver = driver;
		this.timeout = timeout;
		PageFactory.initElements(this.driver, this);
		this.waitForPage();
	}

	// this method waits for the page to be completely loaded before start using every page
	private void waitForPage() {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((Boolean) ((JavascriptExecutor) driver).executeScript("return document.readyState")
						.equals("complete"));
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, this.timeout);
		wait.until(pageLoadCondition);

	}

}
