package com.meajireview.meajireviewforadmin;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * Created by songmho on 2016-10-24.
 */
public class MenuAdapter extends RecyclerView.Adapter {
    Context context;
    List<ShopItem> shopItems;

    static final int HEADER = 0;
    static final int BODY = 1;

    public MenuAdapter(Context context, List<ShopItem> shopItems) {
        this.context = context;
        this.shopItems = shopItems;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == HEADER)
            return HEADER;
        else
            return BODY;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shop,parent,false);
            return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((ViewHolder)holder).txtFood.setText(shopItems.get(position).getFood());
            ((ViewHolder)holder).txtPrice.setText(shopItems.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return shopItems.size();
    }

    /**
     * 가게 상세 액티비티에서 메뉴와 가격 item관련 class <br>
     */
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtFood, txtPrice;
        public ViewHolder(View itemView) {
            super(itemView);
            txtFood = (TextView)itemView.findViewById(R.id.txtFood);
            txtPrice = (TextView)itemView.findViewById(R.id.txtPrice);
        }
    }

}
