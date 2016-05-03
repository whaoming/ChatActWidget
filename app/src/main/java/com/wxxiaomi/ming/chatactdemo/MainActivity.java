package com.wxxiaomi.ming.chatactdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.wxxiaomi.ming.chatwidget.bean.Emojicon;
import com.wxxiaomi.ming.chatwidget.bean.CoustomEmojGroupData;

import com.wxxiaomi.ming.chatwidget.weidgt.ChatExtendMenu.ChatMenuItemModel;
import com.wxxiaomi.ming.chatwidget.weidgt.ChatExtendMenu;
import com.wxxiaomi.ming.chatwidget.weidgt.ChatInputMenu;

import com.wxxiaomi.ming.chatwidget.weidgt.EaseEmojiconMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ChatInputMenu inputMenu;
    static final int ITEM_TAKE_PICTURE = 1;
    static final int ITEM_PICTURE = 2;
    static final int ITEM_LOCATION = 3;

    protected int[] itemStrings = {R.string.attach_take_pic,
            R.string.attach_picture, R.string.attach_location};
    protected int[] itemdrawables = {R.drawable.ease_chat_takepic_selector,
            R.drawable.ease_chat_image_selector,
            R.drawable.ease_chat_location_selector};
    protected int[] itemIds = {ITEM_TAKE_PICTURE, ITEM_PICTURE, ITEM_LOCATION};
    private List<Map<Integer, String>> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputMenu = (ChatInputMenu) findViewById(R.id.input_menu);
        inputMenu.init(CoustomEmojGroupData.getData(), itemStrings, itemdrawables, itemIds
                , new ChatInputMenu.ChatInputMenuListener() {
                    @Override
                    public void onSendMessage(String content) {
                        Log.i("wang","发送了:"+content);
                    }

                    @Override
                    public boolean onPressToSpeakBtnTouch(View v, MotionEvent event) {

                        return false;
                    }

                    @Override
                    public void onCustomItemClick(int position) {
                        Log.i("wang","点击了第"+position+"的item");
                    }

                    @Override
                    public void onBigExpressionClicked(Emojicon emojicon) {
                        Log.i("wang","点击了大表情");
                    }
                });
//        ChatMenuItemModel itemModel = new ChatMenuItemModel("",1,1);
//        inputMenu.init();
//        inputMenu.init(null);
//        inputMenu.setChatInputMenuListener(new ChatInputMenu.ChatInputMenuListener() {
//
//            @Override
//            public void onSendMessage(String content) {
//
//            }
//
//            @Override
//            public boolean onPressToSpeakBtnTouch(View v, MotionEvent event) {
//
//                return false;
//            }
//
//            @Override
//            public void onBigExpressionClicked(Emojicon emojicon) {
//                // TODO Auto-generated method stub
//
//            }
//        });
//        for (int i = 0; i < itemStrings.length; i++) {
//            inputMenu.registerExtendMenuItem(itemStrings[i], itemdrawables[i],
//                    itemIds[i], new ChatExtendMenu.EaseChatExtendMenuItemClickListener() {
//                        @Override
//                        public void onClick(int itemId, View view) {
//
//                        }
//                    });
//        }
//        ((EaseEmojiconMenu) inputMenu.getEmojiconMenu())
//                .addEmojiconGroup(CoustomEmojGroupData.getData());
    }
}
