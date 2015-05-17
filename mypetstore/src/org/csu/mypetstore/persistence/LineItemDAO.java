package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.LineItem;

import java.util.List;

/**
 * Created by jinyejun on 5/13/15.
 */
public interface LineItemDAO {

    List<LineItem> getLineItemsByOrderId(int orderId);

    void insertLineItem(LineItem lineItem);
}
