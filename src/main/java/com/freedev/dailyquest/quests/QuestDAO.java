package com.freedev.dailyquest.quests;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.freedev.dailyquest.users.UsersDAO;

public class QuestDAO {
    
    public QuestDAO() {}
    // ADD DATA TO DATABASE
    public static boolean saveQuestToDB(Quest questObj, Object object) throws Exception {
        boolean result = false;
        Connection conn = UsersDAO.connectToDB();
        String sql = "INSERT INTO quest_tbl(quest_provider_fk_id, quest_name, quest_description, quest_date, quest_location, quest_timespan, quest_bounty, quest_difficulty) VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement prst = conn.prepareStatement(sql);
            prst.setObject(1, object);
            prst.setString(2, questObj.getQuestName());
            prst.setString(3, questObj.getQuestDescription());
            prst.setString(4, questObj.getQuestDate());
            prst.setString(5, questObj.getQuestLocation());
            prst.setString(6, questObj.getQuestTimespan());
            prst.setDouble(7, questObj.getQuestBounty());
            prst.setString(8, questObj.getQuestDifficulty());
            result = prst.execute();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    public Quest getQuestToDB(int questId) throws Exception {
        return null;
    }
    public boolean updateQuestFromDB(int questId) throws Exception {

        return false;
    }
    
    // DELETE DATA FROM DATABASE
    public static boolean deleteQuestFromDB(int questID) throws Exception {
        boolean result = false;
        Connection conn = UsersDAO.connectToDB();
        String sql = "UPDATE quest_tbl SET quest_status = ?, updatedAt = ? WHERE quest_id = '"+questID+"'";
        try {
            PreparedStatement prst = conn.prepareStatement(sql);
            prst.setString(1, "deleted");
            prst.setDate(2, Date.valueOf(LocalDate.now()));
            prst.execute();
            result = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    // GET ALL DATA FROM DATABASE
    public static List<Quest> getAllQuestFromDB() throws Exception {
        List<Quest> allQuests = null;
        Connection conn = UsersDAO.connectToDB();
        String sql = "Select * FROM quest_tbl JOIN users_tbl ON users_tbl.user_id = quest_tbl.quest_provider_fk_id ";
        try {
            allQuests = new ArrayList<>();
            PreparedStatement prst = conn.prepareStatement(sql);
            ResultSet rs = prst.executeQuery();

            while(rs.next()){
                Quest quest = new Quest();
                quest.setQuestId(rs.getInt("quest_id"));
                quest.setQuestProviderId(rs.getInt("quest_provider_fk_id"));
                quest.setQuestProvider(rs.getString("user_name"));
                quest.setQuestName(rs.getString("quest_name"));
                quest.setQuestDescription(rs.getString("quest_description"));
                quest.setQuestDate(rs.getString("quest_date"));
                quest.setQuestLocation(rs.getString("quest_location"));
                quest.setQuestTimespan(rs.getString("quest_timespan"));
                quest.setQuestBounty(rs.getDouble("quest_bounty"));
                quest.setQuestDifficulty(rs.getString("quest_difficulty"));
                quest.setQuestStatus(rs.getString("quest_status"));
                allQuests.add(quest);
            }
            return allQuests;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allQuests;
    }
}
