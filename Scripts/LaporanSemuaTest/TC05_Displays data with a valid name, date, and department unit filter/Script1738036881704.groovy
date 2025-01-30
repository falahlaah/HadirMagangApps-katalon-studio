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

SelectStartDate('18', 'December', '2024')

SelectEndDate('24', 'December', '2024')

WebUI.click(findTestObject('LaporanSemuaPage/Date section/btn_save'))

WebUI.waitForElementVisible(findTestObject('LaporanSemuaPage/input_searchName'), 2)

WebUI.sendKeys(findTestObject('LaporanSemuaPage/input_searchName'), 'budi')

WebUI.waitForElementVisible(findTestObject('LaporanSemuaPage/icon_filter'), 2)

WebUI.click(findTestObject('LaporanSemuaPage/icon_filter'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('LaporanSemuaPage/filter section/input_UnitDepartement'), 2)

WebUI.sendKeys(findTestObject('LaporanSemuaPage/filter section/input_UnitDepartement'), 'IT Programmer')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('LaporanSemuaPage/filter section/input_UnitDepartement'), Keys.chord(Keys.ARROW_DOWN, Keys.ENTER))

String unitDepartement = WebUI.getText(findTestObject('LaporanSemuaPage/filter section/input_UnitDepartement'))

WebUI.click(findTestObject('LaporanSemuaPage/filter section/btn_Terapkan'))

WebUI.click(findTestObject('LaporanSemuaPage/btn_search'))

WebUI.delay(2)

WebUI.verifyEqual(getVerifyDates(), true)

WebUI.verifyEqual(getVerifyName(), true)

WebUI.verifyEqual(getVerifyUnit(unitDepartement), true)

WebUI.closeBrowser()

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

def getVerifyDates() {
    String startDate = WebUI.getAttribute(findTestObject('LaporanSemuaPage/Date section/input_StartDate'), 'value')

    if (startDate.contains('Agt')) {
        startDate = startDate.replace('Agt', 'Agu')
    }
    
    String endDate = WebUI.getAttribute(findTestObject('LaporanSemuaPage/Date section/input_EndDate'), 'value')

    if (endDate.contains('Agt')) {
        endDate = endDate.replace('Agt', 'Agu')
    }
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern('dd MMM yyyy', Locale.forLanguageTag('id-ID'))

    LocalDate awalDate = LocalDate.parse(startDate, formatter)

    LocalDate akhirDate = LocalDate.parse(endDate, formatter)

    List<WebElement> dates = WebUI.findWebElements(findTestObject('LaporanSemuaPage/Table Section/list_JamMasuk'), 3)

    for (WebElement dataDates : dates) {
        String ActualdateDisplay = dataDates.getText()

        if (ActualdateDisplay.contains('Agt')) {
            ActualdateDisplay = ActualdateDisplay.replace('Agt', 'Agu')
        }
        
        LocalDate dateDisplay = LocalDate.parse(ActualdateDisplay, formatter)

        if (dateDisplay.isBefore(awalDate) || dateDisplay.isAfter(akhirDate)) {
            return false
        }
        
        WebUI.scrollToPosition(0, 100)
    }
    
    return true
}

def getVerifyName() {
	List<WebElement> list_name = WebUI.findWebElements(findTestObject('LaporanSemuaPage/Table Section/list_Name'), 3)
	String searchName = WebUI.getText(findTestObject('LaporanSemuaPage/input_searchName'))
	for (WebElement name : list_name) {
		if (!name.getText().contains(searchName)){
			return false;
		}
		WebUI.scrollToPosition(0, 100)
	}
	return true;
}

def getVerifyUnit(String departement) {
    List<WebElement> list_unit = WebUI.findWebElements(findTestObject('LaporanSemuaPage/Table Section/list_Unit'), 3)

    for (WebElement unit : list_unit) {
        if (!(unit.getText().contains(departement))) {
            return false
        }
        
        WebUI.scrollToPosition(0, 100)
    }
    
    return true
}

