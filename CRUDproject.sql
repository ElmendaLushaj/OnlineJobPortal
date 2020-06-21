use [master]
go

CREATE DATABASE [CRUDproject]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'CRUDproject', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\CRUDproject.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'CRUDproject_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\CRUDproject_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [CRUDproject] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [CRUDproject].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [CRUDproject] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [CRUDproject] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [CRUDproject] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [CRUDproject] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [CRUDproject] SET ARITHABORT OFF 
GO
ALTER DATABASE [CRUDproject] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [CRUDproject] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [CRUDproject] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [CRUDproject] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [CRUDproject] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [CRUDproject] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [CRUDproject] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [CRUDproject] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [CRUDproject] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [CRUDproject] SET  DISABLE_BROKER 
GO
ALTER DATABASE [CRUDproject] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [CRUDproject] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [CRUDproject] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [CRUDproject] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [CRUDproject] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [CRUDproject] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [CRUDproject] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [CRUDproject] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [CRUDproject] SET  MULTI_USER 
GO
ALTER DATABASE [CRUDproject] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [CRUDproject] SET DB_CHAINING OFF 
GO
ALTER DATABASE [CRUDproject] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [CRUDproject] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [CRUDproject] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [CRUDproject] SET QUERY_STORE = OFF
GO
USE [CRUDproject]
GO

