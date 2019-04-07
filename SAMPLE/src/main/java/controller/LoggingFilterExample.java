package controller;

import java.io.IOException;
import org.apache.log4j.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public final class LoggingFilterExample implements Filter {
	
	private final Logger logger = Logger.getLogger(LoggingFilterExample.class);
	
	private FilterConfig filterConfigObj = null;

	public void init(FilterConfig filterConfigObj) {
		this.filterConfigObj = filterConfigObj;
	}

	public void doFilter(ServletRequest request, 
ServletResponse response,
  FilterChain chain)
  throws IOException, ServletException 
  {
  String remoteAddress =  request.getRemoteAddr();
  String uri = ((HttpServletRequest) request).getRequestURI();
  String protocol = request.getProtocol();

  chain.doFilter(request, response);
  	filterConfigObj.getServletContext().log("Logging filter Servlet called");
  	filterConfigObj.getServletContext().log("**************************");
  	filterConfigObj.getServletContext().log("User Logged !");
  	filterConfigObj.getServletContext().log("username is "+request.getParameter("username"));
  	logger.info("Filter executed with-->"+request.getParameter("username"));
  }

	public void destroy() {
	}
}