package tech.liujin.dialoglib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import tech.liujin.dialog.fragment.MessageDialog;
import tech.liujin.dialog.fragment.TransparentDialog;
import tech.liujin.dialog.window.DialogWindowManager;

public class MainActivity extends AppCompatActivity implements OnClickListener {

      private Button mShowMessage;
      private Button mTrans;
      private Button mWindowShow;
      private Button mSkip;

      @Override
      protected void onCreate ( Bundle savedInstanceState ) {

            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_main );
            initView();
      }

      private void initView ( ) {

            mShowMessage = findViewById( R.id.showMessage );
            mShowMessage.setOnClickListener( this );
            mTrans = findViewById( R.id.trans );
            mTrans.setOnClickListener( this );
            mWindowShow = (Button) findViewById( R.id.windowShow );
            mWindowShow.setOnClickListener( this );
            mSkip = (Button) findViewById( R.id.skip );
            mSkip.setOnClickListener( this );
      }

      @Override
      public void onClick ( View v ) {

            switch( v.getId() ) {
                  case R.id.showMessage:
                        MessageDialog messageDialog = new MessageDialog();
                        messageDialog.setTitle( "新消息" );
                        messageDialog.setMessage( "这是一条新消息" );
                        break;
                  case R.id.trans:
                        TransparentDialog dialog = new TransparentDialog();
                        dialog.show( getSupportFragmentManager(), null );
                        break;
                  case R.id.windowShow:
                        View view = getLayoutInflater().inflate( R.layout.message_text, null );
                        DialogWindowManager.showActivityDialog( this, view );
                        break;
                  case R.id.skip:
                        Main2Activity.start( this );
                        break;
                  default:
                        break;
            }
      }
}
