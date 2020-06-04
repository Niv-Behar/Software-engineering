import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class CategoryService {
    private static final String restURL = "http://schoolproject-env.eba-qp6e4y82.us-east-2.elasticbeanstalk.com/" + "api/category";
    ArrayList<Category> categories;

    //Singleton
    private CategoryService() {
        this.categories = new ArrayList<>();
    }

    private final static CategoryService INSTANCE = new CategoryService();

    public static CategoryService getInstance() {
        return INSTANCE;
    }
    //Singleton

    public boolean addCategory(String title, int amount, int amountUsed, String creator, String token) {
        String query_url = restURL;
        String json = "{ \"title\":\"" + title + "\",\"amount\":\"" + amount + "\",\"amountUsed\":\"" + amountUsed + "\" }";
        boolean result = true;
        try {
            URL url = new URL(query_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            //Setting header: for authorization
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
            //Parsing the json object from response :
            JSONObject myResponse = new JSONObject(response);
            JSONObject categoryJSON = myResponse.getJSONObject("category");
            String _id = categoryJSON.getString("_id");
            Category category = new Category(title, amount, amountUsed, creator, _id);
            this.categories.add(category);
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


    public boolean getCategories(String token) {
        String query_url = restURL;
        boolean result = true;
        try {
            URL url = new URL(query_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            //Setting header: for authorization
            conn.setRequestProperty("Authorization", "Bearer " + token);
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("GET");
            // read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
            String response = IOUtils.toString(in, "UTF-8");
            //Parsing the json object from response :
            JSONObject myResponse = new JSONObject(response);
            JSONArray catJSONS = myResponse.getJSONArray("categories");
            int size = catJSONS.length();
            this.categories.clear();
            for (int i = 0; i < size; i++) {
                JSONObject obj = catJSONS.getJSONObject(i);
                Category category = new Category(obj.getString("title"), obj.getInt("amount"), obj.getInt("amountUsed"),
                        obj.getString("creator"), obj.getString("_id"));
                this.categories.add(category);
            }
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


    public boolean updateCategory(Category category,String token) {
        String query_url = restURL;
        boolean result = true;
        try {
            JSONObject JSON=new JSONObject().put("title",category.title).put("amount",category.amount)
                    .put("amountUsed",category.amountUsed).put("creator",category.creator)
                    .put("_id",category._id);
            String json=JSON.toString();
            URL url = new URL(query_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            //Setting header: for authorization
            conn.setRequestProperty("Authorization", "Bearer " + token);
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("PUT");
            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            os.close();
            // read the response
            //Here we dont care about the response ! we only care about the
            //Status not failing!
            this.categories.removeIf(cat->{
                return cat._id.equals(category._id);
            });
            this.categories.add(category);
            //Closing connection
            conn.disconnect();
        } catch (Exception e) {
            //In case of unsuccessful response with status of other then 200/201....
            System.out.println("Authentication failed");
            result = false;
        }
        return result;
    }

    public void deleteCategory() {
      //TODO
    }
}