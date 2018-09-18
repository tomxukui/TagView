package com.ablingbling.app.tagview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.ablingbling.library.tagview.Tag;
import com.ablingbling.library.tagview.TagView;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView listView = this.findViewById(R.id.list);
        MyAdapter adapter = new MyAdapter();
        listView.setAdapter(adapter);
        List<ListData> datas = new ArrayList<>();
        for (int i = 0; i <= 50; i++) {
            datas.add(new ListData("ITEM " + i));
        }
        adapter.setDatas(datas);
    }

    public class ListData {
        public String text;

        public ListData(String text) {
            this.text = text;
        }
    }

    public class ViewHolder {
        public TagView tagView;
    }

    public class MyAdapter extends BaseAdapter {
        List<ListData> datas = new ArrayList<>();

        public void setDatas(List<ListData> datas) {
            this.datas = datas;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public ListData getItem(int position) {
            return datas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_tag, parent, false);
                holder = new ViewHolder();
                holder.tagView = convertView.findViewById(R.id.tagview_item_list);
                convertView.setTag(holder);
            }
            holder = (ViewHolder) convertView.getTag();
            if (holder != null) {
                holder.tagView.removeAllTags();
                List<Tag> tags = new ArrayList<>();
                Tag tag;
                tag = new Tag(getItem(position).text);
                tag.layoutColor = Color.parseColor("#F06292");
                tags.add(tag);
                tag = new Tag(getItem(position).text);
                tag.layoutColor = Color.parseColor("#90CAF9");
                tags.add(tag);
                tag = new Tag(getItem(position).text);
                tag.layoutColor = Color.parseColor("#80DEEA");
                tags.add(tag);
                holder.tagView.addTags(tags);
            }
            return convertView;
        }
    }

}
