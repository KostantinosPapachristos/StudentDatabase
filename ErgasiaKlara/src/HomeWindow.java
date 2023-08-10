import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HomeWindow {
	
    private JFrame frmMainWindow;
    
    static Connection conn;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HomeWindow window = new HomeWindow();
                    window.frmMainWindow.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public HomeWindow() {
        initialize();
    }

    private void initialize() {
        frmMainWindow = new JFrame();
        frmMainWindow.addWindowListener(new WindowAdapter() {
        	@Override
        	public void windowOpened(WindowEvent e) {
        		String url="jdbc:mysql://localhost:3302/Studentdb";
                String username="root";
                String password="p08091977pK@";
                System.out.println("Connecting database...");

                try {
                    conn = DriverManager.getConnection(url, username, password);
                }catch(SQLException ex) {
                    throw new IllegalStateException("Cannot connect the database!", ex);
                }

        	}
        });
        frmMainWindow.getContentPane().setBackground(new Color(192, 192, 192));
        frmMainWindow.setBounds(100, 100, 450, 300);
        frmMainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblNewLabel = new JLabel("Welcome To My Main Window");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));

        JButton buttonStudents = new JButton("Students");
        buttonStudents.setFont(new Font("Tahoma", Font.PLAIN, 14));
        buttonStudents.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openSystemWindow();
            }
        });

        JButton buttonClosing = new JButton("Close");
        buttonClosing.setFont(new Font("Tahoma", Font.PLAIN, 14));
        buttonClosing.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                closeWindow();
            }
        });

        GroupLayout groupLayout = new GroupLayout(frmMainWindow.getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(77)
        			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(46, Short.MAX_VALUE))
        		.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
        			.addGap(152)
        			.addComponent(buttonStudents, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        			.addGap(174))
        		.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
        			.addGap(175)
        			.addComponent(buttonClosing)
        			.addContainerGap(194, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(24)
        			.addComponent(lblNewLabel)
        			.addGap(69)
        			.addComponent(buttonStudents, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        			.addGap(30)
        			.addComponent(buttonClosing, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        			.addGap(55))
        );
        frmMainWindow.getContentPane().setLayout(groupLayout);
    }

    private void openSystemWindow() {
        SystemWindow systemWindow = new SystemWindow();
        systemWindow.getFrame().setVisible(true);
    }

    private void closeWindow() {
        frmMainWindow.dispose();
    }

    public JFrame getFrmMainWindow() {
        return frmMainWindow;
    }
}
