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

WebUI.callTestCase(findTestCase('LaporanSemuaTest/Laporan Semua Display a lot of data'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.scrollToElement(findTestObject('LaporanSemuaPage/Table Section/optionRowIcon'), 5)

WebUI.click(findTestObject('LaporanSemuaPage/Table Section/optionRowIcon'))

WebUI.waitForElementClickable(findTestObject('LaporanSemuaPage/Table Section/optionRow5'), 5)

WebUI.click(findTestObject('LaporanSemuaPage/Table Section/optionRow5'))

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyEqual(getSizeRowDisplayed(), 5)

WebUI.scrollToElement(findTestObject('LaporanSemuaPage/Table Section/optionRowIcon'), 5)

WebUI.click(findTestObject('LaporanSemuaPage/Table Section/optionRowIcon'))

WebUI.waitForElementClickable(findTestObject('LaporanSemuaPage/Table Section/optionRow25'), 5)

WebUI.click(findTestObject('LaporanSemuaPage/Table Section/optionRow25'))

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyEqual(getSizeRowDisplayed(), 25)

WebUI.scrollToElement(findTestObject('LaporanSemuaPage/Table Section/optionRowIcon'), 5)

WebUI.click(findTestObject('LaporanSemuaPage/Table Section/optionRowIcon'))

WebUI.waitForElementClickable(findTestObject('LaporanSemuaPage/Table Section/optionRow10'), 5)

WebUI.click(findTestObject('LaporanSemuaPage/Table Section/optionRow10'))

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyEqual(getSizeRowDisplayed(), 10)

WebUI.closeBrowser()

def getSizeRowDisplayed() {
    List<WebElement> list_name = WebUI.findWebElements(findTestObject('LaporanSemuaPage/Table Section/list_Name'), 3)

    return list_name.size()
}

