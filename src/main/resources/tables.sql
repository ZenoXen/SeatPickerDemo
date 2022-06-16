create database seat CHARACTER SET utf8 COLLATE utf8_general_ci;

use seat;

create table admins
(
	Admin_id int auto_increment not null,
	Admin_name varchar(255) not null,
	Admin_pwd varchar(255) not null,
	constraint admin_admin_Id_uindex
		unique (Admin_id)
);

alter table admins
	add primary key (Admin_id);

create table announcements
(
	Announcement_id int auto_increment not null,
	Title varchar(255) not null,
	Announcement_date datetime not null,
	Content varchar(255) null,
	constraint announcement_announcement_id_uindex
		unique (Announcement_id)
);

alter table announcements
	add primary key (Announcement_id);

create table appointment_records
(
	aid int auto_increment not null,
	uid int not null,
	atime datetime not null,
	iscanceled tinyint not null,
	release_time datetime not null,
	isreleased tinyint null,
	register_time datetime null,
	aspan int null,
	constraint appointment_aid_uindex
		unique (aid)
);

alter table appointment_records
	add primary key (aid);

create table floors
(
	fid int auto_increment not null,
	fname varchar(255) not null,
	row int not null,
	col int not null,
	constraint floor_fid_uindex
		unique (fid)
);

alter table floors
	add primary key (fid);

create table seats
(
	sid int auto_increment not null,
	fid int not null,
	aid int null,
	seat_status int not null,
	uid int null,
	rownum int not null,
	colnum int not null,
	constraint seat_sid_uindex
		unique (sid)
);

alter table seats
	add primary key (sid);

create table tipoff_records
(
	tid int auto_increment not null,
	accused_id int not null,
	ttime datetime not null,
	tipster_id int not null,
	sid int not null,
	remark varchar(255) null,
	constraint tipoff_tid_uindex
		unique (tid)
);

alter table tipoff_records
	add primary key (tid);

create table users
(
	uid int auto_increment not null,
	uname varchar(255) not null,
	upwd varchar(255) not null,
	isforbidden tinyint not null,
	unlock_time datetime null,
	constraint user_uid_uindex
		unique (uid)
);

alter table users
	add primary key (uid);

create table violation_records
(
	vid int auto_increment not null,
	uid int not null,
	vtime datetime not null,
	sid int not null,
	constraint violation_vid_uindex
		unique (vid)
);

alter table violation_records
	add primary key (vid);

