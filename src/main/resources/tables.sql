create table admins
(
	Admin_id int auto_increment,
	Admin_name varchar(255) not null,
	Admin_pwd varchar(255) not null,
	constraint admin_admin_Id_uindex
		unique (Admin_id)
);

alter table admins
	add primary key (Admin_id);

create table announcements
(
	Announcement_id int auto_increment,
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
	aid int auto_increment,
	uid int not null,
	atime datetime null,
	iscanceled tinyint null,
	release_time datetime null,
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
	fid int auto_increment,
	fname varchar(255) null,
	row int null,
	col int null,
	constraint floor_fid_uindex
		unique (fid)
);

alter table floors
	add primary key (fid);

create table seats
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

alter table seats
	add primary key (sid);

create table tipoff_records
(
	tid int auto_increment,
	accused_id int not null,
	ttime datetime null,
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
	uid int auto_increment,
	uname varchar(255) null,
	upwd varchar(255) null,
	isforbidden tinyint null,
	unlock_time datetime null,
	constraint user_uid_uindex
		unique (uid)
);

alter table users
	add primary key (uid);

create table violation_records
(
	vid int auto_increment,
	uid int not null,
	vtime datetime null,
	sid int not null,
	constraint violation_vid_uindex
		unique (vid)
);

alter table violation_records
	add primary key (vid);

