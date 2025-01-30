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

WebUI.scrollToElement(findTestObject('LaporanSemuaPage/Table Section/nextPageIcon'), 5)

WebUI.click(findTestObject('LaporanSemuaPage/Table Section/nextPageIcon'))

WebUI.verifyElementText(findTestObject('LaporanSemuaPage/Table Section/txtSumData'), '11-20 of 6989')

WebUI.click(findTestObject('LaporanSemuaPage/Table Section/prevPageIcon'))

WebUI.verifyElementText(findTestObject('LaporanSemuaPage/Table Section/txtSumData'), '1-10 of 6989')

WebUI.click(findTestObject('LaporanSemuaPage/Table Section/lastPageIcon'))

WebUI.verifyElementText(findTestObject('LaporanSemuaPage/Table Section/txtSumData'), '6981-6989 of 6989')

WebUI.click(findTestObject('LaporanSemuaPage/Table Section/firstPageIcon'))

WebUI.verifyElementText(findTestObject('LaporanSemuaPage/Table Section/txtSumData'), '1-10 of 6989')

WebUI.closeBrowser()

