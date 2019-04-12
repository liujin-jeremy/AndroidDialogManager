package tech.threekilogram.dialoglib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import tech.threekilogram.dialog.DialogManager;
import tech.threekilogram.dialog.TransparentDialog;

public class MainActivity extends AppCompatActivity implements OnClickListener {

      private Button mShowMessage;
      private Button mTrans;

      @Override
      protected void onCreate ( Bundle savedInstanceState ) {

            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_main );
            initView();
      }

      private void initView ( ) {

            mShowMessage = findViewById( R.id.showMessage );
            mShowMessage.setOnClickListener( this );
            mTrans = (Button) findViewById( R.id.trans );
            mTrans.setOnClickListener( this );
      }

      @Override
      public void onClick ( View v ) {

            switch( v.getId() ) {
                  case R.id.showMessage:
                        DialogManager.createMessage( this, "新消息", "你有新的消息" ).show( getSupportFragmentManager(), null );
                        break;
                  case R.id.trans:
                        TransparentDialog dialog = new TransparentDialog( this );
                        dialog.show( getSupportFragmentManager(), null );
                        break;
                  default:
                        break;
            }
      }
}
