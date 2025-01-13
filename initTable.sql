CREATE TABLE "Assets"(
    "id" BIGINT NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "category" VARCHAR(255) NOT NULL,
    "value" DECIMAL(16, 2) NOT NULL,
    "user_id" BIGINT NOT NULL,
    "interest" DECIMAL(8, 2) NULL,
    "acquired_at" DATE NULL,
    "created_at" DATE NOT NULL
);
ALTER TABLE
    "Assets" ADD PRIMARY KEY("id");
CREATE INDEX "assets_category_index" ON
    "Assets"("category");
CREATE INDEX "assets_value_index" ON
    "Assets"("value");
CREATE INDEX "assets_user_id_index" ON
    "Assets"("user_id");
CREATE INDEX "assets_interest_index" ON
    "Assets"("interest");
CREATE INDEX "assets_acquired_at_index" ON
    "Assets"("acquired_at");
CREATE INDEX "assets_created_at_index" ON
    "Assets"("created_at");
COMMENT
ON COLUMN
    "Assets"."category" IS 'this would be the type of asset (e.g. Securities, Cash, Real Estate)';
CREATE TABLE "Liabilities"(
    "id" BIGINT NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "category" VARCHAR(255) NOT NULL,
    "value" DECIMAL(16, 2) NOT NULL,
    "user_id" BIGINT NOT NULL,
    "due_at" DATE NULL,
    "interest" DECIMAL(8, 2) NULL,
    "acquired_at" DATE NULL,
    "created_at" DATE NOT NULL
);
ALTER TABLE
    "Liabilities" ADD PRIMARY KEY("id");
CREATE INDEX "liabilities_category_index" ON
    "Liabilities"("category");
CREATE INDEX "liabilities_value_index" ON
    "Liabilities"("value");
CREATE INDEX "liabilities_user_id_index" ON
    "Liabilities"("user_id");
CREATE INDEX "liabilities_due_at_index" ON
    "Liabilities"("due_at");
CREATE INDEX "liabilities_interest_index" ON
    "Liabilities"("interest");
CREATE INDEX "liabilities_acquired_at_index" ON
    "Liabilities"("acquired_at");
CREATE INDEX "liabilities_created_at_index" ON
    "Liabilities"("created_at");
COMMENT
ON COLUMN
    "Liabilities"."category" IS 'this would be the type (e.g. loans, credit cards, mortgages)';
CREATE TABLE "Users"(
    "id" BIGINT NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "email" VARCHAR(255) NOT NULL,
    "created_at" DATE NOT NULL,
    "password_hash" BIGINT NOT NULL
);
ALTER TABLE
    "Users" ADD PRIMARY KEY("id");
CREATE INDEX "users_name_index" ON
    "Users"("name");
CREATE INDEX "users_email_index" ON
    "Users"("email");
CREATE INDEX "users_created_at_index" ON
    "Users"("created_at");
CREATE TABLE "Transactions"(
    "id" BIGINT NOT NULL,
    "user_id" BIGINT NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "done_at" DATE NOT NULL,
    "created_at" DATE NOT NULL,
    "value" DECIMAL(16, 2) NOT NULL
    "category" VARCHAR(255) NOT NULL,
);
ALTER TABLE
    "Transactions" ADD PRIMARY KEY("id");
CREATE INDEX "transactions_user_id_index" ON
    "Transactions"("user_id");
CREATE INDEX "transactions_done_at_index" ON
    "Transactions"("done_at");
CREATE INDEX "transactions_created_at_index" ON
    "Transactions"("created_at");
CREATE INDEX "transactions_value_index" ON
    "Transactions"("value");
CREATE INDEX "transactions_category_index" ON
    "Transactions"("category");
ALTER TABLE
    "Assets" ADD CONSTRAINT "assets_user_id_foreign" FOREIGN KEY("user_id") REFERENCES "Users"("id") ON DELETE CASCADE;
ALTER TABLE
    "Liabilities" ADD CONSTRAINT "liabilities_user_id_foreign" FOREIGN KEY("user_id") REFERENCES "Users"("id") ON DELETE CASCADE;
ALTER TABLE
    "Transactions" ADD CONSTRAINT "transactions_user_id_foreign" FOREIGN KEY("user_id") REFERENCES "Users"("id") ON DELETE CASCADE;