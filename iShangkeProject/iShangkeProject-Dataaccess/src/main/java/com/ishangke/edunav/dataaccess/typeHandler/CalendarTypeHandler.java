package com.ishangke.edunav.dataaccess.typeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.ishangke.edunav.dataaccess.common.DateUtility;


public class CalendarTypeHandler implements TypeHandler{

    @Override
    public void setParameter(PreparedStatement ps, int i, Object parameter,
            JdbcType jdbcType) throws SQLException {
        ps.setString(i, DateUtility.toSQLDateTime(((Calendar)parameter)));  
        
    }

    @Override
    public Object getResult(ResultSet rs, String columnName)
            throws SQLException {
        return DateUtility.DateToCalendar(rs.getDate(columnName));
    }

    @Override
    public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
}
