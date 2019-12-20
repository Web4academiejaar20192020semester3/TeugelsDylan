var getStatusRequest = new XMLHttpRequest();
var setStatusRequest = new XMLHttpRequest();

function getStatus() {
    getStatusRequest.open("GET", "Controller?action=GetStatus", true);
    getStatusRequest.onreadystatechange = getDataGetStatus;
    getStatusRequest.send(null)
}

function getDataGetStatus() {
    if(getStatusRequest.status === 200){
        if(getStatusRequest.readyState === 4){
            var person = JSON.parse(getStatusRequest.responseText);
            var div = document.getElementById("status");
            div.innerHTML = person.status;
        }
    }
}

function setStatus(){
    var newStatus = document.getElementById("newStatus").value;
    var info = "newStatus=" + newStatus;
    setStatusRequest.open("POST", "Controller?action=SetStatus", true);
    setStatusRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    setStatusRequest.send(info);
    setStatusRequest.onreadystatechange = getDataSetStatus;
}

function setStatusWithParameter(status){
    var info = "newStatus=" +  status;
    setStatusRequest.open("POST", "Controller?action=SetStatus", true);
    setStatusRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    setStatusRequest.send(info);
    setStatusRequest.onreadystatechange = getDataSetStatus;
}

function getDataSetStatus() {
    if(setStatusRequest.status === 200){
        if(setStatusRequest.readyState === 4){
            if(setStatusRequest.responseText === "Empty") alert("Fill in a status");
            else{
                document.getElementById("newStatus").value = "";
                getStatus();
            }
            setStatusToggle();
        }
    }
}

function getUserInfo(friend){
    $.get("Controller?action=GetUserInfo", {userInfo: friend}, function (data) {
        alert(JSON.stringify(data));
    })
}

function setStatusToggle(){
    $("#setStatusButton").toggle('hidden');
    $("#setStatusInput").toggle('hidden');
}

function dropdownStatus() {
    document.getElementById("newStatus").classList.toggle("show");
}
