package testngprogram;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragMe {
	WebDriver driver;
	
	public DragMe(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="dropbox")
	private WebElement target;
	
    @FindBy(id="dragbox")
    private WebElement source;
    
    @FindBy(css="div.page>a")
    private WebElement proceed;
    
    public void noDrag() {
    	proceed.click();
    }
    
    public void correctDrag() {
    	Actions act = new Actions(driver);
    	act.dragAndDrop(source, target).build().perform();
    	proceed.click();
    }
    
    public String getObstacleName() {
		return driver.findElement(By.cssSelector("div.page>h1")).getText();
	}
}