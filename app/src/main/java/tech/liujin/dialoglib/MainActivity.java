package tech.liujin.dialoglib;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import tech.liujin.dialog.fragment.MessageDialog;
import tech.liujin.dialog.fragment.TransparentDialog;
import tech.liujin.dialog.window.DialogWindowManager;

public class MainActivity extends AppCompatActivity implements OnClickListener {

      private Button mShowMessage;
      private Button mTrans;
      private Button mWindowShow;
      private Button mSkip;
      private Button mWindowBottom;
      private Button mWindowLeft;
      private Button mWindowRight;
      private Button mCheck;
      private Button mRequest;
      private Button mSystemTop;

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
            mWindowBottom = (Button) findViewById( R.id.windowBottom );
            mWindowBottom.setOnClickListener( this );
            mWindowLeft = (Button) findViewById( R.id.windowLeft );
            mWindowLeft.setOnClickListener( this );
            mWindowRight = (Button) findViewById( R.id.windowRight );
            mWindowRight.setOnClickListener( this );
            mCheck = (Button) findViewById( R.id.check );
            mCheck.setOnClickListener( this );
            mRequest = (Button) findViewById( R.id.request );
            mRequest.setOnClickListener( this );
            mSystemTop = (Button) findViewById( R.id.systemTop );
            mSystemTop.setOnClickListener( this );
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
                        DialogWindowManager.showActivityDialogTop( this, view );
                        break;
                  case R.id.skip:
                        Main2Activity.start( this );
                        break;
                  case R.id.windowBottom:
                        View view0 = getLayoutInflater().inflate( R.layout.message_text, null );
                        DialogWindowManager.showActivityDialogBottom( this, view0 );
                        break;
                  case R.id.windowLeft:
                        View view1 = getLayoutInflater().inflate( R.layout.message_text, null );
                        DialogWindowManager.showActivityDialogLeft( this, view1 );
                        break;
                  case R.id.windowRight:
                        View view2 = getLayoutInflater().inflate( R.layout.message_text, null );
                        DialogWindowManager.showActivityDialogRight( this, view2 );
                        break;
                  case R.id.check:
                        boolean overlays = DialogWindowManager.canDrawOverlays( this );
                        Toast.makeText( this, "是否可以显示" + overlays, Toast.LENGTH_SHORT ).show();
                        break;
                  case R.id.request:
                        DialogWindowManager.requestOverDrawPermission( this, 2048 );
                        break;
                  case R.id.systemTop:
                        View view3 = getLayoutInflater().inflate( R.layout.message_text, null );
                        try {
                              DialogWindowManager.showAppDialogTop( this, view3 );
                        } catch(Exception e) {
                              e.printStackTrace();
                        }
                        break;
                  default:
                        break;
            }
      }

      @Override
      protected void onActivityResult (
          int requestCode, int resultCode, @Nullable Intent data ) {

            super.onActivityResult( requestCode, resultCode, data );

            if( requestCode == 2048 ) {
                  if( DialogWindowManager.canDrawOverlays( this ) ) {
                        View view = getLayoutInflater().inflate( R.layout.message_text, null );
                        try {
                              DialogWindowManager.showAppDialogTop( this, view );
                        } catch(Exception e) {
                              e.printStackTrace();
                        }
                  } else {
                        Toast.makeText( this, "不能显示系统弹窗", Toast.LENGTH_SHORT ).show();
                  }
            }
      }
}
