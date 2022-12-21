package Controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import modle.GetTheWeather;
import modle.WeatherBean;

@WebServlet("/OWservlet")
public class OWServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cityStr = request.getParameter("city");
		String countryStr = request.getParameter("country");
		
		//String time =request.getParameter("timezone");
		String icon =countryStr;

		WeatherBean wBean = new WeatherBean(cityStr, countryStr, "", icon);
		

		GetTheWeather.getWeather(wBean); 
		
		request.getSession().setAttribute("wBeanLabel", wBean);

		RequestDispatcher rd = request.getRequestDispatcher("view/showWeather.jsp");
		rd.forward(request, response);
		
		
		

		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String cityStr = request.getParameter("city");
		String countryStr = request.getParameter("country");
		
		//String time =request.getParameter("timezone");
		String icon =countryStr;

		WeatherBean wBean = new WeatherBean(cityStr, countryStr, "", icon);
		

		GetTheWeather.getWeather(wBean); 
		
		
		
		 Cookie[] cookies = request.getCookies();
	        String tempCity = "";
	        for (int i = 0; i < cookies.length; i++) {
	          if(cookies[i].getName().equals("cookie")) {
	              tempCity = cookies[i].getValue(); 
	          }
	        }
	        tempCity = tempCity + cityStr + "-" ;
	        
	        
		Cookie cookie = new Cookie("cookie",tempCity);
		cookie.setMaxAge(100);
		response.addCookie(cookie);
		
		
		
		String tempCountry="";
		for (int j=0; j<  cookies.length; j++) {
			if (cookies[j].getName().equals("country")) {
				tempCountry = cookies[j].getValue();
			}
		}
		tempCountry = tempCountry + countryStr + "-";
		
		Cookie country = new Cookie("country",tempCountry);	
		country.setMaxAge(100);
		response.addCookie(country);
		
		
		
		
		
		
//
//		private static String getData(NodeList nList, String tag) {
//			String XMLclouds = "";
//			for (int temp = 0; temp < nList.getLength(); temp++) {
//				// Save a node of the current list id
//				Node node = nList.item(temp);
//				if (node.getNodeType() == Node.ELEMENT_NODE) { 
//
//					// set the current node as an Element
//					Element eElement = (Element) node;
//
//					// get the content of an attribute in element
//					XMLclouds = eElement.getAttribute(tag);
//
//				}
//			}
//			return XMLclouds;
//		}
		
		

		
//		Cookie cookie = new Cookie("cookie",cityStr);
//		cookie.setMaxAge(60*60*24);
//		response.addCookie(cookie);

		request.getSession().setAttribute("wBeanLabel", wBean);

		RequestDispatcher rd = request.getRequestDispatcher("view/showWeather.jsp");
		rd.forward(request, response);
		
	
	}


}