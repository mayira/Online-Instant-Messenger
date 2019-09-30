/*   
 Project:   Online Instant Messenger
*/

package windows;

import java.awt.Toolkit;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class LoginWindow extends javax.swing.JFrame {
 java.sql.Connection conn=null;
 ResultSet rs=null;
 Statement st;
 

    public LoginWindow() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Messenger = new javax.swing.JPanel();
        jtxtUsername = new javax.swing.JTextField();
        jtxtPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jToggleButton2 = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chat Login");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(330, 310));
        setSize(new java.awt.Dimension(330, 310));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Messenger.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Chat Login", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sitka Heading", 3, 36), new java.awt.Color(0, 102, 102))); // NOI18N
        Messenger.setForeground(new java.awt.Color(0, 102, 102));
        Messenger.setToolTipText("");
        Messenger.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Messenger.setFocusTraversalPolicyProvider(true);
        Messenger.setMaximumSize(new java.awt.Dimension(320, 180));

        jtxtUsername.setCaretColor(new java.awt.Color(0, 102, 102));

        jtxtPassword.setCaretColor(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("User Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Password");

        jToggleButton2.setBackground(new java.awt.Color(204, 204, 204));
        jToggleButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jToggleButton2.setText("Login");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MessengerLayout = new javax.swing.GroupLayout(Messenger);
        Messenger.setLayout(MessengerLayout);
        MessengerLayout.setHorizontalGroup(
            MessengerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MessengerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MessengerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(MessengerLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MessengerLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MessengerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        MessengerLayout.setVerticalGroup(
            MessengerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MessengerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MessengerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(MessengerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(Messenger, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 320, 170));
        Messenger.getAccessibleContext().setAccessibleName("Messenger Login");
        Messenger.getAccessibleContext().setAccessibleDescription("");

        jPanel3.setBackground(new java.awt.Color(15, 228, 203));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 300, 10));

        jPanel5.setBackground(new java.awt.Color(15, 228, 203));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 300, 10));

        jPanel6.setBackground(new java.awt.Color(15, 228, 203));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 300, 10));

        jPanel7.setBackground(new java.awt.Color(15, 228, 203));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 300, 10));

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 306, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 310, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // for general use 
        String username= jtxtUsername.getText();
        String password= jtxtPassword.getText();
       
        try
         {
            Class.forName("org.sqlite.JDBC");
            
            java.sql.Connection conn= DriverManager.getConnection("jdbc:sqlite:UserNamePassword.db");

            java.sql.Statement st=(Statement)conn.createStatement();
      
           String DBQ="select * from login where username='"+jtxtUsername.getText()+"' AND password='"+jtxtPassword.getText()+"' ";
           
       
            
            rs=st.executeQuery(DBQ);
            

            if(rs.next())
               JOptionPane.showMessageDialog(null,"You have successfully logged In.");
            else
               JOptionPane.showMessageDialog(null,"Login Information is Incorrect.");
         
         }
        
        catch(ClassNotFoundException | SQLException | HeadlessException e){
                        System.err.println(e);
        }
    
        try { 
             
            int log=1;
         
            java.sql.Connection conn;
    
            conn = DriverManager.getConnection("jdbc:sqlite:UserNamePassword.db");
           
            st=(Statement)conn.createStatement();
            
            rs=st.executeQuery("select * from login");
         
            while(rs.next())
            {
                if(rs.getString(1).equals(username)&& rs.getString(2).equals(password)) {
            
                log=0;
                break;
            }
            }
            if(log==0)
            {   
                CloseMe();
                
                st.close();
                
                conn.close();
                
                 //this.setVisible(false);
                String info[]=new String[1];  //creates an array to store  variable values. You can increase the size when needed
 
                info[0]= jtxtUsername.getText(); //put jTextField1's value in the array.
                
                ClientWindow.main(info); // call Frame2. Here we create an object of a Frame2. We are passing info as arguments to main function.
                
                this.setVisible(true); // hiding this form

            }
            else
                JOptionPane.showMessageDialog(null,"Please try again","Login system",JOptionPane.ERROR_MESSAGE);
                jtxtUsername.setText("");
                jtxtPassword.setText("");
                jtxtUsername.grabFocus();
         
    }//GEN-LAST:event_jToggleButton2ActionPerformed
        catch (SQLException ex) {
            Logger.getLogger(LoginWindow.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("Connection to DataBase is failed!\n");
    }
   
    } 
    
    // for test 
    
     public void jToggleButtonAction() {
        ActionEvent event;
        long when;
        when  = System.currentTimeMillis();
        event = new ActionEvent(this.jToggleButton2, ActionEvent.ACTION_PERFORMED, "Anything", when, 0);
        jToggleButton2ActionPerformed(event);
    }
    
    public String getusername(){
        String username= jtxtUsername.getText();
        return(username);
    }
    
    
     public void setusername(String name ){
         name = jtxtUsername.getText();
        
    }
  
    private void CloseMe()
            {
                WindowEvent meClose= new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
                Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(meClose);
            }
    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginWindow().setVisible(true);
            } }); 
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Messenger;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JPasswordField jtxtPassword;
    private javax.swing.JTextField jtxtUsername;
    // End of variables declaration//GEN-END:variables
}
