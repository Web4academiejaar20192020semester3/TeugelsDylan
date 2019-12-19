var firstTime = 1;

function startNewChat(friend){
    var receiver = friend;
    $.ajax({
        type: "GET",
        url: "Controller?action=CheckChatPartner",
        data:{
            sender: document.getElementById("sessionuser").value,
            receiver : friend
        },
        dataType: "text",
        success: function (text) {
            if(text === "emptyField") alert("Empty field");
            else if(text === "notInDb") alert("User not found");
            else if(text === "notAsFriend") alert("User isn't your friend");
            else{
                document.getElementById("receiveruser").value = receiver;
                document.getElementById("chatter").innerHTML = document.getElementById("receiveruser").value;
                if(firstTime){
                    getMessages();
                    firstTime = 0;
                }
                if (window.getComputedStyle(document.getElementById("chat-section")).display === "none") {
                    toggleChatSection();
                }


            }
        },
        error: function(data) {
            firstTime = 1;
        }
    });
}

function getMessages(){
    var messages = document.getElementById("messages");
    var sender = document.getElementById("sessionuser").value;
    $.ajax({
        type: "GET",
        url: "Controller?action=GetMessages",
        data: {

            sender: document.getElementById("sessionuser").value,
            receiver: document.getElementById("receiveruser").value
        },
        dataType: "json",
        success: function (json) {
            messages.innerHTML = "";
            for(var i = 0; i < json.length; i++){
                if(json[i].sender.userId === sender) {
                    messages.innerHTML += "<div class=\"d-flex justify-content-end mb-4\">\n" +
                        "                        <div class=\"msg_cotainer_send\">\n" +
                        "                            " + json[i].message + "\n" +
                        "                            <span class=\"msg_time_send\">You</span>\n" +
                        "                        </div>\n" +
                        "                        <div class=\"img_cont_msg\">\n" +
                        "                            <img src=\"https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg\" class=\"rounded-circle user_img_msg\">\n" +
                        "                        </div>\n" +
                        "                    </div>"
                }else{
                    messages.innerHTML += "<div class=\"d-flex justify-content-start mb-4\">\n" +
                        "                        <div class=\"img_cont_msg\">\n" +
                        "                            <img src=\"https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg\" class=\"rounded-circle user_img_msg\">\n" +
                        "                        </div>\n" +
                        "                        <div class=\"msg_cotainer\">\n" +
                        "                            " + json[i].message + "\n" +
                        "                            <span class=\"msg_time\">" + json[i].sender.firstName + "</span>\n" +
                        "                        </div>\n" +
                        "                    </div>"
                }
            }

            setTimeout(getMessages, 500);
        },
        error: function () {
            alert("Failed to get messages");
        }
    })
}

function send() {
    var message = document.getElementById("chatText").value;
    var messages = document.getElementById("messages");

    $.ajax({
        type: "POST",
        url: "Controller?action=SendMessage",
        data: {
            sender: document.getElementById("sessionuser").value,
            receiver: document.getElementById("receiveruser").value,
            message: message
        },
        dataType: "json",
        success: function (json) {
            messages.innerHTML += "<div class=\"d-flex justify-content-end mb-4 message\">\n" +
                "                        <div class=\"msg_cotainer_send\">\n" +
                "                            " + message + "\n" +
                "                            <span class=\"msg_time_send\">You</span>\n" +
                "                        </div>\n" +
                "                        <div class=\"img_cont_msg\">\n" +
                "                            <img src=\"https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg\" class=\"rounded-circle user_img_msg\">\n" +
                "                        </div>\n" +
                "                    </div>";
            document.getElementById("chatText").value = "";
            scrollToBottom();
        },
        error: function () {
            alert("failed sending message");
        }
    })
}

function scrollToBottom() {
        messages.scrollTop = messages.scrollHeight;
}

function toggleChatSection(){
    $("#chat-section").toggle('hidden');
}

//-------------