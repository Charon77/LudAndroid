package com.ludandroid.lud;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TimelineFragment extends Fragment {

    String[] dataset = {"1","2","3"}; //TODO : Insert data here

    public TimelineFragment() {
        // Required empty public constructor
    }


    // Pretends this class loads from some webserver
    class O implements TimelineFragmentAdapter.ITimelineData
    {
        JSONArray o = new JSONArray();

        public O()
        {
            try {
                o.put(new JSONObject()
                        .put("profileName", "Budi")
                        .put("timestamp", "123")
                );

                o.put(new JSONObject()
                        .put("profileName", "Joyo")
                        .put("timestamp", "789")
                );
            }
            catch (Exception e){e.printStackTrace();}

        }

        @Override
        public String getProfileName(int i) {
            try {
                return o.getJSONObject(i).getString("profileName");
            } catch (JSONException e) {e.printStackTrace(); return "ERROR";}
        }

        @Override
        public String getTimeStamp(int i) {
            try {
                return o.getJSONObject(i).getString("timestamp");
            } catch (JSONException e) {e.printStackTrace(); return "ERROR";}
        }

        @Override
        public int size() {
            return o.length();
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_timeline, container, false);

        RecyclerView mRecyclerView = (RecyclerView) v.findViewById(R.id.timeline_recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(new TimelineFragmentAdapter(new O()));

        return v;
    }

}
