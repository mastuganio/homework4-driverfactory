package com.mastugan.internal;

public final class RunProperties {

    public static final String BROWSER = "browser";

    private RunProperties() {}

    public static String getProperty(String name) {
        String prop = System.getProperty(name);
        if(prop != null)
            prop.toLowerCase();
        return prop;
    }
}
