import java.sql.*;
public class ConnectDB 
{
    Connection con;
    PreparedStatement pst;
    Statement st;
    ResultSet rs;
    public ConnectDB() throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
    }
    /*public ResultSet getData() throws Exception
    {
        st = con.createStatement();
        rs=st.executeQuery("select * from user");
        return rs;
    }
    public void insertData(String unm,String pwd) throws Exception
    {
        pst = con.prepareStatement("insert into user values(?,?)");
        pst.setString(1,unm);
        pst.setString(2,pwd);
        pst.executeUpdate();
    }*/
    public boolean isValidate(String unm,String pwd) throws Exception
    {
        boolean ans=false;
        pst=con.prepareStatement("Select * from user where unm=? and pwd=?");
        pst.setString(1, unm);
        pst.setString(2, pwd);
        rs=pst.executeQuery();
        if(rs.next())
            ans = true;
        return ans;
    }
}
