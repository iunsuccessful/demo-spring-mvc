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

Date: 2016-08-26 09:14:18
*/


-- ----------------------------
-- Table structure for yh_resource
-- ----------------------------
DROP TABLE IF EXISTS "public"."yh_resource";
CREATE TABLE "public"."yh_resource" (
"id" int8 NOT NULL,
"name" varchar(100) COLLATE "default",
"url" varchar(200) COLLATE "default",
"parent_id" int8,
"parent_ids" varchar(100) COLLATE "default",
"permission" varchar(100) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of yh_resource
-- ----------------------------
INSERT INTO "public"."yh_resource" VALUES ('1', '资源', '', '0', '0/', '');
INSERT INTO "public"."yh_resource" VALUES ('11', '组织机构管理', '/organization', '1', '0/1/', 'organization:*');
INSERT INTO "public"."yh_resource" VALUES ('12', '组织机构新增', '', '11', '0/1/11/', 'organization:create');
INSERT INTO "public"."yh_resource" VALUES ('13', '组织机构修改', '', '11', '0/1/11/', 'organization:update');
INSERT INTO "public"."yh_resource" VALUES ('14', '组织机构删除', '', '11', '0/1/11/', 'organization:delete');
INSERT INTO "public"."yh_resource" VALUES ('15', '组织机构查看', '', '11', '0/1/11/', 'organization:view');
INSERT INTO "public"."yh_resource" VALUES ('21', '用户管理', '/user', '1', '0/1/', 'user:*');
INSERT INTO "public"."yh_resource" VALUES ('22', '用户新增', '', '21', '0/1/21/', 'user:create');
INSERT INTO "public"."yh_resource" VALUES ('23', '用户修改', '', '21', '0/1/21/', 'user:update');
INSERT INTO "public"."yh_resource" VALUES ('24', '用户删除', '', '21', '0/1/21/', 'user:delete');
INSERT INTO "public"."yh_resource" VALUES ('25', '用户查看', '', '21', '0/1/21/', 'user:view');
INSERT INTO "public"."yh_resource" VALUES ('31', '资源管理', '/resource', '1', '0/1/', 'resource:*');
INSERT INTO "public"."yh_resource" VALUES ('32', '资源新增', '', '31', '0/1/31/', 'resource:create');
INSERT INTO "public"."yh_resource" VALUES ('33', '资源修改', '', '31', '0/1/31/', 'resource:update');
INSERT INTO "public"."yh_resource" VALUES ('34', '资源删除', '', '31', '0/1/31/', 'resource:delete');
INSERT INTO "public"."yh_resource" VALUES ('35', '资源查看', '', '31', '0/1/31/', 'resource:view');
INSERT INTO "public"."yh_resource" VALUES ('41', '角色管理', '/role', '1', '0/1/', 'role:*');
INSERT INTO "public"."yh_resource" VALUES ('42', '角色新增', '', '41', '0/1/41/', 'role:create');
INSERT INTO "public"."yh_resource" VALUES ('43', '角色修改', '', '41', '0/1/41/', 'role:update');
INSERT INTO "public"."yh_resource" VALUES ('44', '角色删除', '', '41', '0/1/41/', 'role:delete');
INSERT INTO "public"."yh_resource" VALUES ('45', '角色查看', '', '41', '0/1/41/', 'role:view');
INSERT INTO "public"."yh_resource" VALUES ('51', '会话管理', '/sessions', '1', '0/1/', 'session:*');

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Indexes structure for table yh_resource
-- ----------------------------
CREATE INDEX "idx_sys_resource_parent_id_copy" ON "public"."yh_resource" USING btree ("parent_id");
CREATE INDEX "idx_sys_resource_parent_ids_copy" ON "public"."yh_resource" USING btree ("parent_ids");

-- ----------------------------
-- Primary Key structure for table yh_resource
-- ----------------------------
ALTER TABLE "public"."yh_resource" ADD PRIMARY KEY ("id");
