<?php
/**
 * Created by PhpStorm.
 * User: dengzhirong
 * Date: 15.12.16
 * Time: 11:08
 */

/*
 * 获取仪器预约信息
 * 请求方法：POST
 * 请求体数据格式：{"isCompleted": 0}
 * 返回值：{"deviceID": 1, "userID": 1, "userType": 0,
    "beginTime": "2015-12-12 12:00:00", "endTime": "2015-12-12 13:00:00",
    "price": "50.00", "duration": 1, "phoneNum": "13929584731", "remark": "我是备注",
    "project": "测试项目1"}
 * 示例：
    [
    {"deviceID":"1","userID":"1","userType":"0","beginTime":"2015-12-12 12:00:00",
        "endTime":"2015-12-12 13:00:00","price":"50","duration":"1","phoneNum":"13929584731",
        "remark":"我是备注","project":"测试项目1"},
    {"deviceID":"1","userID":"1","userType":"0","beginTime":"2015-12-12 12:00:00",
        "endTime":"2015-12-12 13:00:00","price":"50","duration":"1",
        "phoneNum":"13929584731","remark":"我是备注","project":"测试项目5"}
    ]
 * */

include_once("../../data/DBConnect.php");

// 页面使用utf-8编码格式
header("Content-Type: text/html; charset=UTF-8");
// 页面的访问域是任意的
header("Access-Control-Allow-Origin: *");
// 启用session
session_start();

// 存放News信息的数组
$data = array();

/*
 * 获取POST传递的参数
 * */
$isCompleted = 0;
if($_POST['isCompleted']) {
    $isCompleted = $_POST['isCompleted'];
}

// 验证当前的session是否存在
if(checkSession()) {
    // 获得PDO对象
    $pdo = new DBConnect();
    $link = $pdo->DBConnect();

    /*
     * 获得当前ArticleType的PDOStament对象，并根据loadingIndex获取获取的条数
     * 数据表名：device_reserve
     * 返回值：
     {"deviceID": 1, "userID": 1, "userType": 0,
    "beginTime": "2015-12-12 12:00:00", "endTime": "2015-12-12 13:00:00",
    "price": "50.00", "duration": 1, "phoneNum": "13929584731", "remark": "我是备注",
    "project": "测试项目1"}
     *      * */

    $query = "SELECT DeviceID,UserID,UserType,BeginTime,EndTime,Price,Duration,UserPhoneNumber,Remark,Project FROM device_reserve WHERE IsCompleted='{$isCompleted}'";

//        $query = "SELECT * FROM userinfo WHERE Name='{$userName}' AND "."Password='{$password}'";

    $result = $link->query($query);

    // 若查到记录，则设置SESSION，并进行页面重定向
    if($result) {

        while($row = $result->fetchAll(PDO::FETCH_ASSOC)) {
            for($i=0;$i<count($row);$i++){
                $data[$i]["deviceID"] = $row[$i]["DeviceID"];
                $data[$i]["userID"] = $row[$i]["UserID"];
                $data[$i]["userType"] = $row[$i]["UserType"];
                $data[$i]["beginTime"] = $row[$i]["BeginTime"];
                $data[$i]["endTime"] = $row[$i]["EndTime"];
                $data[$i]["price"] = $row[$i]["Price"];
                $data[$i]["duration"] = $row[$i]["Duration"];
                $data[$i]["phoneNum"] = $row[$i]["UserPhoneNumber"];
                $data[$i]["remark"] = $row[$i]["Remark"];
                $data[$i]["project"] = $row[$i]["Project"];
            }
        }
    }else{
        echo "用户不存在，请重新登录。";
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