import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Hello {
    public static void main(String[] args) throws PropertyVetoException, SQLException {
        ComboPooledDataSource source=new ComboPooledDataSource();
        source.setDriverClass("com.mysql.jdbc.Driver");
        source.setJdbcUrl("jdbc:mysql://localhost:3306/seat?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT");
        source.setUser("root");
        source.setPassword("123456");
        PreparedStatement pstmt=source.getConnection().prepareStatement("select * from users");
        ResultSet rs=pstmt.executeQuery();
        while(rs.next())
            System.out.println(rs.getString(1));
    }
}
