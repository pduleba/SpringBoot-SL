create table SHIPWRECK (
    ID int AUTO_INCREMENT,
    NAME varchar(255) not null,
    DESCRIPTION varchar(2000),
    CONDITION varchar(255),
    DEPTH INT,
    LATITUDE INT,
    LONGITUDE INT,
    YEAR_DISCOVERED INT
);