/****** Object:  Table [dbo].[Personi]  ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Employer](
	[Employer_ID] [int] IDENTITY(1,1) NOT NULL,
	[E_Name] [varchar](150) NOT NULL,
	[E_Contact] [int] NOT NULL,
	[E_Email] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Employer] PRIMARY KEY CLUSTERED 
(
	[Employer_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Location]  ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Location](
	[Location_ID] [int] IDENTITY(1,1) NOT NULL,
	[Location_Name] [varchar](150) NOT NULL,
	[Employer_ID] [int] NOT NULL,
	CONSTRAINT FK_LocationEmployer FOREIGN KEY (Employer_ID)
    REFERENCES Employer(Employer_ID),
 CONSTRAINT [PK_Location] PRIMARY KEY CLUSTERED 
(
	[Location_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[JobCategory]  ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[JobCategory](
	[Category_ID] [int] IDENTITY(1,1) NOT NULL,
	[Category_Name] [varchar](150) NOT NULL,
	
	[Employer_ID] [int] NOT NULL,
	CONSTRAINT FK_JBE FOREIGN KEY (Employer_ID)
    REFERENCES Employer(Employer_ID),
	
 CONSTRAINT [PK_JobCategory] PRIMARY KEY CLUSTERED 
(
	[Category_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[Job]  ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO





/****** Object:  Table [dbo].[Company]  ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Company](
	[Company_ID] [int] IDENTITY(1,1) NOT NULL,
	[C_Name][varchar](150) NOT NULL,
	[C_Addresse][varchar](150) NOT NULL,
	[C_Email][varchar](150) NOT NULL,
	[C_Contact][int] NOT NULL,

	
 
 CONSTRAINT [PK_Company] PRIMARY KEY CLUSTERED 
(
	[Company_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Job](
	[Job_ID] [int] IDENTITY(1,1) NOT NULL,
	[Job_Title] [varchar](150) NOT NULL,
	[Job_Description] [varchar](150) NOT NULL,
	[Category_ID] [int] NOT NULL,
	[Location_ID] [int] NOT NULL,
	[Company_ID] [int] NOT Null,
	[Job_Type][varchar] NOT NULL,
	[Job_Salary][float] NOT NULL,
	[Posting_Date][date] Not Null,

	CONSTRAINT FK_JJC  FOREIGN KEY (Category_ID)
    REFERENCES JobCategory(Category_ID),

	CONSTRAINT FK_JL FOREIGN KEY (Location_ID)
    REFERENCES Location(Location_ID),
	 
	CONSTRAINT FK_JCC FOREIGN KEY (Company_ID)
    REFERENCES Company (Company_ID),

 CONSTRAINT [PK_Job] PRIMARY KEY CLUSTERED 
(
	[Job_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[Applicant]  ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Applicant](
	[Applicant_ID] [int] IDENTITY(1,1) NOT NULL,
	[A_Name] [varchar](150) NOT NULL,
	[Gender] [varchar](10) NOT NULL,
    [A_Email] [varchar](150) NOT NULL,
	[A_Contact][int] NOT NULL, 
	[Professional_Summary][varchar](150) NOT NULL,
 CONSTRAINT [PK_Applicant] PRIMARY KEY CLUSTERED 
(
	[Applicant_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[ApplicationDetails]  ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ApplicationDetails](
	[Application_ID] [int] IDENTITY(1,1) NOT NULL,
	[Job_ID][int] Not Null,
	[Applicant_ID][int] NOT NULL,

	CONSTRAINT FK_ADJ FOREIGN KEY (Job_ID)
    REFERENCES Job (Job_ID),

	CONSTRAINT FK_ADA FOREIGN KEY (Applicant_ID)
    REFERENCES Applicant (Applicant_ID),
 
 
 CONSTRAINT [PK_ApplicationDetails] PRIMARY KEY CLUSTERED 
(
	[Application_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO




SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Username] [varchar](50) NULL,
	[Password] [varchar](550) NULL,
	[RoleID] [int] NULL,
 CONSTRAINT [PK_Perdoruesi] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Role](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [varchar](50) NULL,
 CONSTRAINT [PK_Role] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE Employer
ADD filetype IMAGE  ;
ALTER TABLE Applicant
ADD filetype IMAGE  ;
INSERT [dbo].[User] ([Username], [Password], [RoleID]) VALUES (N'elmenda.lushaj', N'123456', 1)
INSERT [dbo].[User] ([Username], [Password], [RoleID]) VALUES (N'lester.branch', N'0000', 2)
INSERT [dbo].[User] ([Username], [Password], [RoleID]) VALUES (N'macy.riviera', N'1111', 3)


INSERT [dbo].[Role] ([Name]) VALUES (N'Admin')
INSERT [dbo].[Role] ([Name]) VALUES (N'User')
INSERT [dbo].[Role] ([Name]) VALUES (N'UserEmployer')


ALTER TABLE [dbo].[User]  WITH CHECK ADD  CONSTRAINT [FK_User_Role] FOREIGN KEY([RoleID])
REFERENCES [dbo].[Role] ([ID])
GO
ALTER TABLE [dbo].[User] CHECK CONSTRAINT [FK_User_Role]
GO



   


INSERT [dbo].[Employer] ([Employer_ID],[E_Name],[E_Contact],[E_Email]) VALUES (16681381,'Macy Rivera',0135-9100739,'eu.sem.Pellentesque@consequat.edu')
INSERT[dbo].[Employer] ([Employer_ID],[E_Name],[E_Contact],[E_Email]) VALUES(165456,'Rama Peck',07624-339983,'nisl.Nulla@tempusscelerisquelorem.org');
INSERT [dbo].[Employer] ([Employer_ID],[E_Name],[E_Contact],[E_Email]) VALUES(165818,'Lucian Andrews',0845-46-42,'placerat@necmalesuada.org');
INSERT [dbo].[Employer] ([Employer_ID],[E_Name],[E_Contact],[E_Email]) VALUES(16550,'Nerea Wiggins',0382-981-0373,'rhoncus.Proin.nisl@arcu.co.uk');
INSERT [dbo].[Employer] ([Employer_ID],[E_Name],[E_Contact],[E_Email]) VALUES(163261,'Allistair Scott',020-01976005,'orci.Ut@Curabitursedtortor.edu');
INSERT [dbo].[Employer] ([Employer_ID],[E_Name],[E_Contact],[E_Email]) VALUES(1637549,'Claudia Morales',0393-1732984,'malesuada@nequevitaesemper.ca'); 
INSERT [dbo].[Employer] ([Employer_ID],[E_Name],[E_Contact],[E_Email]) VALUES (161102,'Carson Holder',01360-38607,'sit.amet@per.org');
INSERT [dbo].[Employer] ([Employer_ID],[E_Name],[E_Contact],[E_Email]) VALUES(1616284,'Xena Pearson',0199-43617,'interdum.Sed@asollicitudin.net');
INSERT [dbo].[Employer] ([Employer_ID],[E_Name],[E_Contact],[E_Email]) VALUES(165942,'Galvin Thomas',0800-040847,'lacinia.at@Vivamus.co.uk');
INSERT [dbo].[Employer] ([Employer_ID],[E_Name],[E_Contact],[E_Email]) VALUES(166808,'Abel Welch',0845-4642,'lacinia@eratVivamusnisi.net');
INSERT [dbo].[Employer] ([Employer_ID],[E_Name],[E_Contact],[E_Email]) VALUES (1645197,'Zachery Robertson',076-2786-4591,'sit.amet@vitae.com');
INSERT [dbo].[Employer] ([Employer_ID],[E_Name],[E_Contact],[E_Email]) VALUES(165827,'Mannix Herman',0855-2867759,'vitae.risus.Duis@ametlorem.net');
INSERT [dbo].[Employer] ([Employer_ID],[E_Name],[E_Contact],[E_Email]) VALUES(165073,'TaShya Huber',0845-4644,'a@consectetuercursus.co.uk');
INSERT [dbo].[Employer] ([Employer_ID],[E_Name],[E_Contact],[E_Email]) VALUES(162842,'Genevieve Stanton',056-45650654,'Donec@a.co.uk');
INSERT [dbo].[Employer] ([Employer_ID],[E_Name],[E_Contact],[E_Email]) VALUES (1616031,'Beau Barton',0117-629-4380,'ornare.lectus.ante@egestasascelerisque.edu')
INSERT [dbo].[Employer] ([Employer_ID],[E_Name],[E_Contact],[E_Email])VALUES(1632082,'Tyrone England',055-7768-4148,'Nullam@vel.co.uk');
INSERT [dbo].[Employer] ([Employer_ID],[E_Name],[E_Contact],[E_Email]) VALUES(163851,'Holmes Buck',0800-1111,'lectus@fermentummetusAenean.org');
INSERT [dbo].[Employer] ([Employer_ID],[E_Name],[E_Contact],[E_Email]) VALUES(1670027,'Beau Carrillo',07624-771979,'id@ametconsectetueradipiscing.ca');
SET IDENTITY_INSERT [dbo].[Employer] OFF


INSERT  [dbo].[Location]([Location_ID],[Location_Name],[Employer_ID]) VALUES (101,'Georgia',1670027);
INSERT  [dbo].[Location]([Location_ID],[Location_Name],[Employer_ID]) VALUES (102,'Bharatpur',163851);
INSERT  [dbo].[Location]([Location_ID],[Location_Name],[Employer_ID]) VALUES (103,'Ambleside',1632082);
INSERT  [dbo].[Location]([Location_ID],[Location_Name],[Employer_ID]) VALUES (104,'Belcarra',1616031);
INSERT  [dbo].[Location]([Location_ID],[Location_Name],[Employer_ID]) VALUES (105,'Cincinnati',162842);
INSERT  [dbo].[Location]([Location_ID],[Location_Name],[Employer_ID]) VALUES (106,'Knoxville',165073);
INSERT  [dbo].[Location]([Location_ID],[Location_Name],[Employer_ID]) VALUES (107,'MŽlin',165827);
INSERT  [dbo].[Location]([Location_ID],[Location_Name],[Employer_ID]) VALUES (108,'Rae Lakes',1645197);
INSERT  [dbo].[Location]([Location_ID],[Location_Name],[Employer_ID]) VALUES (109,'Lytkarino',166808);
INSERT  [dbo].[Location]([Location_ID],[Location_Name],[Employer_ID]) VALUES (110,'Santa Flavia',165942);
INSERT  [dbo].[Location]([Location_ID],[Location_Name],[Employer_ID]) VALUES (111,'Moio Alcantara',1616284);
INSERT  [dbo].[Location]([Location_ID],[Location_Name],[Employer_ID]) VALUES (112,'Parrano',161102);
INSERT  [dbo].[Location]([Location_ID],[Location_Name],[Employer_ID]) VALUES (113,'Bexbach',1637549);
INSERT  [dbo].[Location]([Location_ID],[Location_Name],[Employer_ID]) VALUES (114,'Montresta',163261);
INSERT  [dbo].[Location]([Location_ID],[Location_Name],[Employer_ID]) VALUES (115,'Monfumo',16550);
INSERT  [dbo].[Location]([Location_ID],[Location_Name],[Employer_ID]) VALUES (116,'Saltillo',165818);
INSERT  [dbo].[Location]([Location_ID],[Location_Name],[Employer_ID]) VALUES (117,'Kaaskerke',165456);
INSERT  [dbo].[Location]([Location_ID],[Location_Name],[Employer_ID]) VALUES (118,'Shreveport',16681381);
SET IDENTITY_INSERT [dbo].[Location] OFF


INSERT  [dbo].[JobCategory]([Category_ID],[Category_Name],[Employer_ID]) VALUES (2001,'Advertising Sales',1670027);
INSERT  [dbo].[JobCategory]([Category_ID],[Category_Name],[Employer_ID]) VALUES (2002,'Architectural and Engineering',163851);
INSERT  [dbo].[JobCategory]([Category_ID],[Category_Name],[Employer_ID]) VALUES (2003,'Cleaning',1632082);
INSERT  [dbo].[JobCategory]([Category_ID],[Category_Name],[Employer_ID]) VALUES (2004,'Computer Programmers',1616031);
INSERT  [dbo].[JobCategory]([Category_ID],[Category_Name],[Employer_ID]) VALUES (2005,'Computer Science and Database Administration',162842);
INSERT  [dbo].[JobCategory]([Category_ID],[Category_Name],[Employer_ID]) VALUES (2006,'Economists',165073);
INSERT  [dbo].[JobCategory]([Category_ID],[Category_Name],[Employer_ID]) VALUES (2007,'Electrical and Electronics',165827);
INSERT  [dbo].[JobCategory]([Category_ID],[Category_Name],[Employer_ID]) VALUES (2008,'Financial Analysts',1645197);
INSERT  [dbo].[JobCategory]([Category_ID],[Category_Name],[Employer_ID]) VALUES (2009,'Food Service',166808);
INSERT  [dbo].[JobCategory]([Category_ID],[Category_Name],[Employer_ID]) VALUES (2010,'Graphic Designers',165942);
INSERT  [dbo].[JobCategory]([Category_ID],[Category_Name],[Employer_ID]) VALUES (2011,'Health and Safety',1616284);
INSERT  [dbo].[JobCategory]([Category_ID],[Category_Name],[Employer_ID]) VALUES (2012,'Mechanical Engineers',161102);
INSERT  [dbo].[JobCategory]([Category_ID],[Category_Name],[Employer_ID]) VALUES (2013,'Pharmacists',1637549);
INSERT  [dbo].[JobCategory]([Category_ID],[Category_Name],[Employer_ID]) VALUES (2014,'Software Developers',163261);
INSERT  [dbo].[JobCategory]([Category_ID],[Category_Name],[Employer_ID]) VALUES (2015,'Travel Agents',16550);
INSERT  [dbo].[JobCategory]([Category_ID],[Category_Name],[Employer_ID]) VALUES (2016,'Teachers',165818);
INSERT  [dbo].[JobCategory]([Category_ID],[Category_Name],[Employer_ID]) VALUES (2017,'Meeting and Convention Planners',165456);
INSERT  [dbo].[JobCategory]([Category_ID],[Category_Name],[Employer_ID]) VALUES (2018,'Market Research Analysts',16681381);
SET IDENTITY_INSERT [dbo].[JobCategory] OFF


INSERT [dbo].[Applicant]([Applicant_ID],[A_Name],[Gender],[A_Email],[A_Contact],[Professional_Summary]) VALUES (508398,'Lester Branch','Male','eget.nisi.dictum@posuereat.org',304702320,'euismod et, commodo at, libero.');
INSERT [dbo].[Applicant]([Applicant_ID],[A_Name],[Gender],[A_Email],[A_Contact],[Professional_Summary]) VALUES (128595,'Serina Franco','Female','ultricies.ligula@lobortisultrices.org',20382350,'sit');
INSERT [dbo].[Applicant]([Applicant_ID],[A_Name],[Gender],[A_Email],[A_Contact],[Professional_Summary]) VALUES (786870,'Harlan Trevino','Male','ridiculus@ametnullaDonec.ca',3476684,'ultrices posuere cubilia Curae;');
INSERT [dbo].[Applicant]([Applicant_ID],[A_Name],[Gender],[A_Email],[A_Contact],[Professional_Summary]) VALUES (644932,'Dominic Benson','Male','consectetuer@erategettincidunt.ca',939146150,'felis ullamcorper viverra.');
INSERT [dbo].[Applicant]([Applicant_ID],[A_Name],[Gender],[A_Email],[A_Contact],[Professional_Summary]) VALUES (547458,'Montana Tyson','Female','diam.Proin@lobortisrisusIn.co.uk',19222641,'posuere');
INSERT [dbo].[Applicant]([Applicant_ID],[A_Name],[Gender],[A_Email],[A_Contact],[Professional_Summary]) VALUES (449999,'Myra Roy','Female','lacinia@tellus.com',63814040,'malesuada fringilla est.');
INSERT [dbo].[Applicant]([Applicant_ID],[A_Name],[Gender],[A_Email],[A_Contact],[Professional_Summary]) VALUES (088164,'Beau Hensley','Male','Donec.egestas.Aliquam@purusmauris.org',3578554,'cubilia Curae; Phasellus ornare. Fusce');
INSERT[dbo].[Applicant]([Applicant_ID],[A_Name],[Gender],[A_Email],[A_Contact],[Professional_Summary])  VALUES (679725,'Ray Kaufman','Male','Duis@semNullainterdum.ca',45506420,'Donec tempor, est');
INSERT [dbo].[Applicant]([Applicant_ID],[A_Name],[Gender],[A_Email],[A_Contact],[Professional_Summary]) VALUES (359532,'Malachi Welch','Female','faucibus.ut.nulla@etmagnis.co.uk',08514746,'urna. Ut tincidunt vehicula risus. Nulla');
INSERT [dbo].[Applicant]([Applicant_ID],[A_Name],[Gender],[A_Email],[A_Contact],[Professional_Summary]) VALUES (082446,'Nolan Matthew','Male','libero@auctorvelit.com',3560462,'egestas. Duis ac arcu. Nunc');
INSERT [dbo].[Applicant]([Applicant_ID],[A_Name],[Gender],[A_Email],[A_Contact],[Professional_Summary]) VALUES (109538,'Juliet Mccullough','Female','Fusce.fermentum.fermentum@vel.edu',5800384,'felis eget varius ultrices, mauris');
INSERT [dbo].[Applicant]([Applicant_ID],[A_Name],[Gender],[A_Email],[A_Contact],[Professional_Summary]) VALUES (698740,'Jamalia Knowles','Female','Integer@Duisrisus.edu',637146,'Sed eu eros.');
INSERT [dbo].[Applicant]([Applicant_ID],[A_Name],[Gender],[A_Email],[A_Contact],[Professional_Summary]) VALUES (534398,'Cheyenne Logan','Male','faucibus.orci@turpisIncondimentum.ca',0086584,'sit amet lorem semper auctor. Mauris');
INSERT [dbo].[Applicant]([Applicant_ID],[A_Name],[Gender],[A_Email],[A_Contact],[Professional_Summary]) VALUES (062134,'Joseph Cervantes','Male','commodo@felispurus.net',970807,'auctor odio');
INSERT [dbo].[Applicant]([Applicant_ID],[A_Name],[Gender],[A_Email],[A_Contact],[Professional_Summary]) VALUES (804477,'Gloria Curry','Female','molestie@eu.edu',4227383,'et netus et malesuada fames ac');
INSERT [dbo].[Applicant]([Applicant_ID],[A_Name],[Gender],[A_Email],[A_Contact],[Professional_Summary]) VALUES (487046,'Philip Rose','Male','nunc@nislelementumpurus.ca',415044,'Vivamus molestie dapibus ligula.');
SET IDENTITY_INSERT [dbo].[Applicant] OFF

INSERT [dbo].[Company]([Company_ID],[C_Name],[C_Addresse],[C_Email],[C_Contact]) VALUES (44760400,'Fermentum Convallis Ligula Limited','336-702 Praesent Ave','Donec.porttitor@quam.edu',415678);
INSERT [dbo].[Company]([Company_ID],[C_Name],[C_Addresse],[C_Email],[C_Contact]) VALUES (31333923,'Scelerisque Neque Nullam Limited','Ap #829-9519 Sit Ave','mauris.erat@eudui.co.uk',415878);
INSERT [dbo].[Company]([Company_ID],[C_Name],[C_Addresse],[C_Email],[C_Contact]) VALUES (5969598,'Sed Est PC','7133 Diam. Street','id.nunc.interdum@nonbibendum.com',4113529);
INSERT [dbo].[Company]([Company_ID],[C_Name],[C_Addresse],[C_Email],[C_Contact]) VALUES (31575872,'Enim LLC','8707 Erat Street','arcu.Curabitur@nibhDonec.ca',5289929);
INSERT [dbo].[Company]([Company_ID],[C_Name],[C_Addresse],[C_Email],[C_Contact]) VALUES (8155945,'Sed Incorporated','P.O. Box 824, 6923Dolor. Road','lobortis.quam@pedesagittis.co.uk',456465);
INSERT [dbo].[Company]([Company_ID],[C_Name],[C_Addresse],[C_Email],[C_Contact]) VALUES (25451943,'Faucibus Leo In Consulting','P.O. Box 811, 7507 Lectus St.','felis.adipiscing.fringilla@penatibus.ca',6546556);
INSERT [dbo].[Company]([Company_ID],[C_Name],[C_Addresse],[C_Email],[C_Contact]) VALUES (38606672,'Imperdiet Nec Company','139-153 Arcu St.','adipiscing@pedeCum.co.uk',65465465);
INSERT [dbo].[Company]([Company_ID],[C_Name],[C_Addresse],[C_Email],[C_Contact]) VALUES (39090928,'Quis Arcu LLP','412-3622 Ultrices Avenue','semper.dui@lectusjustoeu.ca',65456654);
INSERT [dbo].[Company]([Company_ID],[C_Name],[C_Addresse],[C_Email],[C_Contact]) VALUES (38066825,'Vel Arcu Curabitur Incorporated','Ap #678-7992 Felis Rd.','eleifend.egestas.Sed@purusDuis.org',564554);
INSERT [dbo].[Company]([Company_ID],[C_Name],[C_Addresse],[C_Email],[C_Contact]) VALUES (36350786,'Ipsum Incorporated','P.O. Box 639, 2482 Enim St.','mus.Aenean.eget@Aliquamrutrum.com',554546);
INSERT [dbo].[Company]([Company_ID],[C_Name],[C_Addresse],[C_Email],[C_Contact]) VALUES (34724615,'Sed Congue Foundation','794-7145 Aenean Street','metus@lorem.com',654456);
INSERT [dbo].[Company]([Company_ID],[C_Name],[C_Addresse],[C_Email],[C_Contact]) VALUES (20456669,'Magna Cras LLC','P.O. Box 534, 3775 Tempor Ave','molestie.Sed.id@orciluctuset.com',65654654);
INSERT [dbo].[Company]([Company_ID],[C_Name],[C_Addresse],[C_Email],[C_Contact]) VALUES (19552047,'Fringilla Porttitor Industries','9762 Nunc Avenue','mi.felis.adipiscing@est.net',654656);
INSERT [dbo].[Company]([Company_ID],[C_Name],[C_Addresse],[C_Email],[C_Contact]) VALUES (9877266,'Pede Et Associates','P.O. Box 682, 7731 Blandit Ave','non.nisi@nullamagnamalesuada.net',897989);
SET IDENTITY_INSERT [dbo].[Company] OFF
SET ansi_warnings OFF
GO

INSERT [dbo].[Job]([Job_ID],[Job_Title],[Job_Description],[Category_ID],[Location_ID],[Company_ID],[Job_Type],[Job_Salary],[Posting_Date]) VALUES (80001,'Advertising Sales Agents','senectus et netus et malesuada',2001,101,44760400,'Worker',450,'2020-04-05');
INSERT [dbo].[Job]([Job_ID],[Job_Title],[Job_Description],[Category_ID],[Location_ID],[Company_ID],[Job_Type],[Job_Salary],[Posting_Date]) VALUES (80002,'Architectural and Engineering Managers','aliquam eros turpis non enim',2002,102,31333923,'Manager',375,'2020-01-05');
INSERT [dbo].[Job]([Job_ID],[Job_Title],[Job_Description],[Category_ID],[Location_ID],[Company_ID],[Job_Type],[Job_Salary],[Posting_Date]) VALUES (80003,'Building Cleaning Workers','consequat auctor, nunc nulla vulputate',2003,103,5969598,'Worker',650,'2020-01-05');
INSERT [dbo].[Job]([Job_ID],[Job_Title],[Job_Description],[Category_ID],[Location_ID],[Company_ID],[Job_Type],[Job_Salary],[Posting_Date]) VALUES (80004,'Computer Programmers','Proin eget odio. Aliquam vulputate',2004,104,31575872,'Worker',425,'2020-01-05');
INSERT [dbo].[Job]([Job_ID],[Job_Title],[Job_Description],[Category_ID],[Location_ID],[Company_ID],[Job_Type],[Job_Salary],[Posting_Date]) VALUES (80005,'Computer Scientists and Database Administrators','in molestie tortor nibh sit',2005,105,8155945,'Manager',380,'2020-01-05');
INSERT [dbo].[Job]([Job_ID],[Job_Title],[Job_Description],[Category_ID],[Location_ID],[Company_ID],[Job_Type],[Job_Salary],[Posting_Date]) VALUES (80006,'Economists','id nunc interdum feugiat. Sed',2006,106,25451943,'Worker',550,'2020-01-05');
INSERT [dbo].[Job]([Job_ID],[Job_Title],[Job_Description],[Category_ID],[Location_ID],[Company_ID],[Job_Type],[Job_Salary],[Posting_Date]) VALUES (80007,'Electrical and Electronics Engineers','sociis natoque penatibus et magnis',2007,107,38606672,'Worker',457,'2020-01-05');
INSERT [dbo].[Job]([Job_ID],[Job_Title],[Job_Description],[Category_ID],[Location_ID],[Company_ID],[Job_Type],[Job_Salary],[Posting_Date]) VALUES (80008,'Financial Analysts','tincidunt adipiscing. Mauris molestie pharetra',2008,108,39090928,'Worker',740,'2020-01-05');
INSERT [dbo].[Job]([Job_ID],[Job_Title],[Job_Description],[Category_ID],[Location_ID],[Company_ID],[Job_Type],[Job_Salary],[Posting_Date]) VALUES (80009,'Food Service Managers','malesuada vel, venenatis vel, faucibus',2009,109,38066825,'Manager',950,'2020-11-25');
INSERT [dbo].[Job]([Job_ID],[Job_Title],[Job_Description],[Category_ID],[Location_ID],[Company_ID],[Job_Type],[Job_Salary],[Posting_Date]) VALUES (80010,'Graphic Designers','Aenean massa. Integer vitae nibh.',2010,110,36350786,'Worker',498,'2020-01-05');
INSERT [dbo].[Job]([Job_ID],[Job_Title],[Job_Description],[Category_ID],[Location_ID],[Company_ID],[Job_Type],[Job_Salary],[Posting_Date]) VALUES (80011,'Health and Safety Engineers','venenatis vel, faucibus id, libero.',2011,111,34724615,'Worker',436,'2020-11-05');
INSERT [dbo].[Job]([Job_ID],[Job_Title],[Job_Description],[Category_ID],[Location_ID],[Company_ID],[Job_Type],[Job_Salary],[Posting_Date]) VALUES (80012,'Mechanical Engineers','dis parturient montes, nascetur ridiculus',2012,112,20456669,'Worker',399,'2020-04-15');
INSERT [dbo].[Job]([Job_ID],[Job_Title],[Job_Description],[Category_ID],[Location_ID],[Company_ID],[Job_Type],[Job_Salary],[Posting_Date]) VALUES (80013,'Pharmacists','primis in faucibus orci luctus',2013,113,19552047,'Worker',578,'2020-01-19');
INSERT [dbo].[Job]([Job_ID],[Job_Title],[Job_Description],[Category_ID],[Location_ID],[Company_ID],[Job_Type],[Job_Salary],[Posting_Date]) VALUES (80014,'Software Developers','tincidunt adipiscing. Mauris molestie pharetra',2014,114,9877266,'Worker',690,'2020-03-05');
SET IDENTITY_INSERT [dbo].[Job] OFF

INSERT [dbo].[ApplicationDetails]([Application_ID],[Job_ID],[Applicant_ID]) VALUES (1000001,80001,508398);
INSERT [dbo].[ApplicationDetails]([Application_ID],[Job_ID],[Applicant_ID]) VALUES (1000002,80002,128595);
INSERT [dbo].[ApplicationDetails]([Application_ID],[Job_ID],[Applicant_ID]) VALUES (1000003,80003,786870);
INSERT [dbo].[ApplicationDetails]([Application_ID],[Job_ID],[Applicant_ID]) VALUES (1000004,80004,644932);
INSERT [dbo].[ApplicationDetails]([Application_ID],[Job_ID],[Applicant_ID]) VALUES (1000005,80005,547458);
INSERT [dbo].[ApplicationDetails]([Application_ID],[Job_ID],[Applicant_ID]) VALUES (1000006,80006,449999);
INSERT [dbo].[ApplicationDetails]([Application_ID],[Job_ID],[Applicant_ID]) VALUES (1000007,80007,088164);
INSERT [dbo].[ApplicationDetails]([Application_ID],[Job_ID],[Applicant_ID]) VALUES (1000008,80008,679725);
INSERT [dbo].[ApplicationDetails]([Application_ID],[Job_ID],[Applicant_ID]) VALUES (1000009,80009,359532);
INSERT [dbo].[ApplicationDetails]([Application_ID],[Job_ID],[Applicant_ID]) VALUES (1000010,80010,082446);
INSERT [dbo].[ApplicationDetails]([Application_ID],[Job_ID],[Applicant_ID]) VALUES (1000011,80011,109538);
INSERT [dbo].[ApplicationDetails]([Application_ID],[Job_ID],[Applicant_ID]) VALUES (1000012,80012,698740);
INSERT [dbo].[ApplicationDetails]([Application_ID],[Job_ID],[Applicant_ID]) VALUES (1000013,80013,534398);
INSERT [dbo].[ApplicationDetails]([Application_ID],[Job_ID],[Applicant_ID]) VALUES (1000014,80014,062134);
SET IDENTITY_INSERT [dbo].[ApplicationDetails] OFF


USE [master]
GO
ALTER DATABASE [CRUDproject] SET  READ_WRITE 
GO
USE CRUDproject

CREATE TABLE [dbo].[Perdoruesi](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Username] [varchar](50) NULL,
	[Password] [varchar](550) NULL,
	[RoliID] [int] NULL,
 CONSTRAINT [PK_Perdoruesi] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Roli](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Emertimi] [varchar](50) NULL,
 CONSTRAINT [PK_Roli] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO


INSERT [dbo].[Perdoruesi] ([Username], [Password], [RoliID]) VALUES (N'useradmin', N'123456', 1)
INSERT [dbo].[Perdoruesi] ([Username], [Password], [RoliID]) VALUES (N'useremployer', N'000', 2)
INSERT [dbo].[Perdoruesi] ([Username], [Password], [RoliID]) VALUES (N'userapplicant', N'444', 3)

INSERT [dbo].[Roli] ([Emertimi]) VALUES (N'Admini')
INSERT [dbo].[Roli] ([Emertimi]) VALUES (N'UserEmployer')
INSERT [dbo].[Roli] ([Emertimi]) VALUES (N'Useri')

ALTER TABLE [dbo].[Perdoruesi]  WITH CHECK ADD  CONSTRAINT [FK_Perdoruesi_Roli] FOREIGN KEY([RoliID])
REFERENCES [dbo].[Roli] ([ID])
GO
ALTER TABLE [dbo].[Perdoruesi] CHECK CONSTRAINT [FK_Perdoruesi_Roli]
GO
