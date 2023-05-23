package test;
import org.testng.annotations.Test;
import page.Flightspage;
public class Flightstest extends Baseclass
{
@Test
public void roundtrip()
{
Flightspage ob=new Flightspage(driver);
ob.flightsclick();
ob.setvalues("Kochi (KCZ - Ryoma)","Bengaluru (BLR - Kempegowda Intl.)");
ob.deptdatepicker("July 2023","5");
ob.retrndatepicker("September 2023", "10");
ob.travelers();
ob.Adult();
ob.Childrens("3");
ob.economy();
ob.search();
}
}
