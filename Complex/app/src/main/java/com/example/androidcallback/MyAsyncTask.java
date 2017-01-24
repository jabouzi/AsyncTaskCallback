package com.example.androidcallback;

import android.os.AsyncTask;
import android.os.SystemClock;

public class MyAsyncTask{

	interface DoSomething {
		void doItInBackground(int progress);
		void doItPostExecute();
	}

	//DoSomething myDoSomethingCallBack;
	int myMax;
	
	public MyAsyncTask(int max){
		//myDoSomethingCallBack = callback;
		myMax = max;
	}

	public AsyncTask execute(final DoSomething callback) {
        return new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] params) {
                for (int i = 0; i <= myMax; i++) {
                    SystemClock.sleep(100);
                    callback.doItInBackground(i);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Object result)
            {
                callback.doItPostExecute();
            }

        }.execute();
    }

	/*@Override
	protected Void doInBackground(Void... params) {
		for (int i = 0; i <= myMax; i++) {
			SystemClock.sleep(100);
			myDoSomethingCallBack.doInBackground(i);
		}
		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);
		myDoSomethingCallBack.doPostExecute();
	}*/

}
