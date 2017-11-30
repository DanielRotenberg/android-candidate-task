package homework.chegg.com.chegghomework.data.entities.dataSourceB;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by dr9874 on 30/11/2017.
 */

public class Metadata {

    @SerializedName("this")
    @Expose
    private String _this;
    @SerializedName("innerData")
    @Expose
    private List<Innerdata> innerData = null;

    public String getThis() {
        return _this;
    }

    public void setThis(String _this) {
        this._this = _this;
    }

    public List<Innerdata> getInnerData() {
        return innerData;
    }

    public void setInnerData(List<Innerdata> innerData) {
        this.innerData = innerData;
    }
}
