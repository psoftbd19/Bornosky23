package com.bornosky.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.bornosky.R;
import com.bornosky.model.StudentInfo;

import java.util.ArrayList;
import java.util.List;

public class DataItemAdapter extends RecyclerView.Adapter<DataItemAdapter.ViewHolder> {

    public static final String ITEM_ID_KEY = "item_id_key";
    public static final String ITEM_KEY = "item_key";
    private List<StudentInfo> mItems;
    Context mContext;
    private SharedPreferences.OnSharedPreferenceChangeListener prefsListener;

    public DataItemAdapter(Context context, List<StudentInfo> items) {
        this.mContext = context;
        this.mItems = items;
        phones = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(R.layout.row, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final StudentInfo item = mItems.get(position);

        holder.tvRoll.setText(item.getRoll());
        holder.tvName.setText(item.getName());
        holder.tvPhone.setText(item.getPhone());


     /*   holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Toast.makeText(mContext, "item selected " + item.getItemName(), Toast.LENGTH_SHORT).show();
                //  Intent intent = new Intent(mContext, DetailActivity.class);
                //intent.putExtra(ITEM_ID_KEY,item.getItemId());
                // intent.putExtra(ITEM_KEY, item);
                //    mContext.startActivity(intent);
            //    int adapterPosition = getAdapterPosition();
                Toast.makeText(mContext, "item:"+item.getPosition(), Toast.LENGTH_SHORT).show();

                if (!item.getChecked()) {
                    holder.choiceSt.setChecked(true);
                    item.setChecked(true);

                }
                else  {
                    holder.choiceSt.setChecked(false);
                    item.setChecked(false);
                }

            }
        });
        holder.mView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(mContext, "item onlong click " + item.getName(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });*/


        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static List<String> phones;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tvName, tvRoll, tvPhone;
        public CheckBox choiceSt;
        public View mView;


        public ViewHolder(View itemView) {
            super(itemView);

            tvRoll = (TextView) itemView.findViewById(R.id.tvRoll);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvPhone = (TextView) itemView.findViewById(R.id.tvPhone);
            choiceSt = (CheckBox) itemView.findViewById(R.id.choiceSt);


            mView = itemView;
            mView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            Toast.makeText(mContext, "item:" + mItems.get(adapterPosition).getName(), Toast.LENGTH_SHORT).show();


            if (!mItems.get(adapterPosition).getChecked()) {
                choiceSt.setChecked(true);
                mItems.get(adapterPosition).setChecked(true);
                phones.add(mItems.get(adapterPosition).getPhone());
            } else {
                choiceSt.setChecked(false);
                mItems.get(adapterPosition).setChecked(false);
                phones.remove(mItems.get(adapterPosition).getPhone());
            }
        }

        public void bind(int position) {

            if (!mItems.get(position).getChecked()) {
                choiceSt.setChecked(false);
            } else {
                choiceSt.setChecked(true);
                //   Toast.makeText(mContext, "item:" + mItems.get(position).getPosition(), Toast.LENGTH_SHORT).show();
            }
            // choiceSt.setText(String.valueOf(mItems.get(position).getPosition()));
        }
    }
}