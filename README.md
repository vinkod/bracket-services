# Bracket Related Backend Services for BracketPark

## DB Setup (Do-It-Once thing!) 
**This section is only need the first time**
This project needs a Postgres DB. So, spin up a postgres DB container
* Open terminal at the project folder
* `docker build -t postgres docker`
* `docker run -di -p 32222:5432 postgres`

## Test DB Connection
You can check your DB connection with 
* Container powershell with `psql -h localhost -U postgres` -> `\l`. Should `brackets` db.
* Can you a DB Tool like Valentina Studio

## Run Flyway Migrations before `bootrun`
* `gradle flywayMigrate -i`

## Run Boot
* `gradle bootrun`
