create database wuliu;
use wuliu;
create table car(
	cid int primary key auto_increment,
	spid int,    /*   这个字段加外键   */
	cnumber varchar(3000),
	ctype varchar(3000),
	cbuyDay date,
	crunNum varchar(3000),
	cvolume double,
	cton double,
	cstatus int,
	cisBox int,
	cremake varchar(2000),
	remark1 varchar(2000),
	remark2 varchar(2000),
	remark3 varchar(2000),
	remark4 varchar(2000),
	remark5 varchar(2000)
);

insert into car(cid,spid,cnumber,ctype,cbuyDay,crunNum,cvolume,cton,cstatus,cisBox) values(1,1,'1001','c',now(),'1000m',20,30,0,1);
update car set remark5=1 where cid=1;
create table driver(
	did int  primary key auto_increment,
	spid int,    
	dname varchar(50),
	dnumber varchar(50),
	dphone varchar(50),
	didCard varchar(50),
	ddage int ,
	dstatus int,
	remark1 varchar(3000),
	remark2 varchar(3000),
	remark3 varchar(3000),
	remark4 varchar(3000),
	remark5 varchar(3000)
);
select * from driver;
update driver set spid=2,dname='ycs',dnumber='asd',dphone='21316549874',didCard='asdsadasd',ddage=20,dstatus=0 where did=1;
update driver set remark5=1 where did=1;

create table goods(
	gid int primary key auto_increment,
	gname varchar(50),
	gcount varchar(50),
	gprice double,
	gweight double,
	gvolume double,
	gtype varchar(50),
	gremark varchar(3000),
	remark1 varchar(3000),
	remark2 varchar(3000),
	remark3 varchar(3000),
	remark4 varchar(3000),
	remark5 varchar(3000)
);
update goods set remark5=1 where gid=1;

select * from goods;
insert into goods(gname,gcount,gprice,gweight,gvolume,gtype,gremark,remark1,remark2,remark3,remark4,remark5) values('food','1000',1000,200,30,'a','null','null','null','null','null','null');

create table handover(
	hid int primary key auto_increment,
	cid int ,/*   这个字段加外键   */
	did  int,/*   这个字段加外键   */
	osid int,/*   这个字段加外键   */
	rid int,/*   这个字段加外键   */
	hfromSpname varchar(50),
	htoSpname varchar(50),
	hstartTime date,
	hendTime date,
	hstatus int,
	hremark varchar(3000),
	remark1 varchar(3000),
	remark2 varchar(3000),
	remark3 varchar(3000),
	remark4 varchar(3000),
	remark5 varchar(3000)
);
select * from handover;
insert into handover(cid,did,osid,rid,hfromSpname,htoSpname,hstartTime,hendTime,hstatus) values(1,1,1,1,'cs','sh',now(),now(),0);
update handover set remark5=1 where hid=1;



create table orderHandover(
	ohid int primary key auto_increment,
	hid int,/*   这个字段加外键   */
	osid int,/*   这个字段加外键   */
	remark1 varchar(3000),
	remark2 varchar(3000),
	remark3 varchar(3000),
	remark4 varchar(3000),
	remark5 varchar(3000)
);

create table order1(
	osid int primary key auto_increment,
	usid int,/*   这个字段加外键   */
	spid int,/*   这个字段加外键   */
	osendName varchar(50),
	osendTel varchar(50),
	osendAddress varchar(50),
	orecName varchar(50),
	orecTel varchar(50),
	orecAddress varchar(50),
	orecCode varchar(50),
	orecPhone varchar(50),
	otime date,
	oprice double,
	oinsurePrice double,
	otype int,
	ostatus int,
	ostartTime date,
	oendTime date,
	orecSpname varchar(50),
	oremark varchar(3000),
	remark1 varchar(3000),
	remark2 varchar(3000),
	remark3 varchar(3000),
	remark4 varchar(3000),
	remark5 varchar(3000)
);
insert into order1(usid,spid,osendName,osendTel,osendAddress,orecCode,orecPhone,otime,oprice,oinsurePrice,otype,ostatus,ostartTime,oendTime,orecSpname)
values(1,1,'asdasd','asdad','dgfdg','asdad','16354654',now(),100,200,1,1,now(),now(),'asdsad');
select * from order1;
update order1 set remark5=1 where osid=1;
create table orderInfo(
	oiid int primary key auto_increment,
	osid int,/*   这个字段加外键   */
	gname varchar(50),
	gprice double,
	gcount int,
	remark1 varchar(3000),
	remark2 varchar(3000),
	remark3 varchar(3000),
	remark4 varchar(3000),
	remark5 varchar(3000)
);
create table price(
	pid int primary key auto_increment,
	pfrom varchar(50),
	pto varchar(50),
	pfirstwei double,
	prestwei double,
	pfirstvol double,
	prestvol double,
	pretime varchar(50),
	remark1 varchar(3000),
	remark2 varchar(3000),
	remark3 varchar(3000),
	remark4 varchar(3000),
	remark5 varchar(3000)
	);
	
