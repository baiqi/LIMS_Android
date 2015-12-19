<?php
/**
 * Created by PhpStorm.
 * User: dengzhirong
 * Date: 15.12.15
 * Time: 21:44
 */

/*
 * 向数据库中插入短信息
 * 请求方法：POST
 * 请求体数据格式：{"sendName": "dengzhirong", "receiverName": "xiaohei",
    "title": "Hello, xiaohei你好，我是邓子", "content": "我是消息正文"}
 * 返回值：{"success": true}
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
 * {"sendName": "dengzhirong", "receiverName": "xiaohei",
    "title": "Hello, xiaohei你好，我是邓子", "content": "我是消息正文"}
 * */
$sendName= "";
$receiverName="";
$title="";
$content="";
if($_POST["sendName"] && $_POST["receiverName"] && $_POST["title"] && $_POST["content"]) {
    $sendName= trim($_POST['sendName']);
    $receiverName=trim($_POST['receiverName']);
    $title=trim($_POST['title']);
    $content=trim($_POST['content']);
}

// 验证当前的session是否存在
if(checkSession()) {
    // 获得PDO对象
    $pdo = new DBConnect();
    $link = $pdo->DBConnect();

    /*
     * 获得当前ArticleType的PDOStament对象，并根据loadingIndex获取获取的条数
     * 数据表名：content_article
     * */
//    $query = "SELECT * FROM content_article WHERE ArticleID='{$artileID}'";

    $sendID =getIDFromUserName($sendName);
    $receiverID =getIDFromUserName($receiverName);

    try {
        $link->beginTransaction();
        $query = "insert into message (SendID, ReceiverID, Title, Content) values (1, 2, '{$title}', '{$content}')";
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

/*
 * 从用户名中得到用户ID
 * */
function getIDFromUserName($name) {

    $userID = array();

    // 获得PDO对象
    $pdo = new DBConnect();
    $link = $pdo->DBConnect();

    //
    $query_get_ID = "SELECT UserID from userinfo WHERE Name='{$name}'";

    $result = $link->query($query_get_ID);

    if($result) {
        foreach($result as $row) {
            $userID[0] = $row["UserID"];
        }
    }
    return $userID[0];
}
