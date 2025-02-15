package io.loop.step_def;

import io.loop.utilities.Driver;
import org.junit.After;
import org.junit.Before;

public class Hook {
    @Before
    public void setUp() {
        Driver.getDriver();
    }
    @After
    public void tearDown() {
        Driver.getDriver().close();
    }
}
