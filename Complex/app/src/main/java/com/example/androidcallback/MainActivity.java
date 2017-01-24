package com.example.androidcallback;

//ßimport com.example.androidcallback.MyAsyncTask.DoSomething;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity /*implements DoSomething*/{
	
	ProgressBar myProgressBar;
	MyAsyncTask myAsyncTask;
	int myProgress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		myProgressBar = (ProgressBar)findViewById(R.id.myprogressbar);
		
		myProgress = 0;
		myAsyncTask = new MyAsyncTask(100);
//		myAsyncTask.execute(this);
        myAsyncTask.execute(new MyAsyncTask.DoSomething() {
            @Override
            public void doItInBackground(int i) {
                myProgressBar.setProgress(i);
            }

            @Override
            public void doItPostExecute() {
                Toast.makeText(MainActivity.this,
                        "Finish", Toast.LENGTH_LONG).show();
            }
        });

    }

	/*@Override
	public void doItInBackground(int i) {
		myProgressBar.setProgress(i);
	}

	@Override
	public void doItPostExecute() {
		Toast.makeText(MainActivity.this, 
				"Finish", Toast.LENGTH_LONG).show();
	}*/

}
