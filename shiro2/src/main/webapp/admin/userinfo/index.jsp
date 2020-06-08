<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
</head>
<body>
<table border="1" width="100%" id="tab">
    <tr>
        <td>uid</td>
        <td>uname</td>
        <td>upass</td>
        <td>role</td>
        <td>状态</td>
    </tr>
</table>
<a href="input.jsp">save</a>
</body>
</html>
<script>
    $(function(){
        findAll();
    })

    function findAll(){
        $.getJSON("findAll",{},function(json){
            $.each(json, function(i,item){
                let state = "已删除";
                if(item.isdelete==null||item.isdelete==false){
                    state = "正常";
                }
                $("#tab").append("<tr><td>"+item.uid+"</td><td>"+item.uname+"</td><td>"+item.upass+"</td><td>"+item.roles+"</td><td>"+state+"</td></tr>");
            });
        })
    }
</script>
