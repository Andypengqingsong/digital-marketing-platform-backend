package com.mydataway.api.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;

//@Profile({"dev", "test"})
@Component
public class RequestLoggingFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestLoggingFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = getCurrentContext();
        try {
            traceRequest(ctx);
        } catch (IOException e) {
            LOGGER.error("unexpected error", e);
        }
        return null;
    }

    private void traceRequest(RequestContext context) throws IOException {
        HttpServletRequest request = context.getRequest();
        LOGGER.debug("===========================request begin================================================");
        LOGGER.debug("URI         : {}", request.getRequestURI());
        LOGGER.debug("Method      : {}", request.getMethod());
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            StringBuilder sb = new StringBuilder();
            while (headerNames.hasMoreElements()) {
                String header = headerNames.nextElement();
                sb.append(header);
                sb.append(": ");
                sb.append(request.getHeader(header));
            }
            LOGGER.debug("Headers    : {}", sb);
        }

        InputStream in = (InputStream) context.get("requestEntity");
        if (in == null) {
            in = context.getRequest().getInputStream();
        }
        String body = StreamUtils.copyToString(in, StandardCharsets.UTF_8);
        LOGGER.debug("Request body: {}", body);
        LOGGER.debug("==========================request end================================================");
    }
}
