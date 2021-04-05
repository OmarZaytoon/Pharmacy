package com.example.pharmacy.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pharmacy.R;
import com.example.pharmacy.models.Cart;
import com.example.pharmacy.models.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderPlacedAdapter extends RecyclerView.Adapter<OrderPlacedAdapter.ViewHolder> {

    private List<Product> mCategoriesList = new ArrayList<>();
    private OrderPlacedAdapter.OnClickListner mListner;

    @NonNull
    @Override
    public OrderPlacedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.orderstate_list_item, parent, false);
        return new OrderPlacedAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderPlacedAdapter.ViewHolder holder, int position) {

        Product currentItem = mCategoriesList.get(position);

        holder.product_name.setText(currentItem.getProduct_name());


    }

    public void setItems(List<Product> categories) {
        mCategoriesList = categories;
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return mCategoriesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView product_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            product_name=itemView.findViewById(R.id.product_name1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int index = getAdapterPosition();
                    if (mListner != null && index != RecyclerView.NO_POSITION) {
                        mListner.onClick(mCategoriesList.get(index));


                    }
                }
            });


        }


    }

    //On item click :
    public interface OnClickListner {
        void onClick(Product category);
    }

    public void OnItemClickListner(OrderPlacedAdapter.OnClickListner listner) {

        mListner = listner;

    }

    public Product getCategoryAt(int pos) {
        return mCategoriesList.get(pos);
    }
}