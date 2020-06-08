package com.shiro2.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequest extends HttpServletRequestWrapper {

    public MyRequest(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name);
        value = getRightValue(value);
        return value;
    }

    public String getRightValue(String value) {
        if (value != null) {
            value = value.replaceAll("<", "&lt;");
            value = value.replaceAll(">", "&gt;");
            value = value.replaceAll("gp", "*");
            value = value.replaceAll("pf", "*");
            value = value.replaceAll("fuck", "*");

        }
        return value;
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                String value = values[i];
                value = getRightValue(value);
                values[i] = value;

            }
        }
        return values;
    }
}
