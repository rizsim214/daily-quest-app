package com.freedev.dailyquest.transactions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import com.freedev.dailyquest.quests.QuestDAO;
import com.freedev.dailyquest.users.UsersDAO;

public class TransactionDAO {
    
    public TransactionDAO() {}

    public static boolean saveTransactionToDB(Transaction transactionObj) throws Exception {
        boolean result = false;
        Connection conn = UsersDAO.connectToDB();
        String sql = "INSERT INTO quest_transaction_tbl(quest_transaction_quest_id, quest_seeker_id, quest_provider_id) VALUES(?,?,?)";
        try {
            PreparedStatement prst = conn.prepareStatement(sql);
            prst.setInt(1, transactionObj.getQuestID());
            prst.setInt(2, transactionObj.getQuestSeekerID());
            prst.setInt(3, transactionObj.getQuestProviderID());
            updateQuestStatusToAccepted(transactionObj.getQuestID());
            updateUserStatus(transactionObj.getQuestSeekerID(), "questing");
            prst.execute();

            result = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("some kind of error");
        }
        return result;
    }

    public static boolean updateQuestStatusToAccepted(int questID) throws Exception {
        boolean result = false;
        Connection conn = UsersDAO.connectToDB();
        String sql = "UPDATE quest_tbl SET quest_status = ?,acceptedAt = ? WHERE quest_id = '"+questID+"'";
        try {
            PreparedStatement prst = conn.prepareStatement(sql);
            prst.setString(1, "accepted");
            prst.setDate(2, Date.valueOf(LocalDate.now()));
            prst.execute();
            result = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }   
    public static boolean updateUserStatus(int userID, String status) throws Exception {
        boolean result = false;
        Connection conn = UsersDAO.connectToDB();
        String sql = "UPDATE users_tbl SET user_status = ?,updatedAt = ? WHERE user_id = '"+userID+"'";
        try {
            PreparedStatement prst = conn.prepareStatement(sql);
            prst.setString(1, status);
            prst.setDate(2, Date.valueOf(LocalDate.now()));
            prst.execute();
            result = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    public static boolean updateQuestTransactionStatus(Transaction transaction, String status) throws Exception {
        boolean result = false;
        Connection conn = UsersDAO.connectToDB();
        String sql = "UPDATE quest_transaction_tbl SET quest_transaction_status = ? ,updatedAt = ? WHERE quest_transaction_id = '"+transaction.getQuestTransactionID()+"'";
        try {
            PreparedStatement prst = conn.prepareStatement(sql);
            prst.setString(1, status);
            prst.setDate(2, Date.valueOf(LocalDate.now()));
            
            prst.execute();
            result = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    public static boolean QuestTransactionStatus(Transaction transaction, String status, String questStatus) throws Exception {
        boolean result = false;
        Connection conn = UsersDAO.connectToDB();
        String sql = "Update quest_transaction_tbl SET quest_transaction_status = ?, updatedAt = ? WHERE quest_transaction_id = '"+transaction.getQuestTransactionID()+"'";
        try {
            PreparedStatement prst = conn.prepareStatement(sql);
            prst.setString(1, status);
            prst.setDate(2, Date.valueOf(LocalDate.now()));
            updateUserStatus(transaction.getQuestSeekerID(), "active");
            prst.execute();
            QuestDAO.updateQuestStatusToActive(transaction.getQuestID(), questStatus);
            result = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
   
    public static List<Transaction> getAcceptedTransactions(Object userID) throws Exception {
        List<Transaction> transactions = null;
        Connection conn = UsersDAO.connectToDB();
        // Join Tables then Set Transactions with quest and user to get data
        String sql = "SELECT * FROM quest_transaction_tbl JOIN quest_tbl ON quest_transaction_tbl.quest_transaction_quest_id = quest_tbl.quest_id JOIN users_tbl ON quest_transaction_tbl.quest_provider_id = users_tbl.user_id WHERE quest_seeker_id = '"+userID+"' ORDER BY quest_transaction_id DESC";
        try {
            transactions = new ArrayList<>();
            PreparedStatement prst = conn.prepareStatement(sql);
            ResultSet rs = prst.executeQuery();

            while(rs.next()) {
               Transaction transaction = new Transaction();
               transaction.setQuestTransactionID(rs.getInt("quest_transaction_id"));
               transaction.setQuestName(rs.getString("quest_name"));
               transaction.setQuestProviderID(rs.getInt("user_id"));
               transaction.setQuestID(rs.getInt("quest_transaction_quest_id"));
               transaction.setQuestProvider(rs.getString("user_name"));
               transaction.setContactInfo(rs.getString("user_contact"));
               transaction.setTimespan(rs.getString("quest_timespan"));
               transaction.setLocation(rs.getString("quest_location"));
               transaction.setQuestBounty(rs.getDouble("quest_bounty"));
               transaction.setDescription(rs.getString("quest_description"));
               transaction.setTransaction_status(rs.getString("quest_transaction_status"));
               transaction.setQuestStatus(rs.getString("quest_status"));
               transactions.add(transaction);
            };
        } catch (Exception e) {
            System.out.println(e.getMessage());            
        }
        return transactions;
    }

    public static List<Transaction> getAllProviderTransactions(Object userID) throws Exception {
        List<Transaction> transactions = null;
        Connection conn = UsersDAO.connectToDB();
        // Join Tables then Set Transactions with quest and user to get data
        String sql = "SELECT * FROM quest_transaction_tbl JOIN quest_tbl ON quest_transaction_tbl.quest_transaction_quest_id = quest_tbl.quest_id JOIN users_tbl ON quest_transaction_tbl.quest_seeker_id = users_tbl.user_id WHERE quest_provider_id = '"+userID+"' ORDER BY quest_transaction_id DESC";
        try {
            transactions = new ArrayList<>();
            PreparedStatement prst = conn.prepareStatement(sql);
            ResultSet rs = prst.executeQuery();

            while(rs.next()) {
               Transaction transaction = new Transaction();
               transaction.setQuestTransactionID(rs.getInt("quest_transaction_id"));
               transaction.setQuestName(rs.getString("quest_name"));
               transaction.setQuestSeekerID(rs.getInt("quest_seeker_id"));
               transaction.setQuestID(rs.getInt("quest_id"));
               transaction.setQuestSeeker(rs.getString("user_name"));
               transaction.setContactInfo(rs.getString("user_contact"));
               transaction.setQuestDate(rs.getDate("quest_start_date"));
               transaction.setTimespan(rs.getString("quest_timespan"));
               transaction.setLocation(rs.getString("quest_location"));
               transaction.setQuestBounty(rs.getDouble("quest_bounty"));
               transaction.setDescription(rs.getString("quest_description"));
               transaction.setTransaction_status(rs.getString("quest_transaction_status"));
               transaction.setQuestStatus(rs.getString("quest_status"));
               transactions.add(transaction);
            };
        } catch (Exception e) {
            System.out.println(e.getMessage());            
        }
        return transactions;
    }

    public static List<Transaction> getAllTransactions() throws Exception {
        List<Transaction> transactions = null;
        Connection conn = UsersDAO.connectToDB();
        // Join Tables then Set Transactions with quest and user to get data
        String sql = "SELECT * FROM quest_transaction_tbl JOIN quest_tbl ON quest_transaction_tbl.quest_transaction_quest_id = quest_tbl.quest_id JOIN users_tbl ON quest_transaction_tbl.quest_seeker_id = users_tbl.user_id WHERE quest_transaction_status = 'done' ORDER BY quest_transaction_id DESC";
        try {
            transactions = new ArrayList<>();
            PreparedStatement prst = conn.prepareStatement(sql);
            ResultSet rs = prst.executeQuery();

            while(rs.next()) {
               Transaction transaction = new Transaction();
               transaction.setQuestTransactionID(rs.getInt("quest_transaction_id"));
               transaction.setQuestName(rs.getString("quest_name"));
               transaction.setQuestProviderID(rs.getInt("quest_provider_id"));
               transaction.setQuestSeekerID(rs.getInt("quest_seeker_id"));
               transaction.setQuestID(rs.getInt("quest_transaction_quest_id"));
               transaction.setQuestSeeker(rs.getString("user_name"));
               transaction.setQuestBounty(rs.getDouble("quest_bounty"));
               transaction.setUpdatedAt(rs.getDate("updatedAt"));
               transaction.setLocation(rs.getString("quest_location"));
               transaction.setTransaction_status(rs.getString("quest_transaction_status"));
               transaction.setQuestStatus(rs.getString("quest_status"));
               transactions.add(transaction);
            };
        } catch (Exception e) {
            System.out.println(e.getMessage());            
        }
        return transactions;
    }

    public static List<Transaction> getAllSeekerTransactions() throws Exception {
        List<Transaction> transactions = null;
        Connection conn = UsersDAO.connectToDB();
        String sql = "SELECT * FROM quest_transaction_tbl JOIN quest_tbl ON quest_transaction_tbl.quest_transaction_quest_id = quest_tbl.quest_id JOIN users_tbl ON quest_transaction_tbl.quest_provider_id = users_tbl.user_id WHERE quest_transaction_status = 'done' ORDER BY quest_transaction_id DESC";
        try {
            transactions = new ArrayList<>();
            PreparedStatement prst = conn.prepareStatement(sql);
            ResultSet rs = prst.executeQuery();

            while(rs.next()) {
               Transaction transaction = new Transaction();
               transaction.setQuestTransactionID(rs.getInt("quest_transaction_id"));
               transaction.setQuestName(rs.getString("quest_name"));
               transaction.setQuestProviderID(rs.getInt("quest_provider_id"));
               transaction.setQuestSeekerID(rs.getInt("quest_seeker_id"));
               transaction.setQuestID(rs.getInt("quest_transaction_quest_id"));
               transaction.setQuestProvider(rs.getString("user_name"));
               transaction.setQuestBounty(rs.getDouble("quest_bounty"));
               transaction.setUpdatedAt(rs.getDate("updatedAt"));
               transaction.setLocation(rs.getString("quest_location"));
               transaction.setTransaction_status(rs.getString("quest_transaction_status"));
               transaction.setQuestStatus(rs.getString("quest_status"));
               transactions.add(transaction);
            };
        } catch (Exception e) {
            System.out.println(e.getMessage());            
        }
        return transactions;
    }

    // DAO for search accepted quest
    public static List<Transaction> searchAcceptedTransactions(Object userID,String searchTitle) throws Exception {
        List<Transaction> transactions = null;
        Connection conn = UsersDAO.connectToDB();
        // Join Tables then Set Transactions with quest and user to get data
        String sql = "SELECT * FROM quest_transaction_tbl JOIN quest_tbl ON quest_transaction_tbl.quest_transaction_quest_id = quest_tbl.quest_id JOIN users_tbl ON quest_transaction_tbl.quest_provider_id = users_tbl.user_id WHERE MATCH (quest_name, quest_description) AGAINST ('"+searchTitle+"' IN NATURAL LANGUAGE MODE) AND quest_seeker_id = '"+userID+"' ORDER BY quest_transaction_id DESC";
        try {
            transactions = new ArrayList<>();
            PreparedStatement prst = conn.prepareStatement(sql);
            ResultSet rs = prst.executeQuery();

            while(rs.next()) {
               Transaction transaction = new Transaction();
               transaction.setQuestTransactionID(rs.getInt("quest_transaction_id"));
               transaction.setQuestName(rs.getString("quest_name"));
               transaction.setQuestProviderID(rs.getInt("user_id"));
               transaction.setQuestID(rs.getInt("quest_transaction_quest_id"));
               transaction.setQuestProvider(rs.getString("user_name"));
               transaction.setContactInfo(rs.getString("user_contact"));
               transaction.setTimespan(rs.getString("quest_timespan"));
               transaction.setLocation(rs.getString("quest_location"));
               transaction.setQuestBounty(rs.getDouble("quest_bounty"));
               transaction.setDescription(rs.getString("quest_description"));
               transaction.setTransaction_status(rs.getString("quest_transaction_status"));
               transaction.setQuestStatus(rs.getString("quest_status"));
               transactions.add(transaction);
            };
        } catch (Exception e) {
            System.out.println(e.getMessage());            
        }
        return transactions;
    }
}
