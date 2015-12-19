<?php
/**
 * Created by PhpStorm.
 * User: dengzhirong
 * Date: 15.12.15
 * Time: 15:50
 */

/*
 * 获取用户信息
 * 请求方法：POST
 * 请求体数据格式：{"userName": "2"}
 * 返回值：{"userName": "邓智容", "userType":"普通用户", "group": "厚朴工作室",
          "job": "student", "userImageUrl": "http://dengzhr.com/dengzhirong.jpg"}
 * */

include_once("../../data/DBConnect.php");

// 页面使用utf-8编码格式
header("Content-Type: text/html; charset=UTF-8");
// 页面的访问域是任意的
header("Access-Control-Allow-Origin: *");

// 存放user信息的数组
$data = array();

/*
 * 获取POST传递的参数
 * */
$userName="";
if($_POST['userName']) {
    $userName=trim($_POST['userName']);
}

// 验证当前的session是否存在
if(checkSession()) {
    // 获得PDO对象
    $pdo = new DBConnect();
    $link = $pdo->DBConnect();

    // 获得当前用户名的PDOStament对象
    $query = "SELECT * FROM userinfo WHERE Name='{$userName}'";
//        $query = "SELECT * FROM userinfo WHERE Name='{$userName}' AND "."Password='{$password}'";

    $result = $link->query($query);

    // 若查到记录，则设置SESSION，并进行页面重定向
    if($result) {
        foreach($result as $row) {
            // 向$data数组中读入用户信息数据
            //{"userName": "邓智容", "userType":"普通用户", "group": "厚朴工作室",
            // "job": "student", "userImageUrl": "http://dengzhr.com/dengzhirong.jpg"}
            $data["userName"] = $row["RealName"];
            $data["userType"] = getUserType($row["UserType"]);
            $data["group"] = getUserDepartment($row["DepartmentID"]);
            $data["job"] = $row["Job"];
            $data["userImageUrl"] = $row["UserImageUrl"];
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
    $isSetSession = (!isset($_SESSION['user_id']));
//    $isSetSession = (!isset($_SESSION['user_id']) && (int)$_SESSION['user_id'] > 0);
    return $isSetSession;
}

// 用户类型判断
function getUserType($userType) {
    switch($userType) {
        case 0:
            return "学生";
            break;
        case 1:
            return "老师";
            break;
        case 2:
            return "校外人员";
            break;
        default:
            return "未指定用户类型";
            break;
    }
}

// 用户所在部门判断
function getUserDepartment($departmentID) {
    switch($departmentID) {
        case 0:
            return "校外人员";
            break;
        case 1:
            return "厚朴工作室";
            break;
        case 2:
            return "院办";
            break;
        default:
            return "莱恩所";
            break;
    }
}
