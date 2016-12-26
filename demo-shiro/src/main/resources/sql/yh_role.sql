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

Date: 2016-08-26 09:14:25
*/


-- ----------------------------
-- Table structure for yh_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."yh_role";
CREATE TABLE "public"."yh_role" (
"id" int8 NOT NULL,
"role" varchar(100) COLLATE "default",
"description" varchar(100) COLLATE "default",
"resource_ids" varchar(100) COLLATE "default",
"available" int2
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of yh_role
-- ----------------------------
INSERT INTO "public"."yh_role" VALUES ('1', 'admin', '超级管理员', '11,21,31,41,51', '1');
INSERT INTO "public"."yh_role" VALUES ('2', 'normal', '普通用户', '21', '1');

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Indexes structure for table yh_role
-- ----------------------------
CREATE INDEX "idx_sys_role_resource_ids_copy" ON "public"."yh_role" USING btree ("resource_ids");

-- ----------------------------
-- Primary Key structure for table yh_role
-- ----------------------------
ALTER TABLE "public"."yh_role" ADD PRIMARY KEY ("id");
