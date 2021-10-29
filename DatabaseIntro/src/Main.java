import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {
        SignInFrame.signInFrame =new SignInFrame();
        SwingUtilities.invokeLater(SignInFrame.signInFrame);
        try {
            DatabaseClass db = DatabaseClass.getInstance();
            db.run();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }

    }
}
