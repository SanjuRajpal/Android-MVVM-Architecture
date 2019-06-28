package com.sr.sample.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.sr.sample.R;

public class MyRecyclerView extends FrameLayout {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private TextView tvNoData;
    private boolean isLoading;
    private boolean isShowNoData;

    public MyRecyclerView(@NonNull Context context) {
        super(context);
        init(null, -1);
    }

    public MyRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public MyRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(attrs, defStyleAttr);
    }

    public MyRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs, defStyleAttr);
    }

    private void init(AttributeSet attrs, int defStyleAttr) {

        if (attrs != null && defStyleAttr != -1) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.MyRecyclerView, defStyleAttr, 0);
            isLoading = a.getBoolean(R.styleable.MyRecyclerView_showProgress, false);
            isShowNoData = a.getBoolean(R.styleable.MyRecyclerView_showNoData, false);
            a.recycle();
        }

        View view = inflate(getContext(), R.layout.recyclerview, null);
        recyclerView = view.findViewById(R.id.recycler_view);
        progressBar = view.findViewById(R.id.progress_bar);
        tvNoData = view.findViewById(R.id.tv_no_data);

        addView(view);

        if (isLoading) {
            progressBar.setVisibility(VISIBLE);
        }

    }

    public boolean isLoading() {
        return isLoading;
    }

    public void dismissLoading() {
        isLoading = false;
        progressBar.setVisibility(GONE);
    }

    public void showLoading() {
        isLoading = true;
        progressBar.setVisibility(VISIBLE);
    }

    public void setRecyclerViewAdapter(RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
        if (isShowNoData) {
            if (adapter.getItemCount() == 0)
                tvNoData.setVisibility(VISIBLE);
            else
                tvNoData.setVisibility(GONE);
        }
        dismissLoading();
    }
}
