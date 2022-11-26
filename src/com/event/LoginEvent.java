package com.
        event;

import com.
        mysqld.
        Mysqld;
import com.
        window.
        LoginStart;
import com.
        window.
        Manage;
import com.
        window.
        StudentSystem;

import java.
        awt.
        event.
        ActionEvent;
import
        javax.
                swing.*;
import java.
        awt.
        event.
        ActionListener;
import java
        .sql.
        ResultSet;

public class LoginEvent
        implements ActionListener {
    JButton
            button;
    JMenuItem
            item;
    static Manage
            manage;

    public void actionPerformed(ActionEvent e) {
        try {
            button = (JButton) e.getSource();
            if (button.getName()
                    == "ok") {
                String account
                        = LoginStart.
                        accounttext.
                        getText();
                String password
                        = new
                        String(LoginStart.
                        passwordtext.
                        getPassword());
                if (Mysqld.
                        loginAccount
                                (account, password)) {
                    manage
                            = new Manage();
                }
            }
            if (button.
                    getName()
                    =="add"){
                String  name
                        =Manage.nametext.getText();
                String number
                        =Manage.numbertext.getText();
                if(name.
                        equals("")){
                    JOptionPane.
                            showMessageDialog(
                                    null,
                                    "不能为空",
                                    "编辑消息",
                                    JOptionPane.
                                            WARNING_MESSAGE);
                }
                else if (number.
                        equals("")){
                    JOptionPane.
                            showMessageDialog(
                                    null,
                                    "不能为空",
                                    "编辑消息",
                                    JOptionPane.
                                            WARNING_MESSAGE);
                }
                else {
                    Mysqld.
                            addStudent
                                    (name,number);
                    String
                            data[]
                             =new String[2];
                    data[0]
                            =name;
                    data[1]
                            =number;
                    Manage.
                            model.
                             addRow
                                    (data);
                }
            }
            if
            (button.getName()
                    =="del"){
                String number1
                        =Manage.
                        numbertext.
                        getText();
                if
                (number1.
                        equals("")){
                    JOptionPane.
                            showMessageDialog(
                                    null,
                                    "不能为空",
                                    "编辑消息",
                                    JOptionPane.
                                            WARNING_MESSAGE);
                }else{
                    Mysqld.
                            delStudent
                                    (number1);
                }
            }
        } catch
        (Exception e1) {
        }
        try {
            item
                    =
                    (JMenuItem)
                            e.getSource();
            if
            (item.
                    getName()
                    == "item1")
            {
                manage.
                        dispose();
            }

        } catch
        (Exception
                        e1) {
        }
    }
    }
