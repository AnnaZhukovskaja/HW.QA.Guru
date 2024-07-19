import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class GitHabSolutionsTest {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void pagesEnterpriseShouldHaveHeaderTest() {
        open("https://github.com/");
        $$(".HeaderMenu-item").findBy(text(" Solutions ")).hover();
        $(byTagAndText("a","Enterprise")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered\n" +
                "developer platform."));
    }
}
