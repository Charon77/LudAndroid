package com.ludandroid.lud;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Evans on 22-Dec-16.
 *
 * Provides Interface for filling in data to the timeline
 * Interface used by TimelineFragmentAdapter to get data from TestNotifierTimelineAsyncTask
 */

// TODO: make method for getting detail for content and contentInner
interface INotifierTimelineDataset extends INotifier{
    String getProfileName(int i);
    String getTimeStamp(int i);
    int size();
}
