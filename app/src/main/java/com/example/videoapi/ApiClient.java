package com.example.videoapi;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class ApiClient  {
    private RequestQueue requestQueue;
    private static ApiClient mInstance;

    private ApiClient(Context context){
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static synchronized ApiClient getmInstance(Context context){

        if(mInstance == null){
            mInstance = new ApiClient(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue(){
        return  requestQueue;
    }
}
