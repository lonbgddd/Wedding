package com.example.wedding;

import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {


    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public void replaceFragment(Fragment fragment) {
        getParentFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left,
                R.anim.slide_out_right).replace(R.id.fade_control, fragment).addToBackStack(null).commit();
    }

    abstract public void loadData();

    abstract public void listening();
    public void backStack() {
        getParentFragmentManager().popBackStack();
    }
}
