$(document).ready(function () {
  const $movil = $('#movil');
  const $contenedor = $('#fondo-contenedor');

  const gridSize = 150;
  let posX = 0;
  let posY = 0;

  // Orientación actual en grados (0 = NORTH, 90 = EAST, 180 = SOUTH, 270 = WEST)
  let orientacion = 0;

  const $textarea = $('#area-instrucciones');
  const $infoPosicion = $('#info-posicion');

  function gradosAOrientacionTexto(grados) {
    grados = ((grados % 360) + 360) % 360;
    switch (grados) {
      case 0: return "NORTH";
      case 90: return "EAST";
      case 180: return "SOUTH";
      case 270: return "WEST";
      default: return grados + "°";
    }
  }

  function actualizarEstado(obstaculo = false) {
    let estado = `INITIAL POSITION: (0,0)\n`;
    estado += `ACTUAL POSITION: (${posX},${posY})\n`;
    estado += `ORIENTATION: ${gradosAOrientacionTexto(orientacion)}\n`;
    estado += `OBSTACLE: ${obstaculo ? 'YES' : 'NO'}`;
    $infoPosicion.val(estado);
  }

  actualizarEstado();

  function resaltarBoton($btn) {
    $('#botones-direccionales button').removeClass('active');
    if ($btn) $btn.addClass('active');
  }

  // Mapea dx, dy a grados según orientación (0° = NORTH)
  function direccionAGrados(dx, dy) {
    if (dx === 0 && dy === -1) return 0;     // NORTH
    if (dx === 1 && dy === 0) return 90;     // EAST
    if (dx === 0 && dy === 1) return 180;    // SOUTH
    if (dx === -1 && dy === 0) return 270;   // WEST
    return orientacion; // si no coincide, retorna orientación actual
  }

  // Diferencia mínima entre ángulos (-180..180)
  function diferenciaAngulo(objetivo, actual, posX, posY) {
    let diff = objetivo - actual;
    while (diff > 180) diff -= 360;
    while (diff < -180) diff += 360;

    // Forzar giro a la izquierda cuando se va de 0 a 270
    if (actual === 0 && objetivo === 270) {
      diff = -90;  // izquierda
    }
    // Forzar giro a la derecha cuando se va de 270 a 0
    else if (actual === 270 && objetivo === 0) {
      diff = 90;   // derecha
    }

    // Ajustes para bordes y giros más naturales:
    if (posY === 0) {
      // Caso mover de EAST (90) a WEST (270) en borde norte
      if (actual === 90 && objetivo === 270) {
        diff = 180;
      }
      // Caso mover de WEST (270) a EAST (90) en borde norte
      else if (actual === 270 && objetivo === 90) {
        diff = -180;
      }
    }

    return diff;
  }

  // Según diferencia, retorna comando simple
  function comandoSimple(dx, dy, orientActual, posX, posY) {
    const objetivo = direccionAGrados(dx, dy);
    if (objetivo === orientActual) {
      return "FORWARD";
    }
    const diff = diferenciaAngulo(objetivo, orientActual, posX, posY);

    switch(diff) {
      case 0: return "FORWARD";
      case 90: return "LEFT";
      case -90: return "RIGHT";
      case 180:
      case -180: return "BACK";
      default: return "FORWARD";
    }
  }

  function mover(dx, dy, $btn) {
    const containerWidth = $contenedor.innerWidth();
    const containerHeight = $contenedor.innerHeight();

    const maxXPos = Math.floor((containerWidth - gridSize) / gridSize);
    const maxYPos = Math.floor((containerHeight - gridSize) / gridSize);

    const prevX = posX;
    const prevY = posY;

    const objetivo = direccionAGrados(dx, dy);

    // Guardar orientación previa antes de actualizar
    const orientacionPrev = orientacion;

    // Calcular diferencia y actualizar orientación
    const diff = diferenciaAngulo(objetivo, orientacionPrev, posX, posY);

    if (diff !== 0) {
      orientacion = (orientacion + diff + 360) % 360;
    }

    // Obtener comando con orientación previa (antes del giro)
    const comando = comandoSimple(dx, dy, orientacionPrev, posX, posY);

    // Actualizar posición
    posX += dx;
    posY += dy;

    if (posX < 0) posX = 0;
    if (posY < 0) posY = 0;
    if (posX > maxXPos) posX = maxXPos;
    if (posY > maxYPos) posY = maxYPos;

    let obstaculo = (posX === prevX && posY === prevY && (dx !== 0 || dy !== 0));

    $movil.css({
      left: (posX * gridSize) + 'px',
      top: (posY * gridSize) + 'px',
      transform: `rotate(${orientacion + 180}deg)`
    });

    let textoActual = $textarea.val();
    textoActual += comando + '\n';
    $textarea.val(textoActual);
    $textarea.scrollTop($textarea[0].scrollHeight);

    actualizarEstado(obstaculo);
    resaltarBoton($btn);
  }

  // Botones
  $('#btn-up').click(function () { $(this).blur(); mover(0, -1, $(this)); });
  $('#btn-left').click(function () { $(this).blur(); mover(-1, 0, $(this)); });
  $('#btn-down').click(function () { $(this).blur(); mover(0, 1, $(this)); });
  $('#btn-right').click(function () { $(this).blur(); mover(1, 0, $(this)); });

  // Teclado
  let teclaPresionada = false;
  $(document).on('keydown', function (e) {
    if (teclaPresionada) return;
    switch (e.key) {
      case "ArrowUp":
        e.preventDefault();
        teclaPresionada = true;
        mover(0, -1, $('#btn-up'));
        break;
      case "ArrowLeft":
        e.preventDefault();
        teclaPresionada = true;
        mover(-1, 0, $('#btn-left'));
        break;
      case "ArrowDown":
        e.preventDefault();
        teclaPresionada = true;
        mover(0, 1, $('#btn-down'));
        break;
      case "ArrowRight":
        e.preventDefault();
        teclaPresionada = true;
        mover(1, 0, $('#btn-right'));
        break;
    }
  });
  $(document).on('keyup', function (e) {
    if (["ArrowUp", "ArrowLeft", "ArrowDown", "ArrowRight"].includes(e.key)) {
      teclaPresionada = false;
    }
  });
});
