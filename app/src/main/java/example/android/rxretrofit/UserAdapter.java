package example.android.rxretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import example.android.rxretrofit.databinding.ItemLayoutBinding;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private Context context;
    private List<Items> itemList = new ArrayList<>();

    public UserAdapter(Context context, List<Items> itemsList) {
        this.context = context;
        this.itemList = itemsList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLayoutBinding itemLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_layout, parent,false);
        return new UserViewHolder(itemLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Items user = itemList.get(position);
        holder.itemLayoutBinding.setUser(user);
    }

    @Override
    public int getItemCount() {
        if(itemList.size() > 10){
            return 10;
        }
        else{
        return itemList.size();
        }
    }

    public void updateData(List<Items> itemsList){
        this.itemList  = itemsList;
        notifyDataSetChanged();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{

        ItemLayoutBinding itemLayoutBinding;

        public UserViewHolder(@NonNull ItemLayoutBinding itemView) {
            super(itemView.getRoot());
            itemLayoutBinding = itemView;
        }
    }

}
