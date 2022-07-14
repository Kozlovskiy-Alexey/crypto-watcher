CREATE DATABASE idf_crypto_service;

CREATE TABLE crypto_watcher.crypto
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

CREATE TABLE crypto_watcher.btc_price
(
    id                 BIGSERIAL PRIMARY KEY,
    crypto_id          INT REFERENCES crypto_watcher.crypto (id),
    rank               INT,
    price_usd          DECIMAL,
    percent_change_24h DECIMAL,
    percent_change_1h  DECIMAL,
    percent_change_7d  DECIMAL,
    market_cap_usd     DECIMAL,
    volume24           DECIMAL,
    volume24_native    DECIMAL,
    csupply            DECIMAL,
    price_btc          DECIMAL,
    tsupply            DECIMAL,
    msupply            DECIMAL
);

CREATE TABLE crypto_watcher.eth_price
(
    id                 BIGSERIAL PRIMARY KEY,
    crypto_id          INT REFERENCES crypto_watcher.crypto (id),
    rank               INT,
    price_usd          DECIMAL,
    percent_change_24h DECIMAL,
    percent_change_1h  DECIMAL,
    percent_change_7d  DECIMAL,
    market_cap_usd     DECIMAL,
    volume24           DECIMAL,
    volume24_native    DECIMAL,
    csupply            DECIMAL,
    price_btc          DECIMAL,
    tsupply            DECIMAL,
    msupply            DECIMAL
);


CREATE TABLE crypto_watcher.sol_price
(
    id                 BIGSERIAL PRIMARY KEY,
    crypto_id          INT REFERENCES crypto_watcher.crypto (id),
    rank               INT,
    price_usd          DECIMAL,
    percent_change_24h DECIMAL,
    percent_change_1h  DECIMAL,
    percent_change_7d  DECIMAL,
    market_cap_usd     DECIMAL,
    volume24           DECIMAL,
    volume24_native    DECIMAL,
    csupply            DECIMAL,
    price_btc          DECIMAL,
    tsupply            DECIMAL,
    msupply            DECIMAL
);


CREATE TABLE crypto_watcher.users
(
    id          VARCHAR(128) PRIMARY KEY,
    symbol      VARCHAR(32) REFERENCES crypto_watcher.crypto (symbol),
    entry_price DECIMAL
);

DROP TABLE crypto_watcher.users;
DROP TABLE crypto_watcher.crypto;
DROP TABLE crypto_watcher.btc_price;
DROP TABLE crypto_watcher.eth_price;
DROP TABLE crypto_watcher.sol_price;

