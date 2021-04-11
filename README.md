# Docusign-Integration
Capstone project for UNO with BuilderTrend

## Starting the App
to start the docusign app, run:
`gradle bR`

This will install dependencies, build the app, run the tests, deploy it, test the server, and start it as well.

Once the server is up, proceed to http://localhost:8080

### REST API Endpoints
http://localhost:8080/api/all JSON structure containing every project in the database (for testing mainly, we should probably get rid of this eventually)

http://localhost:8080/api/builder?builderName=Enter%20name%20here
This endpoint returns all documents that belong to the builder specified in builderName.

The mock data should return data from this endpoint:
http://localhost:8080/api/builder?builderName=Blake%20Bartenbach

### ReactJS Client
Until we figure out how npm is supposed to be used within gradle, use these instructions in the meantime.

To start the ReactJS Client, enter the `webapp` directory
`cd src/main/webapp`

Run the client with
`npm start`

http://localhost:3000/
