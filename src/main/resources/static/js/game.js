// Tạo ID ngẫu nhiên cho người chơi
const playerId = 'player_' + Math.random().toString(36).substring(2, 11);

// Kết nối WebSocket
const socket = new SockJS('/ws-wordguess');
const stompClient = Stomp.over(socket);

// Khi kết nối thành công
stompClient.connect({}, function (frame) {
    console.log('Connected: ' + frame);

    startNewGame();
    // Subscribe để nhận updates về session
    stompClient.subscribe('/topic/session', function (response) {
        const session = JSON.parse(response.body);
        if (session.status === 'PLAYING') {
            updateGameStatus(session);
        } else if (session.status === 'FINISHED') {
            updateGameStatus(session);
            let playerName = prompt("Please enter your name:", "");
            if (playerName === null || playerName === "") {
                playerName = "Anonymous";
            }
            alert('Hi ' + playerName + '. Game over! Your score: ' + session.score);
            stompClient.send("/app/end", {}, JSON.stringify({
                sessionId: session.id,
                playerName: playerName
            }));
            window.location.href = '/api/leaderboard';
        }
    });
});

// Hàm bắt đầu game mới
function startNewGame() {
    document.querySelector('#guess-word').value = '';
    stompClient.send("/app/start", {}, playerId);
}

// Hàm cập nhật trạng thái game
function updateGameStatus(session) {
    const statusDiv = document.getElementById('game-status');

    statusDiv.innerHTML = `
        <h2>Game Status</h2>
        Session ID: ${session.id}<br>
        Player ID: ${session.playerId}<br>
        Status: ${session.status}<br>
        Score: ${session.score}<br>
        Round: ${session.round}<br>
        Word Hint: ${session.currentWordHint}<br>
    `;

    // Log để debug
    console.log('Session updated:', session);
}

// Hàm đoán từ
function makeGuess() {
    const sessionId = document.querySelector('#game-status').textContent.match(/Session ID: (.*)/)[1];
    var word = document.querySelector('#guess-word').value;
    stompClient.send("/app/guess", {}, JSON.stringify({
        sessionId: sessionId,
        guessWord: word
    }));
}
