package retrofitrestapi.com.ouz.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofitrestapi.com.ouz.domain.Il;
import retrofitrestapi.com.ouz.domain.Ilce;
import retrofitrestapi.com.ouz.domain.Mahalle;
import retrofitrestapi.com.ouz.retrofit.IRetrofitService;
import retrofitrestapi.com.ouz.retrofit.RetrofitClient;

public class NetworkUtil {

	private volatile static NetworkUtil instance;
	
	private final static int TICKET = 1;

	static IRetrofitService apiService;

	static {
		apiService = RetrofitClient.getClient().create(IRetrofitService.class);
	}

	private NetworkUtil() {
	}

	public static NetworkUtil getInstance() {

		if (instance == null) {
			// To make thread safe
			synchronized (NetworkUtil.class) {
				// check again as multiple threads
				// can reach above step
				if (instance == null)
					instance = new NetworkUtil();
			}
		}
		return instance;
	}

	public List<Il> getProvinces() throws Exception {

		List<Il> illerList = new ArrayList();

		// *** **** Retrofit service **** *** //

		Call<List<Il>> illerCall;
		illerCall = apiService.getIller(TICKET);

		if (illerCall != null) {

			/* Synchronous calling */
			try {
				Response<List<Il>> response = illerCall.execute();

				if (response.isSuccessful()) {
					illerList = response.body();
				}

			} catch (IOException ex) {
				throw new Exception("RETROFIT_CALL retrofit synchronous calling was thrown an error -> "
						+ ex.getLocalizedMessage());
			}
		}

		return illerList;

		// *** *** Retrofit Service *** *** //
	}

	

	public List<Ilce> getTownWithParentId(int parentId) throws Exception {

		List<Ilce> ilceList = new ArrayList();

		// *** **** Retrofit service **** *** //

		Call<List<Ilce>> ilceCall;
		ilceCall = apiService.getIlce(TICKET, parentId);

		if (ilceCall != null) {

			/* Synchronous calling */
			try {
				Response<List<Ilce>> response = ilceCall.execute();

				if (response.isSuccessful()) {
					ilceList = response.body();
				}

			} catch (IOException ex) {
				throw new Exception("RETROFIT_CALL retrofit synchronous calling was thrown an error -> "
						+ ex.getLocalizedMessage());
			}
		}

		return ilceList;

		// *** *** Retrofit Service *** *** //
	}

	public List<Mahalle> getQuartersWithParentId(int parentId) throws Exception {

		List<Mahalle> mahalleList = new ArrayList();

		// *** **** Retrofit service **** *** //

		Call<List<Mahalle>> mahalleCall;
		mahalleCall = apiService.getMahalle(TICKET,parentId);

		if (mahalleCall != null) {

			/* Synchronous calling */
			try {
				Response<List<Mahalle>> response = mahalleCall.execute();

				if (response.isSuccessful()) {
					mahalleList = response.body();
				}

			} catch (IOException ex) {
				throw new Exception("RETROFIT_CALL retrofit synchronous calling was thrown an error -> "
						+ ex.getLocalizedMessage());
			}
		}

		return mahalleList;

		// *** *** Retrofit Service *** *** //
	}

}
