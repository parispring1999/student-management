package com.window;
import com.event.LoginEvent;
import com.event.RegEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Manage extends JFrame {

    final int WIDTH=800;
    final int HEIGHT=550;
    JMenuBar menubar;
    JMenu menu,menu1;
    JMenuItem item,item1;
    JPanel jpanel_1,jpanel_2;
    JLabel name,number,yon,cla,pro,num;
    public static JTextField nametext,numbertext,yontext,clatext,protext,numtext;
    JButton add,del,c,v1,v2,v3;
    //JLabel numbercondition;
    //JTextField numberconditiontext;
    Object columns[]={"姓名","学号","年级","专业","电话","是否核酸"};
    JTable tableL;
    JScrollPane jscrollpane;
    static Vector rwo;
    public static DefaultTableModel model;
    static TableColumnModel columnModel;
    ActionListener lintener_1;

    public Manage(){
        init();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        validate();
    }
    void init(){
        //窗口布局大小位置
        this.setLayout(null);
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension screenSize=kit.getScreenSize();
        int width=screenSize.width;
        int height=screenSize.height;
        int x=(width-WIDTH)/2;
        int y=(height-HEIGHT)/2;
        this.setBounds(x,y,WIDTH,HEIGHT);
        //菜单栏
        menubar=new JMenuBar();
        menu=new JMenu("管理");
        menu1=new JMenu("账号");
        item=new JMenuItem("更改账号信息");
        item1=new JMenuItem("注销");
        item1.setName("item1");
        //基本信息处理
        jpanel_1=new javax.swing.JPanel();
        jpanel_1.setLayout(new FlowLayout(FlowLayout.CENTER));
        jpanel_1.setBorder(BorderFactory.createTitledBorder("基本信息处理"));
        jpanel_1.setBounds(50,30,WIDTH-100,110);
        //按钮
        name=new JLabel("姓名");
        nametext=new JTextField(18);
        number=new JLabel("学号");
        numbertext=new JTextField(18);
        cla=new JLabel("年级");
        clatext=new JTextField(18);
        pro=new JLabel("专业");
        protext=new JTextField(18);
        num=new JLabel("电话");
        numtext=new JTextField(18);
        yon=new JLabel("是否核酸");
        yontext=new JTextField(18);
        add=new JButton("增加数据");
        del=new JButton("删除数据");
        c=new JButton("更改数据");
        v1=new JButton("筛选未做核算者");
        v2=new JButton("查看总人数");
        v3=new JButton("查看未做人数");

        add.setName("add");
        del.setName("del");

        //umbercondition=new JLabel ("学号条件");
        //numberconditiontext=new JTextField(25);

        //表格
        jpanel_2=new javax.swing.JPanel();
        jpanel_2.setLayout(new FlowLayout(FlowLayout.CENTER));
        jpanel_2.setBounds(50,160,WIDTH-100,300);
        jpanel_2.setBorder(BorderFactory.createTitledBorder("学生核酸信息显示"));
        table();
        //添加
        menu.add(item);
        menu1.add(item1);
        menubar.add(menu);
        menubar.add(menu1);
        jpanel_1.add(name);
        jpanel_1.add(nametext);
        jpanel_1.add(number);
        jpanel_1.add(numbertext);
        jpanel_1.add(yon);
        jpanel_1.add(yontext);
        jpanel_1.add(cla);
        jpanel_1.add(clatext);
        jpanel_1.add(pro);
        jpanel_1.add(protext);
        jpanel_1.add(num);
        jpanel_1.add(numtext);
        jpanel_1.add(add);
        jpanel_1.add(del);
        jpanel_1.add(c);
        jpanel_1.add(v1);
        jpanel_1.add(v2);
        jpanel_1.add(v3);
        //jpanel_1.add (numbercondition);
        //jpanel_1.add(numberconditiontext);
        jpanel_2.add(jscrollpane);
        this.add(jpanel_2);
        this.add(jpanel_1);
        this.add(menubar);
        this.setJMenuBar(menubar);
        String data[]=new String[6];
        data[0]= "张三";
        data[1]= "2022000";
        data[2]= "一年级";
        data[3]="CS";
        data[4]="5000000";
        data[5]="是";
        Manage.model.addRow(data);
        allEvent();
    }
    void table(){
        tableL=getTable();
        jscrollpane=new JScrollPane(tableL);
        jscrollpane.setPreferredSize(new Dimension(WIDTH-190,250));
        tableL.setPreferredSize(new Dimension(WIDTH-190,1000));
        jscrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    }
    JTable getTable() {
        if (tableL == null) {
            tableL = new JTable();
            int[] columnWidth = {50,50,50,50,50,50};
            model = new DefaultTableModel() {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            model.setColumnIdentifiers(columns);
            tableL.setModel(model);
            columnModel=tableL.getColumnModel();
            tableL.getTableHeader().setReorderingAllowed(false);
            tableL.getTableHeader().setResizingAllowed(false);
            int count = columnModel.getColumnCount();
            for (int i = 0; i < count; i++) {
                javax.swing.table.TableColumn column = columnModel.getColumn(i);
                column.setPreferredWidth(columnWidth[i]);
            }
            rwo = new Vector(6);
        }
        return tableL;
    }
    void allEvent(){
        lintener_1=new LoginEvent();
        item1.addActionListener(lintener_1);
        add.addActionListener(lintener_1);
        del.addActionListener(lintener_1);
    }
}
