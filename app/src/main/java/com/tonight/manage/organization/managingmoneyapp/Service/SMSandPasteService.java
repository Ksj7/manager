package com.tonight.manage.organization.managingmoneyapp.Service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.tonight.manage.organization.managingmoneyapp.Custom.CustomSelectEventForReceivedTossSMSPopup;
import com.tonight.manage.organization.managingmoneyapp.R;
import com.tonight.manage.organization.managingmoneyapp.SMSActivity;

/**
 * Created by Taek on 2016. 12. 2..
 */

public class SMSandPasteService extends Service {
    static boolean semaphore = false;
    ClipboardManager clipBoard;
    ClipboardListener clipboardListener;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        new Thread() {
            public void run() {
                while (true) {
                    try {
                        Log.e("test", "testing..");
                        sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        IntentFilter filter = new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
        registerReceiver(mBroadcastReceiver,filter);
    }
    @Override
    public void onDestroy() {
        unregisterReceiver(mBroadcastReceiver);
        super.onDestroy();
    }

    class ClipboardListener implements ClipboardManager.OnPrimaryClipChangedListener, View.OnClickListener {
        View mView;
        WindowManager mManager;
        Button btn;
        TextView text;
        CharSequence pasteData = "";
        WindowManager.LayoutParams mParams;
        LayoutInflater mInflater;
        int i=5;
        public void onPrimaryClipChanged() {
            if(semaphore == false) {
                semaphore = true;
                ClipData.Item item = clipBoard.getPrimaryClip().getItemAt(0);
                pasteData = item.getText();
                Log.e("data ", pasteData.toString());

                mInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                mView = mInflater.inflate(R.layout.snackbar_activity, null);
                btn = (Button) mView.findViewById(R.id.btn);
                text = (TextView) mView.findViewById(R.id.timetext);
                text.setText(i + "");
                btn.setOnClickListener(this);
                mParams = new WindowManager.LayoutParams(
                        WindowManager.LayoutParams.MATCH_PARENT,
                        WindowManager.LayoutParams.WRAP_CONTENT,
                        WindowManager.LayoutParams.TYPE_PHONE,
                        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                        PixelFormat.TRANSLUCENT);

                mManager = (WindowManager) getApplicationContext().getSystemService(WINDOW_SERVICE);
                mParams.gravity = Gravity.BOTTOM;
                mManager.addView(mView, mParams);

                new TimerThread().start();
            }
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(),SMSActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
           /* CustomSelectEventForReceivedTossSMSPopup customSelectEventForReceivedTossSMSPopup = CustomSelectEventForReceivedTossSMSPopup.newInstance("");
            customSelectEventForReceivedTossSMSPopup.show(getApplicationContext(, "create_group");
*/
            if(mView != null) {
                mManager.removeView(mView);
                mView = null;
                i=5;
                semaphore = false;
                emptyClipboard(clipBoard);
            }
        }

        class TimerThread extends Thread{
            public void run() {
                while (i > 0 && semaphore == true) {
                    try {
                        this.sleep(1000);
                        //Message m = new Message();
                        i--;
                        //m.what = i;
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // new Handler and Runnable
                            @Override
                            public void run() {
                                text.setText(i + "");
                            }
                        });
                        //handler.sendMessage(m);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (mView != null) {
                    mManager.removeView(mView);
                    mView = null;
                    i = 5;
                    if(semaphore == true){
                        emptyClipboard(clipBoard);
                        semaphore = false;
                    }
                }
            }
        }
    }

    public void emptyClipboard(ClipboardManager clipBoard)
    {
        ClipData.Item item = new ClipData.Item("");
        String[] mimeType = new String[1];
        mimeType[0] = ClipDescription.MIMETYPE_TEXT_URILIST;
        ClipData cd = new ClipData(new ClipDescription("text_data", mimeType), item);
        clipBoard.removePrimaryClipChangedListener(clipboardListener);
        clipBoard.setPrimaryClip(cd);
        clipBoard.addPrimaryClipChangedListener(clipboardListener);
    }

    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)) {
                String reason = intent.getStringExtra("reason");
                if (reason != null) {
                    if (reason.equals("homekey")) {
                        //if(start == true) {

                        clipboardListener = new ClipboardListener();
                        clipBoard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                        clipBoard.addPrimaryClipChangedListener(clipboardListener);
                        emptyClipboard(clipBoard);

                        //stopservice();
                        //    start = false;
                        //}
                    }
                }
            }

        }
    };

    public void stopservice(){
        this.stopSelf();
    }
}

