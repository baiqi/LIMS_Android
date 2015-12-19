<?php
/**
 * Created by PhpStorm.
 * User: dengzhirong
 * Date: 15.12.11
 * Time: 20:42
 */

header('COntent-Type:text/html;charset=utf-8');

//$db = new mysqli("localhost", "lims", "lims", "lims");
$db = new PDO("mysql:host=localhost;port=3306;dbname=lims", "lims", "lims");

//@ $dbo = mysqli_connect("localhost", "lims", "lims", "lims");

$query = "SELECT * FROM userinfo";

$db->query("SET NAMES 'UTF8'");

$result = $db->query($query);

if($result) {
    $num_results = $result->rowCount();
    for($i = 0; $i < $num_results; $i++) {
        $row = $result->fetch();
        echo $row["RealName"];
    }
}




