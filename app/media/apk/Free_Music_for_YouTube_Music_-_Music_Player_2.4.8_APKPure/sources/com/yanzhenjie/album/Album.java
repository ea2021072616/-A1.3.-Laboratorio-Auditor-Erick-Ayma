package com.yanzhenjie.album;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import com.yanzhenjie.album.api.AlbumMultipleWrapper;
import com.yanzhenjie.album.api.AlbumSingleWrapper;
import com.yanzhenjie.album.api.BasicGalleryWrapper;
import com.yanzhenjie.album.api.GalleryAlbumWrapper;
import com.yanzhenjie.album.api.GalleryWrapper;
import com.yanzhenjie.album.api.ImageCameraWrapper;
import com.yanzhenjie.album.api.ImageMultipleWrapper;
import com.yanzhenjie.album.api.ImageSingleWrapper;
import com.yanzhenjie.album.api.VideoCameraWrapper;
import com.yanzhenjie.album.api.VideoMultipleWrapper;
import com.yanzhenjie.album.api.VideoSingleWrapper;
import com.yanzhenjie.album.api.camera.AlbumCamera;
import com.yanzhenjie.album.api.camera.Camera;
import com.yanzhenjie.album.api.choice.AlbumChoice;
import com.yanzhenjie.album.api.choice.Choice;
import com.yanzhenjie.album.api.choice.ImageChoice;
import com.yanzhenjie.album.api.choice.VideoChoice;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class Album {
    public static final int FUNCTION_CAMERA_IMAGE = 0;
    public static final int FUNCTION_CAMERA_VIDEO = 1;
    public static final int FUNCTION_CHOICE_ALBUM = 2;
    public static final int FUNCTION_CHOICE_IMAGE = 0;
    public static final int FUNCTION_CHOICE_VIDEO = 1;
    public static final String KEY_INPUT_ALLOW_CAMERA = "KEY_INPUT_ALLOW_CAMERA";
    public static final String KEY_INPUT_CAMERA_BYTES = "KEY_INPUT_CAMERA_BYTES";
    public static final String KEY_INPUT_CAMERA_DURATION = "KEY_INPUT_CAMERA_DURATION";
    public static final String KEY_INPUT_CAMERA_QUALITY = "KEY_INPUT_CAMERA_QUALITY";
    public static final String KEY_INPUT_CHECKED_LIST = "KEY_INPUT_CHECKED_LIST";
    public static final String KEY_INPUT_CHOICE_MODE = "KEY_INPUT_CHOICE_MODE";
    public static final String KEY_INPUT_COLUMN_COUNT = "KEY_INPUT_COLUMN_COUNT";
    public static final String KEY_INPUT_CURRENT_POSITION = "KEY_INPUT_CURRENT_POSITION";
    public static final String KEY_INPUT_FILE_PATH = "KEY_INPUT_FILE_PATH";
    public static final String KEY_INPUT_FILTER_VISIBILITY = "KEY_INPUT_FILTER_VISIBILITY";
    public static final String KEY_INPUT_FUNCTION = "KEY_INPUT_FUNCTION";
    public static final String KEY_INPUT_GALLERY_CHECKABLE = "KEY_INPUT_GALLERY_CHECKABLE";
    public static final String KEY_INPUT_LIMIT_COUNT = "KEY_INPUT_LIMIT_COUNT";
    public static final String KEY_INPUT_NAVIGATION_ALPHA = "KEY_INPUT_NAVIGATION_ALPHA";
    public static final String KEY_INPUT_REQUEST_CODE = "KEY_INPUT_REQUEST_CODE";
    public static final String KEY_INPUT_WIDGET = "KEY_INPUT_WIDGET";
    public static final int MODE_MULTIPLE = 1;
    public static final int MODE_SINGLE = 2;
    private static AlbumConfig sAlbumConfig;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface CameraFunction {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ChoiceFunction {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ChoiceMode {
    }

    public static void initialize(AlbumConfig albumConfig) {
        if (sAlbumConfig == null) {
            sAlbumConfig = albumConfig;
        }
    }

    public static AlbumConfig getAlbumConfig() {
        if (sAlbumConfig == null) {
            sAlbumConfig = AlbumConfig.newBuilder(null).build();
        }
        return sAlbumConfig;
    }

    public static Camera<ImageCameraWrapper, VideoCameraWrapper> camera(Context context) {
        return new AlbumCamera(context);
    }

    public static Choice<ImageMultipleWrapper, ImageSingleWrapper> image(Context context) {
        return new ImageChoice(context);
    }

    public static Choice<VideoMultipleWrapper, VideoSingleWrapper> video(Context context) {
        return new VideoChoice(context);
    }

    public static Choice<AlbumMultipleWrapper, AlbumSingleWrapper> album(Context context) {
        return new AlbumChoice(context);
    }

    public static GalleryWrapper gallery(Context context) {
        return new GalleryWrapper(context);
    }

    public static GalleryAlbumWrapper galleryAlbum(Context context) {
        return new GalleryAlbumWrapper(context);
    }

    public static Camera<ImageCameraWrapper, VideoCameraWrapper> camera(Activity activity) {
        return new AlbumCamera(activity);
    }

    public static Choice<ImageMultipleWrapper, ImageSingleWrapper> image(Activity activity) {
        return new ImageChoice(activity);
    }

    public static Choice<VideoMultipleWrapper, VideoSingleWrapper> video(Activity activity) {
        return new VideoChoice(activity);
    }

    public static Choice<AlbumMultipleWrapper, AlbumSingleWrapper> album(Activity activity) {
        return new AlbumChoice(activity);
    }

    public static BasicGalleryWrapper<GalleryWrapper, String, String, String> gallery(Activity activity) {
        return new GalleryWrapper(activity);
    }

    public static BasicGalleryWrapper<GalleryAlbumWrapper, AlbumFile, String, AlbumFile> galleryAlbum(Activity activity) {
        return new GalleryAlbumWrapper(activity);
    }

    public static Camera<ImageCameraWrapper, VideoCameraWrapper> camera(Fragment fragment) {
        return new AlbumCamera(fragment.getActivity());
    }

    public static Choice<ImageMultipleWrapper, ImageSingleWrapper> image(Fragment fragment) {
        return new ImageChoice(fragment.getActivity());
    }

    public static Choice<VideoMultipleWrapper, VideoSingleWrapper> video(Fragment fragment) {
        return new VideoChoice(fragment.getActivity());
    }

    public static Choice<AlbumMultipleWrapper, AlbumSingleWrapper> album(Fragment fragment) {
        return new AlbumChoice(fragment.getActivity());
    }

    public static BasicGalleryWrapper<GalleryWrapper, String, String, String> gallery(Fragment fragment) {
        return new GalleryWrapper(fragment.getActivity());
    }

    public static BasicGalleryWrapper<GalleryAlbumWrapper, AlbumFile, String, AlbumFile> galleryAlbum(Fragment fragment) {
        return new GalleryAlbumWrapper(fragment.getActivity());
    }

    public static Camera<ImageCameraWrapper, VideoCameraWrapper> camera(android.support.v4.app.Fragment fragment) {
        return new AlbumCamera(fragment.getContext());
    }

    public static Choice<ImageMultipleWrapper, ImageSingleWrapper> image(android.support.v4.app.Fragment fragment) {
        return new ImageChoice(fragment.getContext());
    }

    public static Choice<VideoMultipleWrapper, VideoSingleWrapper> video(android.support.v4.app.Fragment fragment) {
        return new VideoChoice(fragment.getContext());
    }

    public static Choice<AlbumMultipleWrapper, AlbumSingleWrapper> album(android.support.v4.app.Fragment fragment) {
        return new AlbumChoice(fragment.getContext());
    }

    public static BasicGalleryWrapper<GalleryWrapper, String, String, String> gallery(android.support.v4.app.Fragment fragment) {
        return new GalleryWrapper(fragment.getContext());
    }

    public static BasicGalleryWrapper<GalleryAlbumWrapper, AlbumFile, String, AlbumFile> galleryAlbum(android.support.v4.app.Fragment fragment) {
        return new GalleryAlbumWrapper(fragment.getContext());
    }
}
