<%-- 
    Document   : menu_nav
    Created on : Jun 3, 2014, 4:23:55 PM
    Author     : Welcomes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu nav</title>
        <link href="../css/bootstrap-theme.css" rel="stylesheet"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <link href="../css/bootstrap.css" rel="stylesheet"/>
        <link href="../css/blog.css" rel="stylesheet"/>
    </head>
    <body>
        <div class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div class="navbar-collapse collapse">
                    <div class="col-md-8">
                        <ul class="nav navbar-nav">

                            <li class="active"><a href="/project1/home.jsp">Trang chủ</a></li>
                            <li><a href="/project1/Page?p=about">Giới thiệu</a></li>
                            <li><a href="/project1/Page?p=seach-cb">Tìm kiếm</a></li>
                            <li><a href="/project1/Page?p=contact">Liên Hệ</a></li>
                             <li><a href="/project1/admin.jsp">Quản trị</a></li>
                        </ul>
                    </div>
                </div><!--/.nav-collapse -->
            </div><!--/.container-fluid -->
        </div>
        <script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="../js/bootstrap.min.js"></script>
    </body>
</html>
