import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
    @Test
    void fillFormTest() {
        Selenide.open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Alexey");
        $("#lastName").setValue("Belyakov");
        $("#userEmail").setValue("user@mail.com");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("89991234567");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $("[value='10']").click();
        $(".react-datepicker__year-select").click();
        $("[value='1992']").click();
        $(".react-datepicker__day--002").click();
        $("#subjectsInput").setValue("C");
        $(Selectors.byText("Computer Science")).scrollTo().click();
        $("[for=hobbies-checkbox-1]").click();
        $("[for=hobbies-checkbox-3]").click();
        $("input#uploadPicture").uploadFile(new File("C:\\Users\\ivlex\\Downloads\\dog.jpg"));
        $("#currentAddress").setValue("Russia, Moscow");
        $(Selectors.byText("Select State")).click();
        $(Selectors.byText("Haryana")).click();
        $(Selectors.byText("Select City")).click();
        $(Selectors.byText("Karnal")).click();
        $("#submit").click();

        $(".modal-content").shouldBe(Condition.visible);
        $(".modal-content").shouldHave(text("Alexey Belyakov"), text("user@mail.com"),
                text("Male"), text("8999123456"), text("02 November,1992"), text("Computer Science"),
                text("Sports, Music"), text("dog.jpg"), text("Russia, Moscow"), text("Haryana Karnal"));


    }
}
