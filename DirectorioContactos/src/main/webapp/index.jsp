<%@page import="Clases.Persistencia"%>
<%@page import="java.util.Collection"%>
<%@page import="Clases.Contacto"%>
<%@page import="Logica.Directorio"%>
<!-- Inclución de la plantilla de footer -->
<%@include file= "templates/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">
        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
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
                        <a class="nav-link" href="index.html">
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

                                        <!-- Topbar Busqueda -->
                                        <form
                                            class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                                            <div class="input-group">
                                                <input type="text" class="form-control bg-light border-0 small" placeholder="Buscar contacto..."
                                                       aria-label="Search" aria-describedby="basic-addon2">
                                                    <div class="input-group-append">
                                                        <button class="btn btn-primary" type="button">
                                                            <i class="fas fa-search fa-sm"></i>
                                                        </button>
                                                    </div>
                                            </div>
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
                                        <h1 class="h3 mb-2 text-gray-800">DIRECTORIO DE CONTACTOS</h1>
                                        <p class="mb-4">Encuentra todos tus contactos registrados en este directorio de contactos, agrega, visualiza, edita y elimina los contactos que desees.</p>


                                        <%@include file= "templates/Modal_Agregar.jsp" %>

                                        <!-------fin de boton agregar contacto---------->
                                        <!-- DataTales -->
                                        <div class="card shadow mb-4">
                                            <div class="card-header py-3">
                                                <h6 class="m-0 font-weight-bold text-primary">Directorio de contactos</h6>
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
                                                            <%
                                                                ServletContext context = getServletContext();
                                                                Persistencia persistencia = new Persistencia();
                                                                Directorio directorio = new Directorio();
                                                                        
                                                                        
                                                                persistencia.leerArchivoYAgregarContactos(context, directorio);
                                                                
                                                                
                                                                Collection<Contacto> listaContactos = (Collection<Contacto>) directorio.darListaContactos();
                                                                if (listaContactos == null) {
                                                                
                                                            %>
                                                            <tr>

                                                            </tr>


                                                            <%                                       } else {

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
                                                                    <a href="#" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#editModalConfirm<%= contacto.getNombre()%>"><i class="fa fa-marker"></i></a>         
                                                                    <a href="#" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteModalConfirm<%= contacto.getId()%>"><i class="fa fa-trash-alt"></i></a>


                                                                </td>
                                                            </tr>


                                                            <!------------  Modal para ver informacion de conctacto ------------>

                                                            <div class="modal fade" id="exampleModalDetalles<%= contacto.getId()%>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                                <div class="modal-dialog">
                                                                    <div class="modal-content">
                                                                        <div class="modal-header">
                                                                            <h1 class="modal-title fs-5" id="exampleModalLabel">Informacion de conctacto</h1>
                                                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                        </div>
                                                                        <div class="modal-body">

                                                                            <%= contacto.getId()%>
                                                                            <%= contacto.getNombre()%>
                                                                            <%= contacto.getApellido()%>
                                                                            <%= contacto.getDireccion()%>
                                                                            <%= contacto.getTelefono()%>
                                                                            <%= contacto.getEmail()%>
                                                                        </div>
                                                                        <div class="modal-footer">
                                                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>

                                                            <!-- fin de modal -->


                                                            <!------------- Modal para editar informacion del conctacto  ------------->
                                                            <div class="modal fade" id="editModalConfirm<%= contacto.getNombre()%>" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
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


                                                            <!----------------- Fin de modal para editar informacion --------------->


                                                            <!------------------- Modal para elimianr contacto --------------------->

                                                            <div class="modal fade" id="deleteModalConfirm<%= contacto.getId()%>" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                                                                <div class="modal-dialog">
                                                                    <div class="modal-content">
                                                                        <div class="modal-header">
                                                                            <h1 class="modal-title fs-5" id="staticBackdropLabel">Eliminar Contacto</h1>
                                                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                        </div>

                                                                        <form method="post" action="SvEliminar">
                                                                            <div class="modal-body">

                                                                                <div class="col-md-12">
                                                                                    <label for="nombres" class="form-label">¿Estas seguro de eliminar a <%=contacto.getNombre()%> <%=contacto.getApellido()%> ?</label>

                                                                                </div>

                                                                            </div>
                                                                            <div class="modal-footer">
                                                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
                                                                                
                                                                                <a href="SvEliminar?nombre=<%= contacto.getNombre()%>" class="btn btn-primary"  >Si</a>
                                                                            </div>
                                                                        </form>

                                                                    </div>
                                                                </div>
                                                            </div>

                                                            <!------------------- Fin del modal para eliminar contacto ----------------->

                                                            <%
                                                                    }
                                                                }
                                                            %>
                                                        </tbody>


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

                            <!-- Inclución de la plantilla de footer -->
                            <%@include file= "templates/footer.jsp" %>