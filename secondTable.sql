CREATE TABLE "users"(
    "id" BIGSERIAL PRIMARY KEY,
    "name" VARCHAR(255) NOT NULL,
    "email" VARCHAR(255) NOT NULL,
    "created_at" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    "password_hash" BIGINT NOT NULL,
    "is_verified" BOOLEAN NOT NULL,
    "role" VARCHAR(255) NULL,
    "is_active" BOOLEAN NOT NULL
);
CREATE INDEX "users_name_index" ON
    "users"("name");
CREATE UNIQUE INDEX "users_email_index" ON
    "users"("email");
CREATE INDEX "users_created_at_index" ON
    "users"("created_at");
CREATE INDEX "users_role_index" ON
    "users"("role");
    
CREATE TABLE "assets"(
    "id" BIGSERIAL PRIMARY KEY,
    "version" INT NOT NULL DEFAULT 1,
    "date" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "user_id" BIGINT NOT NULL,
    "value" DECIMAL(16, 2) NOT NULL,
    "source" VARCHAR(255) NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
CREATE INDEX "assets_version_index" ON
    "assets"("version");
CREATE INDEX "assets_date_index" ON
    "assets"("date");
CREATE INDEX "assets_name_index" ON
    "assets"("name");
CREATE INDEX "assets_user_id_index" ON
    "assets"("user_id");
CREATE INDEX "assets_value_index" ON
    "assets"("value");
CREATE INDEX "assets_source_index" ON
    "assets"("source");

CREATE TABLE "liabilities"(
    "id" BIGSERIAL PRIMARY KEY,
    "version" INT NOT NULL DEFAULT 1,
    "date" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "user_id" BIGINT NOT NULL,
    "value" DECIMAL(16, 2) NOT NULL,
    "interest" DECIMAL(5, 2) NULL,
    "due_at" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    "source" VARCHAR(255) NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
CREATE INDEX "liabilities_version_index" ON
    "liabilities"("version");
CREATE INDEX "liabilities_date_index" ON
    "liabilities"("date");
CREATE INDEX "liabilities_name_index" ON
    "liabilities"("name");
CREATE INDEX "liabilities_user_id_index" ON
    "liabilities"("user_id");
CREATE INDEX "liabilities_value_index" ON
    "liabilities"("value");
CREATE INDEX "liabilities_interest_index" ON
    "liabilities"("interest");
CREATE INDEX "liabilities_due_at_index" ON
    "liabilities"("due_at");
CREATE INDEX "liabilities_source_index" ON
    "liabilities"("source");

CREATE TABLE "transactions"(
    "id" BIGSERIAL PRIMARY KEY,
    "date" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "user_id" BIGINT NOT NULL,
    "value" DECIMAL(16, 2) NOT NULL,
    "is_credit" BOOLEAN NOT NULL,
    "source" VARCHAR(255) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
CREATE INDEX "transactions_date_index" ON
    "transactions"("date");
CREATE INDEX "transactions_name_index" ON
    "transactions"("name");
CREATE INDEX "transactions_user_id_index" ON
    "transactions"("user_id");
CREATE INDEX "transactions_value_index" ON
    "transactions"("value");
CREATE INDEX "transactions_is_credit_index" ON
    "transactions"("is_credit");

CREATE TABLE "stocks"(
    "id" BIGSERIAL PRIMARY KEY,
    "asset_id" BIGINT NOT NULL,
    "shares" DECIMAL(16, 2) NOT NULL,
    "ticker" VARCHAR(255) NOT NULL,
    "cost_basis" DECIMAL(16, 2) NOT NULL,
    "cur_share_price" DECIMAL(12, 2) NOT NULL,
    FOREIGN KEY (asset_id) REFERENCES assets(id) ON DELETE CASCADE
);
CREATE INDEX "stocks_asset_id_index" ON
    "stocks"("asset_id");
CREATE INDEX "stocks_shares_index" ON
    "stocks"("shares");
CREATE INDEX "stocks_ticker_index" ON
    "stocks"("ticker");
CREATE INDEX "stocks_cost_basis_index" ON
    "stocks"("cost_basis");
CREATE INDEX "stocks_cur_share_price_index" ON
    "stocks"("cur_share_price");

CREATE TABLE "cash"(
    "id" BIGSERIAL PRIMARY KEY,
    "asset_id" BIGINT NOT NULL,
    "interest" DECIMAL(5, 2) NULL,
    FOREIGN KEY (asset_id) REFERENCES assets(id) ON DELETE CASCADE
);
CREATE INDEX "cash_asset_id_index" ON
    "cash"("asset_id");
CREATE INDEX "cash_interest_index" ON
    "cash"("interest");

CREATE TABLE "networth_snapshot"(
    "id" BIGSERIAL PRIMARY KEY,
    "version" INT NOT NULL DEFAULT 1,
    "user_id" BIGINT NOT NULL,
    "value" DECIMAL(16, 2) NOT NULL,
    "date" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
CREATE INDEX "networth_snapshot_version_index" ON
    "networth_snapshot"("version");
CREATE INDEX "networth_snapshot_user_id_index" ON
    "networth_snapshot"("user_id");
CREATE INDEX "networth_snapshot_value_index" ON
    "networth_snapshot"("value");
CREATE INDEX "networth_snapshot_date_index" ON
    "networth_snapshot"("date");

CREATE TABLE "properties"(
    "id" BIGSERIAL PRIMARY KEY,
    "asset_id" BIGINT NOT NULL,
    FOREIGN KEY (asset_id) REFERENCES assets(id) ON DELETE CASCADE
);
CREATE INDEX "properties_asset_id_index" ON
    "properties"("asset_id");

CREATE TABLE "loans"(
    "id" BIGSERIAL PRIMARY KEY,
    "liability_id" BIGINT NOT NULL,
    FOREIGN KEY (liability_id) REFERENCES liabilities(id) ON DELETE CASCADE
);
CREATE INDEX "loans_liability_id_index" ON
    "loans"("liability_id");
