package com.ludandroid.lud;

/**
 * Created by Evans on 22-Dec-16.
 *
 * Adapter should implement this so they will be notified upon data change,
 * typically by AsyncTask
 */

interface IDatasetChangeListener {
    void refreshAdapter();
}
