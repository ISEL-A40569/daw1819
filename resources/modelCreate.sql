CREATE TABLE  Project  (
   projectId  int PRIMARY KEY,
   name  varchar UNIQUE ,
   description  varchar
);

CREATE TABLE  Issue  (
   issueId  int PRIMARY KEY,
   projectId  int NOT NULL,
   description  varchar,
   creationDate  timestamp NOT NULL,
   closeDate  timestamp,
   labelId  int NOT NULL,
   stateId  int NOT NULL,
   ownerId  int
);

CREATE TABLE  tid_issueState  (
   issueStateId  int PRIMARY KEY,
   stateName  varchar NOT NULL,
   description  varchar
);

CREATE TABLE  tid_issueStateTransition  (
   issueStateTransitionId  int PRIMARY KEY,
   current  int NOT NULL,
   next  int NOT NULL
);

CREATE TABLE  tid_issueLabel  (
   issueLabelId  int PRIMARY KEY,
   name  varchar NOT NULL,
   description  varchar
);

CREATE TABLE  trl_projectIssueState  (
   projectId  int,
   issueStateId  int,
  PRIMARY KEY( projectId ,  issueStateId )
);

CREATE TABLE  trl_projectIssueStateTransition  (
   projectId  int,
   stateTransitionId  int,
  PRIMARY KEY( projectId ,  stateTransitionId )
);

CREATE TABLE  trl_projectIssueLabel  (
   projectId  int,
   labelId  int,
  PRIMARY KEY( projectId ,  labelId )
);

CREATE TABLE  Comment  (
   commentId  int PRIMARY KEY,
   issueId  int NOT NULL,
   _user  int,
   _date  timestamp NOT NULL,
   body  varchar
);

ALTER TABLE  Issue  ADD FOREIGN KEY ( projectId ) REFERENCES  Project  ( projectId );

ALTER TABLE  trl_projectIssueState  ADD FOREIGN KEY ( projectId ) REFERENCES  Project  ( projectId );

ALTER TABLE  trl_projectIssueState  ADD FOREIGN KEY ( issueStateId ) REFERENCES  tid_issueState  ( issueStateId );

ALTER TABLE  trl_projectIssueStateTransition  ADD FOREIGN KEY ( projectId ) REFERENCES  Project  ( projectId );

ALTER TABLE  trl_projectIssueStateTransition  ADD FOREIGN KEY ( stateTransitionId ) REFERENCES  tid_issueStateTransition  ( issueStateTransitionId );

ALTER TABLE  trl_projectIssueLabel  ADD FOREIGN KEY ( projectId ) REFERENCES  Project  ( projectId );

ALTER TABLE  trl_projectIssueLabel  ADD FOREIGN KEY ( labelId ) REFERENCES  tid_issueLabel  ( issueLabelId );

ALTER TABLE  Comment  ADD FOREIGN KEY ( issueId ) REFERENCES  Issue  ( issueId );