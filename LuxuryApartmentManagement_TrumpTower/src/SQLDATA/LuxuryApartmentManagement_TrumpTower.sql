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
--===================================================================================================
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
	('A', N'Tòa A'),
	('B', N'Tòa B'),
	('C', N'Tòa C'),
	('D', N'Tòa D'),
	('E', N'Tòa E'),
	('F', N'Tòa F'),
	('G', N'Tòa G'),
	('H', N'Tòa H')
GO
--===================================================================================================
CREATE TABLE CATEGORIZE_APARTMENTS
(
	CateApart_ID INT IDENTITY (1,1) PRIMARY KEY,
	CateApart_Name NVARCHAR(100) DEFAULT N'Chưa đặt tên',
	CateApart_Explication NVARCHAR(255) DEFAULT N'Chưa cập nhật',
)
GO
INSERT INTO CATEGORIZE_APARTMENTS (CateApart_Name, CateApart_Explication)
VALUES	('Aparment - 1', 'Apartment luxury 1'),
		('Aparment - 2', 'Apartment luxury 2'),
		('Aparment - 3', 'Apartment luxury 3'),
		('Hotel - 1', N'Nhà nghỉ để nghỉ'),
		('Hotel - 2', N'Nhà nghỉ không để nghỉ'),
		('Motel - 1', N'Nhà trọ sinh viên'),
		('Hotel - 2', N'Nhà trọ cho người lao động'),
		('Home stay - 1', N'Dành cho khách du lịch')
GO
--===================================================================================================
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
--===================================================================================================
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
--===================================================================================================
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
	Cus_Relative VARCHAR(20)
)


GO
INSERT INTO CUSTOMERS(Cus_ID, Cus_Name, Cus_BirDate, Cus_HomeTower, Cus_Gender, Cus_PhoneNumber,Cus_Mail) VAlUES
('079203020008', N'Trần Bảo Trường', '25/05/2005', N'Nhị Bình', N'Nữ', '0359369018', 'cute123@gmail.com')
INSERT INTO CUSTOMERS(Cus_ID, Cus_Name, Cus_BirDate, Cus_HomeTower, Cus_Gender, Cus_PhoneNumber,Cus_Mail) VAlUES
('079203020007', N'Lưu Ngọc Anh', '25/05/2005', N'Nhị Bình', N'Nữ', '0359369015', 'ngocanh@gmail.com')
INSERT INTO CUSTOMERS(Cus_ID, Cus_Name, Cus_BirDate, Cus_HomeTower, Cus_Gender, Cus_PhoneNumber,Cus_Mail) VAlUES
('079203020006', N'Phạm Quỳnh Anh', '25/05/2005', N'Nhị Bình', N'Nữ', '0359369016', 'wanh@gmail.com')
INSERT INTO CUSTOMERS(Cus_ID, Cus_Name, Cus_BirDate, Cus_HomeTower, Cus_Gender, Cus_PhoneNumber,Cus_Mail) VAlUES
('079203020005', N'Lưu Ngọc Hà', '25/05/2005', N'Nhị Bình', N'Nữ', '0359369014', 'agoha@gmail.com')
INSERT INTO CUSTOMERS(Cus_ID, Cus_Name, Cus_BirDate, Cus_HomeTower, Cus_Gender, Cus_PhoneNumber,Cus_Mail) VAlUES
('079203020004', N'Lê Ngọc Linh', '25/05/2005', N'Nhị Bình', N'Nữ', '0359369013', 'Hongnho1@gmail.com')
INSERT INTO CUSTOMERS(Cus_ID, Cus_Name, Cus_BirDate, Cus_HomeTower, Cus_Gender, Cus_PhoneNumber,Cus_Mail) VAlUES
('079203020000', N'Lưu Thị Thanh Hồng', '25/05/2005', N'Nhị Bình', N'Nữ', '0359369087', 'Hongnhoi25@gmail.com')
INSERT INTO CUSTOMERS(Cus_ID, Cus_Name, Cus_BirDate, Cus_HomeTower, Cus_Gender, Cus_PhoneNumber,Cus_Mail) VAlUES
('079203020001', N'Phạm Minh Anh', '23/05/2003', N'Nhị Bình', N'Nữ', '0359369011', 'Hongnhoi11@gmail.com')
INSERT INTO CUSTOMERS(Cus_ID, Cus_Name, Cus_BirDate, Cus_HomeTower, Cus_Gender, Cus_PhoneNumber,Cus_Mail) VAlUES
('079203020002', N'Huỳnh Nguyễn Tường Vy', '21/01/2005', N'Nhị Bình', N'Nữ', '0359369010', 'Hongnhoi10@gmail.com')
INSERT INTO CUSTOMERS(Cus_ID, Cus_Name, Cus_BirDate, Cus_HomeTower, Cus_Gender, Cus_PhoneNumber,Cus_Mail) VAlUES
('079203020003', N'Huỳnh Mai Tường Vy', '23/12/2005', N'Nhị Bình', N'Nữ', '0359369012', 'Hongnhoi12@gmail.com')
GO
--===================================================================================================
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
--===================================================================================================
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
INSERT INTO CONTRACTS(CateCon_ID, Cus_ID, Apart_ID) VALUES	(1, '079203020008', 9)
INSERT INTO CONTRACTS(CateCon_ID, Cus_ID, Apart_ID) VALUES	(1, '079203020007', 8)
INSERT INTO CONTRACTS(CateCon_ID, Cus_ID, Apart_ID) VALUES	(1, '079203020006', 7)
INSERT INTO CONTRACTS(CateCon_ID, Cus_ID, Apart_ID) VALUES	(1, '079203020005', 6)
INSERT INTO CONTRACTS(CateCon_ID, Cus_ID, Apart_ID) VALUES	(1, '079203020004', 5)
INSERT INTO CONTRACTS(CateCon_ID, Cus_ID, Apart_ID) VALUES	(1, '079203020000', 1)
INSERT INTO CONTRACTS(CateCon_ID, Cus_ID, Apart_ID) VALUES	(2, '079203020001', 2)
INSERT INTO CONTRACTS(CateCon_ID, Cus_ID, Apart_ID) VALUES	(1, '079203020002', 3)
INSERT INTO CONTRACTS(CateCon_ID, Cus_ID, Apart_ID) VALUES	(1, '079203020003', 4)
GO
--===================================================================================================
create proc USP_InsertDe_contract
@idContr int, @idSer int, @quantity int
as	
begin	
	if exists (select * from DETAIL_CONTRACTS 
				where Contr_ID = @idContr 
				and Serv_ID = @idSer)
	begin
		update DETAIL_CONTRACTS set quantity += @quantity
		where Contr_ID = @idContr 
		and Serv_ID = @idSer
	end
	else
	begin
		insert into DETAIL_CONTRACTS values (@idContr, @idSer, @quantity)
	end
