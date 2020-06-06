package example.android.rxretrofit;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import androidx.databinding.Bindable;

public class User {

    private String u;

    public String getU() {
        return u;
    }


    @SerializedName("total_count")
    private String userName;

    @SerializedName("items")
    private ArrayList<Items> items;

    public User(String userName) {
        this.userName = userName;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;

    }

    public ArrayList<Items> getItems() {
        return items;
    }

    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }
}
