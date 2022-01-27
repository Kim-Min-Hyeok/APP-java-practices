package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder> {

    private final ArrayList<MainData> arrayList;

    public MainAdapter(ArrayList<MainData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MainAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    //ListView배너가 생성될 때 생명주기
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);


        return new CustomViewHolder(view);//holder 리턴!! 중요
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.CustomViewHolder holder, int position) {
        //추가될 때의 생명주기
        holder.iv_profile.setImageResource(arrayList.get(position).getIv_profile());//생성한 imageView 가져오기
        holder.tv_name.setText(arrayList.get(position).getTv_name());//생성한 TextView가져오기
        holder.tv_content.setText(arrayList.get(position).getTv_content());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(view -> {
            //TextView를 짧게 클릭했을 때 이벤트
            String curName = holder.tv_name.getText().toString();
            Toast.makeText(view.getContext(),curName,Toast.LENGTH_SHORT).show();
        });

        holder.itemView.setOnLongClickListener(view -> {
            remove(holder.getAdapterPosition());
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size():0);
    }

    public void remove(int position){
        //LongClick했을 때 ListView가 삭제 됨
        try{
            arrayList.remove(position);
            notifyItemRemoved(position);//새로고침(ListView를 지운 후 새로고침을 해줘야 삭제한 것이 보임)
        }catch(IndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {

        protected ImageView iv_profile;
        protected TextView tv_name;
        protected TextView tv_content;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_profile = (ImageView) itemView.findViewById(R.id.iv_profile);
            this.tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            this.tv_content = (TextView) itemView.findViewById(R.id.tv_content);
        }
    }
}
