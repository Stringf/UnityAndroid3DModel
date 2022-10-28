package com.VPA.VPAModel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.VPA.VPAModel.util.Action;
import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

public class MainActivity extends UnityPlayerActivity implements View.OnClickListener {

    public static final String MODEL = "Jammo_LowPoly";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        mUnityPlayer = new UnityPlayer(this,this);


        FrameLayout model = (FrameLayout) findViewById(R.id.FrameLayout);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        model.addView(mUnityPlayer.getView(), 0, layoutParams);
    }

    private void init() {
        Button agree = findViewById(R.id.btn_agree);
        Button run = findViewById(R.id.btn_run);
        Button sad = findViewById(R.id.btn_sad);
        Button no = findViewById(R.id.btn_no);
        Button sit = findViewById(R.id.btn_sit);
        Button test = findViewById(R.id.btn_test);
        Button wave = findViewById(R.id.btn_wave);

        run.setOnClickListener((View.OnClickListener) this);
        agree.setOnClickListener((View.OnClickListener) this);
        sad.setOnClickListener((View.OnClickListener) this);
        no.setOnClickListener((View.OnClickListener) this);
        sit.setOnClickListener((View.OnClickListener) this);
        test.setOnClickListener((View.OnClickListener) this);
        wave.setOnClickListener((View.OnClickListener) this);

    }

    public void callUnity(String _objName , String _funcStr, String _content) {
        UnityPlayer.UnitySendMessage(_objName, _funcStr, _content);
    }

    public void callUnity(String _objName , String _funcStr) {
        UnityPlayer.UnitySendMessage(_objName, _funcStr, "");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_agree:
                callUnity(MODEL, Action.AGREE);
                break;

            case R.id.btn_sit:
                callUnity(MODEL,Action.SIT);
                break;

            case R.id.btn_run:
                callUnity(MODEL,Action.RUN);
                break;

            case R.id.btn_sad:
                callUnity(MODEL,Action.SAD);
                break;

            case R.id.btn_no:
                callUnity(MODEL,Action.NO);
                break;

            case R.id.btn_test:
                callUnity(MODEL,Action.TEST);
                break;

            case R.id.btn_wave:
                callUnity(MODEL,Action.WAVE);
        }
    }
}
