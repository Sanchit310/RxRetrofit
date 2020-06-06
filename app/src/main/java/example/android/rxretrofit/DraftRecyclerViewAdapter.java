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
import example.android.rxretrofit.databinding.AddDraftGridItemBinding;
import example.android.rxretrofit.databinding.AddDraftLinearItemBinding;
import example.android.rxretrofit.databinding.DraftGridItemBinding;
import example.android.rxretrofit.databinding.DraftLinearItemBinding;

public class DraftRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int mIsGridMode = 0;
    private int mIsLinearMode = 1;
    private boolean mIsGridModeBool = false;
    private Context context;
    private List<Us> usList = new ArrayList<>();

    public DraftRecyclerViewAdapter(Context context, List<Us> usList) {
        this.context = context;
        this.usList = usList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DraftLinearItemBinding draftLinearItemBinding;
        DraftGridItemBinding draftGridItemBinding;
        AddDraftLinearItemBinding addDraftLinearItemBinding;
        AddDraftGridItemBinding addDraftGridItemBinding;

        switch (viewType) {
            case 0:
                draftGridItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.draft_grid_item, parent, false);
                return new DraftGridViewHolder(draftGridItemBinding);

            case 1:
                draftLinearItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.draft_linear_item, parent, false);

                return new DraftLinearViewHolder(draftLinearItemBinding);

            case 3:
                addDraftGridItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.add_draft_grid_item, parent, false);

                return new DraftGridLastViewHolder(addDraftGridItemBinding);

            case 4:
                addDraftLinearItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.add_draft_linear_item, parent, false);

                return new DraftLinearLastViewHolder(addDraftLinearItemBinding);
            }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        if (mIsGridModeBool){
            return 0;
        }
        if (mIsGridModeBool == false){
            return 1;
        }
       if(mIsGridModeBool == true && position== usList.size()){
           return 3;
       }
        if(mIsGridModeBool == false && position== usList.size()){
            return 4;
        }

        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Us uu = usList.get(position);

        if (mIsGridModeBool) {
            DraftGridViewHolder draftGridViewHolder = (DraftGridViewHolder) holder;

            draftGridViewHolder.draftGridItemBinding.setUuuu(uu);
        }if (mIsGridModeBool == false) {
            DraftLinearViewHolder draftLinearViewHolder = (DraftLinearViewHolder) holder;
            draftLinearViewHolder.draftLinearItemBinding.setUuuu(uu);

        }
//        }if (mIsGridModeBool && position == 0) {
//            DraftGridLastViewHolder draftGridLastViewHolder = (DraftGridLastViewHolder) holder;
//
//        }
//        if (mIsGridModeBool == false && position == 0){
//            DraftLinearLastViewHolder draftLinearLastViewHolder = (DraftLinearLastViewHolder) holder;
//
//        }
    }

    @Override
    public int getItemCount() {
        return usList.size() + 1;
    }

    public void setLayoutSate(boolean state){
        mIsGridModeBool  = state;
        notifyDataSetChanged();
    }


    public static class DraftLinearViewHolder extends RecyclerView.ViewHolder{

        DraftLinearItemBinding draftLinearItemBinding;
        DraftGridItemBinding draftGridItemBinding;

        public DraftLinearViewHolder(@NonNull DraftLinearItemBinding itemView) {
            super(itemView.getRoot());
            draftLinearItemBinding = itemView;
        }

    }

    public static class DraftGridViewHolder extends RecyclerView.ViewHolder{

        DraftLinearItemBinding draftLinearItemBinding;
        DraftGridItemBinding draftGridItemBinding;

        public DraftGridViewHolder(@NonNull DraftGridItemBinding itemView) {
            super(itemView.getRoot());
            draftGridItemBinding = itemView;
        }
    }

    public static class DraftLinearLastViewHolder extends RecyclerView.ViewHolder{

       AddDraftLinearItemBinding addDraftLinearItemBinding;

        public DraftLinearLastViewHolder(@NonNull AddDraftLinearItemBinding itemView) {
            super(itemView.getRoot());
            addDraftLinearItemBinding = itemView;
        }

    }

    public static class DraftGridLastViewHolder extends RecyclerView.ViewHolder{

        AddDraftGridItemBinding addDraftGridItemBinding;

        public DraftGridLastViewHolder(@NonNull AddDraftGridItemBinding itemView) {
            super(itemView.getRoot());
            addDraftGridItemBinding = itemView;
        }
    }

}
