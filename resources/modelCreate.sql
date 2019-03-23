CREATE TABLE "Project" (
  "id" int PRIMARY KEY,
  "name" varchar,
  "description" varchar
);

CREATE TABLE "Issue" (
  "id" int PRIMARY KEY,
  "projectId" int,
  "description" varchar,
  "creationDate" timestamp,
  "closeDate" timestamp,
  "labelId" int,
  "stateId" int,
  "ownerId" int
);

CREATE TABLE "tid_issueState" (
  "id" int PRIMARY KEY,
  "stateName" varchar,
  "description" varchar
);

CREATE TABLE "tid_issueStateTransition" (
  "id" int PRIMARY KEY,
  "current" int,
  "next" int
);

CREATE TABLE "tid_issueLabel" (
  "id" int PRIMARY KEY,
  "name" varchar,
  "description" varchar
);

CREATE TABLE "trl_projectIssueState" (
  "projectId" int,
  "issueStateId" int,
  PRIMARY KEY("projectId", "issueStateId")
);

CREATE TABLE "trl_projectIssueStateTransition" (
  "projectId" int,
  "stateTransitionId" int,
  PRIMARY KEY("projectId", "stateTransitionId")
);

CREATE TABLE "trl_projectIssueLabel" (
  "projectId" int,
  "labelId" int,
  PRIMARY KEY("projectId", "labelId")
);

CREATE TABLE "Comment" (
  "id" int PRIMARY KEY,
  "issueId" int,
  "user" int,
  "data" timestamp,
  "body" varchar
);

ALTER TABLE "Issue" ADD FOREIGN KEY ("projectId") REFERENCES "Project" ("id");

ALTER TABLE "trl_projectIssueState" ADD FOREIGN KEY ("projectId") REFERENCES "Project" ("id");

ALTER TABLE "trl_projectIssueState" ADD FOREIGN KEY ("issueStateId") REFERENCES "tid_issueState" ("id");

ALTER TABLE "trl_projectIssueStateTransition" ADD FOREIGN KEY ("projectId") REFERENCES "Project" ("id");

ALTER TABLE "trl_projectIssueStateTransition" ADD FOREIGN KEY ("stateTransitionId") REFERENCES "tid_issueStateTransition" ("id");

ALTER TABLE "trl_projectIssueLabel" ADD FOREIGN KEY ("projectId") REFERENCES "Project" ("id");

ALTER TABLE "trl_projectIssueLabel" ADD FOREIGN KEY ("labelId") REFERENCES "tid_issueLabel" ("id");

ALTER TABLE "Comment" ADD FOREIGN KEY ("issueId") REFERENCES "Issue" ("id");