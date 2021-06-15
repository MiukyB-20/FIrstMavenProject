package utils;

import org.openqa.selenium.By;

public interface IObjectrepository {

    void load(String... fileNames);
    void reset();
    public By getLocator(String key);
}
