import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class User {
	private static String token;
	private static String userID;
	public static String restURL = "http://schoolproject-env.eba-qp6e4y82.us-east-2.elasticbeanstalk.com/"+"api/";
	
	public static class UserData
	{
        public String token;
        public String userId;
        public UserData(String token,String userId)
        {
            this.token=token;
            this.userId=userId;
        }
    }

public static UserData login(String email,String password,String restUrl) {
        String query_url = restUrl+"user/login";
        String json= "{ \"email\":\""+email+"\",\"password\":\""+password+"\" }";
        UserData userData=null;
        try {
            URL url = new URL(query_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            //Setting header: for authoraization
            conn.setRequestProperty("Authorization","Bearer shoshimoshianat");
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            os.close();
            // read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
            String result = IOUtils.toString(in, "UTF-8");
            System.out.println(result);
            System.out.println("result after Reading JSON Response");
            //Parsing the json object from response :
            JSONObject myResponse = new JSONObject(result);
           // String token =  myResponse.getString( "token" );
           // String userId = myResponse.getString( "userId" );
           // userData=new UserData(token,userId);
            userData=new UserData(myResponse.getString("token"),myResponse.getString("userId"));
            //Closing connection
            in.close();
            conn.disconnect();
        } catch (Exception e) {
            //In case of unsuccessful response with status of other then 200/201....
            System.out.println("Authentication failed");
        }
        return userData;
    }
}