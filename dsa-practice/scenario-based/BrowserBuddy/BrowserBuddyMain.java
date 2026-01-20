package scenario.BrowserBuddy;

public class BrowserBuddyMain {

    public static void main(String[] args) {

        BrowserBuddy browser = new BrowserBuddy();

        browser.openPage("google.com");
        browser.openPage("openai.com");
        browser.openPage("github.com");

        System.out.println(browser.back());      // openai.com
        System.out.println(browser.back());      // google.com
        System.out.println(browser.forward());   // openai.com

        browser.closeTab();                      // close current tab

        System.out.println(browser.restoreTab()); // restores tab
        System.out.println(browser.showCurrentPage());
    }
}
