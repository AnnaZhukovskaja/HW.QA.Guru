import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class HerokuAppTest {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void checkDragAndDropMovements() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $(byTagName("header")).shouldHave(text("A"));
        actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b")).release().perform();
        $(byTagName("header")).shouldHave(text("B"));
        $("#column-b").dragAndDrop(to("#column-a"));
        $(byTagName("header")).shouldHave(text("A"));
    }
}
