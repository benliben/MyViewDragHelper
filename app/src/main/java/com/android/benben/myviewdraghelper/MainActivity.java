package com.android.benben.myviewdraghelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import com.nineoldandroids.view.ViewHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;


public class MainActivity extends BaseActivity {
    private DragLayout dl;
    private ExpandableListView lv;
    private CircleImageView iv_bottom;
    private ImageView iv_icon;


    private Map<String, List<String>> dataset = new HashMap<>();
    private String[] parentList = new String[]{"first", "second", "third"};
    private List<String> childrenList1 =new ArrayList<>();
    private List<String> childrenList2 =new ArrayList<>();
    private List<String> childrenList3 =new ArrayList<>();




    public DragLayout getDl() {
        return dl;
    }





        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setStatusBar();
        initDragLayout();
        initView();

            initialData();
            initViews();

    }

    private void initialData() {
        childrenList1.add(parentList[0] + "-" + "first");
        childrenList1.add(parentList[0] + "-" + "second");
        childrenList1.add(parentList[0] + "-" + "third");
        childrenList2.add(parentList[1] + "-" + "first");
        childrenList2.add(parentList[1] + "-" + "second");
        childrenList2.add(parentList[1] + "-" + "third");
        childrenList3.add(parentList[2] + "-" + "first");
        childrenList3.add(parentList[2] + "-" + "second");
        childrenList3.add(parentList[2] + "-" + "third");
        dataset.put(parentList[0], childrenList1);
        dataset.put(parentList[1], childrenList2);
        dataset.put(parentList[2], childrenList3);
    }

    private void initViews() {

        MyExpandableListViewAdapter mAdapter = new MyExpandableListViewAdapter(parentList, dataset, MainActivity.this);
        lv.setAdapter(mAdapter);

    }

    private void initDragLayout() {
        dl = (DragLayout) findViewById(R.id.dl);
        dl.setDragListener(new DragLayout.DragListener() {
            //界面打开的时候
            @Override
            public void onOpen() {
            }
            //界面关闭的时候
            @Override
            public void onClose() {
            }

            //界面滑动的时候
            @Override
            public void onDrag(float percent) {
                ViewHelper.setAlpha(iv_icon, 1 - percent);
            }
        });
    }

    private void initView() {

        iv_icon = (ImageView) findViewById(R.id.iv_icon);

        iv_bottom = (CircleImageView) findViewById(R.id.iv_bottom);
        iv_bottom.setImageResource(R.drawable.tjlogo);

        lv = (ExpandableListView) findViewById(R.id.lv);
//        lv.setAdapter(new ArrayAdapter<>(MainActivity.this,
//                R.layout.item_text, new String[] { "item 01", "item 01",
//                "item 01", "item 01", "item 01", "item 01",
//                "item 01", "item 01", "item 01", "item 01",
//                "item 01", "item 01", "item 01", "item 01",
//                "item 01", "item 01", "item 01",
//                "item 01", "item 01", "item 01", "item 01"}));
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> arg0, View arg1,
//                                    int position, long arg3) {
//                Toast.makeText(MainActivity.this,"Click Item "+position,Toast.LENGTH_SHORT).show();
//            }
//        });
        iv_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                dl.openLeft();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }



}
