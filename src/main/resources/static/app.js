var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect(r) {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        
        stompClient.subscribe('/topic/greetings/' + r, function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName(flight, r) {
    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val(), 'flight': flight, "session": r}));
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
	let r = Math.random().toString(36).substring(7);
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(r); });
    $( "#disconnect" ).click(function() { disconnect(); });
    //$( "#send" ).click(function() { sendName(); });
    $("#flightDrop").change(function () {
    	sendName($("#flightDrop").val(), r);
    });
});

