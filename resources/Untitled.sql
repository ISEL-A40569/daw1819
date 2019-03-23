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
  "projectId" int PRIMARY KEY,
  "issueStateId" int PRIMARY KEY
);

CREATE TABLE "trl_projectIssueStateTransition" (
  "projectId" int PRIMARY KEY,
  "stateTransitionId" int PRIMARY KEY
);

CREATE TABLE "trl_projectIssueLabel" (
  "projectId" int PRIMARY KEY,
  "labelId" int PRIMARY KEY
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