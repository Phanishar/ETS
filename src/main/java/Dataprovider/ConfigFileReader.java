package Dataprovider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath = "configs//Config.properties";

	public ConfigFileReader() {
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getReportConfigPath() {
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if (reportConfigPath != null)
			return reportConfigPath;
		else
			throw new RuntimeException(
					"Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
	}

	public String getApplicationUrl() {
		String env = properties.getProperty("Env");
		String url = "";
		if (env.equalsIgnoreCase("DEV")) {
			url = properties.getProperty("Dev_URL");

		} else if ((env.equalsIgnoreCase("TEST"))) {
			url = properties.getProperty("Test_URL");

		} else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
		return url;
	}

	public String getEnvironment() {
		String environmentName = properties.getProperty("Env");
		if (environmentName == null || environmentName.equalsIgnoreCase("dev"))
			return environmentName;
		else if (environmentName.equalsIgnoreCase("test"))
			return environmentName;
		else
			throw new RuntimeException(
					"Environment Type Key value in Configuration.properties is not matched : " + environmentName);
	}

	public String getDriverPathforIE() {

		String driverPath = properties.getProperty("IE_DriverPath");

		if (driverPath != null)
			return driverPath;

		else
			throw new RuntimeException("IEdriverPath not specified in the Configuration.properties file.");

	}

	public String getDriverPathforChrome() {

		String driverPath = properties.getProperty("Chrome_DriverPath");

		if (driverPath != null)
			return driverPath;

		else
			throw new RuntimeException("ChromedriverPath not specified in the Configuration.properties file.");

	}

}
