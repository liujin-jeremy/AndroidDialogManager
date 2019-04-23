package tech.liujin.dialog;

import android.content.Context;

/**
 * @author Liujin 2019/4/12:18:14:18
 */
public class DialogManager {

      public static MessageDialog createMessage ( Context context, String title, String message ) {

            MessageDialog dialog = new MessageDialog( context );
            dialog.setTitle( title );
            dialog.setMessage( message );
            return dialog;
      }
}
