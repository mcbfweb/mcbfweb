
DROP TABLE IF EXISTS `cb_clbizdat`.`TABSTATEM0`;
CREATE TABLE  `cb_clbizdat`.`TABSTATEM0` (
  `STACTRY` varchar(5) NOT NULL COMMENT 'Country Code',
  `STACDE` varchar(5) NOT NULL COMMENT 'State Code',
  `STANAME` varchar(100) NOT NULL COMMENT 'State Name',
  `STAGEOID` int(20) unsigned default NULL COMMENT 'Geo ID',
  `STADATID` int(11) NOT NULL auto_increment COMMENT 'Data ID',
  `STACRTDT` datetime NOT NULL COMMENT 'Create Date',
  `STACRTUSR` varchar(15) NOT NULL COMMENT 'Created By',
  `STACHGDT` datetime NOT NULL COMMENT 'Change Date',
  `STACHGUSR` varchar(15) NOT NULL COMMENT 'Changed By',
  PRIMARY KEY  USING BTREE (`STACTRY`,`STACDE`, `STADATID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COMMENT='Country States/Provinces Code'; 
