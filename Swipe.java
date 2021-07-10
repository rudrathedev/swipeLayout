package com.kab.Swipe;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.daimajia.swipe.SwipeLayout;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.AndroidViewComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.YailList;
import com.google.appinventor.components.common.ComponentCategory;

@DesignerComponent(
    iconName = "",
    description = "",
    version = 1,
    category = ComponentCategory.EXTENSION,
    nonVisible = true
)
@SimpleObject(external = true)

public class SwipeLayoutAndroid extends AndroidNonvisibleComponent {
    private ComponentContainer container ;
    private Context context;

  public SwipeLayoutAndroid(ComponentContainer container) {
    super(container.$form());
  }
  @SimpleFunction
  public void Do(AndroidViewComponent bottomView , AndroidViewComponent surfaceView){
      SwipeLayout swipeLayout = new SwipeLayout(container.$context());

      LinearLayout linearLayoutForBottomView = (LinearLayout) bottomView.getView();
      LinearLayout linearLayoutForSurfaceView = (LinearLayout) surfaceView.getView();
      swipeLayout.addView(linearLayoutForBottomView , 0);
      swipeLayout.addView(linearLayoutForSurfaceView , 1 );

      // Now we do have both bottom view and surface view
      // This is layDown , we can also switch to another mode

      swipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown );

      // Adding dragEdge either left , right , buttom or top
      //

      swipeLayout.setDragEdge(SwipeLayout.DragEdge.Left);

      swipeLayout.addSwipeListener(new SwipeLayout.SwipeListener() {
          @Override
          public void onStartOpen(SwipeLayout swipeLayout) {

          }

          @Override
          public void onOpen(SwipeLayout swipeLayout) {

          }

          @Override
          public void onStartClose(SwipeLayout swipeLayout) {

          }

          @Override
          public void onClose(SwipeLayout swipeLayout) {

          }

          @Override
          public void onUpdate(SwipeLayout swipeLayout, int i, int i1) {

          }

          @Override
          public void onHandRelease(SwipeLayout swipeLayout, float v, float v1) {

          }
      });


  }


}
