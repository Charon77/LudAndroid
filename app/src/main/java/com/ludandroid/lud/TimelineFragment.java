package com.ludandroid.lud;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class TimelineFragment extends Fragment {

    String[] dataset = {"1","2","3"}; //TODO : Insert data here

    public TimelineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_timeline, container, false);

        RecyclerView mRecyclerView = (RecyclerView) v.findViewById(R.id.timeline_recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Creates Asynctask for loading
        TestTimelineAsyncTask testTimelineAsyncTask = new TestTimelineAsyncTask();

        // Sets Adapter to the asynctask
        TimelineFragmentAdapter timelineFragmentAdapter = new TimelineFragmentAdapter(testTimelineAsyncTask);

        // Tells Asynctask how to refresh
        testTimelineAsyncTask.setDatasetChangeListener(timelineFragmentAdapter);

        // Set adapter to the recyclerview
        mRecyclerView.setAdapter(timelineFragmentAdapter);

        // Loads Asynctask
        testTimelineAsyncTask.execute();

        return v;
    }

}
