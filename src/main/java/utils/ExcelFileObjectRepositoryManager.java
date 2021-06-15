package utils;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ExcelFileObjectRepositoryManager implements IObjectrepository{

    private static ExcelFileObjectRepositoryManager instance = null;

    private HashMap<String, String> properties = null;

    private ExcelFileObjectRepositoryManager() {
        properties = new HashMap<>();
    }


    public static ExcelFileObjectRepositoryManager getInstance() {
        if (instance == null) {
            instance = new ExcelFileObjectRepositoryManager();
        }
        return instance;
    }

    public void load(String... fileNames) {
        for(String file1 : fileNames) {

            File inputFile = new File(file1);
            if(inputFile.exists()) {

                Workbook workbook = null;

                try {
                    workbook = Workbook.getWorkbook(inputFile);
                    Sheet sheet = null;
                    sheet = workbook.getSheet(0);
                    for (int i = 1; i < sheet.getRows(); i++) {

                        Cell keyCell = sheet.getCell(1, i);
                        String key = keyCell.getContents();

                        Cell locatorTypeCell = sheet.getCell(2, i);
                        String locatorType = locatorTypeCell.getContents();

                        Cell locatorCell = sheet.getCell(3, i);
                        String locator = locatorCell.getContents();

                        String locatorValue = locatorType + ":" + locator;

                        System.out.println(key + "=" +  locatorValue);
                        properties.put(key, locatorValue);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (BiffException e) {
                    e.printStackTrace();
                }
            }





        }
    }

    public void reset() {
    properties = new HashMap<>();
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
        String value = properties.get(key);
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
                throw new RuntimeException("There is no value for the key: "  + key);
            }
        }
        else{
            throw new RuntimeException("There is no locator with the key: " + key);
        }
        return locator;
    }

  /*  public static void main(String[] args) {
        String fileName = System.getProperty("user.dir") + "/src/test/resources/SpreeObjectRepo.xls";
        Workbook workbook = null;
        File inputWorkbook = new File(fileName);
        if (inputWorkbook.exists()) {
            try {
                workbook = Workbook.getWorkbook(inputWorkbook);
                Sheet sheet = null;
                sheet = workbook.getsheet(0);
                for (int i = 1; i < sheet.getRows(); i++) {

                    Cell keyCell = sheet.getCell(1, i);
                    String key = keyCell.getContents();

                    Cell locatorTypeCell = sheet.getCell(2, i);
                    String locatorType = locatorTypeCell.getContents();

                    Cell locatorType = sheet.getCell(3, i);
                    String locator = locatorType.getContents();


                }

            } catch (IOException e) {
                e.printStackTrace();
                0
            } catch (BiffException e) {
                e.printStackTrace();
            }

*/
        }



