--<ScriptOptions statementTerminator=";"/>

DROP TABLE IF EXISTS `cb_clbizdat`.`TABECOSECM0`;
CREATE TABLE  `cb_clbizdat`.`TABECOSECM0` (
  `ECOCODE` varchar(10) NOT NULL COMMENT 'Code',
  `ECODESC` varchar(100) NOT NULL COMMENT 'Long Desc',
  `ECOSDESC` varchar(15) NOT NULL COMMENT 'Short Desc',
  `ECOCRTDT` datetime NOT NULL COMMENT 'Create Date',
  `ECOCRTUSR` varchar(15) NOT NULL COMMENT 'Created By',
  `ECOCHGDT` datetime NOT NULL COMMENT 'Change Date',
  `ECOCHGUSR` varchar(15) NOT NULL COMMENT 'Changed By',
  PRIMARY KEY  (`ECOCODE`,`ECODESC`),
  UNIQUE KEY `ECOCODE` (`ECOCODE`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COMMENT='Economic Sector Table';