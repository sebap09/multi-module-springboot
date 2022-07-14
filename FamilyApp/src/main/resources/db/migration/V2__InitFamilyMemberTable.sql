CREATE TABLE family_member (
    id int AUTO_INCREMENT,
    family_id int not null,
    family_name varchar(255) not null,
    given_name varchar(255) not null,
    age int not null,
    PRIMARY KEY (id)
    -- FOREIGN KEY (family_id) REFERENCES family(id), cannot be used, because firstly we
    -- save members, then the family which gives an exception
);