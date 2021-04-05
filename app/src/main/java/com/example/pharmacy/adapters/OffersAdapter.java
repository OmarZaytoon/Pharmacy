package com.example.pharmacy.adapters;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pharmacy.R;
import com.example.pharmacy.models.Product;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class OffersAdapter extends RecyclerView.Adapter<OffersAdapter.ViewHolder> {

    private List<Product> products=new ArrayList<>();
    private OnClickListner mListner;
    private float discount_value;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.deals_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Product currentItem = products.get(position);
            holder.product_name.setText(products.get(position).getProduct_name());
            Number discount_value1=(discount_value*100);
        DecimalFormat df1 = new DecimalFormat("##.#");
            holder.offer_value.setText("%"+df1.format(discount_value1));
        holder.price_before.setText(""+products.get(position).getProduct_price());
            holder.price_before.setPaintFlags(holder.price_before.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
            Double p_a= products.get(position).getProduct_price()-products.get(position).getProduct_price()*discount_value;
            Number number=p_a+ 1e-6;
            DecimalFormat df = new DecimalFormat("#.#");
            df.setRoundingMode(RoundingMode.CEILING);
            holder.price_after.setText(df.format(number)+"");

    }

    public void setItems(List<Product> products, float discount_value) {
        this.products=products;
        this.discount_value=discount_value;
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView product_name;
        TextView price_before;
        TextView price_after;
        TextView offer_value;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            product_name=itemView.findViewById(R.id.deals_offer_name1);
            offer_value=itemView.findViewById(R.id.deals_price_one);
            price_after=itemView.findViewById(R.id.deals_price_two);
            price_before=itemView.findViewById(R.id.deals_offer_price_before);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int index = getAdapterPosition();
                    if (mListner != null && index != RecyclerView.NO_POSITION) {
                        mListner.onClick(products.get(index));


                    }
                }
            });

        }

    }

    //On item click :
    public interface OnClickListner {
        void onClick(Product product);
    }

    public void OnItemClickListner(OnClickListner listner) {

        mListner = listner;

    }

    public Product getOfferAt(int pos) {
        return products.get(pos);
    }
}

