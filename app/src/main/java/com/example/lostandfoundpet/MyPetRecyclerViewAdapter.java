package com.example.lostandfoundpet;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.IconCompat;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Context;
import android.content.Intent;

//import static android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lostandfoundpet.PetFragment.OnListFragmentInteractionListener;
import com.example.lostandfoundpet.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyPetRecyclerViewAdapter extends RecyclerView.Adapter<MyPetRecyclerViewAdapter.ViewHolder> {

    private final List<Pet> petList;
    private final OnListFragmentInteractionListener mListener;
    private TextView mCityView;

    public MyPetRecyclerViewAdapter(List<Pet> items, OnListFragmentInteractionListener listener) {
        petList = items;
        mListener = listener;
    }



//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.fragment_pet, parent, false);
//        final ViewHolder.OnListFragmentInteractionListener
//        return new ViewHolder(view, mCityView);
//    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
//        Bitmap bitmap = BitmapFactory.decodeFile("/Users/soyewale/Desktop/codefellows/401/LostAndFoundPet/dogPictures/biggie.jpg");

        holder.mItem = petList.get(position);
        holder.mNameView.setText(petList.get(position).getName());
        holder.mDetailsView.setText(petList.get(position).getDetails());
        holder.mCityView.setText(petList.get(position).getCity());

//        int imageResource = Context.getResources().getIdentifier(petList.get(position).getImg());
//        Drawable res = getResources().getDrawable(imageResource);


        holder.mImgView.setImageDrawable(petList.get(position).getImg());


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent sentToDetailsPage = new Intent(context, DetailPage.class);
                // sentToDetailsPage.putExtra("mTitleView", mTitleView);
                sentToDetailsPage.putExtra("mNameView", holder.mNameView.getText());
                sentToDetailsPage.putExtra("mDetailsView", holder.mDetailsView.getText());
                sentToDetailsPage.putExtra("mCityView", holder.mCityView.getText());

                context.startActivity(sentToDetailsPage);

                Log.i("tag", "itworked");
            }
        });
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        public Pet pet;
        public final View mView;
        public final TextView mNameView;
        public final TextView mDetailsView;
        public final TextView mCityView;
        public ImageView mImgView;

        //        public final ImageView mimgView;
        public Pet mItem;
//        public TextView mCityView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mNameView = (TextView) view.findViewById(R.id.name);
            mDetailsView = (TextView) view.findViewById(R.id.details);
            mImgView = (ImageView) view.findViewById(R.id.imageView);
            mCityView = (TextView) view.findViewById(R.id.city);

//            this.mCityView = mCityView;
        }

    }


        @NonNull
        @Override
        public MyPetRecyclerViewAdapter.ViewHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.fragment_pet, parent, false);
            //this gives me access to the view
            final ViewHolder viewHolder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onClickOnPetCallback(viewHolder.pet);








                }
            });
            return viewHolder;
        }

        @Override
        public int getItemCount() {
            return petList.size();
        }
        public static interface OnListFragmentInteractionListener{
            public void onClickOnPetCallback(Pet pet);
        }


//        @Override
//        public String toString() {
//            return super.toString() + " '" + mDetailsView.getText() + "'";
//        }

//    @Override
//    public int getItemCount() {
//        return petList.size();
//    }
}
