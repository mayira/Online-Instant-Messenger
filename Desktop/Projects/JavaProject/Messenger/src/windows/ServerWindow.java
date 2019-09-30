/*   
 Project:   Online Instant Messenger
*/
package windows;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.*;
import java.util.*;


public class ServerWindow extends javax.swing.JFrame 
{
   ArrayList<String> Users;
   ArrayList ClientOutputStreams;
   
   public class clientManager implements Runnable	
   {
       BufferedReader reader;
       Socket Socket;
       PrintWriter Client;

       public clientManager(Socket clientSocket, PrintWriter user) 
       {
            Client = user;
            try 
            {
                Socket = clientSocket;
                InputStreamReader isReader = new InputStreamReader(Socket.getInputStream());
                reader = new BufferedReader(isReader);
            }
            catch (Exception ex) 
            {
                c_chat.append("Error\n");
            }

       }

       @Override
       public void run() 
       {
            String message;
            String connect = "C";
            String disconnect = "D";
            String chat = "t" ;
            String[] data;

            try 
            {
                while ((message = reader.readLine()) != null) 
                {
                  
                    data = message.split(":");
                    
                    for (String token:data) 
                    {
                        c_chat.append(token + "\n");
                    }

                    if (data[2].equals(connect)) 
                    {
                        Spread((data[0] + ":" + data[1] + ":" + chat));
                        userAdd(data[0]);
                    } 
                    else if (data[2].equals(disconnect)) 
                    {
                        Spread((data[0] + ": disconnected" + ":" + chat));
                        userRemove(data[0]);
                    } 
                    else if (data[2].equals(chat)) 
                    {
                        Spread(message);
                    } 
                    else 
                    {
                     //  c_chat.append("Disconnected\n");
                    }
                } 
             } 
             catch (Exception ex) 
             {
                c_chat.append("disconnected \n");
                ex.printStackTrace();
                ClientOutputStreams.remove(Client);
             }}}

    public ServerWindow() 
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new javax.swing.JPanel();
        Chat_Name1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        c_chat = new javax.swing.JTextArea();
        Start_Button = new javax.swing.JButton();
        End_Button = new javax.swing.JButton();
        Online_Users_Button = new javax.swing.JButton();
        Clear_Button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CChat Server");
        setLocation(new java.awt.Point(700, 300));
        setName("server"); // NOI18N
        setResizable(false);

        background1.setBackground(new java.awt.Color(0, 102, 102));

        Chat_Name1.setFont(new java.awt.Font("Sitka Text", 3, 72)); // NOI18N
        Chat_Name1.setForeground(new java.awt.Color(15, 228, 212));
        Chat_Name1.setText("C_Chat");

        c_chat.setColumns(20);
        c_chat.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        c_chat.setRows(5);
        jScrollPane1.setViewportView(c_chat);

