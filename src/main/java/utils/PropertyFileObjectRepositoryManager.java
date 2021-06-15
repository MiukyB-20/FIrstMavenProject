package utils;



import org.openqa.selenium.By;

import java.io.*;
import java.util.Properties;

public class PropertyFileObjectRepositoryManager implements IObjectrepository{

    //holding an instance as Private static so it means globally in my program with one variable so
    //other class can use it without creating variable.
    // (Singleton Design Pattern)
    private static PropertyFileObjectRepositoryManager instance = null;

    //helps to read the file
    private Properties properties = null;

    //constructor
    public PropertyFileObjectRepositoryManager() {

    }
    //method
    //so when i call this method its going to create an instance for me.
    public static PropertyFileObjectRepositoryManager getInstance() {

        //creating an instance only no instance is created.
        if(instance == null) {
            instance = new PropertyFileObjectRepositoryManager();
        }
        return instance;
    }

    //loading files
    public void load(String... fileNames) {
        for(String fileName : fileNames) //giving u 1 file to read
            { System.out.println("Reading File :" + fileName);

            if(new File(fileName).exists()) //"File" is an imported class and we created an instance for it
                 { InputStream input = null; //InputStream is used to read the file
                 try {
                     input = new FileInputStream(fileName); //FileInputStream is a implementation of InputStream
                     properties.load(input);

                 } catch (IOException e) {
                     e.printStackTrace();
                 } finally {
                     if (input != null) {
                         try {
                             input.close();

                         } catch (IOException e) {
                             e.printStackTrace();
                         }
                     }
                 }

                 } else {
                throw new RuntimeException("File with the name" + fileName + "does not exist");
            }


        }

    }

    public void reset() {

        properties = new Properties();
    }

    public By getLocator(String key) {
        By by = null;

        String locatorBy = getLocatorByString(key);
        String locator = getLocatorString(key);

        if(locatorBy != null && locator != null) {
            if(locatorBy.equalsIgnoreCase("LINK_TEXT")) {
                by = By.linkText(locator);
            } else if (locatorBy.equalsIgnoreCase("PARTIAL_LINK_TEXT")) {
                by = By.partialLinkText(locator);
            } else if (locatorBy.equalsIgnoreCase("ID")) {
                by = By.id(locator);
            } else if (locatorBy.equalsIgnoreCase("NAME")) {
                by = By.name(locator);
            } else if (locatorBy.equalsIgnoreCase("CSS")) {
                by = By.cssSelector(locator);
            } else if (locatorBy.equalsIgnoreCase("TAG_NAME")) {
                by = By.tagName(locator);
            } else if (locatorBy.equalsIgnoreCase("XPATH")) {
                by = By.xpath(locator);
            } else if (locatorBy.equalsIgnoreCase( "CLASS_NAME")) {
                by = By.className(locator);
                }
            }
        return by;
        }

        private String get(String key) {
        String value = properties.getProperty(key);
        return value;
        }

        private String getLocatorByString(String key) {
        String locatorBy = null;
        String value = get(key);
        if (value != null) {
            String parts[] = value.split(":");
            locatorBy = parts[0];
        }
        return locatorBy;
        }

        private String getLocatorString(String key) {
        String locator = null;
        String value = get(key);
        if(value != null) {
            String parts[] = value.split(":");
            if(parts != null && parts.length > 0) {
                locator = parts[1];
            }
            else {
                throw new RuntimeException("There is no value for the key" + key);
            }
        }
        else{
            throw new RuntimeException("There is no locator with the key" + key);
        }
        return locator;
        }
    }



