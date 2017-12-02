package homework.chegg.com.chegghomework.data.entities.dataSourceA;

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

public class DataSourceA implements DataConverter {
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
    public List<Item> convert() {
      //  Log.w("jira", "convert: called" );
        List<Item> itemList = new ArrayList<>();
        // itemList = Collections.EMPTY_LIST;
        for (Story story: stories){
          //  Log.e("jira", "convert: inside loop" );
            Item item = new Item();
            item.setHeader(story.getTitle()!= null?story.getTitle():"empty");
            item.setDescription(story.getSubtitle()!= null?story.getSubtitle():"empty");
            item.setPicture(story.getImageUrl()!= null?story.getImageUrl():"empty");
            itemList.add(item);
           // Log.d("jira", "convert: end of loop");
        }
      //  Log.e("jira", "convert: itemlist size is "+itemList.size() );
        return itemList;
    }

    @Override
    public void fetchData() {

    }

//    @Override
//    public Item convertItem() {
//        return null;
//    }
}
