<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>

<form method="post" action="">
    uname	<input type="text" id="uname"><br>
    upass	<input type="text" id="upass"><br>
    请选择你要的角色：
    <div id="roles">
    </div>
    <input type="button" value="增加" onclick="dosave()">
</form>
<script>
    $(function(){
       findRoles();
    });

    function dosave(){
        var  uname = $("#uname").val();
        var  upass = $("#upass").val();

        var rids = [];
        $("input[name='rids']:checked").each(function(i){
            rids.push($(this).val())
        })
        rids =  rids+"";
        console.log(uname+"   "+upass+" "+rids);

        $.post("save",{uname:uname,upass:upass,rids:rids},function(){
            console.log("success");
        });
    }

    function findRoles(){
        $.getJSON("findRoles",{},function(json){
            $.each(json, function(i,item){
               $("#roles").append("<input type=\"checkbox\" name=\"rids\" value=\""+item.rid+"\">"+item.rolename+"");
            });
        });
    }
</script>
