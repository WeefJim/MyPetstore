package org.csu.mypetstore.persistence.impl;

import org.csu.mypetstore.domain.LineItem;
import org.csu.mypetstore.persistence.LineItemDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinyejun on 5/13/15.
 */
public class LineItemDAOImpl implements LineItemDAO {

    private final static String GET_LINEITEM_BY_lineItemID = "select * from lineitem where lineItemid = ?";
    private final static String INSERT_LINEITEM = "inset into lineitem values(?,?,?,?,?)";

    @Override
    public List<LineItem> getLineItemsByOrderId(int lineItemId) {

        List<LineItem> lineItemList = new ArrayList<LineItem>();
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_LINEITEM_BY_lineItemID);
            preparedStatement.setInt(1, lineItemId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                LineItem lineItem = new LineItem();
                lineItem.setOrderId(resultSet.getInt(1));
                lineItem.setLineNumber(resultSet.getInt(2));
                lineItem.setItemId(resultSet.getString(3));
                lineItem.setQuantity(resultSet.getInt(4));
                lineItem.setUnitPrice(resultSet.getBigDecimal(5));
                lineItemList.add(lineItem);
            }

            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);

        }catch (Exception e){
            e.printStackTrace();
        }


        return lineItemList;
    }

    @Override
    public void insertLineItem(LineItem lineItem) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LINEITEM);
            preparedStatement.setInt(1, lineItem.getOrderId());
            preparedStatement.setInt(2, lineItem.getLineNumber());
            preparedStatement.setString(3, lineItem.getItemId());
            preparedStatement.setInt(4, lineItem.getQuantity());
            preparedStatement.setBigDecimal(5, lineItem.getUnitPrice());
            preparedStatement.executeUpdate();

            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
