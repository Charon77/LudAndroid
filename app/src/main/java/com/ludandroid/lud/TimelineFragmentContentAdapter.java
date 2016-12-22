package com.ludandroid.lud;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.vipul.hp_hp.timelineview.TimelineView;

/**
 * Created by richi on 12/22/2016.
 */
public class TimelineFragmentContentAdapter extends RecyclerView.Adapter<TimelineFragmentContentAdapter.ViewHolder> {

    private String[] mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TimelineView mTimelineView;
        public RecyclerView mRecyclerView;
        public Context mContext;

        /* NOTE:
         * Use Baseclass View instead of CardView in order to
         * be generic. Change made because I needed to have
         * LinearLayout as the root element, as opposed
         * to CardView.
         */

        public ViewHolder(View v, int viewType) {
            super(v);

            // Init Timeline line
            mTimelineView = (TimelineView) v.findViewById(R.id.time_marker);
            mTimelineView.initLine(viewType);
            mRecyclerView = (RecyclerView) v.findViewById(R.id.timeline_card_recyclerView_inner);
            mContext = v.getContext();
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public TimelineFragmentContentAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public TimelineFragmentContentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                 int viewType) {

        /* NOTE:
         * Use View.inflate instead of LayoutInflater, so that the
         * height of the timeline can be derived properly, otherwise it will
         * just fill the whole screen.
         */
        View v = View.inflate(parent.getContext(), R.layout.card_timeline_content, null);

        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v, viewType);

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        //holder.mTextView.setText(mDataset[position]);

        holder.mTimelineView.setMarker(ContextCompat.getDrawable(holder.mContext,R.drawable.r_59));

        //TODO : Insert data for Outer content here
        holder.mRecyclerView.setLayoutManager(new LinearLayoutManager(holder.mContext));
        holder.mRecyclerView.setAdapter(new TimelineFragmentContentInnerAdapter(mDataset));

    }

    @Override
    public int getItemViewType(int position) {
        return TimelineView.getTimeLineViewType(position, getItemCount());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }

}
