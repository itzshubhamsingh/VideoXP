package com.example.videoapi.Adapters;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videoapi.Models.ExoModel;
import com.example.videoapi.R;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;

import java.util.ArrayList;
import java.util.SimpleTimeZone;

public class ExoAdapter extends RecyclerView.Adapter<ExoAdapter.viewholder>{
    Context context;
    ArrayList<ExoModel>list;
    ProgressDialog progressDialog;



    public ExoAdapter(Context context, ArrayList<ExoModel> list) {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_recycler, parent, false);
        return new viewholder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading");
        ExoPlayer simpleExoPlayer = (ExoPlayer) new ExoPlayer.Builder(context).build();
        holder.playerView.setPlayer(simpleExoPlayer);
        MediaItem mediaItem = MediaItem.fromUri(list.get(position).getVideo_url());
        simpleExoPlayer.addMediaItem(mediaItem);
        holder.playerView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(View view) {
//                holder.playerView.setPlayer();
                simpleExoPlayer.prepare();
                simpleExoPlayer.play();

            }

            @Override
            public void onViewDetachedFromWindow(View view) {
                holder.playerView.getPlayer().stop();

            }
        });


        /*
        holder.player_name.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
    @Override
    public void onViewAttachedToWindow(View v) {

    }

    @Override
    public void onViewDetachedFromWindow(View v) {
        holder.player_name.getPlayer().stop();

    }
});
         */


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class viewholder extends RecyclerView.ViewHolder {
        PlayerView playerView;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            playerView = itemView.findViewById(R.id.exo_main);
        }
    }
}
