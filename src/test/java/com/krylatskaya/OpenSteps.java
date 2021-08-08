package com.krylatskaya;

import io.cucumber.java.ru.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class OpenSteps {

    @Допустим("Проверить что в копирайте указана подпись {string}")
    public void checkFooter(String string) {
        $(byText(string)).shouldBe(visible);
    }

    @Допустим("Проверяю наличие {string} внутри {string}")
    public void checkMenu(String string1, String string2) {
        if (isNotBlank(string2)) {
            $(byXpath("//*[text()='" + string2 + "']")).hover();
        }
        $(byText(string1)).shouldBe(visible);
        System.out.println(">>> Checking " + string1);
    }


}
