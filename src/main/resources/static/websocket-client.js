var stompClient = null;

function connect() {
    var socket = new SockJS('/websocket-client');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function () {
        stompClient.subscribe('/topic/logs', function (response) {
            showMessage(JSON.parse(response.body));
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
}

function sendMessage() {
    var message = document.getElementById('message').value;
    stompClient.send("/app/addLog", {}, JSON.stringify({ content: message }));
}

function showMessage(message) {
    var messageDiv = document.getElementById('messages');
    messageDiv.innerHTML += '<p>' + message.content + '</p>';
}
function getLogs() {
    stompClient.send("/app/logs", {}, JSON.stringify({ command: "logs" }));
}

connect();
