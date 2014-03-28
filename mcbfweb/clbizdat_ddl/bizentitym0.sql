
DROP TABLE IF EXISTS `cb_clbizdat`.`BIZENTITYM0`;
CREATE TABLE  `cb_clbizdat`.`BIZENTITYM0` (
  `ITYENTITY` int(11) unsigned NOT NULL auto_increment COMMENT 'Entity Code',
  `ITYCTRY` varchar(5) NOT NULL COMMENT 'Country Code',
  `ITYENTTYP` varchar(5) NOT NULL COMMENT 'Entity Type',
  `ITYECOCODE` varchar(10) NOT NULL COMMENT 'Eco Sector',
  `ITYBIZCODE` varchar(10) NOT NULL COMMENT 'Biz Sector',
  `ITYCRTDT` datetime NOT NULL COMMENT 'Create Date',
  `ITYCRTUSR` varchar(15) NOT NULL COMMENT 'Created By',
  `ITYCHGDT` datetime NOT NULL COMMENT 'Change Date',
  `ITYCHGUSR` varchar(15) NOT NULL COMMENT 'Changed By',
  `ITYVERSION` int(7) unsigned NOT NULL COMMENT 'Version No.',
  
  PRIMARY KEY  (`ITYENTITY`),
  UNIQUE KEY `Entity` (`ITYENTITY`),
  KEY `EcoBiz` (`ITYECOCODE`,`ITYBIZCODE`),
  KEY `EntType` (`ITYENTTYP`)
) ENGINE=MyISAM AUTO_INCREMENT=51 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC COMMENT='Business Entity Code Table';