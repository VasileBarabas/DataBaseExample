
import java.awt.event.ActionEvent;
public class SubmitSignInButton extends Buttons {
   private boolean _hasInput=false;
   private boolean _wantsToSignIn=false;
   String _user;
   String _password;
    public SubmitSignInButton (String text) {
        super(text);
        this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
         _password=String.copyValueOf(SignInFrame.signInFrame.getPasswordField().getPassword());
         _user=SignInFrame.signInFrame.getUsernameField().getText();
         this._hasInput=true;
         this._wantsToSignIn=true;
    }
    public String getPassword()
    {
        return this._password;
    }
    public String getUser()
    {
        return this._user;
    }
    public boolean gethasInput()
    {
        return this._hasInput;
    }
    public void set_hasInput(boolean hasInput)
    {
        this._hasInput=hasInput;
    }
    public boolean is_wantsToSignIn()
    {
        return _wantsToSignIn;
    }
    public void set_wantsToSignIn(boolean wantsToSignIn)
    {
        this._wantsToSignIn=wantsToSignIn;
    }
}
