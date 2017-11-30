package homework.chegg.com.chegghomework.data.entities.dataSourceB;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dr9874 on 30/11/2017.
 */

public class Articlewrapper {

    @SerializedName("header")
    @Expose
    private String header;
    @SerializedName("description")
    @Expose
    private String description;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
