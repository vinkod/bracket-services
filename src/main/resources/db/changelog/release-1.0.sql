--liquibase formatted sql

--changeset Swaroop:InitialBracketSchemaGeneration(dbms:postgresql failOnError:true splitStatements:false)
CREATE TABLE brackets (
  bracket_id BIGSERIAL PRIMARY KEY,
  name TEXT NOT NULL,
  type INTEGER NOT NULL,
  sport INTEGER,
  total_participants INTEGER NOT NULL DEFAULT 0
);

CREATE TABLE bracket_team (
  id BIGSERIAL PRIMARY KEY,
  bracket_id BIGINT NOT NULL,
  name TEXT NOT NULL,
  seed INTEGER
);
--rollback SELECT 1;
