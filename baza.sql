create database JavaMovies
go
use JavaMovies
go
create table Actor(
	IDActor int primary key identity(0,1) not null,
	FirstName nvarchar(50),
	LastName nvarchar(50)
)
go
create table Director(
	IDDirector int primary key identity(0,1) not null,
	FirstName nvarchar(50),
	LastName nvarchar(50)
)
go
create table Movie(
	IDMovie int primary key identity(0,1) not null,
	Title nvarchar(100),
	Plot nvarchar(max),
	DirectorID int foreign key references Director(IDDirector),
	ImgPath varchar(max)
)
go
create table MovieActor(
	IDMovieActor int primary key identity(0,1) not null,
	MovieID int foreign key references Movie(IDMovie),
	ActorID int foreign key references Actor(IDActor)
)
go
create table [User](
	IDUser int primary key identity(0,1) not null,
	Username nvarchar(50),
	[Password] nvarchar(50),
	IsAdmin bit
)
go
insert into [User](Username, [Password], IsAdmin)
values('Admin', 'Admin', 1)
go
create proc selectUser
@IDUser int
as 
begin 
	select * from [User] where IDUser = @IDUser		
end
go
create proc selectUsers
as 
begin 
	select * from [User]
end
go
create proc createUser
@Username nvarchar(50),
@Password nvarchar(50),
@IsAdmin bit
as 
begin 
	insert into [User] (Username, [Password], IsAdmin)
	values(@Username, @Password, @IsAdmin)
end
go
--ALTER TABLE Movie
--alter column Plot nvarchar(max);
--ADD ImgPath varchar(max);
create proc createMovieWithDirectorName
@FirstName nvarchar(50),
@LastName nvarchar(50),
@Title nvarchar(100),
@Plot nvarchar(max),
@ImgPath varchar(max)
as 
begin 

insert into Movie(Title, Plot, DirectorID, ImgPath)
values(
	@Title,
	@Plot,
	(select IDDirector 
	 from Director 
	 where FirstName like @FirstName and LastName like @LastName),
	@ImgPath)
end
go
create proc createDirector
@FirstName nvarchar(50),
@LastName nvarchar(50)
as 
begin 
insert into Director(FirstName,LastName)
values(@FirstName, @LastName)
end
go
create proc deleteAllData
as 
begin 
	delete from MovieActor
	delete from Movie
	delete from Actor
	delete from Director
end
go
create proc createActors
@FirstName nvarchar(50),
@LastName nvarchar(50)
as 
begin 
	insert into Actor(FirstName,LastName)
	values(@FirstName, @LastName)
end
go
create proc createMovieActor
@Title nvarchar(100),
@FirstName nvarchar(50),
@LastName nvarchar(50)
as 
begin 
	insert into MovieActor(MovieID, ActorID)
	values(
	   (select IDMovie from Movie where Title = @Title),
	   (select IDActor
		from Actor 
		where FirstName like @FirstName and LastName like @LastName))
end
go
create proc selectMovies
as 
begin 
	select * from Movie
end
go
create proc selectMovie
@IDMovie int
as 
begin 
	select * from Movie where IDMovie = @IDMovie
end
go
create proc selectDirectorById
@IDDirector int
as 
begin 
	select * from Director where IDDirector = @IDDirector
end
go
create proc selectMovie
@IDMovie int
as 
begin 
	select * from Movie where IDMovie = @IDMovie
end
go
create proc selectActorsByMovieId
@IDMovie int
as 
begin 
	select a.IDActor, a.FirstName, a.LastName
	from MovieActor as ma
	inner join Actor as a on a.IDActor = ma.ActorID
	where ma.MovieID = @IDMovie
	
end
go
create proc selectActors
as 
begin 
	select * from Actor
	
end
go
create proc updateMovie
@IDMovie int,
@Title nvarchar(100),
@Plot nvarchar(max),
@DirectorID int,
@ImgPath varchar(max)
as 
begin 
	update Movie
	set Title = @Title,
	Plot = @Plot,
	DirectorID = @DirectorID,
	ImgPath = @ImgPath
	where IDMovie = @IDMovie
end
go
create proc createMovie
@Title nvarchar(100),
@Plot nvarchar(max),
@DirectorID int,
@ImgPath varchar(max),
@IDMovie int output
as 
begin 
	insert into Movie(Title, Plot, DirectorID, ImgPath)
	values(@Title,@Plot,@DirectorID,@ImgPath)
	set @IDMovie = scope_identity()
end
go
create proc createMovieActorWithIds
@MovieID int,
@ActorID int
as 
begin 
	insert into MovieActor(MovieID, ActorID)
	values(@MovieID, @ActorID)
end
go
create proc deleteMovie
@MovieID int
as 
begin
	delete from MovieActor where MovieID = @MovieID
	delete from Movie where IDMovie = @MovieID
end
go
create proc deleteMovieActorsById
@MovieID int
as
begin
delete MovieActor where MovieID = @MovieID
end
go
create proc deleteMovieActor
@MovieID int,
@ActorID int
as
begin
delete MovieActor where MovieID = @MovieID and ActorID = @ActorID
end
go
create proc selectActorById
@IDActor int
as
begin
select * from Actor where IDActor = @IDActor
end
go
create proc updateActor
@IDActor int,
@FirstName nvarchar(50),
@LastName nvarchar(50)
as 
begin 
	update Actor
	set FirstName = @FirstName,
	LastName = @LastName
	where IDActor = @IDActor
end
go
create proc deleteActor
@IDActor int
as 
begin
	delete from MovieActor where ActorID = @IDActor
	delete from Actor where IDActor = @IDActor
end
go


