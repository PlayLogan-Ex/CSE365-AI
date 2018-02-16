package com.signoffour.apps.controlcommentview;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class ViewAllCommentFragment extends Fragment {

    public ViewAllCommentFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Intent intent = getActivity().getIntent();

        return inflater.inflate(R.layout.fragment_view_all_comment, container, false);
    }
}