create table proxy(
	prid int primary key auto_increment,
	prname varchar(50),
	prtime varchar(50),
	prprice double,
	spid int,/*   这个字段加外键   */
	prremark varchar(3000),
	remark1 varchar(3000),
	remark2 varchar(3000),
	remark3 varchar(3000),
	remark4 varchar(3000),
	remark5 varchar(3000)
);
/*
create table role(
	roleid int primary key auto_increment,
	rolename varchar(50),
	renabled int,
	remark1 varchar(3000),
	remark2 varchar(3000),
	remark3 varchar(3000),
	remark4 varchar(3000),
	remark5 varchar(3000)
)*/

create table route(
	rid int primary key auto_increment,
	rname varchar(50),
	rvia varchar(50),
	remark1 varchar(3000),
	remark2 varchar(3000),
	remark3 varchar(3000),
	remark4 varchar(3000),
	remark5 varchar(3000)
);

select * from route;
--配送点
create table shippoint(
	spid int primary key auto_increment,
	spname varchar(50),
	spperson varchar(50),
	sptel varchar(50),
	spemail varchar(50),
	spaddress varchar(50),
	spType int,
	sppersonTel varchar(50),
	spfax varchar(50),
	sparea varchar(50),
	spremark varchar(50),
	remark1 varchar(3000),
	remark2 varchar(3000),
	remark3 varchar(3000),
	remark4 varchar(3000),
	remark5 varchar(3000)
);

insert into shippoint values(1,'hgpsd','tome','56161','64648@qq.com','tianjing',1,'5641681486','4648648','16515','dasd',null,null,null,null,null);
select * from shippoint;
create table users(
	usid int primary key auto_increment,
	uname varchar(50),
	upwd varchar(50),
	urealName varchar(50),
	uaddress varchar(50),
	uphone varchar(50),
	utel varchar(50),
	uemail varchar(50),
	status int, /* 0代表用户封禁，删除状态  1.代表管理员权限,2.代表普通用户权限 */
	remark1 varchar(3000),
	remark2 varchar(3000),
	remark3 varchar(3000),
	remark4 varchar(3000), 
	remark5 varchar(3000)
);
select * from users;
update users set upwd='DF2107E57ED58419' where uname='yc';
update users set remark4=2;
insert into users values(2,'yc','aa','jack','beijing','4165468489','489498749','56448@qq.com','2','null','null','null','null','null');

create table log(
	lid int primary key auto_increment,
	lusid int,
	luname varchar(50),
	ldate date, 
	loperation varchar(50)
);
select * from log;
drop table log;
delete from log;

select order1.*,route.*,orderinfo.* from (select * from order1 limit 0,5) order1 left join orderinfo on order1.osid=orderinfo.osid left join route on order1.remark1=route.rid
		
select * from order1 where otime='2018-01-29'	



select order1.osid, users.usid as uusid,uname, spid, osendName, osendTel, osendAddress, orecName, orecTel, orecAddress, orecCode, orecPhone, otime, oprice, oinsurePrice, otype, ostatus, ostartTime, oendTime, orecSpname, oremark, order1.remark1, order1.remark2, order1.remark3, order1.remark4, order1.remark5, oiid,gname,gprice,gcount,orderinfo.remark1 as oifremark1,orderinfo.remark2 as oifremark2,orderinfo.remark3 as oifremark3,orderinfo.remark4 as oifremark4,orderinfo.remark5 as oifremark5 from order1 left join users on order1.usid=users.usid left join orderinfo on order1.osid=orderinfo.osid  where order1.osid = 34 

