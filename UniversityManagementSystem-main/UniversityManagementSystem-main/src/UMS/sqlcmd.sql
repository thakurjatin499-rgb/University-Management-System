create database universitymanagement;
use universitymanagement;
create table login(username varchar(30), password varchar(30));
select *from login;
insert into login value('Admin', 'abc123');
create table faculty(Name varchar(30), FName varchar(30), EId varchar(30), Dob varchar(30), Address varchar(50),Phone varchar(30),Email varchar(30), Aadhar varchar(20),Qualification varchar(30), Department varchar(30));
select * from faculty;
create table student(Name varchar(30), FName varchar(30), Roll varchar(30), Dob varchar(30), Address varchar(50),Phone varchar(30),Email varchar(30), Aadhar varchar(20),XIImarks varchar(30),Xmarks varchar(30),Course varchar(30), Branch varchar(30));
select * from student;
create table StudentLeave(Roll varchar(20),Start varchar(20), End varchar(20), Duration varchar(20));
select * from Studentleave;
create table FacultyLeave(EId varchar(20),Start varchar(20), End varchar(20), Duration varchar(20));
select * from FacultyLeave;
create table subject (Roll varchar(20), sem varchar(20), sub1 varchar(50), sub2 varchar(50), sub3 varchar(50), sub4 varchar(50),sub5 varchar(50));
select * from subject;
create table marks (Roll varchar(20), sem varchar(20), m1 varchar(50), m2 varchar(50), m3 varchar(50), m4 varchar(50),m5 varchar(50));
select * from marks;
create table fee(course varchar(20), semester1 varchar(20), semester2 varchar(20), semester3 varchar(20), semester4 varchar(20), semester5 varchar(20), semester6 varchar(20), semester7 varchar(20), semester8 varchar(20));
insert into fee values("BTech", "49000", "43000","43000","43000","43000","43000","43000","43000");
insert into fee values("Bsc", "44000", "35000","35000","35000","35000","35000","","");
insert into fee values("BCA", "39000", "34000","34000","34000","34000","34000","","");
insert into fee values("MTech", "70000", "60000","60000","60000","","","","");
insert into fee values("MSc", "44000", "45000","45000","45000","","","","");
insert into fee values("MCA", "66000", "42000","42000","49000","","","","");
insert into fee values("Bcom", "32000", "20000","20000","20000","20000","20000","","");
insert into fee values("Mcom", "46000", "30000","30000","30000","","","","");
select * from fee;
create table FeesPaid(Roll varchar(20), Course varchar(20), Branch varchar(20), Sem varchar(20), Total varchar(20));
select * from FeesPaid;



