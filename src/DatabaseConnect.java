import javax.swing.*;
import java.sql.*;

public class DatabaseConnect {
    private Connection connect;
    private Statement state;
    private ResultSet rset;
    private PreparedStatement pstate;

    public DatabaseConnect(){
        try {
            connect = DataSrc.getMysqlDataSource().getConnection();
            if(connect != null){
                System.out.println("Connected to DataBase");
            }
            state = connect.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Boolean checkUserLogin(String user , String password){
        String query = "Select email, password from userlogin where email = ? and password = ?";

        try {
            pstate = connect.prepareStatement(query);
            pstate.setString(1,user);
            pstate.setString(2,password);
            rset = pstate.executeQuery();

            if(rset.next()){
                //JOptionPane.showMessageDialog(null,"Login Succesfull");
                return true;
            }
            else {
                JOptionPane.showMessageDialog(null,"Email or Password is incorrect");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}