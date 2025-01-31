CREATE TABLE IF NOT EXISTS metal_rate
(
    id   bigserial PRIMARY KEY,
    code varchar(2) NOT NULL,
    selling_rate decimal(256)NOT NULL,
    buying_rate decimal(256)NOT NULL,
    update_at TIMESTAMP NOT NULL
    );