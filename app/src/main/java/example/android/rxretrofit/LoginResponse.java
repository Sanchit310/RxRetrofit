package example.android.rxretrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class LoginResponse {

    @Expose
    @SerializedName("data")
    private Data data;

    @Expose
    @SerializedName("email")
    private ArrayList<Email> email;

    public Data getData() {
        return data;
    }

    public static class Data{

        @Expose
        @SerializedName("api_token")
        private String apiToken;

        @Expose
        @SerializedName("name")
        private String name;

        @Expose
        @SerializedName("email")
        private String email;

        public Data(String apiToken, String name, String email) {
            this.apiToken = apiToken;
            this.name = name;
            this.email = email;
        }

        public String getApiToken() {
            return apiToken;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }
    }

    public static class Email{

    }

}
