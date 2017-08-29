package com.boot;

import com.boot.controller.HomeController;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void testApp()
    {
        HomeController hc = new HomeController();
        String hResult = hc.home();
        assertEquals(hResult,"Home");
    }
}
