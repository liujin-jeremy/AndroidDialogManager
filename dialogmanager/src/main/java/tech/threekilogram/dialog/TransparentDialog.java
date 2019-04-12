package tech.threekilogram.dialog;

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

/**
 * @author Liujin 2019/4/12:20:23:40
 */
@SuppressLint("ValidFragment")
public class TransparentDialog extends CustomDialogFragment {

      @SuppressLint("ValidFragment")
      public TransparentDialog ( Context context ) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            setView( inflater.inflate( R.layout.dialog_transparent, null ) );
      }

      @Override
      protected void onDialogViewCreated ( View dialogView ) {

            super.onDialogViewCreated( dialogView );
      }

      @NonNull
      @Override
      public Dialog onCreateDialog ( @Nullable Bundle savedInstanceState ) {

            Dialog dialog = super.onCreateDialog( savedInstanceState );
            dialog.getWindow().setBackgroundDrawable( new ColorDrawable( Color.TRANSPARENT ) );
            return dialog;
      }
}
