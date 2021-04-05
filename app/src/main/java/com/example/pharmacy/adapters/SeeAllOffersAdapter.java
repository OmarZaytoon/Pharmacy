package com.example.pharmacy.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pharmacy.R;
import com.example.pharmacy.models.Offers;

import java.util.ArrayList;
import java.util.List;

public class SeeAllOffersAdapter extends RecyclerView.Adapter<SeeAllOffersAdapter.ViewHolder> {

    private List<Offers> mCategoriesList = new ArrayList<>();
    private OnClickListner mListner;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.see_all_offers_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Offers currentItem = mCategoriesList.get(position);

        holder.offer_name.setText(currentItem.getOffer_id());


    }

    public void setItems(List<Offers> categories) {
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
            offer_name=itemView.findViewById(R.id.deals_offer_name1);


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
        void onClick(Offers category);
    }

    public void OnItemClickListner(OnClickListner listner) {

        mListner = listner;

    }

    public Offers getCategoryAt(int pos) {
        return mCategoriesList.get(pos);
    }
}