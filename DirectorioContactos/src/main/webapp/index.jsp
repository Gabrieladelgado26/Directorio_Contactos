
<%@page import="Clases.Persistencia"%>
<%@page import="java.util.Collection"%>
<%@page import="Clases.Contacto"%>
<%@page import="Logica.Directorio"%>
<!-- Inclución de la plantilla de header -->
<%@include file= "templates/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">
        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.jsp">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-phone"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Directorio</div>
            </a>
            <!-- División -->
            <hr class="sidebar-divider my-0">
                <!-- Divider -->
                <hr class="sidebar-divider">
                    <!-- Nav Item - Tables -->
                    <li class="nav-item active">
                        <a class="nav-link" href="index.jsp">
                            <i class="fas fa-fw fa-table"></i>
                            <span>Directorio de Contactos</span></a>
                    </li>
                    <!-- Divider -->
                    <hr class="sidebar-divider">
                        <li class="nav-item active">
                            <a class="nav-link" href="" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-lines-fill" viewBox="0 0 16 16">
                                    <path d="M6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6m-5 6s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1zM11 3.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4a.5.5 0 0 1-.5-.5m.5 2.5a.5.5 0 0 0 0 1h4a.5.5 0 0 0 0-1zm2 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1zm0 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1z"/>
                                </svg>
                                <span>Agregar Contacto</span></a>
                        </li>
                        <!-- División -->
                        <hr class="sidebar-divider d-none d-md-block">
                            <!-- Sidebar Toggler (Sidebar) -->
                            <div class="text-center d-none d-md-inline">
                                <button class="rounded-circle border-0" id="sidebarToggle"></button>
                            </div>
                            </ul>
                            <!-- End of Sidebar -->

                            <!-- Contenido Wrapper -->
                            <div id="content-wrapper" class="d-flex flex-column">
                                <!-- Main Content -->
                                <div id="content">
                                    <!-- Topbar -->
                                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                                        <!-- Sidebar Toggle (Topbar) -->
                                        <form class="form-inline">
                                            <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                                                <i class="fa fa-bars"></i>
                                            </button>
                                        </form>



                                        <!-- Topbar Navbar -->
                                        <ul class="navbar-nav ml-auto">

                                            <!-- Nav Item - Alertas -->
                                            <li class="nav-item dropdown no-arrow mx-1">
                                                <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button"
                                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                    <i class="fas fa-bell fa-fw"></i>
                                                    <!-- Counter - Alerts -->
                                                    <span class="badge badge-danger badge-counter">0</span>
                                                </a>
                                                <!-- Dropdown - Alerts -->
                                                <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                                     aria-labelledby="alertsDropdown">
                                                    <h6 class="dropdown-header">
                                                        Notificaciones
                                                    </h6>
                                                    <a class="dropdown-item d-flex align-items-center" href="#">
                                                        <div class="mr-3">
                                                            <div class="icon-circle bg-primary">
                                                                <i class="fas fa-file-alt text-white"></i>
                                                            </div>
                                                        </div>
                                                        <div>
                                                            <div class="small text-gray-500">Notificaciones</div>
                                                            <span class="font-weight-bold">No hay notificaciones en el momento</span>
                                                        </div>
                                                    </a>
                                                    <a class="dropdown-item text-center small text-gray-500" href="#">Cerrar ventana</a>
                                                </div>
                                            </li>

                                            <!-- Nav Item - Mensajes -->
                                            <li class="nav-item dropdown no-arrow mx-1">
                                                <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button"
                                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                    <i class="fas fa-envelope fa-fw"></i>
                                                    <!-- Counter - Messages -->
                                                    <span class="badge badge-danger badge-counter">0</span>
                                                </a>
                                                <!-- Dropdown - Messages -->
                                                <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                                     aria-labelledby="messagesDropdown">
                                                    <h6 class="dropdown-header">
                                                        Mensajes
                                                    </h6>
                                                    <a class="dropdown-item d-flex align-items-center" href="#">
                                                        <div class="dropdown-list-image mr-3">
                                                            <img class="rounded-circle" src="img/undraw_profile_1.svg"
                                                                 alt="...">
                                                                <div class="status-indicator bg-success"></div>
                                                        </div>
                                                        <div class="font-weight-bold">
                                                            <div class="text-truncate">No hay mensajes en el momento</div>
                                                            <div class="small text-gray-500">Sin mensajes</div>
                                                        </div>
                                                    </a>
                                                    <a class="dropdown-item text-center small text-gray-500" href="#">Cerrar ventana</a>
                                                </div>
                                            </li>

                                            <div class="topbar-divider d-none d-sm-block"></div>

                                            <!-- Nav Item - User Information -->
                                            <li class="nav-item dropdown no-arrow">
                                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">Usuario sin nombre</span>
                                                    <img class="img-profile rounded-circle"
                                                         src="img/undraw_profile.svg">
                                                </a>
                                                <!-- Dropdown - User Information -->
                                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                                     aria-labelledby="userDropdown">
                                                    <div class="dropdown-divider"></div>
                                                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModa">
                                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                                        Cerrar ventana
                                                    </a>
                                                </div>
                                            </li>

                                        </ul>

                                    </nav>
                                    <!-- Fin de Topbar -->

                                    <!-- Begin Page Content -->
                                    <div class="container-fluid">

                                        <!-- Page Heading -->
                                        <h2 class="h3 mb-2 text-gray-800">DIRECTORIO DE CONTACTOS</h2>
                                        <p class="mb-4">Encuentra todos tus contactos registrados en este directorio de contactos, agrega, visualiza, busca y elimina los contactos que desees.</p>

                                        <!-------fin de boton agregar contacto---------->
                                        <!-- DataTales -->
                                        <div class="card shadow mb-4">
                                            <div class="card-header py-3">
                                                <div class="row">
                                                    <div class="col-8">
                                                        <h6 class="m-0 font-weight-bold text-primary">Directorio de contactos</h6>
                                                    </div>
                                                    <div class="col-4">
                                                        <% if (request.getSession().getAttribute("ContactoAgregado") != null && (boolean) request.getSession().getAttribute("ContactoAgregado") == true) { %>



                                                        <div class="alert alert-success d-flex align-items-center" role="alert" id="Agregado" style="height: 30px">
                                                            <svg class="bi flex-shrink-0 me-2" role="img" aria-label="Éxito:" _mstaria-label="106548" _mstHash="248" style="width: 30px"><use xlink:href="#check-circle-fill"></use></svg>
                                                            <div _msttexthash="1158755" _msthash="249" style="text-align: center">Se ha agregado un contacto </div>
                                                        </div>

                                                        <script>
                                                            // Ocultar la alerta después de 5 segundos (5000 milisegundos)
                                                            setTimeout(function () {
                                                                $('#Agregado').alert('close');
                                                            }, 5000);
                                                        </script>
                                                        <% request.getSession().removeAttribute("ContactoAgregado"); %>
                                                        <% }%>
                                                    </div>

                                                </div>
                                            </div>
                                            <div class="card-body">
                                                <div class="table-responsive">
                                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                                        <thead>
                                                            <tr>
                                                                <th>Id</th>
                                                                <th>Nombres</th>
                                                                <th>Apellidos</th>
                                                                <th>Dirección</th>
                                                                <th>Telefono</th>
                                                                <th>Correo</th>
                                                                <th>Acciones</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <%  ServletContext context = getServletContext();
                                                                Persistencia persistencia = new Persistencia();

                                                                Collection<Contacto> lista = persistencia.leerListaContactos(context);

                                                                Collection<Contacto> listaContactos = lista;

                                                                if (listaContactos == null) {
                                                            %>
                                                            <tr>
                                                                <td>
                                                                    No hay contactos
                                                                </td>

                                                            </tr>
                                                            <% } else {
                                                                for (Contacto contacto : listaContactos) {
                                                            %>
                                                            <!-- Aqui van los contactos que se debe agregar -->
                                                            <tr>
                                                                <td><%= contacto.getId()%></td>
                                                                <td><%= contacto.getNombre()%></td>
                                                                <td><%= contacto.getApellido()%></td>
                                                                <td><%= contacto.getDireccion()%></td>
                                                                <td><%= contacto.getTelefono()%></td>
                                                                <td><%= contacto.getEmail()%></td>
                                                                <td>
                                                                    <a href="#"  class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModalDetalles<%= contacto.getId()%>"><i class="fa fa-eye"></i></a>  
                                                                    <a href="#" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#editModalConfirm<%= contacto.getId()%>"><i class="fa fa-marker"></i></a>
                                                                    <a href="#" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteModalConfirm<%= contacto.getId()%>"><i class="fa fa-trash-alt"></i></a>
                                                                </td>
                                                            </tr>

                                                            <!--------------------------------  Modal para agregar un contacto  ------------------------------------------------->
                                                            <%@include file= "templates/Modal_Agregar.jsp" %>

                                                            <!--------------------------------  Modal para ver informacion de conctacto ------------------------------------------------->

                                                            <div class="modal fade" id="exampleModalDetalles<%= contacto.getId()%>" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                                <div class="modal-dialog modal-dialog-centered">
                                                                    <div class="modal-content">
                                                                        <div class="modal-header">
                                                                            <h3 class="modal-title" id="exampleModalLabel">Detalles del contacto</h3>
                                                                        </div>
                                                                        <div class="modal-body">
                                                                            <div class="row justify-content-center">
                                                                                <div class="col text-center">
                                                                                    <div class="card shadow">
                                                                                        <div class="card-body">
                                                                                            <h4 class="card-title fw-bold">Nombre</h4>
                                                                                            <p class="card-text"><%= contacto.getNombre() + " " + contacto.getApellido()%></p>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="col text-center">
                                                                                    <div class="card shadow">
                                                                                        <div class="card-body">
                                                                                            <h4 class="card-title fw-bold">Teléfono celular</h4>
                                                                                            <p class="card-text"><%= contacto.getTelefono()%></p>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="modal-footer">
                                                                            <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cerrar</button>
                                                                            <button class="btn btn-primary" data-bs-target="#exampleModalToggle2" data-bs-toggle="modal">Más</button>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="modal fade" id="exampleModalToggle2" aria-hidden="true" aria-labelledby="exampleModalToggleLabel2" data-bs-backdrop="static" tabindex="-1">
                                                                <div class="modal-dialog modal-dialog-centered">
                                                                    <div class="modal-content">
                                                                        <div class="modal-header">
                                                                            <h3 class="modal-title fs-5" id="exampleModalToggleLabel2">Información del contacto</h3>
                                                                        </div>
                                                                        <div class="modal-body">
                                                                            <div class="row row-cols-1 row-cols-md-2 g-4 justify-content-center">
                                                                                <div class="col text-center">
                                                                                    <div class="card shadow">
                                                                                        <div class="card-body">
                                                                                            <h4 class="card-title fw-bold">ID:</h4>
                                                                                            <p class="card-text"><%= contacto.getId()%></p>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="col text-center">
                                                                                    <div class="card shadow">
                                                                                        <div class="card-body">
                                                                                            <h4 class="card-title fw-bold">Nombre:</h4>
                                                                                            <p class="card-text"><%= contacto.getNombre()%></p>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="col text-center">
                                                                                    <div class="card shadow">
                                                                                        <div class="card-body">
                                                                                            <h4 class="card-title fw-bold">Apellido:</h4>
                                                                                            <p class="card-text"><%= contacto.getApellido()%></p>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="col text-center">
                                                                                    <div class="card shadow">
                                                                                        <div class="card-body">
                                                                                            <h4 class="card-title fw-bold">Dirección:</h4>
                                                                                            <p class="card-text"><%= contacto.getDireccion()%></p>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="col text-center">
                                                                                    <div class="card shadow">
                                                                                        <div class="card-body">
                                                                                            <h4 class="card-title fw-bold">Teléfono:</h4>
                                                                                            <p class="card-text"><%= contacto.getTelefono()%></p>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="col text-center">
                                                                                    <div class="card shadow">
                                                                                        <div class="card-body">
                                                                                            <h4 class="card-title fw-bold">Email:</h4>
                                                                                            <p class="card-text"><%= contacto.getEmail()%></p>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="modal-footer">
                                                                            <button class="btn btn-primary" data-bs-target="#exampleModalDetalles<%= contacto.getId()%>" data-bs-toggle="modal" data-bs-dismiss="modal">Menos información</button>
                                                                            <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cerrar</button>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>

                                                            <!--------------------------------------------- fin de modal ------------------------------------------------------------->




                                                            <!------------- Modal para editar informacion del conctacto  ------------->
                                                            <div class="modal fade" id="editModalConfirm<%= contacto.getId()%>" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                                                                <div class="modal-dialog">
                                                                    <div class="modal-content">
                                                                        <div class="modal-header">
                                                                            <h1 class="modal-title fs-5" id="staticBackdropLabel">Informacion de Contacto</h1>
                                                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                        </div>

                                                                        <form method="post" action="SvEditar">
                                                                            <div class="modal-body">

                                                                                <div class="col-md-12">
                                                                                    <label for="nombres" class="form-label">Nombres</label>
                                                                                    <input type="text" class="form-control" name="nombres" value="<%=contacto.getNombre()%>"  required>
                                                                                </div>
                                                                                <div class="col-md-12">
                                                                                    <label for="apellidos" class="form-label">Apellidos</label>
                                                                                    <input type="text" class="form-control" name="apellidos" value="<%=contacto.getApellido()%>" required>
                                                                                </div>
                                                                                <div class="col-md-12">
                                                                                    <label for="direccion" class="form-label">Dirección</label>
                                                                                    <input type="text" class="form-control" name="direccion" value="<%=contacto.getDireccion()%>" required>
                                                                                </div>
                                                                                <div class="col-md-12">
                                                                                    <label for="telefono" class="form-label">Teléfono</label>
                                                                                    <input type="text" class="form-control" name="telefono" value="<%=contacto.getTelefono()%>" required>
                                                                                </div>
                                                                                <div class="col-md-12">
                                                                                    <label for="correo" class="form-label">Correo</label>
                                                                                    <input type="email" class="form-control" name="correo" value="<%=contacto.getEmail()%>" required>
                                                                                </div>
                                                                            </div>
                                                                            <div class="modal-footer">
                                                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                                                <button type="submit" class="btn btn-primary">Guardar</button>
                                                                            </div>
                                                                        </form>

                                                                    </div>
                                                                </div>
                                                            </div>

                                                            <!--------------------------------------------- fin de modal ------------------------------------------------------------->


                                                            <!----------------------------------------- Modal para eliminar contacto ------------------------------------------------->

                                                            <div class="modal fade" id="deleteModalConfirm<%= contacto.getId()%>" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                                                                <div class="modal-dialog modal-dialog-centered">
                                                                    <div class="modal-content">
                                                                        <div class="modal-header">
                                                                            <h3 class="modal-title fs-5 text-center" id="staticBackdropLabel">Eliminar Contacto</h3>
                                                                        </div>

                                                                        <form method="post" action="SvEliminar">
                                                                            <div class="modal-body">
                                                                                <div class="col-md-12">
                                                                                    <h5 for="nombres" class="form-label">¿Estas seguro de eliminar a <%=contacto.getNombre()%> <%=contacto.getApellido()%>?</h5>
                                                                                </div>
                                                                            </div>
                                                                            <div class="modal-footer">
                                                                                <button type="button" class="btn btn-primary" data-bs-dismiss="modal">No</button>
                                                                                <a href="SvEliminar?nombre=<%= contacto.getNombre()%>" class="btn btn-danger"  >Si</a>
                                                                            </div>
                                                                        </form>

                                                                    </div>
                                                                </div>
                                                            </div>

                                                            <!----------------------------------------- Fin del modal para eliminar contacto ------------------------------------------>
                                                            <!------------------------------------------ modal de contacto repetido  --------------------------------------------------->
                                                            <c:if test="${requestScope.showModal}">
                                                                <div
                                                                    class="modal fade "
                                                                    id="exampleModal"
                                                                    tabindex="-1"
                                                                    aria-labelledby="exampleModalLabel"
                                                                    aria-hidden="true"

                                                                    >
                                                                    <div class="modal-dialog modal-dialog-centered"  >
                                                                        <div class="modal-content">

                                                                            <div class="modal-body"  >
                                                                                <div class="row position-center">

                                                                                    <div class="col">

                                                                                        <h4><%=request.getAttribute("nombre")%> ya esta agregad@</h4>
                                                                                    </div>
                                                                                    <div class="col-2">
                                                                                        <button
                                                                                            type="button"
                                                                                            class="btn"
                                                                                            data-bs-dismiss="modal"
                                                                                            aria-label="Close"
                                                                                            ><i class="bi bi-x-lg"></i></button>
                                                                                    </div>

                                                                                </div>


                                                                            </div>

                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </c:if>
                                                            <%
                                                                    }
                                                                }
                                                            %>
                                                            


                                                    </table>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                    <!-- /.container-fluid -->

                                </div>
                                <!-- Fin de Main Content -->

                                <% if (request.getSession().getAttribute("ContactoAgregado") != null && (boolean) request.getSession().getAttribute("ContactoAgregado") == true) { %>
                                <div class="toast fade show p-3" role="alert" aria-live="assertive"id="Agregado" style="text-align: center; size: 28px">
                                    <div class="toast-body">
                                        <label>Se agrego un nuevo contacto</label>
                                    </div>
                                </div>

                                <script>
                                    // Ocultar la alerta después de 5 segundos (5000 milisegundos)
                                    setTimeout(function () {
                                        $('#Agregado').alert('close');
                                    }, 4000);
                                </script>
                                <% request.getSession().removeAttribute("alertaAgregar"); %>
                                <% }%>

                                <!-- Footer -->
                                <footer class="sticky-footer bg-white">
                                    <div class="container my-auto">
                                        <div class="copyright text-center my-auto">
                                            <span>Copyright &copy; Your Website 2020</span>
                                        </div>
                                    </div>
                                </footer>
                                <!-- Fin de Footer -->

                            </div>
                            <!-- Fin de Content Wrapper -->

                            </div>
                            <!-- Fin de Page Wrapper -->

                            <!-- Scroll to Top Button-->
                            <a class="scroll-to-top rounded" href="#page-top">
                                <i class="fas fa-angle-up"></i>
                            </a>

                            <!-- Bootstrap core JavaScript-->
                            <script src="vendor/jquery/jquery.min.js"></script>
                            <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

                            <!-- Core plugin JavaScript-->
                            <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

                            <!-- Custom scripts for all pages-->
                            <script src="js/sb-admin-2.min.js"></script>

                            <!-- Page level plugins -->
                            <script src="vendor/datatables/jquery.dataTables.min.js"></script>
                            <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

                            <!-- Page level custom scripts -->
                            <script src="js/demo/datatables-demo.js"></script>

                            <script>
                                    function contactoRepetido() {

                                        toastr.options = {
                                            "closeButton": false,
                                            "debug": false,
                                            "newestOnTop": false,
                                            "progressBar": false,
                                            "positionClass": "toast-top-center",
                                            "preventDuplicates": false,
                                            "onclick": null,
                                            "showDuration": "300",
                                            "hideDuration": "1000",
                                            "timeOut": "5000",
                                            "extendedTimeOut": "1000",
                                            "showEasing": "swing",
                                            "hideEasing": "linear",
                                            "showMethod": "fadeIn",
                                            "hideMethod": "fadeOut"
                                        };

                                        // Mostrar una notificación Toastr de error
                                        toastr.error('El nombre que intenta ingresar ya se encuentra en el directorio', 'Error');
                                    }
                            </script>

                            <!-- Inclución de la plantilla de footer -->
                            <%@include file= "templates/footer.jsp" %>