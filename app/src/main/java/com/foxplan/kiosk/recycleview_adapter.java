package com.foxplan.kiosk;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class recycleview_adapter extends RecyclerView.Adapter<recycleview_adapter.ViewHolder> {

    List<String> mNetworkList;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        public final TextView mTextView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            //mImageView = (ImageView) view.findViewById(R.id.avatar);
            mTextView = (TextView) view.findViewById(R.id.id_text_view);
        }
    }

    public recycleview_adapter(List<String> items) {

        mNetworkList = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.mTextView.setText(mNetworkList.get(position));
    }

    @Override
    public int getItemCount() {
        return mNetworkList.size();
    }
}