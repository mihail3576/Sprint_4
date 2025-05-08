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
    private final By successModal = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void enterAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }

    public void selectMetroStation() {
        driver.findElement(metroInput).click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(metroOption));
        driver.findElement(metroOption).click();
    }

    public void enterPhone(String phone) {
        driver.findElement(phoneInput).sendKeys(phone);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void fillFirstForm(String firstName, String lastName, String address, String phone) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterAddress(address);
        selectMetroStation();
        enterPhone(phone);
        clickNextButton();
    }

    public void enterDate(String date) {
        driver.findElement(dateInput).sendKeys(date);
        driver.findElement(header).click();
    }

    public void selectRentalPeriod() {
        driver.findElement(rentalPeriodDropdown).click();
        driver.findElement(rentalPeriodOption).click();
    }

    public void selectScooterColor() {
        driver.findElement(scooterColorCheckbox).click();
    }

    public void enterComment(String comment) {
        driver.findElement(commentInput).sendKeys(comment);
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void confirmOrder() {
        driver.findElement(confirmYesButton).click();
    }

    public void fillSecondForm(String date, String comment) {
        enterDate(date);
        selectRentalPeriod();
        selectScooterColor();
        enterComment(comment);
        clickOrderButton();
        confirmOrder();
    }

    public boolean isOrderConfirmed() {
        return driver.findElement(successModal).isDisplayed();
    }
}
