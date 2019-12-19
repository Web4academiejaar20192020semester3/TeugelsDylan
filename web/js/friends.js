var FriendRequest = new XMLHttpRequest();
var AddFriendRequest = new XMLHttpRequest();
var OnlineFriendsRequest = new XMLHttpRequest();

function getFriends(){
    FriendRequest.open("GET", "Controller?action=GetFriends", true);
    FriendRequest.onreadystatechange = getDataGetFriends;
    FriendRequest.send(null);
}

function getDataGetFriends(){
    if(FriendRequest.status === 200) {
        if (FriendRequest.readyState === 4) {
            var friends = JSON.parse(FriendRequest.responseText);
            var ui = document.getElementById("friends");

            var list = document.createElement("div");

            friends.forEach(function (friend) {
                var p = document.createElement("p");
                p.innerHTML = "";
                if(friend.status !== "Offline"){
                    p.innerHTML = "<span class=\"online_icon\"></span>";
                    document.getElementById("user-chatSection").innerHTML = "<img src=\"https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg\" class=\"rounded-circle user_img\">\n" +
                        "                            <span class=\"online_icon\"></span>";
                }else{
                    document.getElementById("user-chatSection").innerHTML = "<img src=\"https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg\" class=\"rounded-circle user_img\">";
                }

               list.innerHTML +=        "<li class=\"active\">\n" +
                   "                        <div class=\"d-flex bd-highlight\">\n" +
                   "                            <div class=\"img_cont\">\n" +
                   "                                <img src=\"https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg\" class=\"rounded-circle user_img\">\n" +
                                                    p.innerHTML +
                   "                            </div>\n" +
                   "                            <div class=\"user_info\">\n" +
                   "                                <span>" + friend.firstName + " " + friend.lastName +  "</span>\n" +
                   "                                <p>" + friend.status + "</p>\n" +
                   "                                <button onclick='getUserInfo(\"" + friend.userId + "\")'>Show Info</button>\n" +
                   "                                <button style='margin: 5px' onclick='startNewChat(\"" + friend.userId + "\")'>Start Chat</button>\n" +
                   "                                <input type='hidden' id='receiverId' value='"+ friend.userId + "'>" +
                   "                            </div>\n" +
                   "                        </div>\n" +
                   "                    </li>"
            });

            ui.innerHTML = list.innerHTML;

            setTimeout(getFriends, 3000);
        }
    }
}
//----------------

function addFriend(){
    var newFriend = document.getElementById("newFriend").value;
    var info = "newFriend=" + newFriend;
    AddFriendRequest.open("POST", "Controller?action=AddFriend", true);
    AddFriendRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    AddFriendRequest.send(info);
    AddFriendRequest.onreadystatechange = getDataAddFriend;
    addFriendToggle();
}

function getDataAddFriend(){
    if(AddFriendRequest.status === 200){
        if(AddFriendRequest.readyState = 4){
            getFriends();
        }
    }
}

function addFriendToggle(){
    $("#addFriendButton").toggle('hidden');
    $("#addFriendInput").toggle('hidden');
}

//---------------

function getOnlineFriends(){
    OnlineFriendsRequest.open('GET', 'Controller?action=GetOnlineFriendsHandler', 'true');
    OnlineFriendsRequest.onreadystatechange = getDataOnlineFriends;
    OnlineFriendsRequest.send(null);
}

function getDataOnlineFriends() {
    if(OnlineFriendsRequest.status === 200){
        if(OnlineFriendsRequest.readyState === 4){
            var onlineFriends = JSON.parse(OnlineFriendsRequest.responseText)
            var p = document.getElementById("onlineFriends");
            p.innerHTML = "<p>Online Friends: " + onlineFriends[0] + "</p>" +
                "<p>Offline Friends: " + onlineFriends[1] + "</p>"

        }
        setTimeout(getOnlineFriends, 3000);
    }
}

//-------------------

