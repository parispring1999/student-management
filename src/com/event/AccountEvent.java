package com.
        event;
import com.
        mysql.
        jdbc.
        Connection;
import com.
        mysqld.
        Mysqld;
import com.
        window.
        Register;
import javax.
        swing.
        *;
import java.
        awt.
        event.
        ActionListener;
import java.
        awt.
        event.
        ActionEvent;
import java.
        sql.
        PreparedStatement;
import java.
        sql.
        ResultSet;
import java.
        sql.
        SQLException;
import java.
        sql.
        Statement;

public class
AccountEvent
        implements
        ActionListener {
    Statement
            sql;
    ResultSet
            rs;
    JButton
            allbutton;
    public void
    actionPerformed
            (ActionEvent e)
    {
        allbutton
                =
                (JButton)
                        e.
                                getSource();
        if
        (allbutton.
                getName()
                == "reg")
        {
            Jbtton();
            System.
                    out.
                    println
                            ("reg success");
        }
    }
    void Jbtton()
    {
           String
                   name=
                   Register.
                           nametext.
                           getText();
           String
                   account
                   =Register.
                   accounttext.
                   getText();
           char[]
                   str=
                   Register.
                           passwordtext.
                           getPassword();
           String
                   passwordtext
                   =new String
                   (str);
           String
                   password=
                   passwordtext;
           Connection
                   con=
                   Mysqld.
                           con;
           PreparedStatement
                   preSql;
           String
                   url=
                   "insert into user values" +
                           "(?,?,?)";
            try
            {
                preSql
                        =con.
                        prepareStatement
                                (url);
                preSql.
                        setString
                                (1,
                                        name);
                preSql.
                        setString(
                                2,
                                account);
                preSql.
                        setString(
                                3,
                                password);
                int
                        ok
                        = preSql.
                        executeUpdate();
            }
            catch
            (SQLException
                    ex) {
                ex.
                        printStackTrace();
            }
        }



}
