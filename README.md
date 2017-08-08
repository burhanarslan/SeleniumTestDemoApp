 Selenium WebDriver Example With Java
===================

 **Test Koşturulan Ortam Bilgileri Aşağıdaki Gibidir.**

> İşletim sistemi: Windows 7, İDE: intellij community, Browser : Firefox Mozilla 50.1.0, Kullanılan Dil : Java Junit version : 4.12 Geckodriver version : 0.13.0

----------


**Note:**

> - Firefox ayarlaması için aşağıda linkte bulunan size uygun driver'ı indirin ; https://github.com/mozilla/geckodriver/releases
> - utility.java içerisinde aşağıda bulunan kodu bulun ve indirdiğiniz driver'ın yolunu gösterin ve kaydedin. 
> - System.setProperty("webdriver.gecko.driver", "Driverın bulunduğu adres");


 **Test Koşturma işlemleri**
>   **Test Senaryosu**

> - https://www.amazon.com/ sitesine gelecek ve anasayfanin acildigini onaylayacak.
> - Login ekranini acip, bir kullanici ile login olacak ( daha once siteye uyeligin varsa o olabilir ).
> - Ekranin ustundeki Search alanina 'samsung' yazip Ara butonuna tiklayacak.
> - Gelen sayfada samsung icin sonuc bulundugunu onaylayacak.
> - Arama sonuclarindan 2. sayfaya tiklayacak ve acilan sayfada 2. sayfanin su an gosterimde oldugunu onaylayacak.
> - Ustten 3. urunun icindeki 'Add to List' butonuna tiklayacak.
> - Ekranin en ustundeki 'Wish List' linkine tiklayacak.
> - Acilan sayfada bir onceki sayfada izlemeye alinmis urunun bulundugunu onaylayacak.
> - Favorilere alinan bu urunun yanindaki 'Delete' butonuna basarak, favorilerimden cikaracak.
> - Sayfada bu urunun artik favorilere alinmadigini onaylayacak.


**Ekran Görüntüsü**
> ![alt text](https://github.com/burhanarslan/SeleniumTestDemoApp/blob/master/screenshot/Amazon.gif?raw=true "Logo Title Text 1")