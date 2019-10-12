package com.example.angela.assap;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by User on 1/1/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{


/*
    private OnItemClickListener mListener;
    public interface OnItemClickListener {
        void  onItemClick (int position);
        void onDeleteClick (int position);
    }
    public void  OnItemClickListener(OnItemClickListener listener){

        mListener = listener;
    }
*/


    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> theList = new ArrayList<>();
    //private ArrayList<String> mImages = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<String> issue ) {
        theList = issue;
        //mImages = images;
        mContext = context;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
      //  ViewHolder holder = new ViewHolder(view, mListener);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

       // Glide.with(mContext)
               // .asBitmap()
               // .load(mImages.get(position))
              //  .into(holder.image);

        holder.imageName.setText(theList.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + theList.get(position));

                Toast.makeText(mContext, theList.get(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, MainReports.class);
               // intent.putExtra("image_url", mImages.get(position));
                intent.putExtra("image_name", theList.get(position));
                mContext.startActivity(intent);



            }
        });
    }

    @Override
    public int getItemCount() {
        return theList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView imageName;
        RelativeLayout parentLayout;
        public ImageView mDeleteImage;

      //  public ViewHolder(View itemView, final OnItemClickListener listener) {
        public ViewHolder(View itemView) {

            super(itemView);
           // image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            mDeleteImage = itemView.findViewById((R.id.image_delete));

          /*  itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position  =getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

            mDeleteImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position  =getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });*/
        }
    }
}












