package pojo;

import java.util.List;

public class Desktop {
	private String os;
	private String os_version;
	private String os_display_name;
	private List<Browsers> browsers;
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getOs_version() {
		return os_version;
	}
	public void setOs_version(String os_version) {
		this.os_version = os_version;
	}
	public String getOs_display_name() {
		return os_display_name;
	}
	public void setOs_display_name(String os_display_name) {
		this.os_display_name = os_display_name;
	}
	public List<Browsers> getBrowsers() {
		return browsers;
	}
	public void setBrowsers(List<Browsers> browsers) {
		this.browsers = browsers;
	}
	

}
