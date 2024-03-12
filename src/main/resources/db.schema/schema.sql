
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE users (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    profile_picture TEXT NULL,
    biography TEXT NULL
);

CREATE TYPE item_category AS ENUM ('Travel', 'Music', 'Television', 'Movies', 'Food', 'Gaming', 'Shopping', 'Books', 'Automobiles', 'Electronics', 'Web');

CREATE TABLE user_lists (
    id BIGSERIAL PRIMARY KEY,
    user_id UUID NOT NULL,
    title VARCHAR(255) NOT NULL,
    image TEXT NULL,
    description TEXT NULL,
    category item_category NOT NULL,
    date_created TIMESTAMP(0) WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);




CREATE TABLE list_items (
    id BIGSERIAL PRIMARY KEY,
    list_id BIGINT NOT NULL,
    list_item TEXT NOT NULL,
    image TEXT NULL,
    description TEXT NULL,
    link TEXT NULL,
    subcategory VARCHAR(100) NULL,
    FOREIGN KEY (list_id) REFERENCES user_lists(id) ON DELETE CASCADE
);

CREATE TABLE user_viewing_histories (
    id BIGSERIAL PRIMARY KEY,
    user_id UUID NOT NULL,
    item_id BIGINT NOT NULL,
    timestamp TIMESTAMP(0) WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (item_id) REFERENCES user_lists(id)
);

CREATE TABLE list_topics (
    id SERIAL PRIMARY KEY,
    item_id BIGINT NOT NULL,
    topic TEXT NOT NULL,
    FOREIGN KEY (item_id) REFERENCES user_lists(id) ON DELETE CASCADE
);

CREATE TABLE user_ratings (
    id BIGSERIAL PRIMARY KEY,
    user_id UUID NOT NULL,
    item_id BIGINT NOT NULL ,
    rating_value FLOAT NOT NULL CHECK (rating_value >= 0 AND rating_value <= 5),
    timestamp TIMESTAMP(0) WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
    -- CONSTRAINT authenticated_user CHECK(EXISTS (SELECT 1 FROM users WHERE users.id = user_ratings.user_id)),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (item_id) REFERENCES user_lists(id) ON DELETE CASCADE
);

CREATE TABLE user_followers (
    follower_id UUID NOT NULL,
    followed_id UUID NOT NULL,
    PRIMARY KEY (follower_id, followed_id),
    FOREIGN KEY (follower_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (followed_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE user_saved_lists (
    id BIGSERIAL PRIMARY KEY,
    user_id UUID NOT NULL,
    item_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (item_id) REFERENCES user_lists(id) ON DELETE CASCADE
);

