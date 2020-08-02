package com.niklasarndt.maventemplate;

import com.niklasarndt.maventemplate.util.PreventExitManager;
import io.sentry.dsn.InvalidDsnException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class BootstrapTest {

    @BeforeAll
    public static void setSecurityManager() {
        System.setSecurityManager(new PreventExitManager());
    }

    @Test
    public void testMain() {
        assertDoesNotThrow(() -> Bootstrap.main(new String[0]));
        assertThrows(SecurityException.class, () -> Bootstrap.main(new String[]{"error"}));
        assertThrows(IllegalStateException.class, () -> new Bootstrap(new String[]{"error"}));

        System.setProperty("sentry.dsn", "abc");
        assertThrows(InvalidDsnException.class, () -> Bootstrap.main(new String[0]));
    }

}