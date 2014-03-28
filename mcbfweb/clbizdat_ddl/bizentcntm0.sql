DROP TABLE IF EXISTS `cb_clbizdat`.`BIZENTCNTM0`;
CREATE TABLE  `cb_clbizdat`.`BIZENTCNTM0` (
  `CNTENTITY` int(11) NOT NULL COMMENT 'Entity Code',
  `CNTTYP` varchar(5) NOT NULL COMMENT 'Contact Type',
  `CNTNAME` varchar(100) NOT NULL COMMENT 'Contact Name',
  `CNTPOS` varchar(20) NOT NULL COMMENT 'Contact Position',
  `CNTEMAIL` varchar(100) NOT NULL COMMENT 'Email Address',
  `CNTISDCDE` varchar(4) NOT NULL COMMENT 'ISD Code',
  `CNTAREACDE` varchar(5) NOT NULL COMMENT 'Area Code',
  `CNTPHNNO` varchar(10) NOT NULL COMMENT 'Phone Number',
  `CNTDATID` int(11) NOT NULL auto_increment COMMENT 'File Unique Id',
  `CNTCRTDT` datetime NOT NULL default '2013-12-04 14:19:27' COMMENT 'Create Date',
  `CNTCRTUSR` varchar(15) NOT NULL COMMENT 'Created By',
  `CNTCHGDT` datetime NOT NULL default '2013-12-04 14:19:27' COMMENT 'Change Date',
  `CNTCHGUSR` varchar(15) NOT NULL COMMENT 'Changed By',
  `CNTVERSION` int(7) NOT NULL COMMENT 'Version No.',
  PRIMARY KEY  USING BTREE (`CNTENTITY`,`CNTDATID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COMMENT='Entity Contact Table';