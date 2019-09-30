/*   
 Project:   Online Instant Messenger
*/

package windows;

import java.awt.event.ActionEvent;
import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class ClientWindow extends javax.swing.JFrame 
{
    String nameUser;
    String Addr = "localhost";
    
    ArrayList<String> Users = new ArrayList();
    int Port = 1000;
    Boolean isConnected = false;
    
    Socket socket;
    BufferedReader Reader;
    PrintWriter Writer;
    
    public static String text; 
    
    // creating threads 
    public void ListenThread() 
    {
         Thread IncomingReader = new Thread(new IncomingReader());
         IncomingReader.start();
    }
    
    
    public void userAdd(String data) 
    {
         Users.add(data);
    }
    
    
    public void userRemove(String data) 
    {
         Chat.append(data + " is now offline.\n");
    }
    
    
    public void writeUsers() 
    {
         String[] tempList = new String[(Users.size())];
         Users.toArray(tempList);
         for (String token:tempList) 
         {
             //users.append(token + "\n");
         }
    }
    
    
    public void sendDisconnect() 
    {
        String bye = (nameUser + ": :D");
        try
        {
            Writer.println(bye); 
            Writer.flush(); 
        } catch (Exception e) 
        {
            //Chat.append("Could not send Disconnect message.\n");
        }
    }


    
    public ClientWindow() 
    {
        initComponents();
    }
    
    
    
    public class IncomingReader implements Runnable
    {
        @Override
        public void run() 
        {
            String[] data;
            String stream;
            String done = "Done";
            String connect = "Login";
            String disconnect = "LogOff";
            String chat = "t";

            try 
            {
                while ((stream = Reader.readLine()) != null) 
                {
                     data = stream.split(":");

                     if (data[2].equals(chat)) 
                     {
                        Chat.append(data[0] + ": " + data[1] + "\n");
                        Chat.setCaretPosition(Chat.getDocument().getLength());
                     } 
                     else if (data[2].equals(connect))
                     {
                        Chat.removeAll();
                        userAdd(data[0]);
                     } 
                     else if (data[2].equals(disconnect)) 
                     {
                         userRemove(data[0]);
                     } 
                     else if (data[2].equals(done)) 
                     {
                        //users.setText("");
                        writeUsers();
                        Users.clear();
                     }
                }
           }catch(Exception ex) { }
        }
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        background = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Chat = new javax.swing.JTextArea();
        Chat_Name = new javax.swing.JLabel();
        START = new javax.swing.JButton();
        LogOff_Button = new javax.swing.JButton();
        type_window = new javax.swing.JTextField();
        Send_button = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat User");
        setLocation(new java.awt.Point(700, 300));
        setName("client"); // NOI18N
        setResizable(false);

        background.setBackground(new java.awt.Color(15, 228, 203));
        background.setToolTipText("");

        Chat.setColumns(20);
        Chat.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        Chat.setForeground(new java.awt.Color(2, 70, 70));
        Chat.setRows(5);
        jScrollPane1.setViewportView(Chat);

        Chat_Name.setFont(new java.awt.Font("Sitka Text", 3, 72)); // NOI18N
        Chat_Name.setForeground(new java.awt.Color(0, 102, 102));
        Chat_Name.setText(" Chat");

        START.setBackground(new java.awt.Color(0, 153, 153));
        START.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        START.setText("START");
        START.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                STARTActionPerformed(evt);
            }
        });

        LogOff_Button.setBackground(new java.awt.Color(23, 154, 154));
        LogOff_Button.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        LogOff_Button.setText("Log Off");
        LogOff_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOff_ButtonActionPerformed(evt);
            }
        });

        type_window.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        type_window.setForeground(new java.awt.Color(0, 102, 102));
        type_window.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type_windowActionPerformed(evt);
            }
        });

        Send_button.setBackground(new java.awt.Color(0, 153, 153));
        Send_button.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Send_button.setText("SEND");
        Send_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Send_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(Chat_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LogOff_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(START, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addGroup(backgroundLayout.createSequentialGroup()
                            .addComponent(type_window, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Send_button, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(START)
                        .addGap(26, 26, 26)
                        .addComponent(LogOff_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Chat_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(type_window, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Send_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("CChat  User");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void STARTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_STARTActionPerformed
           
            nameUser = text;
            //type_username.setEditable(false);

            
            if(isConnected==false)
            try 
            {
                        socket = new Socket(Addr, Port);
                        InputStreamReader streamreader = new InputStreamReader(socket.getInputStream());
                        Reader = new BufferedReader(streamreader);
                        Writer = new PrintWriter(socket.getOutputStream());
                        Writer.println(nameUser + ":Has Connected :C");
                        Writer.flush(); 
                        isConnected = true;
                       // myRs.close();
                        
                    
                    }
            catch (Exception ex) 
            {
                Chat.append("            Fail to Connect Server!\n");
               // type_username.setEditable(true);

            }   
            else{
            
                Chat.append("             You already Started! \n");

            }
            ListenThread();

    }//GEN-LAST:event_STARTActionPerformed

    
    
    private void LogOff_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOff_ButtonActionPerformed
        sendDisconnect();
    //    Disconnect();
        
        this.setVisible(false);
        
        //type_username.setEditable(true);

    }//GEN-LAST:event_LogOff_ButtonActionPerformed

    
    private void Send_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Send_buttonActionPerformed
        String nothing = "";
        if ((type_window.getText()).equals(nothing)) {
            type_window.setText("");
            type_window.requestFocus();
        } else {
            try {
               Writer.println(nameUser + ":" + type_window.getText() + ":" + "t");
               Writer.flush(); // flushes the buffer
            } catch (Exception ex) {
                Chat.append("            Could not send Messages.\n"
                            );
            }
            type_window.setText("");
            type_window.requestFocus();
        }

        type_window.setText("");
        type_window.requestFocus();
    }//GEN-LAST:event_Send_buttonActionPerformed

    private void type_windowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type_windowActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_type_windowActionPerformed

    public static void main(String args[]) 
    {     
        text = args[0];
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                new ClientWindow().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Chat;
    private javax.swing.JLabel Chat_Name;
    private javax.swing.JButton LogOff_Button;
    private javax.swing.JButton START;
    private javax.swing.JButton Send_button;
    private javax.swing.JPanel background;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField type_window;
    // End of variables declaration//GEN-END:variables
}
