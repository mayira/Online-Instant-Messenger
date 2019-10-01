# ----------- Description ----------

Online-Instant-Messenger creates socket connection that allows communication between multiple users and one server. Login Window, Client and Server Windows have Graphical User Interfaces. Login window is connected to database that stores users' names and their passwords. The project is written in Java using Netbeans IDE.


#  ----------- Functionality ----------

1. Using netbeans IDE run serverwindow.java first. It will open server window. Press "START" to run the server.

<img src= "https://raw.githubusercontent.com/mayira/Online-Instant-Messenger/master/Desktop/Projects/JavaProject/Messenger/Images/ServerStart.png" width="270" />

 If server wasn't started, the client is not able to connect to the chat.
 
 <img src= "https://github.com/mayira/Online-Instant-Messenger/blob/master/Desktop/Projects/JavaProject/Messenger/Images/ClientFailToConnect.png?raw=true" width="270" />
 
2. Open Login window by running loginwindow.java. It will ask for user name and password. User names and passwords are writted into the database attached to the project and can be modiefied by the database's administrator.

 <img src= "https://github.com/mayira/Online-Instant-Messenger/blob/master/Desktop/Projects/JavaProject/Messenger/Images/Login.png?raw=true" width="270" />

The attached database contains following names and passwords. Enter one of the following:

      john            123
      sara            234
      kate            345
      sam             456

If login information is incorrect, the following popup window appears. 

 <img src= "https://github.com/mayira/Online-Instant-Messenger/blob/master/Desktop/Projects/JavaProject/Messenger/Images/Login%20Failed.png?raw=true" width="450" />


If "OK" pressed, then

<img src= "https://github.com/mayira/Online-Instant-Messenger/blob/master/Desktop/Projects/JavaProject/Messenger/Images/Login%20Failed%20Pressed%20OK.png?raw=true" width="450" />

If the right user name and password are entered: 

<img src= "https://github.com/mayira/Online-Instant-Messenger/blob/master/Desktop/Projects/JavaProject/Messenger/Images/Login%20Success.png?raw=true" width="450" />

If "OK" is pressed, it automatically starts Client Window.

3. 

<img src= "https://github.com/mayira/Online-Instant-Messenger/blob/master/Desktop/Projects/JavaProject/Messenger/Images/Client.png?raw=true" width="270" />

If client presses "START", the connection with server is established. Another client can see that another user is online. 

<img src= "https://github.com/mayira/Online-Instant-Messenger/blob/master/Desktop/Projects/JavaProject/Messenger/Images/Connection.png?raw=true" width="450" />

Clients can send messages by typing messages in the text field and pressing "SEND". Client chat window displays the conversation between users. Server window shows users chat and connections.

<img src= "https://github.com/mayira/Online-Instant-Messenger/blob/master/Desktop/Projects/JavaProject/Messenger/Images/Client%20Chat%20Window.png?raw=true" width="450" />

When user presses "Logoff", client window is closed. Users can see that another user is disconnected

<img src= "https://github.com/mayira/Online-Instant-Messenger/blob/master/Desktop/Projects/JavaProject/Messenger/Images/Client%20Logoff.png?raw=true" width="270" />

4. Server Window shows active users when "online users" is pressed.

<img src= "https://github.com/mayira/Online-Instant-Messenger/blob/master/Desktop/Projects/JavaProject/Messenger/Images/Online%20Users.png?raw=true" width="450" />


To clear chat on the server side, press "clear".

<img src= "https://github.com/mayira/Online-Instant-Messenger/blob/master/Desktop/Projects/JavaProject/Messenger/Images/Clear%20Chat.png?raw=true" width="450" />

To shut down the server press "END".










