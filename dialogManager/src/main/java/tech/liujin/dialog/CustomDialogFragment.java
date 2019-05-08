package tech.liujin.dialog;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.View;

/**
 * @author Liujin 2019/4/12:18:17:37
 */
public abstract class CustomDialogFragment extends DialogFragment {

      protected Dialog mDialog;
      protected View   mView;

      /**
       * 创建{@link #mDialog}的显示界面
       */
      protected abstract View onCreateDialogView ( Context context );

      @NonNull
      @Override
      public Dialog onCreateDialog ( @Nullable Bundle savedInstanceState ) {

            if( mDialog == null ) {
                  AlertDialog.Builder builder = new Builder( getContext() );
                  mView = onCreateDialogView( getContext() );
                  builder.setView( mView );
                  mDialog = builder.create();
            }

            return mDialog;
      }
}
