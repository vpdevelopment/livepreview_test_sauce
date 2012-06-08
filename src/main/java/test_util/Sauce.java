package test_util;

import static test_util.Util.timeNow;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/* For Sauce Labs OnDemand. */
public class Sauce extends Base {
	
	protected Key key = new Key();

	/**
	 * Accepts the following as valid os strings:
	 * 
	 * <pre>
	 * xp    = Windows Server 2003 (on Sauce) 
	 * vista = Windows Server 2008 (on Sauce)
	 * linux
	 * </pre>
	 * 
	 * @param os
	 *            desired OS.
	 * @return platform to run on.
	 */
	private static Platform getOS(String os) {
		os = os.toLowerCase();

		if (os.contentEquals("xp")) {
			return Platform.XP;
		}

		if (os.contentEquals("vista")) {
			return Platform.VISTA;
		}

		if (os.contentEquals("linux")) {
			return Platform.LINUX;
		}

		throw new RuntimeException("Unknown operating system: " + os);
	}

	/**
	 * Accepts chrome or firefox as valid browsers. Firefox defaults to latest
	 * stable version used by Sauce (currently 11). Chrome automatically
	 * defaults to latest stable version.
	 * 
	 * @param browser
	 * @return
	 */
	private static DesiredCapabilities getBrowser(String browser) {
		browser = browser.toLowerCase();

		if (browser.contentEquals("chrome")) {
			return DesiredCapabilities.chrome();
		}

		if (browser.contentEquals("firefox")) {
			final DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setCapability("version", "11");
			return cap;
		}
		
		/* Test IE 9 (Ace supports IE >= 9) */
		if (browser.contentEquals("ie")) {
			final DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
			cap.setCapability("version", "9");
			return cap;
		}

		throw new RuntimeException("Unknown browser: " + browser);
	}

	protected void setUpDriver(final String os, final String browser) {
		// Don't record videos.
		// capabillities.setCapability("record-video", false);
		// Don't record screenshots.
		// capabillities.setCapability("record-screenshots", false);

		final DesiredCapabilities capabilities = getBrowser(browser);
		capabilities.setCapability("platform", getOS(os));
		final String name = os + "_" + browser + "_" + timeNow();
		capabilities.setCapability("name", name);

		try {
			driver = new RemoteWebDriver(new URL(key.url()),
					capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		exec = (JavascriptExecutor) driver;
	}
}