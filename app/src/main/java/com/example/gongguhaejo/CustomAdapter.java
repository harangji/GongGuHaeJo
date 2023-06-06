package com.example.gongguhaejo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>{

    private ArrayList<GongguList> arrayList;
    private Context context;
    public CustomAdapter(ArrayList<GongguList> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }
    private OnItemClickListener mListener = null ;

    // OnItemClickListener 리스너 객체 참조를 어댑터에 전달하는 메서드
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener ;
    }




    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gonggu_list_item, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {    //아이템 클릭 처리
                String tv_restname = "";
                int position = holder.getAbsoluteAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    holder.tv_restname.setText("item clicked. pos=" + position); //test
                    //todo
                }
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getFood_cate_image())
                .into(holder.iv_foodcateimage);
        holder.tv_restname.setText(arrayList.get(position).getRest_name());
        holder.tv_foodcate.setText(arrayList.get(position).getFood_cate());
        holder.tv_food_deliveryprice.setText(String.valueOf(arrayList.get(position).getFood_deliveryprice()));
        //holder.tv_timelimit.setText(arrayList.get(position).getTime_limit());
    }

    @Override
    public int getItemCount() {
        //삼향 연산자
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_foodcateimage;
        TextView tv_restname;
        TextView tv_foodcate;
        TextView tv_food_deliveryprice;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_foodcateimage = itemView.findViewById(R.id.iv_foodcateimage);
            this.tv_restname = itemView.findViewById(R.id.tv_restname);
            this.tv_foodcate = itemView.findViewById(R.id.tv_foodcate);
            this.tv_food_deliveryprice = itemView.findViewById(R.id.tv_fooddeliveryprice);
        }
    }
}
