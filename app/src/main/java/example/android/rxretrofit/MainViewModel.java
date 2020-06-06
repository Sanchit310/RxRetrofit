package example.android.rxretrofit;

import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import androidx.lifecycle.ViewModel;
import example.android.rxretrofit.databinding.ActivityMainBinding;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class MainViewModel extends ViewModel {



    private Observable<LoginResponse> userObservable;


    public void click() {

        Log.d("___", "click: clicked vm");

    }

    public void init(String email, String password, String dv){

        Log.d("___", "init: " + email + password + dv);

       userObservable = ServiceGenerator.getRequestApi().getUser(email, password, dv)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    public Observable<LoginResponse> getUserObservable(){
        return userObservable;
    }
}
