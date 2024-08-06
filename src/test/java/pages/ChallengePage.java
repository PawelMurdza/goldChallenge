package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import  utils.CommonMethods;
import java.util.List;

public class ChallengePage extends CommonMethods{

    @FindBy(id = "reset")
    public List<WebElement> buttons;

    @FindBy(id = "weigh")
    public WebElement weighButton;

    @FindBy(xpath = "//*[@class='game-info']/ol/li")
    public List<WebElement> weightings;

    @FindBy(xpath = "//*[@class='coins']/button")
    public List<WebElement> answerNumbers;

    @FindBy(xpath = "//*[@data-side='left']")
    public List<WebElement> leftBowl;

    @FindBy(xpath = "//*[@data-side='right']")
    public List<WebElement> rightBowl;

    public ChallengePage() {
        PageFactory.initElements(driver,this);
    }
}