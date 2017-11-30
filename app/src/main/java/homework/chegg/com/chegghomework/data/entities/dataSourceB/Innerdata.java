package homework.chegg.com.chegghomework.data.entities.dataSourceB;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dr9874 on 30/11/2017.
 */

public class Innerdata {

    @SerializedName("aticleId")
    @Expose
    private Integer aticleId;
    @SerializedName("articlewrapper")
    @Expose
    private Articlewrapper articlewrapper;
    @SerializedName("picture")
    @Expose
    private String picture;

    public Integer getAticleId() {
        return aticleId;
    }

    public void setAticleId(Integer aticleId) {
        this.aticleId = aticleId;
    }

    public Articlewrapper getArticlewrapper() {
        return articlewrapper;
    }

    public void setArticlewrapper(Articlewrapper articlewrapper) {
        this.articlewrapper = articlewrapper;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
