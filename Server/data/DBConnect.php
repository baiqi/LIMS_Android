<?php
/**
 * Created by PhpStorm.
 * User: dengzhirong
 * Date: 15.12.15
 * Time: 10:04
 */

// 数据库配置信息
@include_once(dirname(dirname(__FILE__)).'/config/config.php');

/*// 数据库连接信息数据
public $SQL_CONFIG = array("host" => $SQL_HOST,
    "port" => $SQL_PORT, "database" => $SQL_DATABASE,
    "username" => $SQL_USER, "password" => $SQL_PASSWORD);*/

/*
 * 连接数据库
 * 返回当前的数据库连接PDOStatement对象
 * */
class DBConnect {

    public function DBConnect() {
        $SQL_CONFIG = array("host" => "localhost",
            "port" => "3306", "database" => "lims",
            "username" => "lims", "password" => "lims");

        $PDOStatement = new PDO("mysql:host=".$SQL_CONFIG["host"].";port=".$SQL_CONFIG["port"].";dbname=".$SQL_CONFIG["database"], $SQL_CONFIG["username"], $SQL_CONFIG["password"]);

        if($PDOStatement) {
            try{
                $PDOStatement->query("SET NAMES 'UTF8'");
                return $PDOStatement;
            } catch(Exception $e) {
                die("Connect Server Failed: " . mysql_error());
            }
        }else {
            echo "数据库连接失败！";
            return null;
        }
    }
}