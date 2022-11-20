package com.event;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import com.window.Register;
public class RegEvent implements MouseListener{
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1)
        System.out.print("click\n");
        Register register=new Register();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}
