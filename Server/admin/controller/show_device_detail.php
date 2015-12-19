<?php
/**
 * Created by PhpStorm.
 * User: dengzhirong
 * Date: 15.12.16
 * Time: 9:56
 */


/*
 * 获取特定仪器的详细信息
 * 请求方法：POST
 * 请求体数据格式：{"deviceID": 1}
 * 返回值：
    {
    "deviceID":"2","deviceName":"X-射线光电子能谱仪","deviceNameEn":"x-ray","Model":"",
    "priceInner":"100","priceOuter":"200","status":"0",
    "devicePicUrl":"http:\/\/7xinb0.com1.z0.glb.clouddn.com\/skin\/HopeRebuild\/dist\/images\/logo\/logo_40.png"
    }
 * 示例：
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
 * 获取POST传递的参数{"deviceNodeID": "1"}
 * */
$deviceID = 0;
if($_POST['deviceID']) {
    $deviceID = $_POST['deviceID'];
}

// 验证当前的session是否存在
if(checkSession()) {
    // 获得PDO对象
    $pdo = new DBConnect();
    $link = $pdo->DBConnect();

    /*
     * 获得当前ArticleType的PDOStament对象，并根据loadingIndex获取获取的条数
     * 数据表名：device_info
     * 返回值：
     {
        "deviceID":"2","deviceName":"X-射线光电子能谱仪","deviceNameEn":"x-ray","Model":"",
        "priceInner":"100","priceOuter":"200","status":"0",
        "devicePicUrl":"http:\/\/7xinb0.com1.z0.glb.clouddn.com\/skin\/HopeRebuild\/dist\/images\/logo\/logo_40.png"
    }
     * */

    $query = "SELECT * FROM device_info WHERE DeviceID='{$deviceID}'";

//        $query = "SELECT * FROM userinfo WHERE Name='{$userName}' AND "."Password='{$password}'";

    $result = $link->query($query);

    // 若查到记录，则设置SESSION，并进行页面重定向
    if($result) {

        foreach($result as $row) {
            $data["deviceID"] = $row["DeviceID"];
            $data["deviceName"] = $row["Name"];
            $data["deviceNameEn"] = $row["NameEn"];
            $data["Model"] = $row["Model"];
            $data["priceInner"] = $row["PriceInner"];
            $data["priceOuter"] = $row["PriceOuter"];
            $data["status"] = $row["Status"];
            $data["devicePicUrl"] = $row["DevicePicUrl"];
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