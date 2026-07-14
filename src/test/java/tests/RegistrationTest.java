package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

@Epic("UI Tests")
@Feature("Registration")
public class RegistrationTest {

    @Test
    @Story("User registration")
    @Description("Checking user registration flow")
    @Severity(SeverityLevel.CRITICAL)
    void testRegistration() {

        System.out.println("Тест запустился");

    }
}
