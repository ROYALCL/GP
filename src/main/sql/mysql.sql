/*
Navicat MySQL Data Transfer
Source Host           : localhost
Source Database       : cm
Target Server Type    : MYSQL
*/
# 使用数据库cm
USE cm;
# 关闭外键约束
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS dept;
CREATE TABLE dept (
  id          INT(11)     NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name        VARCHAR(50) NOT NULL,
  description VARCHAR(300)                     DEFAULT NULL
)
  ENGINE = InnoDB
  CHARSET = utf8;
INSERT INTO dept (id, name, description)
VALUES (NULL, '技术部', '技术部'), (NULL, '运营部', '运营部'), (NULL, '财务部', '财务部'), (NULL, '总公办', '总公办'), (NULL, '市场部', '市场部'),
  (NULL, '教学部', '教学部');

DROP TABLE IF EXISTS job;
CREATE TABLE job (
  id          INT(11)     NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name        VARCHAR(50) NOT NULL,
  description VARCHAR(300)                     DEFAULT NULL
)
  ENGINE = InnoDB
  CHARSET = utf8;
INSERT INTO job (id, name, description)
VALUES (NULL, '职员', '职员'), (NULL, 'Java开发工程师', 'Java开发工程师'), (NULL, 'Java中级开发工程师', 'Java中级开发工程师'),
  (NULL, 'Java高级开发工程师', 'Java高级开发工程师'), (NULL, '系统管理员', '系统管理员'), (NULL, '架构师', '架构师'), (NULL, '主管', '主管'),
  (NULL, '经理', '经理'), (NULL, '总经理', '总经理');
#创建表user
DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id          INT(11)      NOT NULL AUTO_INCREMENT PRIMARY KEY
  COMMENT '登陆ID',
  role_id      INT(11) NOT NULL ,
  name        VARCHAR(50)  NOT NULL
  COMMENT '用户姓名',
  password    VARCHAR(20)  NOT NULL
  COMMENT '用户密码',
  nick_name   VARCHAR(100) NOT NULL
  COMMENT '昵称',
  sex         CHAR(1)      NOT NULL DEFAULT 'n'
  COMMENT '性别', #m/f/n
  email       VARCHAR(50) COMMENT '邮箱',
  used        CHAR(1)      NOT NULL DEFAULT 'n'
  COMMENT '账号是否可用', #Y/N
  create_time DATETIME     NOT NULL,
  CONSTRAINT fk_role_id FOREIGN KEY (role_id) REFERENCES role (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
INSERT INTO user(id,role_id,name,password,nick_name,sex,email,used,create_time) VALUES (NULL,1, 'admin', '000000', 'admin', 'M', '0000@163.com', 'T', now());
INSERT INTO user (id,role_id,name,password,nick_name,sex,email,used,create_time) VALUES (NULL, 2,'test', '000000', 'test', 'F', '1111@163.com', 'F', now());

DROP TABLE IF EXISTS employee;
CREATE TABLE employee (
  id          INT(11)     NOT NULL AUTO_INCREMENT PRIMARY KEY,
  dept_id     INT(11)     NOT NULL,
  job_id      INT(11)     NOT NULL,
  name        VARCHAR(50) NOT NULL,
  card_id     VARCHAR(18) NOT NULL,
  address     VARCHAR(50) NOT NULL,
  post_code   VARCHAR(50)          DEFAULT NULL,
  tel         VARCHAR(16)          DEFAULT NULL,
  phone       VARCHAR(11) NOT NULL,
  qq          VARCHAR(15)          DEFAULT NULL,
  email       VARCHAR(50) NOT NULL,
  sex         CHAR(1)     NOT NULL DEFAULT '1',
  birthday    DATETIME             DEFAULT NULL,
  education   VARCHAR(10)          DEFAULT NULL,
  hobby       VARCHAR(100)         DEFAULT NULL,
  description VARCHAR(500)         DEFAULT NULL,
  create_time DATE        NOT NULL,
  KEY fk_dept_id (dept_id),
  KEY fk_job_id (job_id),
  CONSTRAINT fk_dept_id FOREIGN KEY (dept_id) REFERENCES dept (id),
  CONSTRAINT fk_job_id FOREIGN KEY (job_id) REFERENCES job (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
INSERT INTO employee (id, dept_id, job_id, name, card_id, address, post_code, tel, phone, qq, email, sex, birthday, education, hobby, description, create_time)
VALUES
  (NULL, 1, 3, '爱丽丝', '4328011988', '广州天河', '510000', '020-77777777', '13902001111', '36750066', '251425887@qq.com', 0,
   '1980-01-01', '本科', '唱歌', '四大天王', now()),
  (NULL, 2, 1, '杰克', '22623', '43234', '42427424', '42242', '4247242', '42424', '251425887@qq.com', 2, NULL, NULL, NULL,
   NULL, '2016-03-14 11:35:18'),
  (NULL, 1, 2, 'bb', '432801197711251038', '广州', '510000', '020-99999999', '13907351532', '36750064', '36750064@qq.com',
   1,  '1977-11-25',  '本科', '爬山', '无', now());

DROP TABLE IF EXISTS notice;
CREATE TABLE notice (
  id          INT(11)      NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title       VARCHAR(100) NOT NULL,
  content     TEXT         NOT NULL,
  create_time DATE         NOT NULL,
  user_id     INT(11)      NOT NULL,
  CONSTRAINT notice FOREIGN KEY (user_id) REFERENCES user (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
INSERT INTO notice(id,title,content,create_time,user_id) VALUES (NULL ,"dfkjhaksdjhfakjd","dfhkasdjhflajksd",now(),"1");
INSERT INTO notice(id,title,content,create_time,user_id) VALUES (NULL ,"dsfasdadsf","gfhdfgd",now(),"2");


DROP TABLE IF EXISTS document;
CREATE TABLE document (
  id          INT(11)      NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id     INT(11)      NOT NULL,
  title       VARCHAR(100) NOT NULL,
  filename    VARCHAR(300) NOT NULL,
  description VARCHAR(300)          DEFAULT NULL,
  create_time DATE         NOT NULL,
  CONSTRAINT document FOREIGN KEY (user_id) REFERENCES user (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS role;
CREATE TABLE role (
  id          INT(11)      NOT NULL AUTO_INCREMENT PRIMARY KEY,
  parent_id   INT(11)      NOT NULL,
  name       VARCHAR(100) NOT NULL,
  description VARCHAR(300)          DEFAULT NULL,
  create_time DATE         NOT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
INSERT INTO role(id,parent_id,name,description,create_time) VALUES (1,1,"管理员","系统管理员",now());
INSERT INTO role(id,parent_id,name,description,create_time) VALUES (2,1,"管理员2","系统管理员",now());
