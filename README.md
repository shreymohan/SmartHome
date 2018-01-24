# Smart Home

## An IoT project

### Client

* Here the client is the mobile android application which has a login activity, which proceeds to the User's home on successful login.
* As we login, we see a toast showing us if the raspberry pi present at home and controlling the appliances is present in the network or not.
* The userhome activity has buttons for every appliance. Here, I implemented 3 buttons, Light, Thermostat and weather.
* The Light activity lets you turn on/off the light at home. The Thermostat activity lets you set a particular temperature for the thermostat at home.
* All the information is sent to the server using http requests which POST to the php codes and these php codes update the mysql database accordingly on the XAMPP server.

### Server

* The server(XAMPP) receives information from the client using particular php codes inside the htdocs folder of the XAMPP server hence updating the respective mysql databases.
* A java application also runs on the server simultaneously which communicates both with the mysql database which is being updated by the client and the 
raspberry pi present at home through socket connection.
* An NMAP application also runs on the server which continuosly monitors the connection of all the nodes in the network.
* All the updated information is sent to the raspberry pi using socket connection from the server.
* The changing values of the thermostat as the temperature goes up/down were implemented in thermostat.php where I used threads to increment/decrement temperature requested by the client and send it to the raspberry pi. 

### Raspberry pi

* Here raspberry pi acts as a simulator for a fully automated smart home.
* I used simple mysql database to demonstrate the values updating in the raspberry pi when the client requests any change.




