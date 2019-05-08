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
import android.view.Window;
import android.widget.TextView;

/**
 * @author Liujin 2019/4/12:18:34:02
 */
@SuppressLint("ValidFragment")
public class MessageDialog extends CustomDialogFragment implements OnClickListener {

      private String mTitleText;
      private String mMessageText;

      @Override
      protected View onCreateDialogView ( Context context ) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            View view = inflater.inflate( R.layout.dialog_message, null );

            return view;
      }

      @NonNull
      @Override
      public Dialog onCreateDialog ( @Nullable Bundle savedInstanceState ) {

            Dialog dialog = super.onCreateDialog( savedInstanceState );
            Window window = dialog.getWindow();
            if( window != null ) {
                  window.setBackgroundDrawableResource( R.drawable.rect_16 );
            }
            ( (TextView) mView.findViewById( R.id.title ) ).setText( mTitleText );
            ( (TextView) mView.findViewById( R.id.message ) ).setText( mMessageText );
            mView.findViewById( R.id.confirm ).setOnClickListener( this );
            return dialog;
      }

      public void setTitle ( String title ) {

            mTitleText = title;
      }

      public void setMessage ( String message ) {

            mMessageText = message;
      }

      public TextView getTitleView ( ) {

            return ( (TextView) mView.findViewById( R.id.title ) );
      }

      public TextView getMessageView ( ) {

            return ( (TextView) mView.findViewById( R.id.message ) );
      }

      public TextView getConfirmView ( ) {

            return mView.findViewById( R.id.confirm );
      }

      @Override
      public void onClick ( View v ) {

            if( v.getId() == R.id.confirm ) {
                  dismiss();
            }
      }
}
