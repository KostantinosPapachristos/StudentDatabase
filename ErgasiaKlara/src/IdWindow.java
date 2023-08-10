import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class IdWindow {
    private JFrame frame;
    private JTextField IDText;
    private JTextField SurnameText;
    private JTextField NameText;
    private Connection connection;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    IdWindow window = new IdWindow();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public IdWindow() {
        initialize();
        connectToDatabase();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(128, 128, 128));
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel TfId = new JLabel("ID :");
        TfId.setFont(new Font("Tahoma", Font.BOLD, 16));

        JLabel TFSur = new JLabel("Surname :");
        TFSur.setFont(new Font("Tahoma", Font.BOLD, 16));

        JLabel TfNam = new JLabel("Name :");
        TfNam.setFont(new Font("Tahoma", Font.BOLD, 16));

        IDText = new JTextField();
        IDText.setColumns(10);

        SurnameText = new JTextField();
        SurnameText.setColumns(10);

        NameText = new JTextField();
        NameText.setColumns(10);

        JButton DeleteButton = new JButton("Delete");
        DeleteButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		try {
                    int StudentsId = Integer.parseInt(IDText.getText());
                    PreparedStatement p = (PreparedStatement) HomeWindow.conn.prepareStatement("DELETE FROM STUDENTS WHERE ID=?");
                    p.setInt(1, StudentsId);
                    p.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Delete Done", "DELETE", JOptionPane.PLAIN_MESSAGE);
                    p.close();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
        	}
        });
        DeleteButton.setBackground(new Color(255, 255, 255));
        DeleteButton.setFont(new Font("Tahoma", Font.PLAIN, 12));

        JButton UpdateButton = new JButton("Update");
        UpdateButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		try {
                    int StudentsId = Integer.parseInt(IDText.getText());
                    String StudentsName = NameText.getText();
                    String StudentsSurname = SurnameText.getText();
                    PreparedStatement p = (PreparedStatement) HomeWindow.conn.prepareStatement("UPDATE STUDENTS SET NAME=?, SURNAME=? WHERE ID=?");
                    p.setString(1,StudentsName);
                    p.setString(2, StudentsSurname);
                    p.setInt(3, StudentsId);
                    p.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Update Done", "UPDATE", JOptionPane.PLAIN_MESSAGE);
                    p.close();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
        	}
        });
        UpdateButton.setBackground(new Color(255, 255, 255));
        UpdateButton.setFont(new Font("Tahoma", Font.PLAIN, 12));

        JButton ClosingButton = new JButton("Close");
        ClosingButton.setBackground(new Color(255, 255, 255));
        ClosingButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        ClosingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeWindow();
            }
        });

        JLabel lblNewLabel_3 = new JLabel("Update Or Delete ");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));

        GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(130)
        			.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
        			.addGap(109))
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(99)
        					.addComponent(DeleteButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addGap(18)
        					.addComponent(UpdateButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addGap(26)
        					.addComponent(ClosingButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(28)
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGap(28)
        							.addComponent(TFSur, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGap(81)
        							.addComponent(TfId, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGap(43)
        							.addComponent(TfNam, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGap(20)
        							.addComponent(IDText, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
        						.addComponent(NameText, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
        						.addComponent(SurnameText, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))))
        			.addGap(116))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(18)
        			.addComponent(lblNewLabel_3)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(31)
        					.addComponent(TfId))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(28)
        					.addComponent(IDText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addGap(18)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(SurnameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(3)
        					.addComponent(TFSur)))
        			.addGap(18)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(NameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(TfNam))
        			.addGap(51)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(DeleteButton, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        				.addComponent(UpdateButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(ClosingButton, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
        			.addContainerGap())
        );
        frame.getContentPane().setLayout(groupLayout);
    }

    public JFrame getFrame() {
        return frame;
    }
    
    private void connectToDatabase() {
        String url = "jdbc:mysql://localhost:3302/studentdb";
        String username = "root";
        String password = "p08091977pK@";

        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }
    
    private void closeWindow() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to close the database connection.");
            e.printStackTrace();
        }
        frame.dispose();
    }
}
