package example.android.rxretrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginRequest {

    private LoginRequest(){

    }

    public static class FacebookLoginRequest{

        @Expose
        @SerializedName("token")
        private String token;

        @Expose
        @SerializedName("device_name")
        private String deviceName;

        public FacebookLoginRequest(String token, String deviceName) {
            this.token = token;
            this.deviceName = deviceName;
        }

        public String getToken() {
            return token;
        }

        public String getDeviceName() {
            return deviceName;
        }
    }

    public static class GoogleLoginRequest{

        @Expose
        @SerializedName("token")
        private String token;

        @Expose
        @SerializedName("device_name")
        private String deviceName;

        public String getToken() {
            return token;
        }

        public String getDeviceName() {
            return deviceName;
        }

    }

    public static class ServerLoginRequest{

        @Expose
        @SerializedName("email")
        private String email;

        @Expose
        @SerializedName("password")
        private String password;

        @Expose
        @SerializedName("device_name")
        private String deviceName;

        public ServerLoginRequest(String email, String password, String deviceName) {
            this.email = email;
            this.password = password;
            this.deviceName = deviceName;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public String getDeviceName() {
            return deviceName;
        }
    }



}
