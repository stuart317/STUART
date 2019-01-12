

-- 导出 test 的数据库结构
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `test`;

-- 导出  表 test.books 结构
CREATE TABLE IF NOT EXISTS `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `title` varchar(100) NOT NULL COMMENT '书名',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `publishDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '出版日期',
  `updateDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期',
  PRIMARY KEY (`id`),
  UNIQUE KEY `title` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- 正在导出表  test.books 的数据：~9 rows (大约)
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` (`id`, `title`, `price`, `publishDate`, `updateDate`) VALUES
	(1, 'Java编程思想', 102.00, '2005-01-02 00:00:00', '2018-11-18 17:32:39'),
	(2, 'HeadFirst设计模式', 55.70, '2010-11-09 00:00:00', '2018-12-18 17:32:39'),
	(3, '第一行Android代码', 69.90, '2015-06-23 00:00:00', '2018-12-02 17:32:39'),
	(4, 'C++编程思想', 88.56, '2004-01-09 00:00:00', '2018-12-07 17:32:39'),
	(5, 'HeadFirst Java', 55.70, '2013-12-17 00:00:00', '2018-12-10 10:32:39'),
	(6, '疯狂Android', 19.50, '2014-07-31 00:00:00', '2018-11-28 17:32:39'),
	(8, 'HelloWorld', 1.00, '2018-11-08 00:00:00', '2018-12-13 09:32:39'),
	(9, '明天会更好', 20.00, '2018-11-09 00:00:00', '2018-09-18 17:32:39'),
	(10, '天下无贼', 111.00, '2018-11-09 00:00:00', '2018-12-15 11:32:39');

##测试更改