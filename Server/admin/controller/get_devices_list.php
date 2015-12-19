<?php
/**
 * Created by PhpStorm.
 * User: dengzhirong
 * Date: 15.12.16
 * Time: 9:56
 */

/*
 * 获取特定分类下的仪器列表信息
 * 请求方法：POST
 * 请求体数据格式：{"deviceNodeID": "1"}
 * 返回值：{"deviceID": 1, "deviceName": "激光显微拉曼光谱仪",
    "deviceNameEn": "Laser Micro-Raman Spectrometer ",
    "Model": "Renishaw inVia", "priceInner": "200", "priceOuter": 300,
    "Status": 1,
    "devicePicUrl": "http://7xinb0.com1.z0.glb.clouddn.com/skin/HopeRebuild/dist/images/logo/logo_40.png"}
 * 示例：
   [{"deviceID":"3","deviceName":"冷场发射扫描电镜","deviceNameEn":"lengchang",
    "Model":"","priceInner":"100","priceOuter":"200","status":"0",
    "devicePicUrl":"http:\/\/7xinb0.com1.z0.glb.clouddn.com\/skin\/HopeRebuild\/dist\/images\/logo\/logo_40.png"}]
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
$deviceNodeID = 0;
if($_POST['deviceNodeID']) {
    $deviceNodeID = $_POST['deviceNodeID'];
}

// 验证当前的session是否存在
if(checkSession()) {
    // 获得PDO对象
    $pdo = new DBConnect();
    $link = $pdo->DBConnect();

    /*
     * 获得当前ArticleType的PDOStament对象，并根据loadingIndex获取获取的条数
     * 数据表名：device_info
     * 返回值：{"deviceID": 1, "deviceName": "激光显微拉曼光谱仪",
    "deviceNameEn": "Laser Micro-Raman Spectrometer ",
    "Model": "Renishaw inVia", "priceInner": "200", "priceOuter": 300,
    "status": 1,
    "devicePicUrl": "http://7xinb0.com1.z0.glb.clouddn.com/skin/HopeRebuild/dist/images/logo/logo_40.png"}
     * */

    $query = "SELECT DeviceID,Name,NameEn,Model,PriceInner,PriceOuter,Status,DevicePicUrl FROM device_info WHERE DeviceNodeID='{$deviceNodeID}'";

//        $query = "SELECT * FROM userinfo WHERE Name='{$userName}' AND "."Password='{$password}'";

    $result = $link->query($query);

    // 若查到记录，则设置SESSION，并进行页面重定向
    if($result) {

        while($row = $result->fetchAll(PDO::FETCH_ASSOC)) {
            for($i=0;$i<count($row);$i++){
                $data[$i]["deviceID"] = $row[$i]["DeviceID"];
                $data[$i]["deviceName"] = $row[$i]["Name"];
                $data[$i]["deviceNameEn"] = $row[$i]["NameEn"];
                $data[$i]["Model"] = $row[$i]["Model"];
                $data[$i]["priceInner"] = $row[$i]["PriceInner"];
                $data[$i]["priceOuter"] = $row[$i]["PriceOuter"];
                $data[$i]["status"] = $row[$i]["Status"];
                $data[$i]["devicePicUrl"] = $row[$i]["DevicePicUrl"];
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

