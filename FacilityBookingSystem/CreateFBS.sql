
/*drop database facilitybooking*/

create database facilitybooking
/*Create the user table*/
CREATE TABLE UserTable(
	UserID NCHAR(10) PRIMARY KEY,
	UserPSW NVARCHAR(16) NOT NULL,
	Role NVARCHAR(7) NOT NULL,
	UserName NVARCHAR(100) NOT NULL,
	ContactNo NVARCHAR(14) NOT NULL
);
/*Create the type table*/
CREATE TABLE FacilityType(
	TypeID INTEGER PRIMARY KEY,
	TypeName NVARCHAR(100) NOT NULL,
	Capacity INTEGER,
	Description NVARCHAR(500),
	CHECK(Capaicity > 0)
);
/*Create the facility table*/
CREATE TABLE Facility(
	FacID NCHAR(10) PRIMARY KEY,
	FacName NVARCHAR(20) NOT NULL,
	FacUsage INTEGER NOT NULL,
	TypeID INTEGER NOT NULL,
	FOREIGN KEY (TypeID) REFERENCES FacilityType(TypeID),
	CHECK(FacUsage >= 0)
);
/*Create the booking table*/
CREATE TABLE Bookings(
	BookingID NCHAR(10) PRIMARY KEY,
	UserID NCHAR(10) NOT NULL,
	FacID NCHAR(10) NOT NULL,
	StartTime DATETIME NOT NULL,
	EndTime DATETIME NOT NULL,
	BookStatus NVARCHAR(8) NOT NULL,
	Priority NCHAR(1) NOT NULL,
	Reason NVARCHAR(500),
	FOREIGN KEY (UserID) REFERENCES UserTable(UserID),
	FOREIGN KEY (FacID) REFERENCES Facility(FacID)
);
create index Index_UserID on UserTable (UserID(10));
create index Index_FacID on Facility (FacID(10));
create index Index_BookingID on Bookings(BookingID(10));

