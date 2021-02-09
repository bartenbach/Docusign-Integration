# Docusign-Integration
Capstone project for UNO with BuilderTrend

## server
To start the Docusign server, enter the server directory
`cd server`
then, start the server with gradle
`gradle bR`

### server REST endpoints
http://localhost:8080/all JSON structure containing every document in the database (for testing mainly, we should probably get rid of this eventually)

http://localhost:8080/builder?builderName=Enter%20name%20here
This endpoint returns all documents that belong to the builder specified in builderName.
The mock data should return data from this endpoint:
http://localhost:8080/builder?builderName=Blake%20Bartenbach
