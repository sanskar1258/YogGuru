package models;

import java.sql.*;
import org.jasypt.util.password.StrongPasswordEncryptor;

public class User {
    static StrongPasswordEncryptor spe = new StrongPasswordEncryptor();

    // ########### Properties #################
    private Integer userId;
    private String name;
    private String email;
    private String password;
    private String phone;
    private Integer age;
    private String startDate;
    private String selectedBatch;

    // ########### Constructors ###############
    public User() {
    
    }   

    public User(String name, String email, String password, String phone) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public User(String name,Integer age,String phone,String startDate,String selectedBatch) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.startDate= startDate;
        this.selectedBatch = selectedBatch;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // ########### Other Methods ##############

    public boolean addMember() {
        boolean flag = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yogadb?user=root&password=9893777225");

            String query = "insert into users (name, age, phone, start_date, selected_batch) value (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, phone);
            ps.setString(4, startDate);
            ps.setString(5, selectedBatch);

            int res = ps.executeUpdate();

            if(res == 1) 
                flag = true;

            con.close();
        } catch(SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }

        return flag;
    }

    public boolean signinUser() {
        boolean flag = false;
        // statusId:
        // 0 - ac with email does not exist...
        // -1 - password mismatched...
        // 1 - active
        // 2,4,5 - inactive,closed & blocked 

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yogadb?user=root&password=9893777225");

            String query = "select password,user_id, name, phone from users where email=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                
                if(spe.checkPassword(password, rs.getString("password"))) {
                    password = null;
                    userId = rs.getInt("user_id");
                    name = rs.getString("name");
                    phone = rs.getString("phone");  

                    flag = true;                     
                } else {
                    flag = false;
                } 
                
            }

            con.close();
        } catch(SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }

        return flag;
    }


    public boolean signupUser() {
        boolean flag = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yogadb?user=root&password=9893777225");

            String query = "insert into users (name, email, password, phone) value (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, spe.encryptPassword(password));
            ps.setString(4, phone);

            int res = ps.executeUpdate();

            if(res == 1) 
                flag = true;

            con.close();
        } catch(SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }

        return flag;
    }

    // ########### Getter-Setters ##############
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    
}
