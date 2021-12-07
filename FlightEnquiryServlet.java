package com.java.layer5;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.layer2.Flight;
import com.java.layer3.FlightRepositoryImpl;

public class FlightEnquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	FlightRepositoryImpl flightRepo = new FlightRepositoryImpl();
	
    
    public FlightEnquiryServlet() {
        super();
        System.out.println("FlightEnquiryServlet().constructor.......");
		
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("\tinit().....");
		
	}

	
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("\tdestroy().....");
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()....."
					+request.getRemoteAddr()
					+" port "+request.getRemotePort());
		String source= request.getParameter("src");
		String target= request.getParameter("trg");
		//ctrl+shift+m
		PrintWriter pw = response.getWriter();
		pw.println("Customer is searching for "
		+source+" to "+target+" flight");
		List<Flight> flightList = flightRepo.searchFlights();
		//List<Flight> flightListToShow = new ArrayList<Flight>();
		pw.println("<table border=3 cellspacing=5 cellpadding=5>");
		for(Flight theFlight : flightList) {
			if(theFlight.getFlightSource().equalsIgnoreCase(source) && theFlight.getFlightDestination().equals(target)) {
				pw.println("<tr>");
				pw.println("<td>"+theFlight.getFlightNumber()+"</td>");
				pw.println("<td>"+theFlight.getFlightSource()+"</td>");
				pw.println("<td>"+theFlight.getFlightDestination()+"</td>");
				pw.println("<td>"+theFlight.getFlightDepartureDate()+"</td>");
				pw.println("</tr>");
			}
		}
		pw.println("</table>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost()..when?...");
		
		doGet(request, response);
	}

}
