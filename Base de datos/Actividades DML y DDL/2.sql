CREATE TABLE customers (
	cus_id int,
	cus_name varchar(20) NOT NULL,
    cus_surname1 varchar(20) NOT NULL,
    cus_surname2 varchar(20)
);
ALTER TABLE customers
ADD CONSTRAINT pk_customers
PRIMARY KEY (cus_id);

ALTER TABLE cars
ADD CONSTRAINT pk_cars
PRIMARY KEY (car_pnumber);

ALTER TABLE reparationheaders
ADD CONSTRAINT pk_reparationheaders
PRIMARY KEY (rhe_id);

ALTER TABLE tspareparts
ADD CONSTRAINT pk_tspareparts
PRIMARY KEY (tsp_id);

ALTER TABLE repairlog
ADD CONSTRAINT pk_repairlog
PRIMARY KEY (rlg_rhe_id, rlg_number);

ALTER TABLE spartsxheaders
ADD CONSTRAINT pk_spartsxheaders
PRIMARY KEY (sxh_rhe_id, sxh_spa_id);

ALTER TABLE spareparts
ADD CONSTRAINT pk_spareparts
PRIMARY KEY (spa_id);
CREATE TABLE repairlog (
	rlg_rhe_id int,
    rlg_number int,
    rlg_description varchar(100) NOT NULL
);

CREATE TABLE spartsxheaders (
	sxh_rhe_id int,
    sxh_spa_id int
);

CREATE TABLE spareparts (
	spa_id int,
    spa_description varchar(100) NOT NULL,
    spa_tsp_id int NOT NULL
);