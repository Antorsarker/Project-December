package com.example.projectdecember;


import android.view.View;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

public class BottomNavigationBehavior extends CoordinatorLayout.Behavior<BottomNavigationView> {


    private int height;

    @Override
    public boolean onLayoutChild(@NonNull CoordinatorLayout parent, @NonNull BottomNavigationView child, int layoutDirection) {
        height=child.getHeight();
        return super.onLayoutChild(parent, child, layoutDirection);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout,
                                       @NonNull BottomNavigationView child,
                                       @NonNull View directTargetChild, @NonNull View target,
                                       int axes, int type) {

        return axes== ViewCompat.SCROLL_AXIS_VERTICAL;
    }

    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomNavigationView child,
                               @NonNull View target, int dxConsumed, int dyConsumed,
                               int dxUnconsumed, int dyUnconsumed,
                               int type) {

        if (dyConsumed>0){
            slideDown(child);
        }
        else if (dyConsumed <0){
            slideUp(child);
        }
    }

    private void slideUp(BottomNavigationView child) {

        child.clearAnimation();
        child.animate().translationY(0).setDuration(100);

    }

    private void slideDown(BottomNavigationView child) {
        child.clearAnimation();
        child.animate().translationY(height).setDuration(100);

    }




}
