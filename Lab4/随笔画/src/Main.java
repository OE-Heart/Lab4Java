import java.awt.*;  
import java.awt.event.*;

public class Main extends Frame implements MouseListener, MouseMotionListener{  
    Label l1, l2;  
    int p_x;
    int p_y;
    long p_t;
    Color c;

    Main() {  
        l1 = new Label();  
        l1.setBounds(20,40,100,20);  
        add(l1);  

        l2 = new Label();  
        l2.setBounds(20,60,100,20);  
        add(l2);  
        
        addMouseListener(this);
        addMouseMotionListener(this);  
        
        setSize(1000, 1000);  
        setLayout(null);  
        setVisible(true);  
    }  
    
    public void mouseDragged(MouseEvent e) {  
        l1.setText("X="+e.getX()+", Y="+e.getY());  

        Graphics2D g = (Graphics2D)getGraphics();
        g.setColor(c);

        int x = e.getX();
        int y = e.getY();
        long t = e.getWhen();

        double v = Math.sqrt(Math.abs(x-p_x)^2+Math.abs(y-p_y)^2)/(t-p_t);

        g.setStroke(new BasicStroke(Math.max(0, 10-10*(float)v)));
        g.setBackground(Color.WHITE);
        g.drawLine(p_x, p_y, x, y);

        p_x = x;
        p_y = y;
        p_t = t;
    }  

    public void mouseMoved(MouseEvent e) {  
        l1.setText("X="+e.getX()+", Y="+e.getY()); 
    }

    public void mouseClicked(MouseEvent e) {
        l2.setText("Mouse Clicked");    
    }  
    public void mouseEntered(MouseEvent e) {
        l2.setText("Mouse Entered");  
    }  
    public void mouseExited(MouseEvent e) {
        l2.setText("Mouse Exited");  
    }  
    public void mousePressed(MouseEvent e) {
        l2.setText("Mouse Pressed");
        if(e.getButton() == 1) c = Color.BLACK;
        else if(e.getButton() == 3) c = Color.WHITE;
        else {}
        p_x = e.getX();
        p_y = e.getY();
        p_t = e.getWhen();
    }  
    public void mouseReleased(MouseEvent e) {
        l2.setText("Mouse Released");   
    }

    public static void main(String[] args) {  
        new Main();  
    }
}  