end
GO

GO
CREATE TABLE DETAIL_CONTRACTS
(
	Contr_ID INT,
	Serv_ID INT,
	quantity int default 1,
	CONSTRAINT FK_Deltails_Contract FOREIGN KEY (Contr_ID) REFERENCES CONTRACTS(Contr_ID),
	CONSTRAINT FK_Deltails_Service FOREIGN KEY (Serv_ID) REFERENCES SERVICES(Serv_ID),
	CONSTRAINT PK_CONTRACT_SERVICE PRIMARY KEY (Contr_ID, Serv_ID)
)
INSERT INTO DETAIL_CONTRACTS(Contr_ID, Serv_ID) VALUES
	(9, 1),(9, 2),(9, 3),(9, 4),(9, 5),(9, 7),(9, 9)
INSERT INTO DETAIL_CONTRACTS(Contr_ID, Serv_ID) VALUES
	(8, 1),(8, 3),(8, 5),(8, 9),(8, 7)
INSERT INTO DETAIL_CONTRACTS(Contr_ID, Serv_ID) VALUES
	(7, 1),(7, 9),(7, 7),(7, 2)
INSERT INTO DETAIL_CONTRACTS(Contr_ID, Serv_ID) VALUES
	(6, 1),(6, 2),(6, 3),(6, 9)
INSERT INTO DETAIL_CONTRACTS(Contr_ID, Serv_ID) VALUES
	(2, 1),(2, 2), (2, 6)
 INSERT INTO DETAIL_CONTRACTS(Contr_ID, Serv_ID) VALUES
	(3, 1),(3, 4)

