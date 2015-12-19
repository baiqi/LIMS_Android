<?php
/**
 * Created by PhpStorm.
 * User: dengzhirong
 * Date: 15.12.15
 * Time: 23:13
 */

/*
 * 向数据库中插入短信息
 * 请求方法：POST
 * 请求体数据格式：
 * 返回值：{"sendName": "dengzhirong", "receiverName": "xiaohei",
    "title": "Hello, xiaohei你好，我是邓子", "content": "我是消息正文"}
 * */

include_once("../../data/DBConnect.php");

// 页面使用utf-8编码格式
header("Content-Type: text/html; charset=UTF-8");
// 页面的访问域是任意的
header("Access-Control-Allow-Origin: *");

// 存放News信息的数组
$data = array();

// 验证当前的session是否存在
if(checkSession()) {
    // 获得PDO对象
    $pdo = new DBConnect();
    $link = $pdo->DBConnect();

    try {
        $link->beginTransaction();
        $query = "SELECT SendID,ReceiverID,Title,Content,MessageDate FROM message";

        $result = $link->query($query);

        // 查到记录
        if($result) {
            // 循环数据，并将数据写入$data
            while($row = $result->fetchAll(PDO::FETCH_ASSOC)) {
                for($i=0; $i<count($row); $i++){
                    $data[$i]["sendName"] = getUserRealNameFromID($row[$i]["SendID"]);
                    $data[$i]["receiverName"] = getUserRealNameFromID($row[$i]["ReceiverID"]);
                    $data[$i]["title"] = $row[$i]["Title"];
                    $data[$i]["content"] = $row[$i]["Content"];
                    $data[$i]["messageDate"] = $row[$i]["MessageDate"];
                }
            }
        }else{
            echo "用户不存在，请重新登录。";
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

/*
 * 从用户名中得到用户ID
 * */
function getUserRealNameFromID($id) {

    $userName = array();

    // 获得PDO对象
    $pdo = new DBConnect();
    $link = $pdo->DBConnect();

    $query_get_Name = "SELECT RealName from userinfo WHERE UserID='{$id}'";

    $result = $link->query($query_get_Name);

    if($result) {
        foreach($result as $row) {
            $userName = $row["RealName"];
        }
    }
    return $userName;
}