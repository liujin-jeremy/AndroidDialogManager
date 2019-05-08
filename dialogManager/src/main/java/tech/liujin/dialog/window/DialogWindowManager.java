package tech.liujin.dialog.window;

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import tech.liujin.dialog.R;

/**
 * @author Liujin 2019/5/8:10:50:02
 */
public class DialogWindowManager {

      public static void showActivityDialog ( Context context, final View view ) {

            showActivityDialog( context, view, Gravity.TOP, R.style.windowDialogAnim, 2000 );
      }

      public static void showActivityDialog (
          Context context, final View view, int gravity, int animStyle, int dismissDelayMill ) {

            LayoutParams layoutParams = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT,
                0,
                0,
                PixelFormat.TRANSPARENT
            );

            layoutParams.flags = LayoutParams.FLAG_NOT_TOUCH_MODAL |
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |// 不获取焦点，以便于在弹出的时候 下层界面仍然可以进行操作
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN |
                WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR; // 确保你的内容不会被装饰物(如状态栏)掩盖.
            // popWindow的层级为 TYPE_APPLICATION_PANEL
            layoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_SUB_PANEL;

            // 显示位置
            layoutParams.gravity = gravity;
            // 动画效果
            layoutParams.windowAnimations = animStyle;

            final WindowManager manager = (WindowManager) context.getSystemService( Context.WINDOW_SERVICE );
            manager.addView( view, layoutParams );

            view.postDelayed( new Runnable() {

                  @Override
                  public void run ( ) {

                        manager.removeView( view );
                  }
            }, dismissDelayMill );
      }
}