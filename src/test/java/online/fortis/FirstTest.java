package online.fortis;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FirstTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillPracticeFormTests() {
        open("https://demoqa.com/automation-practice-form");
        //fill form
        $("#firstName").setValue("FirstName");
        $("#lastName").setValue("LastName");
        $("#userEmail").setValue("test@test.ru");
        $("[for='gender-radio-3']").click();
        $("#userNumber").setValue("9991234567");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1986");
        $(".react-datepicker__day--012").click();

        $("#subjectsInput").setValue("English").pressEnter();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("[for=hobbies-checkbox-1]").click();
        $("[for=hobbies-checkbox-3]").click();

        $("#uploadPicture").uploadFromClasspath("Glazov.txt");

        $("#currentAddress").setValue("Any Address");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();

        $("#submit").click();

        // check result
        $("#example-modal-sizes-title-lg").shouldBe(visible);
        $(".table-responsive").shouldHave(text("FirstName"), text("LastName"), text("test@test.ru"),
                text("Other"), text("9991234567"), text("12 August,1986"), text("English, Computer Science"),
                text("Sports, Music"), text("Glazov.txt"), text("Any Address"), text("Haryana Karnal"));
    }
    //comment 1
}