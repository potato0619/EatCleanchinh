package com.example.eatclean2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class videoadapter extends RecyclerView.Adapter<videoadapter.ViewHolder> {

    CacbtActivity context;
    ArrayList<vide> vides=new ArrayList<>();

    public videoadapter(CacbtActivity context, ArrayList<vide> vides) {
        this.context = context;
        this.vides = vides;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_video, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    vide a=vides.get(position);
    holder.tv_video.setText(a.getTen()+"");
    holder.image_sp.setImageResource(a.getId());
    }

    @Override
    public int getItemCount() {
        return vides.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image_sp;
        TextView tv_video;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            image_sp = itemView.findViewById(R.id.image);
            tv_video = itemView.findViewById(R.id.tv_video);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CacbtActivity.videoView.pause();
                    CacbtActivity.videoView.setVideoPath("android.resource://com.example.app_suc_khoe/"+vides.get(getPosition()).idVideo);
                    CacbtActivity.videoView.start();
                }
            });
        }

    }
}
