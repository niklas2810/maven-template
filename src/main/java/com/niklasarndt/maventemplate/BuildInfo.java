package com.niklasarndt.maventemplate;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Properties;

public final class BuildInfo {

    protected static final String DEFAULT_VALUE = "UNKNOWN";
    public static String NAME;
    public static String DESCRIPTION;
    public static String VERSION;
    public static String TARGET_JDK;
    public static String TIMESTAMP;
    public static String URL;
    public static String MAIN_CLASS;

    static {
        try {
            Properties properties = new Properties();
            properties.load(BuildInfo.class.getClassLoader()
                    .getResourceAsStream("build.properties"));

            NAME = properties.getProperty("build.name");
            DESCRIPTION = properties.getProperty("build.description");
            VERSION = properties.getProperty("build.version");
            TARGET_JDK = properties.getProperty("build.targetJdk");
            TIMESTAMP = properties.getProperty("build.timestamp");
            URL = properties.getProperty("build.url");
            MAIN_CLASS = properties.getProperty("build.mainClass");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Set null fields to UNKNOWN
        for (Field field : BuildInfo.class.getDeclaredFields()) {
            try {
                if (field.getType().isAssignableFrom(String.class)
                        && field.getModifiers() == (Modifier.PUBLIC | Modifier.STATIC)
                        && (field.get(null) == null ||
                        field.get(null).toString().startsWith("$"))) {
                    field.set(null, DEFAULT_VALUE);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private BuildInfo() {
    }
}
