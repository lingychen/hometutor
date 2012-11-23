# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table syslogin (
  id                        varchar(255) not null,
  email                     varchar(255),
  passwd                    varchar(255),
  login_type                varchar(255),
  status                    varchar(255),
  create_date               timestamp,
  last_logged               timestamp,
  passwd_helper             varchar(255),
  constraint pk_syslogin primary key (id))
;

create table systemlog (
  id                        varchar(255) not null,
  syslogin_id               varchar(255),
  action                    varchar(255),
  action_date               timestamp,
  ip_address                varchar(255),
  fault_code                varchar(255),
  fault_detail              varchar(255),
  reference                 varchar(255),
  constraint pk_systemlog primary key (id))
;

create table ticket (
  id                        varchar(255) not null,
  tutor_id                  varchar(255),
  subject_id                integer,
  grade_id                  integer,
  city                      varchar(255),
  district                  varchar(255),
  zone                      varchar(255),
  contact                   varchar(255),
  phone                     varchar(255),
  email                     varchar(255),
  comments                  varchar(255),
  create_date               timestamp,
  ip_address                varchar(255),
  status                    varchar(255),
  next_dealer               varchar(255),
  close_date                timestamp,
  constraint pk_ticket primary key (id))
;

create table ticket_log (
  id                        varchar(255) not null,
  ticket_id                 varchar(255),
  tutor_id                  varchar(255),
  action                    varchar(255),
  action_date               timestamp,
  remark                    varchar(255),
  constraint pk_ticket_log primary key (id))
;

create table tutor (
  id                        varchar(255) not null,
  syslogin_id               varchar(255),
  name                      varchar(255),
  gender                    varchar(255),
  phone                     varchar(255),
  birthday                  timestamp,
  home_town                 varchar(255),
  high_school               varchar(255),
  college                   varchar(255),
  diploma                   varchar(255),
  major                     varchar(255),
  occupation                varchar(255),
  employer                  varchar(255),
  credential                varchar(255),
  workplace                 varchar(255),
  houseplace                varchar(255),
  self_assessment           varchar(255),
  subjects                  varchar(255),
  available_areas           varchar(255),
  certificates              varchar(255),
  means                     varchar(255),
  experiences               varchar(255),
  salary                    varchar(255),
  constraint pk_tutor primary key (id))
;

create sequence syslogin_seq;

create sequence systemlog_seq;

create sequence ticket_seq;

create sequence ticket_log_seq;

create sequence tutor_seq;

alter table systemlog add constraint fk_systemlog_syslogin_1 foreign key (syslogin_id) references syslogin (id);
create index ix_systemlog_syslogin_1 on systemlog (syslogin_id);
alter table ticket add constraint fk_ticket_tutor_2 foreign key (tutor_id) references tutor (id);
create index ix_ticket_tutor_2 on ticket (tutor_id);
alter table ticket_log add constraint fk_ticket_log_ticket_3 foreign key (ticket_id) references ticket (id);
create index ix_ticket_log_ticket_3 on ticket_log (ticket_id);
alter table ticket_log add constraint fk_ticket_log_tutor_4 foreign key (tutor_id) references tutor (id);
create index ix_ticket_log_tutor_4 on ticket_log (tutor_id);
alter table tutor add constraint fk_tutor_syslogin_5 foreign key (syslogin_id) references syslogin (id);
create index ix_tutor_syslogin_5 on tutor (syslogin_id);



# --- !Downs

drop table if exists syslogin cascade;

drop table if exists systemlog cascade;

drop table if exists ticket cascade;

drop table if exists ticket_log cascade;

drop table if exists tutor cascade;

drop sequence if exists syslogin_seq;

drop sequence if exists systemlog_seq;

drop sequence if exists ticket_seq;

drop sequence if exists ticket_log_seq;

drop sequence if exists tutor_seq;

