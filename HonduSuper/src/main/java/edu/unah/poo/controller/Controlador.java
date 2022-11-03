package edu.unah.poo.controller;

import java.time.LocalDate; 

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.unah.poo.model.Cliente;
import edu.unah.poo.model.DetalleFactura;
import edu.unah.poo.model.Empleado;
import edu.unah.poo.model.Factura;
import edu.unah.poo.model.IdDetalleFactura;
import edu.unah.poo.model.IdProvee;
import edu.unah.poo.model.Producto;
import edu.unah.poo.model.Provee;
import edu.unah.poo.model.Proveedor;

import edu.unah.poo.service.ServiceCliente;
import edu.unah.poo.service.ServiceDetalleFactura;
import edu.unah.poo.service.ServiceEmpleado;
import edu.unah.poo.service.ServiceFactura;
import edu.unah.poo.service.ServiceProducto;
import edu.unah.poo.service.ServiceProvee;
import edu.unah.poo.service.ServiceProveedor;


@Controller
public class Controlador {
	
	@Autowired
	ServiceCliente serviceCliente;
	
	@Autowired
	ServiceEmpleado serviceEmpleado;
	
	@Autowired
	ServiceProducto serviceProducto;
	
	@Autowired
	ServiceProveedor serviceProveedor;
	
	@Autowired
	ServiceFactura serviceFactura;
	
	@Autowired
	ServiceDetalleFactura serviceDetalleFactura;
	
	@Autowired
	ServiceProvee serviceProvee;
	
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	//====================================================================
    // Security
	//====================================================================
	
	/*
	 * @RequestMapping(value = "/encriptar", method = RequestMethod.GET)
	 * public String encriptarContrasenia() {
		List<Empleado> lista = this.serviceEmpleado.obtenerTodosEmpleado();
		String contrasenia;
		for(Empleado e: lista) {
			contrasenia = passwordEncoder.encode("123");
			System.out.println("123 " + "pasa a " + contrasenia);
			e.setContrasenia(contrasenia);
			this.serviceEmpleado.crearEmpleado(e);
		}
		return "encriptar";
		
	}
	 */
	 
	
	
	
	 //====================================================================
	 //                       Inicio
	 //====================================================================
	@GetMapping("/")
	public String inicio() {
		return "inicio";
	}
	
	 //====================================================================
	 //                       Empleado
	//esta clase se creo solo con la finalidad de implementar el security del proyecto
	 //====================================================================
	
		@GetMapping("/empleado/registroEmpleado")
		public String registrarEmpleado() {
			return "registrarEmpleado";
		}

		@GetMapping("/empleado/detalle/{id}")
		public String registrarEmpleador(@PathVariable("id") int id, Model model) {
			Empleado empleado = this.serviceEmpleado.buscarEmpleado(id);
			model.addAttribute("empleado", empleado);
			return "detalleEmpleado";
		}

		@RequestMapping(value = "/empleado/crearEmpleado", method = RequestMethod.POST)
		public String crearEmpleado(@RequestParam(name = "id") int idEmpleado,
				@RequestParam(name = "nombre") String nombre,
				@RequestParam(name = "usuario") String usuario,
				@RequestParam(name = "contrasenia") String contrasenia,
				@RequestParam(name = "rol") String rol) {
			Empleado empleado = new Empleado(idEmpleado, nombre, usuario, passwordEncoder.encode(contrasenia), rol);
			this.serviceEmpleado.crearEmpleado(empleado);
			return "registrarEmpleado";

		}

		@RequestMapping(value = "/empleado/listaEmpleado", method = RequestMethod.GET)
		public String listadoEmpleado(Model model) {
			List<Empleado> empleados = this.serviceEmpleado.obtenerTodosEmpleado();
			model.addAttribute("empleados", empleados);

			return "listadoEmpleado";
		}

		@RequestMapping(value ="/empleado/buscarEmpleado",method=RequestMethod.GET)
		public Empleado buscarEmpleado(@RequestParam(name = "id") int idEmpleado) {
			return this.serviceEmpleado.buscarEmpleado( idEmpleado);
		}
	
	 //====================================================================
	 //                       Proveedor
	 //====================================================================
	
		@GetMapping("/proveedor/registroProveedor")
		public String registrarProveedor() {
			return "registrarProveedor";
		}

		@GetMapping("/proveedor/detalle/{id}")
		public String registrarProveedor(@PathVariable("id") int id, Model model) {
			Proveedor proveedor = this.serviceProveedor.buscarProveedor(id);
			model.addAttribute("proveedor", proveedor);
			return "detalleProveedor";
		}

