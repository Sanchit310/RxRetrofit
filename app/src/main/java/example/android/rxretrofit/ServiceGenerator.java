package example.android.rxretrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    public static final String BASE_URL = "http://54.225.7.59";


    private static  HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

     private  static    OkHttpClient.Builder httpClient = new OkHttpClient.Builder().addInterceptor(interceptor);


    private static Retrofit.Builder builder =  new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient.build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();


    public static  RequestApi requestApi = retrofit.create(RequestApi.class);

    public static  RequestApi getRequestApi(){
        return requestApi;
    }


}
