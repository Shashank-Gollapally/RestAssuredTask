package pojo;

import java.util.List;

public class Mobile {

	private String os;
	private String os_display_name;
	private List<Devices> devices;
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getOs_display_name() {
		return os_display_name;
	}
	public void setOs_display_name(String os_display_name) {
		this.os_display_name = os_display_name;
	}
	public List<Devices> getDevices() {
		return devices;
	}
	public void setDevices(List<Devices> devices) {
		this.devices = devices;
	}
}
