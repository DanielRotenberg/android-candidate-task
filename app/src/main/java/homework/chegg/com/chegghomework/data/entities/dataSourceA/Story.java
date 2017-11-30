package homework.chegg.com.chegghomework.data.entities.dataSourceA;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dr9874 on 30/11/2017.
 */

public class Story {
    @SerializedName("title")
    private String title;
    @SerializedName("subtitle")
    private String subtitle;
    @SerializedName("imageUrl")
    private String imageUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
