<?php
/**
 * Created by PhpStorm.
 * User: dengzhirong
 * Date: 15.12.15
 * Time: 9:57
 */
/*
 * 请求方法：POST
 * 请求体数据格式：{"uesrName": "dengzhirong", "password": "name"}
 * 验证客户端传来的数据
 * 当用户登录成功，跳转，并设置Session
 * */
include_once("../../data/DBConnect.php");

session_start();
// 页面使用utf-8编码格式
header("Content-Type: text/html; charset=UTF-8");
// 页面的访问域是任意的
header("Access-Control-Allow-Origin: *");

/*
 * 获取POST传递的参数
 * */
$userName="";
$password="";
if($_POST['userName'] && $_POST['password']) {
    $userName=trim($_POST['userName']);
    $password=trim($_POST['password']);
}

// 验证当前的session是否存在
if(!isset($_SESSION['user_id']) && (int)$_SESSION['user_id']>0){
    if(!empty($userName)&&!empty($password)){
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
                // 获取当前用户在数据库中保存的密码
                $dbPassword = $row["Password"];
                echo $dbPassword;
                if($dbPassword == md5($password)) {

                    // 设置Session，以及Session的过期时间
                    $_SESSION['user_id']=$row['user_id'];
                    $_SESSION['username']=$row['username'];

                    // 登录成功
                    loginSuccess();
                }else {
                    echo "密码有误，请重新输入。";
                }
            }
        }else{
            echo "用户名不存在，请注册。";
        }
    }else{
        echo "用户名或密码不能为空！";
    }
}else{
    //如果用户已经登录，则直接跳转到已经登录页面
    loginSuccess();
}

function loginSuccess() {
    $home_url = 'http://dengzhr.com';
    header('Location: '.$home_url);
    // echo "<script>window.location.href='http://dengzhr.com'</script>";
}
