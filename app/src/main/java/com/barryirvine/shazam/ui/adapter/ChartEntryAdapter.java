package com.barryirvine.shazam.ui.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.barryirvine.shazam.BR;
import com.barryirvine.shazam.R;
import com.barryirvine.shazam.model.local.ChartEntry;
import com.barryirvine.shazam.ui.contract.MainContract;
import com.barryirvine.shazam.viewmodel.ChartEntryViewModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ChartEntryAdapter extends RecyclerView.Adapter<ChartEntryAdapter.ViewHolder> {

    private final List<ChartEntry> mItems;
    private final Picasso mPicasso;
    private MainContract.Presenter mPresenter;

    public ChartEntryAdapter(final List<ChartEntry> items, final Picasso picasso, final MainContract.Presenter presenter) {
        mItems = items;
        mPicasso = picasso;
        mPresenter = presenter;

    }

    public List<ChartEntry> getItems() {
        return mItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, @LayoutRes final int viewType) {
        return new ChartEntryAdapter.ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), viewType, parent, false));
    }

    @LayoutRes
    @Override
    public int getItemViewType(final int position) {
        return R.layout.item_chart;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.bind(new ChartEntryViewModel(mItems.get(position)));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final ViewDataBinding mBinding;

        ViewHolder(@NonNull final ViewDataBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        void bind(@NonNull final ChartEntryViewModel chartEntryViewModel) {
            mBinding.setVariable(BR.viewModel, chartEntryViewModel);
            mBinding.setVariable(BR.picasso, mPicasso);
            mBinding.executePendingBindings();
        }
    }
}
