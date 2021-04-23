# Docusign-Integration
Capstone project for UNO with BuilderTrend

## Starting the App
Build the client: `gradle bC` or `gradle buildClient`
Build the server: `gradle bS` or `gradle buildServer`
Build everything and run springboot: `gradle bA` or `gradle buildAll`
Start webpack live development server: `gradle sD` or `grade startDev`

Once the server is up, proceed to http://localhost:8080 or http://localhost:3000 if you started the webpack server

### REST API Endpoints
Projects endpoint:
`/api/projects/{id}`

Supported methods: `GET`, `POST`, `DELETE`
