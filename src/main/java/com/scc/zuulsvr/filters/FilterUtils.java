package com.scc.zuulsvr.filters;

import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

@Component
public class FilterUtils {

	public static final String AUTHENTIFICATION_KEY = "X-SCC-authentification";

	public static final String PRE_FILTER_TYPE = "pre";
	public static final String POST_FILTER_TYPE = "post";
	public static final String ROUTE_FILTER_TYPE = "route";

	public String getAuthentificationKey() {
		RequestContext ctx = RequestContext.getCurrentContext();

		if (ctx.getRequest().getHeader(AUTHENTIFICATION_KEY) != null) {
			return ctx.getRequest().getHeader(AUTHENTIFICATION_KEY);
		} else {
			return ctx.getZuulRequestHeaders().get(AUTHENTIFICATION_KEY);
		}
	}

	public void setAuthentificationKey(String correlationId) {
		RequestContext ctx = RequestContext.getCurrentContext();
		ctx.addZuulRequestHeader(AUTHENTIFICATION_KEY, correlationId);
	}

}
