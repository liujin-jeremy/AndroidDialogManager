package tech.liujin.dialog;

/**
 * @author Liujin 2019/4/12:18:14:18
 */
public class DialogManager {

      public static MessageDialog createMessage ( String title, String message ) {

            MessageDialog dialog = new MessageDialog();
            dialog.setTitle( title );
            dialog.setMessage( message );
            return dialog;
      }
}
