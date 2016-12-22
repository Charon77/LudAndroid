package com.ludandroid.lud;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vipul.hp_hp.timelineview.TimelineView;

class TimelineFragmentAdapter extends RecyclerView.Adapter<TimelineFragmentAdapter.ViewHolder> implements IDatasetChangeListener {
    private INotifierTimelineDataset mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        ImageView mProfPic;
        TextView mProfName;
        TextView mTimeStamp;
        RecyclerView mRecyclerView;
        Context context;

        ViewHolder(View v,Context c) {
            super(v);
            mProfName = (TextView) v.findViewById(R.id.timeline_card_profName);
            mProfPic = (ImageView) v.findViewById(R.id.timeline_card_profPic);
            mTimeStamp = (TextView) v.findViewById(R.id.timeline_card_timestamp);
            mRecyclerView = (RecyclerView) v.findViewById(R.id.timeline_card_recyclerView);
            context = c;
        }
    }


    // Provide a suitable constructor (depends on the kind of dataset)
    TimelineFragmentAdapter() {
        mDataset = new TestNotifierTimelineAsyncTask();
        mDataset.setDatasetChangeListener(this);
        mDataset.loadData();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public TimelineFragmentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_timeline, parent, false);

        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v,parent.getContext());

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        //holder.mTextView.setText(mDataset[position]);

        holder.mProfName.setText(mDataset.getProfileName(position));
        holder.mTimeStamp.setText(mDataset.getTimeStamp(position));


        //TODO : Set Adapter for R.id.card_timeline_recyclerView here
        holder.mRecyclerView.setLayoutManager(new LinearLayoutManager(holder.context));
        holder.mRecyclerView.setAdapter(new TimelineFragmentContentAdapter(new String[]{"1","2","3","4"}));
    }

    @Override
    public int getItemViewType(int position) {
        return TimelineView.getTimeLineViewType(position, getItemCount());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override
    public void refreshAdapter() {
        notifyDataSetChanged();
    }
}
