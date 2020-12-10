package com.geekbrains.a1l6_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<DataClass> data = new ArrayList<>();
    private Context context;

    RecyclerViewAdapter(ArrayList<DataClass> data) {
        if(data != null) {
            this.data = data;
        }
    }

    void addItem(DataClass dataClass) {
        data.add(1, dataClass);
        notifyItemInserted(1);
        //notifyDataSetChanged(); // - перерисует сразу весь список
    }

    void removeItem() {
        data.remove(0);
        notifyItemRemoved(0);
    }

    void moveElement() {
        DataClass secondElement = data.get(1);
        data.remove(secondElement);
        data.add(2, secondElement);
        notifyItemMoved(1, 2);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.imageView.setImageDrawable(data.get(position).drawable);
        holder.textView.setText(data.get(position).text);
        holder.checkBox.setChecked(data.get(position).isChecked);

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                data.get(position).isChecked = isChecked;
                Toast.makeText(context, "Is checked: " + isChecked, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        CheckBox checkBox;

        ViewHolder(View view) {
            super(view);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            checkBox = itemView.findViewById(R.id.checkbox);
        }
    }
}
