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

WebUI.waitForElementVisible(findTestObject('LaporanSemuaPage/icon_filter'), 2)

WebUI.click(findTestObject('LaporanSemuaPage/icon_filter'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('LaporanSemuaPage/filter section/input_UnitDepartement'), 2)

WebUI.sendKeys(findTestObject('LaporanSemuaPage/filter section/input_UnitDepartement'), 'SQA-RPA Benhil')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('LaporanSemuaPage/filter section/input_UnitDepartement'), Keys.chord(Keys.ARROW_DOWN, Keys.ENTER))

WebUI.click(findTestObject('LaporanSemuaPage/filter section/btn_Terapkan'))

WebUI.delay(1)

WebUI.verifyElementText(findTestObject('LaporanSemuaPage/Table Section/txtSumData'), '0-0 of 0')

WebUI.closeBrowser()

