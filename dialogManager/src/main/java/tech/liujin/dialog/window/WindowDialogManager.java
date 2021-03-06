package tech.liujin.dialog.window;

import android.Manifest.permission;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.provider.Settings;
import android.support.annotation.RequiresPermission;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import tech.liujin.dialog.R;

/**
 * @author Liujin 2019/5/8:10:50:02
 */
public class WindowDialogManager {

      private static final String TAG = WindowDialogManager.class.getSimpleName();

      public static void showActivityDialogTop ( Context context, final View view ) {

            showActivityDialog( context, view, Gravity.TOP, R.style.windowDialogTopAnim, 2000 );
      }

      public static void showActivityDialogBottom ( Context context, final View view ) {

            showActivityDialog( context, view, Gravity.BOTTOM, R.style.windowDialogBottomAnim, 2000 );
      }

      public static void showActivityDialogLeft ( Context context, final View view ) {

            showActivityDialog( context, view, Gravity.LEFT | Gravity.TOP, R.style.windowDialogLeftAnim, 2000 );
      }

      public static void showActivityDialogRight ( Context context, final View view ) {

            showActivityDialog( context, view, Gravity.RIGHT | Gravity.TOP, R.style.windowDialogRightAnim, 2000 );
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

      public static boolean canDrawOverlays ( Context context ) {

            if( VERSION.SDK_INT >= VERSION_CODES.M ) {
                  return Settings.canDrawOverlays( context );
            }

            return true;
      }

      public static void requestOverDrawPermission ( Activity activity, int requestCode ) {

            if( VERSION.SDK_INT >= VERSION_CODES.M ) {
                  activity.startActivityForResult(
                      new Intent(
                          Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                          Uri.parse( "package:" + activity.getPackageName() )
                      ),
                      requestCode
                  );
            }
      }

      @RequiresPermission(permission.SYSTEM_ALERT_WINDOW)
      public static void showAppDialog (
          Context context, final View view, int gravity, int animStyle, int dismissDelayMill ) throws Exception {

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

            if( VERSION.SDK_INT >= VERSION_CODES.O ) { // 8.0开始需要使用该类型
                  layoutParams.type = LayoutParams.TYPE_APPLICATION_OVERLAY;
            } else {
                  layoutParams.type = LayoutParams.TYPE_PHONE;
            }

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

      @RequiresPermission(permission.SYSTEM_ALERT_WINDOW)
      public static void showAppDialogTop ( Context context, final View view ) throws Exception {

            showAppDialog( context, view, Gravity.TOP, R.style.windowDialogTopAnim, 2000 );
      }

      @RequiresPermission(permission.SYSTEM_ALERT_WINDOW)
      public static void showAppDialogBottom ( Context context, final View view ) throws Exception {

            showAppDialog( context, view, Gravity.BOTTOM, R.style.windowDialogBottomAnim, 2000 );
      }

      @RequiresPermission(permission.SYSTEM_ALERT_WINDOW)
      public static void showAppDialogLeft ( Context context, final View view ) throws Exception {

            showAppDialog( context, view, Gravity.LEFT | Gravity.TOP, R.style.windowDialogLeftAnim, 2000 );
      }

      @RequiresPermission(permission.SYSTEM_ALERT_WINDOW)
      public static void showAppDialogRight ( Context context, final View view ) throws Exception {

            showAppDialog( context, view, Gravity.RIGHT | Gravity.TOP, R.style.windowDialogRightAnim, 2000 );
      }
}