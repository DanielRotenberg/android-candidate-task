package homework.chegg.com.chegghomework.Presentation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import homework.chegg.com.chegghomework.R;
import homework.chegg.com.chegghomework.data.entities.Item;

/**
 * Created by dr9874 on 03/12/2017.
 */

public class CheggAdapter extends RecyclerView.Adapter<CheggAdapter.CheggVH> {

    private List<Item> itemList = new ArrayList<>();


    public CheggAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public CheggVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item,parent,false);
        return new CheggVH(itemView);
    }

    @Override
    public void onBindViewHolder(CheggVH holder, int position) {
            Item item = itemList.get(position);
            holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class CheggVH extends RecyclerView.ViewHolder{

        private TextView header;
        private TextView subTitle;
        private ImageView picture;
        private Context context;

        public CheggVH(View itemView) {
            super(itemView);
            context = itemView.getContext();
            initWidgets(itemView);
        }

        private void initWidgets(View root){
            picture = root.findViewById(R.id.imageView_card_item);
            header = root.findViewById(R.id.textView_card_item_title);
            subTitle = root.findViewById(R.id.textView_card_item_subtitle);
        }

        private void setItem(Item item){
            header.setText(item.getHeader());
            subTitle.setText(item.getDescription());
            Glide.with(context).load(item.getPicture()).into(picture);
        }
    }

}
