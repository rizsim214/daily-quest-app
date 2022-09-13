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
        String sql = "INSERT INTO quest_tbl(quest_provider_fk_id, quest_name, quest_description, quest_location, quest_bounty, quest_difficulty, quest_start_date, quest_timespan, createdAt ) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement prst = conn.prepareStatement(sql);
            prst.setObject(1, object);
            prst.setString(2, questObj.getQuestName());
            prst.setString(3, questObj.getQuestDescription());
            prst.setString(4, questObj.getQuestLocation());
            prst.setDouble(5, questObj.getQuestBounty());
            prst.setString(6, questObj.getQuestDifficulty());
            prst.setDate(7, questObj.getStartDate());
            prst.setString(8, questObj.getQuestTimespan());
            prst.setDate(9, Date.valueOf(LocalDate.now()));

            result = prst.execute();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    public Quest getQuestToDB(int questId) throws Exception {
        return null;
    }
    
    // DELETE DATA FROM DATABASE
    public static boolean deleteQuestFromDB(int questID) throws Exception {
        boolean result = false;
        Connection conn = UsersDAO.connectToDB();
        String sql = "UPDATE quest_tbl SET quest_status = ?, quest_updatedAt = ? WHERE quest_id = '"+questID+"'";
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

      // UPDATED DATA FROM DATABASE TO ACTIVE
      public static boolean updateQuestStatusToActive(int questID, String questStatus) throws Exception {
        boolean result = false;
        Connection conn = UsersDAO.connectToDB();
        String sql = "UPDATE quest_tbl SET quest_status = ?, quest_updatedAt = ? WHERE quest_id = '"+questID+"'";
        try {
            PreparedStatement prst = conn.prepareStatement(sql);
            prst.setString(1, questStatus);
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
        String sql = "Select * FROM quest_tbl JOIN users_tbl ON users_tbl.user_id = quest_tbl.quest_provider_fk_id ORDER BY quest_id ASC";
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
                quest.setQuestLocation(rs.getString("quest_location"));
                quest.setQuestBounty(rs.getDouble("quest_bounty"));
                quest.setQuestDifficulty(rs.getString("quest_difficulty"));
                quest.setQuestStatus(rs.getString("quest_status"));
                quest.setStartDate(rs.getDate("quest_start_date"));
                quest.setQuestTimespan(rs.getString("quest_timespan"));
                allQuests.add(quest);
            }
            return allQuests;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allQuests;
    }

    // this is the DAO for searching a specific quest
    public static List<Quest> searchAllQuestFromDB(String searchTitle) throws Exception {
        List<Quest> allQuests = null;
        Connection conn = UsersDAO.connectToDB();
        String sql = "Select * FROM quest_tbl JOIN users_tbl ON users_tbl.user_id = quest_tbl.quest_provider_fk_id WHERE MATCH (quest_name, quest_description) AGAINST ('"+searchTitle+"' IN NATURAL LANGUAGE MODE)";
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
                quest.setQuestLocation(rs.getString("quest_location"));
                quest.setQuestBounty(rs.getDouble("quest_bounty"));
                quest.setQuestDifficulty(rs.getString("quest_difficulty"));
                quest.setQuestStatus(rs.getString("quest_status"));
                quest.setStartDate(rs.getDate("quest_start_date"));
                quest.setQuestTimespan(rs.getString("quest_timespan"));
                allQuests.add(quest);
            }
            return allQuests;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allQuests;
    }
    // DAO for search posted quest
    public static List<Quest> searchPostedQuestFromDB(String searchTitle) throws Exception {
        List<Quest> allQuests = null;
        Connection conn = UsersDAO.connectToDB();
        String sql = "Select * FROM quest_tbl JOIN users_tbl ON users_tbl.user_id = quest_tbl.quest_provider_fk_id WHERE MATCH (quest_name, quest_description) AGAINST ('"+searchTitle+"' IN NATURAL LANGUAGE MODE)";
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
                quest.setQuestLocation(rs.getString("quest_location"));
                quest.setQuestBounty(rs.getDouble("quest_bounty"));
                quest.setQuestDifficulty(rs.getString("quest_difficulty"));
                quest.setQuestStatus(rs.getString("quest_status"));
                quest.setStartDate(rs.getDate("quest_start_date"));
                quest.setQuestTimespan(rs.getString("quest_timespan"));
                allQuests.add(quest);
            }
            return allQuests;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allQuests;
    }

    // filter by bounty
    public static List<Quest> filterByBounty() throws Exception {
        List<Quest> allQuests = null;
        Connection conn = UsersDAO.connectToDB();
        String sql = "Select * FROM quest_tbl JOIN users_tbl ON users_tbl.user_id = quest_tbl.quest_provider_fk_id order by quest_bounty desc";
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
                quest.setQuestLocation(rs.getString("quest_location"));
                quest.setQuestBounty(rs.getDouble("quest_bounty"));
                quest.setQuestDifficulty(rs.getString("quest_difficulty"));
                quest.setQuestStatus(rs.getString("quest_status"));
                quest.setStartDate(rs.getDate("quest_start_date"));
                quest.setQuestTimespan(rs.getString("quest_timespan"));
                allQuests.add(quest);
            }
            return allQuests;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allQuests;
    }

    // filter by easy

    public static List<Quest> filterByEasy() throws Exception {
        List<Quest> allQuests = null;
        Connection conn = UsersDAO.connectToDB();
        String sql = "Select * FROM quest_tbl JOIN users_tbl ON users_tbl.user_id = quest_tbl.quest_provider_fk_id where quest_difficulty='easy'";
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
                quest.setQuestLocation(rs.getString("quest_location"));
                quest.setQuestBounty(rs.getDouble("quest_bounty"));
                quest.setQuestDifficulty(rs.getString("quest_difficulty"));
                quest.setQuestStatus(rs.getString("quest_status"));
                quest.setStartDate(rs.getDate("quest_start_date"));
                quest.setQuestTimespan(rs.getString("quest_timespan"));
                allQuests.add(quest);
            }
            return allQuests;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allQuests;
    }

    public static List<Quest> filterByMedium() throws Exception {
        List<Quest> allQuests = null;
        Connection conn = UsersDAO.connectToDB();
        String sql = "Select * FROM quest_tbl JOIN users_tbl ON users_tbl.user_id = quest_tbl.quest_provider_fk_id where quest_difficulty='medium'";
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
                quest.setQuestLocation(rs.getString("quest_location"));
                quest.setQuestBounty(rs.getDouble("quest_bounty"));
                quest.setQuestDifficulty(rs.getString("quest_difficulty"));
                quest.setQuestStatus(rs.getString("quest_status"));
                quest.setStartDate(rs.getDate("quest_start_date"));
                quest.setQuestTimespan(rs.getString("quest_timespan"));
                allQuests.add(quest);
            }
            return allQuests;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allQuests;
    }

    public static List<Quest> filterByHard() throws Exception {
        List<Quest> allQuests = null;
        Connection conn = UsersDAO.connectToDB();
        String sql = "Select * FROM quest_tbl JOIN users_tbl ON users_tbl.user_id = quest_tbl.quest_provider_fk_id where quest_difficulty='hard'";
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
                quest.setQuestLocation(rs.getString("quest_location"));
                quest.setQuestBounty(rs.getDouble("quest_bounty"));
                quest.setQuestDifficulty(rs.getString("quest_difficulty"));
                quest.setQuestStatus(rs.getString("quest_status"));
                quest.setStartDate(rs.getDate("quest_start_date"));
                quest.setQuestTimespan(rs.getString("quest_timespan"));
                allQuests.add(quest);
            }
            return allQuests;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allQuests;
    }
}