GO
--===================================================================================================
CREATE TABLE PROBLEMS
(
	Prob_ID INT IDENTITY(1,1) PRIMARY KEY,
	Prob_Describe NVARCHAR(255) DEFAULT N'Chưa mô tả',
	Prob_Note NVARCHAR(255) NULL,
	Prob_Status NVARCHAR(50) DEFAULT N'Chưa xong',
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
--===================================================================================================
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

GO
--===================================================================================================

----------------Accounts-------------------
create proc USP_LoginAccount 
@username varchar(50),
@password varchar(50)
as
BEGIN
    BEGIN TRY
        select * from ACCOUNTS
		where Acc_User = @username
		and Acc_Password = @password
        PRINT N'Đăng nhập thành công!.'
    END TRY
    BEGIN CATCH
        PRINT 'Error: ' + ERROR_MESSAGE()
    END CATCH
END
-------------------------------------------------
GO
CREATE PROCEDURE USP_ChangePassword
    @Username NVARCHAR(50),
    @OldPassword NVARCHAR(50),
    @NewPassword NVARCHAR(50)
AS
BEGIN
    DECLARE @StoredPassword NVARCHAR(50)

    -- Kiểm tra mật khẩu cũ
    SELECT @StoredPassword = Acc_Password 
    FROM ACCOUNTS 
    WHERE Acc_User = @Username
    
    IF @StoredPassword IS NOT NULL AND @StoredPassword = @OldPassword
    BEGIN
        -- Mật khẩu cũ chính xác, tiến hành thay đổi mật khẩu
        UPDATE ACCOUNTS 
        SET Acc_Password = @NewPassword
        WHERE Acc_User = @Username
        
        PRINT 'Mật khẩu đã được thay đổi thành công.'
    END
    ELSE
    BEGIN
        -- Mật khẩu cũ không chính xác hoặc tài khoản không tồn tại
        PRINT 'Mật khẩu cũ không chính xác hoặc tài khoản không tồn tại.'
    END
END
go
create PROCEDURE USP_FilterApartment
@idBuild nvarchar(5),
@idCate int,
@isAvail bit,
@priceFrom decimal,
@priceTo decimal,
@floor int,
@isView bit,
@acreage nvarchar(50),
@des nvarchar(255)
as
begin
	select * from APARTMENTS left join CATEGORIZE_APARTMENTS on  APARTMENTS.CateApart_ID = CATEGORIZE_APARTMENTS.CateApart_ID
	where	Build_ID = @idBuild
	or		APARTMENTS.CateApart_ID = @idCate
	or		Apart_View =  @isView
	or		Apart_Available = @isAvail
	or		Apart_Price >= @priceFrom and Apart_Price <= @priceTo
	or		Apart_Acreage like @acreage
	or		Apart_Describe like @des
	or		Apart_Floor = @floor
end
go
create proc USP_ShowAllServiceByIdApart
@idApart int
as
begin
	select a.Apart_Number,  cus.Cus_Name, s.Serv_Name, dc.quantity from DETAIL_CONTRACTS dc left join CONTRACTS c on dc.Contr_ID = c.Contr_ID
				 left join APARTMENTS a on a.Apart_ID = c.Apart_ID
				 left join CUSTOMERS cus on c.Cus_ID = cus.Cus_ID
				 left join SERVICES s on s.Serv_ID = dc.Serv_ID
			where a.Apart_ID  = @idApart	
end

go
create proc USP_GetInforContractByNumberApartment
@idAparment int
as
begin
	select Contr_ID, Contr_Date from APARTMENTS a right join CONTRACTS c on a.Apart_ID = c.Apart_ID 
	where a.Apart_ID = @idAparment
end
go
create proc USP_GetInforRenterByNumberApartment
@idAparment int
as
begin
	select Cus_Name, c.Cus_ID, Cus.Cus_Gender, Cus_HomeTower, Cus_PhoneNumber, LEFT(Cus_BirDate, 11) as 'birth', Cus_Mail 
	from APARTMENTS a 
	right join CONTRACTS c 
	on  a.Apart_ID = c.Apart_ID 
	inner join CUSTOMERS cus 
	on cus.Cus_ID = c.Cus_ID 
	where a.Apart_ID = @idAparment
end
go
create proc USP_GetAllContract
as
begin
	select con.Contr_ID, con.Contr_Date, con.Contr_Status, CateCon_Name, cus.Cus_Name, a.Apart_Number,
	count(dc.Contr_ID) as N'Dịch vụ đang sử dụng'
	from  CONTRACTS con left join CUSTOMERS cus 
	on con.Cus_ID = cus.Cus_ID left join CATEGORIZE_CONTRACTS cate
	on cate.CateCon_ID = con.CateCon_ID left join APARTMENTS a
	on a.Apart_ID = con.Apart_ID left join DETAIL_CONTRACTS dc
	on dc.Contr_ID = con.Contr_ID
	GROUP BY 
	con.Contr_ID,
	con.Contr_Date,
	con.Contr_Status,
	CateCon_Name,
	cus.Cus_Name,
	a.Apart_Number
end
go
create proc USP_ChangeApartment
@CustomerID varchar(20),
@ApartmentIdOld int,
@ApartmentIdNew varchar(100)
as
begin
	update CONTRACTS
	set  Apart_ID = @ApartmentIdNew
	where Cus_ID = @CustomerID and Apart_ID = @ApartmentIdOld

	update APARTMENTS
	set Apart_Available = 1 
	where Apart_ID =  @ApartmentIdNew

	update APARTMENTS
	set Apart_Available = 0 
	where Apart_ID =  @ApartmentIdOld
end
go
