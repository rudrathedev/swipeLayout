package com.kab.Swipe;

import android.app.Activity;
import android.content.Context;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.appinventor.components.annotations.*;
import android.widget.FrameLayout;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.*;
import com.daimajia.swipe.*;


@DesignerComponent(
        version = 1,
        description = "",
        category = ComponentCategory.EXTENSION,
        nonVisible = true,
        iconName = "")

@SimpleObject(external = true)
//Libraries
@UsesLibraries(libraries = "AndroidSwipeLayout-v1.1.8.jar, recyclerview.jar")

public class Swipe extends AndroidNonvisibleComponent {

    private Context context;
    private Activity activity;
    private SwipeLayout swipeLayout;
    private String showMode;
        
    public Swipe(ComponentContainer container){
        super(container.$form());
        this.activity = container.$context();
        this.context = container.$context();
        this.showMode = "PullOut";
    }
 @SimpleProperty
 public void ShowMode(String showModeVal){
         this.showMode = showModeVal;
 }
 @SimpleFunction
 public String PullOut(){
         return "PullOut";
 }
 @SimpleFunction
 public String LayDown(){
         return "LayDown";
 }

@SimpleFunction()
public void SetupSwipeLayout(AndroidViewComponent swipeLayoutView){
 this.swipeLayout = new SwipeLayout(this.context);
FrameLayout haha = (FrameLayout) swipeLayoutView.getView();
haha.addView(swipeLayout, new FrameLayout.LayoutParams(-1, -1));
        //Set Show mode accepts ShowMode which can be either PullOut or Lay Down
        if(this.showMode == "LayDown"){
        swipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);
        }else{
        swipeLayout.setShowMode(SwipeLayout.ShowMode.PullOut);
        }

swipeLayout.addSwipeListener(new SwipeLayout.SwipeListener() {
            @Override
            public void onClose(SwipeLayout layout) {
                LayoutClosed();
            }

            @Override
            public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {
              LayoutUpdated();
            }

            @Override
            public void onStartOpen(SwipeLayout layout) {
            LayoutStartedOpening();
            }

            @Override
            public void onOpen(SwipeLayout layout) {
               SwipeLayoutOpened();
            }

            @Override
            public void onStartClose(SwipeLayout layout) {
            StartedClosing();
            }

            @Override
            public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {
              HandReleased();
            }
        });
    }
    @SimpleFunction()
    public void AddAdapter(AndroidViewComponent swipeLayoutAdapter){
View adapter = (View) swipeLayoutAdapter.getView();

this.swipeLayout.addDrag(SwipeLayout.DragEdge.Left, (View) adapter.getChildAt(0));
adapter.addView(swipeLayout, new FrameLayout.LayoutParams(-1, -1));
    }

    @SimpleEvent()
    public void LayoutClosed(){
        EventDispatcher.dispatchEvent(this, "LayoutClosed");
    }
    @SimpleEvent()
    public void LayoutUpdated(){
        EventDispatcher.dispatchEvent(this, "LayoutUpdated");
    }
    @SimpleEvent()
    public void LayoutStartedOpening(){
        EventDispatcher.dispatchEvent(this, "LayoutStartedOpening");
    }
    @SimpleEvent()
    public void SwipeLayoutOpened(){
        EventDispatcher.dispatchEvent(this, "SwipeLayoutOpened");
    }
    @SimpleEvent()
    public void StartedClosing(){
        EventDispatcher.dispatchEvent(this, "StartedClosing");
    }
    @SimpleEvent()
    public void HandReleased(){
        EventDispatcher.dispatchEvent(this, "HandReleased");
    }
}
