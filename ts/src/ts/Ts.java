package ts;

import java.io.IOException;
import java.util.Map;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;


public class Ts {
	private static OkHttpClient client;
	public static MediaType JSON = MediaType.parse("application/xml; charset=utf-8");


	public static OkHttpClient getClient() {
		client = new OkHttpClient();
		return client;
	}

	public static void main(String[] args) {
       System.out.println(get("http://localhost:8080/hedait-web/resultFul?aaa=bbb"));
	}



	/**
	 * get请求
	 *
	 * @param url
	 * @return
	 */
	public static String get(String url) {
		 Request.Builder builder = new Request.Builder().url(url);
		 builder.addHeader("name", "123");
		  builder.addHeader("Content-Type", "text/xml; charset=UTF-8");
		  Request request = builder.build();
		//Request request = getGetRequest(url, null, null);
		 
		try {
		      Response res = getClient().newCall(request).execute();
	            System.out.println(res.code());
	            System.out.println(res.body().string());
			return getClient().newCall(request).execute().body().string();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取请求对象
	 *
	 * @param url
	 * @param headers
	 * @return
	 */
	private static Request getGetRequest(String url,
			Map<String, String> queryParas, Map<String, String> headers) {
		Request.Builder builder = new Request.Builder()
				.url(url);
		if (headers != null)
			for (String key : headers.keySet()) {
				builder.addHeader(key, headers.get(key));
			}

		return builder.build();
	}
}
