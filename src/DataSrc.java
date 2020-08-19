import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

public class DataSrc {
    public static DataSource getMysqlDataSource(){
        MysqlDataSource src = new MysqlDataSource();
        src.setUser("root");
        src.setPort(3306);
        src.setServerName("localhost");
        src.setPassword("root");
        src.setDatabaseName("db1");

        return src;
    }
}
