import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.conditions.Visible;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CardTest {

    @Test
    void testDelivery() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("input[placeholder=\"Город\"]").setValue("Ханты-Мансийск");
        $("[placeholder=\"Дата встречи\"]").setValue("19.10.2022");
        $("[name=\"name\"]").setValue("Иванов-Петров Вадим");
        $("[name=\"phone\"]").setValue("+79279999999");
        $("[data-test-id=\"agreement\"]").click();
        $x("//span[text()=\"Забронировать\"]").click();
        $("[data-test-id=\"notification\"]").should(visible, Duration.ofSeconds(15));


    }
}
