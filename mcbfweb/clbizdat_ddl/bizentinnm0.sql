
DROP TABLE IF EXISTS `cb_clbizdat`.`BIZENTINNM0`;
CREATE TABLE  `cb_clbizdat`.`BIZENTINNM0` (
  `INNENTITY` int(11) NOT NULL COMMENT 'Entity Code',
  `INNTYP` varchar(5) NOT NULL COMMENT 'Name Type',
  `INNFNAME` varchar(50) default NULL COMMENT 'First Name',
  `INNSNAME` varchar(50) default NULL COMMENT 'Second Name',
  `INNLNAME` varchar(50) default NULL COMMENT 'Last Name',
  `INNUNAME` varchar(100) default NULL COMMENT 'Unformatted Name',
  `INNBNAME` varchar(100) default NULL COMMENT 'Business Entity Name',
  `INNDATID` int(11) NOT NULL COMMENT auto_increment 'File Unique Id',
  `INNCRTDT` datetime NOT NULL default '2013-12-04 14:19:27' COMMENT 'Create Date',
  `INNCRTUSR` varchar(15) NOT NULL COMMENT 'Created By',
  `INNCHGDT` datetime NOT NULL default '2013-12-04 14:19:27' COMMENT 'Change Date',
  `INNCHGUSR` varchar(15) NOT NULL COMMENT 'Changed By',
  `INNVERSION` int(7) NOT NULL COMMENT 'Version No.',
  PRIMARY KEY  USING BTREE (`INNENTITY`,`INNDATID`),
  KEY `BizName` USING BTREE (`INNTYP`,`INNBNAME`),
  KEY `IndName` USING BTREE (`INNTYP`,`INNFNAME`,`INNLNAME`),
  KEY `IndUName` (`INNTYP`,`INNUNAME`)
) ENGINE=MyISAM AUTO_INCREMENT=48 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC COMMENT='Entity Name Table';