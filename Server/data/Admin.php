<?php
/**
 * Created by PhpStorm.
 * User: dengzhirong
 * Date: 15.12.15
 * Time: 11:48
 */
namespace data;
include_once("Base.php");
include_once("DbHelper.php");

Class Admin extends Base {
    public $name;
    public $password;
    public $addTime;
    public $lastLoginTime;

    public function getAdminByName($name) {
        $name=$this->name;
        $result = $this->query("SELECT * FROM userinfo WHERE Name='{$name}'");

        if($row = $result->fetch()){
            $this->password = $row["Password"];
            $this->dataToObj($row);
            return $this;
        }else{
            return null;
        }
    }
}