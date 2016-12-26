/*
Navicat PGSQL Data Transfer

Source Server         : localhost
Source Server Version : 90408
Source Host           : localhost:5432
Source Database       : shiro_test_db
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90408
File Encoding         : 65001

Date: 2016-08-26 09:14:33
*/


-- ----------------------------
-- Table structure for yh_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."yh_user";
CREATE TABLE "public"."yh_user" (
"id" int8 NOT NULL,
"username" varchar(100) COLLATE "default",
"password" varchar(100) COLLATE "default",
"salt" varchar(100) COLLATE "default",
"role_ids" varchar(100) COLLATE "default",
"locked" int2
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of yh_user
-- ----------------------------
INSERT INTO "public"."yh_user" VALUES ('1', 'admin', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', '1', '0');
INSERT INTO "public"."yh_user" VALUES ('2', 'normal', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', '2', '0');
INSERT INTO "public"."yh_user" VALUES ('3', 'shiro', 'f4b5d499f8993995f9a5d353bfc1da14', '1bfab134e20bb49a699f7e850efd3961', '2', '0');

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Indexes structure for table yh_user
-- ----------------------------
CREATE UNIQUE INDEX "idx_sys_user_username_copy" ON "public"."yh_user" USING btree ("username");

-- ----------------------------
-- Primary Key structure for table yh_user
-- ----------------------------
ALTER TABLE "public"."yh_user" ADD PRIMARY KEY ("id");
