package com.example.pharmacy.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pharmacy.R;
import com.example.pharmacy.models.Store;

import java.util.ArrayList;
import java.util.List;

public class SeeAllStoresAdapters extends RecyclerView.Adapter<SeeAllStoresAdapters.ViewHolder> {

    private List<Store> mCategoriesList = new ArrayList<>();
    private SeeAllStoresAdapters.OnClickListner mListner;

    @NonNull
    @Override
    public SeeAllStoresAdapters.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stores2_list_item, parent, false);
        return new SeeAllStoresAdapters.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SeeAllStoresAdapters.ViewHolder holder, int position) {

        Store currentItem = mCategoriesList.get(position);

        holder.offer_name.setText(currentItem.getStore_name());


    }

    public void setItems(List<Store> categories) {
        mCategoriesList = categories;
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return mCategoriesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView offer_name;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            offer_name=itemView.findViewById(R.id.store_name1);


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
        void onClick(Store category);
    }

    public void OnItemClickListner(SeeAllStoresAdapters.OnClickListner listner) {

        mListner = listner;

    }

    public Store getCategoryAt(int pos) {
        return mCategoriesList.get(pos);
    }
}
