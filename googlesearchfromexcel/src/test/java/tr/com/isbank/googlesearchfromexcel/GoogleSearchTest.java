package tr.com.isbank.googlesearchfromexcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

public class GoogleSearchTest {
    private WebDriver driver;

    private Workbook workbook;

    @BeforeEach
    public void setUp() throws IOException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com/");

        // Load the Excel file from the resources directory
        FileInputStream fis = new FileInputStream(new File("src/test/resources/data.xlsx"));
        workbook = new XSSFWorkbook(fis);
    }
    @Test
    @DisplayName("Perform Google Search Test")
    public void performGoogleSearchTest() throws InterruptedException {

        // Get the first sheet of the workbook
        Sheet sheet = workbook.getSheetAt(0);

        // Get an iterator to iterate over the rows of the sheet
        Iterator<Row> rowIterator = sheet.iterator();

        // Skip the header row
        if (rowIterator.hasNext()) {
            rowIterator.next();
        }

        // Iterate over each row of the sheet until the end of the file
        while (rowIterator.hasNext()) {

            // Get the next row
            Row row = rowIterator.next();

            // Get the search query from the first cell of the row
            Cell cell = row.getCell(0);
            String searchQuery = cell.getStringCellValue();

            // Perform the Google search
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.clear();
            searchBox.sendKeys(searchQuery);
            searchBox.submit();

            // Wait for the search results to load
            Thread.sleep(2000);
            //Expilicit Wait Tanımlaama daha efektif...


            // Assert the search results page title
            String expectedTitle = searchQuery + " - Google'da Ara";
            String actualTitle = driver.getTitle();
            Assertions.assertEquals(expectedTitle, actualTitle);
        }

        // Close the file input stream
        //  fis.close();
    }


    @AfterEach
    public void tearDown() {
        // Quit the driver
        if (driver != null) {
            driver.quit();
        }
    }

}
