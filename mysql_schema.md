

##### work_site schema

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
   
   
   
   
   
