<?php
    $page  = isset($__POST['page'])?intval($__POST['page']):1;
    $rows = isset($_POST['rows']) ? intval($_POST['rows']) : 10;
    $offset=($page-1)*$rows;
    $result=array();
    
    include 'conn.php';
    
    $rs=mysql_query("select count(*) from Storage");
    $row = mysql_fetch_row($rs);
    $result["total"]=$row[0];
    $rs=mysql_query("select * from Storage limit $offset,$rows");
    
    $item=array();
    while($row=mysql_fetch_object($rs)){
    	array__push($item,$row);
    }
    $result["row"]=$items;
    echo json__encode($result);
    
    ?>
    