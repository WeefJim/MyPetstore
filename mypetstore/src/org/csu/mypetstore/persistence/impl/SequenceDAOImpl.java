package org.csu.mypetstore.persistence.impl;

import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.domain.Sequence;
import org.csu.mypetstore.persistence.SequenceDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by jinyejun on 5/13/15.
 */
public class SequenceDAOImpl implements SequenceDAO {

    private final static String GET_SEQUENCE = "select * from sequence where name=?";
    private final static String UPDATE_SEQUENCE = "update sequence set name=?, nextid=? where name=?";

    @Override
    public Sequence getSequence(Sequence sequence) {

        Sequence sequence1 = null;

        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement pStatement = connection
                    .prepareStatement(GET_SEQUENCE);
            pStatement.setString(1, sequence.getName());
            ResultSet resultSet = pStatement.executeQuery();
            if (resultSet.next()) {
                sequence1 = new Sequence();
                sequence1.setName(resultSet.getString(1));
                sequence1.setNextId(resultSet.getInt(2));
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(pStatement);
            DBUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sequence1;
    }

    @Override
    public void updateSequence(Sequence sequence) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement pStatement = connection
                    .prepareStatement(UPDATE_SEQUENCE);
            pStatement.setString(1, sequence.getName());
            pStatement.setInt(2, sequence.getNextId());
            pStatement.setString(3, sequence.getName());

            pStatement.executeUpdate();

            DBUtil.closePreparedStatement(pStatement);
            DBUtil.closeConnection(connection);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