		@RequestMapping(value = "/proveedor/crearProveedor", method = RequestMethod.POST)
		public String crearProveedor(@RequestParam(name = "id") int idProveedor,
				@RequestParam(name = "nombre") String nombre, @RequestParam(name = "direccion") String direccion,
				@RequestParam(name = "nombreContacto") String nombreContacto,
				@RequestParam(name = "telefono") String telefono,
				@RequestParam(name = "correoElectronico") String correoElectronico) {
			Proveedor proveedor = new Proveedor(idProveedor, nombre, direccion, nombreContacto, telefono,
					correoElectronico);
			this.serviceProveedor.crearProveedor(proveedor);
			return "registrarProveedor";

		}

		@RequestMapping(value = "/proveedor/listaProveedor", method = RequestMethod.GET)
		public String listadoProveedor(Model model) {
			List<Proveedor> proveedores = this.serviceProveedor.obtenerTodosProveedores();
			model.addAttribute("proveedores", proveedores);

			return "listadoProveedor";
		}

		@RequestMapping(value ="/proveedor/buscarProveedor",method=RequestMethod.GET)
		public Proveedor buscarProveedor(@RequestParam(name = "id") int idProveedor) {
			return this.serviceProveedor.buscarProveedor( idProveedor);
		}
		
     	//=======================================================================
		//                        Cliente
		//======================================================================
		@GetMapping("/cliente/registroCliente")
		public String registrarCliente() {
			return "registrarCliente";
		}
		
		@GetMapping("/cliente/detalle/{id}")
		public String registrarCliente(@PathVariable("id") int id, Model model) {
			Cliente cliente = this.serviceCliente.buscarCliente(id);
			model.addAttribute("cliente", cliente);
			return "detalleCliente";
		}

		@RequestMapping(value = "/cliente/crearCliente", method = RequestMethod.POST)
		public String crearCliente(@RequestParam(name = "id") int idCliente,
				@RequestParam(name = "nombre") String nombre, @RequestParam(name = "direccion") String direccion,
				@RequestParam(name = "telefono") String telefono) {

			Cliente Cliente = new Cliente(idCliente, nombre, direccion, telefono);
			this.serviceCliente.crearCliente(Cliente);
			return "registrarCliente";
		}
		
		@RequestMapping(value = "/cliente/listaCliente", method = RequestMethod.GET)
		public String listadoClientes(Model model) {
			List<Cliente> clientes = this.serviceCliente.obtenerTodosClientes();
			model.addAttribute("clientes", clientes);

			return "listadoClientes";
		}
		
		@RequestMapping(value ="/cliente/buscarCliente",method=RequestMethod.GET)
		public Cliente buscarCliente(@RequestParam(name = "id") int idCliente) {
			return this.serviceCliente.buscarCliente( idCliente);
		}
		
		//=======================================================================
		//                          Producto
		//======================================================================
		@GetMapping("/producto/registroProducto")
		public String registrarProducto() {
			return "registrarProducto";
		}

		@GetMapping("/producto/detalle/{id}")
		public String registrarProducto(@PathVariable("id") int id, Model model) {
			Producto producto = this.serviceProducto.buscarProducto(id);
			model.addAttribute("producto", producto);
			return "detalleProducto";
		}
		
		@RequestMapping (value = "/producto/crearProducto",method=RequestMethod.POST)
		public String crearProducto(@RequestParam(name = "id") int idProducto,
				                 @RequestParam(name = "nombre") String nombre,
				                 @RequestParam(name = "descripcion") String descripcion,
				                 @RequestParam(name = "precioCompra") double precioCompra,
				                 @RequestParam(name = "existencia") int existencia,
				                 @RequestParam(name = "precioVenta") double precioVenta) {
			
			Producto producto = new Producto(idProducto, nombre, descripcion, precioCompra, existencia, precioVenta);
			this.serviceProducto.crearProducto(producto);
			return "registrarProducto";
			
		}
		
		@RequestMapping(value ="/producto/listaProducto",method=RequestMethod.GET)
		public String listadoProducto(Model model) {
			List<Producto> productos = this.serviceProducto.obtenerTodosProductos();
			model.addAttribute("productos", productos);
			
			return "listadoProductos";
		}
		
		@RequestMapping(value ="/producto/buscarProducto",method=RequestMethod.GET)
		public Producto buscarProducto(@RequestParam(name = "id") int idProducto) {
			return this.serviceProducto.buscarProducto( idProducto);
		}
		
		//=======================================================================
		//                       Factura
		//======================================================================
		@GetMapping("/factura/registroFactura")
		public String registrarFactura() {
			return "registrarFactura";
		}
		
		@GetMapping("/factura/Factura")
		public String registrarFact() {
			return "factura";
		}
		
