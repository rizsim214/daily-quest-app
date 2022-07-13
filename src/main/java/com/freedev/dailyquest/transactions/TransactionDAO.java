package com.freedev.dailyquest.transactions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.sql.Date;
import com.freedev.dailyquest.users.UsersDAO;

public class TransactionDAO {
    
    public TransactionDAO() {}

    public static boolean saveTransactionToDB(Transaction transactionObj) throws Exception {
        boolean result = false;
        Connection conn = UsersDAO.connectToDB();
        String sql = "INSERT INTO quest_transaction_tbl(quest_id, quest_seeker_id, quest_provider_id) VALUES(?,?,?)";
        try {
            PreparedStatement prst = conn.prepareStatement(sql);
            prst.setInt(1, transactionObj.getQuestID() );
            prst.setInt(2, transactionObj.getQuestSeekerID());
            prst.setInt(3, transactionObj.getQuestProviderID());
            updateQuestStatus(transactionObj.getQuestID());
            prst.execute();

            result = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static boolean updateQuestStatus(int questID) throws Exception {
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
    public static boolean removeTransactionFromDB() throws Exception {
        return false;
    }
}
