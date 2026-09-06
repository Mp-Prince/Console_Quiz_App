package com.mycompany.Quiz_DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import io.github.cdimascio.dotenv.Dotenv;

public class ConnDB {

    private final String databaseUrl = loadDatabaseUrl();

    private String loadDatabaseUrl() {
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()
                .load();
        String url = dotenv.get("DATABASE_URL");
        if (url == null || url.isBlank()) {
            throw new IllegalStateException("DATABASE_URL is missing from the .env file");
        }
        return url;
    }

    public void connSQL(){ 
        String listQuery = "SELECT * FROM Category"; 

        try (Connection conn = DriverManager.getConnection(databaseUrl);
             PreparedStatement pstmt = conn.prepareStatement(listQuery);
             ResultSet rs = pstmt.executeQuery();
             Scanner s = new Scanner(System.in)) {

            // 1. Display all available categories
            int i = 1;
            while(rs.next()){
                System.out.println(i + " : \t" + rs.getString("Cate"));
                i++;
            }
            int id = 1;
            try{
                System.out.print("\nEnter Category ID: ");
                id = s.nextInt(); // safer than nextByte() to prevent overflow drops
            }catch(InputMismatchException err){
                System.out.println("Invalid Entery : So well go with General Questions");
            }
            

            // 2. Fetch the specific category name based on user input
            // ConnDB Fetch_Que = new ConnDB();
            // Fetch_Que.Display(id);

            Display(id);

        // Display(id);

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }

    public void Display(int ID){
        String Qquery = "SELECT * FROM Quiz_qustions WHERE Cate_ID = ?";
        try (
            Scanner sc = new Scanner(System.in);
            Connection con = DriverManager.getConnection(databaseUrl);
            PreparedStatement psCat = con.prepareStatement(Qquery);
        ){
            psCat.setInt(1, ID);
            try(
                ResultSet data = psCat.executeQuery();
            ){

                int score = 0 ;
                int i = 0 ;
                while(data.next()){
                    i++;
                    System.out.println(i+" "+data.getString("Qustion"));
                    System.out.println("1 : "+data.getString("Option_1"));
                    System.out.println("2 : "+data.getString("Option_2"));
                    System.out.println("3 : "+data.getString("Option_3"));
                    System.out.println("4 : "+data.getString("Option_4"));
                    int ans = sc.nextByte();
                    if(ans == data.getInt("Answer")){
                        score++;
                    }
                }
                System.out.println("Your score is : "+score );
            }catch(SQLException e){
                System.out.println("Faild to fetch the Question : "+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("DataBase Connecton Faild : "+e.getMessage());
        }
    }
}