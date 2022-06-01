create table admin
(
	Admin_id int auto_increment,
	Admin_name varchar(255) not null,
	Admin_pwd varchar(255) not null,
	constraint admin_admin_Id_uindex
		unique (Admin_id)
);

alter table admin
	add primary key (Admin_id);

create table announcement
(
	Announcement_id int auto_increment,
	Title varchar(255) not null,
	Announcement_date date not null,
	Content varchar(255) null,
	constraint announcement_announcement_id_uindex
		unique (Announcement_id)
);

alter table announcement
	add primary key (Announcement_id);

create table appointment
(
	aid int auto_increment,
	uid int not null,
	atime date null,
	iscancelled tinyint null,
	release_time date null,
	isreleased tinyint null,
	register_time date null,
	aspan int null,
	constraint appointment_aid_uindex
		unique (aid)
);

alter table appointment
	add primary key (aid);

create table floor
(
	fid int auto_increment,
	fname varchar(255) null,
	row int null,
	col int null,
	constraint floor_fid_uindex
		unique (fid)
);

alter table floor
	add primary key (fid);

create table seat
(
	sid int auto_increment,
	fid int not null,
	aid int null,
	seat_status int null,
	uid int not null,
	rownum int not null,
	colnum int not null,
	constraint seat_sid_uindex
		unique (sid)
);

alter table seat
	add primary key (sid);

create table tipoff
(
	tid int auto_increment,
	accused_id int not null,
	ttime date null,
	tipster_id int not null,
	sid int not null,
	remark varchar(255) null,
	constraint tipoff_tid_uindex
		unique (tid)
);

alter table tipoff
	add primary key (tid);

create table user
(
	uid int auto_increment,
	uname varchar(255) null,
	upwd varchar(255) null,
	isforbidden tinyint null,
	unlock_time date null,
	constraint user_uid_uindex
		unique (uid)
);

alter table user
	add primary key (uid);

create table violation
(
	vid int auto_increment,
	uid int not null,
	vtime date null,
	sid int not null,
	constraint violation_vid_uindex
		unique (vid)
);

alter table violation
	add primary key (vid);

