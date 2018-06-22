package testngprogram;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FrameDungeon {
	WebDriver driver;
	private WebElement box1,box2;
	String box1_color, box2_color;
	boolean check = true;
	public FrameDungeon(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void box1Color() {
		box1 = driver.findElement(By.id("answer"));
		box1_color = box1.getAttribute("class");		
	}
	
	public void box2Color() {
		driver.switchTo().frame("child");
		box2 = driver.findElement(By.id("answer"));
		box2_color = box2.getAttribute("class");
		driver.switchTo().parentFrame();
	}
	
	public void repaintBox2() {
		driver.findElement(By.linkText("Repaint Box 2")).click();
	}

	public void proceed() {
		driver.findElement(By.linkText("Proceed")).click();
	}
	
	public void diffrentColor() {
		driver.switchTo().frame("main");
		proceed();
	}
	
	public void sameColor() {
		driver.switchTo().frame("main");
		box1Color(); box2Color();
		while (check) {
			if(box1_color.equals(box2_color))
				check = false;
			else {
				repaintBox2();
				box2Color();
			}
		}
		proceed();
		
	}
	
	public String getObstacleName() {
		driver.switchTo().parentFrame();
		return driver.findElement(By.xpath("/html/body/div[1]/div[2]/h1")).getText();
	}
}
