USE [master]
GO

/****** Object:  Database [CRUD13] ******/
CREATE DATABASE [CRUD13]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'CRUD13', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\CRUD13.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'CRUD13_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\CRUD13_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [CRUD13] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [CRUD13].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [CRUD13] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [CRUD13] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [CRUD13] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [CRUD13] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [CRUD13] SET ARITHABORT OFF 
GO
ALTER DATABASE [CRUD13] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [CRUD13] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [CRUD13] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [CRUD13] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [CRUD13] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [CRUD13] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [CRUD13] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [CRUD13] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [CRUD13] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [CRUD13] SET  DISABLE_BROKER 
GO
ALTER DATABASE [CRUD13] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [CRUD13] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [CRUD13] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [CRUD13] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [CRUD13] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [CRUD13] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [CRUD13] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [CRUD13] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [CRUD13] SET  MULTI_USER 
GO
ALTER DATABASE [CRUD13] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [CRUD13] SET DB_CHAINING OFF 
GO
ALTER DATABASE [CRUD13] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [CRUD13] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO

USE [CRUD13]
GO

/****** Object:  Table [dbo].[Employer]  ******/
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
	[Location_ID] [int]  IDENTITY (1,1) NOT NULL,
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






/****** Object:  Table [dbo].[Company]  ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Company](
	[Company_ID] [int] IDENTITY (1,1) NOT NULL,
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

/****** Object:  Table [dbo].[Job]  ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
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
    REFERENCES JobCategory (Category_ID),

	CONSTRAINT FK_JL FOREIGN KEY (Location_ID)
    REFERENCES Location (Location_ID),
	 
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








INSERT [dbo].[Employer] ([E_Name],[E_Contact],[E_Email]) VALUES (N'Macy Rivera',0135-9100739,N'eu.sem.Pellentesque@consequat.edu')
INSERT [dbo].[Employer]  ([E_Name],[E_Contact],[E_Email]) VALUES(N'Rama Peck',07624-339983,N'nisl.Nulla@tempusscelerisquelorem.org')
INSERT  [dbo].[Employer] ([E_Name],[E_Contact],[E_Email]) VALUES(N'Lucian Andrews',0845-46-42,N'placerat@necmalesuada.org')
INSERT  [dbo].[Employer] ([E_Name],[E_Contact],[E_Email]) VALUES(N'Nerea Wiggins',0382-981-0373,N'rhoncus.Proin.nisl@arcu.co.uk')
INSERT [dbo].[Employer] ([E_Name],[E_Contact],[E_Email]) VALUES(N'Allistair Scott',020-01976005,N'orci.Ut@Curabitursedtortor.edu')
INSERT  [dbo].[Employer] ([E_Name],[E_Contact],[E_Email]) VALUES(N'Claudia Morales',0393-1732984,N'malesuada@nequevitaesemper.ca') 
INSERT   [dbo].[Employer] ([E_Name],[E_Contact],[E_Email]) VALUES (N'Carson Holder',01360-38607,N'sit.amet@per.org')
INSERT  [dbo].[Employer] ([E_Name],[E_Contact],[E_Email]) VALUES(N'Xena Pearson',0199-43617,N'interdum.Sed@asollicitudin.net')
INSERT [dbo].[Employer] ([E_Name],[E_Contact],[E_Email]) VALUES(N'Galvin Thomas',0800-040847,N'lacinia.at@Vivamus.co.uk')
INSERT [dbo].[Employer] ([E_Name],[E_Contact],[E_Email]) VALUES(N'Abel Welch',0845-4642,N'lacinia@eratVivamusnisi.net')
INSERT [dbo].[Employer] ([E_Name],[E_Contact],[E_Email]) VALUES (N'Zachery Robertson',076-2786-4591,N'sit.amet@vitae.com')
INSERT [dbo].[Employer] ([E_Name],[E_Contact],[E_Email]) VALUES(N'Mannix Herman',0855-2867759,N'vitae.risus.Duis@ametlorem.net')
INSERT [dbo].[Employer] ([E_Name],[E_Contact],[E_Email]) VALUES(N'TaShya Huber',0845-4644,N'a@consectetuercursus.co.uk')
INSERT [dbo].[Employer] ([E_Name],[E_Contact],[E_Email]) VALUES(N'Genevieve Stanton',056-45650654,N'Donec@a.co.uk')
INSERT [dbo].[Employer] ([E_Name],[E_Contact],[E_Email]) VALUES (N'Beau Barton',0117-629-4380,N'ornare.lectus.ante@egestasascelerisque.edu')
INSERT [dbo].[Employer] ([E_Name],[E_Contact],[E_Email])VALUES(N'Tyrone England',055-7768-4148,N'Nullam@vel.co.uk')
INSERT [dbo].[Employer] ([E_Name],[E_Contact],[E_Email]) VALUES(N'Holmes Buck',0800-1111,N'lectus@fermentummetusAenean.org')
INSERT [dbo].[Employer] ([E_Name],[E_Contact],[E_Email]) VALUES(N'Beau Carrillo',07624-771979,N'id@ametconsectetueradipiscing.ca')
SET IDENTITY_INSERT [dbo].[Employer] OFF


INSERT  [dbo].[Location]([Location_Name],[Employer_ID]) VALUES ('Georgia',1);
INSERT  [dbo].[Location]([Location_Name],[Employer_ID]) VALUES ('Bharatpur',11);
INSERT  [dbo].[Location]([Location_Name],[Employer_ID]) VALUES ('Ambleside',14);
INSERT  [dbo].[Location]([Location_Name],[Employer_ID]) VALUES ('Belcarra',12);
INSERT  [dbo].[Location]([Location_Name],[Employer_ID]) VALUES ('Cincinnati',11);
INSERT  [dbo].[Location]([Location_Name],[Employer_ID]) VALUES ('Knoxville',11);
INSERT  [dbo].[Location]([Location_Name],[Employer_ID]) VALUES ('MŽlin',4);
INSERT  [dbo].[Location]([Location_Name],[Employer_ID]) VALUES ('Rae Lakes',4);
INSERT  [dbo].[Location]([Location_Name],[Employer_ID]) VALUES ('Lytkarino',5);
INSERT  [dbo].[Location]([Location_Name],[Employer_ID]) VALUES ('Santa Flavia',7);
INSERT  [dbo].[Location]([Location_Name],[Employer_ID]) VALUES ('Moio Alcantara',8);
INSERT  [dbo].[Location]([Location_Name],[Employer_ID]) VALUES ('Parrano',8);
INSERT  [dbo].[Location]([Location_Name],[Employer_ID]) VALUES ('Bexbach',6);
INSERT  [dbo].[Location]([Location_Name],[Employer_ID]) VALUES ('Montresta',3);
INSERT  [dbo].[Location]([Location_Name],[Employer_ID]) VALUES ('Monfumo',2);
INSERT  [dbo].[Location]([Location_Name],[Employer_ID]) VALUES ('Saltillo',7);
INSERT  [dbo].[Location]([Location_Name],[Employer_ID]) VALUES ('Kaaskerke',6);
INSERT  [dbo].[Location]([Location_Name],[Employer_ID]) VALUES ('Shreveport',3);
SET IDENTITY_INSERT [dbo].[Location] OFF


INSERT  [dbo].[JobCategory]([Category_Name],[Employer_ID]) VALUES ('Advertising Sales',7);
INSERT  [dbo].[JobCategory]([Category_Name],[Employer_ID]) VALUES ('Architectural and Engineering',11);
INSERT  [dbo].[JobCategory]([Category_Name],[Employer_ID]) VALUES ('Cleaning',2);
INSERT  [dbo].[JobCategory]([Category_Name],[Employer_ID]) VALUES ('Computer Programmers',1);
INSERT  [dbo].[JobCategory]([Category_Name],[Employer_ID]) VALUES ('Computer Science and Database Administration',2);
INSERT  [dbo].[JobCategory]([Category_Name],[Employer_ID]) VALUES ('Economists',13);
INSERT  [dbo].[JobCategory]([Category_Name],[Employer_ID]) VALUES ('Electrical and Electronics',7);
INSERT  [dbo].[JobCategory]([Category_Name],[Employer_ID]) VALUES ('Financial Analysts',7);
INSERT  [dbo].[JobCategory]([Category_Name],[Employer_ID]) VALUES ('Food Service',8);
INSERT  [dbo].[JobCategory]([Category_Name],[Employer_ID]) VALUES ('Graphic Designers',12);
INSERT  [dbo].[JobCategory]([Category_Name],[Employer_ID]) VALUES ('Health and Safety',14);
INSERT  [dbo].[JobCategory]([Category_Name],[Employer_ID]) VALUES ('Mechanical Engineers',12);
INSERT  [dbo].[JobCategory]([Category_Name],[Employer_ID]) VALUES ('Pharmacists',9);
INSERT  [dbo].[JobCategory]([Category_Name],[Employer_ID]) VALUES ('Software Developers',1);
INSERT  [dbo].[JobCategory]([Category_Name],[Employer_ID]) VALUES ('Travel Agents',1);
INSERT  [dbo].[JobCategory]([Category_Name],[Employer_ID]) VALUES ('Teachers',8);
INSERT  [dbo].[JobCategory]([Category_Name],[Employer_ID]) VALUES ('Meeting and Convention Planners',6);
INSERT  [dbo].[JobCategory]([Category_Name],[Employer_ID]) VALUES ('Market Research Analysts',14);
SET IDENTITY_INSERT [dbo].[JobCategory] OFF


INSERT [dbo].[Applicant]([A_Name],[Gender],[A_Email],[A_Contact],[Professional_Summary]) VALUES ('Lester Branch','Male','eget.nisi.dictum@posuereat.org',304702320,'euismod et, commodo at, libero.');
INSERT [dbo].[Applicant]([A_Name],[Gender],[A_Email],[A_Contact],[Professional_Summary]) VALUES ('Serina Franco','Female','ultricies.ligula@lobortisultrices.org',20382350,'sit');
INSERT [dbo].[Applicant]([A_Name],[Gender],[A_Email],[A_Contact],[Professional_Summary]) VALUES ('Harlan Trevino','Male','ridiculus@ametnullaDonec.ca',3476684,'ultrices posuere cubilia Curae;');
INSERT [dbo].[Applicant]([A_Name],[Gender],[A_Email],[A_Contact],[Professional_Summary]) VALUES ('Dominic Benson','Male','consectetuer@erategettincidunt.ca',939146150,'felis ullamcorper viverra.');
INSERT [dbo].[Applicant]([A_Name],[Gender],[A_Email],[A_Contact],[Professional_Summary]) VALUES ('Montana Tyson','Female','diam.Proin@lobortisrisusIn.co.uk',19222641,'posuere');
INSERT [dbo].[Applicant]([A_Name],[Gender],[A_Email],[A_Contact],[Professional_Summary]) VALUES ('Myra Roy','Female','lacinia@tellus.com',63814040,'malesuada fringilla est.');
INSERT [dbo].[Applicant]([A_Name],[Gender],[A_Email],[A_Contact],[Professional_Summary]) VALUES ('Beau Hensley','Male','Donec.egestas.Aliquam@purusmauris.org',3578554,'cubilia Curae; Phasellus ornare. Fusce');
INSERT [dbo].[Applicant]([A_Name],[Gender],[A_Email],[A_Contact],[Professional_Summary]) VALUES ('Ray Kaufman','Male','Duis@semNullainterdum.ca',45506420,'Donec tempor, est');
INSERT [dbo].[Applicant]([A_Name],[Gender],[A_Email],[A_Contact],[Professional_Summary]) VALUES ('Malachi Welch','Female','faucibus.ut.nulla@etmagnis.co.uk',08514746,'urna. Ut tincidunt vehicula risus. Nulla');
INSERT [dbo].[Applicant]([A_Name],[Gender],[A_Email],[A_Contact],[Professional_Summary]) VALUES ('Nolan Matthew','Male','libero@auctorvelit.com',3560462,'egestas. Duis ac arcu. Nunc');
INSERT [dbo].[Applicant]([A_Name],[Gender],[A_Email],[A_Contact],[Professional_Summary]) VALUES ('Juliet Mccullough','Female','Fusce.fermentum.fermentum@vel.edu',5800384,'felis eget varius ultrices, mauris');
INSERT [dbo].[Applicant]([A_Name],[Gender],[A_Email],[A_Contact],[Professional_Summary]) VALUES ('Jamalia Knowles','Female','Integer@Duisrisus.edu',637146,'Sed eu eros.');
INSERT [dbo].[Applicant]([A_Name],[Gender],[A_Email],[A_Contact],[Professional_Summary]) VALUES ('Cheyenne Logan','Male','faucibus.orci@turpisIncondimentum.ca',0086584,'sit amet lorem semper auctor. Mauris');
INSERT [dbo].[Applicant]([A_Name],[Gender],[A_Email],[A_Contact],[Professional_Summary]) VALUES ('Joseph Cervantes','Male','commodo@felispurus.net',970807,'auctor odio');
INSERT [dbo].[Applicant]([A_Name],[Gender],[A_Email],[A_Contact],[Professional_Summary]) VALUES ('Gloria Curry','Female','molestie@eu.edu',4227383,'et netus et malesuada fames ac');
INSERT [dbo].[Applicant]([A_Name],[Gender],[A_Email],[A_Contact],[Professional_Summary]) VALUES ('Philip Rose','Male','nunc@nislelementumpurus.ca',415044,'Vivamus molestie dapibus ligula.');
SET IDENTITY_INSERT [dbo].[Applicant] OFF

INSERT [dbo].[Company]([C_Name],[C_Addresse],[C_Email],[C_Contact]) VALUES ('Fermentum Convallis Ligula Limited','336-702 Praesent Ave','Donec.porttitor@quam.edu',415678);
INSERT [dbo].[Company]([C_Name],[C_Addresse],[C_Email],[C_Contact]) VALUES ('Scelerisque Neque Nullam Limited','Ap #829-9519 Sit Ave','mauris.erat@eudui.co.uk',415878);
INSERT [dbo].[Company]([C_Name],[C_Addresse],[C_Email],[C_Contact]) VALUES ('Sed Est PC','7133 Diam. Street','id.nunc.interdum@nonbibendum.com',4113529);
INSERT [dbo].[Company]([C_Name],[C_Addresse],[C_Email],[C_Contact]) VALUES ('Enim LLC','8707 Erat Street','arcu.Curabitur@nibhDonec.ca',5289929);
INSERT [dbo].[Company]([C_Name],[C_Addresse],[C_Email],[C_Contact]) VALUES ('Sed Incorporated','P.O. Box 824, 6923Dolor. Road','lobortis.quam@pedesagittis.co.uk',456465);
INSERT [dbo].[Company]([C_Name],[C_Addresse],[C_Email],[C_Contact]) VALUES ('Faucibus Leo In Consulting','P.O. Box 811, 7507 Lectus St.','felis.adipiscing.fringilla@penatibus.ca',6546556);
INSERT [dbo].[Company]([C_Name],[C_Addresse],[C_Email],[C_Contact]) VALUES ('Imperdiet Nec Company','139-153 Arcu St.','adipiscing@pedeCum.co.uk',65465465);
INSERT [dbo].[Company]([C_Name],[C_Addresse],[C_Email],[C_Contact]) VALUES ('Quis Arcu LLP','412-3622 Ultrices Avenue','semper.dui@lectusjustoeu.ca',65456654);
INSERT [dbo].[Company]([C_Name],[C_Addresse],[C_Email],[C_Contact]) VALUES ('Vel Arcu Curabitur Incorporated','Ap #678-7992 Felis Rd.','eleifend.egestas.Sed@purusDuis.org',564554);
INSERT [dbo].[Company]([C_Name],[C_Addresse],[C_Email],[C_Contact]) VALUES ('Ipsum Incorporated','P.O. Box 639, 2482 Enim St.','mus.Aenean.eget@Aliquamrutrum.com',554546);
INSERT [dbo].[Company]([C_Name],[C_Addresse],[C_Email],[C_Contact]) VALUES ('Sed Congue Foundation','794-7145 Aenean Street','metus@lorem.com',654456);
INSERT [dbo].[Company]([C_Name],[C_Addresse],[C_Email],[C_Contact]) VALUES ('Magna Cras LLC','P.O. Box 534, 3775 Tempor Ave','molestie.Sed.id@orciluctuset.com',65654654);
INSERT [dbo].[Company]([C_Name],[C_Addresse],[C_Email],[C_Contact]) VALUES ('Fringilla Porttitor Industries','9762 Nunc Avenue','mi.felis.adipiscing@est.net',654656);
INSERT [dbo].[Company]([C_Name],[C_Addresse],[C_Email],[C_Contact]) VALUES ('Pede Et Associates','P.O. Box 682, 7731 Blandit Ave','non.nisi@nullamagnamalesuada.net',897989);
SET IDENTITY_INSERT [dbo].[Company] OFF
SET ansi_warnings OFF
GO

INSERT [dbo].[Job]([Job_Title],[Job_Description],[Category_ID],[Location_ID],[Company_ID],[Job_Type],[Job_Salary],[Posting_Date]) VALUES ('Advertising Sales Agents','senectus et netus et malesuada',1,1,1,'Worker',450,'2020-04-05');
INSERT [dbo].[Job]([Job_Title],[Job_Description],[Category_ID],[Location_ID],[Company_ID],[Job_Type],[Job_Salary],[Posting_Date]) VALUES ('Architectural and Engineering Managers','aliquam eros turpis non enim',2,2,3,'Manager',375,'2020-01-05');
INSERT [dbo].[Job]([Job_Title],[Job_Description],[Category_ID],[Location_ID],[Company_ID],[Job_Type],[Job_Salary],[Posting_Date]) VALUES ('Building Cleaning Workers','consequat auctor, nunc nulla vulputate',3,3,5,'Worker',650,'2020-01-05');
INSERT [dbo].[Job]([Job_Title],[Job_Description],[Category_ID],[Location_ID],[Company_ID],[Job_Type],[Job_Salary],[Posting_Date]) VALUES ('Computer Programmers','Proin eget odio. Aliquam vulputate',4,4, 4,'Worker',425,'2020-01-05');
INSERT [dbo].[Job]([Job_Title],[Job_Description],[Category_ID],[Location_ID],[Company_ID],[Job_Type],[Job_Salary],[Posting_Date]) VALUES ('Computer Scientists and Database Administrators','in molestie tortor nibh sit',5,5,8,'Manager',380,'2020-01-05');
INSERT [dbo].[Job]([Job_Title],[Job_Description],[Category_ID],[Location_ID],[Company_ID],[Job_Type],[Job_Salary],[Posting_Date]) VALUES ('Economists','id nunc interdum feugiat. Sed',6,6,2,'Worker',550,'2020-01-05');
INSERT [dbo].[Job]([Job_Title],[Job_Description],[Category_ID],[Location_ID],[Company_ID],[Job_Type],[Job_Salary],[Posting_Date]) VALUES ('Electrical and Electronics Engineers','sociis natoque penatibus et magnis',7,7,13,'Worker',457,'2020-01-05');
INSERT [dbo].[Job]([Job_Title],[Job_Description],[Category_ID],[Location_ID],[Company_ID],[Job_Type],[Job_Salary],[Posting_Date]) VALUES ('Financial Analysts','tincidunt adipiscing. Mauris molestie pharetra',8,8,3,'Worker',740,'2020-01-05');
INSERT [dbo].[Job]([Job_Title],[Job_Description],[Category_ID],[Location_ID],[Company_ID],[Job_Type],[Job_Salary],[Posting_Date]) VALUES ('Food Service Managers','malesuada vel, venenatis vel, faucibus',9,9,3,'Manager',950,'2020-11-25');
INSERT [dbo].[Job]([Job_Title],[Job_Description],[Category_ID],[Location_ID],[Company_ID],[Job_Type],[Job_Salary],[Posting_Date]) VALUES ('Graphic Designers','Aenean massa. Integer vitae nibh.',10,10,6,'Worker',498,'2020-01-05');
INSERT [dbo].[Job]([Job_Title],[Job_Description],[Category_ID],[Location_ID],[Company_ID],[Job_Type],[Job_Salary],[Posting_Date]) VALUES ('Health and Safety Engineers','venenatis vel, faucibus id, libero.',11,11,1,'Worker',436,'2020-11-05');
INSERT [dbo].[Job]([Job_Title],[Job_Description],[Category_ID],[Location_ID],[Company_ID],[Job_Type],[Job_Salary],[Posting_Date]) VALUES ('Mechanical Engineers','dis parturient montes, nascetur ridiculus',12,12,9,'Worker',399,'2020-04-15');
INSERT [dbo].[Job]([Job_Title],[Job_Description],[Category_ID],[Location_ID],[Company_ID],[Job_Type],[Job_Salary],[Posting_Date]) VALUES ('Pharmacists','primis in faucibus orci luctus',13,13,7,'Worker',347,'2020-01-19');
INSERT [dbo].[Job]([Job_Title],[Job_Description],[Category_ID],[Location_ID],[Company_ID],[Job_Type],[Job_Salary],[Posting_Date]) VALUES ('Software Developers','tincidunt adipiscing. Mauris molestie pharetra',14,14,7,'Worker',690,'2020-03-05');
SET IDENTITY_INSERT [dbo].[Job] OFF

INSERT [dbo].[ApplicationDetails]([Job_ID],[Applicant_ID]) VALUES (1,1);
INSERT [dbo].[ApplicationDetails]([Job_ID],[Applicant_ID]) VALUES (2,1);
INSERT [dbo].[ApplicationDetails]([Job_ID],[Applicant_ID]) VALUES (3,2);
INSERT [dbo].[ApplicationDetails]([Job_ID],[Applicant_ID]) VALUES (4,4);
INSERT [dbo].[ApplicationDetails]([Job_ID],[Applicant_ID]) VALUES (5,4);
INSERT [dbo].[ApplicationDetails]([Job_ID],[Applicant_ID]) VALUES (6,3);
INSERT [dbo].[ApplicationDetails]([Job_ID],[Applicant_ID]) VALUES (7,5);
INSERT [dbo].[ApplicationDetails]([Job_ID],[Applicant_ID]) VALUES (8,8);
INSERT [dbo].[ApplicationDetails]([Job_ID],[Applicant_ID]) VALUES (9,9);
INSERT [dbo].[ApplicationDetails]([Job_ID],[Applicant_ID]) VALUES (1,7);
INSERT [dbo].[ApplicationDetails]([Job_ID],[Applicant_ID]) VALUES (11,10);
INSERT [dbo].[ApplicationDetails]([Job_ID],[Applicant_ID]) VALUES (12,14);
INSERT [dbo].[ApplicationDetails]([Job_ID],[Applicant_ID]) VALUES (13,12);
INSERT [dbo].[ApplicationDetails]([Job_ID],[Applicant_ID]) VALUES (14,9);
SET IDENTITY_INSERT [dbo].[ApplicationDetails] OFF

USE [master]
GO
ALTER DATABASE [CRUD13] SET  READ_WRITE 
GO

USE CRUD13

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

INSERT [dbo].[Perdoruesi] ([Username], [Password], [RoliID]) VALUES (N'melina.lushaku', N'123456', 1)
INSERT [dbo].[Perdoruesi] ([Username], [Password], [RoliID]) VALUES (N'elmenda.lushaj', N'246810', 2)
INSERT [dbo].[Perdoruesi] ([Username], [Password], [RoliID]) VALUES (N'kujtse.lahi', N'13579', 3)

INSERT [dbo].[Roli] ([Emertimi]) VALUES (N'Admin')
INSERT [dbo].[Roli] ([Emertimi]) VALUES (N'User Applicant')
INSERT [dbo].[Roli] ([Emertimi]) VALUES (N'User Employer')


ALTER TABLE [dbo].[Perdoruesi]  WITH CHECK ADD  CONSTRAINT [FK_Perdoruesi_Roli] FOREIGN KEY([RoliID])
REFERENCES [dbo].[Roli] ([ID])
GO
ALTER TABLE [dbo].[Perdoruesi] CHECK CONSTRAINT [FK_Perdoruesi_Roli]