		@GetMapping("/factura/detalleFactura")
		public String registrarDetalleFactura() {
			return "detalleFactura";
		}
	
		
		@GetMapping("/factura/detalle/{id}")
		public String detalleFactura(@PathVariable("id") int id, Model model) {
			Factura fac = this.serviceFactura.buscarFactura(id);
			List<DetalleFactura> det = this.serviceDetalleFactura.obtenerTodosDetalleFactura();
			List<DetalleFactura> det2 = new ArrayList<DetalleFactura>();
			for(DetalleFactura d : det) {
				if(id==d.getIdFactura() ) {
					det2.add(d);
					model.addAttribute("detalleFactura", det2);
				}
			}
			
			return "listadoDetalleFactura";
		}
		 
		@RequestMapping (value ="/factura/crearFactura",method=RequestMethod.POST)
		public String crearFactura(@RequestParam(name = "id") int idFactura,
				                 @RequestParam(name = "fecha") @DateTimeFormat(iso = ISO.DATE) LocalDate fecha,
				                 @RequestParam(name = "total") double total,
				                 @RequestParam(name = "idCliente") int idCliente) {
			
			Cliente cliente=this.serviceCliente.buscarCliente(idCliente);
			
			Factura factura = new Factura(idFactura, fecha, total, cliente);
			this.serviceFactura.crearFactura(factura);
			return "registrarFactura";
			
		}
		
		@RequestMapping(value ="/factura/listaFactura",method=RequestMethod.GET)
		public String listadoFactura(Model model) {
			List<Factura> factura = this.serviceFactura.obtenerTodosFacturas();
			model.addAttribute("facturas", factura);
			
			return "listadoFacturas";
		}
		
		@RequestMapping(value ="/factura/listaDetalleFactura",method=RequestMethod.GET)
		public String listadoDetalleFactura(Model model) {
			List<DetalleFactura> detalleFactura = this.serviceDetalleFactura.obtenerTodosDetalleFactura();
			model.addAttribute("detalleFactura", detalleFactura);
			
			return "listadoDetalleFactura";
		}
		
		@RequestMapping(value ="/factura/buscarFactura",method=RequestMethod.GET)
		public Factura buscarFactura(@RequestParam(name = "id") int idFactura) {
			return this.serviceFactura.buscarFactura( idFactura);
		}
		
		
	    @RequestMapping (value = "/factura/crearDetalleFactura",method=RequestMethod.POST)
	   public String crearDetalleFactura(@RequestParam(name = "idProducto") int idProducto,
					      @RequestParam(name = "idFactura") int idFactura,
					      @RequestParam(name = "precio") double precio,
					      @RequestParam(name = "cantidad") int cantidad){
				
		Factura factura = this.serviceFactura.buscarFactura(idFactura);
		Producto producto = this.serviceProducto.buscarProducto(idProducto);
		
		precio = producto.getPrecioVenta();	
	    List<DetalleFactura> det = new ArrayList<DetalleFactura>();
		DetalleFactura detalle = new DetalleFactura(idProducto, idFactura, precio, cantidad, producto, factura);
		Producto prod = this.serviceProducto.buscarProducto(detalle.getIdProducto());
		det.add(detalle);
	
		int c= prod.getExistencia()-detalle.getCantidad();
		 prod.setExistencia(c);
   		if(prod.getExistencia()< 4) {
   			 throw new IllegalArgumentException ("La existencia del producto es de "+( prod.getExistencia()+detalle.getCantidad())+ " se necesita hacer nuevo pedido de producto al proveedor");
   		}
   		this.serviceProducto.crearProducto(prod);
          this.serviceDetalleFactura.crearDetalleFactura(detalle);
   		return "registrarFactura";
			}
		
		//=======================================================================
		//                        Provee
		//======================================================================
	   
	    @GetMapping("/provee/registroProvee")
		public String registrarProvee() {
			return "registrarProvee";
		}
		
		@RequestMapping (value = "/provee/crearProvee",method=RequestMethod.POST)
		public String crearProvee(@RequestParam(name = "idProducto") int idProducto,
				                      @RequestParam(name = "idProveedor") int idProveedor) {
			
			Producto producto = this.serviceProducto.buscarProducto(idProducto);
			Proveedor proveedor = this.serviceProveedor.buscarProveedor(idProveedor);

			Provee tmpProvee = new Provee(idProducto, idProveedor, producto, proveedor);
			this.serviceProvee.crearProvee(tmpProvee);
			return "registrarProvee";
		}

		@RequestMapping(value = "/provee/buscarProvee",method=RequestMethod.GET)
		public Provee buscarProvee(@RequestParam(name = "idProducto") int idProducto,
						                @RequestParam(name = "idProveedor") int idProveedor){
			IdProvee idProvee = new IdProvee(idProducto, idProveedor);
			return this.serviceProvee.buscarProvee(idProvee);
		}
		
		@RequestMapping(value ="/provee/listaProvee",method=RequestMethod.GET)
		public String listadoProvee(Model model) {
			List<Provee> provees = this.serviceProvee.obtenerTodosProvee();
			model.addAttribute("provees", provees);
			
			return "listadoProvee";
		}
		
		

		
		
		
	 

}
