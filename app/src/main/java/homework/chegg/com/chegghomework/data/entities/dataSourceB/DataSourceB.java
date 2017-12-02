package homework.chegg.com.chegghomework.data.entities.dataSourceB;

import android.util.Log;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import homework.chegg.com.chegghomework.data.entities.DataConverter;
import homework.chegg.com.chegghomework.data.entities.Item;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dr9874 on 30/11/2017.
 */

public class DataSourceB implements DataConverter{

    @SerializedName("metadata")
    @Expose
    private Metadata metadata;

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public List<Item> convert() {
        List<Item> itemList = new ArrayList<>();
        List<Innerdata> sourceList = getMetadata().getInnerData();
        for(Innerdata innerdata: sourceList){
            Item item = new Item();
            item.setHeader(innerdata.getArticlewrapper().getHeader());
            item.setDescription(innerdata.getArticlewrapper().getDescription());
            item.setPicture(innerdata.getPicture());
            itemList.add(item);
        }
        return itemList;
    }

    @Override
    public void fetchData() {

    }
}
