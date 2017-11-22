package com.weidongjian.meitu.wheelviewdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.weigan.loopview.LoopView;
import com.weigan.loopview.OnItemSelectedListener;

import java.util.ArrayList;

import static android.R.id.list;

/**
 * Created by Weidongjian on 2017/3/25.
 */

public class DialogActivity extends AppCompatActivity {

    private Toast toast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    private void showDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_view, null);
        dialogBuilder.setView(dialogView);

        LoopView loopView = (LoopView) dialogView.findViewById(R.id.loopView);
        LoopView loopView2 = (LoopView) dialogView.findViewById(R.id.loopView2);
        LoopView loopView0 = (LoopView) dialogView.findViewById(R.id.loopView0);

        ArrayList<String> list0 = new ArrayList<>();
        for (int i = 4; i < 32; i++) {
            list0.add(" " + i);
        }
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            list.add(" " + i);
        }
        ArrayList<String> list2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list2.add("." + i+"kg");
        }
        // 滚动监听
        loopView.setListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                if (toast == null) {
                    toast = Toast.makeText(DialogActivity.this, "item " + index, Toast.LENGTH_SHORT);
                }
                toast.setText("item " + index);
                toast.show();
            }
        });

        loopView2.setListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                if (toast == null) {
                    toast = Toast.makeText(DialogActivity.this, "item " + index, Toast.LENGTH_SHORT);
                }
                toast.setText("item " + index);
                toast.show();
            }
        });
        // 设置原始数据
        loopView0.setItems(list0);
        loopView.setItems(list);
        loopView2.setItems(list2);

        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }
}
