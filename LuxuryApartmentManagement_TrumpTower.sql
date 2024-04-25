USE MASTER
GO
drop DATABASE LuxuryApartmentManagement_TrumpTowers
GO
CREATE DATABASE LuxuryApartmentManagement_TrumpTowers
GO
USE LuxuryApartmentManagement_TrumpTowers
GO
set dateformat DMY
GO
CREATE TABLE BUILDINGS
(
	Build_Address NVARCHAR(100) PRIMARY KEY,
	Build_Name NVARCHAR(100) DEFAULT 'Unnamed',
	Build_Describe NVARCHAR(255)
)

GO
CREATE TABLE CATEGORIZE_APARTMENTS
(
	CateApart_ID INT IDENTITY (1,1) PRIMARY KEY,
	CateApart_Name NVARCHAR(100) DEFAULT 'Unnamed',
	CateApart_Explication NVARCHAR(255),
	Build_Address NVARCHAR(100)
	CONSTRAINT FK_CateApart_Build FOREIGN KEY (Build_Address) REFERENCES BUILDINGS(Build_Address)
)
GO

CREATE TABLE APARTMENTS
(
	Apart_ID INT IDENTITY (1,1) PRIMARY KEY,
	Apart_Name NVARCHAR(100),
	Apart_Cate INT,
	Apart_Build INT,
	Apart_Floor INT,
	Apart_View BIT,
	Apart_Acreage NVARCHAR(50),
	Apart_Price DECIMAL,
	Apart_Describe NVARCHAR(255),
	Apart_Available BIT,
	CateApart_ID INT
	CONSTRAINT FK_Apart_Cate FOREIGN KEY (CateApart_ID) REFERENCES CATEGORIZE_APARTMENTS(CateApart_ID)
)
GO
CREATE TABLE CUSTOMERS
(	
	Cus_ID INT IDENTITY (1,1) PRIMARY KEY,
	Cus_Name NVARCHAR(100),
	Cus_CitizenIdentificationPhoto Image,
	Cus_BirDate DATETIME,
	Cus_HomeTower NVARCHAR(200),
	Cus_Gender NVARCHAR(10),
	Cus_PhoneNumber VARCHAR(11),
	Cus_Mail NVARCHAR(50),
	Cus_Note NVARCHAR(255),
)
GO
CREATE TABLE BUILDING_SERVICES
(
	BuiServ_ID INT IDENTITY (1,1) PRIMARY KEY,
	BuiServ_Name NVARCHAR(100),
	BuiServ_Price DECIMAL,
	BuiServ_Explication NVARCHAR(255),
	BuiServ_Available BIT,
	Build_Address NVARCHAR(100)
	CONSTRAINT FK_BuServ_Build FOREIGN KEY (Build_Address) REFERENCES BUILDINGS(Build_Address)
)
GO
CREATE TABLE APARTMENT_SERVICES
(
	ApartServ_ID INT IDENTITY (1,1) PRIMARY KEY,
	ApartServ_Name NVARCHAR(100),
	ApartServ_Price DECIMAL,
	ApartServ_Explication NVARCHAR(255),
	ApartServ_Available BIT,
	Apart_ID INT
	CONSTRAINT FK_Apart_Serv FOREIGN KEY (Apart_ID) REFERENCES APARTMENTS(Apart_ID)
)

GO
CREATE TABLE CATEGORIZE_CONTRACTS
(
	CateCon_ID INT IDENTITY (1,1) PRIMARY KEY,
	CateCon_Name NVARCHAR(100)
)
GO
CREATE TABLE CONTRACTS
(
	Contr_ID INT IDENTITY (1,1) PRIMARY KEY,
	Contr_Date DATETIME,
	Contr_Status BIT,
	CateCon_ID INT,
	Cus_ID INT
	CONSTRAINT FK_Contract_Cate FOREIGN KEY (CateCon_ID) REFERENCES CATEGORIZE_CONTRACTS(CateCon_ID)
	CONSTRAINT FK_Contract_Cus FOREIGN KEY (Cus_ID) REFERENCES CUSTOMERS(Cus_ID)
	
)
GO
CREATE TABLE DETAIL_CONTRACTS
(
	DetailCT_ID INT IDENTITY(1,1) PRIMARY KEY,
	DetailCT_DepositPayment DECIMAL,
	DetailCT_OutstandingPayment DECIMAL,
	DetailCT_OldIndex INT,
	DetailCT_NewIndex INT,
	Contr_ID INT
	CONSTRAINT FK_Contract_Deltail FOREIGN KEY (Contr_ID) REFERENCES CONTRACTS(Contr_ID)
)
GO
CREATE TABLE PROBLEMS
(
	Prob_ID INT IDENTITY(1,1) PRIMARY KEY,
	Prob_Describe NVARCHAR(255),
	Prob_Note NVARCHAR(255),
	Prob_Status NVARCHAR(50),
	Prob_DateOccur DATETINE,
)
