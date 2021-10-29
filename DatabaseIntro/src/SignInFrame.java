import javax.swing.*;
import java.awt.*;
public class SignInFrame extends Frame implements Runnable {
    public static SignInFrame signInFrame;
    JLabel usernameLabel;
    JTextField usernameField;
    JLabel passwordLabel;
    JPasswordField passwordField;
    SubmitSignInButton submitSignInButton;
    SubmitSignUpButton submitSignUpButton;
    public void run () {

        this.setLayout(new GridLayout(10, 1));

        usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        submitSignInButton = new SubmitSignInButton("Submit");
        submitSignUpButton=new SubmitSignUpButton("Submit Sign Up");

        this.add(usernameLabel);
        this.add(usernameField);
        this.add(passwordLabel);
        this.add(passwordField);
        this.add(submitSignInButton);
        this.add(submitSignUpButton);

        this.setVisible(true);
    }
    public JTextField getUsernameField()
    {
        return usernameField;
    }
    public JPasswordField getPasswordField()
    {
        return passwordField;
    }
    public JButton getsubmitSignInButton(){return this.submitSignInButton;}
}
