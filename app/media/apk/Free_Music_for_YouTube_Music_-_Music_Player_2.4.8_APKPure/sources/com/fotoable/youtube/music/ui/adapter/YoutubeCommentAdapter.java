package com.fotoable.youtube.music.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.aw;
import com.airbnb.lottie.bf;
import com.bumptech.glide.i;
import com.bumptech.glide.load.b.b;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.UserDataStore;
import com.fotoable.free.music.R;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.a;
import com.fotoable.youtube.music.bean.UserInfoModel;
import com.fotoable.youtube.music.bean.YoutubeComment;
import com.fotoable.youtube.music.ui.adapter.YoutubeCommentAdapter;
import com.fotoable.youtube.music.util.h;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public class YoutubeCommentAdapter extends BaseAdapter<CommentViewHolder> {
    private static final long TIME_DAY = 86400000;
    private static final long TIME_DAY_28 = 2419200000L;
    private static final long TIME_WEEK = 604800000;
    private static final long TIME_YEAR = 31536000000L;
    private Context context;
    private LayoutInflater inflater;
    private OnClickCommentListener onClickCommentListener;
    private List<YoutubeComment> youtubeCommentList;

    /* loaded from: classes.dex */
    public interface OnClickCommentListener {
        void onClickComment(int i, String str, String str2, String str3, String str4, UserInfoModel userInfoModel, String str5);

        void onClickLike(String str);
    }

    public YoutubeCommentAdapter(Context context, List<YoutubeComment> list) {
        this.context = context;
        this.inflater = LayoutInflater.from(this.context);
        this.youtubeCommentList = list;
    }

    public void setYoutubeCommentList(List<YoutubeComment> list) {
        this.youtubeCommentList = list;
        notifyDataSetChanged();
    }

    public void addYoutubeCommentList(List<YoutubeComment> list) {
        if (this.youtubeCommentList == null) {
            this.youtubeCommentList = list;
        } else {
            this.youtubeCommentList.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // com.fotoable.youtube.music.ui.adapter.BaseAdapter
    public void onDestroy() {
        this.context = null;
        this.inflater = null;
        this.youtubeCommentList = null;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public CommentViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new CommentViewHolder(this.inflater.inflate(R.layout.view_holder_comment, viewGroup, false)) : new CommentViewHolder(this.inflater.inflate(R.layout.view_holder_comment_reply, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        YoutubeComment youtubeComment = this.youtubeCommentList.get(i);
        if (youtubeComment != null) {
            if (youtubeComment.getIsReplyComment() == 0) {
                return 1;
            }
            return 2;
        }
        return super.getItemViewType(i);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(final CommentViewHolder commentViewHolder, int i) {
        try {
            final int itemViewType = getItemViewType(i);
            final YoutubeComment youtubeComment = this.youtubeCommentList.get(i);
            if (youtubeComment != null) {
                if (youtubeComment.getUserInfo() != null && youtubeComment.getUserInfo().getData() != null) {
                    i.c(this.context).a(youtubeComment.getUserInfo().getData().getAvatar()).d((int) R.drawable.user_avatar_def).c((int) R.drawable.user_avatar_def).b(b.ALL).i().a(commentViewHolder.user_avatar);
                    if (MusicApplication.c().h() != null) {
                        if (TextUtils.equals(youtubeComment.getUserInfo().getData().getUid(), MusicApplication.c().h().getUid())) {
                            if (MusicApplication.c().h() != null) {
                                if (TextUtils.equals(youtubeComment.getUserInfo().getData().getUid(), MusicApplication.c().h().getUid())) {
                                    if (a.h() || com.fotoable.youtube.music.util.a.a()) {
                                        commentViewHolder.iv_vip_mark_icon.setVisibility(0);
                                    } else {
                                        commentViewHolder.iv_vip_mark_icon.setVisibility(8);
                                    }
                                } else if (youtubeComment.getUserInfo().getData().isVip()) {
                                    commentViewHolder.iv_vip_mark_icon.setVisibility(0);
                                } else {
                                    commentViewHolder.iv_vip_mark_icon.setVisibility(8);
                                }
                            } else if (youtubeComment.getUserInfo().getData().isVip()) {
                                commentViewHolder.iv_vip_mark_icon.setVisibility(0);
                            } else {
                                commentViewHolder.iv_vip_mark_icon.setVisibility(8);
                            }
                        } else if (youtubeComment.getUserInfo().getData().isVip()) {
                            commentViewHolder.iv_vip_mark_icon.setVisibility(0);
                        } else {
                            commentViewHolder.iv_vip_mark_icon.setVisibility(8);
                        }
                    } else if (youtubeComment.getUserInfo().getData().isVip()) {
                        commentViewHolder.iv_vip_mark_icon.setVisibility(0);
                    } else {
                        commentViewHolder.iv_vip_mark_icon.setVisibility(8);
                    }
                } else {
                    i.c(this.context).a(Integer.valueOf((int) R.drawable.user_avatar_def)).d((int) R.drawable.user_avatar_def).c((int) R.drawable.user_avatar_def).b(b.ALL).i().a(commentViewHolder.user_avatar);
                    commentViewHolder.iv_vip_mark_icon.setVisibility(8);
                }
                if (youtubeComment.getUserInfo() != null && youtubeComment.getUserInfo().getData() != null) {
                    commentViewHolder.user_name.setText(youtubeComment.getUserInfo().getData().getName() + "");
                }
                commentViewHolder.comment_time.setText(formatCommentTime(youtubeComment.getCreatedAt()) + "");
                commentViewHolder.comment_like.setImageLevel(youtubeComment.isLike() ? 1 : 0);
                if (youtubeComment.isLike()) {
                    commentViewHolder.comment_like_count.setTextColor(this.context.getResources().getColor(R.color.color_ff2d55));
                } else {
                    commentViewHolder.comment_like_count.setTextColor(this.context.getResources().getColor(R.color.color_9b9b9b));
                }
                if (youtubeComment.getCounter() != null && youtubeComment.getCounter().getData() != null && youtubeComment.getCounter().getData().getComments_like_count() > 0) {
                    commentViewHolder.comment_like_count.setText(youtubeComment.getCounter().getData().getComments_like_count() + "");
                    commentViewHolder.comment_like_count.setVisibility(0);
                } else {
                    commentViewHolder.comment_like_count.setVisibility(8);
                }
                if (itemViewType == 1) {
                    commentViewHolder.comment_content.setText(youtubeComment.getBody() + "");
                    setUrlClick(commentViewHolder.comment_content);
                } else {
                    commentViewHolder.reply_comment_content.setText(youtubeComment.getBody() + "");
                    setUrlClick(commentViewHolder.reply_comment_content);
                    if (youtubeComment.getReUserInfo() != null && youtubeComment.getReUserInfo().getData() != null) {
                        String str = "@" + youtubeComment.getReUserInfo().getData().getName();
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + ":  " + (TextUtils.isEmpty(youtubeComment.getReBody()) ? this.context.getString(R.string.the_comment_does_not_exist) : youtubeComment.getReBody()));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.color.color_9b9b9b)), 0, str.length(), 33);
                        commentViewHolder.comment_content.setText(spannableStringBuilder);
                        setUrlClick(commentViewHolder.comment_content);
                    } else {
                        commentViewHolder.comment_content.setText("");
                    }
                }
                commentViewHolder.itemView.setOnClickListener(new View.OnClickListener(this, itemViewType, youtubeComment) { // from class: com.fotoable.youtube.music.ui.adapter.YoutubeCommentAdapter$$Lambda$0
                    private final YoutubeCommentAdapter arg$1;
                    private final int arg$2;
                    private final YoutubeComment arg$3;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.arg$1 = this;
                        this.arg$2 = itemViewType;
                        this.arg$3 = youtubeComment;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        this.arg$1.lambda$onBindViewHolder$0$YoutubeCommentAdapter(this.arg$2, this.arg$3, view);
                    }
                });
                if (commentViewHolder.lav_like_anim.b()) {
                    commentViewHolder.lav_like_anim.d();
                    commentViewHolder.lav_like_anim.clearAnimation();
                }
                if (!youtubeComment.isLike()) {
                    commentViewHolder.lav_like_anim.setVisibility(4);
                    commentViewHolder.comment_like.setVisibility(0);
                    commentViewHolder.like_panel.setOnClickListener(new View.OnClickListener(this, youtubeComment, commentViewHolder) { // from class: com.fotoable.youtube.music.ui.adapter.YoutubeCommentAdapter$$Lambda$1
                        private final YoutubeCommentAdapter arg$1;
                        private final YoutubeComment arg$2;
                        private final YoutubeCommentAdapter.CommentViewHolder arg$3;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.arg$1 = this;
                            this.arg$2 = youtubeComment;
                            this.arg$3 = commentViewHolder;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            this.arg$1.lambda$onBindViewHolder$1$YoutubeCommentAdapter(this.arg$2, this.arg$3, view);
                        }
                    });
                    return;
                }
                commentViewHolder.like_panel.setOnClickListener(null);
                commentViewHolder.lav_like_anim.setVisibility(4);
                commentViewHolder.comment_like.setVisibility(0);
                return;
            }
            commentViewHolder.comment_like_count.setVisibility(8);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$onBindViewHolder$0$YoutubeCommentAdapter(int i, YoutubeComment youtubeComment, View view) {
        if (i == 1) {
            if (this.onClickCommentListener != null && youtubeComment.getUserInfo() != null && youtubeComment.getUserInfo().getData() != null) {
                this.onClickCommentListener.onClickComment(youtubeComment.getIsReplyComment(), youtubeComment.getCid(), youtubeComment.getUserInfo().getData().getUid(), youtubeComment.getUserInfo().getData().getName(), youtubeComment.getBody(), youtubeComment.getUserInfo().getData(), youtubeComment.getBody());
            }
        } else if (this.onClickCommentListener != null && youtubeComment.getUserInfo() != null && youtubeComment.getUserInfo().getData() != null) {
            this.onClickCommentListener.onClickComment(youtubeComment.getIsReplyComment(), youtubeComment.getCid(), youtubeComment.getUserInfo().getData().getUid(), youtubeComment.getUserInfo().getData().getName(), youtubeComment.getBody(), youtubeComment.getUserInfo().getData(), youtubeComment.getBody());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$onBindViewHolder$1$YoutubeCommentAdapter(YoutubeComment youtubeComment, CommentViewHolder commentViewHolder, View view) {
        if (!youtubeComment.isLike()) {
            if (this.onClickCommentListener != null) {
                this.onClickCommentListener.onClickLike(youtubeComment.getCid());
            }
            commentViewHolder.lav_like_anim.setVisibility(0);
            commentViewHolder.comment_like.setVisibility(8);
            try {
                commentViewHolder.lav_like_anim.d();
                commentViewHolder.lav_like_anim.clearAnimation();
                commentViewHolder.lav_like_anim.setProgress(0.0f);
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
            setComposition("post_like.json", commentViewHolder.lav_like_anim);
            youtubeComment.setLike(true);
            commentViewHolder.comment_like.setImageLevel(youtubeComment.isLike() ? 1 : 0);
            commentViewHolder.comment_like_count.setTextColor(this.context.getResources().getColor(R.color.color_ff2d55));
            if (youtubeComment.getCounter() != null && youtubeComment.getCounter().getData() != null) {
                commentViewHolder.comment_like_count.setVisibility(0);
                youtubeComment.getCounter().getData().setComments_like_count(youtubeComment.getCounter().getData().getComments_like_count() + 1);
                if (youtubeComment.getCounter() != null && youtubeComment.getCounter().getData() != null && youtubeComment.getCounter().getData().getComments_like_count() > 0) {
                    commentViewHolder.comment_like_count.setText(youtubeComment.getCounter().getData().getComments_like_count() + "");
                    commentViewHolder.comment_like_count.setVisibility(0);
                    return;
                }
                commentViewHolder.comment_like_count.setVisibility(8);
            }
        }
    }

    private void setComposition(String str, final LottieAnimationView lottieAnimationView) {
        aw.a.a(this.context, str, new bf() { // from class: com.fotoable.youtube.music.ui.adapter.YoutubeCommentAdapter.1
            @Override // com.airbnb.lottie.bf
            public void onCompositionLoaded(aw awVar) {
                if (lottieAnimationView != null) {
                    lottieAnimationView.setComposition(awVar);
                    lottieAnimationView.c();
                }
            }
        });
    }

    private void setUrlClick(TextView textView) {
        if (textView != null) {
            CharSequence text = textView.getText();
            if (!TextUtils.isEmpty(text) && (text instanceof Spannable)) {
                int length = text.length();
                Spannable spannable = (Spannable) textView.getText();
                URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, length, URLSpan.class);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
                for (final URLSpan uRLSpan : uRLSpanArr) {
                    spannableStringBuilder.removeSpan(uRLSpan);
                    spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.fotoable.youtube.music.ui.adapter.YoutubeCommentAdapter.2
                        @Override // android.text.style.ClickableSpan
                        public void onClick(View view) {
                            try {
                                h.a("qxs url", "click:" + uRLSpan.getURL());
                                Uri parse = Uri.parse(uRLSpan.getURL());
                                Intent createChooser = Intent.createChooser(new Intent("android.intent.action.VIEW", parse), YoutubeCommentAdapter.this.context.getString(R.string.open_with_browser));
                                if (createChooser != null) {
                                    createChooser.addFlags(268435456);
                                    YoutubeCommentAdapter.this.context.startActivity(createChooser);
                                    com.fotoable.youtube.music.util.b.b("在线音乐-评论界面-评论链接点击次数", "链接域名", "" + parse.getHost());
                                }
                            } catch (Exception e) {
                                ThrowableExtension.printStackTrace(e);
                            }
                        }
                    }, spannable.getSpanStart(uRLSpan), spannable.getSpanEnd(uRLSpan), 34);
                }
                textView.setText(spannableStringBuilder);
            }
        }
    }

    private String formatCommentTime(long j) {
        Date date = new Date(j);
        long abs = Math.abs(System.currentTimeMillis() - date.getTime());
        if (abs < TIME_DAY) {
            return new SimpleDateFormat("HH:mm").format(date);
        }
        if (abs >= TIME_DAY && abs < TIME_WEEK) {
            return (abs / TIME_DAY) + "" + this.context.getResources().getString(R.string.days_ago);
        }
        if (abs >= TIME_WEEK && abs <= TIME_DAY_28) {
            return (abs / TIME_WEEK) + "" + this.context.getResources().getString(R.string.weeks_ago);
        }
        if (abs > TIME_DAY_28 && abs < TIME_YEAR) {
            if (a.a()) {
                return new SimpleDateFormat("MMMMMM dd").format(date) + "" + getEnglishSuffix(date);
            }
            return new SimpleDateFormat("MM-dd").format(date) + "";
        }
        return (abs / TIME_YEAR) + "" + this.context.getResources().getString(R.string.years_ago);
    }

    private String getEnglishSuffix(Date date) {
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

    public void deleteComment(String str) {
        YoutubeComment commentByCid = getCommentByCid(str);
        if (commentByCid != null) {
            this.youtubeCommentList.remove(commentByCid);
            notifyDataSetChanged();
        }
    }

    public void reportComment(String str) {
    }

    public void likeComment(String str) {
    }

    private YoutubeComment getCommentByCid(String str) {
        if (TextUtils.isEmpty(str) || this.youtubeCommentList == null) {
            return null;
        }
        YoutubeComment youtubeComment = null;
        for (int i = 0; i < this.youtubeCommentList.size(); i++) {
            youtubeComment = this.youtubeCommentList.get(i);
            if (youtubeComment != null && TextUtils.equals(youtubeComment.getCid(), str)) {
                return youtubeComment;
            }
        }
        return youtubeComment;
    }

    public void addComment(YoutubeComment youtubeComment, boolean z) {
        if (this.youtubeCommentList == null) {
            this.youtubeCommentList = new ArrayList();
        }
        this.youtubeCommentList.add(0, youtubeComment);
        notifyDataSetChanged();
    }

    public void setOnClickCommentListener(OnClickCommentListener onClickCommentListener) {
        this.onClickCommentListener = onClickCommentListener;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.youtubeCommentList != null) {
            return this.youtubeCommentList.size();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class CommentViewHolder extends RecyclerView.ViewHolder {
        TextView comment_content;
        ImageView comment_like;
        TextView comment_like_count;
        TextView comment_time;
        ImageView iv_vip_mark_icon;
        LottieAnimationView lav_like_anim;
        RelativeLayout like_panel;
        TextView reply_comment_content;
        ImageView user_avatar;
        TextView user_name;

        public CommentViewHolder(View view) {
            super(view);
            this.user_avatar = (ImageView) view.findViewById(R.id.user_avatar);
            this.like_panel = (RelativeLayout) view.findViewById(R.id.like_panel);
            this.comment_like = (ImageView) view.findViewById(R.id.comment_like);
            this.user_name = (TextView) view.findViewById(R.id.user_name);
            this.comment_time = (TextView) view.findViewById(R.id.comment_time);
            this.comment_like_count = (TextView) view.findViewById(R.id.comment_like_count);
            this.comment_content = (TextView) view.findViewById(R.id.comment_content);
            this.lav_like_anim = (LottieAnimationView) view.findViewById(R.id.lav_like_anim);
            this.iv_vip_mark_icon = (ImageView) view.findViewById(R.id.iv_vip_mark_icon);
            if (view.findViewById(R.id.reply_comment_content) != null) {
                this.reply_comment_content = (TextView) view.findViewById(R.id.reply_comment_content);
            }
        }
    }
}
