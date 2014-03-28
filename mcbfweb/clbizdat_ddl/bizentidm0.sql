
DROP TABLE IF EXISTS `cb_clbizdat`.`BIZENTIDM0`;
CREATE TABLE  `cb_clbizdat`.`BIZENTIDM0` (
  `IDENTITY` int(11) NOT NULL COMMENT 'Entity Code',
  `IDCTRY` varchar(5) NOT NULL COMMENT 'Id Country',
  `IDIDTYP` varchar(5) NOT NULL COMMENT 'ID Type',
  `IDIDCODE` varchar(40) NOT NULL COMMENT 'ID Code',
  `IDDATID` int(11) NOT NULL auto_increment COMMENT 'File Unique Id',
  `IDCRTDT` datetime NOT NULL default '2013-12-04 14:19:27' COMMENT 'Create Date',
  `IDCRTUSR` varchar(15) NOT NULL COMMENT 'Created By',
  `IDCHGDT` datetime NOT NULL default '2013-12-04 14:19:27' COMMENT 'Change Date',
  `IDCHGUSR` varchar(15) NOT NULL COMMENT 'Changed By',
  `IDVERSION` int(7) unsigned NOT NULL COMMENT 'Version No.',
  
  PRIMARY KEY  USING BTREE (`IDENTITY`,`IDDATID`),
  UNIQUE KEY `IdIdx` USING BTREE (`IDCTRY`,`IDIDTYP`,`IDIDCODE`,`IDDATID`)
) ENGINE=MyISAM AUTO_INCREMENT=46 DEFAULT CHARSET=latin1 COMMENT='Business ID Table';