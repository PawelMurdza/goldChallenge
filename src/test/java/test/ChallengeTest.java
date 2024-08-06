package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Constants;
import utils.Hooks;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChallengeTest extends Hooks {

    private void performWeighing(List<Integer> leftCoins, List<Integer> rightCoins) {
        for (int i = 0; i < leftCoins.size(); i++) {
            sendText(challengePage.leftBowl.get(i), String.valueOf(leftCoins.get(i)));
            sendText(challengePage.rightBowl.get(i), String.valueOf(rightCoins.get(i)));
        }
        click(challengePage.weighButton);
    }

    @Test
    public void solveChallenge() {
        String fakeBar = null;
        List<Integer> goldCoins = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8);
        List<String> weightings = new ArrayList<>();

        // Navigate to the challenge page and make sure it's loaded
        driver.navigate().to(Constants.CHALLENGE_URL);
        getWait().until(ExpectedConditions.titleIs("React App"));
        Assertions.assertTrue(challengePage.weighButton.isDisplayed());

        //Perform 1st weigh in and get result
        WebElement resultOperator = challengePage.buttons.get(0);
        WebElement resetButton = challengePage.buttons.get(1);

        performWeighing(goldCoins.subList(0, 3), goldCoins.subList(3, 6));

        waitForTextToChange(resultOperator, "?");
        String result = challengePage.weightings.get(0).getText();
        weightings.add(result);

        click(resetButton);

        if (result.contains("=")) {
            goldCoins = goldCoins.subList(6, 9);

        } else if (result.contains(">")) {
            goldCoins = goldCoins.subList(3, 6);

        } else if (result.contains("<")) {
            goldCoins = goldCoins.subList(0, 3);
        }

        //Perform 2nd weigh in and find fake bar
        performWeighing(goldCoins.subList(0, 1), goldCoins.subList(1, 2));

        waitForTextToChange(resultOperator, "?");
        String result2 = challengePage.weightings.get(1).getText();
        weightings.add(result2);

        if (result2.contains("=")) {
            fakeBar = String.valueOf(goldCoins.get(2));

        } else if (result2.contains(">")) {
            fakeBar = String.valueOf(goldCoins.get(1));

        } else if (result2.contains("<")) {
            fakeBar = String.valueOf(goldCoins.get(0));
        }

        assert fakeBar != null;

        click(challengePage.answerNumbers.get(Integer.parseInt(fakeBar)));

        weightings.forEach(System.out::println);
        System.out.println("Number of weigh-ins : " + weightings.size());
        System.out.println("Fake gold bar : " + fakeBar);

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);

        //Close alert
        alert.accept();
    }
}