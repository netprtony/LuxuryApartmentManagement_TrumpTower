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
	Build_ID VARCHAR(5) PRIMARY KEY,
	Build_Address NVARCHAR(100) DEFAULT N'725 5th Ave, New York, NY 10022, United States',
	Build_Name NVARCHAR(100) DEFAULT N'Chưa cập nhật',
	Build_Describe NVARCHAR(255) DEFAULT N'Chưa cập nhật'
)
GO
INSERT INTO BUILDINGS (Build_ID, Build_Name)
VALUES 
	('A', 'Tòa A'),
	('B', 'Tòa B'),
	('C', 'Tòa C'),
	('D', 'Tòa D'),
	('E', 'Tòa E'),
	('F', 'Tòa F'),
	('G', 'Tòa G'),
	('H', 'Tòa H')
GO
CREATE TABLE CATEGORIZE_APARTMENTS
(
	CateApart_ID INT IDENTITY (1,1) PRIMARY KEY,
	CateApart_Number NVARCHAR(100) DEFAULT N'Chưa đặt tên',
	CateApart_Explication NVARCHAR(255) DEFAULT N'Chưa cập nhật',
)
GO
INSERT INTO CATEGORIZE_APARTMENTS (CateApart_Number, CateApart_Explication)
VALUES	('Aparment - 1', 'Apartment luxury 1'),
		('Aparment - 2', 'Apartment luxury 2'),
		('Aparment - 3', 'Apartment luxury 3'),
		('Hotel - 1', 'Nhà nghỉ để nghỉ'),
		('Hotel - 2', 'Nhà nghỉ không để nghỉ'),
		('Motel - 1', 'Nhà trọ sinh viên'),
		('Hotel - 2', 'Nhà trọ cho người lao động'),
		('Home stay - 1', 'Dành cho khách du lịch')
GO
CREATE TABLE SERVICES
(
	Serv_ID INT IDENTITY (1,1) PRIMARY KEY,
	Serv_Name NVARCHAR(100) DEFAULT N'Chưa đặt tên',
	Serv_Price DECIMAL NULL,
	Serv_Explication NVARCHAR(255) DEFAULT N'Chưa đề cập',
	Serv_Available BIT DEFAULT 0,
)
GO
INSERT INTO SERVICES (Serv_Name, Serv_Price, Serv_Explication, Serv_Available)
VALUES
	('SWIMMING POOL', 20000, N'a year', 1),
	('BAR CLUB', 1500, N'a year', 1),
	('HIDDEN BAR', 100, N'a year', 1),
	('Saigon Rooftop Bar', 90000, N'a day', 1),
	('The World of Heineken', 100, N'a day', 1),
	('Snuffbox Speakeasy', 200, N'a day', 1),
	('Social Club Rooftop Bar', 300, N'a day', 1),
	('Blank Lounge Landmark', 50, N'a day', 1),
	('Private Wifi', 100, N'a month', 1)
GO
CREATE TABLE APARTMENTS
(
	Apart_ID INT IDENTITY (1,1) PRIMARY KEY,
	Apart_Number NVARCHAR(100) NULL,
	Apart_Floor INT NOT NULL,
	Apart_View BIT DEFAULT 0,
	Apart_Acreage NVARCHAR(50) DEFAULT N'Chưa cập nhật',
	Apart_Price DECIMAL DEFAULT NULL,
	Apart_Describe NVARCHAR(255) DEFAULT N'Chưa cập nhật',
	Apart_Available BIT DEFAULT 0,
	CateApart_ID INT,
	Build_ID VARCHAR(5),
	CONSTRAINT FK_Aparts_Build FOREIGN KEY (Build_ID) REFERENCES BUILDINGS(Build_ID),
	CONSTRAINT FK_Aparts_Cate FOREIGN KEY (CateApart_ID) REFERENCES CATEGORIZE_APARTMENTS(CateApart_ID),
)
GO
INSERT INTO APARTMENTS (Apart_Number, Apart_Floor, Apart_Acreage, Apart_Price, CateApart_ID, Build_ID)
VAlUES	('A001', 1, '1,092 ft²', 3150000, 1, 'A'),
		('A002',1, '1,092 ft²', 3150000, 6, 'C'),
		('A003',3, '1,092 ft²', 3150000, 3, 'B'),
		('A004',1, '1,092 ft²', 3150000, 2, 'A'),
		('A005',14, '1,092 ft²', 3150000, 1, 'C'),
		('A006',1, '1,092 ft²', 3150000, 1, 'A'),
		('A007',22, '1,092 ft²', 3150000, 6, 'C'),
		('A008',1, '1,092 ft²', 3150000, 7, 'A'),
		('A009',11, '1,092 ft²', 3150000, 8, 'A'),
		('A101',14, '1,092 ft²', 3150000, 3, 'B'),
		('A102',15, '1,092 ft²', 3150000, 4, 'G'),
		('A103',16, '1,092 ft²', 3150000, 1, 'H'),
		('A104',17, '1,092 ft²', 3150000, 1, 'A'),
		('A105',18, '1,092 ft²', 3150000, 2, 'E'),
		('A106',15, '1,092 ft²', 3150000, 1, 'A'),
		('A107',13, '1,092 ft²', 3150000, 1, 'G'),
		('A108',13, '1,092 ft²', 3150000, 1, 'A'),
		('A109',14, '1,092 ft²', 3150000, 2, 'A'),
		('A111',11, '1,092 ft²', 3150000, 1, 'E'),
		('A112',12, '1,092 ft²', 3150000, 5, 'D'),
		('A113',13, '1,092 ft²', 3150000, 1, 'C'),
		('A114',14, '1,092 ft²', 3150000, 1, 'A'),
		('A115',15, '1,092 ft²', 3150000, 2, 'A')