        Start_Button.setBackground(new java.awt.Color(255, 255, 255));
        Start_Button.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Start_Button.setForeground(new java.awt.Color(0, 102, 102));
        Start_Button.setText("START");
        Start_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Start_ButtonActionPerformed(evt);
            }
        });

        End_Button.setBackground(new java.awt.Color(255, 255, 255));
        End_Button.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        End_Button.setForeground(new java.awt.Color(0, 102, 102));
        End_Button.setText("END");
        End_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                End_ButtonActionPerformed(evt);
            }
        });

        Online_Users_Button.setBackground(new java.awt.Color(255, 255, 255));
        Online_Users_Button.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Online_Users_Button.setForeground(new java.awt.Color(0, 102, 102));
        Online_Users_Button.setText("Online Users");
        Online_Users_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Online_Users_ButtonActionPerformed(evt);
            }
        });

        Clear_Button.setBackground(new java.awt.Color(255, 255, 255));
        Clear_Button.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Clear_Button.setForeground(new java.awt.Color(0, 102, 102));
        Clear_Button.setText("Clear");
        Clear_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Clear_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Chat_Name1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Start_Button, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(End_Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Clear_Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Online_Users_Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(background1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Chat_Name1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(background1Layout.createSequentialGroup()
                        .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Start_Button)
                            .addComponent(Online_Users_Button))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(End_Button)
                            .addComponent(Clear_Button))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        Chat_Name1.getAccessibleContext().setAccessibleName("CChat");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Clear_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Clear_ButtonActionPerformed
        c_chat.setText(""); //reset
    }//GEN-LAST:event_Clear_ButtonActionPerformed

    // for test
    public void Clear_ButtonAction() {
        ActionEvent event;
        long when;
        when  = System.currentTimeMillis();
        event = new ActionEvent(this.Clear_Button, ActionEvent.ACTION_PERFORMED, "Anything", when, 0);
        Clear_ButtonActionPerformed(event);
    }
    //
    
    
    
    private void Online_Users_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Online_Users_ButtonActionPerformed
        c_chat.append("\n Online users : \n");
        for (String current_user : Users)
        {
            c_chat.append(current_user);
            c_chat.append("\n");
        }

    }//GEN-LAST:event_Online_Users_ButtonActionPerformed

   // for test
    public void Online_Users_ButtonAction() {
        ActionEvent event;
        long when;
        when  = System.currentTimeMillis();
        event = new ActionEvent(this.Online_Users_Button, ActionEvent.ACTION_PERFORMED, "Anything", when, 0);
        Online_Users_ButtonActionPerformed(event);
    } 
  
   // 
    private void End_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_End_ButtonActionPerformed
        
        Spread("Server: turning off \n:t");
        try
        {
            
            Thread.sleep(450);
            
            CloseMe();
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();}
          c_chat.append("Shutting down\n");
        Spread("Server: turning off \n:t");
     
        c_chat.setText("");
    }//GEN-LAST:event_End_ButtonActionPerformed

    
    private void Start_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Start_ButtonActionPerformed
        Thread starter = new Thread(new Connection());
        starter.start();

        c_chat.append("Booting\n");
    }//GEN-LAST:event_Start_ButtonActionPerformed

    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(() -> {
            new ServerWindow().setVisible(true);
        });
    }
    // this class will be initialized or started when the startbutton has been pressed.
    // first component that will run 
    // it is runned by threds
    public class Connection implements Runnable 
    {
        @Override
        public void run() 
        {
            ClientOutputStreams = new ArrayList();
            Users = new ArrayList(); 
            //establish connection
            try 
            {
                // creating server socket 
                ServerSocket serverSock = new ServerSocket(1000);
                boolean flag = true;
                while (flag) 
                {                
                                // creting client socket 
				Socket clientSock = serverSock.accept();
				PrintWriter writer = new PrintWriter(clientSock.getOutputStream());
                                // adding clients in to an array
				ClientOutputStreams.add(writer);
                                // creating threds to listen to every client 
				Thread listener = new Thread(new clientManager(clientSock, writer));
				listener.start();
				c_chat.append("Connection successful \n");
                }
            }
            catch (Exception ex)
            {
                c_chat.append("ERROR \n");
            }
        }
    }
    
    public void userAdd (String data) 
    {
        String message;
        String add = ": :C";
       
        String name = data;
        Users.add(name);
        c_chat.append(name + " added. \n");
        String[] tempList = new String[(Users.size())];
        Users.toArray(tempList);

        for (String token:tempList) 
        {
            message = (token + add);
   
        }
    
    }
    
    public void userRemove (String data) 
    {
        String message;
        String add = ": :C";
        
        String name = data;
        Users.remove(name);
        c_chat.append(name + " removed.\n");
        String[] tempList = new String[(Users.size())];
        Users.toArray(tempList);

        for (String token:tempList) 
        {
            message = (token + add);
         
        }
       
    }
    
    public void Spread(String message) 
    {
	Iterator it = ClientOutputStreams.iterator();
        while (it.hasNext()) 
        {
            try 
            {
                PrintWriter writer = (PrintWriter) it.next();
		writer.println(message);
		//c_chat.append("Sending: " + message + "\n");
                writer.flush();
                c_chat.setCaretPosition(c_chat.getDocument().getLength());
            } 
            catch (Exception ex) 
            {
		c_chat.append("Error \n");
            }
        } 
    }
      private void CloseMe()
            {
                WindowEvent meClose= new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
                Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(meClose);
                
    }
      
      
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Chat_Name1;
    private javax.swing.JButton Clear_Button;
    private javax.swing.JButton End_Button;
    private javax.swing.JButton Online_Users_Button;
    private javax.swing.JButton Start_Button;
    private javax.swing.JPanel background1;
    private javax.swing.JTextArea c_chat;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
