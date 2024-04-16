use master
go
drop database LuxuryApartmentManagement_TrumpTowers
go
create database LuxuryApartmentManagement_TrumpTowers
go
use LuxuryApartmentManagement_TrumpTowers
go
create table Buildings
(
	Build_Address nvarchar(100) primary key,
	Build_Name nvarchar(100) not null,
	Build_Describe nvarchar(255)
)

go
create table Categorize_Apartments
(
	CateApart_ID int identity (1,1) primary key,
	CateApart_Name nvarchar(100) not null,
	CateApart_Explication nvarchar(255),
	Build_Address nvarchar(100)
	constraint FK_CateApart_Build foreign key (Build_Address) references Buildings(Build_Address)
)
go

create table Apartments
(
	Apart_ID int identity (1,1) primary key,
	Apart_Name nvarchar(100),
	Apart_Cate int,
	Apart_Build int,
	Apart_Floor int,
	Apart_View bit,
	Apart_Acreage nvarchar(50),
	Apart_Price decimal,
	Apart_Describe nvarchar(255),
	Apart_Available bit,
	CateApart_ID int
	constraint FK_Apart_Cate foreign key (CateApart_ID) references Categorize_Apartments(CateApart_ID)
)
go
create table Customers
(	
	Cus_ID int identity (1,1) primary key,
	Cus_Name nvarchar(100),
	Cus_CitizenIdentificationPhoto Image,
	Cus_BirDate datetime,
	Cus_HomeTower nvarchar(200),
	Cus_Gender nvarchar(10),
	Cus_PhoneNumber varchar(11),
	Cus_Mail nvarchar(50),
	Cus_Note nvarchar(255),
)
go
create table Building_Services
(
	BuiServ_ID int identity (1,1) primary key,
	BuiServ_Name nvarchar(100),
	BuiServ_Price decimal,
	BuiServ_Explication nvarchar(255),
	BuiServ_Available bit,
	Build_Address nvarchar(100)
	constraint FK_BuServ_Build foreign key (Build_Address) references Buildings(Build_Address)
)
go
create table Apartment_Services
(
	ApartServ_ID int identity (1,1) primary key,
	ApartServ_Name nvarchar(100),
	ApartServ_Price decimal,
	ApartServ_Explication nvarchar(255),
	ApartServ_Available bit,
	Apart_ID int
	constraint FK_Apart_Serv foreign key (Apart_ID) references Apartments(Apart_ID)
)

go
create table Categorize_Contracts
(
	CateCon_ID int identity (1,1) primary key,
	CateCon_Name nvarchar(100)
)
go
create table Contracts
(
	Contr_ID int identity (1,1) primary key,
	Contr_Date datetime,
	Contr_Available bit,
	CateCon_ID int
	constraint FK_Contract_Cate foreign key (CateCon_ID) references Categorize_Contracts(CateCon_ID)
)
go
create table Detail_Contracts
(
	DetailCT_ID int identity(1,1) primary key,
	DetailCT_DepositPayment decimal,
	DetailCT_OutstandingPayment decimal,
	DetailCT_OldIndex int,
	DetailCT_NewIndex int,
	Contr_ID int
	constraint FK_Contract_Deltail foreign key (Contr_ID) references Contracts(Contr_ID)
)
go
create table Problems
(
	Prob_Id int identity (1,1) primary key,
	Prob_Describe nvarchar(255),
	Prob_Note nvarchar(255),
	Prob_Status nvarchar(50),
	Prob_DateOccur date,
	Apart_ID int,
	constraint FK_Problem_ApartID foreign key (Apart_ID) references Apartments(Apart_ID)
)
