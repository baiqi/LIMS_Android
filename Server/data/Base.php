<?php
/**
 * Created by PhpStorm.
 * User: dengzhirong
 * Date: 15.12.15
 * Time: 11:51
 */

namespace data;
require_once("DbHelper.php");
require_once("DBConnect.php");

date_default_timezone_set("Asia/Shanghai");

class Base {
    public $id;
    //bit value is 0 or 1,default 1
    public $enable=1;

    protected $link;


    public function set($key,$val){
        if($key == "enable" || $key == "canPaging"){
            if(ord($val) ==1){
                $this->$key = 1;
            }else{
                $this->$key = 0;
            }
        }else{
            $this->$key = $val;
        }
    }

    public  function query($sql){
        //echo($sql);
        $pdo = new \DBConnect();

        if(!isset($this->link)){
            $this->link=$pdo->DBConnect();
        }
        $r=  $this->link->query($sql);

//        or die("Query {$this->getClassName()} Error!\n{$sql}\n".mysql_error());
        return $r;
    }

    //
    public function dataToObj($data){
        foreach($this as $key=>$value){
            if(isset($data[$key]))$this->set($key,$data[$key]);
        }
    }
    /**
     * @param int $Id
     * @return bool
     */
    public function getObjById($Id){
        $id=(int)$Id;
        $result = $this->query("SELECT * FROM ".$this->getClassName()." WHERE id={$id}");
        if($row = mysql_fetch_array($result,MYSQL_ASSOC)){
            $this->dataToObj($row);
            return true;
        }else{
            return false;
        }
    }

    /**
     * @param int $id
     * @return array|null
     */
    public function getDataById($id){
        $id=(int)$id;
        if($id<=0) return null;
        $result = $this->query("SELECT * FROM ".$this->getClassName()." WHERE id={$id}");
        if($row = mysql_fetch_array($result,MYSQL_ASSOC)){
            if(isset($row["enable"])) $row["enable"] = ord($row["enable"]) ==1 ? 1:0;
            if(isset($row["canPaging"])) $row["canPaging"] = ord($row["canPaging"]) ==1 ? 1:0;
            return $row;
        }
        return null;
    }

    public function getDateByIds($ids){
        $temp="";
        foreach($ids as $id){
            $id=(int)$id;
            if($id>0){
                if($temp){
                    $temp=$temp." OR id={$id}";
                }else{
                    $temp=$temp." id={$id}";
                }
            }
        }
        if($temp){
            $sql="SELECT * FROM ".$this->getClassName()." WHERE".$temp;
            $r=$this->query($sql);
            $list = array();
            while($row = mysql_fetch_array($r,MYSQL_ASSOC)){
                if(isset($row["enable"])) $row["enable"] = ord($row["enable"]) ==1 ? 1:0;
                if(isset($row["canPaging"])) $row["canPaging"] = ord($row["canPaging"]) ==1 ? 1:0;
                array_push($list,$row);
            }
            return $list;
        }
        return null;
    }

    public function getDateBySql($sql){
        $r=$this->query($sql);
        $list = array();
        while($row = mysql_fetch_array($r,MYSQL_ASSOC)){
            if(isset($row["enable"])) $row["enable"] = ord($row["enable"]) ==1 ? 1:0;
            if(isset($row["canPaging"])) $row["canPaging"] = ord($row["canPaging"]) ==1 ? 1:0;
            array_push($list,$row);
        }
        return $list;
    }


    /**
     * @param int $page  >=1
     * @param int $pageSize default 20
     * @return array
     */
    public function getDataByPage($page,$pageSize=20){
        $page=(int) $page;
        $pageSize=(int)$pageSize;
        $table=$this->getClassName();
        $sql="SELECT * FROM {$table} WHERE id <=(SELECT id FROM {$table} ORDER BY id DESC LIMIT ".($page-1)*$pageSize.",1)ORDER BY id DESC LIMIT {$pageSize}";
        $r=$this->query($sql);
        $list = array();
        while($row = mysql_fetch_array($r,MYSQL_ASSOC)){
            if(isset($row["enable"])) $row["enable"] = ord($row["enable"]) ==1 ? 1:0;
            if(isset($row["canPaging"])) $row["canPaging"] = ord($row["canPaging"]) ==1 ? 1:0;
            array_push($list,$row);
        }
        return $list;
    }

    /**
     * @param int $limit
     * @return array|null
     */
    public function getDateByLimit($limit=1000){
        $limit=(int)$limit;
        if($limit<=0) return null;
        $sql="SELECT * FROM ".$this->getClassName()." ORDER BY id DESC LIMIT {$limit}";
        $r=$this->query($sql);
        $list = array();
        while($row = mysql_fetch_array($r,MYSQL_ASSOC)){
            if(isset($row["enable"])) $row["enable"] = ord($row["enable"]) ==1 ? 1:0;
            if(isset($row["canPaging"])) $row["canPaging"] = ord($row["canPaging"]) ==1 ? 1:0;
            array_push($list,$row);
        }
        return $list;
    }

    //根据类名获取数据库表名
    protected   function getClassName(){
        $str=get_class($this);
        $temp=strtok($str,"\\");
        $arr=array();
        while($temp!==false){
            array_push($arr,$temp);
            $temp=strtok("\\");
        }
        return strtolower(array_pop($arr));
    }

    protected function getLastInsertId(){
        $sql_getId="SELECT LAST_INSERT_ID()";
        if($row=mysql_fetch_array($this->query($sql_getId))){
            return (int)$row[0];
        };
        return null;
    }
    //析构函数
    public function __destruct(){
        if(isset($this->link)){
//            mysql_close($this->link);
            $this->link = null;
        }
    }

    protected function strMysqlEscape($str){
        if(!$this->link) $this->link=DbHelper::getDbLink();
        return mysql_real_escape_string($str,$this->link);
    }
    /**
     * 字符串转为数组
     * @param $str
     * @return array
     */
    public static function dataToArray($str){
        if(!empty($str)){
            return explode(",",$str);
        }
        return array();
    }

    /**
     * @param $arr
     * @return string
     */
    public static function arrayToData($arr){
        if(empty($arr)) return "";
        array_multisort($arr,SORT_ASC,SORT_NUMERIC);
        return join(",",$arr);
    }

}