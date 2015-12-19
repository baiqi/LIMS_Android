<?php
/**
 * Created by PhpStorm.
 * User: dengzhirong
 * Date: 15.12.16
 * Time: 10:32
 */

/*
 * 向数据库中插入短信息
 * 请求方法：POST
 * 请求体数据格式：{"deviceID": 1, "userID": 1, "userType": 0,
    "beginTime": "2015-12-12 12:00:00", "endTime": "2015-12-12 13:00:00",
    "price": "50.00", "duration": 1, "phoneNum": "13929584731", "remark": "我是备注",
    "project": "测试项目1"}
 * 返回值：
 * */

include_once("../../data/DBConnect.php");

// 页面使用utf-8编码格式
header("Content-Type: text/html; charset=UTF-8");
// 页面的访问域是任意的
header("Access-Control-Allow-Origin: *");

// 存放News信息的数组
$data = array();

/*
 * 获取POST传递的参数
 * {"deviceID": 1, "userID": 1, "userType": 0,
    "beginTime": "2015-12-12 12:00:00", "endTime": "2015-12-12 13:00:00",
    "price": "50.00", "duration": 1, "phoneNum": "13929584731", "remark": "我是备注",
    "project": "测试项目1"}
 * */

$deviceID= $_POST["deviceID"];
$userID= $_POST["userID"];
$userType=$_POST["userType"];
$beginTime=trim($_POST['beginTime']);
$endTime=trim($_POST['endTime']);
$price=trim($_POST['price']);
$duration=trim($_POST['duration']);
$phoneNum=trim($_POST['phoneNum']);
$remark=trim($_POST['remark']);
$project=trim($_POST["project"]);

// 验证当前的session是否存在
if(checkSession()) {
    // 获得PDO对象
    $pdo = new DBConnect();
    $link = $pdo->DBConnect();

    /*
     * 获得当前ArticleType的PDOStament对象，并根据loadingIndex获取获取的条数
     * 数据表名：device_reserve
     * */
//    $query = "SELECT * FROM content_article WHERE ArticleID='{$artileID}'";

    try {
        $link->beginTransaction();
        $query = "insert into device_reserve (DeviceID,UserID,UserType,BeginTime,EndTime,Price,Duration,UserPhoneNumber,Remark,Project)
            values ('{$deviceID}', '{$userID}', '{$userType}', '{$beginTime}', '{$endTime}',
            '{$price}', '{$duration}', '{$phoneNum}', '{$remark}', '{$project}')";
        $reslut = $link->exec($query);
        $link->commit();

        // 当数据插入成功时，执行的函数
        if($reslut) {
            $data["success"] = true;
        }
    } catch (Exception $e) {
        $link->rollBack();
        echo "Failed: " . $e->getMessage();
    }

}else{
    //如果用户未登录，跳转至登录页面
    // header();
}

// 将$data以json格式输出
echo json_encode($data, JSON_UNESCAPED_UNICODE);

/* 验证当前session
 * 当session存在，则返回true
**/
function checkSession() {
    $isSetSession = false;
//    $isSetSession = (!isset($_SESSION['user_id']) && (int)$_SESSION['user_id']>0);
    $isSetSession = (!isset($_SESSION['user_id']));
    return $isSetSession;
}