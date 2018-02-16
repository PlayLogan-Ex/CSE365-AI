package com.signoffour.apps.controlcommentview.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by User on 8/15/2017.
 */
public class Answer implements Parcelable{
    private int answerID;
    private String answererName;
    private String answerTime;
    private String answerText;


    private List<Comment> commentList;

    public Answer(Parcel in) {
        answerID = in.readInt();
        answererName = in.readString();
        answerTime = in.readString();
        answerText = in.readString();
    }

    public static final Creator<Answer> CREATOR = new Creator<Answer>() {
        @Override
        public Answer createFromParcel(Parcel in) {
            return new Answer(in);
        }

        @Override
        public Answer[] newArray(int size) {
            return new Answer[size];
        }
    };

    public Answer() {

    }

    public int getAnswerID() {
        return answerID;
    }
    public void setAnswerID(int answerID) {
        this.answerID = answerID;
    }

    public String getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(String answerTime) {
        this.answerTime = answerTime;
    }
    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public String getAnswererName() {
        return answererName;
    }

    public void setAnswererName(String answererName) {
        this.answererName = answererName;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeInt(answerID);
        parcel.writeString(answererName);
        parcel.writeString(answerTime);
        parcel.writeString(answerText);
    }

    public static class Comment {
        private int commentId;
        private String commentText;
        private String commenterName;
        private String commentTime;
        private int totalThumbUp;
        private int totalThumbDown;

        public int getTotalThumbUp() {
            return totalThumbUp;
        }

        public void setTotalThumbUp(int totalThumbUp) {
            this.totalThumbUp = totalThumbUp;
        }

        public int getTotalThumbDown() {
            return totalThumbDown;
        }

        public void setTotalThumbDown(int totalThumbDown) {
            this.totalThumbDown = totalThumbDown;
        }


        public String getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(String commentTime) {
            this.commentTime = commentTime;
        }



        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public String getCommentText() {
            return commentText;
        }

        public void setCommentText(String commentText) {
            this.commentText = commentText;
        }

        public String getCommenterName() {
            return commenterName;
        }
        public void setCommenterName(String commenterName) {
            this.commenterName = commenterName;
        }
    }
}
