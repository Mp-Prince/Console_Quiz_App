/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quiz_app;
import com.mycompany.Quiz_DataBase.ConnDB;
/**
 *
 * @author prince
 */
public class Quiz_App {

    public static void main(String[] args) {    
        ConnDB c = new ConnDB();
        c.connSQL();
    }
}
