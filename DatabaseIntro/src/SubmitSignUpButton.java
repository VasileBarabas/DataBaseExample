import java.awt.event.ActionEvent;

public class SubmitSignUpButton extends Buttons {
    private boolean _hasInput=false;
    private boolean _wantsToSignUp=false;
    String _user;
    String _password;
    public SubmitSignUpButton (String text) {
        super(text);
        this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        _password=String.copyValueOf(SignInFrame.signInFrame.getPasswordField().getPassword());
        _user=SignInFrame.signInFrame.getUsernameField().getText();
        this._hasInput=true;
        this. _wantsToSignUp=true;
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
    public boolean is_wantsToSignUp()
    {
        return _wantsToSignUp;
    }
    public void set_wantsToSignUp(boolean wantsToSignUp)
    {
        this._wantsToSignUp=wantsToSignUp;
    }

}
