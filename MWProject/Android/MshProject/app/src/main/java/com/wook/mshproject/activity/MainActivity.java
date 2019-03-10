package com.wook.mshproject.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wook.mshproject.MshApplication;
import com.wook.mshproject.R;
import com.wook.mshproject.model.UserInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recyuclerview)
    RecyclerView mRecyclerView;

    RecyclerViewAdapter recyclerViewAdapter;
    List<UserInfo> mUserInfos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initLayout();
        requestApi();
    }

    private void initLayout() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter = new RecyclerViewAdapter(mUserInfos);
        mRecyclerView.setAdapter(recyclerViewAdapter);
    }

    private void requestApi() {
        Call<List<UserInfo>> call = MshApplication.getInstance().getApiInfo().getApiTest();
        call.enqueue(new Callback<List<UserInfo>>() {
            @Override
            public void onResponse(Call<List<UserInfo>> call, Response<List<UserInfo>> response) {
                Log.d("TAG", "response = " + response.toString());
                Log.d("TAG", "response = " + response.body().toString());
                if (response.isSuccessful() && response.code() != 204) {
                    bindData(response.body());
                }

            }

            @Override
            public void onFailure(Call<List<UserInfo>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void bindData(List<UserInfo> data) {
        mUserInfos.clear();
        mUserInfos.addAll(data);

        recyclerViewAdapter.notifyDataSetChanged();
    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        List<UserInfo> uesrInfos;

        public RecyclerViewAdapter(List<UserInfo> uesrInfos) {
            this.uesrInfos = uesrInfos;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_user_info, viewGroup, false);
            return new ViewHolderUserInfo(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            UserInfo userInfo = uesrInfos.get(i);

            ViewHolderUserInfo ViewHolderUserInfo = (ViewHolderUserInfo) viewHolder;

            ViewHolderUserInfo.textCompany.setText(userInfo.getCompany());
            ViewHolderUserInfo.textManager.setText(userInfo.getManager());
            ViewHolderUserInfo.Contact.setText(userInfo.getContact());
        }

        @Override
        public int getItemCount() {
            return uesrInfos.size();
        }

        public class ViewHolderUserInfo extends RecyclerView.ViewHolder {
            @BindView(R.id.text_company)
            TextView textCompany;
            @BindView(R.id.text_manager)
            TextView textManager;
            @BindView(R.id.text_contact)
            TextView Contact;

            public ViewHolderUserInfo(@NonNull View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }
    }
}
