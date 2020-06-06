package example.android.rxretrofit;

import com.google.gson.annotations.SerializedName;

public class Items {


    @SerializedName("login")
    private String login;

    public String getLogin() {
        return login;
    }
}
