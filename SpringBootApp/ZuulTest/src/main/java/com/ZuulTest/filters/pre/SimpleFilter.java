package com.ZuulTest.filters.pre;

import javax.servlet.http.HttpServletRequest;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.ZuulFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleFilter extends ZuulFilter {

	//open up a dedicated log between this class and the Zuul console
  private static Logger log = LoggerFactory.getLogger(SimpleFilter.class);

  //indicate a type of filter, using a string
  @Override
  public String filterType() {
    return "pre";
  }

  //order this filter should be executed in, if there's other filters (1 cause it's our only filter)
  @Override
  public int filterOrder() {
    return 1;
  }

  //logic as to whether or not this filter triggers
  //we want it to always trigger, so it's just set to true
  @Override
  public boolean shouldFilter() {
    return true;
  }

  //code as to what this filter actually does, now that it's running
  //Basically it's : "Before you handle a request, post its information to the console"
  @Override
  public Object run() {
	//get information about current request from client and store it in a variable
    RequestContext ctx = RequestContext.getCurrentContext();
    //And pull out JUST the request for use in our logging
    HttpServletRequest request = ctx.getRequest();

    //console log information about the type of HTTP request and the URL it is going to
    //(this is all the filter does!)
    log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

    //ctx.addZullRequestHeader("Key", "Value"); can be used to add a header to the request Zuul sends to the app
    
    return null;
  }

}