package com.example.hyundai.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hyundai.R;
import com.example.hyundai.SQLite.DatabaseHelper;
import com.example.hyundai.SQLite.Product;
import com.example.hyundai.SQLite.User;
import com.example.hyundai.activity.MainActivity;
import com.example.hyundai.activity.list_user;
import com.example.hyundai.update_user;

import java.util.List;

public class recycler_user extends RecyclerView.Adapter<recycler_user.MyViewHolder> {

    private List<User> itemUser;
    Context context;
    DatabaseHelper mDatabaseHelper;
    /*static String nama_user = "nama user";
    static String npk_user = "npk user";*/


    public recycler_user(Context ct, List<User> item) {
        this.context = ct;
        this.itemUser = item;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        mDatabaseHelper = new DatabaseHelper(context);
        View view = inflater.inflate(R.layout.item_user, parent, false);
        return new MyViewHolder(view).linkAdapter(this);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final User user = itemUser.get(position);
        holder.text1.setText(user.getName());
        holder.text2.setText(user.getNpk());



    }

    @Override
    public int getItemCount() {
        return itemUser.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text1, text2;
        ImageButton edit, delete;
        private recycler_user adapter;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.nama);
            text2 = itemView.findViewById(R.id.npk);
            edit = itemView.findViewById(R.id.imageButton2);
            delete = itemView.findViewById(R.id.imageButton);

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mDatabaseHelper.DeleteUser(adapter.itemUser.get(getAdapterPosition()).getNpk());
                    itemUser.remove(adapter.itemUser.get(getAdapterPosition()));
                    adapter.notifyDataSetChanged();

                }
            });

            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, update_user.class);
                    context.startActivity(intent);
                }
            });

        }

        public MyViewHolder linkAdapter(recycler_user adapter) {
            this.adapter = adapter;
            return this;
        }
    }
}

