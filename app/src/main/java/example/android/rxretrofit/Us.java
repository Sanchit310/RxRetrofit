package example.android.rxretrofit;

import com.google.gson.annotations.SerializedName;

public class Us {

    @SerializedName("name")
    private String name;

    public Us(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
