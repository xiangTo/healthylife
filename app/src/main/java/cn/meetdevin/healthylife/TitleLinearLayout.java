package cn.meetdevin.healthylife;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.meetdevin.healthylife.MyApplication;
import cn.meetdevin.healthylife.Pedometer.View.SettingActivity;
import cn.meetdevin.healthylife.R;

/**
 * Created by XinZh on 2017/3/29.
 */

public class TitleLinearLayout extends LinearLayout implements View.OnClickListener{
    Button back;
    TextView textView;
    Button setting;

    public TitleLinearLayout(final Context context, AttributeSet attributeSet) {
        super(context,attributeSet);
        LayoutInflater.from(context).inflate(R.layout.title,this);
        back = (Button) findViewById(R.id.title_back);
        textView = (TextView) findViewById(R.id.title_textView);
        setting = (Button) findViewById(R.id.title_setting);

        switch (getRunningActivityName(context)){
            case "PedometerActivity":
                textView.setText("计步");
                back.setVisibility(VISIBLE);
                setting.setVisibility(VISIBLE);
                break;
            case "RunningActivity":
                textView.setText("跑步");
                back.setVisibility(VISIBLE);
                setting.setVisibility(GONE);
                break;
            case "MainActivity":
                textView.setText("HealthyLife");
                back.setVisibility(GONE);
                setting.setVisibility(GONE);
                break;
            default:
                textView.setText("---");
                break;
        }

        back.setOnClickListener(this);
        setting.setOnClickListener(this);
    }

    //获取当前运行的 Activity 名字
    private String getRunningActivityName(Context context) {
        String contextString = context.toString();
        return contextString.substring(contextString.lastIndexOf(".") + 1, contextString.indexOf("@"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_back:
                ((Activity)getContext()).finish();
                break;
            case R.id.title_setting:
                SettingActivity.actionStart(getContext());
                break;
        }
    }
}
