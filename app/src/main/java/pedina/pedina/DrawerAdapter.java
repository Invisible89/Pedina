package pedina.pedina;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by Francesco on 11/04/2015.
 */
public class DrawerAdapter extends BaseAdapter {

    private final List<DrawerItem> items;
    private final Context context;

    public DrawerAdapter(Context context, List<DrawerItem> items) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.drawer_item, null);
            holder = new ViewHolder();
            holder.image_drawer = (ImageView) convertView.findViewById(R.id.image_drawer);
            holder.text_drawer = (TextView) convertView.findViewById(R.id.text_drawer);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.text_drawer.setText(items.get(position).getText());
        holder.image_drawer.setImageResource(items.get(position).getImageId());

        return convertView;
    }

    static class ViewHolder {
        TextView text_drawer;
        ImageView image_drawer;
    }


}