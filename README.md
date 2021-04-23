# Docusign-Integration
Capstone project for UNO with BuilderTrend

## Starting the App
To build the client, run `gradle bC` or `gradle buildClient`
To build the server, run `gradle bS` or `gradle buildServer`
To build everything and run springboot, run `gradle bA` or `gradle buildAll`

Once the server is up, proceed to http://localhost:8080

### REST API Endpoints
Projects endpoints:
/api/projects/{id}

### ReactJS Client
Until we figure out how npm is supposed to be used within gradle, use these instructions in the meantime.

To start the ReactJS Client, enter the `webapp` directory
`cd src/main/webapp`

Run the client with
`npm start`

http://localhost:3000/
