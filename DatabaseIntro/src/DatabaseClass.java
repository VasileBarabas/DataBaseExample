import java.sql.*;

public class DatabaseClass extends Thread {
    private static DatabaseClass instance;
    private Connection con;
    private int _idCounter=0;

    private DatabaseClass() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-video", "root", "toor");
            System.out.println("Conexiune reusita");
            setDaemon(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DatabaseClass getInstance() throws SQLException {
        if (null == instance) {
            instance = new DatabaseClass();
        } else if (instance.getCon().isClosed()) {
            instance = new DatabaseClass();
        }
        return instance;
    }

    public Connection getCon() {
        return con;
    }
    public void getMaxValueOfId()
    {
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT MAX(id) from people as Max;");

            if(rs.next())
            {
                _idCounter=rs.getInt(1)+1;
            }
            stm.close();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    public void run() {
        getMaxValueOfId();
        //Sincronizam instanta bazei de date
        synchronized (instance) {
            while (true) {
                //verificam daca am apasat pe submit
                if (!SignInFrame.signInFrame.submitSignInButton.gethasInput() && !SignInFrame.signInFrame.submitSignUpButton.gethasInput()) {
                    //cat timp nu
                    try {
                        //asteptam
                       // System.out.println("We are waiting for input");
                        wait(10);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    //altfel efectuam un query cu datele pe care le-am citit din SubmitSignInButtonClass si le introducem intr-un result set. Daca result set e null, adica nu sunt valori valide in baza, at nu avem valori;
                } else {
                    try {
                        if (SignInFrame.signInFrame.submitSignInButton.is_wantsToSignIn()) {
                            System.out.println("Want to search for items such as " + SignInFrame.signInFrame.submitSignInButton.getUser() + " and " + SignInFrame.signInFrame.submitSignInButton.getPassword());
                            Statement stm = con.createStatement();
                            ResultSet rs = stm.executeQuery("select * from people where userName='" + SignInFrame.signInFrame.submitSignInButton.getUser() + "';");
                            if (rs.next()) {
                                System.out.println("Am gasit valori");
                            } else {
                                System.out.println("Nu am gasit valori");
                            }
                            SignInFrame.signInFrame.submitSignInButton.set_wantsToSignIn(false);
                            stm.close();
                        } else if (SignInFrame.signInFrame.submitSignUpButton.is_wantsToSignUp()) {
                            System.out.println("Vrem sa aduagam in baza de date user");
                            Statement stm=con.createStatement();
                            stm.execute("INSERT INTO people VALUES ('"+_idCounter+"','"+ SignInFrame.signInFrame.submitSignUpButton.getUser()+"','"+SignInFrame.signInFrame.submitSignUpButton.getPassword()+"')");
                            this._idCounter++;
                            stm.close();
                            SignInFrame.signInFrame.submitSignUpButton.set_wantsToSignUp(false);
                        }
                        //Resetam inputul
                        SignInFrame.signInFrame.submitSignInButton.set_hasInput(false);
                        SignInFrame.signInFrame.submitSignUpButton.set_hasInput(false);
                        notify();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}

