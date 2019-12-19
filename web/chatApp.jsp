<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <c:choose>
        <c:when test="${user == null}">
            <meta http-equiv = "refresh" content = "0; url = /loggedOut.jsp" />
        </c:when>
    </c:choose>
    <title>Dylan's Chat App - Chat</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script type="text/javascript" src="js/status.js"></script>
    <script type="text/javascript" src="js/friends.js"></script>
    <script type="text/javascript" src="js/chat.js"></script>
</head>
<body onload="getFriends();" >
<input type="hidden" id="sessionuser" name="sessionuser" value="${user.getUserId()}">
<input type="hidden" id="receiveruser" name="receiveruser">
<div class="container-fluid h-100">
    <div class="row justify-content-center h-100">
        <div class="col-md-4 col-xl-3 chat"><div class="card mb-sm-3 mb-md-0 contacts_card">
            <!-- USER SECTION -->
            <div class="d-flex bd-highlight myMargin">
                <div class="img_cont">
                    <img src="https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg" class="rounded-circle user_img">
                    <span class="online_icon"></span>
                </div>
    <div class="user_info">
                    <span>${user.getFirstName()}</span>
                    <p id="status">${user.getStatus()}</p>
                    <button class="myButton" onclick="getUserInfo('${user.getUserId()}')">Show Info</button>
                </div>
            </div>
            <!-- SET STATUS -->
            <button class="myButton myMargin" onclick="setStatusToggle()" id="setStatusButton">Set Status</button>
            <div class="card-header hidden" id="setStatusInput">
                <div class="input-group">
                    <input type="text" placeholder="Set new status" id="newStatus" class="form-control search">
                    <div class="input-group-prepend">
                        <input class="input-group-text search_btn" type="submit" onclick="setStatus()" value="Set Status">
                    </div>
                </div>
            </div>
            <!-- ADD FRIEND -->
            <button class="myButton myMargin" onclick="addFriendToggle()" id="addFriendButton">Add Friend</button>
            <div class="card-header hidden" id="addFriendInput">
                <div class="input-group">
                    <input type="text" placeholder="Add new friend" id="newFriend" value="" class="form-control search">
                    <div class="input-group-prepend">
                        <input class="input-group-text search_btn" type="submit" onclick="addFriend()" value="Add Friend">
                    </div>
                </div>
            </div>
            <!-- FRIENDS -->
            <div class="card-body contacts_body">
                <ui class="contacts" id="friends"/>
            </div>
            <div class="card-footer">
                <form method="post" action="Controller?action=LogOut">
                    <p>
                        <input class="myButton" type="submit" id="logoutbutton" value="Log Out">
                    </p>
                </form>
            </div>
        </div></div>
        <!-- CHAT SECTION -->
        <div class="col-md-8 col-xl-6 chat hidden" id="chat-section">
            <div class="card">
                <div class="card-header msg_head">
                    <div class="d-flex bd-highlight">
                        <div class="img_cont" id="user-chatSection">
                            <img src="https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg" class="rounded-circle user_img">
                            <span class="online_icon"></span>
                        </div>
                        <div class="user_info">
                            <span id="chatter"></span>
                        </div>
                        <button class="closeChatButton" onclick="toggleChatSection();">Close Chat</button>
                    </div>
                </div>
                <!--CHAT MESSAGES-->
                <div class="card-body msg_card_body" id="messages"></div>
                <!--CHAT INPUT-->
                <div class="card-footer">
                    <div class="input-group">
                        <!--
                        <div class="input-group-append">
                            <span class="input-group-text attach_btn"><i class="fas fa-paperclip"></i></span>
                        </div>-->
                        <input name="" id="chatText" class="form-control type_msg" placeholder="Type your message...">
                        <div class="input-group-append">
                            <button class="input-group-text send_btn" type="submit" id="sendButton" onclick="send();"><i class="fas fa-location-arrow"></i></button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
