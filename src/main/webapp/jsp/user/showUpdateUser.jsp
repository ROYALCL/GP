<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Content Manage——修改用户</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
    <meta http-equiv="description" content="This is my page"/>
    <link href="${ctx}/css/css.css" type="text/css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/js/ligerUI/skins/Aqua/css/ligerui-dialog.css"/>
    <link href="${ctx}/js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${ctx }/js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="${ctx }/js/jquery-migrate-1.2.1.js"></script>
    <script src="${ctx}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
    <script src="${ctx}/js/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script>
    <script src="${ctx}/js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
    <script src="${ctx}/js/ligerUI/js/plugins/ligerResizable.jss" type="text/javascript"></script>
    <link href="${ctx}/css/pager.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript">

        $(function () {
            /** 员工表单提交 */
            $("#userForm").submit(function () {
                var msg = "";
                if ($.trim($("#nickname").val()) == "") {
                    msg = "姓名不能为空！";
                    nickname.focus();
                } else if ($.trim($("#used").val()) == "") {
                    msg = "状态不能为空！";
                    used.focus();
                } else if ($.trim($("#name").val()) == "") {
                    msg = "登录名不能为空！";
                    name.focus();
                } else if ($.trim($("#password").val()) == "") {
                    msg = "密码不能为空！";
                    password.focus();
                } else if ($.trim($("#email").val()) == "") {
                    msg = "邮箱不能为空！";
                    email.focus();
                }
                if (msg != "") {
                    $.ligerDialog.error(msg);
                    return false;
                } else {
                    return true;
                }
                $("#userForm").submit();
            });
        });


    </script>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td height="10"></td>
    </tr>
    <tr>
        <td width="15" height="32"><img src="${ctx}/img/main_locleft.gif" width="15" height="32"></td>
        <td class="main_locbg font2"><img src="${ctx}/img/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：用户管理 &gt; 修改用户</td>
        <td width="15" height="32"><img src="${ctx}/img/main_locright.gif" width="15" height="32"></td>
    </tr>
</table>
<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
    <tr valign="top">
        <td>
            <form action="${ctx}/user/updateUser" id="userForm" method="post">
                <!-- 隐藏表单，flag表示添加标记 -->
                <input type="hidden" name="flag" value="2">
                <input type="hidden" name="id" value="${user.getId()}">
                <table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
                    <tr>
                        <td class="font3 fftd">
                            <table>
                                <tr>
                                    <td class="font3 fftd">登录名：<input name="name" id="name" size="20"
                                                                      value="${user.name }"/></td>
                                    <td class="font3 fftd">姓&nbsp;名：<input type="text" name="nickName" id="nickname"
                                                                           size="20"
                                                                           value="${user.nickName}"/></td>

                                    <td class="font3 fftd">密&nbsp;码：<input name="passWord"
                                                                           id="password"
                                                                           size="20"
                                                                           value="${user.passWord }"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="font3 fftd">创建时间：<f:formatDate value="${user.getCreateTime()}"
                                                                              type="date" dateStyle="long"/></td>
                                    </td>
                                    <td class="font3 fftd">邮&nbsp;箱：<input type="text" name="email" id="email" size="20"
                                                                           value="${user.email}"/></td>
                                    <td class="font3 fftd">性&nbsp;别：
                                        <select name="sex" style="width:143px;">
                                            <option value="0">--请选择性别--</option>
                                            <option value="M">男</option>
                                            <option value="F">女</option>
                                            <option value="S">保密</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="font3 fftd">使用状态：
                                        <select name="used" style="width:143px;">
                                            <option value="0">--请选择使用状态--</option>
                                            <option value="T">使用</option>
                                            <option value="F">未使用</option>
                                        </select>
                                    </td>
                                    <td class="font3 fftd">权&nbsp;限：
                                        <select name="role_id" style="width:143px;">
                                            <option value="0">--请选择权限--</option>
                                            <c:forEach items="${role }" var="role">
                                                <option value="${role.id }">${role.name }</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>

                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td class="main_tdbor"></td>
                    </tr>

                    <tr>
                        <td align="left" class="fftd"><input type="submit" value="修改 ">&nbsp;&nbsp;<input type="reset"
                                                                                                          value="取消 "
                                                                                                          href="${ctx}user/selectUser">
                        </td>
                    </tr>
                </table>
            </form>
        </td>
    </tr>
</table>
<div style="height:10px;"></div>
</body>
</html>