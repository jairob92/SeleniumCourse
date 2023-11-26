package practice;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        // Diligenciar datos del formulario
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Thread.sleep(2000);
        //driver.findElement(By.id("user-name")).clear();
        //driver.findElement(By.id("login-button")).click();
        // validar que nos logueamos correctamente
        /*
         * String obtener_titulo= driver.getTitle(); String titulo="Swag Labs";
         * System.out.println(obtener_titulo); if(obtener_titulo.equals(titulo)) {
         * System.out.println("Succesfull test"); } else {
         * System.out.println("Test fallido"); }
         */
        Thread.sleep(2000);
        String products = null;

        try {

            products = driver.findElement(By.className("title")).getText();

        } catch (NoSuchElementException e) {
            products = "";
            // Maneja la excepción generando un mensaje
            System.out.println("El elemento 'titlee' no se encontró en la página.");
        }

        String expect_products = "Products";
        // System.out.println(products);
        if (products.equals(expect_products)) {
            System.out.println("you are in dashboard");
        } else {
            System.out.println("you aren't in dashboard");
        }

        driver.close();

    }

}
