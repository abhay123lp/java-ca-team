/*Create the user table*/
CREATE TABLE UserTable(
	UserID NCHAR(10) PRIMARY KEY,
	UserPSW NVARCHAR(16) NOT NULL,
	Role NVARCHAR(7) NOT NULL,
	UserName NVARCHAR(100) NOT NULL,
	ContactNo NVARCHAR(14),
	EmailAddress NVARCHAR(30) NOT NULL
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
	FOREIGN KEY (TypeID) REFERENCES FacilityType(TypeID) ON DELETE CASCADE,
	CHECK(FacUsage >= 0)
);
/*Create the booking table*/
CREATE TABLE Bookings(
	BookingID NCHAR(10) PRIMARY KEY,
	UserID NCHAR(10) NOT NULL,
	FacID NCHAR(10) NOT NULL,
	StartTime DATE NOT NULL,
	Duration INTEGER NOT NULL,
	BookStatus NVARCHAR(10) NOT NULL,
	Priority NCHAR(1) NOT NULL,
	Reason NVARCHAR(500),
	FOREIGN KEY (UserID) REFERENCES UserTable(UserID) ON DELETE CASCADE,
	FOREIGN KEY (FacID) REFERENCES Facility(FacID) ON DELETE CASCADE
);

/*Create index of table*/
CREATE INDEX Index_Bookings ON Bookings(BookingID);
CREATE INDEX Index_BookStatus ON Bookings(BookStatus);
CREATE INDEX Index_Facility ON Facility(FacID);
CREATE INDEX Index_User ON UserTable(UserID);
CREATE INDEX Index_Type ON FacilityType(TypeID);