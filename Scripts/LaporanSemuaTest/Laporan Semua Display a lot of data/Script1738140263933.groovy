import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import java.time.LocalDate as LocalDate
import java.time.format.DateTimeFormatter as DateTimeFormatter
import java.util.Locale as Locale

WebUI.callTestCase(findTestCase('LoginAndLogoutTest/LoginValid'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('HomePage/sideMenu_Laporan'), 3)

WebUI.click(findTestObject('HomePage/sideMenu_Laporan'))

WebUI.waitForElementVisible(findTestObject('HomePage/SubMenuLaporan_Semua'), 3)

WebUI.click(findTestObject('HomePage/SubMenuLaporan_Semua'))

WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('LaporanSemuaPage/Date section/icon_startDateCal'))

SelectStartDate('1', 'January', '2023')

SelectEndDate('24', 'December', '2024')

WebUI.click(findTestObject('LaporanSemuaPage/Date section/btn_save'))

WebUI.click(findTestObject('LaporanSemuaPage/btn_search'))

WebUI.delay(2)

def SelectStartDate(String date, String month, String year) {
    WebUI.selectOptionByLabel(findTestObject('LaporanSemuaPage/Date section/select_Month'), month, false)

    WebUI.selectOptionByValue(findTestObject('LaporanSemuaPage/Date section/select_Year'), year, false)

    List<WebElement> days = WebUI.findWebElements(findTestObject('LaporanSemuaPage/Date section/list_days'), 3)

    for (WebElement day : days) {
        if (day.getText().equalsIgnoreCase(date)) {
            day.click()

            break
        }
    }
}

def SelectEndDate(String date, String month, String year) {
    WebUI.selectOptionByLabel(findTestObject('LaporanSemuaPage/Date section/select_Month'), month, false)

    WebUI.selectOptionByValue(findTestObject('LaporanSemuaPage/Date section/select_Year'), year, false)

    List<WebElement> days = WebUI.findWebElements(findTestObject('LaporanSemuaPage/Date section/list_days'), 5)

    for (WebElement day : days) {
        if (day.getText().equalsIgnoreCase(date)) {
            day.click()

            break
        }
    }
}

