import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class Homework3Test {

    // Задание 1. Есть ли разница между $("h1 div"); и $("h1").$("div");
    // Нет. Оба варианта ищут div внутри элемента h1. Пробовал запускать несколько разных тестов с разной вложенностью,
    // никакой разницы нет. Оба варианта всегда либо проходят, либо падают.

    @Test
    // Задание 2. Проверка наличия кода для JUnit5.
    void OpenSoftAssertions() {
        open("https://github.com/");
        $("[data-test-selector=\"nav-search-input\"]").setValue("Selenide").pressEnter();
        $("[href=\"/selenide/selenide\"]").click();
        $("#wiki-tab").click();
        $(".markdown-body").shouldHave(text("Soft assertions"), visible);
        $(".markdown-body").$(Selectors.byText("Soft assertions")).click();
        $(".markdown-body").shouldHave(text("JUnit5 extension"), visible);
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"), visible);
    }

    @Test
    // Задание 3. DragAndDrop с помощью actions на этой странице не работает. Первый элемент выделяется, но не перетаскивается.
    void DragAndDropActionTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a header").shouldHave(text("A"));
        actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b")).release().perform();
        $("#column-a header").shouldHave(text("B"));
    }

    @Test
    // Задание 3. DragAndDrop с помощью Selenide отлично работает.
    void DragAndDropSelenideTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a header").shouldHave(text("A"));
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-a header").shouldHave(text("B"));
    }

    @Test
    // *Задание 3. DragAndDrop с помощью actions на странице demoqa. Такой же тест, все работает.
    void DragAndDropDemoqaTest() {
        open("https://demoqa.com/droppable");
        $("#droppable").shouldHave(text("Drop here"));
        actions().moveToElement($("#draggable")).clickAndHold().moveToElement($("#droppable")).release().perform();
        $("#droppable").shouldHave(text("Dropped!"));
    }
}
