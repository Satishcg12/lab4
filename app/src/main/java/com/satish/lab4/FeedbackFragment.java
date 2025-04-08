package com.satish.lab4;

import android.os.Bundle;
import android.view.*;
import androidx.fragment.app.Fragment;

public class FeedbackFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater,
                              ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_feedback, container, false);
    }
}