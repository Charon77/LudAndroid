package com.ludandroid.lud;

import android.support.v7.widget.RecyclerView;

/**
 * Created by richi on 12/21/2016.
 */

// Provides Interface for filling in data to the timeline
// TODO: make method for getting detail for content and contentInner
interface ITimelineDataset {
    String getProfileName(int i);
    String getTimeStamp(int i);
    int size();
}
