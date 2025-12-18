let board = [];
let score = 0;
let gameEnded = false;

// ================= START GAME =================
function startGame() {
    board = Array(16).fill(0);
    score = 0;
    gameEnded = false;
    addNumber();
    addNumber();
    drawBoard();
}

// ================= ADD RANDOM TILE =================
function addNumber() {
    let empty = board
        .map((v, i) => v === 0 ? i : null)
        .filter(v => v !== null);

    if (empty.length === 0) return;

    let index = empty[Math.floor(Math.random() * empty.length)];
    board[index] = Math.random() > 0.9 ? 4 : 2;
}

// ================= DRAW BOARD =================
function drawBoard() {
    const grid = document.getElementById("grid");
    grid.innerHTML = "";

    board.forEach(value => {
        let cell = document.createElement("div");
        cell.className = "cell";
        cell.innerText = value === 0 ? "" : value;
        grid.appendChild(cell);
    });

    document.getElementById("score").innerText = score;
}

// ================= MOVE RIGHT =================
function moveRight() {
    for (let i = 0; i < 16; i += 4) {
        let row = board.slice(i, i + 4).filter(x => x);

        for (let j = row.length - 1; j > 0; j--) {
            if (row[j] === row[j - 1]) {
                row[j] *= 2;
                score += row[j];
                row[j - 1] = 0;
            }
        }

        row = row.filter(x => x);
        while (row.length < 4) row.unshift(0);

        board.splice(i, 4, ...row);
    }
}

// ================= KEYBOARD CONTROL =================
document.addEventListener("keydown", function (e) {
    if (gameEnded) return;

    if (e.key === "ArrowRight") {
        moveRight();
        addNumber();
        drawBoard();

        if (isGameOver()) {
            gameOver();
        }
    }
});

// ================= GAME OVER CHECK =================
function isGameOver() {
    return !board.includes(0);
}

// ================= GAME OVER =================
function gameOver() {
    if (gameEnded) return;
    gameEnded = true;

    alert("Game Over! Your score: " + score);
    saveScore();
}

// ================= SEND SCORE TO SERVLET =================
function saveScore() {
    fetch("saveScore", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: "score=" + score
    })
    .then(res => res.text())
    .then(data => console.log("Score saved:", data))
    .catch(err => console.error("Error:", err));
}
