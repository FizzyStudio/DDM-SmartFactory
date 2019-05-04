# mysql schema 

- work_site schema
- work_procedure schema
- procedure_group schema

---
### work_site schema

    CREATE TABLE `work_site` (
      `site_id` int(64) unsigned NOT NULL AUTO_INCREMENT,
      `procedure_id` int(64) NOT NULL,
      `site_index` int(64) unsigned NOT NULL,
      `site_name` varchar(64) NOT NULL,
      `site_property` int(32) unsigned DEFAULT '0',
      `site_status` int(16) unsigned DEFAULT '0' COMMENT '表示当前工位的状态    idle:00,busy:01',
      `site_desc` varchar(256) DEFAULT NULL,
      `create_tine` datetime DEFAULT CURRENT_TIMESTAMP,
      `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
      `extern1` varchar(64) DEFAULT NULL,
      `extern2` varchar(64) DEFAULT NULL,
      PRIMARY KEY (`site_id`),
      UNIQUE KEY `site_id_UNIQUE` (`site_id`),
      UNIQUE KEY `procedure_site_index_unique` (`procedure_id`,`site_index`)
    ) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


    - site_id
       * 工位的ID，唯一，自增
    - procedure_id
       * 工序的ID，当前工位隶属于哪个工序
    - site_index
       * 一个工序可能配置多个工位，表示当前工位在所属的工序下的索引号
    - site_name
       * 工位的中文名：一般等于工序名+索引号
    - site_status
       * 工位当前的状态
          + idle：00,所有正在进行的生产计划中没有用到当前工位
          + busy：01,正在进行的生产计划中有使用当前工位
          + suspend：正在进行的生产计划中有使用当前工位，但由于某种原因暂停中（暂时不考虑）
          + not configured：当前工位没有配置好，不能使用（暂时不考虑）
    - site_desc
       * 工位工作内容的描述
    - create_time
       * 工位的创建时间          
    - update_time
       * 工位的更新时间
    
    -  v0.1版本说明
       *  支持并发处理：同一时间段内隶属于多个生产计划的组装品在同一工位上处理
          + 方案：第一道工序区分组装品的生产计划、工序组等信息，记录到数据库
       *  新建生产计划（工序组）时，默认只指定用哪些工序，不具体到工序下的工位，用到的工序下的默认工位都视为参与该生产计划（工序组）
       *  支持两种工位状态：idle和busy
          + 方案1：生产计划一旦进入ongoing状态，相关的工位即进入busy状态
          + 方案2：工位在最近的一段时间内有工作即为busy
       *  不考虑生产和检测设备的绑定和解绑功能
       *  不考虑操作人员的绑定和解绑功能
       *  不考虑工位的暂停、恢复等功能
   
   ---
   ### work_procedure schema
   
    CREATE TABLE `work_procedure` (
      `procedure_id` int(64) unsigned NOT NULL COMMENT '工序ID，唯一，每种工序只占用1bit位，不同工序占用的bit位不同',
      `procedure_name` varchar(64) NOT NULL COMMENT '工序名',
      `procedure_desc` varchar(256) DEFAULT NULL COMMENT '工序的描述',
      `procedure_property` int(32) unsigned NOT NULL DEFAULT '0' COMMENT '描述工序的属性',
      `procedure_status` int(16) unsigned NOT NULL DEFAULT '0' COMMENT '描述工序当前的状态',
      `work_site_count` int(8) unsigned NOT NULL DEFAULT '0',
      `procedure_table` varchar(64) NOT NULL COMMENT '工序对应的表名',
      `procedure_paras` varchar(2048) DEFAULT NULL,
      `procedure_help` varchar(2048) DEFAULT NULL,
      `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
      `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
      `extern1` varchar(64) DEFAULT NULL,
      `extern2` varchar(64) DEFAULT NULL,
      PRIMARY KEY (`procedure_id`),
      UNIQUE KEY `id_UNIQUE` (`procedure_id`),
      KEY `name_index` (`procedure_name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


    - procedure_id
       * 工序ID，唯一，每个procedure只占用1bit位，如0x00000001,0x00000002,0x00000040
    - procedure_name
       * 工序名，用于对外显示
    - procedure_desc
       * 工序的描述
    - procedure_property
       * 描述工序的属性
          + 该工序是否是头工序？00:不是；01:可以是也可以不是；10:必须是
          + 该工序是否是尾工序？00:不是；01:可以是也可以不是；10:必须是
          + 该工序是否是抽检工序？00:不是；01:可以是也可以不是；10:必须是
          + 该工序需要扫码次数？0,1,2...
          + 是否支持多生产计划同时处理？
          + 是否支持暂停和恢复功能？
    - procedure_status
       * 描述工序当前的状态
          + idle：所有正在进行的生产计划都没有用到当前工序（v0.1支持）
          + busy：正在进行的生产计划中有用到当前工序（v0.1支持）
          + suspend：正在进行的生产计划中有用到当前工序，但由于某种原因暂停中（v0.1暂时不考虑）
          + not configured：当前工序没有配置好，不能使用（v0.1暂时不考虑）
    - work_site_count
       * 当前工序包含的工位数
    - procedure_table
       * 工序对应的记录表
    - procedure_help
       * 工序指导说明链接
    - create_time
       * 工序的创建时间      
    - update_time
       * 工序的更新时间
   
    -  v0.1版本说明
       *  支持并发处理：同一时间段内隶属于多个生产计划的组装品在同一工序中处理
       *  新建生产计划（工序组）时，默认只指定用到哪些工序，不具体到工序下的工位，用到的工序下的默认工位都视为参与该生产计划（工序组）
       *  支持两种工序状态：idle和busy，不考虑其他状态
       *  不考虑工序的暂停和恢复等功能
       *  不考虑抽检工序
   
   ---
   ### procedure_group schema
   
    CREATE TABLE `procedure_group` (
      `group_id` int(64) unsigned NOT NULL AUTO_INCREMENT,
      `group_name` varchar(64) NOT NULL,
      `product_id` varchar(64) NOT NULL,
      `group_tag` varchar(64) NOT NULL,
      `group_bitmap` int(64) unsigned NOT NULL,
      `group_sequence` varchar(2048) NOT NULL,
      `group_status` int(16) unsigned DEFAULT '0',
      `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
      `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
      `extern1` varchar(64) DEFAULT NULL,
      `extern2` varchar(64) DEFAULT NULL,
      PRIMARY KEY (`group_id`),
      UNIQUE KEY `group_id_UNIQUE` (`group_id`),
      KEY `group_name_index` (`group_name`),
      KEY `group_tag_index` (`group_tag`) /*!80000 INVISIBLE */,
      KEY `product_id_index` (`product_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

    - group_id
       * 工序组ID，唯一
    - group_name
       * 工序组名称，对外显示
    - product_id
       * 关联的产品类型ID
    - group_tag
       * 工序组历史版本标签，在原有工序组基础上的修改，存为新的工序组（group_id不同），但group_tag相同
    - procedure_bitmap
       * 所有用到的工序ID“与”运算的结果
    - procedure_sequence
       * json格式存储所有用到的工序ID的顺序
       * {total:10, 1:c, 2:b, 3:e, 4:a, ...}
    - group_status
       * 工序组当前的状态
          + 是否有生产计划关联了当前工序组？
          + 该工序组处于激活状态或删除状态？
          + 该工序组是否是最新版本？
    - create_time
       * 工序组的创建时间
    - update_time
       * 工序组的更新时间
       

       
