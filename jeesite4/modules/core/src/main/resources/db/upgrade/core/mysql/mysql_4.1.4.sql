
-- 删除sys_file_entity表的file_md5唯一索引
ALTER TABLE `${_prefix}sys_file_entity` 
DROP INDEX `file_md5`,
ADD INDEX `file_md5`(`file_md5`);

-- 增加文件信息字段（可存储图片大小）
ALTER TABLE `${_prefix}sys_file_entity` 
ADD COLUMN `file_meta` varchar(255) NULL COMMENT '文件信息(JSON格式)' AFTER `file_size`;

-- 集群的实例名字  
ALTER TABLE `${_prefix}sys_job` 
ADD COLUMN `instance_name` varchar(64) NOT NULL DEFAULT 'JeeSiteScheduler' COMMENT '集群的实例名字' AFTER `concurrent`;

-- 内部消息菜单
INSERT INTO `${_prefix}sys_menu`(`menu_code`, `parent_code`, `parent_codes`, `tree_sort`, `tree_sorts`, `tree_leaf`, `tree_level`, `tree_names`, `menu_name`, `menu_type`, `menu_href`, `menu_target`, `menu_icon`, `menu_color`, `permission`, `weight`, `is_show`, `sys_code`, `module_codes`, `status`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `extend_s1`, `extend_s2`, `extend_s3`, `extend_s4`, `extend_s5`, `extend_s6`, `extend_s7`, `extend_s8`, `extend_i1`, `extend_i2`, `extend_i3`, `extend_i4`, `extend_f1`, `extend_f2`, `extend_f3`, `extend_f4`, `extend_d1`, `extend_d2`, `extend_d3`, `extend_d4`)
VALUES ('1105443204287991808', '0', '0,', 9030, '0000009030,', '1', 0, '站内消息', '站内消息', '1', '/msg/msgInner/list', '', 'icon-speech', '', 'msg:msgInner', 40, '1', 'default', 'core', '0', 'system', now(), 'system', now(), '', '', '', '', '', '', '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- 内部消息新增字典数据
INSERT INTO `${_prefix}sys_dict_type`(`id`, `dict_name`, `dict_type`, `is_sys`, `status`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`)
VALUES ('1105440848414543872', '消息状态', 'msg_inner_msg_status', '0', '0', 'system', now(), 'system', now(), '');
INSERT INTO `${_prefix}sys_dict_data`(`dict_code`, `parent_code`, `parent_codes`, `tree_sort`, `tree_sorts`, `tree_leaf`, `tree_level`, `tree_names`, `dict_label`, `dict_value`, `dict_type`, `is_sys`, `description`, `css_style`, `css_class`, `status`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `corp_code`, `corp_name`, `extend_s1`, `extend_s2`, `extend_s3`, `extend_s4`, `extend_s5`, `extend_s6`, `extend_s7`, `extend_s8`, `extend_i1`, `extend_i2`, `extend_i3`, `extend_i4`, `extend_f1`, `extend_f2`, `extend_f3`, `extend_f4`, `extend_d1`, `extend_d2`, `extend_d3`, `extend_d4`)
VALUES ('1106135527342673920', '0', '0,', 20, '0000000020,', '1', 0, '全部', '全部', '0', 'msg_inner_receiver_type', '1', '', '', '', '0', 'system', now(), 'system', now(), '', '0', 'JeeSite', '', '', '', '', '', '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- 取消内部消息部分字段必填选项
ALTER TABLE `${_prefix}sys_msg_inner` 
MODIFY COLUMN `receive_codes` text NULL COMMENT '接受者字符串' AFTER `receive_type`,
MODIFY COLUMN `receive_names` text NULL COMMENT '接受者名称字符串' AFTER `receive_codes`,
MODIFY COLUMN `send_user_code` varchar(64) NULL COMMENT '发送者用户编码' AFTER `receive_names`,
MODIFY COLUMN `send_user_name` varchar(100) NULL COMMENT '发送者用户姓名' AFTER `send_user_code`,
MODIFY COLUMN `send_date` datetime(0) NULL COMMENT '发送时间' AFTER `send_user_name`,
MODIFY COLUMN `notify_types` varchar(100) NULL COMMENT '通知类型（PC APP 短信 邮件 微信）多选' AFTER `is_attac`;
