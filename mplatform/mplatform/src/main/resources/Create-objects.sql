DROP SEQUENCE mh_business_typ_sq;
DROP TABLE mh_business_type CASCADE;

DROP SEQUENCE mh_item_sq;
DROP TABLE mh_item CASCADE;

DROP SEQUENCE mh_item_typ_sq;
DROP TABLE mh_item_type CASCADE;

DROP SEQUENCE mh_vendor_sq;
DROP TABLE mh_vendor CASCADE;

CREATE TABLE mh_business_type (
    business_type_id numeric NOT NULL,
    business_type varchar(255) NOT NULL
);
ALTER TABLE ONLY mh_business_type  ADD CONSTRAINT mh_business_type_pkey PRIMARY KEY (business_type_id);
CREATE SEQUENCE mh_business_typ_sq START WITH 10000 MINVALUE 0 MAXVALUE 9223372036854775807 NO CYCLE;

CREATE TABLE mh_item_type (
    item_type_id numeric NOT NULL,
    item_type varchar(255) NOT NULL
);
ALTER TABLE ONLY mh_item_type ADD CONSTRAINT mh_item_type_pkey PRIMARY KEY (item_type_id);
CREATE SEQUENCE mh_item_typ_sq START WITH 10000 MINVALUE 0 MAXVALUE 9223372036854775807 NO CYCLE;

CREATE TABLE mh_vendor (
    vendor_id numeric NOT NULL,  
    vendor_name varchar(255) NOT NULL,
    description varchar(255),
    email_address varchar(255) NOT NULL,
    password varchar(255),
    phone_number varchar(255) NOT NULL,
    business_type numeric not null,
    street varchar(255) NOT NULL,
    city varchar(255) NOT NULL,
    state varchar(255) NOT NULL,
    country varchar(255) NOT NULL,   
    postal_code varchar(255) NOT NULL,
    latitude numeric NOT NULL,
    longitude numeric NOT NULL,       
    created_by varchar(255),
    created_dt timestamp,
    updated_by varchar(255),
    updated_dt timestamp
);
ALTER TABLE ONLY mh_vendor ADD CONSTRAINT mh_vendor_pkey PRIMARY KEY (vendor_id);
ALTER TABLE ONLY mh_vendor ADD CONSTRAINT mh_vendor_fk1 FOREIGN KEY (business_type) REFERENCES mh_business_type(business_type_id);
CREATE SEQUENCE mh_vendor_sq START WITH 10000 MINVALUE 0 MAXVALUE 9223372036854775807 NO CYCLE;

CREATE TABLE mh_item (
    item_id numeric NOT NULL,    
    discounted_price double precision,
    icon_path varchar(255),
    item_name varchar(255),
    offer_exp_date timestamp,
    original_price double precision,
    item_type numeric,
    vendor_id numeric NOT NULL,
    created_by varchar(255),
    created_dt timestamp,
    updated_by varchar(255),
    updated_dt timestamp
);
ALTER TABLE ONLY mh_item ADD CONSTRAINT mh_item_pkey PRIMARY KEY (item_id);
ALTER TABLE ONLY mh_item ADD CONSTRAINT mh_item_fk1 FOREIGN KEY (item_type) REFERENCES mh_item_type(item_type_id);
ALTER TABLE ONLY mh_item ADD CONSTRAINT mh_item_fk2 FOREIGN KEY (vendor_id) REFERENCES mh_vendor(vendor_id);
CREATE SEQUENCE mh_item_sq START WITH 10000 MINVALUE 0 MAXVALUE 9223372036854775807 NO CYCLE;

INSERT INTO mh_business_type(business_type_id, business_type) VALUES (10000,'Dairy');
INSERT INTO mh_business_type(business_type_id, business_type) VALUES (10001,'Daily Needs');
INSERT INTO mh_business_type(business_type_id, business_type) VALUES (10002,'Bakery');
INSERT INTO mh_business_type(business_type_id, business_type) VALUES (10003,'Sweets Shop');
INSERT INTO mh_business_type(business_type_id, business_type) VALUES (10004,'Restaurant');
INSERT INTO mh_business_type(business_type_id, business_type) VALUES (10005,'Farsan');


INSERT INTO mh_item_type(item_type_id, item_type) VALUES (10000,'Pastry');
INSERT INTO mh_item_type(item_type_id, item_type) VALUES (10001,'Sweets');
INSERT INTO mh_item_type(item_type_id, item_type) VALUES (10002,'Cakes');