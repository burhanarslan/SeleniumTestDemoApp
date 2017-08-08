import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AmazonTest extends page {
    WebDriverWait wait = new WebDriverWait(driver, 1000);

    //WEb Sitesi açılma testi
    @Test
    public void test_1_WebSiteControl() {
        waitForPageLoad();
        Assert.assertTrue(driver.getTitle().equals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more"));
        System.out.println("Web Sitesi Açıldı");
    }

    //Kullanıcı giriş sayfası açılma testi
    @Test
    public void test_2_loginPageReadyControl() {
        findByCss("#nav-link-accountList").click();
        Assert.assertTrue(driver.getTitle().equals("Amazon Sign In"));
        System.out.println("Sayfa kullanıcı girişi için hazır ...");
        findById("ap_email").sendKeys("YourMail@gmail.com");
        findById("ap_password").sendKeys("Your_Password");
        findById("signInSubmit").click();
        System.out.println("Kullanıcı Girişi Başarılı ...");
    }

    //samsung için arama sonucu testi
    @Test
    public void test_3_searchControl() throws InterruptedException {
        waitForPageLoad();
        wait.until(elementClickableById("twotabsearchtextbox"));
        findById("twotabsearchtextbox").sendKeys("samsung");
        findById("nav-search-submit-text").click();
        Thread.sleep(5000);
        String resultOk = findByXpad("//*[@id=\"s-result-count\"]/span/span").getText();
        Assert.assertTrue(resultOk.contains("samsung"));
        System.out.println("Samsung için sonuç bulundu");
    }

    //ikinci sayfaya tıklanma ve 2. sayfanın açılma testi
    @Test
    public void test_4_clickPageAndPageTwoOpenedControl() {
        findByCss("#pagn > span:nth-child(3) > a").click();
        waitForPageLoad();
        Assert.assertTrue(driver.getTitle().contains("Amazon.com: samsung"));
        System.out.println("2. Sayfa Gösterimde ...");
    }

    //listede 3. ürünün favorilere eklenme testi
    @Test
    public void test_5_addThirdProductFavorite() throws InterruptedException {
        //Listede 3. Ürün Oluşana Kadar Bekle
        Thread.sleep(2000);
        findByXpad("//*[@id='s-results-list-atf']/child::li[3]/div/div/div/div[1]").click();
        findById("add-to-wishlist-button-submit").click();
        Thread.sleep(4000);
        selectedFavori = findByXpad("//*[@id='productTitle']").getText();
        System.out.println("Seçilen ürünün adı: " + selectedFavori);
        findByCss("a[href*='/gp/registry/wishlist/2ODPF0C2QMSIZ/ref=cm_wl_huc_title']").click();
        System.out.println("Listeye 3. ürün eklendi.");
    }

    //Favorilerimde daha önce eklenmiş ürünün onaylanma testi
    @Test
    public void test_6_clickedFavoriteConfirmation() {
        List<WebElement> productTitles = findListByXpad("//*[@id=\'g-items\']");
        for (WebElement productTitle : productTitles) {
            favoriesCount += 1;
            String watchesProduct = productTitle.getText();
            if (watchesProduct.equals(selectedFavori)) {
                System.out.println("Favoriye Eklenen Ürün Onaylandı.Ürünün Başlığı :" + watchesProduct + "\n");
                willDeleteFavorite = favoriesCount;
                Assert.assertTrue(watchesProduct.equals(selectedFavori));
                //System.out.println("Seçilen ürn favorilere eklenmiş durumdadır.");
            }
        }
    }

    //Favorilerden aynı ürünün silinme testi
    @Test
    public void test_7_deleteSelectedProduct() {
        findByXpad("//*[@id=\"a-autoid-6\"]").click();
        waitForPageLoad();
        System.out.println("Seçilen ürn favorilerden silinmiş durumdadır.");
    }

    //Silinen ürünün favorilerim listesinde bulunmadığının testi
    @Test
    public void test_8_checkDeletedFavorite() {

        boolean isThereProduct = false;
        List<WebElement> productTitles = findListByXpad("//*[@class='productTitle']/p/a");
        for (WebElement productTitle : productTitles) {
            String watchesProduct = productTitle.getText();
            if (watchesProduct.equals(selectedFavori)) {
                isThereProduct = true;
            }
        }
        Assert.assertFalse(isThereProduct);
        System.out.println("Favorilerim Sayfasında " + selectedFavori + " isimli ürün artık bulunmuyor ...");
    }
}
