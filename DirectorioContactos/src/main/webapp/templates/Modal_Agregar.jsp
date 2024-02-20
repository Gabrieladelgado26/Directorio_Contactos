

<%@include file= "header.jsp" %>
<body>

    <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="staticBackdropLabel">Informacion de Contacto</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>

                <form  method="Post" action="SvAgregar">
                    <div class="modal-body">
                        <div class="col-md-12">
                            <label for="validationServer01" class="form-label">Nombres</label>
                            <input type="text" class="form-control" required>
                        </div>
                        <div class="col-md-12">
                            <label for="validationServer01" class="form-label">Apellidos</label>
                            <input type="text" class="form-control" required>
                        </div>
                        <div class="col-md-12">
                            <label for="validationServer01" class="form-label">Direccion</label>
                            <input type="text" class="form-control" required>
                        </div>
                        <div class="col-md-12">
                            <label for="validationServer01" class="form-label">Telefono</label>
                            <input type="text" class="form-control" required>
                        </div>
                        <div class="col-md-12">
                            <label for="validationServer01" class="form-label">Correo</label>
                            <input type="email" class="form-control" required>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Guardar</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
