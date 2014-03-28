--<ScriptOptions statementTerminator=";"/>

DROP TABLE IF EXISTS `cb_clbizdat`.`TABGENM0`;
CREATE TABLE  `cb_clbizdat`.`TABGENM0` (
  `GENDEFTYP` varchar(10) NOT NULL COMMENT 'Table Definition Type',
  `GENCODID` varchar(5) NOT NULL COMMENT 'Table Code Id',
  `GENDESC` varchar(100) NOT NULL COMMENT 'Long Desc',
  `GENSDESC` varchar(15) NOT NULL COMMENT 'Short Desc',
  `GENVWSEQ` int(5) NOT NULL COMMENT 'View Seq',
  `GENDATID` int(11) NOT NULL auto_increment COMMENT 'Data ID',
  `GENCRTDT` datetime NOT NULL COMMENT 'Create Date',
  `GENCRTUSR` varchar(15) NOT NULL COMMENT 'Created By',
  `GENCHGDT` datetime NOT NULL COMMENT 'Change Date',
  `GENCHGUSR` varchar(15) NOT NULL COMMENT 'Changed By',
  PRIMARY KEY  USING BTREE (`GENDEFTYP`,`GENCODID`,`GENVWSEQ`,`GENDATID`),
  UNIQUE KEY `GENDEFTYP` (`GENDEFTYP`,`GENCODID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COMMENT='Genral Definitions';