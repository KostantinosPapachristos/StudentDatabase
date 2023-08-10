import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Color;

public class SearchWindow {

    private JFrame formInsert;
    private JTextField TfName;
    private JTextField TfSurname;
    private JTextField TfID;
	private JLabel lblNewLabel;


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
            	SearchWindow window = new SearchWindow();
                window.formInsert.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @wbp.parser.entryPoint
     */
    public SearchWindow() {
        initialize();
    }

    private void initialize() {
        formInsert = new JFrame();
        formInsert.getContentPane().setBackground(new Color(192, 192, 192));
        formInsert.setTitle("Insert Student");
        formInsert.setBounds(100, 100, 450, 300);
        formInsert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        formInsert.getContentPane().setLayout(null);

        JButton btnInsert = new JButton("Insert");
        btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
           
            	try {
                    int StudentsId = Integer.parseInt(TfID.getText());
                    String StudentsName = TfName.getText();
                    String StudentsSurname = TfSurname.getText();
                    PreparedStatement p = (PreparedStatement) HomeWindow.conn.prepareStatement("INSERT INTO STUDENTS VALUES(?,?,?)");
                    p.setInt(1, StudentsId);
                    p.setString(2,StudentsName);
                    p.setString(3, StudentsSurname);
                    p.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Insert Done", "INSERT", JOptionPane.PLAIN_MESSAGE);
                    p.close();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        
        btnInsert.setBounds(182, 226, 77, 25);
        formInsert.getContentPane().add(btnInsert);
        
        JLabel lbName = new JLabel("Name:");
        lbName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbName.setBounds(108, 71, 47, 16);
        formInsert.getContentPane().add(lbName);
        
        JLabel lbSUR = new JLabel("Last Name:");
        lbSUR.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbSUR.setBounds(71, 119, 84, 13);
        formInsert.getContentPane().add(lbSUR);
        
        JLabel lbID = new JLabel("ID:");
        lbID.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbID.setBounds(132, 158, 23, 23);
        formInsert.getContentPane().add(lbID);
        
        TfName = new JTextField();
        TfName.setBounds(185, 71, 96, 19);
        formInsert.getContentPane().add(TfName);
        TfName.setColumns(10);
        
        TfSurname = new JTextField();
        TfSurname.setBounds(185, 117, 96, 19);
        formInsert.getContentPane().add(TfSurname);
        TfSurname.setColumns(10);
        
        TfID = new JTextField();
        TfID.setBounds(185, 161, 29, 19);
        formInsert.getContentPane().add(TfID);
        TfID.setColumns(10);
        
        lblNewLabel = new JLabel("Search Student");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel.setBounds(161, 27, 144, 13);
        formInsert.getContentPane().add(lblNewLabel);
    }

    public JFrame getFrmSearchWindow() {
        return formInsert;
    }
}