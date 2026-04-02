package com.fotoable.youtube.music.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.aw;
import com.airbnb.lottie.bf;
import com.bumptech.glide.i;
import com.bumptech.glide.load.b.b;
import com.facebook.ads.AdError;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.UserDataStore;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.a;
import com.fotoable.youtube.music.bean.PlayMusicModel;
import com.fotoable.youtube.music.bean.PostBean;
import com.fotoable.youtube.music.ui.activity.CommunityPostDetailActivity;
import com.fotoable.youtube.music.ui.view.LaToTextView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import com.makeramen.roundedimageview.RoundedImageView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public class CommunityAdapter extends BaseAdapter<PostViewHolder> {
    private static final long TIME_DAY = 86400000;
    private static final long TIME_DAY_28 = 2419200000L;
    private static final long TIME_WEEK = 604800000;
    private static final long TIME_YEAR = 31536000000L;
    private static Context context;
    private LayoutInflater inflater;
    private OnItemClickListener onItemClickListener;
    private List<PostBean> postBeanList;

    /* loaded from: classes.dex */
    public interface OnItemClickListener {
        void onComment(PostBean postBean);

        void onDelete(String str);

        void onLike(String str);

        void onLongClick(String str);

        void onReport(String str);
    }

    /* loaded from: classes.dex */
    public class PostViewHolder_ViewBinding implements Unbinder {
        private PostViewHolder target;
        private View view2131820774;

        @UiThread
        public PostViewHolder_ViewBinding(final PostViewHolder postViewHolder, View view) {
            this.target = postViewHolder;
            postViewHolder.ivUserAvatar = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.iv_user_avatar, "field 'ivUserAvatar'", RoundedImageView.class);
            postViewHolder.tvUserName = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.tv_user_name, "field 'tvUserName'", LaToTextView.class);
            postViewHolder.tvPostTime = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.tv_post_time, "field 'tvPostTime'", LaToTextView.class);
            postViewHolder.tvPostContent = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.tv_post_content, "field 'tvPostContent'", LaToTextView.class);
            postViewHolder.rvPostImage = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_post_image, "field 'rvPostImage'", RecyclerView.class);
            postViewHolder.ivPostVideoCover = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_post_video_cover, "field 'ivPostVideoCover'", ImageView.class);
            postViewHolder.tvPostVideoTime = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.tv_post_video_time, "field 'tvPostVideoTime'", LaToTextView.class);
            postViewHolder.tvPostVideoTitle = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.tv_post_video_title, "field 'tvPostVideoTitle'", LaToTextView.class);
            postViewHolder.tvPostVideoArtists = (LaToTextView) Utils.findRequiredViewAsType(view, R.id.tv_post_video_artists, "field 'tvPostVideoArtists'", LaToTextView.class);
            View findRequiredView = Utils.findRequiredView(view, R.id.ll_post_video, "field 'llPostVideo' and method 'onViewClicked'");
            postViewHolder.llPostVideo = (RelativeLayout) Utils.castView(findRequiredView, R.id.ll_post_video, "field 'llPostVideo'", RelativeLayout.class);
            this.view2131820774 = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.CommunityAdapter.PostViewHolder_ViewBinding.1
                @Override // butterknife.internal.DebouncingOnClickListener
                public void doClick(View view2) {
                    postViewHolder.onViewClicked();
                }
            });
            postViewHolder.gap_view = Utils.findRequiredView(view, R.id.gap_view, "field 'gap_view'");
            postViewHolder.tvPostLikeCount = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_post_like_count, "field 'tvPostLikeCount'", TextView.class);
            postViewHolder.tvPostCommentCount = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_post_comment_count, "field 'tvPostCommentCount'", TextView.class);
            postViewHolder.ll_post_like = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_post_like, "field 'll_post_like'", LinearLayout.class);
            postViewHolder.iv_post_like = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_post_like, "field 'iv_post_like'", ImageView.class);
            postViewHolder.ll_post_comment = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_post_comment, "field 'll_post_comment'", LinearLayout.class);
            postViewHolder.ll_post_delete_report = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_post_delete_report, "field 'll_post_delete_report'", LinearLayout.class);
            postViewHolder.iv_delete_report = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_delete_report, "field 'iv_delete_report'", ImageView.class);
            postViewHolder.tv_delete_report = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_delete_report, "field 'tv_delete_report'", TextView.class);
            postViewHolder.lav_like_anim = (LottieAnimationView) Utils.findRequiredViewAsType(view, R.id.lav_like_anim, "field 'lav_like_anim'", LottieAnimationView.class);
            postViewHolder.iv_vip_mark_icon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_vip_mark_icon, "field 'iv_vip_mark_icon'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            PostViewHolder postViewHolder = this.target;
            if (postViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            postViewHolder.ivUserAvatar = null;
            postViewHolder.tvUserName = null;
            postViewHolder.tvPostTime = null;
            postViewHolder.tvPostContent = null;
            postViewHolder.rvPostImage = null;
            postViewHolder.ivPostVideoCover = null;
            postViewHolder.tvPostVideoTime = null;
            postViewHolder.tvPostVideoTitle = null;
            postViewHolder.tvPostVideoArtists = null;
            postViewHolder.llPostVideo = null;
            postViewHolder.gap_view = null;
            postViewHolder.tvPostLikeCount = null;
            postViewHolder.tvPostCommentCount = null;
            postViewHolder.ll_post_like = null;
            postViewHolder.iv_post_like = null;
            postViewHolder.ll_post_comment = null;
            postViewHolder.ll_post_delete_report = null;
            postViewHolder.iv_delete_report = null;
            postViewHolder.tv_delete_report = null;
            postViewHolder.lav_like_anim = null;
            postViewHolder.iv_vip_mark_icon = null;
            this.view2131820774.setOnClickListener(null);
            this.view2131820774 = null;
        }
    }

    public CommunityAdapter(Context context2) {
        context = context2;
        this.inflater = LayoutInflater.from(context);
        this.postBeanList = new ArrayList();
    }

    @Override // com.fotoable.youtube.music.ui.adapter.BaseAdapter
    public void onDestroy() {
        context = null;
        this.inflater = null;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public PostViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new PostViewHolder(this.inflater.inflate(R.layout.view_holder_community_post, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(final PostViewHolder postViewHolder, int i) {
        final PostBean postBean = this.postBeanList.get(i);
        if (postBean != null) {
            if (postBean.getUserInfo() != null && postBean.getUserInfo().getData() != null) {
                i.c(context).a(postBean.getUserInfo().getData().getAvatar()).d((int) R.drawable.user_avatar_def).c((int) R.drawable.user_avatar_def).b(b.ALL).i().a(postViewHolder.ivUserAvatar);
                postViewHolder.tvUserName.setText(postBean.getUserInfo().getData().getName() + "");
                if (TextUtils.equals(postBean.getUserInfo().getData().getUid(), MusicApplication.c().h().getUid())) {
                    postViewHolder.ll_post_delete_report.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.CommunityAdapter.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (CommunityAdapter.this.onItemClickListener != null) {
                                CommunityAdapter.this.onItemClickListener.onDelete(postBean.getBigId());
                            }
                        }
                    });
                    postViewHolder.iv_delete_report.setImageResource(R.drawable.icon_community_delete);
                    postViewHolder.tv_delete_report.setText(R.string.delete);
                    if (a.h() || com.fotoable.youtube.music.util.a.a()) {
                        postViewHolder.iv_vip_mark_icon.setVisibility(0);
                    } else {
                        postViewHolder.iv_vip_mark_icon.setVisibility(8);
                    }
                } else {
                    postViewHolder.ll_post_delete_report.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.CommunityAdapter.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (CommunityAdapter.this.onItemClickListener != null) {
                                CommunityAdapter.this.onItemClickListener.onReport(postBean.getBigId());
                            }
                        }
                    });
                    postViewHolder.iv_delete_report.setImageResource(R.drawable.icon_report);
                    postViewHolder.tv_delete_report.setText(R.string.report);
                    if (postBean.getUserInfo().getData().isVip()) {
                        postViewHolder.iv_vip_mark_icon.setVisibility(0);
                    } else {
                        postViewHolder.iv_vip_mark_icon.setVisibility(8);
                    }
                }
            } else {
                postViewHolder.iv_vip_mark_icon.setVisibility(8);
            }
            postViewHolder.tvPostTime.setText(formatCommentTime(postBean.getCreatedAt()) + "");
            if (!TextUtils.isEmpty(postBean.getBody())) {
                postViewHolder.tvPostContent.setText(postBean.getBody() + "");
                postViewHolder.tvPostContent.setVisibility(0);
            } else {
                postViewHolder.tvPostContent.setVisibility(8);
            }
            if (postBean.getImgUrl() != null && postBean.getImgUrl().size() > 0) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < postBean.getImgUrl().size(); i2++) {
                    arrayList.add(postBean.getImgUrl().get(i2).getThumbUrl());
                    arrayList2.add(postBean.getImgUrl().get(i2).getImgUrl());
                }
                postViewHolder.rvPostImage.setFocusableInTouchMode(false);
                postViewHolder.rvPostImage.setAdapter(new PostImageNineSpaceAdapter(context, arrayList, arrayList2));
                postViewHolder.rvPostImage.setVisibility(0);
            } else {
                postViewHolder.rvPostImage.setVisibility(8);
                postViewHolder.rvPostImage.removeAllViews();
            }
            if (!TextUtils.isEmpty(postBean.getVideoId())) {
                i.c(context).a(postBean.getVideoImgUrl()).d((int) R.mipmap.pic_recently).c((int) R.mipmap.pic_recently).b(b.ALL).a(postViewHolder.ivPostVideoCover);
                postViewHolder.tvPostVideoTitle.setText(postBean.getVideoTitle() + "");
                if (!TextUtils.isEmpty(postBean.getVideoArtists())) {
                    postViewHolder.tvPostVideoArtists.setText(postBean.getVideoArtists() + "");
                    postViewHolder.tvPostVideoArtists.setVisibility(0);
                    postViewHolder.tvPostVideoTitle.setMaxLines(1);
                } else {
                    postViewHolder.tvPostVideoArtists.setVisibility(8);
                    postViewHolder.tvPostVideoTitle.setMaxLines(2);
                }
                postViewHolder.llPostVideo.setVisibility(0);
                postViewHolder.llPostVideo.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.CommunityAdapter.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PlayMusicModel playMusicModel = new PlayMusicModel();
                        playMusicModel.setVideoId(postBean.getVideoId());
                        playMusicModel.setDuration(postBean.getVideoDuration());
                        playMusicModel.setCoverImg(postBean.getVideoImgUrl());
                        playMusicModel.setArtists(postBean.getVideoArtists());
                        playMusicModel.setTitle(postBean.getVideoTitle());
                        ArrayList arrayList3 = new ArrayList(1);
                        arrayList3.add(playMusicModel);
                        com.fotoable.youtube.music.e.b.a().a(new com.fotoable.youtube.music.e.a((int) AdError.INTERNAL_ERROR_CODE, arrayList3, 0));
                    }
                });
            } else {
                postViewHolder.llPostVideo.setVisibility(8);
            }
            if (postBean.getCounter() != null && postBean.getCounter().getData() != null) {
                if (postBean.getCounter().getData().getComments_like_count() != 0) {
                    postViewHolder.tvPostLikeCount.setText(postBean.getCounter().getData().getComments_like_count() + "");
                } else {
                    postViewHolder.tvPostLikeCount.setText(R.string.like);
                }
                if (postBean.getCounter().getData().getCommentsCount() != 0) {
                    postViewHolder.tvPostCommentCount.setText(postBean.getCounter().getData().getCommentsCount() + "");
                } else {
                    postViewHolder.tvPostCommentCount.setText(R.string.comment);
                }
            } else {
                postViewHolder.tvPostLikeCount.setText(R.string.like);
                postViewHolder.tvPostCommentCount.setText(R.string.comment);
            }
            if (postBean.isLike()) {
                postViewHolder.iv_post_like.setImageLevel(1);
                postViewHolder.tvPostLikeCount.setTextColor(context.getResources().getColor(R.color.color_ff2d55));
            } else {
                postViewHolder.tvPostLikeCount.setTextColor(context.getResources().getColor(R.color.color_9b9b9b));
                postViewHolder.iv_post_like.setImageLevel(0);
            }
            postViewHolder.rvPostImage.setNestedScrollingEnabled(false);
            postViewHolder.rvPostImage.setOnTouchListener(new View.OnTouchListener() { // from class: com.fotoable.youtube.music.ui.adapter.CommunityAdapter.4
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case 0:
                        case 2:
                        default:
                            return false;
                        case 1:
                            Intent intent = new Intent(CommunityAdapter.context, CommunityPostDetailActivity.class);
                            intent.putExtra("post", postBean);
                            ((Activity) CommunityAdapter.context).startActivityForResult(intent, AdError.MEDIATION_ERROR_CODE);
                            return false;
                    }
                }
            });
            postViewHolder.rvPostImage.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.CommunityAdapter.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = new Intent(CommunityAdapter.context, CommunityPostDetailActivity.class);
                    intent.putExtra("post", postBean);
                    ((Activity) CommunityAdapter.context).startActivityForResult(intent, AdError.MEDIATION_ERROR_CODE);
                }
            });
            postViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.CommunityAdapter.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = new Intent(CommunityAdapter.context, CommunityPostDetailActivity.class);
                    intent.putExtra("post", postBean);
                    ((Activity) CommunityAdapter.context).startActivityForResult(intent, AdError.MEDIATION_ERROR_CODE);
                }
            });
            postViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.CommunityAdapter.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (CommunityAdapter.this.onItemClickListener != null) {
                        CommunityAdapter.this.onItemClickListener.onLongClick(postBean.getBigId());
                        return true;
                    }
                    return true;
                }
            });
            if (!postBean.isLike()) {
                postViewHolder.lav_like_anim.setVisibility(4);
                postViewHolder.iv_post_like.setVisibility(0);
                postViewHolder.ll_post_like.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.CommunityAdapter.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!postBean.isLike()) {
                            postViewHolder.iv_post_like.setVisibility(4);
                            postViewHolder.lav_like_anim.setVisibility(0);
                            try {
                                postViewHolder.lav_like_anim.d();
                                postViewHolder.lav_like_anim.clearAnimation();
                                postViewHolder.lav_like_anim.setProgress(0.0f);
                            } catch (Exception e) {
                                ThrowableExtension.printStackTrace(e);
                            }
                            CommunityAdapter.this.setComposition("post_like.json", postViewHolder.lav_like_anim);
                            if (CommunityAdapter.this.onItemClickListener != null) {
                                CommunityAdapter.this.onItemClickListener.onLike(postBean.getBigId());
                            }
                            if (postBean.getCounter() != null && postBean.getCounter().getData() != null) {
                                postBean.setLike(true);
                                postViewHolder.iv_post_like.setImageLevel(1);
                                postViewHolder.tvPostLikeCount.setTextColor(CommunityAdapter.context.getResources().getColor(R.color.color_ff2d55));
                                postBean.getCounter().getData().setComments_like_count(postBean.getCounter().getData().getComments_like_count() + 1);
                                if (postBean.getCounter() != null && postBean.getCounter().getData() != null && postBean.getCounter().getData().getComments_like_count() > 0) {
                                    postViewHolder.tvPostLikeCount.setText(postBean.getCounter().getData().getComments_like_count() + "");
                                } else {
                                    postViewHolder.tvPostLikeCount.setText(R.string.like);
                                }
                            }
                        }
                    }
                });
            } else {
                postViewHolder.ll_post_like.setOnClickListener(null);
                postViewHolder.lav_like_anim.setVisibility(4);
                postViewHolder.iv_post_like.setVisibility(0);
            }
            postViewHolder.ll_post_comment.setOnClickListener(new View.OnClickListener() { // from class: com.fotoable.youtube.music.ui.adapter.CommunityAdapter.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (CommunityAdapter.this.onItemClickListener != null) {
                        CommunityAdapter.this.onItemClickListener.onComment(postBean);
                    }
                }
            });
        }
        if (i == getItemCount() - 1) {
            postViewHolder.gap_view.setVisibility(8);
        } else {
            postViewHolder.gap_view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setComposition(String str, final LottieAnimationView lottieAnimationView) {
        aw.a.a(context, str, new bf() { // from class: com.fotoable.youtube.music.ui.adapter.CommunityAdapter.10
            @Override // com.airbnb.lottie.bf
            public void onCompositionLoaded(aw awVar) {
                if (lottieAnimationView != null) {
                    lottieAnimationView.setComposition(awVar);
                    lottieAnimationView.c();
                }
            }
        });
    }

    public void likePost(String str) {
        if (this.postBeanList != null && this.postBeanList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.postBeanList.size()) {
                    if (this.postBeanList.get(i2) == null || !TextUtils.equals(this.postBeanList.get(i2).getBigId(), str)) {
                        i = i2 + 1;
                    } else if (this.postBeanList.get(i2).getCounter() != null && this.postBeanList.get(i2).getCounter().getData() != null) {
                        this.postBeanList.get(i2).getCounter().getData().setComments_like_count(this.postBeanList.get(i2).getCounter().getData().getComments_like_count() + 1);
                        this.postBeanList.get(i2).setLike(true);
                        notifyDataSetChanged();
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void deletePost(String str) {
        if (this.postBeanList != null && this.postBeanList.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.postBeanList.size()) {
                    if (this.postBeanList.get(i2) == null || !TextUtils.equals(this.postBeanList.get(i2).getBigId(), str)) {
                        i = i2 + 1;
                    } else {
                        this.postBeanList.remove(i2);
                        notifyDataSetChanged();
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void addPost(PostBean postBean) {
        if (postBean != null && this.postBeanList != null) {
            this.postBeanList.add(0, postBean);
            notifyDataSetChanged();
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public static String formatCommentTime(long j) {
        Date date = new Date(j);
        long abs = Math.abs(System.currentTimeMillis() - date.getTime());
        if (abs < TIME_DAY) {
            return new SimpleDateFormat("HH:mm").format(date);
        }
        if (abs >= TIME_DAY && abs < TIME_WEEK) {
            return (abs / TIME_DAY) + "" + MusicApplication.c().getResources().getString(R.string.days_ago);
        }
        if (abs >= TIME_WEEK && abs <= TIME_DAY_28) {
            return (abs / TIME_WEEK) + "" + MusicApplication.c().getResources().getString(R.string.weeks_ago);
        }
        if (abs > TIME_DAY_28 && abs < TIME_YEAR) {
            if (a.a()) {
                return new SimpleDateFormat("MMMMMM dd").format(date) + "" + getEnglishSuffix(date);
            }
            return new SimpleDateFormat("MM-dd").format(date) + "";
        }
        return (abs / TIME_YEAR) + "" + context.getResources().getString(R.string.years_ago);
    }

    private static String getEnglishSuffix(Date date) {
        int day = date.getDay();
        String str = day + "";
        if (str.endsWith(AppEventsConstants.EVENT_PARAM_VALUE_YES) && day != 11) {
            return UserDataStore.STATE;
        }
        if (str.endsWith("2") && day != 12) {
            return "nd";
        }
        if (str.endsWith("3") && day != 13) {
            return "rd";
        }
        return "th";
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.postBeanList != null) {
            return this.postBeanList.size();
        }
        return 0;
    }

    public void showPostList(boolean z, List<PostBean> list) {
        if (z) {
            this.postBeanList.clear();
        }
        if (list != null) {
            this.postBeanList.addAll(list);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class PostViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.gap_view)
        View gap_view;
        @BindView(R.id.iv_post_video_cover)
        ImageView ivPostVideoCover;
        @BindView(R.id.iv_user_avatar)
        RoundedImageView ivUserAvatar;
        @BindView(R.id.iv_delete_report)
        ImageView iv_delete_report;
        @BindView(R.id.iv_post_like)
        ImageView iv_post_like;
        @BindView(R.id.iv_vip_mark_icon)
        ImageView iv_vip_mark_icon;
        @BindView(R.id.lav_like_anim)
        LottieAnimationView lav_like_anim;
        @BindView(R.id.ll_post_video)
        RelativeLayout llPostVideo;
        @BindView(R.id.ll_post_comment)
        LinearLayout ll_post_comment;
        @BindView(R.id.ll_post_delete_report)
        LinearLayout ll_post_delete_report;
        @BindView(R.id.ll_post_like)
        LinearLayout ll_post_like;
        @BindView(R.id.rv_post_image)
        RecyclerView rvPostImage;
        @BindView(R.id.tv_post_comment_count)
        TextView tvPostCommentCount;
        @BindView(R.id.tv_post_content)
        LaToTextView tvPostContent;
        @BindView(R.id.tv_post_like_count)
        TextView tvPostLikeCount;
        @BindView(R.id.tv_post_time)
        LaToTextView tvPostTime;
        @BindView(R.id.tv_post_video_artists)
        LaToTextView tvPostVideoArtists;
        @BindView(R.id.tv_post_video_time)
        LaToTextView tvPostVideoTime;
        @BindView(R.id.tv_post_video_title)
        LaToTextView tvPostVideoTitle;
        @BindView(R.id.tv_user_name)
        LaToTextView tvUserName;
        @BindView(R.id.tv_delete_report)
        TextView tv_delete_report;

        public PostViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.rvPostImage.setLayoutManager(new GridLayoutManager(view.getContext(), 3));
            this.rvPostImage.addItemDecoration(new GridSpacingItemDecoration(3, (int) (view.getContext().getResources().getDisplayMetrics().density * 2.0f), false));
        }

        @OnClick({R.id.ll_post_video})
        public void onViewClicked() {
        }
    }
}
