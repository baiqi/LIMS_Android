<?php
/**
 * Created by PhpStorm.
 * User: dengzhirong
 * Date: 15.12.16
 * Time: 8:44
 */

/*
 * 获取新闻列表信息（每次更新10条，每下拉一次加载5条）
 * 请求方法：POST
 * 请求体数据格式：{"loadingIndex": 1, "ArticleType": "News"}
 * 返回值：{"title": "我是标题", "subtitle": "我是副标题", "updateTime": "2015-12-13",
 *         "author": "邓智容", "articleID": "234", "articleUrl": "dengzhr.com"}
 * 示例：
     [{"title":"我是标题1","subtitle":"我是副标题1",
     "updateTime":"2015-12-11 00:00:00","author":"邓智容",
     "articleID":"1","articleUrl":"dengzhr.com"},
      {"title":"我是标题2","subtitle":"我是副标题2",
      "updateTime":"2015-12-11 00:00:00","author":"邓智容",
      "articleID":"2","articleUrl":"dengzhr.com"}]
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

// 每次加载的条数
$firstLoadingCount = 2;
$eachLoadingCount = 3;

/*
 * 获取POST传递的参数
 * */
$loadingIndex= 0;
$ArticleType= "News";
if($_POST['loadingIndex'] && $_POST['ArticleType']) {
    $loadingIndex=$_POST['loadingIndex'];
    $ArticleType=trim($_POST['ArticleType'])=="News"? 0: 1;
}

// 验证当前的session是否存在
if(checkSession()) {
    // 获得PDO对象
    $pdo = new DBConnect();
    $link = $pdo->DBConnect();

    /*
     * 获得当前ArticleType的PDOStament对象，并根据loadingIndex获取获取的条数
     * 数据表名：content_article
     * {"loadingIndex": 1, "ArticleType": "News"}
     * */
    $query = "";
    if($loadingIndex == 0) {
        $query = "SELECT  * FROM content_article WHERE NodeID='{$ArticleType}' order by ArticleID limit 0, ".$firstLoadingCount;
    } elseif($loadingIndex == 1) {
        $query = "SELECT  * FROM content_article WHERE NodeID='{$ArticleType}' order by ArticleID limit ".$firstLoadingCount.", ".$eachLoadingCount;
    }else {
        $query = "SELECT  * FROM content_article WHERE NodeID='{$ArticleType}' order by ArticleID limit ".($eachLoadingCount*($loadingIndex-1) + $firstLoadingCount).", ".$eachLoadingCount;
    }
//        $query = "SELECT * FROM userinfo WHERE Name='{$userName}' AND "."Password='{$password}'";

    $result = $link->query($query);
    $rowCount = $result->columnCount();

    // 若查到记录，则设置SESSION，并进行页面重定向
    if($result) {
        // 循环数据，并将数据写入$data
        while($row = $result->fetchAll(PDO::FETCH_ASSOC)) {
            for($i=0;$i<count($row);$i++){
                $data[$i]["title"] = $row[$i]["Title"];
                $data[$i]["subtitle"] = $row[$i]["SubTitle"];
                $data[$i]["updateTime"] = $row[$i]["UpdateTime"];
                $data[$i]["author"] = $row[$i]["Author"];
                $data[$i]["articleID"] = $row[$i]["ArticleID"];
                $data[$i]["articleUrl"] = $row[$i]["Url"];
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