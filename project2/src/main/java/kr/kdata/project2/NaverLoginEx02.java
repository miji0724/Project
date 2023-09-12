package kr.kdata.project2;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// 기본적으로 Selenium 4는 Chrome v75 이상과 호환됩니다. Chrome 브라우저 버전과 chromedriver 버전이 주 버전과 일치해야 합니다.

/*
왜 우리는 셀레늄을 기다릴 필요가 있습니까?
대부분의 웹 애플리케이션은 Ajax와 Javascript를 사용하여 개발되었습니다. 
페이지가 브라우저에 의해로드 될 때 상호 작용하려는 요소는 다른 시간 간격으로로드 될 수 있습니다.
요소 식별이 어려울뿐 아니라 요소가 없으면 " ElementNotVisibleException"예외가 발생합니다. Waits를 사용하여이 문제를 해결할 수 있습니다.
 */
public class NaverLoginEx02 {
	public static void main(String[] args) {

		// 1. 웹드라이버의 경로를 지정해 주어야 한다.
		System.setProperty("webdriver.chrome.driver", new File("src/main/resources/chromedriver.exe").getAbsolutePath());
		
		// 2. Selenium으로 브라우저 열기
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		// 기본 URL로 리디렉션합니다.
		driver.get("https://nid.naver.com/nidlogin.login" );
		// 브라우저 창을 최대화합니다.
		driver.manage().window().maximize() ;
		// 암시 적 대기
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		/*
		WebElement idBox = driver.findElement(By.id("id"));
		idBox.sendKeys("자신의 네이버아이디");
		
		WebElement pwBox = driver.findElement(By.id("pw"));
		pwBox.sendKeys("자신의 네이버 비밀번호");
		*/
		// 아이디와 비번을 자바스크립트를 이용하여 입력한다.
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("document.getElementById('id').value='miji8450'");
		js.executeScript("document.getElementById('pw').value='alwl8450!'");
		
		// 로그인 버튼을 찾는다.
		WebElement loginButton = driver.findElement(By.id("log.login"));
		// 찾은 버튼을 클릭 한다.
		loginButton.click();
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

	    
		// 3. Selenium으로 브라우저 닫기(세션종료)
		// driver.quit();
	}
}
