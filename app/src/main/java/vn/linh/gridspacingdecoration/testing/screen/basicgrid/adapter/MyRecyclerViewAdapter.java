package vn.linh.gridspacingdecoration.testing.screen.basicgrid.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import vn.linh.gridspacingdecoration.R;
import vn.linh.gridspacingdecoration.testing.model.RecyclerItem;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<RecyclerItem> dataSet;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private int TYPE_SECTION = 1;
    private int TYPE_ITEM = 2;

    public MyRecyclerViewAdapter(Context context, ArrayList<RecyclerItem> data) {
        mInflater = LayoutInflater.from(context);
        dataSet = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        if (viewType == TYPE_SECTION) {
            View view = mInflater.inflate(R.layout.section, parent, false);
            viewHolder = new SectionViewHolder(view);
        } else {

            View view = mInflater.inflate(R.layout.item, parent, false);
            viewHolder = new ViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            RecyclerItem item = dataSet.get(position);
            ((ViewHolder) holder).myTextView.setText(item.getTitle());
        } else {

        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView myTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            myTextView = (TextView) itemView.findViewById(R.id.info_text);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    public class SectionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView myTextView;

        public SectionViewHolder(View itemView) {
            super(itemView);
            myTextView = (TextView) itemView.findViewById(R.id.info_text);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}