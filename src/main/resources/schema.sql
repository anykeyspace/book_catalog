CREATE TABLE IF NOT EXISTS Author (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    country VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS Book (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL,
    name VARCHAR(50) NOT NULL,
    year INTEGER,
    genre VARCHAR(50),
    author_id INTEGER,
    description VARCHAR(200)
);

ALTER TABLE Book ADD FOREIGN KEY (author_id) REFERENCES Author(id);

CREATE INDEX IF NOT EXISTS idx_author_id ON Book(author_id);
