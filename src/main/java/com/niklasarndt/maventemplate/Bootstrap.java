package com.niklasarndt.maventemplate;

import io.sentry.Sentry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bootstrap {

    private static final Logger logger = LoggerFactory.getLogger(Bootstrap.class);

    public Bootstrap(String[] args) {
        if (args.length > 0 && args[0].equals("error")) {
            throw new IllegalStateException("This excepetion is expected as the " +
                    "argument \"error\" has been provided.");
        }
        logger.debug("Hello, World!");
    }

    public static void main(String[] args) {
        if (System.getenv("SENTRY_DSN") != null || System.getProperty("sentry.dsn") != null) {

            Sentry.init();
            logger.debug("Did Sentry initialize properly? {}",
                    Sentry.isInitialized() ? "Yes" : "No");
        } else {
            logger.info("Specify your DSN via SENTRY_DSN to enable Sentry logging. You can " +
                    "find it at https://sentry.io/settings/<org>/projects/<project>/keys.");
        }

        try {
            new Bootstrap(args);
        } catch (Exception e) {
            logger.error("Encountered uncaught exception", e);
            logger.error("This fatal event will lead to an application shutdown.");
            System.exit(1);
        }
    }

}
