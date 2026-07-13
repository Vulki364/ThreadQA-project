package baseElements;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public final SelenideElement userNameInput = $x("//input[@data-testid='username-field']");
    public final SelenideElement emailInput = $x("//input[@data-testid='email-field']");
    public final SelenideElement passwordInput = $x("//input[@data-testid='password-field']");
    public final SelenideElement commentInput = $x("//textarea[@data-testid='comment-field']");
    public final SelenideElement countryDropdown = $x("//button[@data-testid='country-dropdown']");

    public final SelenideElement subscribeNewsletterRadio = $("[data-testid='newsletter-yes']");
    public final SelenideElement doNotSubscribeNewsletterRadio = $("[data-testid='newsletter-no']");
    public final SelenideElement agreeTermsCheckbox = $("[data-testid='terms-agreement']");

    public final SelenideElement interactiveButtonPrimary = $("[data-testid='primary-button']");
    public final SelenideElement interactiveButtonSecondary = $("[data-testid='secondary-button']");
    public final SelenideElement interactiveButtonSuccess = $("[data-testid='success-button']");
    public final SelenideElement interactiveButtonDanger = $("[data-testid='danger-button']");

    public final SelenideElement notificationButton = $x("//button[@data-testid='show-alert-button']");
    public final SelenideElement notificationMessage = $("[data-testid='alert-message']");

    public final SelenideElement openModalButton = $x("//button[@data-testid='open-modal-button']");
    public final SelenideElement closeModalButton = $x("//button[@data-testid='modal-close-button']");
    public final SelenideElement cancelModalButton = $x("//button[@data-testid='modal-cancel-button']");
    public final SelenideElement confirmModalButton = $x("//button[@data-testid='modal-confirm-button']");
    public final SelenideElement modalWindow = $("[data-testid='modal-overlay']");
    public final SelenideElement getModalWindowToastMessageCancel = $x("//p[contains(text(),'Действие отменено')]");
    public final SelenideElement modalWindowToastMessageConfirm = $x("//p[contains(text(),'Действие подтверждено!')]");

    public final SelenideElement notifySuccessButton = $x("//button[@data-testid='notify-success']");
    public final SelenideElement notifyErrorButton = $x("//button[@data-testid='notify-error']");
    public final SelenideElement notifyWarningButton = $x("//button[@data-testid='notify-warning']");
    public final SelenideElement notifyInfoButton = $x("//button[@data-testid='notify-info']");
    public final SelenideElement notifyToastMessage = $x("//div[contains(@class,'pointer-events-auto')]//p");

    public final SelenideElement externalLink = $x("//a[@data-testid='external-link']");
    public final SelenideElement anchorLink = $x("//a[@data-testid='anchor-link']");

    public MainPage(String url) {
        Selenide.open(url);
    }

    public void setUserName(String userName) {
        userNameInput.setValue(userName);
    }

    public void setEmail(String email) {
        emailInput.setValue(email);
    }

    public void setPassword(String password) {
        passwordInput.setValue(password);
    }

    public void setComment(String comment) {
        commentInput.setValue(comment);
    }

    public void selectCountry(Country country) {
        countryDropdown
                .scrollTo()
                .click();

        countryOption(country.getValue())
                .click();
    }

    private SelenideElement countryOption(String country) {
        return $x("//div[text()='" + country + "']");
    }


    public void subscribeToNewsletter() {
        subscribeNewsletterRadio.click();
    }

    public void acceptTerms() {
        agreeTermsCheckbox.click();
    }


    public void showNotification() {
        notificationButton.click();
    }




}
