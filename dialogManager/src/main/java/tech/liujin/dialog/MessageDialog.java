package tech.liujin.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

/**
 * @author Liujin 2019/4/12:18:34:02
 */
@SuppressLint("ValidFragment")
public class MessageDialog extends CustomDialogFragment implements OnClickListener {

      private TextView mTitle;
      private TextView mMessage;
      private TextView mConfirm;

      public MessageDialog ( Context context ) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            setView( inflater.inflate( R.layout.dialog_message, null ) );
      }

      @NonNull
      @Override
      public Dialog onCreateDialog ( @Nullable Bundle savedInstanceState ) {

            Dialog dialog = super.onCreateDialog( savedInstanceState );
            dialog.getWindow().setBackgroundDrawableResource( R.drawable.rect_16 );
            return dialog;
      }

      @Override
      protected void onDialogViewCreated ( View dialogView ) {

            super.onDialogViewCreated( dialogView );

            mTitle = dialogView.findViewById( R.id.title );
            mMessage = dialogView.findViewById( R.id.message );
            mConfirm = dialogView.findViewById( R.id.confirm );
            mConfirm.setOnClickListener( this );
      }

      public void setTitle ( String title ) {

            mTitle.setText( title );
      }

      public void setMessage ( String message ) {

            mMessage.setText( message );
      }

      public TextView getTitleView ( ) {

            return mTitle;
      }

      public TextView getMessageView ( ) {

            return mMessage;
      }

      public TextView getConfirmView ( ) {

            return mConfirm;
      }

      @Override
      public void onClick ( View v ) {

            if( v == mConfirm ) {
                  dismiss();
            }
      }
}
