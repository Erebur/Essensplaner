-- Drop table users;
-- Drop table shopping_list;


CREATE TABLE users(
    "user_name" VARCHAR NOT NULL unique,
    "user_group" VARCHAR NOT NULL ,
    "user_email" VARCHAR unique,
    "user_password" VARCHAR Not NULL
);

CREATE TABLE shopping_list(
    user_group varchar not NULL,
    product_name VARCHAR NOT NULL,
    product_description Text ,
    product_brand Varchar, 
    product_amount decimal not null ,
    Primary key (user_group,product_name),
    FOREIGN KEY (user_group)
        REFERENCES useres (user_group)
);

-- INSERT INTO users(user_name,usergroup, user_password)
--   VALUES (
--       'admin',
--       'admin',
--       '42069'
--     );