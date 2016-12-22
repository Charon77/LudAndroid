package com.ludandroid.lud;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Pretends this class loads from some webserver
// TODO: Real web access
class TestTimelineAsyncTask extends AsyncTask<Void, Void, Void> implements ITimelineDataset
{
    private IDatasetChangeListener datasetChangeListener;
    private JSONArray jsonDataFetchedFromWeb = new JSONArray();

    void setDatasetChangeListener(IDatasetChangeListener myDatasetChangeListener) {
        datasetChangeListener = myDatasetChangeListener;
    }

    //region ITimelineDataset
    @Override
    public String getProfileName(int i) {
        try {
            return jsonDataFetchedFromWeb.getJSONObject(i).getString("profileName");
        } catch (JSONException e) {e.printStackTrace(); return "ERROR";}
    }

    @Override
    public String getTimeStamp(int i) {
        try {
            return jsonDataFetchedFromWeb.getJSONObject(i).getString("timestamp");
        } catch (JSONException e) {e.printStackTrace(); return "ERROR";}
    }

    @Override
    public int size() {
        return jsonDataFetchedFromWeb.length();
    }
    //endregion

    //region AsyncTask Extension
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            Thread.sleep(1000);
            try {
                jsonDataFetchedFromWeb.put(new JSONObject()
                        .put("profileName", "Budi")
                        .put("timestamp", "123")
                );

                jsonDataFetchedFromWeb.put(new JSONObject()
                        .put("profileName", "Joyo")
                        .put("timestamp", "789")
                );
            }
            catch (Exception e){e.printStackTrace();}
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        datasetChangeListener.refreshAdapter();
    }
    //endregion
}
