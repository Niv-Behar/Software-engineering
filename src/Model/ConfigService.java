package Model;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class ConfigService {
	private String creator;
	private int monthlyRevenue;
	private int wantedSaveValue;
	private int totalSaved;
	private boolean configStatus;
	private String _id;

	 private static final String restURL ="http://schoolproject-env.eba-qp6e4y82.us-east-2.elasticbeanstalk.com/"+"api/config";
	// PRODUCTION:
//	private static final String restURL = "http://localhost:3000/api/config";

	// Singleton:
	private static ConfigService INSTANCE = new ConfigService();

	private ConfigService() {
	};

	public static ConfigService getInstance() {
		return INSTANCE;
	}

	// Creating only when a new account is created ! - AKA after Signup!
	public boolean createConfig(String userId, String token) {
		boolean result = true;
		String query_url = restURL;
		try {
			JSONObject JSON = new JSONObject();
			String json = JSON.toString();
			URL url = new URL(query_url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			// Setting header: for authorization
			conn.setRequestProperty("Authorization", "Bearer " + token);
			conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("POST");
			OutputStream os = conn.getOutputStream();
			os.write(json.getBytes("UTF-8"));
			os.close();
			// read the response
			InputStream in = new BufferedInputStream(conn.getInputStream());
			String response = IOUtils.toString(in, "UTF-8");
			// Parsing the json object from response :
			JSONObject myResponse = new JSONObject(response);
			// Initial values for new user config!
			_id = myResponse.getString("_id");
			creator = userId;
			this.configStatus = false;
			this.monthlyRevenue = 0;
			this.totalSaved = 0;
			this.wantedSaveValue = 0;
			// Closing connection
			in.close();
			conn.disconnect();
		} catch (Exception e) {
			// In case of unsuccessful response with status of other then 200/201....
			result = false;
		}
		return result;
	}

	// Fetching the config file from the server - should be done when a user logs
	// in!
	public boolean fetchConfig(String token) {
		String query_url = restURL;
		boolean result = true;
		try {
			URL url = new URL(query_url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			// Setting header: for authorization
			conn.setRequestProperty("Authorization", "Bearer " + token);
			conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("GET");
			// read the response
			InputStream in = new BufferedInputStream(conn.getInputStream());
			String response = IOUtils.toString(in, "UTF-8");
			// Parsing the json object from response :
			JSONObject myResponse = new JSONObject(response);
			JSONObject config = myResponse.getJSONObject("config");
			_id = config.getString("_id");
			creator = config.getString("creator");
			this.configStatus = config.getBoolean("configStatus");
			this.monthlyRevenue = config.getInt("monthlyRevenue");
			this.totalSaved = config.getInt("totalSaved");
			this.wantedSaveValue = config.getInt("wantedSaveValue");
			// Closing connection
			in.close();
			conn.disconnect();
		} catch (Exception e) {
			// In case of unsuccessful response with status of other then 200/201....
			result = false;
		}
		return result;
	}

	// Updating the DB with the current ConfigService Member variables
	public boolean updateConfig(String token) {
		String query_url = restURL;
		boolean result = true;
		try {
			JSONObject JSON = new JSONObject().put("configStatus", this.configStatus)
					.put("monthlyRevenue", this.monthlyRevenue).put("totalSaved", this.totalSaved)
					.put("creator", this.creator).put("_id", this._id).put("wantedSaveValue", this.wantedSaveValue);
			String json = JSON.toString();
			URL url = new URL(query_url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			// Setting header: for authorization
			conn.setRequestProperty("Authorization", "Bearer " + token);
			conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("PUT");
			OutputStream os = conn.getOutputStream();
			os.write(json.getBytes("UTF-8"));
			os.close();
			// read the response
			InputStream in = new BufferedInputStream(conn.getInputStream());
			String response = IOUtils.toString(in, "UTF-8");
			// Closing connection
			conn.disconnect();
		} catch (Exception e) {
			// In case of unsuccessful response with status of other then 200/201....
			result = false;
		}
		return result;
	}

	public void setConfigStatus(boolean configStatus) {
		this.configStatus = configStatus;
	}

	public void setMonthlyRevenue(int monthlyRevenue) {
		this.monthlyRevenue = monthlyRevenue;
	}

	public void setTotalSaved(int totalSaved) {
		this.totalSaved = totalSaved;
	}

	public void setWantedSaveValue(int wantedSaveValue) {
		this.wantedSaveValue = wantedSaveValue;
	}

	public int getTotalSaved() {
		return totalSaved;
	}

	public int getWantedSaveValue() {
		return wantedSaveValue;
	}
	public int getMonthlyRevenue() {
		return monthlyRevenue;
	}
	public boolean getConfigStatus() {
		return configStatus;
	}
}
