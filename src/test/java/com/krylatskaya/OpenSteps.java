package com.krylatskaya;

import io.cucumber.java.ru.*;
import java.util.Base64;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.krylatskaya.Hooks.pass;
import static com.krylatskaya.Hooks.url;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class OpenSteps {

    @Допустим("Проверить что в копирайте указана подпись {string}")
    public void checkFooter(String string) {
        $(byText(string)).shouldBe(visible);
    }

    @Допустим("Проверить наличие {string} внутри {string}")
    public void checkMenu(String string1, String string2) {
        if (isNotBlank(string2)) {$(byXpath("//*[text()='" + string2 + "']")).hover();}
        $(byText(string1)).shouldBe(visible);
        System.out.println(">>> Checking " + string1);
    }

    @Допустим("Перейти в раздел {string}")
    public void changeToFolder(String string) {
        open(url + string);
        $(byText("Защищено: Деловой раздел")).shouldBe(visible);
    }

    @Допустим("Ввести пароль \\({string})")
    public void enterPassword(String string) {
        String open = string;
        byte[] decodedBytes = Base64.getDecoder().decode(pass);
        String decodedString = new String(decodedBytes);
        if ("успех".equals(open)) {$("input[type='password']").val(decodedString);
        } else if ("неуспех".equals(open)) {$("input[type='password']").val("12345678");}
    }

    @Допустим("Нажать на кнопку {string} \\({string})")
    public void pushTheButton(String string, String string2) {
        String open = string2;

        $("input[value="+ string +"]").click();
        if ("успех".equals(open)) {$(byText("Важное")).shouldBe(visible);
        } else if ("неуспех".equals(open)) {$(byText("Защищено: Деловой раздел")).shouldBe(visible);}
    }
}
