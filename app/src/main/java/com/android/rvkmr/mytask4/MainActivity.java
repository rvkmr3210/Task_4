package com.android.rvkmr.mytask4;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.truizlop.fabreveallayout.FABRevealLayout;
import com.truizlop.fabreveallayout.OnRevealChangeListener;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.ll_initial_layout)
    LinearLayout llInitialLayout;
    @BindView(R.id.ll_final_layout)
    RelativeLayout llFinalLayout;
    @BindView(R.id.bt_cancel)
    Button btCancel;
    @BindView(R.id.iv_next)
    ImageView ivNext;
    @BindView(R.id.iv_previous)
    ImageView ivPrevious;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.tv_month)
    TextView tvMonth;
    @BindView(R.id.tv_week)
    TextView tvWeek;
    @BindView(R.id.rl_container)
    FABRevealLayout fabRevealLayout;
    int date;
    String month;
    String[] months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    String[] weeks = new String[]{"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    String week;
    int year;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        configureFABReveal();
        settingOnClickListeners();
        calendar = Calendar.getInstance();
        settingViews(calendar);
    }

    private void settingViews(Calendar calendar) {
        date = calendar.get(Calendar.DAY_OF_MONTH);
        month = months[calendar.get(Calendar.MONTH)];
        week = weeks[calendar.get(Calendar.DAY_OF_WEEK)];
        year = calendar.get(Calendar.YEAR);

        tvDate.setText(String.valueOf(date));
        tvMonth.setText(String.valueOf(month + " " + year));
        tvWeek.setText(String.valueOf(week));

    }

    private void settingOnClickListeners() {
        btCancel.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                prepareBackTransition(fabRevealLayout);
            }
        });

    }

    private void configureFABReveal() {
        fabRevealLayout.setOnRevealChangeListener(new OnRevealChangeListener() {
            @Override
            public void onMainViewAppeared(FABRevealLayout fabRevealLayout, View mainView) {
//                showInitialLayoutItems();
            }

            @Override
            public void onSecondaryViewAppeared(final FABRevealLayout fabRevealLayout, View secondaryView) {
//                showFinalLayoutViewItems();
            }
        });
    }

    private void prepareBackTransition(final FABRevealLayout fabRevealLayout) {
        fabRevealLayout.revealMainView();

    }

/*

    private void animateCircularReveal(ViewGroup viewRoot) {
        final int x = viewRoot.getRight();
        final int y = viewRoot.getTop();
        int startRadius = 0;
        int endRadius = (int) Math.hypot(llInitialLayout.getWidth(), llInitialLayout.getHeight());

        Animator anim = ViewAnimationUtils.createCircularReveal(llFinalLayout, x, y, startRadius, endRadius);
        anim.setDuration(getResources().getInteger(R.integer.anim_duration_medium));

        llFinalLayout.setVisibility(View.VISIBLE);

        anim.start();
    }


    private void animateRevealHide(final View viewRoot) {
        int cx = viewRoot.getRight();
        int cy = viewRoot.getTop();
        int initialRadius = (int) Math.hypot(llFinalLayout.getWidth(), llFinalLayout.getHeight());

        Animator anim = ViewAnimationUtils.createCircularReveal(viewRoot, cx, cy, initialRadius, 0);
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                viewRoot.setVisibility(View.INVISIBLE);
            }
        });
        anim.setDuration(getResources().getInteger(R.integer.anim_duration_medium));
        anim.start();

    }
*/


}
