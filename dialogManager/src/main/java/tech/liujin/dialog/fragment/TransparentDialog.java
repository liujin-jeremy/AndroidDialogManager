package tech.liujin.dialog.fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import tech.liujin.dialog.R;

/**
 * @author Liujin 2019/4/12:20:23:40
 */
@SuppressLint("ValidFragment")
public class TransparentDialog extends CustomDialogFragment {

      @Override
      protected View onCreateDialogView ( Context context ) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            return inflater.inflate( R.layout.dialog_transparent, null );
      }

      @NonNull
      @Override
      public Dialog onCreateDialog ( @Nullable Bundle savedInstanceState ) {

            Dialog dialog = super.onCreateDialog( savedInstanceState );
            Window window = dialog.getWindow();
            if( window != null ) {
                  window.setBackgroundDrawable( new ColorDrawable( Color.TRANSPARENT ) );
            }
            return dialog;
      }
}
