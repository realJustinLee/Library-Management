-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2018-06-04 06:55:32
-- 服务器版本： 10.1.9-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- 表的结构 `send_mail`
--

CREATE TABLE `send_mail` (
  `email` varchar(64) NOT NULL,
  `book_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `send_mail`
--

INSERT INTO `send_mail` (`email`, `book_name`) VALUES
('j@j.com', '??????'),
('j@j.com', 'java????'),
('j@j.com', '??java??'),
('j@j.com', '??????????????'),
('j@j.com', '??????????????'),
('j@j.com', '??????????????'),
('j@j.com', '??????????????'),
('j@j.com', '??????????????'),
('j@j.com', '??????????????'),
('j@j.com', '??????????????'),
('j@j.com', '??????????????'),
('j@j.com', '??????????????'),
('JustinDellAdam@live.com', '??java??'),
('JustinDellAdam@live.com', 'java????'),
('z@z.com', '????????');

-- --------------------------------------------------------

--
-- 表的结构 `tbl_book`
--

CREATE TABLE `tbl_book` (
  `id` int(8) NOT NULL COMMENT '书籍号',
  `name` varchar(255) DEFAULT NULL COMMENT '书籍名称',
  `author` varchar(255) DEFAULT NULL COMMENT '作者',
  `pub` varchar(255) DEFAULT NULL COMMENT '书籍出版社',
  `edition` varchar(255) DEFAULT NULL COMMENT '书籍版次',
  `classes` varchar(255) DEFAULT NULL COMMENT '书籍分类',
  `all_num` int(10) DEFAULT NULL COMMENT '图书馆应有该书的数量',
  `remain_num` int(10) DEFAULT NULL COMMENT '剩余书籍数量',
  `description` varchar(1024) DEFAULT NULL COMMENT '书籍描述',
  `path` varchar(255) DEFAULT NULL COMMENT '书籍图片路径',
  `borrow_num` int(10) DEFAULT NULL COMMENT '书籍被借阅过的次数'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `tbl_book`
--

INSERT INTO `tbl_book` (`id`, `name`, `author`, `pub`, `edition`, `classes`, `all_num`, `remain_num`, `description`, `path`, `borrow_num`) VALUES
(9527, '翻译美学理论', '刘宓庆', '外语教学与研究出版社', '2011-3-1 ', '文学', 14, 8, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud\r\n                            exercitation.', '/statics/images/book/thumb2.gif', 23),
(9528, '医学英语入门', '姜瑾', '苏州大学出版社', '2009-11-1', '科学', 16, 9, '巴拉巴拉。。。', '/statics/images/book/thumb2.gif', 21),
(9529, '医学英语翻译与写作教程', '王燕', '重庆大学出版社', '2008-9-1', '科学', 14, 14, '巴拉巴拉。。。', '/statics/images/book/thumb1.gif', 12),
(9530, '医学英语读写译教程', '贾德江', '中南大学出版社', ' 2005-2-1', '科学', 31, 8, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud\r\n                            exercitation.', '/statics/images/book/thumb3.gif', 234),
(9531, '翻译概论', '姜倩', '上海外语教育出版社', '2008-9-1', '文学', 10, 2, '巴拉巴拉。。。', '/statics/images/book/thumb2.gif', 43),
(9532, '简明中西翻译史', '谢天振', '外语教学与研究出版社', '2013-11-1', '历史', 7, 3, '巴拉巴拉。。。', '/statics/images/book/thumb1.gif', 123),
(9533, '当代国外翻译理论导读', '谢天振', '南开大学出版社', '2008-5-1', '文学', 10, 4, '巴拉巴拉。。。', '/statics/images/book/thumb2.gif', 0),
(9534, '翻译能力培养', '舍夫纳', '上海外语教育出版社', '2012-6-1', '文学', 5, 3, '巴拉巴拉。。。', '/statics/images/book/thumb3.gif', 12),
(9535, '高级译学原典读本', '哈迪姆', '上海外语教育出版社', '2010-6-1', '文学', 20, 12, '巴拉巴拉。。。', '/statics/images/book/thumb2.gif', 2),
(9536, '莎士比亚作品选读', '姚颖', '外语教育与研究出版社', '2009-08-1', '文学', 20, 15, '巴拉巴拉。。。', '/statics/images/book/thumb3.gif', 213),
(9537, '平凡的世界', '路遥', '贵州人民出版社', '2003-2-1', '文学', 21, 3, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud\r\n                            exercitation.', '/statics/images/book/thumb2.gif', 35),
(9538, '计算机网络安全基础', '袁津生', '人民邮电出版社', '20004-6-1', '计算机', 12, 20, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud\r\n                            exercitation.', '/statics/images/book/thumb1.gif', 3),
(9539, '汇编语言程序设计', '金汉均', '武汉大学出版社', '2007-3-1', '计算机', 45, 32, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud\r\n                            exercitation.', '/statics/images/book/thumb3.gif', 2),
(9540, 'Web程序设计教程', '张念鲁', '高等教育出版社', '2011-2-1', '计算机', 9, 10, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud\r\n                            exercitation.', '/statics/images/book/thumb2.gif', 12),
(9541, '经济学原理', '菲尔', '清华大学出版社', '2003-2-1', '文学', 13, 12, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud\r\n                            exercitation.', '/statics/images/book/thumb1.gif', 23),
(9542, '马克思主义哲学', '肖兴燕', '高等教育出版社', '2014-2-1', '文学', 12, 12, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud\r\n                            exercitation.', '/statics/images/book/thumb3.gif', 43),
(9543, '操作系统教程', '孙钟秀', '清华大学出版社', '2015-1-1', '计算机', 9, 4, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud\r\n                            exercitation.', '/statics/images/book/thumb2.gif', 6),
(9544, 'C语言课程设计案例', '吴启武', '高等教育出版社', '2009-9-1', '计算机', 11, 8, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud\r\n                            exercitation.', '/statics/images/book/thumb1.gif', 54),
(9545, '医学免疫学', '张昌菊', '电子工业出版社', '2001-9-1', '科学', 14, 9, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud\r\n                            exercitation.', '/statics/images/book/thumb3.gif', 3),
(9546, 'HTML与CSS从入门到精通', '王昕', '中央编译出版社', '2004-6-1', '计算机', 12, 7, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud\r\n                            exercitation.', '/statics/images/book/thumb2.gif', 23),
(9547, '马克思列宁主义研究', '王昌英', '吉林出版集团', '2005-6-1', '文学', 14, 10, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud\r\n                            exercitation.', '/statics/images/book/thumb1.gif', 34),
(9548, '列宁时代观研究', '姚润皋', '吉林出版集团', '2014-1-1', '文学', 10, 10, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud\r\n                            exercitation.', '/statics/images/book/thumb3.gif', 43),
(9549, '海洋药物学', '王伟光', '光明日报出版社', '2004-1-1', '科学', 12, 10, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud\r\n                            exercitation.', '/statics/images/book/thumb2.gif', 34),
(9550, '本草纲目', '吴兵', '中国商业出版社', '2005-11-1', '科学', 23, 10, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud\r\n                            exercitation.', '/statics/images/book/thumb3.gif', 34),
(9551, '进化金融理论及应用', '杨招军', '光明日报出版社', '2012-2-1', '金融', 10, 10, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud\r\n                            exercitation.', '/statics/images/book/thumb2.gif', 34),
(9552, '华尔街金融真相', '陈思进', '中国商业出版社', '2011-9-1', '金融', 11, 10, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud\r\n                            exercitation.', '/statics/images/book/thumb3.gif', 43),
(9553, '商业研究方法', '刘启译', '新文艺出版社', '2015-8-1', '金融', 12, 10, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud\r\n                            exercitation.', '/statics/images/book/thumb1.gif', 34),
(9554, '战争与和平', '杨亚庚', '四川大学出版社', '2015-9-1', '文学', 9, 6, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud\r\n                            exercitation.', '/statics/images/book/thumb2.gif', 23),
(9555, '中药资源教育', '张爱玲', '中央编译出版社', '2015-2-1', '科学', 12, 7, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud\r\n                            exercitation.', '/statics/images/book/thumb3.gif', 23),
(9556, '少年维特之烦恼', '郑艳', '高等教育出版社', '2014-2-1', '文学', 13, 8, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud\r\n                            exercitation.', '/statics/images/book/thumb2.gif', 4),
(9557, '时间简史', '吴忠超', '牛津大学出版社', '2011-10-1', '科学', 18, 9, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud\r\n                            exercitation.', '/statics/images/book/thumb3.gif', 34),
(9558, '疯狂java讲义', '李刚', '电子工业出版社', '2014-9-1', '计算机', 11, 9, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud\r\n                            exercitation.', '/statics/images/book/thumb2.gif', 4),
(9559, 'java编程思想', '埃克尔', '机械工业出版', '2011-9-1', '计算机', 12, -5, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud\r\n                            exercitation.', '/statics/images/book/thumb3.gif', 4),
(9560, '黑客的代码', '拉希诺维奇', '高等教育出版社', '2014-9-1', '计算机', 10, -3, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud\r\n                            exercitation.', '/statics/images/book/thumb2.gif', 23),
(9566, '陈至成和他的一千零一的女朋友', '陈至成', '陈至成出版社;2018-08-08', NULL, '女朋友', 1001, 992, '陈至成和他的一千零一的女朋友', '/statics/images/book/thumb2.gif', 0),
(9567, '郑老师教你数据库', '郑老师', '郑老师;2018-08-08', NULL, '数据库', 10086, 10085, '郑老师', '/statics/images/book/thumb2.gif', 0);

-- --------------------------------------------------------

--
-- 表的结构 `tbl_book_copy`
--

CREATE TABLE `tbl_book_copy` (
  `id` int(8) NOT NULL COMMENT '书籍号',
  `name` varchar(255) DEFAULT NULL COMMENT '书籍名称',
  `author` varchar(255) DEFAULT NULL COMMENT '作者',
  `pub` varchar(255) DEFAULT NULL COMMENT '书籍出版社',
  `edition` varchar(255) DEFAULT NULL COMMENT '书籍版次',
  `classes` varchar(255) DEFAULT NULL COMMENT '书籍分类',
  `all_num` int(10) DEFAULT NULL COMMENT '图书馆应有该书的数量',
  `remain_num` int(10) DEFAULT NULL COMMENT '剩余书籍数量',
  `description` varchar(1024) DEFAULT NULL COMMENT '书籍描述',
  `path` varchar(255) DEFAULT NULL COMMENT '书籍图片路径',
  `borrow_num` int(10) DEFAULT NULL COMMENT '书籍被借阅过的次数'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `tbl_borrow`
--

CREATE TABLE `tbl_borrow` (
  `id` int(11) NOT NULL,
  `book_id` int(11) DEFAULT NULL COMMENT '所借书籍id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `borrow_start_time` varchar(64) DEFAULT NULL COMMENT '借书时间',
  `borrow_end_time` varchar(64) DEFAULT NULL COMMENT '预计还书时间',
  `borrow_return_time` varchar(64) DEFAULT NULL COMMENT '实际还书时间',
  `borrow_is_return` varchar(255) DEFAULT NULL COMMENT '是否已经还书'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `tbl_borrow`
--

INSERT INTO `tbl_borrow` (`id`, `book_id`, `user_id`, `borrow_start_time`, `borrow_end_time`, `borrow_return_time`, `borrow_is_return`) VALUES
(36, 9560, 15120777, '2018-05-30 00:25:15', '2018-06-03 00:25:15', '2018-05-30 00:27:34', 'true'),
(37, 9560, 15120777, '2018-05-30 00:25:16', '2018-06-03 00:25:16', '2018-05-30 00:27:34', 'true'),
(38, 9560, 15120777, '2018-05-30 00:25:16', '2018-06-03 00:25:16', '2018-05-30 00:27:34', 'true'),
(39, 9560, 15120777, '2018-05-30 00:25:17', '2018-06-03 00:25:17', '2018-05-30 00:27:34', 'true'),
(40, 9560, 15120777, '2018-05-30 00:25:17', '2018-06-03 00:25:17', '2018-05-30 00:27:34', 'true'),
(41, 9560, 15120777, '2018-05-30 00:27:15', '2018-06-03 00:27:15', '2018-05-30 00:27:34', 'true'),
(42, 9560, 15120777, '2018-05-30 00:27:17', '2018-06-03 00:27:17', '2018-05-30 00:27:34', 'true'),
(43, 9559, 15120777, '2018-05-30 00:27:20', '2018-06-03 00:27:20', '2018-06-01 08:25:36', 'true'),
(44, 9559, 15120777, '2018-05-30 00:27:21', '2018-06-03 00:27:21', '2018-06-01 08:25:36', 'true'),
(45, 9559, 15120777, '2018-05-30 00:27:21', '2018-06-03 00:27:21', '2018-06-01 08:25:36', 'true'),
(46, 9559, 15120777, '2018-05-30 00:27:22', '2018-06-03 00:27:22', '2018-06-01 08:25:36', 'true'),
(47, 9559, 15120777, '2018-05-30 00:27:23', '2018-06-03 00:27:23', '2018-06-01 08:25:36', 'true'),
(48, 9559, 15120777, '2018-05-30 00:27:23', '2018-06-03 00:27:23', '2018-06-01 08:25:36', 'true'),
(49, 9559, 15120777, '2018-05-30 00:27:24', '2018-06-03 00:27:24', '2018-06-01 08:25:36', 'true'),
(50, 9559, 15120777, '2018-05-30 00:27:24', '2018-06-03 00:27:24', '2018-06-01 08:25:36', 'true'),
(51, 9559, 15120777, '2018-05-30 00:27:25', '2018-06-03 00:27:25', '2018-06-01 08:25:36', 'true'),
(52, 9559, 15120777, '2018-05-30 00:27:26', '2018-06-03 00:27:26', '2018-06-01 08:25:36', 'true'),
(53, 9559, 15120777, '2018-05-30 00:27:26', '2018-06-03 00:27:26', '2018-06-01 08:25:36', 'true'),
(54, 9559, 15120777, '2018-05-30 00:27:27', '2018-06-03 00:27:27', '2018-06-01 08:25:36', 'true'),
(55, 9559, 15120777, '2018-05-30 00:27:27', '2018-06-03 00:27:27', '2018-06-01 08:25:36', 'true'),
(56, 9559, 15120777, '2018-05-30 00:27:28', '2018-06-03 00:27:28', '2018-06-01 08:25:36', 'true'),
(57, 9559, 15120777, '2018-05-30 00:27:29', '2018-06-03 00:27:29', '2018-06-01 08:25:36', 'true'),
(58, 9558, 14121555, '2018-05-30 00:31:11', '2018-06-03 00:31:11', '2018-05-30 00:31:16', 'true'),
(59, 9560, 15120777, '2018-05-30 00:45:11', '2018-06-03 00:45:11', '', 'false'),
(60, 9559, 15120777, '2018-05-30 00:50:18', '2018-06-03 00:50:18', '2018-06-01 08:25:36', 'true'),
(61, 9538, 15120777, '2018-05-30 00:50:32', '2018-06-03 00:50:32', '', 'false'),
(62, 9527, 15121897, '2018-06-01 00:20:23', '2018-06-05 00:20:23', '', 'false'),
(63, 9559, 15121897, '2018-06-01 00:20:27', '2018-06-05 00:20:27', '2018-06-01 00:20:36', 'true'),
(64, 9558, 15121897, '2018-06-01 00:20:29', '2018-06-05 00:20:29', '2018-06-01 00:20:37', 'true'),
(65, 9566, 15121897, '2018-06-01 00:23:53', '2018-06-05 00:23:53', '', 'false'),
(66, 9566, 15121897, '2018-06-01 00:23:54', '2018-06-05 00:23:54', '', 'false'),
(67, 9566, 15121897, '2018-06-01 00:23:54', '2018-06-05 00:23:54', '', 'false'),
(68, 9566, 15121897, '2018-06-01 00:23:54', '2018-06-05 00:23:54', '', 'false'),
(69, 9566, 15121897, '2018-06-01 00:23:55', '2018-06-05 00:23:55', '', 'false'),
(70, 9566, 15121897, '2018-06-01 00:23:55', '2018-06-05 00:23:55', '', 'false'),
(71, 9566, 15121897, '2018-06-01 00:23:55', '2018-06-05 00:23:55', '', 'false'),
(72, 9566, 15121897, '2018-06-01 00:23:55', '2018-06-05 00:23:55', '', 'false'),
(73, 9566, 15121897, '2018-06-01 00:23:55', '2018-06-05 00:23:55', '', 'false'),
(74, 9558, 15120777, '2018-06-01 08:25:19', '2018-06-05 08:25:19', '', 'false'),
(75, 9559, 15120777, '2018-06-01 08:25:27', '2018-06-05 08:25:27', '2018-06-01 08:25:36', 'true'),
(76, 9567, 15121898, '2018-06-01 08:29:50', '2018-06-05 08:29:50', '', 'false');

--
-- 触发器 `tbl_borrow`
--
DELIMITER $$
CREATE TRIGGER `borrow_email` AFTER INSERT ON `tbl_borrow` FOR EACH ROW BEGIN
	set @t_book_id = NEW.book_id;
	set @t_user_id = NEW.user_id;
    set @t_email = (select email from tbl_user where id=@t_user_id);
    set @t_book_name = (select name from tbl_book where id = @t_book_id);
    insert into send_mail
    values(@t_email,@t_book_name);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- 表的结构 `tbl_borrow_copy`
--

CREATE TABLE `tbl_borrow_copy` (
  `id` int(11) NOT NULL,
  `book_id` int(11) DEFAULT NULL COMMENT '所借书籍id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `borrow_start_time` varchar(64) DEFAULT NULL COMMENT '借书时间',
  `borrow_end_time` varchar(64) DEFAULT NULL COMMENT '预计还书时间',
  `borrow_return_time` varchar(64) DEFAULT NULL COMMENT '实际还书时间',
  `borrow_is_return` varchar(255) DEFAULT NULL COMMENT '是否已经还书'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `tbl_contact`
--

CREATE TABLE `tbl_contact` (
  `contact_id` int(11) UNSIGNED ZEROFILL NOT NULL,
  `contact_name` varchar(255) DEFAULT NULL,
  `contact_email` varchar(255) DEFAULT NULL,
  `contact_phone` varchar(24) DEFAULT NULL,
  `contact_message` varchar(1024) DEFAULT NULL,
  `contact_time` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `tbl_contact`
--

INSERT INTO `tbl_contact` (`contact_id`, `contact_name`, `contact_email`, `contact_phone`, `contact_message`, `contact_time`) VALUES
(00000000005, 'aha', 'null', 'null', 'null', '2018-02-16 12:40:22'),
(00000000006, 'aha', 'null', 'null', 'null', '2018-02-16 12:41:14'),
(00000000007, 'aha', 'null', 'null', 'null', '2018-02-16 12:41:14'),
(00000000010, '23', '321', '312', 'null', '2018-02-16 13:01:31'),
(00000000017, '再次测试', '成功吧', '成吧', '哈哈', '2018-03-10 21:23:38'),
(00000000018, 'li', 'JustinDellAdam@Live.com', '11111111111111', '111', '2018-05-30 00:03:32'),
(00000000019, 'ff', 'ff@ff.com', '12345678909', 'ffff', '2018-06-01 08:27:26');

-- --------------------------------------------------------

--
-- 表的结构 `tbl_order`
--

CREATE TABLE `tbl_order` (
  `order_id` int(11) NOT NULL,
  `order_userid` int(11) DEFAULT NULL COMMENT '用户id',
  `order_book_id` int(11) DEFAULT NULL COMMENT '书籍id',
  `order_number` varchar(255) DEFAULT NULL COMMENT '业务流水号',
  `order_time` varchar(255) DEFAULT NULL COMMENT '业务操作时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `tbl_order`
--

INSERT INTO `tbl_order` (`order_id`, `order_userid`, `order_book_id`, `order_number`, `order_time`) VALUES
(2, 14121896, 9527, '2232018031018003330', '2018-03-10 18:00:43'),
(3, 14121896, 9527, '2232018031018361890', '2018-03-10 18:36:05'),
(4, 14121896, 9541, '2232018031019411220', '2018-03-10 19:41:51'),
(5, 14121896, 9560, '2232018031019573730', '2018-03-10 19:57:09'),
(6, 14121896, 9527, '2232018031216424890', '2018-03-12 16:42:09'),
(7, 14121896, 9560, '2232018031218367120', '2018-03-12 18:36:21'),
(8, 14121896, 9530, '2232018031218458010', '2018-03-12 18:45:19'),
(9, 14122365, 9560, '2232018052922053870', '2018-05-29 22:05:51'),
(10, 14122365, 9559, '2232018052922059640', '2018-05-29 22:05:56'),
(11, 15121895, 9559, '2232018053000023100', '2018-05-30 00:02:57'),
(12, 15121895, 9558, '2232018053000031650', '2018-05-30 00:03:06'),
(13, 15121896, 9528, '2232018053000192700', '2018-05-30 00:19:35'),
(14, 15121896, 9560, '2232018053000194210', '2018-05-30 00:19:37'),
(15, 15120777, 9558, '2232018053000247450', '2018-05-30 00:24:29'),
(16, 15120777, 9559, '2232018053000249680', '2018-05-30 00:24:32'),
(17, 15120777, 9560, '2232018053000245720', '2018-05-30 00:24:43'),
(18, 15120777, 9560, '2232018053000247500', '2018-05-30 00:24:59'),
(19, 15120777, 9560, '2232018053000252320', '2018-05-30 00:25:04'),
(20, 15120777, 9560, '2232018053000256090', '2018-05-30 00:25:06'),
(21, 15120777, 9560, '223201805300025190', '2018-05-30 00:25:07'),
(22, 15120777, 9560, '2232018053000252340', '2018-05-30 00:25:07'),
(23, 15120777, 9560, '2232018053000251100', '2018-05-30 00:25:15'),
(24, 15120777, 9560, '2232018053000255570', '2018-05-30 00:25:16'),
(25, 15120777, 9560, '2232018053000258540', '2018-05-30 00:25:16'),
(26, 15120777, 9560, '2232018053000251220', '2018-05-30 00:25:17'),
(27, 15120777, 9560, '2232018053000253870', '2018-05-30 00:25:17'),
(28, 15120777, 9560, '2232018053000273430', '2018-05-30 00:27:15'),
(29, 15120777, 9560, '2232018053000277990', '2018-05-30 00:27:17'),
(30, 15120777, 9559, '223201805300027650', '2018-05-30 00:27:20'),
(31, 15120777, 9559, '223201805300027400', '2018-05-30 00:27:21'),
(32, 15120777, 9559, '2232018053000277710', '2018-05-30 00:27:21'),
(33, 15120777, 9559, '2232018053000274720', '2018-05-30 00:27:22'),
(34, 15120777, 9559, '2232018053000271020', '2018-05-30 00:27:23'),
(35, 15120777, 9559, '2232018053000277030', '2018-05-30 00:27:23'),
(36, 15120777, 9559, '2232018053000273600', '2018-05-30 00:27:24'),
(37, 15120777, 9559, '2232018053000279700', '2018-05-30 00:27:24'),
(38, 15120777, 9559, '2232018053000275810', '2018-05-30 00:27:25'),
(39, 15120777, 9559, '2232018053000271810', '2018-05-30 00:27:26'),
(40, 15120777, 9559, '2232018053000277750', '2018-05-30 00:27:26'),
(41, 15120777, 9559, '2232018053000273810', '2018-05-30 00:27:27'),
(42, 15120777, 9559, '2232018053000279720', '2018-05-30 00:27:27'),
(43, 15120777, 9559, '2232018053000275950', '2018-05-30 00:27:28'),
(44, 15120777, 9559, '2232018053000271360', '2018-05-30 00:27:29'),
(45, 14121555, 9558, '2232018053000319730', '2018-05-30 00:31:11'),
(46, 15120777, 9560, '2232018053000452770', '2018-05-30 00:45:11'),
(47, 15120777, 9559, '2232018053000507890', '2018-05-30 00:50:18'),
(48, 15120777, 9538, '2232018053000503430', '2018-05-30 00:50:32'),
(49, 15121897, 9527, '2232018060100202510', '2018-06-01 00:20:23'),
(50, 15121897, 9559, '2232018060100201930', '2018-06-01 00:20:27'),
(51, 15121897, 9558, '2232018060100208720', '2018-06-01 00:20:29'),
(52, 15121897, 9566, '2232018060100236720', '2018-06-01 00:23:53'),
(53, 15121897, 9566, '2232018060100231260', '2018-06-01 00:23:54'),
(54, 15121897, 9566, '2232018060100233600', '2018-06-01 00:23:54'),
(55, 15121897, 9566, '2232018060100237360', '2018-06-01 00:23:54'),
(56, 15121897, 9566, '223201806010023800', '2018-06-01 00:23:55'),
(57, 15121897, 9566, '2232018060100232660', '2018-06-01 00:23:55'),
(58, 15121897, 9566, '2232018060100234440', '2018-06-01 00:23:55'),
(59, 15121897, 9566, '2232018060100236090', '2018-06-01 00:23:55'),
(60, 15121897, 9566, '2232018060100239150', '2018-06-01 00:23:55'),
(61, 15120777, 9558, '2232018060108259950', '2018-06-01 08:25:19'),
(62, 15120777, 9559, '2232018060108251550', '2018-06-01 08:25:27'),
(63, 15121898, 9567, '2232018060108291140', '2018-06-01 08:29:50');

-- --------------------------------------------------------

--
-- 表的结构 `tbl_test`
--

CREATE TABLE `tbl_test` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `tbl_test`
--

INSERT INTO `tbl_test` (`id`, `name`) VALUES
(5, NULL),
(6, 'test'),
(7, 'test');

-- --------------------------------------------------------

--
-- 表的结构 `tbl_user`
--

CREATE TABLE `tbl_user` (
  `id` int(8) NOT NULL COMMENT '用户id，可用于登录',
  `name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(255) DEFAULT NULL COMMENT '用户昵称',
  `email` varchar(64) DEFAULT NULL COMMENT '用户email',
  `number` varchar(255) DEFAULT NULL COMMENT '用户联系方式',
  `password` varchar(255) DEFAULT NULL COMMENT '用户密码',
  `role` varchar(64) DEFAULT NULL COMMENT '用户角色：admin、user',
  `is_borrow` varchar(64) DEFAULT NULL COMMENT '用户能否借书',
  `recently_login` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `tbl_user`
--

INSERT INTO `tbl_user` (`id`, `name`, `nickname`, `email`, `number`, `password`, `role`, `is_borrow`, `recently_login`) VALUES
(10000000, 'admin', '用户的爸爸', 'JustinDellAdam@live.com', '18016015760', '21232f297a57a5a743894a0e4a801fc3', 'root', 'true', '2018-05-29 23:52:55'),
(14121555, '霍鹏宇', '霍鹏宇', 'dreamcatcherhpy@qq.com', '18516719403', '28e8fb98ab4dfbf3fb121979fea5c53b', 'user', 'true', NULL),
(15120777, '李欣', '李欣', 'JustinDellAdam@live.com', '18016015760', '128e4949aa4cb04fe109c52df0c67732', 'user', 'true', NULL),
(15121111, '柳力', '上大无彦祖', '1712279796@qq.com', '18016015760', '0144e4bf6eab6053de5a445069012063', 'user', 'true', '2018-05-29 22:04:20'),
(15121112, 'ttnh', '头铁男孩', '23154245@qq.com', '18717892533', '202cb962ac59075b964b07152d234b70', 'user', 'true', NULL),
(15121113, 'ftkzjy', '富土康质检员', '2123542454@qq.com', '15425392533', '202cb962ac59075b964b07152d234b70', 'user', 'true', NULL),
(15121114, 'zs', '张三', '25635566@qq.com', '12367235675', '202cb962ac59075b964b07152d234b70', 'user', 'true', NULL),
(15121115, 'kdjdsz', '肯打鸡董事长', '1789635566@qq.com', '12367891265', '202cb962ac59075b964b07152d234b70', 'user', 'true', NULL),
(15121894, 'lm', '黎明', '231241@qq.com', '18717892775', '202cb962ac59075b964b07152d234b70', 'user', 'true', NULL),
(15121895, 'test', 'test', 'test@test.com', '12345678901', '202cb962ac59075b964b07152d234b70', 'user', 'true', NULL),
(15121896, '测试', '测试', 'test@test.com', '11111111111', '098f6bcd4621d373cade4e832627b4f6', 'user', 'true', NULL),
(15121897, '陈至成', '逼王', 'j@j.com', '12345678909', 'e2549172457ea725492eca0d353a18fd', 'user', 'true', NULL),
(15121898, '郑老师', '郑老师', 'z@z.com', '11111111111110', 'ad0234829205b9033196ba818f7a872b', 'user', 'true', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_book`
--
ALTER TABLE `tbl_book`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_book_copy`
--
ALTER TABLE `tbl_book_copy`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_borrow`
--
ALTER TABLE `tbl_borrow`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_borrow_copy`
--
ALTER TABLE `tbl_borrow_copy`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_contact`
--
ALTER TABLE `tbl_contact`
  ADD PRIMARY KEY (`contact_id`);

--
-- Indexes for table `tbl_order`
--
ALTER TABLE `tbl_order`
  ADD PRIMARY KEY (`order_id`);

--
-- Indexes for table `tbl_test`
--
ALTER TABLE `tbl_test`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `tbl_book`
--
ALTER TABLE `tbl_book`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '书籍号', AUTO_INCREMENT=9568;
--
-- 使用表AUTO_INCREMENT `tbl_book_copy`
--
ALTER TABLE `tbl_book_copy`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '书籍号';
--
-- 使用表AUTO_INCREMENT `tbl_borrow`
--
ALTER TABLE `tbl_borrow`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=77;
--
-- 使用表AUTO_INCREMENT `tbl_borrow_copy`
--
ALTER TABLE `tbl_borrow_copy`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- 使用表AUTO_INCREMENT `tbl_contact`
--
ALTER TABLE `tbl_contact`
  MODIFY `contact_id` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- 使用表AUTO_INCREMENT `tbl_order`
--
ALTER TABLE `tbl_order`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;
--
-- 使用表AUTO_INCREMENT `tbl_test`
--
ALTER TABLE `tbl_test`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- 使用表AUTO_INCREMENT `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '用户id，可用于登录', AUTO_INCREMENT=15121899;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
