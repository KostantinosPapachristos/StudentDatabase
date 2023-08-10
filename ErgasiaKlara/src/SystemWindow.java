import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class SystemWindow {
    private JFrame frame;
    private JTextField TextFieldSearch;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SystemWindow window = new SystemWindow();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SystemWindow() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(192, 192, 192));
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton buttonEdit = new JButton("Edit");
        buttonEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
        buttonEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openIdWindow();
            }
        });
        buttonEdit.setBounds(170, 149, 89, 23);
        frame.getContentPane().add(buttonEdit);

        JButton buttonSearch = new JButton("Insert");
        buttonSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
        buttonSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openSearchWindow();
            }
        });
        buttonSearch.setBounds(170, 116, 89, 23);
        frame.getContentPane().add(buttonSearch);

        JButton buttonClose = new JButton("Close");
        buttonClose.setFont(new Font("Tahoma", Font.PLAIN, 14));
        buttonClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                closeWindow();
            }
        });
        buttonClose.setBounds(170, 182, 89, 23);
        frame.getContentPane().add(buttonClose);
        
        TextFieldSearch = new JTextField();
        TextFieldSearch.setBounds(189, 83, 52, 23);
        frame.getContentPane().add(TextFieldSearch);
        TextFieldSearch.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("NAME OF STUDENT");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel.setBounds(128, 34, 176, 35);
        frame.getContentPane().add(lblNewLabel);
        
        JButton CheckButton = new JButton("Search ID");
        CheckButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
                    int StudentsId = Integer.parseInt(TextFieldSearch.getText());
                    PreparedStatement p = (PreparedStatement) HomeWindow.conn.prepareStatement("SELECT *  FROM STUDENTS WHERE ID=?");
                    p.setInt(1, StudentsId);
                    
                    if (p.executeQuery().next()) {
                        JOptionPane.showMessageDialog(null,"This Search Exists", "SEARCH", JOptionPane.PLAIN_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"This Search does not Exists", "SEARCH", JOptionPane.PLAIN_MESSAGE);
 
                    }
                    
                    p.close();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
        	}
        });
        CheckButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        CheckButton.setBounds(251, 84, 100, 21);
        frame.getContentPane().add(CheckButton);
    }

    private void openIdWindow() {
        IdWindow idWindow = new IdWindow();
        idWindow.getFrame().setVisible(true);
    }

    private void openSearchWindow() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                SearchWindow searchWindow = new SearchWindow();
                searchWindow.getFrmSearchWindow().setVisible(true);
            }
        });
    }

    private void closeWindow() {
        frame.dispose();
    }

    public JFrame getFrame() {
        return frame;
    }
}
