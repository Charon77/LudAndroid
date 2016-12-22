package com.ludandroid.lud;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vipul.hp_hp.timelineview.TimelineView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by richi on 12/21/2016.
 */
public class TimelineFragmentAdapter extends RecyclerView.Adapter<TimelineFragmentAdapter.ViewHolder> {
    private ITimelineData mDataset;

    // Provides Interface for filling in data to the timeline
    // TODO: make method for getting detail for content and contentInner
    public interface ITimelineData {
        String getProfileName(int i);
        String getTimeStamp(int i);

        int size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView mProfPic;
        public TextView mProfName;
        public TextView mTimeStamp;
        public RecyclerView mRecyclerView;
        public Context context;

        public ViewHolder(View v,Context c) {
            super(v);
            mProfName = (TextView) v.findViewById(R.id.timeline_card_profName);
            mProfPic = (ImageView) v.findViewById(R.id.timeline_card_profPic);
            mTimeStamp = (TextView) v.findViewById(R.id.timeline_card_timestamp);
            mRecyclerView = (RecyclerView) v.findViewById(R.id.timeline_card_recyclerView);
            context = c;
        }
    }


    // Provide a suitable constructor (depends on the kind of dataset)
    public TimelineFragmentAdapter(ITimelineData myDataset) {
        mDataset = myDataset;
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
}
