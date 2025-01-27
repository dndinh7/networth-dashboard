CREATE TABLE "assets"(
    "id" BIGSERIAL NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "category" VARCHAR(255) NOT NULL,
    "value" DECIMAL(16, 2) NOT NULL,
    "user_id" BIGINT NOT NULL,
    "interest" DECIMAL(8, 2) NULL,
    "acquired_at" TIMESTAMP NULL,
    "created_at" TIMESTAMP NOT NULL
);
ALTER TABLE
    "assets" ADD PRIMARY KEY("id");
CREATE INDEX "assets_category_index" ON
    "assets"("category");
CREATE INDEX "assets_value_index" ON
    "assets"("value");
CREATE INDEX "assets_user_id_index" ON
    "assets"("user_id");
CREATE INDEX "assets_interest_index" ON
    "assets"("interest");
CREATE INDEX "assets_acquired_at_index" ON
    "assets"("acquired_at");
CREATE INDEX "assets_created_at_index" ON
    "assets"("created_at");
COMMENT
ON COLUMN
    "assets"."category" IS 'this would be the type of asset (e.g. Securities, Cash, Real Estate)';
CREATE TABLE "liabilities"(
    "id" BIGSERIAL NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "category" VARCHAR(255) NOT NULL,
    "value" DECIMAL(16, 2) NOT NULL,
    "user_id" BIGINT NOT NULL,
    "due_at" TIMESTAMP NULL,
    "interest" DECIMAL(8, 2) NULL,
    "acquired_at" TIMESTAMP NULL,
    "created_at" TIMESTAMP NOT NULL
);
ALTER TABLE
    "liabilities" ADD PRIMARY KEY("id");
CREATE INDEX "liabilities_category_index" ON
    "liabilities"("category");
CREATE INDEX "liabilities_value_index" ON
    "liabilities"("value");
CREATE INDEX "liabilities_user_id_index" ON
    "liabilities"("user_id");
CREATE INDEX "liabilities_due_at_index" ON
    "liabilities"("due_at");
CREATE INDEX "liabilities_interest_index" ON
    "liabilities"("interest");
CREATE INDEX "liabilities_acquired_at_index" ON
    "liabilities"("acquired_at");
CREATE INDEX "liabilities_created_at_index" ON
    "liabilities"("created_at");
COMMENT
ON COLUMN
    "liabilities"."category" IS 'this would be the type (e.g. loans, credit cards, mortgages)';
CREATE TABLE "users"(
    "id" BIGSERIAL NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "email" VARCHAR(255) NOT NULL,
    "created_at" TIMESTAMP NOT NULL,
    "password_hash" VARCHAR(255) NOT NULL,
    "role" VARCHAR(255) NULL,
    "is_verified" BOOLEAN NOT NULL DEFAULT FALSE,
    "is_active" BOOLEAN NOT NULL DEFAULT TRUE
);
ALTER TABLE
    "users" ADD PRIMARY KEY("id");
ALTER TABLE users
    ADD CONSTRAINT unique_email UNIQUE (email);
CREATE INDEX "users_name_index" ON
    "users"("name");
CREATE INDEX "users_email_index" ON
    "users"("email");
CREATE INDEX "users_created_at_index" ON
    "users"("created_at");
CREATE TABLE "transactions"(
    "id" BIGSERIAL NOT NULL,
    "user_id" BIGINT NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "done_at" TIMESTAMP NOT NULL,
    "created_at" TIMESTAMP NOT NULL,
    "value" DECIMAL(16, 2) NOT NULL,
    "category" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "transactions" ADD PRIMARY KEY("id");
CREATE INDEX "transactions_user_id_index" ON
    "transactions"("user_id");
CREATE INDEX "transactions_done_at_index" ON
    "transactions"("done_at");
CREATE INDEX "transactions_created_at_index" ON
    "transactions"("created_at");
CREATE INDEX "transactions_value_index" ON
    "transactions"("value");
CREATE INDEX "transactions_category_index" ON
    "transactions"("category");
ALTER TABLE
    "assets" ADD CONSTRAINT "assets_user_id_foreign" FOREIGN KEY("user_id") REFERENCES "users"("id") ON DELETE CASCADE;
ALTER TABLE
    "liabilities" ADD CONSTRAINT "liabilities_user_id_foreign" FOREIGN KEY("user_id") REFERENCES "users"("id") ON DELETE CASCADE;
ALTER TABLE
    "transactions" ADD CONSTRAINT "transactions_user_id_foreign" FOREIGN KEY("user_id") REFERENCES "users"("id") ON DELETE CASCADE;