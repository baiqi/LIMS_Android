<?php
/**
 * Created by PhpStorm.
 * User: dengzhirong
 * Date: 15.12.15
 * Time: 8:51
 */

// 网站根目录
@define("ROOT_PATH", dirname(dirname(__FILE__.'/')));

// config目录
@define("CONFIG_PATH", ROOT_PATH.'\config');

// library目录
@define("LIB_PATH", ROOT_PATH.'\lib');

// 网站主程序目录
@define("APP_PATH", ROOT_PATH.'\application');

// Model主目录
@define("MODEL_PATH", APP_PATH.'\Model');

// Controller主目录
@define("CONTROLLER_PATH", APP_PATH.'\Controller');

/*// View主目录
@define("VIEW_PATH", ROOT_PATH."/");*/

// 网站缓存数据目录
@define("CACHE_PATH", ROOT_PATH.'\cahce');

// 数据库备份目录
@define("SQLDATA_CACHE_PATH", CACHE_PATH.'\data');

// 文档上传目录
@define("UPLOADFILE_PATH", ROOT_PATH.'\uploadfile');
if(!file_exists(UPLOADFILE_PATH)) {
    mkdir(UPLOADFILE_PATH, 0777);
    @chmod(UPLOADFILE_PATH, 0777);
}

/*// 当前网络请求地址的根目录
@define("ROOTURL", $ROOTURL);*/