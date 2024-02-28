package ru.myitschool.lab23;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import ru.myitschool.lab23.databinding.ListItemBinding;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    private final List<ListObject> objects;

    public ListAdapter(List<ListObject> objects) {
        this.objects = objects;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListItemBinding binding = ListItemBinding.inflate(layoutInflater, parent, false);
        ListViewHolder holder = new ListViewHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        ListObject listObject = objects.get(position);
        holder.binding.type.setText(listObject.getType());
        holder.binding.value.setText((int) listObject.getValue());
    }


    @Override
    public int getItemCount() {
        return objects.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        private final ListItemBinding binding;

        public ListViewHolder(@NonNull ListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
