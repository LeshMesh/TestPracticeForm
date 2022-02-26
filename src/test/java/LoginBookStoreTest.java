import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class LoginBookStoreTest extends TestBase {
    @Test
    void registerNewUser() {
        Selenide.open("https://demoqa.com/register");
        $("#firstname").setValue("Andrey");
        $("#lastname").setValue("Perov");
        $("#userName").setValue("APerov5");
        $("#password").setValue("1234Qq!8");
        switchTo().frame(1);
        $(".recaptcha-checkbox-border").click();
        switchTo().defaultContent();
        $("#register").scrollTo().click();
        switchTo().alert().accept();
//        switchTo().alert().getText();
//        $(Selectors.byText("User Register Successfully")).shouldBe(Condition.visible);
    }

    @Test
    void loginUserTrue() {
        Selenide.open("https://demoqa.com/login");
        $("#userForm").shouldHave(Condition.text("Login in Book Store"));
        $("#userName").setValue("APerov");
        $("#password").setValue("1234Qq!8");
        $("#login").click();
        $(".playgound-header").shouldHave(Condition.text("Profile"));
        $("#userName-value").shouldHave(Condition.text("APerov"));

    }

    @Test
    void loginUserFalseName() {
        Selenide.open("https://demoqa.com/login");
        $("#userForm").shouldHave(Condition.text("Login in Book Store"));
        $("#userName").setValue("APerovZZZ");
        $("#password").setValue("1234Qq!8");
        $("#login").click();
        $("#name").shouldHave(Condition.text("Invalid username or password!"));
    }

    @Test
    void loginUserFalsePassword() {
        Selenide.open("https://demoqa.com/login");
        $("#userForm").shouldHave(Condition.text("Login in Book Store"));
        $("#userName").setValue("APerov");
        $("#password").setValue("1234Qq!8ZZZ");
        $("#login").click();
        $("#name").shouldHave(Condition.text("Invalid username or password!"));
    }
}
