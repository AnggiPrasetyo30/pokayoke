package com.example.hyundai.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.hyundai.R;
import com.example.hyundai.SQLite.User;

import java.util.List;

public class recycler_user extends RecyclerView.Adapter<recycler_user.MyViewHolder> {

    private List<User> itemUser;
    Context context;
    /*static String nama_user = "nama user";
    static String npk_user = "npk user";*/


    public recycler_user(Context ct, List<User> item){
        this.context = ct;
        this.itemUser = item;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_user,parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position){
        final User pengguna = itemUser.get(position);
        holder.text1.setText(pengguna.getName());
        holder.text2.setText(pengguna.getNpk());
    }

    @Override
    public int getItemCount(){return itemUser.size();}

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView text1, text2;
        CardView card;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            text1 = itemView.findViewById(R.id.nama);
            text2 = itemView.findViewById(R.id.npk);
            card = itemView.findViewById(R.id.card_view);
        }
    }
}
