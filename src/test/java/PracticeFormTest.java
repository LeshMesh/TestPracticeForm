import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class PracticeFormTest {
    @Test
    void fillFormTest() {
        Selenide.open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Alexey");
        $("#lastName").setValue("Belyakov");
        $("#userEmail").setValue("user@mail.com");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("89991234567");
//        $("#dateOfBirthInput").setValue("");
//        $(".subjects-auto-complete__control").setValue("Programming");
        $("[for=hobbies-checkbox-1]").click();
        $("[for=hobbies-checkbox-3]").click();
        $("input#uploadPicture").uploadFile(new File("C:\\Users\\ivlex\\Downloads\\dog.jpg"));
        $("#currentAddress").setValue("Russia, Moscow");
    }
}
