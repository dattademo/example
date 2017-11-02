/**
 * 
 */
/**
 * @author Damian
 *
 */
package controllers;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageController {
	
	protected WebDriver driver;
	protected int timeout;
	protected WebDriverWait wait;
	
	protected Logger logger = LoggerFactory.getLogger(PageController.class.getName());
	
	public PageController(WebDriver driver, int timeout){
		this.driver = driver;
		this.timeout = timeout;
		this.wait = new WebDriverWait(this.driver, this.timeout);
		}
	
}
