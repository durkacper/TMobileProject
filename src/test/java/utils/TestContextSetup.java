package utils;

import pages.PageObjectManager;

public class TestContextSetup {

    public PageObjectManager pageObjectManager;
    public TestBase testBase;

    public TestContextSetup(){
        testBase = new TestBase();
        pageObjectManager = new PageObjectManager(testBase.initializeWebDriver());
    }
}
