package com.chaeeun.midaschallengeapp.View;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.chaeeun.midaschallengeapp.R;

import java.util.Locale;

public class ReviewActivity extends AppCompatActivity implements AppCompatRatingBar.OnRatingBarChangeListener{

    private float curriculm = 5.0f;
    private float ready = 5.0f;
    private float time = 5.0f;
    MenuItem done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        Toolbar toolbar = (Toolbar)findViewById(R.id.menu_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        AppCompatRatingBar curriculum_ratingBar = (AppCompatRatingBar)findViewById(R.id.curriculum_ratingbar);
        AppCompatRatingBar ready_ratingBar = (AppCompatRatingBar)findViewById(R.id.ready_ratingbar);
        AppCompatRatingBar time_ratingBar = (AppCompatRatingBar)findViewById(R.id.time_ratingbar);

        /*
        자바 코드로 ratingBar 색상 변경 방법입니다.
        Drawable progress = curriculum_ratingBar.getProgressDrawable();
        DrawableCompat.setTint(progress, Color.YELLOW);
         */

        curriculum_ratingBar.setOnRatingBarChangeListener(this);            // RatingBar의 리스너를 설정해서 각 변수를 받습니다.
        ready_ratingBar.setOnRatingBarChangeListener(this);
        time_ratingBar.setOnRatingBarChangeListener(this);

        EditText editText = (EditText)findViewById(R.id.review_et);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count != 0){
                    done.setEnabled(true);              // 입력 받으면 메뉴에 완료버튼을 사용할 수가 있습니다.
                }
                else{
                    done.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.review_menu, menu);
        done = menu.findItem(R.id.menu_done);
        done.setEnabled(false);                         // EditText를 입력 받기전엔 눌러도 실행되지 않도록 합니다.
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menu_done:
                String str = String.format(Locale.getDefault(),"커리큘럼: %.1f, 준비성: %.1f, 시간준수: %.1f", curriculm, ready, time);
                Toast toast = Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT);
                toast.show();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        switch(ratingBar.getId()){
            case R.id.curriculum_ratingbar:
                curriculm = rating;
                break;
            case R.id.ready_ratingbar:
                ready = rating;
                break;
            case R.id.time_ratingbar:
                time = rating;
                break;
        }
    }
}
