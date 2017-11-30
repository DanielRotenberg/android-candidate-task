package homework.chegg.com.chegghomework.data.entities.dataSourceA;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by dr9874 on 30/11/2017.
 */

public class DataSourceA {
    @SerializedName("stories")
    @Expose
    private List<Story> stories = null;

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }
}
