var webSocket;

var answerTable1;
var answerTable2;
var answerTable3;
var answerTable4;
var answerTable5;

var obj;

function openSocket(){
    webSocket = new WebSocket("ws://localhost:8080/echo");

    webSocket.onopen = function(event){
        //writeResponse("Connection opened");
        answerTable1 = document.getElementById("answer-table1");
        answerTable2 = document.getElementById("answer-table2");
        answerTable3 = document.getElementById("answer-table3");
        answerTable4 = document.getElementById("answer-table4");
        answerTable5 = document.getElementById("answer-table5");
    };

    webSocket.onmessage = function(obj){
        writeResponse(obj.data);
    };

    webSocket.onclose = function(event){
        //writeResponse("Connection closed");
    };
}

function sendComment(){
    var topic   = document.getElementById("topic").value;
    var name    = document.getElementById("name").value;
    var rating  = document.getElementById("rating").value;
    var comment = document.getElementById("comment").value;

    obj = { "topic":topic, "name":name, "rating":rating, "comment":comment};

    if(topic === "" || name === "" || rating === "" || comment === "") webSocket.send("NullException");
    else webSocket.send(JSON.stringify(obj));
}

function closeSocket(){
    webSocket.close();
}

function writeResponse(obj){
    obj = JSON.parse((obj));

    switch(obj.topic){
        case "1":
            answerTable1.innerHTML +=
                "<TR> <TD>" + obj.topic + "</TD> <TD>" + obj.name + "</TD> <TD>" + obj.rating + "</TD> <TD>" + obj.comment + "</TD> </TR>";
            break;
        case "2":
            answerTable2.innerHTML +=
                "<TR> <TD>" + obj.topic + "</TD> <TD>" + obj.name + "</TD> <TD>" + obj.rating + "</TD> <TD>" + obj.comment + "</TD> </TR>";
            break;
        case "3":
            answerTable3.innerHTML +=
                "<TR> <TD>" + obj.topic + "</TD> <TD>" + obj.name + "</TD> <TD>" + obj.rating + "</TD> <TD>" + obj.comment + "</TD> </TR>";
            break;
        case "4":
            answerTable4.innerHTML +=
                "<TR> <TD>" + obj.topic + "</TD> <TD>" + obj.name + "</TD> <TD>" + obj.rating + "</TD> <TD>" + obj.comment + "</TD> </TR>";
            break;
        case "5":
            answerTable5.innerHTML +=
                "<TR> <TD>" + obj.topic + "</TD> <TD>" + obj.name + "</TD> <TD>" + obj.rating + "</TD> <TD>" + obj.comment + "</TD> </TR>";
            break;
        default:
    }
}