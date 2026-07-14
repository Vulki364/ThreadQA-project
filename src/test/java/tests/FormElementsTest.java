package tests;

import baseElements.Country;
import baseElements.MainPage;
import core.BaseTest;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FormElementsTest extends BaseTest {
    public static final String BASE_URL = "https://lms.threadqa.ru/xpath-practice-hub/basics";
    public static final String USER_NAME = "Олега";
    public static final String PASSWORD = "12345678";
    public static final String EMAIL = "zdanov36481@gmail.com";
    public static final String COMMENT = "Мозг пытается вернуть источник дофамина";


    @Test
    public void checkUserNameInput() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.setUserName(USER_NAME);
        assertEquals(USER_NAME, mainPage.userNameInput.getValue());
    }

    @Test
    public void checkEmailInput() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.setEmail(EMAIL);
        assertEquals(EMAIL, mainPage.emailInput.getValue());
    }

    @Test
    public void checkPasswordInput() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.setPassword(PASSWORD);
        assertEquals(PASSWORD, mainPage.passwordInput.getValue());
    }

    @Test
    public void checkCommentInput() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.setComment(COMMENT);
        assertEquals(COMMENT, mainPage.commentInput.getValue());
    }

//    @Test
//    public void checkCountrySelect() {
//        MainPage mainPage = new MainPage(BASE_URL);
//
//        mainPage.selectCountry(Country.RUSSIA);
//
//        mainPage.countryDropdown
//                .shouldHave(text("Россия"));
//    }

      @Test
      public void shouldSubscribeToNewsletter() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.subscribeToNewsletter();
      }

    @Test
    public void shouldNotSubscribeToNewsletter() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.doNotSubscribeNewsletterRadio.shouldBe(visible).click();
        mainPage.doNotSubscribeNewsletterRadio.shouldBe(selected);
    }

    @Test
    public void shouldAcceptTerms() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.acceptTerms();
        mainPage.agreeTermsCheckbox.shouldBe(selected);
    }

    @Test
    public void shouldUncheckTerms() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.acceptTerms();
        mainPage.acceptTerms();
        mainPage.agreeTermsCheckbox.shouldNotBe(selected);
    }


    @Test
    public void shouldClickPrimaryButton() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.interactiveButtonPrimary
                .shouldBe(visible)
                .shouldBe(enabled)
                .click();

    }

    @Test
    public void shouldClickSecondaryButton() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.interactiveButtonSecondary
                .shouldBe(visible)
                .shouldBe(enabled)
                .click();
    }

    @Test
    public void shouldClickSuccessButton() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.interactiveButtonSuccess
                .shouldBe(visible)
                .shouldBe(enabled)
                .click();
    }

    @Test
    public void shouldClickDangerButton() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.interactiveButtonDanger
                .shouldBe(visible)
                .shouldBe(enabled)
                .click();
    }


    @Test
    public void checkNotificationButton() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.showNotification();
        mainPage.notificationButton.shouldHave(text("Скрыть уведомление"));
        mainPage.notificationMessage.shouldBe(visible).shouldHave(text("Информационное сообщение"));
    }

    @Test
    public void shouldHideNotification() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.showNotification();
        mainPage.notificationMessage.shouldBe(visible);
        mainPage.showNotification();
        mainPage.notificationButton.shouldHave(text("Показать уведомление"));
        mainPage.notificationMessage.shouldBe(disappear);
    }


    @Test
    public void shouldOpenModalWindow() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.openModalButton.shouldBe(visible).click();
        mainPage.modalWindow.shouldBe(visible);
        mainPage.confirmModalButton.shouldBe(visible);
        mainPage.cancelModalButton.shouldBe(visible);
        mainPage.closeModalButton.shouldBe(visible);
    }

    @Test
    public void shouldCloseModalWindowByCloseButton() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.openModalButton.shouldBe(visible).click();
        mainPage.modalWindow.shouldBe(visible);
        mainPage.closeModalButton.shouldBe(visible).click();
        mainPage.modalWindow.shouldBe(disappear);
    }

    @Test
    public void shouldCloseModalWindowByCancelButton() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.openModalButton.shouldBe(visible).click();
        mainPage.modalWindow.shouldBe(visible);
        mainPage.cancelModalButton.shouldBe(visible).click();
        mainPage.modalWindow.shouldBe(disappear);
        mainPage.getModalWindowToastMessageCancel
                .shouldBe(visible)
                .shouldHave(text("Действие отменено"));
    }

    @Test
    public void shouldCloseModalWindowByConfirmButton() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.openModalButton.shouldBe(visible).click();
        mainPage.modalWindow.shouldBe(visible);
        mainPage.confirmModalButton.shouldBe(visible).click();
        mainPage.modalWindow.shouldBe(disappear);
        mainPage.modalWindowToastMessageConfirm
                .shouldBe(visible)
                .shouldHave(text("Действие подтверждено!"));
    }



    @Test
    public void checkNotifySuccessButton() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.notifySuccessButton.shouldBe(visible).click();
        mainPage.notifyToastMessage
                .shouldBe(visible)
                .shouldHave(text("Операция выполнена успешно!"));
    }

    @Test
    public void checkNotifyErrorButton() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.notifyErrorButton.shouldBe(visible).click();
        mainPage.notifyToastMessage
                .shouldBe(visible)
                .shouldHave(text("Произошла ошибка!"));
    }

    @Test
    public void checkNotifyWarningButton() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.notifyWarningButton.shouldBe(visible).click();
        mainPage.notifyToastMessage
                .shouldBe(visible)
                .shouldHave(text("Обратите внимание!"));
    }

    @Test
    public void checkNotifyInfoButton() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.notifyInfoButton.shouldBe(visible).click();
        mainPage.notifyToastMessage
                .shouldBe(visible)
                .shouldHave(text("Информация для вас"));
    }


    @Test
    public void checkExternalLink() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.externalLink.click();
        switchTo().window(1);
        assertEquals("https://example.com/", getWebDriver().getCurrentUrl());
    }

    @Test
    public void checkAnchorlLink() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.anchorLink
                .shouldHave(attribute(
                        "href",
                        "https://lms.threadqa.ru/xpath-practice-hub/basics#practice-elements"
                ));

    }


}
