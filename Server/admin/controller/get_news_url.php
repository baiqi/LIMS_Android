<?php
/**
 * Created by PhpStorm.
 * User: dengzhirong
 * Date: 15.12.15
 * Time: 20:42
 */

/*
 * 获取新闻的地址信息
 * 请求方法：POST
 * 请求体数据格式：{"artileID": 1}
 * 返回值：{"articleUrl": "http://dengzhr.com"}
 * 示例：

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
 * */
$artileID= 0;
if($_POST["artileID"]) {
    $artileID = $_POST["artileID"];
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
    $query = "SELECT Url FROM content_article WHERE ArticleID='{$artileID}'";

    $result = $link->query($query);

    // 若查到记录，则设置SESSION，并进行页面重定向
    if($result) {
/*        // 循环数据，并将数据写入$data
        while($row = $result->fetchAll(PDO::FETCH_ASSOC)) {
            for($i=0;$i<count($row);$i++){
                $data[$i]["title"] = $row[$i]["Title"];
                $data[$i]["subtitle"] = $row[$i]["SubTitle"];
                $data[$i]["updateTime"] = $row[$i]["UpdateTime"];
                $data[$i]["author"] = $row[$i]["Author"];
                $data[$i]["articleID"] = $row[$i]["ArticleID"];
                $data[$i]["articleUrl"] = $row[$i]["Url"];
            }
        }*/
        foreach($result as $row) {
            $data["articleUrl"] = $row["Url"];
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