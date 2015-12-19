<?php
/**
 * Created by PhpStorm.
 * User: dengzhirong
 * Date: 15.12.15
 * Time: 9:28
 */

/*
* PHP 版本检查
*/
if(0 > version_compare(PHP_VERSION, "5")) {
    die("本程序需要PHP5或更高版本!");
}

// 开启session
session_start();

// 系统配置文件 start
@include_once("/data/config.php");
// 系统配置文件 end

// 连接和测试数据库 start
$SQL_CONFIG = array("host" => $SQL_HOST,
    "port" => $SQL_PORT,
    "database" => $SQL_DATABASE,
    "username" => $SQL_USER,
    "password" => $SQL_PASSWORD);

print_r($SQL_CONFIG);

$db = new mysql($SQL_CONFIG["host"].':'.$SQL_CONFIG["port"], $SQL_CONFIG["username"], $SQL_CONFIG["password"], $SQL_CONFIG["database"]);
if(true) {
    try{
        $result = $db->select_db("*");
        print_r($result);
    } catch(Exception $e) {
        echo "很抱歉，数据库连接失败，请您稍后再试。";
        exit;
    }
}

try{
    $db->query("SET NAMES 'UTF8'");
} catch(Exception $e) {

}

