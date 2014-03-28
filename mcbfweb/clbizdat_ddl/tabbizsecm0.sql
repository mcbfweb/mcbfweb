--<ScriptOptions statementTerminator=";"/>

DROP TABLE IF EXISTS `cb_clbizdat`.`TABBIZSECM0`;
CREATE TABLE  `cb_clbizdat`.`TABBIZSECM0` (
  `BIZCODE` varchar(10) NOT NULL COMMENT 'Code',
  `BIZDESC` varchar(100) NOT NULL COMMENT 'Long Desc',
  `BIZSDESC` varchar(15) NOT NULL COMMENT 'Short Desc',
  `BIZECOCDE` varchar(10) NOT NULL COMMENT 'Economic Sector Code',
  `BIZCRTDT` datetime NOT NULL COMMENT 'Create Date',
  `BIZCRTUSR` varchar(15) NOT NULL COMMENT 'Created By',
  `BIZCHGDT` datetime NOT NULL COMMENT 'Change Date',
  `BIZCHGUSR` varchar(15) NOT NULL COMMENT 'Changed By',
  PRIMARY KEY  (`BIZECOCDE`,`BIZCODE`) 
   
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COMMENT='Business Sector Table';