package homework.chegg.com.chegghomework.data.entities.dataSourceB;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dr9874 on 30/11/2017.
 */

public class DataSourceB {

    @SerializedName("metadata")
    @Expose
    private Metadata metadata;

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

}
