package core;

import org.openqa.selenium.WebElement;

public class UserActions {

    public void click(WebElement element) {
        Log.info("Clicking on element " + element.getText());
        element.click();
    }
}
