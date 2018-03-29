package com.taoze.gitdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.taoze.gitdemo.widget.ActionSheetDialog;
import com.taoze.gitdemo.widget.ActionSheetDialog.OnSheetItemClickListener;
import com.taoze.gitdemo.widget.ActionSheetDialog.SheetItemColor;
import com.taoze.gitdemo.widget.AlertDialog;

public class MainActivity extends Activity implements OnClickListener {

    private Button btn1, btn2, btn3, btn4, btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //setCancelable 设置取消，setCanceledOnTouchOutside设置在外触碰取消
        switch (v.getId()) {
            case R.id.btn1:
                new ActionSheetDialog(MainActivity.this)
                        .builder()
                        .setTitle("清空消息列表后，聊天记录依然保留，确定要清空消息列表？")
                        .setCancelable(true)
                        .setCanceledOnTouchOutside(false)
                        .addSheetItem("清空消息列表", SheetItemColor.Red
                                , new OnSheetItemClickListener() {

                                    @Override
                                    public void onClick(int which) {
                                        Toast.makeText(MainActivity.this,"clear message list",Toast.LENGTH_SHORT).show();
                                    }
                                }).show();
                break;

            case R.id.btn2:
                new ActionSheetDialog(MainActivity.this)
                        .builder()
                        .setCancelable(true)
                        .setCanceledOnTouchOutside(true)
                        .addSheetItem("发送给好友",
                                SheetItemColor.Blue,
                                new OnSheetItemClickListener() {

                                    @Override
                                    public void onClick(int which) {

                                    }
                                })
                        .addSheetItem("转载到空间相册",
                                SheetItemColor.Blue,
                                new OnSheetItemClickListener() {

                                    @Override
                                    public void onClick(int which) {

                                    }
                                })
                        .addSheetItem("上传到群相册",
                                SheetItemColor.Blue,
                                new OnSheetItemClickListener() {

                                    @Override
                                    public void onClick(int which) {

                                    }
                                })
                        .addSheetItem("保存到手机",
                                SheetItemColor.Blue,
                                new OnSheetItemClickListener() {

                                    @Override
                                    public void onClick(int which) {

                                    }
                                }).show();
                break;
            case R.id.btn3:
                new ActionSheetDialog(MainActivity.this)
                        .builder()
                        .setTitle("好友列表")
                        .setCancelable(true)
                        .setCanceledOnTouchOutside(true)
                        .addSheetItem("删除好友", SheetItemColor.Red
                                , new OnSheetItemClickListener() {

                                    @Override
                                    public void onClick(int which) {

                                    }
                                })
                        .addSheetItem("增加好友", SheetItemColor.Blue
                                , new OnSheetItemClickListener() {

                                    @Override
                                    public void onClick(int which) {

                                    }
                                })
                        .addSheetItem("备注", SheetItemColor.Blue
                                , new OnSheetItemClickListener() {

                                    @Override
                                    public void onClick(int which) {

                                    }
                                }).show();
                break;
            //setNegativeButton相对setPositiveButton颜色要浅一些
            case R.id.btn4:
                new AlertDialog(MainActivity.this)
                        .builder()
                        .setTitle("退出当前帐号")
                        .setMsg("再连续登陆15天，就可变身为QQ达人。退出QQ可能会使你现有记录归零，确定退出？")
                        .setPositiveButton("确认退出", new OnClickListener() {

                            @Override
                            public void onClick(View v) {

                            }
                        })
                        .setNegativeButton("取消", new OnClickListener() {

                            @Override
                            public void onClick(View v) {

                            }
                        }).show();
                break;
            case R.id.btn5:
                new AlertDialog(MainActivity.this)
                        .builder()
                        .setTitle("错误信息")
                        .setMsg("你的手机sd卡出现问题，建议删除不需要的文件，否则收不到图片和视频等打文件")
                        .setPositiveButton("确定", new OnClickListener() {

                            @Override
                            public void onClick(View v) {

                            }
                        }).show();
                break;
        }
    }
}