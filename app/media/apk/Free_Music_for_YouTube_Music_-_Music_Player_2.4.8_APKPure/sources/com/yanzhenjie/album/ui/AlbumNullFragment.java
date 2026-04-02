package com.yanzhenjie.album.ui;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.R;
import com.yanzhenjie.album.api.widget.Widget;
import com.yanzhenjie.album.util.AlbumUtils;
import com.yanzhenjie.fragment.a;
import com.yanzhenjie.statusview.StatusView;
/* loaded from: classes2.dex */
public class AlbumNullFragment extends a {
    private static final String KEY_OUTPUT_IMAGE_PATH = "KEY_OUTPUT_IMAGE_PATH";
    private AppCompatButton mBtnCameraImage;
    private AppCompatButton mBtnCameraVideo;
    private int mFunction;
    private boolean mHasCamera;
    @IntRange(from = 1, to = Long.MAX_VALUE)
    private long mLimitBytes;
    @IntRange(from = 1, to = Long.MAX_VALUE)
    private long mLimitDuration;
    private StatusView mStatusView;
    private Toolbar mToolbar;
    private TextView mTvMessage;
    private Widget mWidget;
    @IntRange(from = MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED, to = 1)
    private int mQuality = 1;
    private View.OnClickListener mCameraClickListener = new View.OnClickListener() { // from class: com.yanzhenjie.album.ui.AlbumNullFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.btn_camera_image) {
                Album.camera(AlbumNullFragment.this.getContext()).image().onResult(AlbumNullFragment.this.mCameraAction).start();
            } else if (id == R.id.btn_camera_video) {
                Album.camera(AlbumNullFragment.this.getContext()).video().quality(AlbumNullFragment.this.mQuality).limitDuration(AlbumNullFragment.this.mLimitDuration).limitBytes(AlbumNullFragment.this.mLimitBytes).onResult(AlbumNullFragment.this.mCameraAction).start();
            }
        }
    };
    private Action<String> mCameraAction = new Action<String>() { // from class: com.yanzhenjie.album.ui.AlbumNullFragment.2
        @Override // com.yanzhenjie.album.Action
        public void onAction(int i, @NonNull String str) {
            Bundle bundle = new Bundle();
            bundle.putString(AlbumNullFragment.KEY_OUTPUT_IMAGE_PATH, str);
            AlbumNullFragment.this.setResult(-1, bundle);
            AlbumNullFragment.this.finish();
        }
    };

    public static String parseImagePath(Bundle bundle) {
        return bundle.getString(KEY_OUTPUT_IMAGE_PATH);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.album_fragment_null, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        this.mStatusView = (StatusView) view.findViewById(R.id.status_view);
        this.mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        setToolbar(this.mToolbar);
        this.mTvMessage = (TextView) view.findViewById(R.id.tv_message);
        this.mBtnCameraImage = (AppCompatButton) view.findViewById(R.id.btn_camera_image);
        this.mBtnCameraVideo = (AppCompatButton) view.findViewById(R.id.btn_camera_video);
        this.mBtnCameraImage.setOnClickListener(this.mCameraClickListener);
        this.mBtnCameraVideo.setOnClickListener(this.mCameraClickListener);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        this.mWidget = (Widget) arguments.getParcelable(Album.KEY_INPUT_WIDGET);
        this.mFunction = arguments.getInt(Album.KEY_INPUT_FUNCTION);
        this.mHasCamera = arguments.getBoolean(Album.KEY_INPUT_ALLOW_CAMERA);
        this.mQuality = arguments.getInt(Album.KEY_INPUT_CAMERA_QUALITY, 1);
        this.mLimitDuration = arguments.getLong(Album.KEY_INPUT_CAMERA_DURATION, Long.MAX_VALUE);
        this.mLimitBytes = arguments.getLong(Album.KEY_INPUT_CAMERA_BYTES, Long.MAX_VALUE);
        initializeWidget();
    }

    private void initializeWidget() {
        int statusBarColor = this.mWidget.getStatusBarColor();
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.album_ic_back_white);
        if (this.mWidget.getStyle() == 1) {
            if (((AlbumActivity) getActivity()).isSucceedLightStatus()) {
                this.mStatusView.setBackgroundColor(statusBarColor);
            } else {
                this.mStatusView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.album_ColorPrimaryBlack));
            }
            this.mToolbar.setTitleTextColor(ContextCompat.getColor(getContext(), R.color.album_FontDark));
            this.mToolbar.setSubtitleTextColor(ContextCompat.getColor(getContext(), R.color.album_FontDark));
            AlbumUtils.setDrawableTint(drawable, ContextCompat.getColor(getContext(), R.color.album_IconDark));
            displayHomeAsUpEnabled(drawable);
        } else {
            this.mStatusView.setBackgroundColor(statusBarColor);
            displayHomeAsUpEnabled(drawable);
        }
        this.mToolbar.setBackgroundColor(this.mWidget.getToolBarColor());
        this.mToolbar.setTitle(this.mWidget.getTitle());
        switch (this.mFunction) {
            case 0:
                this.mTvMessage.setText(R.string.album_not_found_image);
                this.mBtnCameraVideo.setVisibility(8);
                break;
            case 1:
                this.mTvMessage.setText(R.string.album_not_found_video);
                this.mBtnCameraImage.setVisibility(8);
                break;
            default:
                this.mTvMessage.setText(R.string.album_not_found_album);
                break;
        }
        if (this.mHasCamera) {
            Widget.ButtonStyle buttonStyle = this.mWidget.getButtonStyle();
            ColorStateList buttonSelector = buttonStyle.getButtonSelector();
            this.mBtnCameraImage.setSupportBackgroundTintList(buttonSelector);
            this.mBtnCameraVideo.setSupportBackgroundTintList(buttonSelector);
            if (buttonStyle.getButtonStyle() == 1) {
                Drawable drawable2 = this.mBtnCameraImage.getCompoundDrawables()[0];
                AlbumUtils.setDrawableTint(drawable2, ContextCompat.getColor(getContext(), R.color.album_IconDark));
                this.mBtnCameraImage.setCompoundDrawables(drawable2, null, null, null);
                Drawable drawable3 = this.mBtnCameraVideo.getCompoundDrawables()[0];
                AlbumUtils.setDrawableTint(drawable3, ContextCompat.getColor(getContext(), R.color.album_IconDark));
                this.mBtnCameraVideo.setCompoundDrawables(drawable3, null, null, null);
                this.mBtnCameraImage.setTextColor(ContextCompat.getColor(getContext(), R.color.album_FontDark));
                this.mBtnCameraVideo.setTextColor(ContextCompat.getColor(getContext(), R.color.album_FontDark));
                return;
            }
            return;
        }
        this.mBtnCameraImage.setVisibility(8);
        this.mBtnCameraVideo.setVisibility(8);
    }
}
