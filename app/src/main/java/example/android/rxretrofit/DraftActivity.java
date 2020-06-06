package example.android.rxretrofit;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import example.android.rxretrofit.databinding.ActivityDraftBinding;

public class DraftActivity extends AppCompatActivity {

    ActivityDraftBinding activityDraftBinding;
    DraftRecyclerViewAdapter adapter;
    Context context;
    List<Us> usList = new ArrayList<>();
    Us us;
    boolean check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDraftBinding = DataBindingUtil.setContentView(this, R.layout.activity_draft);
        activityDraftBinding.draftRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        activityDraftBinding.draftRecyclerView.setHasFixedSize(true);

        adapter = new DraftRecyclerViewAdapter(getApplicationContext(), getAllU());
        activityDraftBinding.setUs(us);
        activityDraftBinding.draftRecyclerView.setAdapter(adapter);

        activityDraftBinding.changeLayoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                adapter.setLayoutSate(!check);
                check = !check;
            }
        });

    }

    public List<Us> getAllU(){
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

}
