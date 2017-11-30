package homework.chegg.com.chegghomework.data.entities.dataSourceC;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dr9874 on 30/11/2017.
 */

public class DataSourceC {

    @SerializedName("topLine")
    @Expose
    private String topLine;
    @SerializedName("subLine1")
    @Expose
    private String subLine1;
    @SerializedName("subline2")
    @Expose
    private String subline2;
    @SerializedName("image")
    @Expose
    private String image;

    public String getTopLine() {
        return topLine;
    }

    public void setTopLine(String topLine) {
        this.topLine = topLine;
    }

    public String getSubLine1() {
        return subLine1;
    }

    public void setSubLine1(String subLine1) {
        this.subLine1 = subLine1;
    }

    public String getSubline2() {
        return subline2;
    }

    public void setSubline2(String subline2) {
        this.subline2 = subline2;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
