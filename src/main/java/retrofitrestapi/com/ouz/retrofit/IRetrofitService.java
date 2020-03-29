package retrofitrestapi.com.ouz.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofitrestapi.com.ouz.domain.Il;
import retrofitrestapi.com.ouz.domain.Ilce;
import retrofitrestapi.com.ouz.domain.Mahalle;

public interface IRetrofitService {
	 
    @GET("/Main/getProvinces")
    public Call<List<Il>> getIller(@Query("ticket") int ticket);
 
    @GET("/Main/getTowns")
    public Call<List<Ilce>> getIlce(@Query("ticket") int ticket,@Query("parentId") int parentId);
    
    @GET("/Main/getQuarters")
    public Call<List<Mahalle>> getMahalle(@Query("ticket") int ticket,@Query("parentId") int parentId);
}
