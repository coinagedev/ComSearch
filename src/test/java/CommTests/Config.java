package CommTests;

public interface Config {

    final String baseUrl = System.getProperty("baseUrl", "https://qalite.legosandbox.com");
	// final String baseUrl = System.getProperty("baseUrl", "https://master.legosandbox.com");
	//final String baseUrl = System.getProperty("baseUrl", "https://qaauto.legosandbox.com");
	final String host = System.getProperty("host", "localhost");
	final String chrome = System.getProperty("browser", "chrome");
	final String edge = System.getProperty("browser", "Edge");
	final String firefox = System.getProperty("browser", "firefox");
	final String ie = System.getProperty("browser", "IE");

	final String platform = System.getProperty("platform","Windows");
	final String os_version = System.getProperty("os_version", "10");
	final String resolution = System.getProperty("resolution","2048x1536");

}