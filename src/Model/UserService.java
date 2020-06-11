package Model;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

public class UserService implements Authentication{
	  private String token;
	    private String userId;
	    private static final String restURL = "http://schoolproject-env.eba-qp6e4y82.us-east-2.elasticbeanstalk.com/" + "api/user";

	    //Singleton
	    private final static UserService INSTANCE = new UserService();
	    private UserService() {
	    }

	    public static UserService getInstance() {
	        return INSTANCE;
	    }
	    //Singleton


	    public String getToken() {
	        return token;
	    }

	    public String getUserId() {
	        return userId;
	    }

	    /*Returns true if successful login and assigns userId and token from response
	     * Returns false if authentication failed - user doesn't exists, wrong email or password*/
	    @Override
	    public boolean login(String email, String password) {
	        String query_url = restURL + "/login";
	        String json = "{ \"email\":\"" + email + "\",\"password\":\"" + password + "\" }";
	        boolean result = true;
	        try {
	            URL url = new URL(query_url);
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setConnectTimeout(5000);
	            //Setting header: for authorization
	            conn.setRequestProperty("Authorization", "Bearer shoshimoshianat");
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
	            //Parsing the json object from response :
	            JSONObject myResponse = new JSONObject(response);
	            this.token = myResponse.getString("token");
	            this.userId = myResponse.getString("userId");
	            //Closing connection
	            in.close();
	            conn.disconnect();
	        } catch (Exception e) {
	            //In case of unsuccessful response with status of other then 200/201....
	            System.out.println("Authentication failed");
	            result = false;
	        }
	        return result;
	    }

	    /*Returns true if user signup successfully
	     * Returns false if email already exists and signing failed!*/
	    @Override
	    public boolean signup(String email, String password) {
	        String query_url = restURL + "/signup";
	        String json = "{ \"email\":\"" + email + "\",\"password\":\"" + password + "\" }";
	        boolean result = true;
	        try {
	            URL url = new URL(query_url);
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setConnectTimeout(5000);
	            //Setting header: for authorization
	            conn.setRequestProperty("Authorization", "Bearer shoshimoshianat");
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
	            //Parsing the json object from response :
	            JSONObject myResponse = new JSONObject(response);
	            //Closing connection
	            in.close();
	            conn.disconnect();
	        } catch (Exception e) {
	            //In case of unsuccessful response with status of other then 200/201....
	            System.out.println("Email already exists!");
	            result = false;
	        }
	        return result;
	    }

	    @Override
	    public void logout() {
	        this.token = null;
	        this.userId = null;
	    }    

}
