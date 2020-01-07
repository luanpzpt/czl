<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>文件上传</title>
    <script src="js/jquery.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function ajaxFun(){
            var test=$(" #test ").val();
            $.ajax({
                type: "POST",
                url: "TestServlet",
                data :"test="+test,
                dataType: "json",
                success: function(result){

                    $.each(result, function(i,item){
                        str =item.vote;
                        $("#results").append(str);
                    });
                }
            });
        }
    </script>

</head>
<body>
            <input type="text" value="17" onclick="ajaxFun()" name="test" id="test">
</body>
</html>