package tests;


import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pageobjects.MainPage;
import pageobjects.OrderPage;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String phone;
    private final String date;
    private final String comment;

    public OrderTest(String firstName, String lastName, String address, String phone, String date, String comment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.date = date;
        this.comment = comment;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"Иван", "Иванов", "Тест 1", "89991234567", "07.05.2025", "Позвонить"},
                {"Ольга", "Ольговна", "Тест 2", "89001112233", "08.05.2025", "Позвонить"}
        });
    }

    @Test
    public void testOrderViaTopButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickTopOrderButton();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillFirstForm(firstName, lastName, address, phone);
        orderPage.fillSecondForm(date, comment);

        assertTrue(orderPage.isOrderConfirmed());
    }

    @Test
    public void testOrderViaBottomButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBottomOrderButton();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillFirstForm(firstName, lastName, address, phone);
        orderPage.fillSecondForm(date, comment);

        assertTrue(orderPage.isOrderConfirmed());
    }
}
