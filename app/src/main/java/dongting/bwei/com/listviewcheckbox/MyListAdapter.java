package dongting.bwei.com.listviewcheckbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * 作者:${董婷}
 * 日期:2017/6/7
 * 描述:
 */

public class MyListAdapter extends BaseAdapter {

    public List<Bean> list;
    public Context context;
    LayoutInflater inflater ;

    public MyListAdapter(Context context,List<Bean> list){
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);

    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.listadapter, null);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.textview_id_list);
            viewHolder.checkBox = (CheckBox) convertView.findViewById(R.id.checkbox);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textView.setText(list.get(position).getText());

        viewHolder.checkBox.setChecked(list.get(position).ischecked);


        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(list.get(position).ischecked()){
                    list.get(position).setIschecked(false);
                    viewHolder.checkBox.setChecked(false);

                }else {
                    list.get(position).setIschecked(true);
                    viewHolder.checkBox.setChecked(true);

                }
                notifyDataSetChanged();
            }
        });

        return  convertView;
    }

    static class ViewHolder {
        TextView textView;
        CheckBox checkBox ;
    }
}
