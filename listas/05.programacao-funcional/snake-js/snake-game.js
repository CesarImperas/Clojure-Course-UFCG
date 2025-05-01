/* Snake Game Functional in JavaScript - Caio Cesar Vieira Cavalcanti - 123110825 - 30/4/2025 */

// ---------------------------------------------------------------------
/* States and constants initialization */
// ---------------------------------------------------------------------

const readline = require('readline');
const { stdin, stdout } = process;

const WIDTH = 20;
const HEIGHT = 10;
const TICKRATE = 300;

const directions = {
	UP: [0, -1],
	DOWN: [0, 1],
	LEFT: [-1, 0],
	RIGHT: [1, 0]
};

const opposites = {
	UP: 'DOWN',
	DOWN: 'UP',
	LEFT: 'RIGHT',
	RIGHT: 'LEFT'
};

const initialState = {
	snake: [ { x: 5, y: 5 }],
	direction: 'RIGHT',
	food: { x: 10, y: 5 },
	gameOver: false,
	history: []
};


// ---------------------------------------------------------------------
/* Functions and Game Initialization */
// ---------------------------------------------------------------------

function moveHead(head, dir) {
	const [dx, dy] = directions[dir];
	return { x: head.x + dx, y: head.y + dy };
}

function isCollision(pos, snake) {
	return (
		pos.x < 0 || pos.x >= WIDTH ||
		pos.y < 0 || pos.y >= HEIGHT ||
		snake.some(seg => seg.x === pos.x && seg.y === pos.y)
	);
}

function generateFood(snake) {
	let pos;
	do {
		pos = { x: Math.floor(Math.random() * WIDTH),
			y: Math.floor(Math.random() * HEIGHT) };
	} while (snake.some(seg => seg.x === pos.x && seg.y === pos.y));
	return pos;
}

function updateState(prev) {
	const head = moveHead(prev.snake[0], prev.direction);
	const ate = head.x === prev.food.x && head.y === prev.food.y;
	const newSnake = [head, ...prev.snake.slice(0, ate ? undefined : -1)];
	const dead = isCollision(head, prev.snake);

	return {
		...prev,
		snake: newSnake,
		food: ate ? generateFood(newSnake) : prev.food,
		gameOver: dead,
		history: [...prev.history, prev]
	};
}

/* Terminal */
function render(state) {
	stdout.write('\x1B[H');
	for (let y = 0; y < HEIGHT; y++) {
		let line = '';
		for(let x = 0; x < WIDTH; x++) {
			const isHead = x === state.snake[0].x && y === state.snake[0].y;
			const isBody = state.snake.slice(1).some(s => s.x === x && s.y === y);
			const isFood = state.food.x === x && state.food.y === y;
			line += isHead ? 'S' : isBody ? 's' : isFood ? '*' : '-';
		}
		console.log(line);
	}
}

/* Input - Keyboard WASD */
function startInput(directionChange) {
	stdin.setRawMode(true);
	stdin.resume();
	stdin.setEncoding('utf8');
	stdin.on('data', key => {
		if (key === '\u0003') process.exit(); // Ctrl + C - End game
		const dirMap = { w: 'UP', a: 'LEFT', s: 'DOWN', d: 'RIGHT' };
		const newDir = dirMap[key];
		if (newDir) directionChange(newDir);
	});
}

/* Game Loop */
function gameLoop(initialState) {
	console.clear();

	let currentState = initialState;
	let nextDirection = currentState.direction;

	startInput(newDir => {
		if (opposites[newDir] !== currentState.direction) {
			nextDirection = newDir;
		}
	});

	const interval = setInterval( () => {
		currentState = {
			...currentState,
			direction: nextDirection
		};

		currentState = updateState(currentState);
		render(currentState);
		
		if(currentState.gameOver) {
			clearInterval(interval);
			console.log('\nGame Over! Well played');
			console.log('Replay in 3 seconds...');
			setTimeout( () => {
				console.clear();
				replay(currentState.history);
			}, 3000);
		}
	}, TICKRATE);
}

/* Replay */
function replay(history) {
	let i = 0;
	const replayInterval = setInterval( () => {
		if(i >= history.length) {
			clearInterval(replayInterval);
			console.log('Replay finished');
			console.log('Thanks for playing the Snake Game by Caio Cesar s2');
			process.exit();
		} else {
			render(history[i]);
			i++;
		}
	}, 300);
}


/* Start the game */
gameLoop(initialState);
