package com.ludandroid.lud;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vipul.hp_hp.timelineview.TimelineView;

/**
 * Created by richi on 12/22/2016.
 */
public class TimelineFragmentContentInnerAdapter extends RecyclerView.Adapter<TimelineFragmentContentInnerAdapter.ViewHolder>{

    private String[] mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TimelineView mTimelineView;
        public TextView mContent;
        public Context mContext;

        public ViewHolder(View v, int viewType) {
            super(v);
            mTimelineView = (TimelineView) v.findViewById(R.id.time_marker);
            mTimelineView.initLine(viewType);
            mContent = (TextView) v.findViewById(R.id.timeline_card_content);
            mContext = v.getContext();
        }

    }

        public TimelineFragmentContentInnerAdapter(String[] myDataset) {
            mDataset = myDataset;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public TimelineFragmentContentInnerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                                 int viewType) {
            /* NOTE:
             * Use View.inflate instead of LayoutInflater, so that the
             * height of the timeline can be derived properly, otherwise it will
             * just fill the whole screen.
             */

            View v = View.inflate(parent.getContext(), R.layout.card_timeline_content_inner, null);

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

            //TODO : Insert data for Inner content here
            holder.mTimelineView.setMarker(ContextCompat.getDrawable(holder.mContext, R.drawable.r_20));
            holder.mContent.setText("Test");
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