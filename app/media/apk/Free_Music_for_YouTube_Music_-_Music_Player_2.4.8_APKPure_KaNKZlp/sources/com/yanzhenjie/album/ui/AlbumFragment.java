package com.yanzhenjie.album.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.AlbumFolder;
import com.yanzhenjie.album.Filter;
import com.yanzhenjie.album.R;
import com.yanzhenjie.album.api.widget.Widget;
import com.yanzhenjie.album.impl.AlbumCallback;
import com.yanzhenjie.album.impl.OnItemCheckedListener;
import com.yanzhenjie.album.impl.OnItemClickListener;
import com.yanzhenjie.album.task.MediaReadTask;
import com.yanzhenjie.album.task.PathConvertTask;
import com.yanzhenjie.album.ui.adapter.AlbumFileAdapter;
import com.yanzhenjie.album.util.AlbumUtils;
import com.yanzhenjie.album.util.DisplayUtils;
import com.yanzhenjie.album.widget.divider.Divider;
import com.yanzhenjie.fragment.a;
import com.yanzhenjie.statusview.StatusView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class AlbumFragment extends a {
    private static final int REQUEST_CODE_CAMERA_IMAGE = 102;
    private static final int REQUEST_CODE_CAMERA_VIDEO = 103;
    private static final int REQUEST_CODE_FRAGMENT_NULL = 101;
    private static final int REQUEST_CODE_FRAGMENT_PREVIEW = 100;
    private AlbumFileAdapter mAlbumContentAdapter;
    private List<AlbumFolder> mAlbumFolders;
    private Button mBtnPreview;
    private Button mBtnSwitchFolder;
    private AlbumCallback mCallback;
    private PopupMenu mCameraPopupMenu;
    private int mChoiceMode;
    private int mColumnCount;
    private int mCurrentFolder;
    private Filter<Long> mDurationFilter;
    private boolean mFilterVisibility;
    private MenuItem mFinishMenuItem;
    private AlbumFolderDialog mFolderDialog;
    private int mFunction;
    private boolean mHasCamera;
    private GridLayoutManager mLayoutManager;
    @IntRange(from = 1, to = Long.MAX_VALUE)
    private long mLimitBytes;
    private int mLimitCount;
    @IntRange(from = 1, to = Long.MAX_VALUE)
    private long mLimitDuration;
    private com.yanzhenjie.a.a mMediaScanner;
    private Filter<String> mMimeFilter;
    private RecyclerView mRvContentList;
    private Filter<Long> mSizeFilter;
    private StatusView mStatusView;
    private Toolbar mToolbar;
    private Widget mWidget;
    private ArrayList<AlbumFile> mCheckedList = new ArrayList<>();
    @IntRange(from = MediaDescriptionCompat.BT_FOLDER_TYPE_MIXED, to = 1)
    private int mQuality = 1;
    private MediaReadTask.Callback mScanCallback = new MediaReadTask.Callback() { // from class: com.yanzhenjie.album.ui.AlbumFragment.2
        @Override // com.yanzhenjie.album.task.MediaReadTask.Callback
        public void onScanCallback(ArrayList<AlbumFolder> arrayList) {
            AlbumFragment.this.mAlbumFolders = arrayList;
            AlbumFragment.this.showAlbumFileFromFolder(0);
            if (((AlbumFolder) AlbumFragment.this.mAlbumFolders.get(0)).getAlbumFiles().size() == 0) {
                AlbumFragment.this.startFragmentForResult((AlbumFragment) ((AlbumNullFragment) AlbumFragment.this.fragment(AlbumNullFragment.class, AlbumFragment.this.getArguments())), 101);
            }
            AlbumFragment.this.setCheckedCountUI(AlbumFragment.this.mCheckedList.size());
        }
    };
    private View.OnClickListener mSwitchDirClick = new View.OnClickListener() { // from class: com.yanzhenjie.album.ui.AlbumFragment.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AlbumFragment.this.mFolderDialog == null) {
                AlbumFragment.this.mFolderDialog = new AlbumFolderDialog(AlbumFragment.this.getContext(), AlbumFragment.this.mWidget, AlbumFragment.this.mAlbumFolders, new OnItemClickListener() { // from class: com.yanzhenjie.album.ui.AlbumFragment.3.1
                    @Override // com.yanzhenjie.album.impl.OnItemClickListener
                    public void onItemClick(View view2, int i) {
                        if (AlbumFragment.this.mAlbumFolders.size() > i) {
                            AlbumFragment.this.mCurrentFolder = i;
                            AlbumFragment.this.showAlbumFileFromFolder(AlbumFragment.this.mCurrentFolder);
                            AlbumFragment.this.mLayoutManager.scrollToPosition(0);
                        }
                    }
                });
            }
            if (!AlbumFragment.this.mFolderDialog.isShowing()) {
                AlbumFragment.this.mFolderDialog.show();
            }
        }
    };
    private OnItemClickListener mAddPhotoListener = new OnItemClickListener() { // from class: com.yanzhenjie.album.ui.AlbumFragment.4
        @Override // com.yanzhenjie.album.impl.OnItemClickListener
        public void onItemClick(View view, int i) {
            String randomMP4Path;
            String randomJPGPath;
            int i2;
            if (AlbumFragment.this.mCheckedList.size() < AlbumFragment.this.mLimitCount) {
                switch (AlbumFragment.this.mFunction) {
                    case 0:
                        if (AlbumFragment.this.mCurrentFolder == 0) {
                            randomJPGPath = AlbumUtils.randomJPGPath();
                        } else {
                            randomJPGPath = AlbumUtils.randomJPGPath(new File(((AlbumFolder) AlbumFragment.this.mAlbumFolders.get(AlbumFragment.this.mCurrentFolder)).getAlbumFiles().get(0).getPath()).getParentFile());
                        }
                        Album.camera(AlbumFragment.this.getContext()).image().filePath(randomJPGPath).requestCode(102).onResult(AlbumFragment.this.mCameraAction).start();
                        return;
                    case 1:
                        if (AlbumFragment.this.mCurrentFolder == 0) {
                            randomMP4Path = AlbumUtils.randomMP4Path();
                        } else {
                            randomMP4Path = AlbumUtils.randomMP4Path(new File(((AlbumFolder) AlbumFragment.this.mAlbumFolders.get(AlbumFragment.this.mCurrentFolder)).getAlbumFiles().get(0).getPath()).getParentFile());
                        }
                        Album.camera(AlbumFragment.this.getContext()).video().filePath(randomMP4Path).quality(AlbumFragment.this.mQuality).limitDuration(AlbumFragment.this.mLimitDuration).limitBytes(AlbumFragment.this.mLimitBytes).requestCode(103).onResult(AlbumFragment.this.mCameraAction).start();
                        return;
                    default:
                        if (AlbumFragment.this.mCameraPopupMenu == null) {
                            AlbumFragment.this.mCameraPopupMenu = new PopupMenu(AlbumFragment.this.getContext(), view);
                            AlbumFragment.this.mCameraPopupMenu.getMenuInflater().inflate(R.menu.album_menu_item_camera, AlbumFragment.this.mCameraPopupMenu.getMenu());
                            AlbumFragment.this.mCameraPopupMenu.setOnMenuItemClickListener(AlbumFragment.this.mCameraItemMenuClickListener);
                        }
                        AlbumFragment.this.mCameraPopupMenu.show();
                        return;
                }
            }
            switch (AlbumFragment.this.mFunction) {
                case 0:
                    i2 = R.plurals.album_check_image_limit_camera;
                    break;
                case 1:
                    i2 = R.plurals.album_check_video_limit_camera;
                    break;
                default:
                    i2 = R.plurals.album_check_album_limit_camera;
                    break;
            }
            Toast.makeText(AlbumFragment.this.getContext(), AlbumFragment.this.getResources().getQuantityString(i2, AlbumFragment.this.mLimitCount, Integer.valueOf(AlbumFragment.this.mLimitCount)), 1).show();
        }
    };
    private PopupMenu.OnMenuItemClickListener mCameraItemMenuClickListener = new PopupMenu.OnMenuItemClickListener() { // from class: com.yanzhenjie.album.ui.AlbumFragment.5
        @Override // android.support.v7.widget.PopupMenu.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.album_menu_camera_image) {
                Album.camera(AlbumFragment.this.getContext()).image().requestCode(102).onResult(AlbumFragment.this.mCameraAction).start();
                return true;
            } else if (itemId == R.id.album_menu_camera_video) {
                Album.camera(AlbumFragment.this.getContext()).video().requestCode(103).onResult(AlbumFragment.this.mCameraAction).start();
                return true;
            } else {
                return true;
            }
        }
    };
    private Action<String> mCameraAction = new Action<String>() { // from class: com.yanzhenjie.album.ui.AlbumFragment.6
        @Override // com.yanzhenjie.album.Action
        public void onAction(int i, @NonNull String str) {
            if (AlbumFragment.this.mMediaScanner == null) {
                AlbumFragment.this.mMediaScanner = new com.yanzhenjie.a.a(AlbumFragment.this.getContext());
            }
            AlbumFragment.this.mMediaScanner.a(str);
            new PathConvertTask(AlbumFragment.this.getContext(), AlbumFragment.this.mConvertCallback, AlbumFragment.this.mSizeFilter, AlbumFragment.this.mMimeFilter, AlbumFragment.this.mDurationFilter).execute(str);
        }
    };
    private PathConvertTask.Callback mConvertCallback = new PathConvertTask.Callback() { // from class: com.yanzhenjie.album.ui.AlbumFragment.7
        @Override // com.yanzhenjie.album.task.PathConvertTask.Callback
        public void onConvertCallback(AlbumFile albumFile) {
            albumFile.setChecked(albumFile.isEnable());
            if (albumFile.isEnable()) {
                AlbumFragment.this.mCheckedList.add(albumFile);
                AlbumFragment.this.setCheckedCountUI(AlbumFragment.this.mCheckedList.size());
            }
            if (albumFile.isEnable()) {
                AlbumFragment.this.addFileToList(albumFile);
            } else if (AlbumFragment.this.mFilterVisibility) {
                AlbumFragment.this.addFileToList(albumFile);
            } else {
                Toast.makeText(AlbumFragment.this.getContext(), AlbumFragment.this.getString(R.string.album_take_file_unavailable), 1).show();
            }
        }
    };
    private OnItemCheckedListener mItemCheckListener = new OnItemCheckedListener() { // from class: com.yanzhenjie.album.ui.AlbumFragment.8
        @Override // com.yanzhenjie.album.impl.OnItemCheckedListener
        public void onCheckedChanged(CompoundButton compoundButton, int i, boolean z) {
            int i2;
            AlbumFile albumFile = ((AlbumFolder) AlbumFragment.this.mAlbumFolders.get(AlbumFragment.this.mCurrentFolder)).getAlbumFiles().get(i);
            albumFile.setChecked(z);
            if (z) {
                if (AlbumFragment.this.mCheckedList.size() < AlbumFragment.this.mLimitCount) {
                    AlbumFragment.this.mCheckedList.add(albumFile);
                    switch (AlbumFragment.this.mChoiceMode) {
                        case 2:
                            AlbumFragment.this.onAlbumResult();
                            break;
                    }
                } else {
                    switch (AlbumFragment.this.mFunction) {
                        case 0:
                            i2 = R.plurals.album_check_image_limit;
                            break;
                        case 1:
                            i2 = R.plurals.album_check_video_limit;
                            break;
                        default:
                            i2 = R.plurals.album_check_album_limit;
                            break;
                    }
                    Toast.makeText(AlbumFragment.this.getContext(), AlbumFragment.this.getResources().getQuantityString(i2, AlbumFragment.this.mLimitCount, Integer.valueOf(AlbumFragment.this.mLimitCount)), 1).show();
                    compoundButton.setChecked(false);
                    albumFile.setChecked(false);
                }
            } else {
                AlbumFragment.this.mCheckedList.remove(albumFile);
            }
            AlbumFragment.this.setCheckedCountUI(AlbumFragment.this.mCheckedList.size());
        }
    };
    private View.OnClickListener mPreviewClick = new View.OnClickListener() { // from class: com.yanzhenjie.album.ui.AlbumFragment.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AlbumFragment.this.mCheckedList.size() > 0) {
                AlbumPreviewFragment albumPreviewFragment = (AlbumPreviewFragment) AlbumFragment.this.fragment(AlbumPreviewFragment.class, AlbumFragment.this.getArguments());
                albumPreviewFragment.bindAlbumFiles(AlbumFragment.this.mCheckedList, AlbumFragment.this.mCheckedList, 0);
                AlbumFragment.this.startFragmentForResult((AlbumFragment) albumPreviewFragment, 100);
            }
        }
    };

    public void setSizeFilter(Filter<Long> filter) {
        this.mSizeFilter = filter;
    }

    public void setMimeFilter(Filter<String> filter) {
        this.mMimeFilter = filter;
    }

    public void setDurationFilter(Filter<Long> filter) {
        this.mDurationFilter = filter;
    }

    @Override // com.yanzhenjie.fragment.a, android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mCallback = (AlbumCallback) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.mCallback = null;
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.album_fragment_album, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        this.mStatusView = (StatusView) view.findViewById(R.id.status_view);
        this.mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        this.mBtnPreview = (Button) view.findViewById(R.id.btn_preview);
        this.mBtnSwitchFolder = (Button) view.findViewById(R.id.btn_switch_dir);
        this.mRvContentList = (RecyclerView) view.findViewById(R.id.rv_content_list);
        setToolbar(this.mToolbar);
        this.mBtnSwitchFolder.setOnClickListener(this.mSwitchDirClick);
        this.mBtnPreview.setOnClickListener(this.mPreviewClick);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.album_menu_album, menu);
        this.mFinishMenuItem = menu.findItem(R.id.album_menu_finish);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            this.mCallback.onAlbumCancel();
            return true;
        } else if (itemId == R.id.album_menu_finish) {
            onAlbumResult();
            return true;
        } else {
            return true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        final Bundle arguments = getArguments();
        this.mWidget = (Widget) arguments.getParcelable(Album.KEY_INPUT_WIDGET);
        this.mFunction = arguments.getInt(Album.KEY_INPUT_FUNCTION);
        this.mChoiceMode = arguments.getInt(Album.KEY_INPUT_CHOICE_MODE);
        this.mColumnCount = arguments.getInt(Album.KEY_INPUT_COLUMN_COUNT);
        this.mHasCamera = arguments.getBoolean(Album.KEY_INPUT_ALLOW_CAMERA);
        this.mLimitCount = arguments.getInt(Album.KEY_INPUT_LIMIT_COUNT);
        this.mQuality = arguments.getInt(Album.KEY_INPUT_CAMERA_QUALITY, 1);
        this.mLimitDuration = arguments.getLong(Album.KEY_INPUT_CAMERA_DURATION, Long.MAX_VALUE);
        this.mLimitBytes = arguments.getLong(Album.KEY_INPUT_CAMERA_BYTES, Long.MAX_VALUE);
        initializeWidget();
        this.mLayoutManager = new GridLayoutManager(getContext(), this.mColumnCount);
        this.mRvContentList.setLayoutManager(this.mLayoutManager);
        Divider divider = AlbumUtils.getDivider(-1);
        this.mRvContentList.addItemDecoration(divider);
        this.mAlbumContentAdapter = new AlbumFileAdapter(getContext(), (DisplayUtils.sScreenWidth - (divider.getWidth() * (this.mColumnCount + 1))) / this.mColumnCount, this.mHasCamera, this.mChoiceMode, this.mWidget.getMediaItemCheckSelector());
        this.mAlbumContentAdapter.setAddClickListener(this.mAddPhotoListener);
        this.mAlbumContentAdapter.setItemCheckedListener(this.mItemCheckListener);
        this.mAlbumContentAdapter.setItemClickListener(new OnItemClickListener() { // from class: com.yanzhenjie.album.ui.AlbumFragment.1
            @Override // com.yanzhenjie.album.impl.OnItemClickListener
            public void onItemClick(View view, int i) {
                ArrayList<AlbumFile> albumFiles = ((AlbumFolder) AlbumFragment.this.mAlbumFolders.get(AlbumFragment.this.mCurrentFolder)).getAlbumFiles();
                AlbumPreviewFragment albumPreviewFragment = (AlbumPreviewFragment) AlbumFragment.this.fragment(AlbumPreviewFragment.class, arguments);
                albumPreviewFragment.bindAlbumFiles(albumFiles, AlbumFragment.this.mCheckedList, i);
                AlbumFragment.this.startFragmentForResult((AlbumFragment) albumPreviewFragment, 100);
            }
        });
        this.mRvContentList.setAdapter(this.mAlbumContentAdapter);
        this.mFilterVisibility = arguments.getBoolean(Album.KEY_INPUT_FILTER_VISIBILITY, true);
        new MediaReadTask(getContext(), this.mFunction, this.mScanCallback, this.mCheckedList, this.mSizeFilter, this.mMimeFilter, this.mDurationFilter, this.mFilterVisibility).execute(arguments.getParcelableArrayList(Album.KEY_INPUT_CHECKED_LIST));
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
            AlbumUtils.setDrawableTint(this.mFinishMenuItem.getIcon(), ContextCompat.getColor(getContext(), R.color.album_IconDark));
            CharSequence title = this.mFinishMenuItem.getTitle();
            this.mFinishMenuItem.setTitle(AlbumUtils.getColorText(title, 0, title.length(), ContextCompat.getColor(getContext(), R.color.album_FontDark)));
        } else {
            this.mStatusView.setBackgroundColor(statusBarColor);
            displayHomeAsUpEnabled(drawable);
        }
        this.mToolbar.setBackgroundColor(this.mWidget.getToolBarColor());
        this.mToolbar.setTitle(this.mWidget.getTitle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAlbumFileFromFolder(int i) {
        AlbumFolder albumFolder = this.mAlbumFolders.get(i);
        this.mBtnSwitchFolder.setText(albumFolder.getName());
        this.mAlbumContentAdapter.notifyDataSetChanged(albumFolder.getAlbumFiles());
    }

    @Override // com.yanzhenjie.fragment.a
    public void onFragmentResult(int i, int i2, @Nullable Bundle bundle) {
        switch (i) {
            case 100:
                showAlbumFileFromFolder(this.mCurrentFolder);
                setCheckedCountUI(this.mCheckedList.size());
                if (i2 == -1) {
                    onAlbumResult();
                    return;
                }
                return;
            case 101:
                if (i2 == -1) {
                    String parseImagePath = AlbumNullFragment.parseImagePath(bundle);
                    String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(parseImagePath));
                    if (!TextUtils.isEmpty(mimeTypeFromExtension)) {
                        this.mCameraAction.onAction(mimeTypeFromExtension.contains(MessengerShareContentUtility.MEDIA_IMAGE) ? 102 : 103, parseImagePath);
                        return;
                    }
                    return;
                }
                this.mCallback.onAlbumCancel();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFileToList(AlbumFile albumFile) {
        if (this.mCurrentFolder != 0) {
            ArrayList<AlbumFile> albumFiles = this.mAlbumFolders.get(0).getAlbumFiles();
            if (albumFiles.size() > 0) {
                albumFiles.add(0, albumFile);
            } else {
                albumFiles.add(albumFile);
            }
        }
        ArrayList<AlbumFile> albumFiles2 = this.mAlbumFolders.get(this.mCurrentFolder).getAlbumFiles();
        if (albumFiles2.size() > 0) {
            albumFiles2.add(0, albumFile);
            this.mAlbumContentAdapter.notifyItemInserted(this.mHasCamera ? 1 : 0);
        } else {
            albumFiles2.add(albumFile);
            this.mAlbumContentAdapter.notifyDataSetChanged();
        }
        switch (this.mChoiceMode) {
            case 2:
                onAlbumResult();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedCountUI(int i) {
        this.mBtnPreview.setText(" (" + i + ")");
        this.mToolbar.setSubtitle(i + "/" + this.mLimitCount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAlbumResult() {
        int i;
        int size = this.mAlbumFolders.get(0).getAlbumFiles().size();
        int size2 = this.mCheckedList.size();
        if (size > 0 && size2 == 0) {
            switch (this.mFunction) {
                case 0:
                    i = R.string.album_check_image_little;
                    break;
                case 1:
                    i = R.string.album_check_video_little;
                    break;
                default:
                    i = R.string.album_check_album_little;
                    break;
            }
            Toast.makeText(getContext(), i, 1).show();
        } else if (size2 == 0) {
            setResult(0);
            finish();
        } else {
            setResult(-1);
            this.mCallback.onAlbumResult(this.mCheckedList);
        }
    }
}
