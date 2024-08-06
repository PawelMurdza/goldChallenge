package test;

import pages.ChallengePage;

public class PageInitializer {

    public static ChallengePage challengePage;

    public static void initializePageObjects() {

        challengePage = new ChallengePage();
    }
}
