package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
    private final WebDriver driver;

    // первая форма
    private final By firstNameInput = By.xpath(".//input[@placeholder='* Имя']");
    private final By lastNameInput = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By addressInput = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroInput = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By metroOption = By.className("select-search__option");
    private final By phoneInput = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.xpath(".//button[text()='Далее']");

    // локатор хэдера
    private final By header = By.className("Order_Header__BZXOb");

    // вторая форма
    private final By dateInput = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By rentalPeriodDropdown = By.className("Dropdown-placeholder");
    private final By rentalPeriodOption = By.xpath(".//div[@class='Dropdown-option' and text()='двое суток']");
    private final By scooterColorCheckbox = By.id("black");
    private final By commentInput = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private final By confirmYesButton = By.xpath(".//button[text()='Да']");
    private final By successModal = By.className("Order_ModalHeader__3FDaJ");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillFirstForm(String firstName, String lastName, String address, String phone) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(addressInput).sendKeys(address);
        driver.findElement(metroInput).click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(metroOption));
        driver.findElement(metroOption).click();
        driver.findElement(phoneInput).sendKeys(phone);
        driver.findElement(nextButton).click();
    }

    public void fillSecondForm(String date, String comment) {
        driver.findElement(dateInput).sendKeys(date);
        driver.findElement(header).click();
        driver.findElement(rentalPeriodDropdown).click();
        driver.findElement(rentalPeriodOption).click();
        driver.findElement(scooterColorCheckbox).click();
        driver.findElement(commentInput).sendKeys(comment);
        driver.findElement(orderButton).click();
        driver.findElement(confirmYesButton).click();
    }

    public boolean isOrderConfirmed() {
        return driver.findElement(successModal).isDisplayed();
    }
}
