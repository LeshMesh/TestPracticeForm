import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest extends TestBase {

    @Test
    void fillFormTest() {
        Selenide.open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Alexey");
        $("#lastName").setValue("Belyakov");
        $("#userEmail").setValue("user@mail.com");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("89991234567");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1992");
        $("[aria-label$=\"November 2nd, 1992\"]").click();
        $("#subjectsInput").setValue("C");
        $(Selectors.byText("Computer Science")).scrollTo().click();
        $("[for=hobbies-checkbox-1]").click();
        $("[for=hobbies-checkbox-3]").click();
//        $("#uploadPicture").scrollTo().uploadFromClasspath("img/dog.jpg");
        $("#currentAddress").setValue("Russia, Moscow");
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").click();

        $(".modal-content").shouldBe(Condition.visible);
        $(".modal-content").shouldHave(text("Alexey Belyakov"), text("user@mail.com"), text("Male"),
                text("8999123456"), text("02 November,1992"), text("Computer Science"), text("Sports, Music"),
                text("dog.jpg"), text("Russia, Moscow"), text("NCR Delhi"));
    }
}
