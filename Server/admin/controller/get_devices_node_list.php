<?php
/**
 * Created by PhpStorm.
 * User: dengzhirong
 * Date: 15.12.15
 * Time: 16:54
 */

/*
 * 获取仪器分类列表信息（包括分类和每条分类下的仪器数量）
 * 请求方法：POST
 * 请求体数据格式：（分类方式）
 * 返回值：
 *  {"deviceNodeName": "中山大学测试中心-表面与结构分析平台",
    "deviceNodeID": "1", "deviceCount": 5}
 * 示例：
   [{"deviceNodeID":"1","deviceNodeName":"中山大学测试中心-表面与结构分析平台\r\n","deviceCount":2},
   {"deviceNodeID":"2","deviceNodeName":"中山大学测试中心-材料微区分析平台","deviceCount":1}]
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
/*$loadingIndex = 0;
$ArticleType = "News";
if($_POST['loadingIndex'] && $_POST['ArticleType']) {
    $loadingIndex=$_POST['loadingIndex'];
    $ArticleType=trim($_POST['ArticleType'])=="News"? 0: 1;
}*/

// 验证当前的session是否存在
if(checkSession()) {
    // 获得PDO对象
    $pdo = new DBConnect();
    $link = $pdo->DBConnect();

     /*
      * 获得当前ArticleType的PDOStament对象，并根据loadingIndex获取获取的条数
      * 数据表名：device_node
      {"deviceNodeName": "中山大学测试中心-表面与结构分析平台",
        "deviceNodeID": "1", "deviceCount": 5}
      * */
    $query = "SELECT * FROM device_node";
//        $query = "SELECT * FROM userinfo WHERE Name='{$userName}' AND "."Password='{$password}'";

    $result_deviceNode = $link->query($query);

    // 若查到记录，则设置SESSION，并进行页面重定向
    if($result_deviceNode) {

        while($row = $result_deviceNode->fetchAll(PDO::FETCH_ASSOC)) {
            for($i=0;$i<count($row);$i++){

                // 获得仪器分类的ID和分类名
                $deviceNodeID = $row[$i]["NodeID"];
                $data[$i]["deviceNodeID"] = $deviceNodeID;
                $data[$i]["deviceNodeName"] = $row[$i]["NodeName"];

                // 获得仪器分类ID下的仪器数量
                $query_deviceNode = "SELECT * FROM device_info WHERE DeviceNodeID='{$deviceNodeID}'";

                $deviceCount = $link->query($query_deviceNode)->rowCount();
                $data[$i]["deviceCount"] = $deviceCount;
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