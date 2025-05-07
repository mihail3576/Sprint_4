package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;

    // локатор верхней кнопки заказать
    private final By topOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    // локатор нижней кнопки заказать
    private final By bottomOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");

    // локатор секции "Вопросы о важном"
    private final By faqSection = By.className("Home_FAQ__3uVm4");
    // локатор вопроса
    private final String questionLocatorTemplate = "//div[@data-accordion-component='AccordionItem'][%d]//div[@role='button']";
    // локатор ответа
    private final String answerLocatorTemplate = "//div[@data-accordion-component='AccordionItem'][%d]//div[@data-accordion-component='AccordionItemPanel']";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

     private void scrollTo(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
    }

    public void clickBottomOrderButton() {
        WebElement button = driver.findElement(bottomOrderButton);
        scrollTo(button);
        button.click();
    }

    public void clickQuestionByIndex(int index) {
        scrollTo(driver.findElement(faqSection));

        By questionPath = By.xpath(String.format(questionLocatorTemplate, index));
        driver.findElement(questionPath).click();
    }

    public String getAnswerTextByIndex(int index) {
        By answerPath = By.xpath(String.format(answerLocatorTemplate, index));
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(answerPath));
        return driver.findElement(answerPath).getText();
    }
}
