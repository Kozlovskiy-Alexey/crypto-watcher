-- CREATE DATABASE idf_crypto_service;

CREATE TABLE IF NOT EXISTS crypto_watcher.crypto
(
    id          INT PRIMARY KEY,
    symbol      VARCHAR(32) UNIQUE,
    crypto_name VARCHAR(32) UNIQUE,
    name_id     VARCHAR(32) unique
);

INSERT INTO crypto_watcher.crypto (id, symbol, crypto_name, name_id)
VALUES (90, 'BTC', 'Bitcoin', 'bitcoin'),
       (80, 'ETH', 'Ethereum', 'ethereum'),
       (48543, 'SOL', 'Solana', 'solana');

CREATE TABLE IF NOT EXISTS crypto_watcher.btc_price
(
    id                 BIGSERIAL PRIMARY KEY,
    crypto_id          INT REFERENCES crypto_watcher.crypto (id),
    rank               INT,
    price_usd          DECIMAL(19,2),
    percent_change_24h DECIMAL(19,2),
    percent_change_1h  DECIMAL(19,2),
    percent_change_7d  DECIMAL(19,2),
    market_cap_usd     DECIMAL(19,2),
    volume24           DECIMAL(19,2),
    volume24_native    DECIMAL(19,2),
    csupply            DECIMAL(19,2),
    price_btc          DECIMAL(3,2),
    tsupply            DECIMAL(19,2),
    msupply            DECIMAL(19,2)
);

CREATE TABLE IF NOT EXISTS crypto_watcher.eth_price
(
    id                 BIGSERIAL PRIMARY KEY,
    crypto_id          INT REFERENCES crypto_watcher.crypto (id),
    rank               INT,
    price_usd          DECIMAL(19,2),
    percent_change_24h DECIMAL(19,2),
    percent_change_1h  DECIMAL(19,2),
    percent_change_7d  DECIMAL(19,2),
    market_cap_usd     DECIMAL(19,2),
    volume24           DECIMAL(19,2),
    volume24_native    DECIMAL(19,2),
    csupply            DECIMAL(19,2),
    price_btc          DECIMAL(19,9),
    tsupply            DECIMAL(19,2),
    msupply            DECIMAL(19,2)
);


CREATE TABLE IF NOT EXISTS crypto_watcher.sol_price
(
    id                 BIGSERIAL PRIMARY KEY,
    crypto_id          INT REFERENCES crypto_watcher.crypto (id),
    rank               INT,
    price_usd          DECIMAL(19,2),
    percent_change_24h DECIMAL(19,2),
    percent_change_1h  DECIMAL(19,2),
    percent_change_7d  DECIMAL(19,2),
    market_cap_usd     DECIMAL(19,2),
    volume24           DECIMAL(19,2),
    volume24_native    DECIMAL(19,2),
    csupply            DECIMAL(19,2),
    price_btc          DECIMAL(19,9),
    tsupply            DECIMAL(19,2),
    msupply            DECIMAL(19,2)
);


CREATE TABLE IF NOT EXISTS crypto_watcher.users
(
    id          VARCHAR(128) PRIMARY KEY,
    symbol      VARCHAR(32) REFERENCES crypto_watcher.crypto (symbol),
    entry_price DECIMAL(19,2)
);

-- DROP TABLE crypto_watcher.users;
-- DROP TABLE crypto_watcher.crypto;
-- DROP TABLE crypto_watcher.btc_price;
-- DROP TABLE crypto_watcher.eth_price;
-- DROP TABLE crypto_watcher.sol_price;


