create database wuliu;

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
	cremake varchar(3000),
	remark1 varchar(3000),
	remark2 varchar(3000),
	remark3 varchar(3000),
	remark4 varchar(3000),
	remark5 varchar(3000)
);

create table driver(
	did int  primary key auto_increment,
	spid int,    /*   这个字段加外键   */
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
)

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
)

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
	
	
)

create table orderHandover(
	ohid int primary key auto_increment,
	hid int,/*   这个字段加外键   */
	osid int,/*   这个字段加外键   */
	remark1 varchar(3000),
	remark2 varchar(3000),
	remark3 varchar(3000),
	remark4 varchar(3000),
	remark5 varchar(3000)
)

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
)
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
)
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
	)
	
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
)
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
)

create table shippoint(
	spid int primary key auto_increment,
	spanme varchar(50),
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
)

create table users(
	usid int primary key auto_increment,
	uname varchar(50),
	upwd varchar(50),
	urealName varchar(50),
	uaddress varchar(50),
	uphone varchar(50),
	utel varchar(50),
	uemail varchar(50),
	status int,
	remark1 varchar(3000),
	remark2 varchar(3000),
	remark3 varchar(3000),
	remark4 varchar(3000),
	remark5 varchar(3000)
)