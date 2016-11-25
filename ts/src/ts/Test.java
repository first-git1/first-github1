package ts;

import java.io.IOException;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;



public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			show("http://localhost:8080/hedait-web/resultFul");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String show(String url) throws IOException {
		OkHttpClient client=new OkHttpClient();
	   Request request = new Request.Builder().url(url).build();
	   Response response = client.newCall(request).execute();    
	   if (response.isSuccessful()) {   
		   return response.body().string();
	    } 
	   else {        
		   throw new IOException("Unexpected code " + response);
		    }
	}

}
