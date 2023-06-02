package edu.hanu.app.facebook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import edu.hanu.app.R;

public class FBReactionDialog extends DialogFragment implements View.OnClickListener{

    View view;
    ImageView like_reaction_iv, love_reaction_iv, haha_reaction_iv,
            wow_reaction_iv, sad_reaction_iv,angry_reaction_iv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dialog_fb_reations, container, false);
        initializeComponents();
        return view;
    }

    private void initializeComponents(){

        if(getView()==null) {
            return;
        }

            like_reaction_iv = getView().findViewById(R.id.like_reaction_iv);
            love_reaction_iv = getView().findViewById(R.id.love_reaction_iv);
            haha_reaction_iv = getView().findViewById(R.id.haha_reaction_iv);
            wow_reaction_iv = getView().findViewById(R.id.wow_reaction_iv);
            sad_reaction_iv = getView().findViewById(R.id.sad_reaction_iv);
            angry_reaction_iv = getView().findViewById(R.id.angry_reaction_iv);

            like_reaction_iv.setOnClickListener(this);
            love_reaction_iv.setOnClickListener(this);
            haha_reaction_iv.setOnClickListener(this);
            wow_reaction_iv.setOnClickListener(this);
            sad_reaction_iv.setOnClickListener(this);
            angry_reaction_iv.setOnClickListener(this);
    }

    @Nullable
    @Override
    public View getView() {
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.like_reaction_iv:
                listener.onReactionSelected(0);
                getDialog().dismiss();
                break;

            case R.id.love_reaction_iv:
                listener.onReactionSelected(1);
                getDialog().dismiss();
                break;

            case R.id.haha_reaction_iv:
                listener.onReactionSelected(2);
                getDialog().dismiss();
                break;

            case R.id.wow_reaction_iv:
                listener.onReactionSelected(3);
                getDialog().dismiss();
                break;

            case R.id.sad_reaction_iv:
                listener.onReactionSelected(4);
                getDialog().dismiss();
                break;

            case R.id.angry_reaction_iv:
                listener.onReactionSelected(5);
                getDialog().dismiss();
                break;
        }
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(@NonNull Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        WindowManager.LayoutParams manager = new WindowManager.LayoutParams();
        manager.width =WindowManager.LayoutParams.MATCH_PARENT;
        manager.height = WindowManager.LayoutParams.WRAP_CONTENT;
        manager.dimAmount = 0.0f;
        dialog.getWindow().getDecorView().setBackground(getResources().getDrawable(android.R.color.transparent));
        dialog.setCanceledOnTouchOutside(true);
        dialog.onBackPressed();
    }

    ReactionsListener listener;

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        try {
            listener = (ReactionsListener) activity;
        } catch (ClassCastException exception) {
            throw new ClassCastException(activity.toString());
        }
    }
}
