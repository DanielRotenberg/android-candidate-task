package homework.chegg.com.chegghomework.data.entities.dataSourceA;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import homework.chegg.com.chegghomework.data.entities.DataConverter;
import homework.chegg.com.chegghomework.data.entities.Item;
import java.util.Collections;
import java.util.List;

/**
 * Created by dr9874 on 30/11/2017.
 */

public class DataSourceA implements DataConverter<DataSourceA,Item> {
    @SerializedName("stories")
    @Expose
    private List<Story> stories = Collections.emptyList();

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    @Override
    public List<Item> convert(DataSourceA source) {
        List<Item> itemList = Collections.emptyList();
        for (Story story: stories){
            Item item = new Item();
            item.setHeader(story.getTitle());
            item.setDescription(story.getSubtitle());
            item.setPicture(story.getImageUrl());
            itemList.add(item);
        }
        return itemList;
    }

    @Override
    public void fetchData() {

    }
}
