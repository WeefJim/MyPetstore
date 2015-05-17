package org.csu.mypetstore.persistence.impl;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.persistence.AccountDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by jinyejun on 5/11/15.
 */
public class AccountDAOImpl implements AccountDAO {
    private final static String GET_ACCOUNT_BY_USERNAME = "select * from account a, signon s, profile p where s.username = ? and a.userid = s.username and a.userid = p.userid";
    private final static String GET_ACCOUNT_BY_USERNAME_AND_PASSWORD = "select * from account a, signon s, profile p where s.username = ? and s.password = ? and a.userid = s.username and a.userid = p.userid";
    private final static String INSERT_ACCOUNT = "insert into account values(?,?,?,?,?,?,?,?,?,?,?,?)";
    private final static String INSERT_PROFILE = "insert into profile values(?,?,?,?,?)";
    private final static String INSERT_SIGNON = "insert into signon values(?,?)";
    private final static String UPDATE_ACCOUNT = "update account set  email=?, firstname=?, lastname=?, status=?, addr1=?, addr2=?, city=?, state=?, zip=?, country=?, phone=? where userid = ?";
    private final static String UPDATE_PROFILE = "update profile set  langpref=?, favcategory=?, mylistopt=?, banneropt=? where userid = ?";
    private final static String UPDATE_SIGNON = "update signon set  password=? where username = ?";


    @Override
    public Account getAccountByUsername(String username) {
        Account account = null;
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ACCOUNT_BY_USERNAME);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                account = new Account();
                account.setEmail(resultSet.getString(2));
                account.setFirstName(resultSet.getString(3));
                account.setLastName(resultSet.getString(4));
                account.setStatus(resultSet.getString(5));
                account.setAddress1(resultSet.getString(6));
                account.setAddress2(resultSet.getString(7));
                account.setCity(resultSet.getString(8));
                account.setState(resultSet.getString(9));
                account.setZip(resultSet.getString(10));
                account.setCountry(resultSet.getString(11));
                account.setPhone(resultSet.getString(12));
                account.setUsername(resultSet.getString(13));
                account.setPassword(resultSet.getString(14));
                account.setLanguagePreference(resultSet.getString(16));
                account.setFavouriteCategoryId(resultSet.getString(17));
                account.setListOption(resultSet.getInt(18) == 1);
                account.setBannerOption(resultSet.getInt(19) == 1);
            }

            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }

        return account;
    }

    @Override
    public Account getAccountByUsernameAndPassword(Account account) {
        Account result = null;
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ACCOUNT_BY_USERNAME_AND_PASSWORD);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                result = new Account();
                result.setEmail(resultSet.getString(2));
                result.setFirstName(resultSet.getString(3));
                result.setLastName(resultSet.getString(4));
                result.setStatus(resultSet.getString(5));
                result.setAddress1(resultSet.getString(6));
                result.setAddress2(resultSet.getString(7));
                result.setCity(resultSet.getString(8));
                result.setState(resultSet.getString(9));
                result.setZip(resultSet.getString(10));
                result.setCountry(resultSet.getString(11));
                result.setPhone(resultSet.getString(12));
                result.setUsername(resultSet.getString(13));
                result.setPassword(resultSet.getString(14));
                result.setLanguagePreference(resultSet.getString(16));
                result.setFavouriteCategoryId(resultSet.getString(17));
                result.setListOption(resultSet.getInt(18) == 1);
                result.setBannerOption(resultSet.getInt(19) == 1);
            }

            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void insertAccount(Account account) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACCOUNT);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getEmail());
            preparedStatement.setString(3, account.getFirstName());
            preparedStatement.setString(4, account.getLastName());
            preparedStatement.setString(5, account.getStatus());
            preparedStatement.setString(6, account.getAddress1());
            preparedStatement.setString(7, account.getAddress2());
            preparedStatement.setString(8, account.getCity());
            preparedStatement.setString(9, account.getState());
            preparedStatement.setString(10,account.getZip());
            preparedStatement.setString(11, account.getCountry());
            preparedStatement.setString(12, account.getPhone());
            preparedStatement.executeUpdate();
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void insertProfile(Account account) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROFILE);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getLanguagePreference());
            preparedStatement.setString(3, account.getFavouriteCategoryId());
            preparedStatement.setInt(4, account.isListOption() ? 1 : 0);
            preparedStatement.setInt(5, account.isBannerOption() ? 1 : 0);
            preparedStatement.executeUpdate();
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void insertSignon(Account account) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SIGNON);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.executeUpdate();
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACCOUNT);
            preparedStatement.setString(1, account.getEmail());
            preparedStatement.setString(2, account.getFirstName());
            preparedStatement.setString(3, account.getLastName());
            preparedStatement.setString(4, account.getStatus());
            preparedStatement.setString(5, account.getAddress1());
            preparedStatement.setString(6, account.getAddress2());
            preparedStatement.setString(7, account.getCity());
            preparedStatement.setString(8, account.getState());
            preparedStatement.setString(9,account.getZip());
            preparedStatement.setString(10, account.getCountry());
            preparedStatement.setString(11, account.getPhone());
            preparedStatement.setString(12, account.getUsername());
            preparedStatement.executeUpdate();
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateProfile(Account account) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PROFILE);
            preparedStatement.setString(1, account.getLanguagePreference());
            preparedStatement.setString(2, account.getFavouriteCategoryId());
            preparedStatement.setInt(3, account.isListOption() ? 1 : 0);
            preparedStatement.setInt(4, account.isBannerOption() ? 1 : 0);
            preparedStatement.setString(5, account.getUsername());
            preparedStatement.executeUpdate();
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateSignon(Account account) {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SIGNON);
            preparedStatement.setString(1, account.getPassword());
            preparedStatement.setString(2, account.getUsername());
            preparedStatement.executeUpdate();
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
