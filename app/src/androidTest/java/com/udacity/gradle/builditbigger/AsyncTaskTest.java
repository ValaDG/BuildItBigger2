package com.udacity.gradle.builditbigger;

/**
 * Created by Valerio on 03/04/2016.
 * Code reviewed and implemented thanks to Matt_from_Pestulon and josen
 * https://discussions.udacity.com/t/async-task-test-where-to-even-begin/159593
 */

import android.content.Context;
import android.content.Intent;
import android.test.AndroidTestCase;
import android.test.mock.MockContext;

import org.mockito.Mock;

import java.util.concurrent.TimeUnit;

public class AsyncTaskTest extends AndroidTestCase{

    EndpointsAsyncTask task;
    String result;
    @Mock Context mockContext;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        result = null;
        task = new EndpointsAsyncTask(){
            @Override
            protected void onPostExecute(String joke){
                //No need to launch intent, so override this method
            }
        };
    }

    public void testAsyncReturnType() {

        try{

            MockContext mockContext = new MockContext(){
                @Override
                public String getPackageName()
                {
                    return "com.udacity.gradle.builditbigger";
                }

                @Override
                public void startActivity(Intent intent)
                {
                    // leave this unimplemented
                }
            };

            //Default timeout for the GCM server is 20 seconds
            //If the .get can't get the result in 10 seconds, something is wrong anyway
            //Greater than 20 seconds results in an error string returned and requires further interpretation
            task.execute(mockContext);
            result = task.get(10, TimeUnit.SECONDS);
            assertNotNull(result);

        }catch (Exception e){
            fail("Timed out");
        }
    }
}