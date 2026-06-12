@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    /**
     * POST /api/pedidos
     * Crea un nuevo pedido, consulta productos via Feign y publica evento en RabbitMQ.
     *
     * Body ejemplo:
     * {
     *   "clienteId": 1,
     *   "detalles": [
     *     { "productoId": 3, "cantidad": 2 },
     *     { "productoId": 7, "cantidad": 1 }
     *   ]
     * }
     */
    @PostMapping
    public ResponseEntity<PedidoResponse> crearPedido(@RequestBody PedidoRequest request) {
        PedidoResponse response = pedidoService.crearPedido(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * GET /api/pedidos/{id}
     * Obtiene un pedido por su ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponse> obtenerPorId(@PathVariable Integer id) {
        PedidoResponse response = pedidoService.obtenerPorId(id);
        return ResponseEntity.ok(response);
    }

    /**
     * GET /api/pedidos/cliente/{clienteId}
     * Lista todos los pedidos de un cliente.
     */
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<PedidoResponse>> obtenerPorCliente(@PathVariable Integer clienteId) {
        List<PedidoResponse> pedidos = pedidoService.obtenerPorCliente(clienteId);
        return ResponseEntity.ok(pedidos);
    }
}