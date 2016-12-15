package com.ludandroid.lud;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vipul.hp_hp.timelineview.TimelineView;

import java.util.ArrayList;
import java.util.List;

public class TimelineFragment extends Fragment {


    public TimelineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_timeline, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        TimelineRecyclerViewAdapter viewAdapter = new TimelineRecyclerViewAdapter();
        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.recycler_view);
        recyclerView.setAdapter(new TimelineRecyclerViewAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    private class TimeLineViewHolder extends RecyclerView.ViewHolder {
        public TimelineView mTimelineView;
        public TextView mTextView;

        public TimeLineViewHolder(View itemView, int viewType) {
            super(itemView);
            mTimelineView = (TimelineView) itemView.findViewById(R.id.time_marker);
            mTimelineView.initLine(viewType);
            mTextView = (TextView) itemView.findViewById(R.id.textView);
        }
    }

    private class TimelineRecyclerViewAdapter extends RecyclerView.Adapter<TimeLineViewHolder> {

        ArrayList<String> stringArrayList = new ArrayList<>();

        public TimelineRecyclerViewAdapter()
        {
            stringArrayList.add("ASDF");
            stringArrayList.add("GHJKL");
            stringArrayList.add("HELLO SAYANG");
        }

        @Override
        public TimeLineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = View.inflate(parent.getContext(), R.layout.card_test, null);
            return new TimeLineViewHolder(view, viewType);
        }

        @Override
        public void onBindViewHolder(TimeLineViewHolder holder, int position) {
            holder.mTextView.setText(stringArrayList.get(position));
        }

        @Override
        public int getItemViewType(int position) {
            return TimelineView.getTimeLineViewType(position, getItemCount());
        }

        @Override
        public int getItemCount() {
            return stringArrayList.size();
        }
    }

}
