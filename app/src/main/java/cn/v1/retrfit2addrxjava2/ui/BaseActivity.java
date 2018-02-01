package cn.v1.retrfit2addrxjava2.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by qy on 2018/2/1.
 */

public class BaseActivity extends Activity {

    protected Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
    }

    /**
     * tusi
     * @param message
     */
    protected void showTost(String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }

    /**
     * 跳转新的Activity
     * @param activity
     */
    protected void goNewActivity(Class<?> activity){
        Intent intent = new Intent(context,activity);
        startActivity(intent);
    }
}
