let rover = { x: 0, y: 0 };
let obstacles = [];

// Mover rover
function moveRover() {
    const roverEl = document.getElementById("movil");
    roverEl.style.left = rover.x * 100 + 'px';
    roverEl.style.top = rover.y * 100 + 'px';

    // Rotar según la dirección
    switch (rover.direction) {
        case 'NORTH':
            roverEl.style.transform = 'rotate(0deg)';
            break;
        case 'EAST':
            roverEl.style.transform = 'rotate(90deg)';
            break;
        case 'SOUTH':
            roverEl.style.transform = 'rotate(180deg)';
            break;
        case 'WEST':
            roverEl.style.transform = 'rotate(270deg)';
            break;
    }

    updateRoverInfo();
}

// Mostrar posición del rover
function updateRoverInfo() {
    document.getElementById('info-posicion').value = `X: ${rover.x} | Y: ${rover.y}`;
}

// Crear roca con imagen
function createRock(x, y) {
    const rock = document.createElement('img');
    rock.src = './img/rock.png';
    rock.classList.add('rock');
    rock.style.position = 'absolute';
    rock.style.left = x * 100 + 'px';
    rock.style.top = y * 100 + 'px';
    rock.style.width = '100px';
    rock.style.height = '100px';
    rock.style.zIndex = 5;
    document.getElementById('fondo-contenedor').appendChild(rock);
}

// Inicializar mapa
async function createMap() {
    // Obtener rover
    const roverResponse = await fetch('/api/rover/', {
        method: 'GET',
        headers: { 'Content-Type': 'application/json' }
    });
    const roverJson = await roverResponse.json();
    rover.x = roverJson.x;
    rover.y = roverJson.y;
    rover.direction = roverJson.direction;
    moveRover();

    // Obtener obstáculos
    const obstacleResponse = await fetch('/api/obstacle/', {
        method: 'GET',
        headers: { 'Content-Type': 'application/json' }
    });
    const obstaclesJson = await obstacleResponse.json();
    obstacles = obstaclesJson;
    obstacles.forEach(obstacle => createRock(obstacle.x, obstacle.y));
    
moveRover();
}

createMap();

