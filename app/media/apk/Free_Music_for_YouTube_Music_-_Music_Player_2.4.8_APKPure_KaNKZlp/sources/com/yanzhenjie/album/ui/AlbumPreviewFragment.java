package com.yanzhenjie.album.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.R;
import com.yanzhenjie.album.api.widget.Widget;
import com.yanzhenjie.album.ui.adapter.AlbumFilePreviewAdapter;
import com.yanzhenjie.album.util.AlbumUtils;
import com.yanzhenjie.fragment.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class AlbumPreviewFragment extends a {
    private int mAllowSelectCount;
    private AppCompatCheckBox mCheckBox;
    private int mCurrentItemPosition;
    private MenuItem mFinishMenuItem;
    private int mFunction;
    private FrameLayout mLayoutLayer;
    private TextView mTvDuration;
    private ViewPager mViewPager;
    private Widget mWidget;
    private List<AlbumFile> mAlbumFiles = new ArrayList(1);
    private List<AlbumFile> mCheckedFiles = new ArrayList(1);

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.album_fragment_preview, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        this.mViewPager = (ViewPager) view.findViewById(R.id.view_pager);
        this.mTvDuration = (TextView) view.findViewById(R.id.tv_duration);
        this.mCheckBox = (AppCompatCheckBox) view.findViewById(R.id.cb_album_check);
        this.mLayoutLayer = (FrameLayout) view.findViewById(R.id.layout_layer);
        setToolbar((Toolbar) view.findViewById(R.id.toolbar));
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        displayHomeAsUpEnabled(R.drawable.album_ic_back_white);
        Bundle arguments = getArguments();
        this.mWidget = (Widget) arguments.getParcelable(Album.KEY_INPUT_WIDGET);
        this.mFunction = arguments.getInt(Album.KEY_INPUT_FUNCTION);
        this.mAllowSelectCount = arguments.getInt(Album.KEY_INPUT_LIMIT_COUNT, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        initializeWidget();
        initializeViewPager();
        setCheckedCountUI(this.mCheckedFiles.size());
    }

    private void initializeWidget() {
        this.mCheckBox.setSupportButtonTintList(this.mWidget.getMediaItemCheckSelector());
        this.mCheckBox.setOnClickListener(new View.OnClickListener() { // from class: com.yanzhenjie.album.ui.AlbumPreviewFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                boolean isChecked = AlbumPreviewFragment.this.mCheckBox.isChecked();
                AlbumFile albumFile = (AlbumFile) AlbumPreviewFragment.this.mAlbumFiles.get(AlbumPreviewFragment.this.mCurrentItemPosition);
                albumFile.setChecked(isChecked);
                if (isChecked) {
                    if (AlbumPreviewFragment.this.mCheckedFiles.size() < AlbumPreviewFragment.this.mAllowSelectCount) {
                        AlbumPreviewFragment.this.mCheckedFiles.add(albumFile);
                    } else {
                        switch (AlbumPreviewFragment.this.mFunction) {
                            case 0:
                                i = R.plurals.album_check_image_limit;
                                break;
                            case 1:
                                i = R.plurals.album_check_video_limit;
                                break;
                            default:
                                i = R.plurals.album_check_album_limit;
                                break;
                        }
                        Toast.makeText(AlbumPreviewFragment.this.getContext(), AlbumPreviewFragment.this.getResources().getQuantityString(i, AlbumPreviewFragment.this.mAllowSelectCount, Integer.valueOf(AlbumPreviewFragment.this.mAllowSelectCount)), 1).show();
                        AlbumPreviewFragment.this.mCheckBox.setChecked(false);
                        albumFile.setChecked(false);
                    }
                } else {
                    AlbumPreviewFragment.this.mCheckedFiles.remove(albumFile);
                }
                AlbumPreviewFragment.this.setCheckedCountUI(AlbumPreviewFragment.this.mCheckedFiles.size());
            }
        });
    }

    private void initializeViewPager() {
        if (this.mAlbumFiles != null) {
            if (this.mAlbumFiles.size() > 3) {
                this.mViewPager.setOffscreenPageLimit(3);
            } else if (this.mAlbumFiles.size() > 2) {
                this.mViewPager.setOffscreenPageLimit(2);
            }
        }
        this.mViewPager.setAdapter(new AlbumFilePreviewAdapter(getContext(), this.mAlbumFiles));
        ViewPager.SimpleOnPageChangeListener simpleOnPageChangeListener = new ViewPager.SimpleOnPageChangeListener() { // from class: com.yanzhenjie.album.ui.AlbumPreviewFragment.2
            @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AlbumPreviewFragment.this.mCurrentItemPosition = i;
                AlbumFile albumFile = (AlbumFile) AlbumPreviewFragment.this.mAlbumFiles.get(AlbumPreviewFragment.this.mCurrentItemPosition);
                AlbumPreviewFragment.this.mCheckBox.setChecked(albumFile.isChecked());
                AlbumPreviewFragment.this.mCheckBox.setEnabled(albumFile.isEnable());
                AlbumPreviewFragment.this.setTitle((AlbumPreviewFragment.this.mCurrentItemPosition + 1) + " / " + AlbumPreviewFragment.this.mAlbumFiles.size());
                if (albumFile.getMediaType() == 2) {
                    AlbumPreviewFragment.this.mTvDuration.setText(AlbumUtils.convertDuration(albumFile.getDuration()));
                    AlbumPreviewFragment.this.mTvDuration.setVisibility(0);
                } else {
                    AlbumPreviewFragment.this.mTvDuration.setVisibility(8);
                }
                AlbumPreviewFragment.this.mLayoutLayer.setVisibility(albumFile.isEnable() ? 8 : 0);
            }
        };
        this.mViewPager.addOnPageChangeListener(simpleOnPageChangeListener);
        this.mViewPager.setCurrentItem(this.mCurrentItemPosition);
        simpleOnPageChangeListener.onPageSelected(this.mCurrentItemPosition);
    }

    public void bindAlbumFiles(List<AlbumFile> list, List<AlbumFile> list2, int i) {
        this.mAlbumFiles.addAll(list);
        this.mCheckedFiles = list2;
        this.mCurrentItemPosition = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedCountUI(int i) {
        this.mFinishMenuItem.setTitle(getString(R.string.album_menu_finish) + "(" + i + " / " + this.mAllowSelectCount + ")");
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.album_menu_preview, menu);
        this.mFinishMenuItem = menu.findItem(R.id.album_menu_finish);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.album_menu_finish) {
            setResult(-1);
            finish();
            return true;
        }
        return true;
    }
}
