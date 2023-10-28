package dao;
import Model.GeekUsers;

import java.util.*;
import java.sql.*;
public class GeekUsersDao {

    // Here geeksforgeeks is the name of the database
    private static String jdbcURL = "jdbc:mysql://localhost:3306/test";
    private static String jdbcUsername = "root";

    // provide your appropriate password  here
    private static String jdbcPassword = "";

    public static Connection getConnection(){
        Connection con=null;
        try {
            // This is the way of connecting MySQL
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            System.out.println("Message.. " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Message.. " + e.getMessage());
            e.printStackTrace();
        }
        return con;
    }
    public static int save(GeekUsers e)
    {
        int status = 0;
        try {
            Connection con = GeekUsersDao.getConnection();
            // Using PreparedStatement, we can execute any SQL
            // statement In order to save the record, we need to
            // insert the details in 'geekusers' table "e" is an
            // object of type "GeekUsers" which exactly resembles
            // geekusers table From html page, the values has
            // been passed to a servlet and from there, this
            // method is called
            PreparedStatement ps = con.prepareStatement(
                    "insert into geekusers(geekUserName,numberOfPosts,technologiesPreferred) values (?,?,?)");
            ps.setString(1, e.getName());
            ps.setInt(2, e.getNumberOfPosts());
            ps.setString(3, e.gettechnologiesPreferred());

            status = ps.executeUpdate();

            con.close();
        }
        catch (Exception ex) {
            System.out.println("Message.." + ex.getMessage());
            ex.printStackTrace();
        }

        return status;
    }
    public static List<GeekUsers> getAllGeekUses()
    {
        List<GeekUsers> list = new ArrayList<GeekUsers>();

        try {
            Connection con = GeekUsersDao.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select * from geekusers");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GeekUsers e = new GeekUsers();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setNumberOfPosts(rs.getInt(3));
                e.setTechnologiesPreferred(rs.getString(4));
                list.add(e);
            }
            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    public static GeekUsers getGeekUsersById(int id)
    {
        GeekUsers e = new GeekUsers();

        try {
            Connection con = GeekUsersDao.getConnection();
            // We are getting the details for a specific user
            // and hence the query has to be sent in the below
            // way
            PreparedStatement ps = con.prepareStatement(
                    "select * from geekusers where geekUserId=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setNumberOfPosts(rs.getInt(3));
                e.setTechnologiesPreferred(rs.getString(4));
            }
            con.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }
    public static int update(GeekUsers e)
    {
        int status = 0;
        try {
            Connection con = GeekUsersDao.getConnection();
            // AS we are not sure about what fields need to be
            // updated, we are setting for all the fields by
            // means of update query This will update the record
            // for the corresponding geekUserId
            PreparedStatement ps = con.prepareStatement(
                    "update geekusers set geekUserName=?,numberOfPosts=?,technologiesPreferred=? where geekUserId=?");
            ps.setString(1, e.getName());
            ps.setInt(2, e.getNumberOfPosts());
            ps.setString(3, e.gettechnologiesPreferred());
            ps.setInt(4, e.getId());

            status = ps.executeUpdate();

            con.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }
    public static int delete(int id)
    {
        int status = 0;
        try {
            Connection con = GeekUsersDao.getConnection();
            // delete query is given to delete the record for
            // the given geekUserId
            PreparedStatement ps = con.prepareStatement(
                    "delete from geekusers where geekUserId=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();
            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    // Rest of the methods like Save,
    // Update, Delete etc., should come here
}