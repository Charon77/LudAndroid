package com.ludandroid.lud;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vipul.hp_hp.timelineview.TimelineView;

/**
 * Created by richi on 12/21/2016.
 */
public class TimelineFragmentAdapter extends RecyclerView.Adapter<TimelineFragmentAdapter.ViewHolder> {
    private String[] mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public TimelineView mTimelineView;

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

            mTextView = (TextView) v.findViewById(R.id.timeline_card_text);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public TimelineFragmentAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public TimelineFragmentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view

        /* NOTE:
         * Use View.inflate instead of LayoutInflater, so that the
         * height of the timeline can be derived properly, otherwise it will
         * just fill the whole screen.
         */
        View v = View.inflate(parent.getContext(), R.layout.card_timeline, null);

        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v, viewType);

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataset[position]);

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
