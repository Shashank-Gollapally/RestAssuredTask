package APIautomation.RestAssured;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import pojo.Browsers;
import pojo.Desktop;
import pojo.Devices;
import pojo.Mobile;
import pojo.Objectsclass;

public class JsonPrasing {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://www.browserstack.com";
		Objectsclass response = given().log().all().queryParam("product", "automate").header("Accept", "*/*")
				.header("content-type", "application/json").when().log().all()
				.get("/list-of-browsers-and-platforms.json").as(Objectsclass.class);

		List<Desktop> desktops = response.getDesktop();
		System.out.println(desktops.size());
		
		List<Browsers> brow = null;
		for (int i = 0; i < desktops.size(); i++) {
			if (desktops.get(i).getOs_display_name().equalsIgnoreCase("Windows 10")) {
				System.out.println(desktops.get(i).getOs_display_name());
				brow = desktops.get(i).getBrowsers();
			}
		}

		System.out.println(brow.size());

		brow.stream().filter(s -> s.getBrowser().equalsIgnoreCase("chrome"))
				.filter(s -> !s.getBrowser_version().contains("beta")).map(s -> s.getBrowser_version())
				.mapToDouble(Double::parseDouble).max().ifPresent(System.out::println);
		
		brow.stream().filter(s -> s.getBrowser().equalsIgnoreCase("firefox"))
		.filter(s -> !s.getBrowser_version().contains("beta")).map(s -> s.getBrowser_version())
		.mapToDouble(Double::parseDouble).max().ifPresent(System.out::println);


		
		List<Mobile> mobiles =response.getMobile();
		System.out.println(mobiles.size());
		List<Devices> devices = null;
		
		for( int i =0 ; i < mobiles.size();i++)
		{
			if( mobiles.get(i).getOs_display_name().equalsIgnoreCase("ios"))
			{
				devices=mobiles.get(i).getDevices();
			}
		}
		
		System.out.println(devices.size());
		
		devices.stream().filter(s->s.getDisplay_name().equalsIgnoreCase("iPhone 8")).map(s->s.getOs_version())
		.mapToDouble(Double::parseDouble).max().ifPresent(System.out::println);
		
	}

}
