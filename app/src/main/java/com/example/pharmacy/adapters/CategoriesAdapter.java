package com.example.pharmacy.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pharmacy.R;
import com.example.pharmacy.models.Categories;

import java.util.ArrayList;
import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    private List<Categories> mCategoriesList = new ArrayList<>();
    private OnClickListner mListner;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Categories currentItem = mCategoriesList.get(position);

        holder.category_name.setText(currentItem.getCategory_name());


    }

    public void setItems(List<Categories> categories) {
        mCategoriesList = categories;
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return mCategoriesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView category_name;
        ImageView category_photo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            category_name=itemView.findViewById(R.id.category_name);
            category_photo=itemView.findViewById(R.id.category_image);

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
        void onClick(Categories category);
    }

    public void OnItemClickListner(OnClickListner listner) {

        mListner = listner;

    }

    public Categories getCategoryAt(int pos) {
        return mCategoriesList.get(pos);
    }
}
