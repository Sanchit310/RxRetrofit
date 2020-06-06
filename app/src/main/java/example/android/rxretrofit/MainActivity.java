package example.android.rxretrofit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import example.android.rxretrofit.databinding.ActivityMainBinding;
import example.android.rxretrofit.databinding.ProjectDetailsDialogBinding;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements SearchClick {

    ActivityMainBinding activityMainBinding;
    UserAdapter userAdapter;
    List<Items> itemsList = new ArrayList<>();
    MainViewModel viewModel ;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        activityMainBinding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        activityMainBinding.recyclerview.setHasFixedSize(true);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        activityMainBinding.setClick((SearchClick)this);
        activityMainBinding.setVmclick(viewModel);
        userAdapter = new UserAdapter(getApplicationContext(), itemsList);
        activityMainBinding.recyclerview.setAdapter(userAdapter);

        getDate();
    }


    public String getDate(){
        String date = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault()).format(new Date());
        Log.d("___", "getDate: " + date);
        return date;
    }


    public List<Us> getAllUsers(){
        List<Us> us = new ArrayList<>();
        us.add(new Us("Sanchit"));
        us.add(new Us("ab"));
        us.add(new Us("sf"));
        us.add(new Us("dhshfd"));
        us.add(new Us("shsgsg"));
        us.add(new Us("tybfxfb"));
        us.add(new Us("sljdgnk"));
        us.add(new Us("sdngksn"));
        us.add(new Us("lrjgnks"));
        us.add(new Us("lsjgosrk"));
        us.add(new Us("iuhgsjbg"));
        us.add(new Us("mf fhkdf"));
        us.add(new Us("kjdghoshng"));
        us.add(new Us("lighnkdlmg"));
        us.add(new Us("oopnsdfln"));

        return  us;
    }

    @Override
    public void click() {


        viewModel.init("vishnu@gmail.com",
                "adminers", "android");
//        viewModel.getUserObservable()
//                .subscribe(response -> {
//                    activityMainBinding.text2.setText(response.getData().getEmail());
//                }, throwable -> {
//                    activityMainBinding.text2.setText(throwable.toString());
//
//                });

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        ProjectDetailsDialogBinding projectDetailsDialogBinding = DataBindingUtil.inflate(LayoutInflater.from(this),
                R.layout.project_details_dialog,null,false
        );

        alert.setView(projectDetailsDialogBinding.getRoot());

        final AlertDialog alertDialog = alert.create();
        alertDialog.show();

        Log.d("___", "click: clicked main");

//                 ServiceGenerator.getRequestApi()
//                .getUser(activityMainBinding.editText.getText().toString())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<User>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(User user) {
//                        itemsList = user.getItems();
//                        userAdapter.updateData(itemsList);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e("___", "onError: ", e );
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Toast.makeText(getApplicationContext(), "Completed", Toast.LENGTH_SHORT).show();
//                    }
//                });

    }





}
