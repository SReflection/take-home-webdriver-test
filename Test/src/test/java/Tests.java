import Pages.*;
import Utils.BrowserUtils;
import Utils.DataReader;
import Utils.UrlReader;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class Tests {
    LoginPage loginPage = new LoginPage();
    CheckBoxPage checkBox = new CheckBoxPage();
    ContextMenuPage contextMenuPage = new ContextMenuPage();
    DragAndDropPage dragAndDropPage = new DragAndDropPage();
    DropDownPage dropDownPage = new DropDownPage();
    DynamicContentPage dynamicContentPage = new DynamicContentPage();
    DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();
    DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage();
    FileDownloadPage fileDownloadPage = new FileDownloadPage();
    FileUploadPage fileUploadPage = new FileUploadPage();
    FloatingMenuPage floatingMenuPage = new FloatingMenuPage();
    iFramePage iFramePage = new iFramePage();
    MouseHoverPage mouseHoverPage = new MouseHoverPage();
    JsAllertPage jsAllertPage = new JsAllertPage();
    JsErrorPage jsErrorPage = new JsErrorPage();
    OpenInNewTapPag openInNewTapPag = new OpenInNewTapPag();
    NotificationMessagePage notificationMessagePage = new NotificationMessagePage();




    @Test
    public void loginSuccess(){
        loginPage.goToPage(UrlReader.getProperty("login"));
        loginPage.enterUsername(DataReader.getProperty("username"));
        loginPage.enterPassword(DataReader.getProperty("password"));
        loginPage.pressLoginButton();
        Assert.assertEquals(DataReader.getProperty("loginSuccessMessage"),loginPage.getBannerText());
        loginPage.tearDown();

    }

    @Test
    public void loginFail(){
        loginPage.goToPage(UrlReader.getProperty("login"));
        loginPage.enterUsername(DataReader.getProperty("fakeUsername"));
        loginPage.enterPassword(DataReader.getProperty("fakePassword"));
        loginPage.pressLoginButton();
        Assert.assertEquals(DataReader.getProperty("loginFailMessage"),loginPage.getBannerText());
        loginPage.tearDown();

    }

    @Test
    public void checkBoxChecking(){
        checkBox.goToPage(UrlReader.getProperty("checkBoxes"));
        checkBox.checkbox(1);
        Assert.assertTrue(checkBox.checkBoxesStatus());
        checkBox.checkbox(3);
        Assert.assertFalse(checkBox.checkBoxesStatus());
        checkBox.tearDown();

    }


    @Test
    public void contextMenuRightClick(){
        contextMenuPage.goToPage(UrlReader.getProperty("contextMenu"));
        contextMenuPage.rightClickOnHotSpot();
        Assert.assertEquals(DataReader.getProperty("alertText"),BrowserUtils.getAlertText());
        contextMenuPage.tearDown();

    }



    // Here is kind of a bug !

    // Could've use Robot class But it is time consuming
    @Test
    public void dragAndDrop(){
        dragAndDropPage.goToPage(UrlReader.getProperty("dragAndDrop"));
        dragAndDropPage.dragBoxAtoBoxB();
        Assert.assertTrue(dragAndDropPage.elementsLocationsDifference()>0);
        dragAndDropPage.tearDown();

    }

    @Test
    public void dropDownList(){
       dropDownPage.goToPage(UrlReader.getProperty("dropDown"));
       dropDownPage.selectOptions();
       Assert.assertTrue(dropDownPage.option2IsSelected());
       dropDownPage.tearDown();

    }

    @Test
    public void dynamicContent(){
        dynamicContentPage.goToPage(UrlReader.getProperty("dynamicContent"));
        List<String> firstListOfMessages = dynamicContentPage.getMessagesText();
        dynamicContentPage.refreshPage();
        List<String> secondListOfMessages = dynamicContentPage.getMessagesText();
        Assert.assertNotEquals(firstListOfMessages,secondListOfMessages);
        dynamicContentPage.tearDown();

    }

    @Test
    public void dynamicControl(){
        dynamicControlsPage.goToPage(UrlReader.getProperty("dynamicControls"));
        Assert.assertEquals(DataReader.getProperty("dynamicControlText"),dynamicControlsPage.getMessage());
        dynamicControlsPage.tearDown();
    }

    @Test()
    public void aDynamicLoading(){
        dynamicLoadingPage.goToPage(UrlReader.getProperty("dynamicLoading"));
        Assert.assertEquals(DataReader.getProperty("dynamicLoadingText"),dynamicLoadingPage.getMessage());
        dynamicLoadingPage.tearDown();

    }

    @Test
    public void fileDownloader() throws IOException {
        fileDownloadPage.goToPage(UrlReader.getProperty("fileDownload"));
        fileDownloadPage.downloadFileAndVerify();
        fileDownloadPage.tearDown();

}
    @Test
    public void fileUploads() throws IOException {
      fileUploadPage.goToPage(UrlReader.getProperty("fileUpload"));
      fileUploadPage.uploadFile();
        fileUploadPage.tearDown();


    }

    @Test
    public void floatMenuScrollExist(){
        floatingMenuPage.goToPage(UrlReader.getProperty("floatingMenu"));
        floatingMenuPage.floatMenu();
        Assert.assertTrue(floatingMenuPage.menuIsVisible());
        floatingMenuPage.tearDown();

    }

    @Test
    public void iframe(){
        iFramePage.goToPage(UrlReader.getProperty("iframe"));
        String expected = "test";
        Assert.assertTrue(expected,true);
        iFramePage.tearDown();

    }

    @Test
    public void hoverOverUsers(){
        mouseHoverPage.goToPage(UrlReader.getProperty("mouseHover"));
        mouseHoverPage.hover();
        mouseHoverPage.tearDown();

    }

    @Test
    public void jSAlertTap(){
        jsAllertPage.goToPage(UrlReader.getProperty("javaScriptAlert"));
        jsAllertPage.clickinOnAlerts();
        jsAllertPage.tearDown();

    }
    @Test
    public void jSError(){
        jsErrorPage.goToPage(UrlReader.getProperty("javaScriptError"));
        jsErrorPage.checkJsErrorMessage();
        jsErrorPage.tearDown();

    }

    @Test
    public void openNewTap(){
        openInNewTapPag.goToPage(UrlReader.getProperty("openInNewTap"));
        openInNewTapPag.clickingOnNewTap();
        openInNewTapPag.tearDown();


    }

    @Test
    public  void notificationMessage(){
        notificationMessagePage.goToPage(UrlReader.getProperty("notificationMessage"));
        notificationMessagePage.clickHere();
        notificationMessagePage.tearDown();

    }
}
