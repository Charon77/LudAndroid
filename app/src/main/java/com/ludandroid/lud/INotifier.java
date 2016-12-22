package com.ludandroid.lud;

/**
 * Created by Evans on 22-Dec-16.
 * Every interface that is being used to fill adapter should extend this
 */

interface INotifier {
    void setDatasetChangeListener(IDatasetChangeListener myDatasetChangeListener);
    void loadData();
}
