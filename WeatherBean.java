package modle;

import javax.servlet.http.Cookie;

public class WeatherBean {

	private String cityStr;

	private String countryStr;

	private String cloudsStr;

	private String time;

	private String icon;
	private String province;
	
	private String tempratur;
	

	public String getTempratur() {
		return tempratur;
	}

	public void setTempratur(String tempratur ) {
		this.tempratur = tempratur;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public WeatherBean(String cityStr, String countryStr, String time, String icon) {
		this.cityStr = cityStr;
		this.countryStr = countryStr;
		this.time = time;
		this.icon = icon;
	
	}

	public String getCityStr() {
		return cityStr;
	}

	public String getCountryStr() {
		return countryStr;
	}

	public String getCloudsStr() {
		return cloudsStr;
	}

	public void setCloudsStr(String cloudsStr) {
		this.cloudsStr = cloudsStr;
	}

	

}
