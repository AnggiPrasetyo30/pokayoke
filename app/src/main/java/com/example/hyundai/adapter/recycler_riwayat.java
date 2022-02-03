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
import com.example.hyundai.SQLite.shopping;

import java.util.List;

public class recycler_riwayat extends RecyclerView.Adapter<recycler_riwayat.MyViewHolder> {

    private List<shopping> itemRiwayat;
    Context context;
    /*static String nama_user = "nama user";
    static String npk_user = "npk user";*/


    public recycler_riwayat(Context ct, List<shopping> item){
        this.context = ct;
        this.itemRiwayat = item;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_riwayat,parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position){
        final shopping riwayat = itemRiwayat.get(position);
        holder.text1.setText(riwayat.getKanban_api());
        holder.text2.setText(riwayat.getKanban_cust());
        holder.text3.setText(riwayat.getHasil());
    }

    @Override
    public int getItemCount(){return itemRiwayat.size();}

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView text1, text2, text3;
        CardView card;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            text1 = itemView.findViewById(R.id.kanban_api);
            text2 = itemView.findViewById(R.id.kanban_cust);
            text3 = itemView.findViewById(R.id.hasil_scan);
            card = itemView.findViewById(R.id.card_view);
        }
    }
}
