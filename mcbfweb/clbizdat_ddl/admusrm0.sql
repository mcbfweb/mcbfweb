DROP TABLE IF EXISTS `cb_clbizdat`.`ADMUSRM0`;
CREATE TABLE  `cb_clbizdat`.`ADMUSRM0` (
  `USRCLIENT` int(11) NOT NULL COMMENT 'Client Number',
  `USRSTATUS` varchar(5) NOT NULL COMMENT 'User Status',
  `USRSTATDT` datetime NOT NULL COMMENT 'Status Date',
  `USRID` varchar(50) NOT NULL COMMENT 'User ID',
  `USRPWD` varchar(50) NOT NULL COMMENT 'User Password',
  `USRPWDEXP` datetime NOT NULL COMMENT 'User Password Expiry',
  `USRROLE` varchar(5) default NULL COMMENT 'User Role',
  `USRGROUP` varchar(5) NOT NULL COMMENT 'User Group',
  `USRUNAME` varchar(100) character set latin1 collate latin1_bin NOT NULL COMMENT 'User Unformatted Name',
  `USREMAIL` varchar(100) NOT NULL COMMENT 'User Email Address',
  `USRCNTISDCDE` varchar(4) NOT NULL COMMENT 'ISD Code',
  `USRAREACDE` varchar(5) NOT NULL COMMENT 'Area Code',
  `USRPHNNO` varchar(10) NOT NULL COMMENT 'Phone Number',
  `USRDATID` int(11) NOT NULL auto_increment COMMENT 'File Unique Id',
  `USRCRTDT` datetime NOT NULL COMMENT 'Create Date',
  `USRCRTUSR` varchar(15) NOT NULL COMMENT 'Created By',
  `USRCHGDT` datetime default NULL COMMENT 'Change Date',
  `USRCHGUSR` varchar(15) default NULL COMMENT 'Changed By',
  `USRVERSION` int(7) NOT NULL COMMENT 'Version No.',
  PRIMARY KEY  USING BTREE (`USRCLIENT`,`USRID`,`USRDATID`),
  UNIQUE KEY `USRCLIENT` (`USRCLIENT`,`USRID`),
  KEY `UserRole` (`USRROLE`,`USRID`),
  KEY `UserUName` (`USRUNAME`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COMMENT='User ID Table';