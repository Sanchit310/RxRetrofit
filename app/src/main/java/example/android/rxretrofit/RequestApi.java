package example.android.rxretrofit;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RequestApi {

    @FormUrlEncoded
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    @POST("/api/login")
    Observable<LoginResponse> getUser(
            @Field("email") String email,
            @Field("password") String password,
            @Field("device_name") String dv
    );

}
