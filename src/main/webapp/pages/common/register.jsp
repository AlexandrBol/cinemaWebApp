<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <jsp:include page="/pages/tmpl/headtag.jsp"/>
</head>

<body>
<jsp:include page="/pages/tmpl/head.jsp"/>
    <form name="registerForm" method="post" action="register">
        <div class="panel panel-success col-md-6">
            <div class="panel-header">Register</div>
            <div class="panel-body">
                <div class="col-md-6">
                    <input type="text"  placeholder="Login" class="form-control" name="login"/> <br/>
                </div>
                <div class="col-md-6">
                    <input type="passsword"  placeholder="Password" class="form-control" name="password"/> <br/>
                </div>
                <div class="col-md-6">
                    <input type="text"  placeholder="Email" class="form-control" name="email"/> <br/>
                </div>
                <div class="col-md-6">
                    <input type="text"  placeholder="First Name" class="form-control" name="firstName"/> <br/>
                </div>
                <div class="col-md-6">
                    <input type="text"  placeholder="Last Name" class="form-control" name="lastName"/> <br/>
                </div>
                <div class="col-md-6">
                    <input type="text"  placeholder="sex" class="form-control" name="sex"/> <br/>
                </div>
                <div class="col-md-6">
                    <input type="date"  placeholder="birthday" class="form-control" name="birthday"/> <br/>
                </div>
            </div>
            <div class="panel-footer text-right">
                <input class=" btn col-md-2 btn-success" type="submit" value="Register" />
            </div>
        </div>
    </form>
</div>
</body>
</html>