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
	Build_ID INT IDENTITY (1, 1) PRIMARY KEY,
	Build_Address NVARCHAR(100) DEFAULT N'5/5A Nguyễn Thị Sóc',
	Build_Name NVARCHAR(100) DEFAULT N'Chưa cập nhật',
	Build_Describe NVARCHAR(255) DEFAULT N'Chưa cập nhật'
)

GO
CREATE TABLE CATEGORIZE_APARTMENTS
(
	CateApart_ID INT IDENTITY (1,1) PRIMARY KEY,
	CateApart_Name NVARCHAR(100) DEFAULT N'Chưa đặt tên',
	CateApart_Explication NVARCHAR(255) DEFAULT N'Chưa cập nhật',
)
GO

CREATE TABLE APARTMENTS
(
	Apart_ID INT IDENTITY (1,1) PRIMARY KEY,
	Apart_Name NVARCHAR(100),
	Apart_Floor INT DEFAULT NULL,
	Apart_View BIT DEFAULT 0,
	Apart_Acreage NVARCHAR(50) DEFAULT N'Chưa cập nhật',
	Apart_Price DECIMAL DEFAULT NULL,
	Apart_Describe NVARCHAR(255) DEFAULT N'Chưa cập nhật',
	Apart_Available BIT DEFAULT ,
	CateApart_ID INT,
	Build_Address NVARCHAR(100),
	CONSTRAINT FK_Apart_Build FOREIGN KEY (Build_ID) REFERENCES BUILDINGS(Build_ID),
	CONSTRAINT FK_Apart_Cate FOREIGN KEY (CateApart_ID) REFERENCES CATEGORIZE_APARTMENTS(CateApart_ID)
)
GO
CREATE TABLE CUSTOMERS
(	
	Cus_ID INT IDENTITY (1,1) PRIMARY KEY,
	Cus_Name NVARCHAR(100) DEFAULT  N'Chưa cập nhật',
	Cus_CitizenIdentificationPhoto Image DEFAULT NULL,
	Cus_BirDate DATETIME,
	Cus_HomeTower NVARCHAR(200),
	Cus_Gender NVARCHAR(10) DEFAULT N'Nam',
	Cus_PhoneNumber VARCHAR(11) UNIQUE,
	Cus_Mail NVARCHAR(50) UNIQUE,
	Cus_Note NVARCHAR(255) DEFAULT  N'Không có chú thích',
	
)
GO
CREATE TABLE SERVICES
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
	Contr_Date DATETIME,
	Contr_Status BIT,
	CateCon_ID INT,
	Cus_ID INT,
	Apart_ID INT,
	CONSTRAINT FK_Contract_Cate FOREIGN KEY (CateCon_ID) REFERENCES CATEGORIZE_CONTRACTS(CateCon_ID),
	CONSTRAINT FK_Contract_Cus FOREIGN KEY (Cus_ID) REFERENCES CUSTOMERS(Cus_ID),
	CONSTRAINT FK_Contract_Apart FOREIGN KEY (Apart_ID) REFERENCES APARTMENTS(Apart_ID),
	CONSTRAINT PK_Contract PRIMARY KEY (Cus_ID, Apart_ID)
	
)
GO
CREATE TABLE DETAIL_CONTRACTS
(
	DetailCT_ID INT IDENTITY(1,1) PRIMARY KEY,
	DetailCT_DepositPayment DECIMAL NULL,
	DetailCT_OutstandingPayment DECIMAL NULL,
	DetailCT_Duration NVARCHAR(100) DEFAULT 'Life time',
	Contr_ID INT,
	CONSTRAINT FK_Contract_Deltail FOREIGN KEY (Contr_ID) REFERENCES CONTRACTS(Contr_ID)
)
GO
CREATE TABLE PROBLEMS
(
	Prob_ID INT IDENTITY(1,1) PRIMARY KEY,
	Prob_Describe NVARCHAR(255),
	Prob_Note NVARCHAR(255),
	Prob_Status NVARCHAR(50),
	Prob_DateOccur DATETIME,
	Apart_ID INT,
	CONSTRAINT FK_Prob_Apart FOREIGN KEY (Apart_ID) REFERENCES APARTMENTS(Apart_ID)
)
