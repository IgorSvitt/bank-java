﻿CREATE TABLE clients
(
    id         int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    name       varchar(100) not null,
    created_at TIMESTAMP WITH TIME ZONE,
    updated_at TIMESTAMP WITH TIME ZONE
);

CREATE TABLE accounts
(
    id         int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    balance    decimal not null,
    client_id  int REFERENCES clients (id),
    currency   varchar(4),
    created_at TIMESTAMP WITH TIME ZONE,
    updated_at TIMESTAMP WITH TIME ZONE
);

CREATE TABLE transactions
(
    id         int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    sender_account  int REFERENCES accounts (id),
    receiver_account  int REFERENCES accounts (id),
    currency   varchar(4),
    amount   decimal,
    created_at TIMESTAMP WITH TIME ZONE
);

