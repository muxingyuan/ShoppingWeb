CREATE DATABASE appointmentDB
;

use appointmentDB;

CREATE TABLE appointment (
    id int NOT NULL AUTO_INCREMENT,
    PatientName varchar(100) NOT NULL,
    PatientEmail varchar(100) NOT NULL,
    PatientPhoneNumber varchar(10) NOT NULL,
    DoctorName varchar(100) NOT NULL,
    PRIMARY KEY (id)
); 

select * from appointment
;
