package ru.netology.aqa0patterns.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.aqa0patterns.data.DataGenerator;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class AppCardDeliveryTest {

    @BeforeEach
    public void setupTest() {
        open("http://localhost:9999");
    }

    @Test
    public void shouldBeSuccessfullyCompleted() {
        DataGenerator.RegistrationInfo registrationInfo = DataGenerator.Registration.generate();
        String date = DataGenerator.generateDate();
        $x("//*[@data-test-id='city']//input").setValue(registrationInfo.cityName);
        $x("//*[@data-test-id='date']//input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE,
                date);
        $x("//*[@data-test-id='name']//input").setValue(registrationInfo.fullName);
        $x("//*[@data-test-id='phone']//input").setValue(registrationInfo.phoneNumber);
        $x("//*[@data-test-id='agreement']").click();
        $x("//*[text()='Запланировать']/../..").click();
        $x("//*[@data-test-id='success-notification']//*[contains(@class, 'notification__content')]")
                .shouldHave(Condition.exactText(String.format("Встреча успешно запланирована на %s", date)))
                .shouldBe(Condition.visible, Duration.ofSeconds(20));
        date = DataGenerator.generateDate();
        $x("//*[@data-test-id='date']//input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE,
                date);
        $x("//*[text()='Запланировать']/../..").click();
        $x("//*[@data-test-id='replan-notification']//button")
                .click();
        $x("//*[@data-test-id='success-notification']//*[contains(@class, 'notification__content')]")
                .shouldHave(Condition.exactText(String.format("Встреча успешно запланирована на %s", date)))
                .shouldBe(Condition.visible, Duration.ofSeconds(20));

    }
}
