package com.alehyem.personalfinances.dao;

import com.alehyem.personalfinances.dao.exceptions.DAOException;
import com.alehyem.personalfinances.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers() throws DAOException;

    User getUser(int id) throws DAOException;

    User getUser(String login) throws DAOException;

    List<Integer> getBannedUsersIdList() throws DAOException;

    List<Integer> getBannedTransactionsUsersIdList() throws DAOException;

    void saveUser(User user) throws DAOException;

    void updateUserPassword(int id, String password) throws DAOException;

    void updateUser(String[] params) throws DAOException;

    void updateUser(User user, String[] params) throws DAOException;

    void updateUserBanStatus(int userId, String[] params) throws DAOException;

    void updateUserTransactionBanStatus(int userId, String[] params) throws DAOException;

    void deleteUser(User user) throws DAOException;

//    List<BalanceTransaction> getUserBalanceTransactions(int id) throws DAOException;
//
//    void addBalanceTransaction(int id, BalanceTransaction balanceTransaction) throws DAOException;

    List<String> getAllCountries() throws DAOException;
}