GO
CREATE TABLE CUSTOMERS
(	
	Cus_ID VARCHAR(20) PRIMARY KEY,
	Cus_Name NVARCHAR(100) DEFAULT  N'Chưa cập nhật',
	Cus_BirDate DATETIME,
	Cus_HomeTower NVARCHAR(200),
	Cus_Gender NVARCHAR(10) DEFAULT N'Nam',
	Cus_PhoneNumber VARCHAR(11) UNIQUE,
	Cus_Mail VARCHAR(50) UNIQUE,
	Cus_Note NVARCHAR(255) DEFAULT  N'Không có chú thích',
	
)
GO
INSERT INTO CUSTOMERS(Cus_ID, Cus_Name, Cus_BirDate, Cus_HomeTower, Cus_Gender, Cus_PhoneNumber,Cus_Mail) 
VAlUES 
	('079203020000', N'Lưu Thị Thanh Hồng', '25/05/2005', N'Nhị Bình', N'Nữ', '0359369087', 'Hongnhoi25@gmail.com'),
	('079203020001', N'Phạm Minh Anh', '23/05/2003', N'Nhị Bình', N'Nữ', '0359369011', 'Hongnhoi11@gmail.com'),
	('079203020002', N'Huỳnh Nguyễn Tường Vy', '21/01/2005', N'Nhị Bình', N'Nữ', '0359369010', 'Hongnhoi10@gmail.com'),
	('079203020003', N'Huỳnh Mai Tường Vy', '23/12/2005', N'Nhị Bình', N'Nữ', '0359369012', 'Hongnhoi12@gmail.com')
GO
CREATE TABLE CATEGORIZE_CONTRACTS
(
	CateCon_ID INT IDENTITY (1,1) PRIMARY KEY,
	CateCon_Name NVARCHAR(100) DEFAULT N'Chưa đặt tên',
)
GO
INSERT INTO CATEGORIZE_CONTRACTS (CateCon_Name)
VALUES 
	('Long-term'),
	('Short-term')
GO
CREATE TABLE CONTRACTS
(
	Contr_ID INT IDENTITY (1,1) PRIMARY KEY, 
	Contr_Date DATETIME DEFAULT CURRENT_TIMESTAMP,
	Contr_Status BIT DEFAULT 0,
	CateCon_ID INT,
	Cus_ID VARCHAR(20),
	Apart_ID INT,
	CONSTRAINT FK_Contracts_Cate FOREIGN KEY (CateCon_ID) REFERENCES CATEGORIZE_CONTRACTS(CateCon_ID),
	CONSTRAINT FK_Contracts_Cus FOREIGN KEY (Cus_ID) REFERENCES CUSTOMERS(Cus_ID),
	CONSTRAINT FK_Contracts_Apart FOREIGN KEY (Apart_ID) REFERENCES APARTMENTS(Apart_ID),
)
GO
INSERT INTO CONTRACTS(CateCon_ID, Cus_ID, Apart_ID)
VALUES
	(1, '079203020000', 1),
	(2, '079203020001', 2),
	(1, '079203020002', 3),
	(1, '079203020003', 4)
GO
CREATE TABLE DETAIL_CONTRACTS
(
	Contr_ID INT,
	Serv_ID INT,
	CONSTRAINT FK_Deltails_Contract FOREIGN KEY (Contr_ID) REFERENCES CONTRACTS(Contr_ID),
	CONSTRAINT FK_Deltails_Service FOREIGN KEY (Serv_ID) REFERENCES SERVICES(Serv_ID),
	CONSTRAINT PK_CONTRACT_SERVICE PRIMARY KEY (Contr_ID, Serv_ID)
)
GO
INSERT INTO DETAIL_CONTRACTS(Contr_ID, Serv_ID)
VALUES 
	(2, 1),
	(3, 2),
	(3, 3),
	(4, 4),
	(5, 5),
	(2, 2),
	(2, 3)
GO
CREATE TABLE PROBLEMS
(
	Prob_ID INT IDENTITY(1,1) PRIMARY KEY,
	Prob_Describe NVARCHAR(255) DEFAULT 'Chưa mô tả',
	Prob_Note NVARCHAR(255) NULL,
	Prob_Status NVARCHAR(50) DEFAULT 'Chưa xong',
	Prob_DateOccur DATETIME DEFAULT CURRENT_TIMESTAMP,
	Apart_ID INT,
	CONSTRAINT FK_Probs_Apart FOREIGN KEY (Apart_ID) REFERENCES APARTMENTS(Apart_ID)
)
GO
INSERT INTO PROBLEMS (Apart_ID)
VALUES
		(1),
		(2),
		(3),
		(4),
		(5),
		(6),
		(7),
		(8)
GO
CREATE TABLE ACCOUNTS 
(
	Acc_User VARCHAR(50) PRIMARY KEY,
	Acc_NameOwner NVARCHAR(100),
	Acc_Password VARCHAR(50),
	Acc_Role NVARCHAR(50) DEFAULT 'USER',
)
GO
INSERT INTO ACCOUNTS (Acc_User, Acc_NameOwner, Acc_Password)
VALUES 
	(N'netprtony', 'huynhvikhang', '123')
