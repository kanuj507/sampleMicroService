package dao.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import common.AbstractDao;
import dao.UserDao;
import model.User;

public class UserDaoImpl extends AbstractDao implements UserDao {

    private static final String SQL_INSERT = String.format("insert into %s (%s,%s,%s) values (:fName, :lName, :userId)");
    private final RowMapper<User> userMapRow = new UserRowMapper();

    @Override
    public int insert(User user) {
        final MapSqlParameterSource pararmSource = new MapSqlParameterSource();
        pararmSource.addValue("fName", user.getfName());
        pararmSource.addValue("lName", user.getlName());
        pararmSource.addValue("userId", user.getUsrId());
        
        return this.getNamedParameterJdbcTemplate().queryForRowSet(SQL_INSERT, pararmSource);
    }

    @Override
    public int searchUserByUserName(String userName) {
        // TODO Auto-generated method stub


        return 0;
    }

    private static final class UserRowMapper implements RowMapper<User> {

        private UserRowMapper() {

        }

        public User mapRow(final ResultSet rs, final int rowNum) throws SQLException {
            final User usr = new User();
            usr.setfName(rs.getString("firstName"));
            usr.setlName(rs.getString("lastName"));
            usr.setUsrId(rs.getInt("userid"));
            return usr;
        }
    }

}
