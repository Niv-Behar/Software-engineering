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

public class CategoryService {
    private static final String restURL = "http://schoolproject-env.eba-qp6e4y82.us-east-2.elasticbeanstalk.com/" + "api/category";
    List<Category> categories;
    

    //Singleton
    private CategoryService() {
        this.categories = new ArrayList<>();
    }

    private final static CategoryService INSTANCE = new CategoryService();

    public static CategoryService getInstance() {
        return INSTANCE;
    }
    //Singleton
    
    public List<Category> getCategories(){
    	return this.categories;
    }
    
    public String toString() {
    	if(this.categories.size()==0) {
    		return " ";
    	}
    	 
    	StringBuilder builder=new StringBuilder();
    	this.categories.forEach(category->{
    		builder.append(category.toString());
    		builder.append('\n');
    		
    	});
    	return builder.toString();
    }
    
    public int spentThisMonth() {
    	int spentAmount=0;
    	for(Category cat:this.categories) {
    	  spentAmount+=cat.amountUsed;
    	}
    	return spentAmount;
    }
    
    public Category findCategoryById(String id) {
    	for(Category cat:this.categories) {
    		if(cat.getId().equalsIgnoreCase(id)) {
    			return cat;
    		}
    	}
    	return null;
    }

    
    public Category findCategory(String title) {
    	Category result=null;
    	for(Category cat:this.categories) {
    		if(cat.title.equalsIgnoreCase(title)) {
    			result=cat;
    			
    		}
    	}
    	return result;
    }

    public boolean addCategory(String title, int amount, int amountUsed, String creator, String token) {
    	//Checking if Category already exists to avoid duplicates:
    	boolean alreadyExists=false;
    	for(Category cat:this.categories) {
    		if(cat.title.equalsIgnoreCase(title)) {
    			alreadyExists=true;
    		}
    	}
    	if(alreadyExists==true) {
    		return false;
    	}
    	    	
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
            
            result = false;
        }
        return result;

    }


    public boolean initCategories(String token) {
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
           // this.categories.clear();
            this.categories=new ArrayList<>();
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
            result = false;
        }
        return result;
    }


    public boolean updateCategory(Category category,String token) {
    	//Checking if Category already exists to avoid duplicates:
    	boolean alreadyExists=false;
    	for(Category cat:this.categories) {
    		if(cat.title.equalsIgnoreCase(category.title)) {
    			alreadyExists=true;
    		}
    	}
    	if(!alreadyExists==true) {
    		return false;
    	}
    	
        String query_url = restURL;
        boolean result = true;
        try {
            JSONObject JSON=new JSONObject().put("title",category.title).put("amount",category.amount)
                    .put("amountUsed",category.amountUsed).put("creator",category.getCreator())
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
            InputStream in = new BufferedInputStream(conn.getInputStream());
            String response = IOUtils.toString(in, "UTF-8");
            //Closing connection
            conn.disconnect();
        } catch (Exception e) {
            //In case of unsuccessful response with status of other then 200/201....
            result = false;
        }
        return result;
    }

    public boolean deleteCategory(String _id,String token) {
    	 String query_url = restURL+"/"+_id;
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
             conn.setRequestMethod("DELETE");
             // read the response
             InputStream in = new BufferedInputStream(conn.getInputStream());
             String response = IOUtils.toString(in, "UTF-8");
             this.categories.removeIf(cat->{
            	 return cat._id.equals(_id);
               
             });

             //Closing connection
             conn.disconnect();
         } catch (Exception e) {
             //In case of unsuccessful response with status of other then 200/201....
             result = false;
         }
         return result;
    }
    public boolean deleteAllByUser(String token) {
    	String query_url=restURL;
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
              conn.setRequestMethod("DELETE");
              // read the response
              InputStream in = new BufferedInputStream(conn.getInputStream());
              String response = IOUtils.toString(in, "UTF-8");
              this.categories.clear();//Reset!

              //Closing connection
              conn.disconnect();
          } catch (Exception e) {
              //In case of unsuccessful response with status of other then 200/201....
              result = false;
          }
          return result;
    }
}
