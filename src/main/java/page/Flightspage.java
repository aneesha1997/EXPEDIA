package page;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
public class Flightspage {
WebDriver driver;
By flights=By.xpath("//*[@id=\"wizardMainRegionV2\"]/div/div/div/div/ul/li[2]/a");
By leav=By.xpath("//*[@id=\"location-field-leg1-origin-menu\"]/div/div/div[1]/button");
By from=By.xpath("//*[@id=\"location-field-leg1-origin\"]");
By go=By.xpath("//*[@id=\"location-field-leg1-destination-menu\"]/div/div/div[1]/button");
By to=By.xpath("//*[@id=\"location-field-leg1-destination\"]");
By depart=By.xpath("//*[@id=\"d1-btn\"]");
By depmonth=By.xpath("//*[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/h2");
By nextclick1=By.xpath("//*[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div[1]/button[2]");
By depdates=By.xpath("//*[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/table/tbody/tr/td/button");                   
By depdone=By.xpath("//*[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div/button");
By retrn=By.xpath("//*[@id=\"d2-btn\"]");
By retmonth=By.xpath("//*[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/h2");
By nextclick2=By.xpath("//*[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/button[2]");
By retdates=By.xpath("//*[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/table/tbody/tr/td/button");
By retdone=By.xpath("//*[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div/button");
By traveler=By.xpath("//*[@id=\"adaptive-menu\"]/button");
By adults=By.xpath("//*[@id=\"adaptive-menu\"]/div/div/div/div[2]/section/div[1]/div[1]/div/button[2]/span");
By child=By.xpath("//*[@id=\"adaptive-menu\"]/div/div/div/div[2]/section/div[1]/div[2]/div/button[2]/span");
By childage=By.xpath("//*[@id=\"child-age-input-0-0\"]");
By donebtn=By.xpath("//*[@id=\"adaptive-menu\"]/div/div/div/div[3]/button");
By economy=By.xpath("//*[@id=\"preferred-class-input-trigger\"]");
By fstcls=By.xpath("//*[@id=\"preferred-class-input\"]/div/div/a[4]/span");
By search=By.xpath("//*[@id=\"wizard-flight-pwa-1\"]/div[3]/div[2]/button");
public Flightspage(WebDriver driver)
{
	this.driver=driver;
	}
public void flightsclick()
{
	driver.findElement(flights).click();
}
public void setvalues(String leaving,String going)
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.findElement(leav).click();
	WebElement wb=driver.findElement(from);
	wb.sendKeys(leaving);
	wb.sendKeys(Keys.ENTER);
	driver.findElement(go).click();
	WebElement bw=driver.findElement(to);
	bw.sendKeys(going);
	bw.sendKeys(Keys.ENTER);
}
public void deptdatepicker(String mnth1,String date1)
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.findElement(depart).click();
	while(true) 
	{	
	WebElement mon=driver.findElement(depmonth);
	String month1=mon.getText();
	if(month1.equals(mnth1))
	{
		System.out.println(month1);
		break;
		}
	else
	{
		driver.findElement(nextclick1).click();
		}
	}
	List<WebElement> alldates1= driver.findElements(depdates);
    for(WebElement dateelement:alldates1)
    {
    	String date=dateelement.getAttribute("data-day");
    	//System.out.println(date);
    	if(date.equals(date1))
    	{
    		dateelement.click();
    		System.out.println("date selected");
    	}}
    driver.findElement(depdone).click();
    }
    public void retrndatepicker(String mnth2,String date2)
    {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	driver.findElement(retrn).click();
    	while(true) 
    	{	
    	WebElement mon1=driver.findElement(retmonth);
    	String month2=mon1.getText();
    	if(month2.equals(mnth2))
    	{
    		System.out.println(month2);
    		break;
    		}
    	else
    	{
    		driver.findElement(nextclick2).click();
    		}
    	}
    	List<WebElement> alldates2= driver.findElements(retdates);
        for(WebElement dateelementt:alldates2)
        {
        	String date1=dateelementt.getAttribute("data-day");
        	//System.out.println(date1);
        	if(date1.equals(date2))
        	{
        		dateelementt.click();
        		System.out.println("date selected");
        	}
        }
    driver.findElement(retdone).click();
}
    public void travelers()
    {
    	driver.findElement(traveler).click();
    }
    public void Adult()
    {
    	driver.findElement(adults).click();
    }
    public void Childrens(String age)
    {
    	driver.findElement(child).click();
    	Select drpchild = new Select(driver.findElement(childage));
    	drpchild.selectByVisibleText(age);
    	driver.findElement(donebtn).click();
    }
    public void economy()
    {
    	driver.findElement(economy).click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	WebElement n=driver.findElement(fstcls);
    	Actions a = new Actions(driver);
    	a.moveToElement(n).perform();
    	n.click();
    }
    public void search()
    {
    	driver.findElement(search).click();
    }
}
