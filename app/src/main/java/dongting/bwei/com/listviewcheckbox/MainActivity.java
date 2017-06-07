package dongting.bwei.com.listviewcheckbox;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者:${董婷}
 * 日期:2017/6/7
 * 描述:
 */
public class MainActivity extends Activity {

    private ListView listView;
    private List<Bean> list;
    private MyListAdapter adapter;

    private boolean checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.lv);
        final Button bt=(Button) findViewById(R.id.bt);

        list = new ArrayList<>();

        initData();

        adapter = new MyListAdapter(this,list);
        listView.setAdapter(adapter);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int i=0;i<list.size();i++){
                    if(!checked){
                        list.get(i).setIschecked(true);
                    }else{
                        list.get(i).setIschecked(false);
                    }
                    adapter.notifyDataSetChanged();
                }

                if(!checked){
                    checked=true;
                    bt.setText("取消全选");
                }else{
                    checked=false;
                    bt.setText("全选");
                }
            }
        });

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

                if(scrollState==AbsListView.OnScrollListener.SCROLL_STATE_IDLE ){

                 if(mtotalItemCount-mvisibleItemCount-mfirstVisibleItem<=5){
                     for(int i=30;i<60;i++){
                    Bean bean = new Bean();
                    bean.setText("哈"+i);
                    bean.setIschecked(false);
                    list.add(bean);
                }
                adapter.notifyDataSetChanged();
    }
}
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                mfirstVisibleItem=firstVisibleItem;
                mvisibleItemCount=visibleItemCount;
                mtotalItemCount=totalItemCount;
            }
        });
    }

    int mfirstVisibleItem;
    int mvisibleItemCount;
    int mtotalItemCount;

    private void initData() {
        for(int i=0;i<30;i++){
            Bean bean = new Bean();
            bean.setText("哈哈"+i);
            bean.setIschecked(false);
            list.add(bean);
        }
    }
}
