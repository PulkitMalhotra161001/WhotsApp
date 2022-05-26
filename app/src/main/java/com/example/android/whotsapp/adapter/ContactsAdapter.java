package com.example.android.whotsapp.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android.whotsapp.R;
import com.example.android.whotsapp.model.users.User;

import org.w3c.dom.Text;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    private List<User> list;
    private Context context;

    public ContactsAdapter(List<User> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_contact_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user=list.get(position);
        holder.username.setText(user.getUserName());
        holder.desc.setText(user.getBio());
        Glide.with(context).load(user.getImageProfile()).into(holder.imageProfile);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageProfile;
        private TextView username,desc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageProfile=itemView.findViewById(R.id.image_profile);
            username=itemView.findViewById(R.id.tv_username);
            desc=itemView.findViewById(R.id.tv_desc);
        }
    }
}
