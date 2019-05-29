package common;

import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class AbstractDao {

    private DataSource dataSource;
    private Environment environment;

    private final NamedParameterJdbcDaoSupport namedParameterJdbcDaoSupport = new NamedParameterJdbcDaoSupport();
    
    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    protected final JdbcTemplate getJdbcTemplate() {
        return this.namedParameterJdbcDaoSupport.getJdbcTemplate();
    }

    protected final NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return this.namedParameterJdbcDaoSupport.getNamedParameterJdbcTemplate();
    }

    public int searchUserByUserName(String userName) {
        // TODO Auto-generated method stub
        return 0;
    }

}
