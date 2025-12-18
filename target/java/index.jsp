<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>2048 Game</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #faf8ef;
            text-align: center;
        }
        .grid-container {
            display: grid;
            grid-template-columns: repeat(4, 100px);
            grid-gap: 10px;
            margin: 20px auto;
            width: 440px;
        }
        .grid-cell {
            width: 100px;
            height: 100px;
            background-color: #eee4da;
            font-size: 55px;
            line-height: 100px;
            color: #776e65;
            border-radius: 5px;
        }
        .score {
            font-size: 24px;
            margin: 20px;
        }
    </style>
</head>
<body>
    <h1>2048 Game</h1>
    <div class="score">Score: <span id="score">0</span></div>
    <div class="grid-container" id="grid"></div>
    <button onclick="startGame()">New Game</button>

    <script>
        let grid = [];
        let score = 0;

        function startGame() {
            grid = Array.from({ length: 4 }, () => Array(4).fill(0));
            score = 0;
            document.getElementById('score').innerText = score;
            generateTile();
            generateTile();
            drawGrid();
        }

        function generateTile() {
            let emptyCells = [];
            for (let r = 0; r < 4; r++) {
                for (let c = 0; c < 4; c++) {
                    if (grid[r][c] === 0) emptyCells.push({ r, c });
                }
            }
            if (emptyCells.length) {
                let { r, c } = emptyCells[Math.floor(Math.random() * emptyCells.length)];
                grid[r][c] = Math.random() < 0.9 ? 2 : 4;
            }
        }

        function drawGrid() {
            const gridElement = document.getElementById('grid');
            gridElement.innerHTML = '';
            for (let r = 0; r < 4; r++) {
                for (let c = 0; c < 4; c++) {
                    const cell = document.createElement('div');
                    cell.className = 'grid-cell';
                    cell.innerText = grid[r][c] === 0 ? '' : grid[r][c];
                    gridElement.appendChild(cell);
                }
            }
        }

        document.addEventListener('keydown', (event) => {
            if (event.key === 'ArrowUp') moveUp();
            else if (event.key === 'ArrowDown') moveDown();
            else if (event.key === 'ArrowLeft') moveLeft();
            else if (event.key === 'ArrowRight') moveRight();
        });

        function moveUp() {
            // Implement move up logic
        }

        function moveDown() {
            // Implement move down logic
        }

        function moveLeft() {
            // Implement move left logic
        }

        function moveRight() {
            // Implement move right logic
        }
    </script>
</body>
</html>
