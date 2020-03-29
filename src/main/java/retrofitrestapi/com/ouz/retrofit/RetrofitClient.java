package retrofitrestapi.com.ouz.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofitrestapi.com.ouz.util.Util;

public class RetrofitClient {

	private static Retrofit retrofit = null;
	private static OkHttpClient.Builder client = null;

	public static Retrofit getClient() {

		//HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
		//interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
		client = new OkHttpClient.Builder();
		//client.addInterceptor(interceptor);

		if (retrofit != null) {
			retrofit = null;
		}

		if (client != null) {

			// Create a first instance a Gson
			Gson gson = new GsonBuilder()
					.setLenient().create();

			GsonConverterFactory factory = GsonConverterFactory.create(gson);

			retrofit = new Retrofit.Builder().baseUrl(Util.BASE_URL).addConverterFactory(factory)
					.client(client.build()).build();
		}

		return retrofit;
	}
}
